package ludito.demo_transaction.model;

import jakarta.persistence.*;
import lombok.*;
import ludito.demo_transaction.enums.enums;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "transactions")
public class Transaction extends BaseModel {
  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  private String description;
  private Double amount;
  @Enumerated(EnumType.STRING)
  private enums.CurrencyType currency;
  private String item;
  @Enumerated(EnumType.STRING)
  private enums.TransactionStatus status = enums.TransactionStatus.PENDING; // Default status is PENDING
}
