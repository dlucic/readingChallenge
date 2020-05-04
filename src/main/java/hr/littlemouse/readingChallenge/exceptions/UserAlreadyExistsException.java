package hr.littlemouse.readingChallenge.exceptions;

import hr.littlemouse.readingChallenge.data.dto.UserDTO;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String message, UserDTO userDTO) {

        super(message + userDTO.getUsername());
    }




}
