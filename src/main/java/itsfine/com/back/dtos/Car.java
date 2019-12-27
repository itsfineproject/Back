package itsfine.com.back.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Car {

    @JsonIgnore
    private long id;
    @Column(unique=true)
    @Pattern(regexp = "^([0-9]{2}-[0-9]{3}-[0-9]{2})|([0-9]{3}-[0-9]{2}-[0-9]{3})$",
            message="Car number should be of type XX-XXX-XX or XXX-XX-XXX where 'X' is a digit")
    private String carNumber;
    @Size(min = 1, max = 15)
    private String carName;
    @Pattern(regexp = "^[0-9-]{9,11}$", message="Only digits and '-'")
    private String carPassportNumber;
    private LocalDateTime buyDate;
    private LocalDateTime sellDate;
    private String comment;
    private long userId;

    public Car(String carNumber, String carName, String carPassportNumber, LocalDateTime buyDate, LocalDateTime sellDate, String comment, long userId) {
        this.carNumber = carNumber;
        this.carName = carName;
        this.carPassportNumber = carPassportNumber;
        this.buyDate = buyDate;
        this.sellDate = sellDate;
        this.comment = comment;
        this.userId = userId;
    }
}
