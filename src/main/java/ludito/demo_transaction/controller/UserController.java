package ludito.demo_transaction.controller;


import ludito.demo_transaction.dto.user.UserInfoDTO;
import ludito.demo_transaction.dto.user.UserUpdateDTO;
import ludito.demo_transaction.model.User;
import ludito.demo_transaction.service.user.IUserService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("${api.path}/users")
public class UserController {
  private final IUserService service;

  public UserController(
    IUserService userService
  ) {
    this.service = userService;
  }

  @PutMapping("/me")
  public UserInfoDTO updateMe(@RequestBody UserUpdateDTO dto, Principal principal) {
    var user = service.update(dto, principal);
    return new UserInfoDTO().toDTO(user);
  }


  @GetMapping("/{id}")
  public UserInfoDTO getById(@PathVariable Long id) {
    var user = service.getById(id);
    return new UserInfoDTO().toDTO(user);
  }

  @GetMapping("/all")
  public List<UserInfoDTO> getAll() {
    var users = service.getAll();
    return users.stream()
      .map(user -> new UserInfoDTO().toDTO(user))
      .toList();
  }

  @GetMapping("/email/{email}")
  public UserInfoDTO getUserByEmail(@PathVariable String email) {
    var user = service.getUserByEmail(email);
    return new UserInfoDTO().toDTO(user);
  }

  @GetMapping("/me")
  public UserInfoDTO getUserInfo(Principal principal) {
    User user = service.getUserByPrincipal(principal);
    return new UserInfoDTO().toDTO(user);
  }

  @DeleteMapping("/me")
  public Boolean deleteMe(Principal principal) {
    return service.delete(principal);
  }

}
