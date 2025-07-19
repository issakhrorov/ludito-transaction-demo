package ludito.demo_transaction.service.transaction;

import ludito.demo_transaction.dto.transaction.TransactionCreateDTO;
import ludito.demo_transaction.dto.transaction.TransactionFilterDTO;
import ludito.demo_transaction.model.Transaction;

import java.security.Principal;
import java.util.List;

public interface ITransactionService {
  Transaction create(TransactionCreateDTO dto, Principal principal);
  Transaction checkSuccess(Long id);
  Transaction checkFailure(Long id);
  Transaction getById(Long id);
  List<Transaction> getAll(TransactionFilterDTO filters);
  List<Transaction> getAllMe(Principal principal);
  Boolean delete(Long id, Principal principal);
}
