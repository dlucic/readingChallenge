package hr.littlemouse.readingChallenge.exceptions;

public class ChallengeDoesNotExistException extends RuntimeException {

    public ChallengeDoesNotExistException(String message) {
        super(message);
    }
}
