package hr.littlemouse.readingChallenge.exceptions;

public class TaskDoesNotExistException extends RuntimeException {

    public TaskDoesNotExistException(String message) {
        super(message);
    }
}
