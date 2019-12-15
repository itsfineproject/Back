package itsfine.com.back.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Fine {

    private long id;
    private int parkingId;
    private double sum;
    private LocalDateTime dateTime;
    private long carId;

}
