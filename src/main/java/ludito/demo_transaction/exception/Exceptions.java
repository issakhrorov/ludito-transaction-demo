package ludito.demo_transaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class Exceptions {
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class BadRequestException extends RuntimeException {}

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class CustomBadRequestException extends RuntimeException {
    public CustomBadRequestException(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class BadCredentialsException extends RuntimeException {
    public BadCredentialsException(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  public static class CustomInternalServerException extends RuntimeException {
    public CustomInternalServerException(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(HttpStatus.CONFLICT)
  public static class CustomConflictException extends RuntimeException {
    public CustomConflictException(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class InvalidJWTTokenException extends RuntimeException {
    public InvalidJWTTokenException(String msg) {
      super("Expired or invalid JWT token!");
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class InvalidBodyException extends RuntimeException {
    public InvalidBodyException(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(code = HttpStatus.CONFLICT)
  public static class EmailNotAvailableException extends RuntimeException {
    public EmailNotAvailableException(String msg) {
      super("Email is not available!");
    }
  }

  @ResponseStatus(code = HttpStatus.CONFLICT)
  public static class UsernameNotAvailableException extends RuntimeException {
    public UsernameNotAvailableException(String msg) {
      super("Username is not available!");
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class EmptyFileException extends RuntimeException {
    public EmptyFileException(String msg) {
      super("File is empty!");
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class EmptyIdException extends RuntimeException {
    public EmptyIdException(String msg) {
      super("Id is required!");
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class CustomEmptyIdException extends RuntimeException {
    public CustomEmptyIdException(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  public static class FileNotUploadedException extends RuntimeException {
    public FileNotUploadedException(String msg) {
      super("File not uploaded!");
    }
  }

  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  public static class InternalServerErrorException extends RuntimeException {}

  @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
  public static class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String msg) {
      super("Username or password is incorrect!");
    }
  }

  @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
  public static class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  public static class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
      super();
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class CustomEntryNotFoundException extends RuntimeException {
    public CustomEntryNotFoundException(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class EntryNotFoundException extends RuntimeException {
    public EntryNotFoundException(String msg) {
      super("Entry not found with provided ID");
    }
  }


  @ResponseStatus(code = HttpStatus.CONFLICT)
  public static class TicketAlreadyDelivered extends RuntimeException {
    public TicketAlreadyDelivered(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(code = HttpStatus.CONFLICT)
  public static class NoTicketsLeftException extends RuntimeException {
    public NoTicketsLeftException(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class EmptyContentException extends RuntimeException {
    public EmptyContentException(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class NullFileException extends RuntimeException {
    public NullFileException(String msg) {
      super("File is null!");
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class PasswordValidationException extends RuntimeException {
    public PasswordValidationException(String message) {
      super(message);
    }
  }

  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  public static class NotCreatedOrUpdatedException extends RuntimeException {
    public NotCreatedOrUpdatedException(String error) {
      super(error);
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg) {
      super("User not found!");
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String msg) {
      super("User not found!");
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class CustomFileNotFoundException extends RuntimeException {
    public CustomFileNotFoundException(String msg) {
      super("Account not found!");
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class CustomFileNotCreatedException extends RuntimeException {
    public CustomFileNotCreatedException(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public static class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String msg) {
      super("File not found!");
    }
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public static class CustomForbiddenException extends RuntimeException {
    public CustomForbiddenException(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  public static class FileFormatException extends RuntimeException {
    public FileFormatException(String msg) {
      super(msg);
    }
  }

  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  public static class EntityNotCreatedException extends RuntimeException {
    public EntityNotCreatedException(String error) {
      super(error);
    }
  }

  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  public static class QRCodeIsNotUniqueException extends RuntimeException {
    public QRCodeIsNotUniqueException(String msg) {
      super("Id not found!");
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class EmptyImageException extends RuntimeException {
    public EmptyImageException(String error) {
      super(error);
    }
  }

  @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
  public static class AuthorizationException extends RuntimeException {
    public AuthorizationException(String msg) {
      super("QR Code is not unique");
    }
  }



  //INPUT EXCEPTIONS
  @ResponseStatus(code = HttpStatus.CONFLICT)
  public static class EntryExistsException extends RuntimeException {
    public EntryExistsException(String msg) {
      super("Need to authorize to access this resource");
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class InvalidTypeException extends RuntimeException {
    public InvalidTypeException(String msg) {
      super("Need to authorize to access this resource");
    }
  }

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public static class CustomInputFieldErrorException extends RuntimeException {
    public CustomInputFieldErrorException(String msg) {
      super("Input type is incorrect!");
    }
  }
}
