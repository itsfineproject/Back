import itsfine.com.back.dtos.Car;
import itsfine.com.back.dtos.User;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootApplication(scanBasePackages = {"itsfine.com.back"})
public class EntityJunitTests {

    static ConfigurableApplicationContext context;
    long id = 123465;
    String email = "vasya@vfdrt.com";
    String name = "vasya kozlov";
    String password = "vasyaV1";

    String carNumber = "012-85-145";
    long carId = 74546456;
    User user = null;
    private static Validator validator;
    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @BeforeAll
    static void setUpBeforeClass() {
        context = SpringApplication.run(EntityJunitTests.class);
    }

    @Test
    public void testUsernameValidator() {
        user = new User(id, email, name, password);
        Set<ConstraintViolation<User>> validates = validator.validate(user);
        assertTrue(validates.size() == 0);

        String name1 = "vav";
        User user1 = new User(id, email, name1, password);
        Set<ConstraintViolation<User>> validates1 = validator.validate(user1);
        assertTrue(validates1.size() > 0);
        validates1.stream().map(v -> v.getMessage())
                .forEach(message->assertEquals("Name should be from 5 to 20 symbols", message));

        String name2 = "csdvsdfbvgnhnfhndghntyhnsbrgvrgvr";
        User user2 = new User(id, email, name2, password);
        Set<ConstraintViolation<User>> validates2 = validator.validate(user2);
        assertTrue(validates2.size() > 0);
        validates2.stream().map(v -> v.getMessage())
                .forEach(message->assertEquals("Name should be from 5 to 20 symbols", message));
    }

    @Test
    public void testEmailValidator() {
        String email1 = "vav";
        User user1 = new User(id, email1, name, password);
        Set<ConstraintViolation<User>> validates1 = validator.validate(user1);
        assertTrue(validates1.size() > 0);
        validates1.stream().map(v -> v.getMessage())
                .forEach(message->assertEquals("Email should include only english letters, digits and symbols: ._", message));

        String email2 = "csdvsd@ntyhnsbrgvrgvr";
        User user2 = new User(id, email2, name, password);
        Set<ConstraintViolation<User>> validates2 = validator.validate(user2);
        assertTrue(validates2.size() > 0);
        validates2.stream().map(v -> v.getMessage())
                .forEach(message->assertEquals("Email should include only english letters, digits and symbols: ._", message));

        String email3 = "csdvsd@ntyhnsbrgvrgvr.fsdrf.fwefw";
        User user3 = new User(id, email3, name, password);
        Set<ConstraintViolation<User>> validates3 = validator.validate(user2);
        assertTrue(validates2.size() > 0);
        validates2.stream().map(v -> v.getMessage())
                .forEach(message->assertEquals("Email should include only english letters, digits and symbols: ._", message));
    }

    @Test
    public void testPasswordValidator() {
        String pass1 = "vav";
        User user1 = new User(id, email, name, pass1);
        Set<ConstraintViolation<User>> validates1 = validator.validate(user1);
        assertTrue(validates1.size() > 0);
        validates1.stream().map(v -> v.getMessage())
                .forEach(message->assertEquals("Password should be not less than 6 characters and contain at least one uppercase letter and a digit", message));

        String pass2 = "csdvsd1tyhnsbrgvrgvr";
        User user2 = new User(id, email, name, pass2);
        Set<ConstraintViolation<User>> validates2 = validator.validate(user2);
        assertTrue(validates2.size() > 0);
        validates2.stream().map(v -> v.getMessage())
                .forEach(message->assertEquals("Password should be not less than 6 characters and contain at least one uppercase letter and a digit", message));

        String pass3 = "fsdrfwefwW";
        User user3 = new User(id, email, name, pass3);
        Set<ConstraintViolation<User>> validates3 = validator.validate(user3);
        assertTrue(validates2.size() > 0);
        validates3.stream().map(v -> v.getMessage())
                .forEach(message->assertEquals("Password should be not less than 6 characters and contain at least one uppercase letter and a digit", message));
    }

    @Test
    public void testCarNumberValidator() {
        Car car = new Car(carId, carNumber, id);
        Set<ConstraintViolation<Car>> validates = validator.validate(car);
        assertTrue(validates.size() == 0);

        String carNumber1 = "02146554";
        Car car1 = new Car(carId, carNumber1, id);
        Set<ConstraintViolation<Car>> validates1 = validator.validate(car1);
        assertTrue(validates1.size() > 0);
        validates1.stream().map(v -> v.getMessage())
                .forEach(message->assertEquals("Car number should be of type XX-XXX-XX or XXX-XX-XXX where 'X' is a digit", message));

        String carNumber2 = "02-146-554";
        Car car2 = new Car(carId, carNumber2, id);
        Set<ConstraintViolation<Car>> validates2 = validator.validate(car2);
        assertTrue(validates2.size() > 0);
        validates2.stream().map(v -> v.getMessage())
                .forEach(message->assertEquals("Car number should be of type XX-XXX-XX or XXX-XX-XXX where 'X' is a digit", message));


        String carNumber3 = "as-123-tg";
        Car car3 = new Car(carId, carNumber3, id);
        Set<ConstraintViolation<Car>> validates3 = validator.validate(car3);
        assertTrue(validates1.size() > 0);
        validates3.stream().map(v -> v.getMessage())
                .forEach(message->assertEquals("Car number should be of type XX-XXX-XX or XXX-XX-XXX where 'X' is a digit", message));

    }

}

