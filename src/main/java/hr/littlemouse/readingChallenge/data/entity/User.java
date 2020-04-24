package hr.littlemouse.readingChallenge.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.littlemouse.readingChallenge.data.enumeration.Role;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String first_name;
    private String last_name;
    public String username;
    private String email;
    private Role role;
    private Integer total_points;
    private Integer challenges_won;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte [] user_photo;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private Set<Challenge> challenges;

}
