package itsfine.com.back.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class InvalidCarData {

    private int parking_id;
    private String car_number;
    private LocalDateTime date_time;
}
