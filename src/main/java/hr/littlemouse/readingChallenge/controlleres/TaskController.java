package hr.littlemouse.readingChallenge.controlleres;

import hr.littlemouse.readingChallenge.data.entity.Task;
import hr.littlemouse.readingChallenge.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getTasksByChallenge(@RequestParam("challenge") Long id) {
        return taskService.getTasksByChallenge(id);
    }
}
