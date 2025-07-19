package ludito.demo_transaction.service.user;

import ludito.demo_transaction.dto.user.UserUpdateDTO;
import ludito.demo_transaction.exception.Exceptions;
import ludito.demo_transaction.model.User;
import ludito.demo_transaction.repository.TransactionRepo;
import ludito.demo_transaction.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

import static ludito.demo_transaction.exception.Logging.LoggedError;

@Service
public class UserService implements IUserService {
  private final UserRepo mainRepo;
  private final TransactionRepo transactionRepo;

  public UserService(
    UserRepo userRepo,
    TransactionRepo transactionRepo
  ) {
    this.mainRepo = userRepo;
    this.transactionRepo = transactionRepo;
  }

  @Override
  public User update(UserUpdateDTO dto, Principal principal) {
    var currentUser = getUserByPrincipal(principal);
    var existingByEmail = mainRepo.findByEmail(currentUser.getEmail());
    if (existingByEmail.isPresent() && !existingByEmail.get().getId().equals(currentUser.getId())) {
      throw LoggedError(new Exceptions.CustomBadRequestException("User with email " + currentUser.getEmail() + " already exists"));
    }

    if (dto.getPassword() != null) {
      currentUser.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
    }
    if (dto.getEmail() != null) {
      currentUser.setEmail(dto.getEmail().toLowerCase());
    }
    if (dto.getLastname() != null) {
      currentUser.setLastname(dto.getLastname().trim());
    }
    if (dto.getFirstname() != null) {
      currentUser.setFirstname(dto.getFirstname().trim());
    }

    return mainRepo.save(currentUser);
  }

  @Override
  public User getById(Long id) {
    return mainRepo.findById(id).orElseThrow(
      () -> LoggedError(new Exceptions.CustomEntryNotFoundException("User with ID #" + id + " not found"))
    );
  }

  @Override
  public List<User> getAll() {
    return mainRepo.findAll();
  }

  @Override
  public User getUserByEmail(String email) {
    var user = mainRepo.findByEmail(email);
    if (user.isPresent()) {
      return user.get();
    } else {
      throw LoggedError(new Exceptions.CustomEntryNotFoundException("User with email " + email + " not found"));
    }
  }

  @Override
  public User getUserByPrincipal(Principal principal) {
    try {
      var userId = Long.parseLong(principal.getName());
      return getById(userId);
    } catch (NumberFormatException e) {
      throw LoggedError(new Exceptions.CustomBadRequestException("Subject in token should be long"));
    }
  }

  @Override
  public Boolean delete(Principal principal) {
    var user = getUserByPrincipal(principal);
    var transactions = transactionRepo.findAllByUserId(user.getId());

    if (!transactions.isEmpty()) {
      throw LoggedError(new Exceptions.CustomBadRequestException("User with ID #" + user.getId() + " has transactions and cannot be deleted"));
    }

    mainRepo.save(user);
    return true;
  }
}
