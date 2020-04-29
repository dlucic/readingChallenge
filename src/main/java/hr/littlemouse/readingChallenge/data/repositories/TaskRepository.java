package hr.littlemouse.readingChallenge.data.repositories;

import hr.littlemouse.readingChallenge.data.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

//    List<Task> findByChallengeChallengeId(Long id);
}
