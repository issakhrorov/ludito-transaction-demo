package ludito.demo_transaction.populator;

import ludito.demo_transaction.enums.enums;
import ludito.demo_transaction.model.Transaction;
import ludito.demo_transaction.model.User;
import ludito.demo_transaction.repository.TransactionRepo;
import ludito.demo_transaction.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoDataLoader implements CommandLineRunner {

  private final UserRepo userRepo;
  private final TransactionRepo transactionRepo;

  public DemoDataLoader(
    UserRepo userRepo,
    TransactionRepo transactionRepo
  ) {
    this.userRepo = userRepo;
    this.transactionRepo = transactionRepo;
  }

  @Override
  public void run(String... args) {
    if (userRepo.count() > 0) {
      return;
    }

    // Insert users
    User user = new User(
      "John",
      "Doe",
      BCrypt.hashpw("12345", BCrypt.gensalt(4)),
      "john_doe@example.com"
    );
    user = userRepo.saveAndFlush(user);

    // Insert Transactions
    Transaction transaction1 = new Transaction(
      user,
      "Transaction 1",
      100.0,
      enums.CurrencyType.EUR,
      "Subscription",
      null
    );

    Transaction transaction2 = new Transaction(
      user,
      "Transaction 2",
      100.0,
      enums.CurrencyType.EUR,
      "Hotel Booking",
      null
    );

    transactionRepo.saveAll(List.of(transaction1, transaction2));
  }
}