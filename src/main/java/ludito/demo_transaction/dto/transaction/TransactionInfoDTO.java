package ludito.demo_transaction.dto.transaction;

import lombok.Data;
import ludito.demo_transaction.enums.enums;
import ludito.demo_transaction.model.Transaction;

@Data
public class TransactionInfoDTO {
  private Long user_id;
  private String description;
  private Double amount;
  private enums.CurrencyType currency;
  private String item;
  private enums.TransactionStatus status;

  public TransactionInfoDTO toDTO(Transaction transaction) {
    this.user_id = transaction.getId();
    this.description = transaction.getDescription();
    this.amount = transaction.getAmount();
    this.currency = transaction.getCurrency();
    this.item = transaction.getItem();
    this.status = transaction.getStatus();

    return this;
  }
}