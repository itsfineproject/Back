package itsfine.com.back.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"email"})

@Entity
@Table(name = "users", uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String name;
    private String password;
    private List<String> roles;

    @OneToMany(mappedBy = "users")
    private Set<CarEntity> cars;

    public UserEntity(long id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public UserEntity(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}