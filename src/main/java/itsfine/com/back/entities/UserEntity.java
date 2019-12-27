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

    @OneToMany(mappedBy = "role")
    private List<RoleEntity> roles;

    @OneToMany(mappedBy = "user")
    private Set<CarEntity> cars;

}