package ludito.demo_transaction.controller;

import ludito.demo_transaction.dto.auth.AuthResponseDTO;
import ludito.demo_transaction.dto.auth.CreateAccountDTO;
import ludito.demo_transaction.dto.auth.SignInDTO;
import ludito.demo_transaction.service.auth.IAuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.path}/auth")
public class AuthController {
  private final IAuthService service;

  public AuthController(
    IAuthService authService
  ) {
    this.service = authService;
  }

  @PostMapping("/register")
  public AuthResponseDTO register(@RequestBody CreateAccountDTO dto) {
    return service.createAccount(dto);
  }

  @PostMapping("/login")
  public AuthResponseDTO login(@RequestBody SignInDTO dto) {
    return service.signInUserViaEmail(dto);
  }

}
