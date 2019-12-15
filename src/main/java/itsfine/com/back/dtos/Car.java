package itsfine.com.back.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Car {

    @JsonIgnore
    private long id;
    @Column(unique=true)
    @Pattern(regexp = "([0-9]{2}-[0-9]{3}-[0-9]{2}) | ([0-9]{3}-[0-9]{2}-[0-9]{3})",
            message="Car number should be of type XX-XXX-XX or XXX-XX-XXX where 'X' is a digit")
    private String carNumber;
    private long userId;

}
