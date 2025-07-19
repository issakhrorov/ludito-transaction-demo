package ludito.demo_transaction.service.auth;

import ludito.demo_transaction.dto.auth.AuthResponseDTO;
import ludito.demo_transaction.dto.auth.CreateAccountDTO;
import ludito.demo_transaction.dto.auth.SignInDTO;

public interface IAuthService {
  AuthResponseDTO signInUserViaEmail(SignInDTO dto);
  AuthResponseDTO createAccount(CreateAccountDTO dto);
}
