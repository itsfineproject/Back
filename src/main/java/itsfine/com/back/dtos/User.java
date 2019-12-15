package itsfine.com.back.dtos;

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
    @Pattern(regexp = "^((\\w+)\\.)*(\\w+)@((\\w+)\\.)+[a-zA-Z]{2,6}$", message="Email should include only english letters, digits and symbols: ._")
    private String email;

    @Size(min = 5, max = 20, message = "Name should be from 5 to 20 symbols")
    private String name;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$",
            message="Password should be not less than 6 characters and contain at least one uppercase letter and a digit")
    private String password;
}
