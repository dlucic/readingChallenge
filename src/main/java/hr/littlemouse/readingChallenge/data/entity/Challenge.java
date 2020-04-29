package hr.littlemouse.readingChallenge.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "challenges")
@EqualsAndHashCode(exclude = "users")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long challengeId;

    private String name;
    private String type;
    private String status;
    private String winner;
    private Integer points;
    private Long ownerId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("challenges")
    @JoinTable(
            name = "challenges_users",
            joinColumns = @JoinColumn(name = "challenge_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "challenge_id")
    private Set<Task> tasks;


}
