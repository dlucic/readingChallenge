package hr.littlemouse.readingChallenge.controllers;

import hr.littlemouse.readingChallenge.data.entity.Challenge;
import hr.littlemouse.readingChallenge.services.ChallengeService;
import hr.littlemouse.readingChallenge.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    @GetMapping(path = "username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Challenge> getChallengesByUsername(@PathVariable("username") String username) {
        return challengeService.getChallengesByUsername(username);
    }

}
