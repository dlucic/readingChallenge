package hr.littlemouse.readingChallenge.exceptions;

public class ChallengeDoesNotExist extends RuntimeException {

    public ChallengeDoesNotExist(String message) {
        super(message);
    }
}
