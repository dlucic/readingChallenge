package hr.littlemouse.readingChallenge.services;

import hr.littlemouse.readingChallenge.data.dto.UserDTO;
import hr.littlemouse.readingChallenge.data.enumeration.UserRole;
import hr.littlemouse.readingChallenge.exceptions.PasswordsAreNotEqualException;
import hr.littlemouse.readingChallenge.exceptions.UserAlreadyExistsException;
import hr.littlemouse.readingChallenge.exceptions.UserDoesNotExistException;
import hr.littlemouse.readingChallenge.data.entity.User;
import hr.littlemouse.readingChallenge.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

import static hr.littlemouse.readingChallenge.exceptions.ExceptionMessages.*;

@Service
@AllArgsConstructor
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getUserById(Long userId) {
        LOGGER.debug("getUserById(): userId = {}", userId);
        return userRepository.findById(userId)
                .orElseThrow(()-> new UserDoesNotExistException(USER_DOES_NOT_EXIST));
    }

    public User getUserByUsername(String username) {
        LOGGER.debug("getUserByUsername(): username = {}", username);
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new UserDoesNotExistException(USER_DOES_NOT_EXIST));
    }

    public User createUser(UserDTO userDTO) {
        LOGGER.debug("createUser(): userDto = {}", userDTO.toString());
        if (!userDTO.getPassword().equals(userDTO.getRepeatPassword())) {
            throw new PasswordsAreNotEqualException(PASSWORDS_ARE_NOT_EQUALS, userDTO);
        }

        Optional<User> newUser = userRepository.findByUsername(userDTO.getUsername());

        if (newUser.isPresent()) {
            throw new UserAlreadyExistsException(USER_ALREADY_EXISTS, userDTO);
        }

        User user = User.builder()
                .first_name(userDTO.getFirstName())
                .last_name(userDTO.getLastName())
                .email(userDTO.getEmail())
                .username(userDTO.getUsername())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .userRoles(Collections.singleton(UserRole.USER))
                .build();

        return userRepository.saveAndFlush(user);
    }

    public void deleteUser(Long id) {
        LOGGER.debug("deleteUser(): id = {}", id);
        userRepository.deleteById(id);
    }


    public User changeUser(User newUser, Long id) {
        LOGGER.debug("changeUser(): newUser = {}, id = {}", newUser, id);
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setFirst_name(newUser.getFirst_name());
                    return userRepository.saveAndFlush(user);
                })
                .orElseThrow(() -> new UserDoesNotExistException(USER_DOES_NOT_EXIST));
    }



}
