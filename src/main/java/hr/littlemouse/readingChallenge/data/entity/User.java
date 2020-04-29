package hr.littlemouse.readingChallenge.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hr.littlemouse.readingChallenge.data.enumeration.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "users")
@EqualsAndHashCode(exclude = "challenges")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String first_name;
    private String last_name;
    public String username;
    private String email;
    private Integer total_points;
    private Integer challenges_won;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "usr_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte [] user_photo;

    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties("users")
    private Set<Challenge> challenges;

}
