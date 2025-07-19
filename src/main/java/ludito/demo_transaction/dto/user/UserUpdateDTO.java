package ludito.demo_transaction.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {
  private String firstname;
  private String lastname;
  private String email;
  private String password;
}
