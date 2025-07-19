package ludito.demo_transaction.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDTO {
  @NotNull
  private String firstname;
  private String lastname;
  @NotNull
  private String password;
  @NotNull
  private String email;
}
