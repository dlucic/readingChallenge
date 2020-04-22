package hr.littlemouse.readingChallenge.services;

import hr.littlemouse.readingChallenge.exceptions.UserDoesNotExist;
import hr.littlemouse.readingChallenge.data.entity.User;
import hr.littlemouse.readingChallenge.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new UserDoesNotExist("User with id " + userId + " does not exist."));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new UserDoesNotExist("User with username " + username + " does not exist."));
    }

    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }
}
