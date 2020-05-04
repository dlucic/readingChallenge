package hr.littlemouse.readingChallenge.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hr.littlemouse.readingChallenge.data.enumeration.UserRole;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity(name = "users")
@EqualsAndHashCode(exclude = "challenges")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String first_name;

    private String last_name;

    @Column(nullable = false, unique = true)
    public String username;

    @Column(nullable = false)
    public String password;

    @Column(nullable = false, unique = true)
    private String email;


    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    private Integer total_points;
    private Integer challenges_won;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "usr_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> userRoles;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte [] user_photo;

    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties("users")
    private Set<Challenge> challenges;

}

