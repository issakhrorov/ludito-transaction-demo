package ludito.demo_transaction.repository;

import ludito.demo_transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
  List<Transaction> findAllByUserId(Long userId);
  Optional<Transaction> findByIdAndUserId(Long id, Long userId);
  List<Transaction> findByCreatedBetween(LocalDateTime from, LocalDateTime to);
}
