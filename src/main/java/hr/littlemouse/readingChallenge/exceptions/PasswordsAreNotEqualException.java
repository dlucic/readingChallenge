package hr.littlemouse.readingChallenge.exceptions;

import hr.littlemouse.readingChallenge.data.dto.UserDTO;

public class PasswordsAreNotEqualException extends RuntimeException{

    public PasswordsAreNotEqualException(String message, UserDTO userDTO) {
        super(message + userDTO.getPassword() + "/" + userDTO.getRepeatPassword());
    }
}
