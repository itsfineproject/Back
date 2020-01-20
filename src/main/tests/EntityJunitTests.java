import itsfine.com.back.dtos.Car;
import itsfine.com.back.dtos.User;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootApplication(scanBasePackages = {"itsfine.com.back"})
public class EntityJunitTests {

    static ConfigurableApplicationContext context;

    private static Validator validator;
    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    long id = 123456789;
    String email = "vasya@vfdrt.com";
    String password = "vasyaV1";
    String firstName = "vasya";
    String lastName = "kozlov";
    long teudatZeut = 123456789;
    List<String> roles = new ArrayList<>();

    String carNumber = "012-85-145";
    String carName = "My Pretty Car";
    String carPassportNumber = "12345678-9";
    LocalDateTime buyDate = LocalDateTime.now().minusYears(1);
    LocalDateTime sellDate = null;
    String comment = "Bought for 10000 shekels";
    User user;

    @BeforeAll
    static void setUpBeforeClass() {
        context = SpringApplication.run(EntityJunitTests.class);
    }

    @AfterAll
    static void tearDownAfterAll(){
        context.close();
    }

    @Test
    public void testValidUser(){
        user = new User(id, email, password, firstName, lastName, teudatZeut, roles);
        Set<ConstraintViolation<User>> validates = validator.validate(user);
        assertTrue(validates.isEmpty());
    }

    @Test
    public void testIdValidator() {
        validation("12", "user", "id");
        validation("111111111111111", "user", "id");
    }
    @Test
    public void testFirstNameValidator() {
        validation("v", "user", "firstName");
        validation("v213", "user", "firstName");
        validation("csdvsdfbvgnhnfhndghntyhnsbrgvrgvr", "user", "firstName");
    }

    @Test
    public void testLastNameValidator() {
        validation("v", "user", "lastName");
        validation("v4fh", "user", "lastName");
        validation("csdvsdfbvgnhnfhndghntyhnsbrgvrgvr", "user", "lastName");
    }

    @Test
    public void testEmailValidator() {
        validation("csd", "user", "email");
        validation("csdvsdfbvgnhnfhndghntyhnsbrgvrgvr", "user", "email");
        validation("csdvsd@ntyhnsbrgvrgvr.fsdrf.fwefvw", "user", "email");
    }

    @Test
    public void testPasswordValidator() {
        validation("csd", "user", "password");
        validation("csdvsd1tyhnsbrgvrgvr", "user", "password");
        validation("fsdrfwefwW", "user", "password");
        validation("fsdrfwef12", "user", "password");
    }
    @Test
    public void testCarValid(){
        Car car = new Car(carNumber, carName, carPassportNumber, buyDate, sellDate, comment, teudatZeut);
        Set<ConstraintViolation<Car>> validates = validator.validate(car);
        assertTrue(validates.isEmpty());
    }

    @Test
    public void testCarNumberValidator() {
        validation("02146554", "car", "carNumber");
        validation("02-146-554", "car", "carNumber");
        validation("as-123-tg", "car", "carNumber");
    }

    @Test
    public void testCarPassportNumberValidator() {
        validation("123456789123", "car", "carPassportNumber");
        validation("02-146", "car", "carPassportNumber");
        validation("as-123-tg", "car", "carPassportNumber");
    }

    private void validation(String value, String type, String field){
        Car car = null;
        User user = null;
        String message = null;

        if(type.equals("car")){
            switch (field) {
                case "carNumber": car = new Car(value, carName, carPassportNumber, buyDate, sellDate, comment, teudatZeut);
                    message = "Car number should be of type XX-XXX-XX or XXX-XX-XXX where 'X' is a digit";
                    break;
                case "carPassportNumber": car = new Car(carNumber, carName, value, buyDate, sellDate, comment, teudatZeut);
                    message = "Only digits and '-'";
                    break;
            }
            Set<ConstraintViolation<Car>> validates = validator.validate(car);
            assertTrue(!validates.isEmpty());
            String finalMessage1 = message;
            validates.stream().map(v -> v.getMessage())
                    .forEach(gotMsg->assertEquals(finalMessage1, gotMsg));
        };

        if(type.equals("user")){
            switch (field) {
                case "id":
                    user = new User(id, email, password, firstName, lastName, Long.valueOf(value), roles);
                    message = "User Id should include 9 digits";
                    break;
                case "firstName": user = new User(id, email, password, value, lastName, teudatZeut, roles);
                    message = "Name should be from 2 to 15 symbols, only letters accepted";
                    break;
                case "lastName": user = new User(id, email, password, firstName, value, teudatZeut, roles);
                    message = "Last name should be from 2 to 15 symbols, only letters accepted";
                    break;
                case "email": user = new User(id, value, password, firstName, lastName, teudatZeut, roles);
                    message = "Email should include only english letters, digits and symbols: ._";
                    break;
                case "password": user = new User(id, email,value, firstName, lastName, teudatZeut, roles);
                    message = "Password should be not less than 6 characters and contain at least one uppercase letter and a digit";
                    break;
            }
            Set<ConstraintViolation<User>> validates = validator.validate(user);
            assertTrue(!validates.isEmpty());
            String finalMessage = message;
            validates.stream().map(v -> v.getMessage())
                    .forEach(gotMsg->assertEquals(finalMessage, gotMsg));
        }

    }

}

