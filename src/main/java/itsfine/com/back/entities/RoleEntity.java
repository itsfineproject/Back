package itsfine.com.back.entities;

import lombok.Data;
import javax.persistence.*;
@Data

@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String role;
}
