package ludito.demo_transaction.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ludito.demo_transaction.enums.enums;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCreateDTO {
  private String description;
  @NotNull
  private Double amount;
  @NotNull
  private enums.CurrencyType currency;
  @NotNull
  private String item;
}
