package hr.littlemouse.readingChallenge.data.repositories;

import hr.littlemouse.readingChallenge.data.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    List<Challenge> findByUsers_username(String username);

}
