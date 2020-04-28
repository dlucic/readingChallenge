package hr.littlemouse.readingChallenge.controlleres;

import hr.littlemouse.readingChallenge.data.entity.Challenge;
import hr.littlemouse.readingChallenge.services.ChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Challenge> getChallengesByUsername(@RequestParam("username") String username) {
        return challengeService.getChallengesByUsername(username);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Challenge getChallengeById(@PathVariable("id") Long id) {
        return challengeService.getChallengeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Challenge createChallenge(@RequestBody Challenge challenge) {
        return challengeService.createChallenge(challenge);
    }

    @DeleteMapping(value = "/{challengeId}")
    public ResponseEntity<?> deleteChallenge(@PathVariable Long challengeId) {
        challengeService.deleteChallengeById(challengeId);
        return ResponseEntity.ok().build();
    }




}
