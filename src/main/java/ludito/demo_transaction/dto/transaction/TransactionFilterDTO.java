package ludito.demo_transaction.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TransactionFilterDTO {
  private Long userId;
  private LocalDate from; // ISO date format
  private LocalDate to; // ISO date format
}
