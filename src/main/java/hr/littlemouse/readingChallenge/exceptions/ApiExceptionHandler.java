package hr.littlemouse.readingChallenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {UserDoesNotExistException.class, ChallengeDoesNotExistException.class, TaskDoesNotExistException.class})
    public ResponseEntity<Object> handleDoesNotExistException(UserDoesNotExistException e) {

        HttpStatus badRequest = HttpStatus.NOT_FOUND;

        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = {PasswordsAreNotEqualException.class, UserAlreadyExistsException.class})
    public ResponseEntity<Object> handlePasswordsNotEqualException(UserDoesNotExistException e) {

        HttpStatus badRequest = HttpStatus.CONFLICT;

        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException, badRequest);
    }
}
