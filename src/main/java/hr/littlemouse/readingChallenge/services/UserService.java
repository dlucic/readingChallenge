package hr.littlemouse.readingChallenge.services;

import hr.littlemouse.readingChallenge.exceptions.UserDoesNotExist;
import hr.littlemouse.readingChallenge.data.entity.User;
import hr.littlemouse.readingChallenge.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static hr.littlemouse.readingChallenge.exceptions.ExceptionMessages.USER_DOES_NOT_EXIST;

@Service
@AllArgsConstructor
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public User getUserById(Long userId) {
        LOGGER.debug("getUserById(): userId = {}", userId);
        return userRepository.findById(userId)
                .orElseThrow(()-> new UserDoesNotExist(USER_DOES_NOT_EXIST));
    }

    public User getUserByUsername(String username) {
        LOGGER.debug("getUserByUsername(): username = {}", username);
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new UserDoesNotExist(USER_DOES_NOT_EXIST));
    }

    public User createUser(User user) {
        LOGGER.debug("createUser(): user = {}", user.toString());
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
                .orElseThrow(() -> new UserDoesNotExist(USER_DOES_NOT_EXIST));
    }

}
