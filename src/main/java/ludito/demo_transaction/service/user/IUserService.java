package ludito.demo_transaction.service.user;

import ludito.demo_transaction.dto.user.UserUpdateDTO;
import ludito.demo_transaction.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.List;

public interface IUserService {
  User update(UserUpdateDTO dto, Principal principal);

  User getById(Long id);
  List<User> getAll();
  User getUserByEmail(String email);
  User getUserByPrincipal(Principal principal);

  Boolean delete(Principal principal);
}
