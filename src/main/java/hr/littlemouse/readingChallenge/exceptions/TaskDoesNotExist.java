package hr.littlemouse.readingChallenge.exceptions;

public class TaskDoesNotExist extends RuntimeException {

    public TaskDoesNotExist(String message) {
        super(message);
    }
}
