package itsfine.com.back.application.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = {"car_number"})

@Entity
@Table(name = "cars", uniqueConstraints={@UniqueConstraint(columnNames={"car_number"})})
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "car_number")
    private String carNumber;

    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "cars")
    private Set<FineEntity> fines;

    public CarEntity(long id, String carNumber, UserEntity user) {
        this.id = id;
        this.carNumber = carNumber;
        this.user = user;
    }

    public CarEntity(String carNumber, UserEntity user) {
        this.carNumber = carNumber;
        this.user = user;
    }
}
