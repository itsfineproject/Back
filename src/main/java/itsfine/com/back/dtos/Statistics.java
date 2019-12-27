package itsfine.com.back.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Statistics {
    private long parkingId;
    private long finesAmount;
    private double finesTotal;
}
