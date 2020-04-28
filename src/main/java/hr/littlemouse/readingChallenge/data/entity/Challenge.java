package hr.littlemouse.readingChallenge.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "challenges")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String status;
    private String winner;
    private Integer points;

    @ManyToMany
    @JoinTable(
            name = "challenges_users",
            joinColumns = @JoinColumn(name = "challenge_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore
    private Set<User> users;

    @OneToMany(mappedBy = "challenge")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Set<Task> tasks;


}
