package dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class User {

    @JsonIgnore
    private long id;

    @Column(unique=true)
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message="Email should include only english letters, digits and symbols: ._-")
    private String email;

    @Size(min = 5, max = 20, message = "Name should be from 5 to 20 symbols")
    private String name;

    @Pattern(regexp = "^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})",
            message="Password should be not less than 6 characters and contain either an uppercase letter or a digit")
    private String password;
}
