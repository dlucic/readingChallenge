package hr.littlemouse.readingChallenge.services;

import hr.littlemouse.readingChallenge.data.entity.Task;
import hr.littlemouse.readingChallenge.data.repositories.TaskRepository;
import hr.littlemouse.readingChallenge.exceptions.TaskDoesNotExist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static hr.littlemouse.readingChallenge.exceptions.ExceptionMessages.TASK_DOES_NOT_EXIST;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(()-> new TaskDoesNotExist(TASK_DOES_NOT_EXIST));
    }

    public List<Task> getTasksByChallenge(Long id) {
        return taskRepository.findByChallengeChallengeId(id);
    }
}
