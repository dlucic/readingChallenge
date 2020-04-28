package hr.littlemouse.readingChallenge.data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;

    private String description;
    private String type;
    private String points;
    private String status;

    @ManyToOne
    @JoinColumn(name = "challengeId", nullable = false)
    @JsonManagedReference
    private Challenge challenge;

}
