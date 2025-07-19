package ludito.demo_transaction.service.transaction;

import ludito.demo_transaction.dto.transaction.TransactionCreateDTO;
import ludito.demo_transaction.dto.transaction.TransactionFilterDTO;
import ludito.demo_transaction.enums.enums;
import ludito.demo_transaction.exception.Exceptions;
import ludito.demo_transaction.model.Transaction;
import ludito.demo_transaction.repository.TransactionRepo;
import ludito.demo_transaction.service.user.IUserService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

import static ludito.demo_transaction.exception.Logging.LoggedError;

@Service
public class TransactionService implements ITransactionService {
  private final TransactionRepo mainRepo;
  private final IUserService userService;

  public TransactionService(
    TransactionRepo transactionRepo,
    IUserService userService
  ) {
    this.mainRepo = transactionRepo;
    this.userService = userService;
  }

  @Override
  public Transaction create(TransactionCreateDTO dto, Principal principal) {
    var user = userService.getUserByPrincipal(principal);
    var transaction = new Transaction();
    transaction.setUser(user);
    transaction.setAmount(dto.getAmount());
    transaction.setDescription(dto.getDescription());
    transaction.setCurrency(dto.getCurrency());
    transaction.setStatus(enums.TransactionStatus.PENDING);

    return mainRepo.save(transaction);
  }

  @Override
  public Transaction checkSuccess(Long id) {
    var transaction = getById(id);
    transaction.setStatus(enums.TransactionStatus.SUCCESS);

    return mainRepo.save(transaction);
  }

  @Override
  public Transaction checkFailure(Long id) {
    var transaction = getById(id);
    transaction.setStatus(enums.TransactionStatus.FAILED);

    return mainRepo.save(transaction);
  }

  @Override
  public Transaction getById(Long id) {
    return mainRepo.findById(id).orElseThrow(
      () -> LoggedError(new Exceptions.CustomEntryNotFoundException("User with ID #" + id + " not found"))
    );
  }

  @Override
  public List<Transaction> getAll(TransactionFilterDTO filters) {
    if (filters.getUserId() != null) {
      return mainRepo.findAllByUserId(filters.getUserId());
    }
    if (filters.getFrom() != null && filters.getTo() != null) {
      return mainRepo.findByCreatedBetween(
        filters.getFrom().atStartOfDay(),
        filters.getTo().plusDays(1).atStartOfDay()
      );
    }

    return mainRepo.findAll();
  }

  @Override
  public List<Transaction> getAllMe(Principal principal) {
    var user = userService.getUserByPrincipal(principal);
    return mainRepo.findAllByUserId(user.getId());
  }

  @Override
  public Boolean delete(Long id, Principal principal) {
    var user = userService.getUserByPrincipal(principal);
    var transaction = mainRepo.findByIdAndUserId(id, user.getId());
    if (transaction.isPresent()) {
      throw LoggedError(new Exceptions.CustomEntryNotFoundException("Transaction with ID #" + id + " not found for user " + user.getEmail()));
    }

    transaction.ifPresent(mainRepo::delete);
    return true;
  }
}

