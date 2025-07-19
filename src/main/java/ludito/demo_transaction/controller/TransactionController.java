package ludito.demo_transaction.controller;


import ludito.demo_transaction.dto.transaction.TransactionCreateDTO;
import ludito.demo_transaction.dto.transaction.TransactionFilterDTO;
import ludito.demo_transaction.dto.transaction.TransactionInfoDTO;
import ludito.demo_transaction.service.transaction.ITransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("${api.path}/transactions")
public class TransactionController {
  private final ITransactionService service;

  public TransactionController(
    ITransactionService transactionService
  ) {
    this.service = transactionService;
  }

  @PostMapping("/")
  public TransactionInfoDTO create(
    @RequestBody TransactionCreateDTO dto,
    Principal principal
  ) {
    var transaction = service.create(dto, principal);
    return new TransactionInfoDTO().toDTO(transaction);
  }

  @GetMapping("/check-success/success/{id}")
  public TransactionInfoDTO checkStatusSuccess(@PathVariable("id") Long id) {
    var transaction = service.checkSuccess(id);
    return new TransactionInfoDTO().toDTO(transaction);
  }

  @GetMapping("/check-success/failure/{id}")
  public TransactionInfoDTO checkStatusFailure(@PathVariable("id") Long id) {
    var transaction = service.checkFailure(id);
    return new TransactionInfoDTO().toDTO(transaction);
  }

  @GetMapping("/all")
  public List<TransactionInfoDTO> getAll(
    @RequestParam(required = false) Long user_id,
    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
  ) {
    var transactionFilter = new TransactionFilterDTO(
      user_id,
      from,
      to
    );

    var users = service.getAll(transactionFilter);
    return users
      .stream()
      .map(transaction -> new TransactionInfoDTO().toDTO(transaction))
      .toList();
  }


  @GetMapping("/all/me")
  public List<TransactionInfoDTO> getAll(
    Principal principal
  ) {
    var users = service.getAllMe(principal);
    return users
      .stream()
      .map(new TransactionInfoDTO()::toDTO)
      .toList();
  }

}
