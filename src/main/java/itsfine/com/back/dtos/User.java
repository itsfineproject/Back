package itsfine.com.back.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class User {

    @JsonIgnore
    private long id;

    @Column(unique=true)
    @Pattern(regexp = "^((\\w+)\\.)*(\\w+)@((\\w+)\\.)+[a-zA-Z]{2,4}$", message="Email should include only english letters, digits and symbols: ._")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$",
            message="Password should be not less than 6 characters and contain at least one uppercase letter and a digit")
    private String password;

    @Pattern(regexp = "[a-zA-Z ]{2,15}", message = "Name should be from 2 to 15 symbols, only letters accepted")
    private String firstName;

    @Pattern(regexp = "[a-zA-Z ]{2,15}", message = "Last name should be from 2 to 15 symbols, only letters accepted")
    private String lastName;

    @Column(unique=true)
    @Min(value = 10000000, message="User Id should include 9 digits")
    @Max(value = 999999999, message="User Id should include 9 digits")
    private long teudatZeut;

    private List<String> roles;  //?

    public User(String email, String password, String firstName, String lastName, long teudatZeut, List<String> roles) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teudatZeut = teudatZeut;
        this.roles = roles;
    }

    public User(String email, String password, List<String> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
