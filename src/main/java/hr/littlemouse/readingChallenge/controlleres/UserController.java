package hr.littlemouse.readingChallenge.controlleres;

import hr.littlemouse.readingChallenge.data.entity.Challenge;
import hr.littlemouse.readingChallenge.data.entity.User;
import hr.littlemouse.readingChallenge.services.ChallengeService;
import hr.littlemouse.readingChallenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;
    private final ChallengeService challengeService;

    @Autowired
    public UserController(UserService userService, ChallengeService challengeService) {
        this.userService = userService;
        this.challengeService = challengeService;
    }

    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public User getUserByUsername(@RequestParam("username") String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping(path = "/{userId}/challenges")
    public List<Challenge> getChallengesByUserId(@PathVariable("userId") Long userId) {
        return challengeService.getChallengesByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping(value = "/{id}")
    public User changeUser(@RequestBody User newUser, @PathVariable Long id) {
        return userService.changeUser(newUser, id);
    }



}
