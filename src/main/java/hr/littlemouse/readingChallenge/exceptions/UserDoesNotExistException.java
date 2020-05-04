package hr.littlemouse.readingChallenge.exceptions;

public class UserDoesNotExistException extends RuntimeException {

    public UserDoesNotExistException(String message) {
        super(message);
    }
}
