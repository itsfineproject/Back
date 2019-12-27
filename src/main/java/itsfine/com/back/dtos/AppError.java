package itsfine.com.back.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class AppError {

    private LocalDateTime dateTime;
    private String errorMessage;
    private String errorSource;
}
