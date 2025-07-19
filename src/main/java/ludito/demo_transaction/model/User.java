package ludito.demo_transaction.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
public class User extends BaseModel {

  @Column(nullable = false)
  private String firstname = "";
  private String lastname = null;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, unique = true)
  private String email = "";

}
