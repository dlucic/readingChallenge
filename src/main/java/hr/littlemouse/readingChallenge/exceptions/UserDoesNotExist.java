package hr.littlemouse.readingChallenge.exceptions;

public class UserDoesNotExist extends RuntimeException {

    public UserDoesNotExist(String message) {
        super(message);
    }
}
