package ludito.demo_transaction.dto.user;

import lombok.Data;
import ludito.demo_transaction.model.User;

@Data
public class UserInfoDTO {
  private Long user_id;
  private String firstname;
  private String lastname;
  private String email;

  public UserInfoDTO toDTO(User user) {
    this.user_id = user.getId();
    this.firstname = user.getFirstname();
    this.lastname = user.getLastname();
    this.email = user.getEmail();

    return this;
  }
}
