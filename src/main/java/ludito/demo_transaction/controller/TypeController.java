package ludito.demo_transaction.controller;

import ludito.demo_transaction.enums.enums;
import ludito.demo_transaction.exception.Exceptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static ludito.demo_transaction.exception.Logging.LoggedError;

@RestController("${api.path}/types")
public class TypeController {
  @GetMapping("/{type}")
  public List<String> getTypes(@PathVariable("type") String type) {
    switch (type) {
      case "currency" -> {
        return Arrays.stream(enums.CurrencyType.values())
          .map(Enum::name)
          .toList();
      }
      default ->
        throw LoggedError(new Exceptions.CustomEntryNotFoundException("Type not found: " + type));
    }
  }
}
