package itsfine.com.back.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class InvalidCarData {

    private ObjectId _id;
    private int parking_id;
    private String car_number;
    private LocalDateTime date_time;
}
