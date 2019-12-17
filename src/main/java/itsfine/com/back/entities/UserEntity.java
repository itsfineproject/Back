package itsfine.com.back.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = {"email"})

@Entity
@Table(name = "users", uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private long teudatZeut;
    private List<String> roles;

    @OneToMany(mappedBy = "user")
    private Set<CarEntity> cars;

    public UserEntity(String email, String password, String firstName, String lastName, long teudatZeut, List<String> roles) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teudatZeut = teudatZeut;
        this.roles = roles;
    }

    public UserEntity(String email, String password, List<String> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}