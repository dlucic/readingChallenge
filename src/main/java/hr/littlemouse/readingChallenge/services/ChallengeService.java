package hr.littlemouse.readingChallenge.services;

import hr.littlemouse.readingChallenge.data.entity.Challenge;
import hr.littlemouse.readingChallenge.data.repository.ChallengeRepository;
import hr.littlemouse.readingChallenge.exceptions.ChallengeDoesNotExist;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChallengeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChallengeService.class);

    private ChallengeRepository challengeRepository;

    public Challenge getChallengeById(Long challengeId) {
        return challengeRepository.findById(challengeId)
                .orElseThrow(()-> new ChallengeDoesNotExist("Challenge with id " + challengeId + " does not exist."));
    }

    public List<Challenge> getChallengesByUsername(String username) {
        return challengeRepository.findByUsers_username(username);
    }


    public Challenge createChallenge(Challenge challenge) {
        return challengeRepository.saveAndFlush(challenge);
    }


}


