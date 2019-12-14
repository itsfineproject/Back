package application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "fines")
public class FineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int parkingId;
    private double sum;
    private LocalDateTime dateTime;

    @ManyToOne
    private CarEntity car;



}
