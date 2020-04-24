package hr.littlemouse.readingChallenge.controllers;

import hr.littlemouse.readingChallenge.data.entity.User;
import hr.littlemouse.readingChallenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping(path = "username/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED) // TODO: 13/04/2020 provjeriti što se dogodi kad nema ove anotacije
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
