package itsfine.com.back.controllers;

import itsfine.com.back.dtos.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Set;

@RestController
public class ItsFineBackController {

//  ----------USER-----------

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        return new ResponseEntity(null);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user){
        return new ResponseEntity(null);
    }

    @PutMapping("/user")
    public ResponseEntity<String> editUser(@RequestBody User user){
        return new ResponseEntity(null);
    }

    //  ----------CAR-----------

    @GetMapping("/userCars")
    public ResponseEntity<Set<Car>> getUserCars(@RequestParam long userId){
        return null;
    }

    @PostMapping("/car")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return new ResponseEntity(null);
    }

    @PutMapping("/car")
    public ResponseEntity<Car> editCar(@RequestBody Car car){
        return new ResponseEntity(null);
    }

    @DeleteMapping("/car")                                                          //??
    public ResponseEntity<String> removeCar(@RequestParam String carNumber){
        return new ResponseEntity(null);
    }

    //  ----------FINE-----------

    @GetMapping("/carFines")
    public ResponseEntity<Set<Fine>> getCarFines(@RequestParam String carNumber){
        return null;
    }

    @PutMapping("/pay")
    public ResponseEntity<Boolean> fineSetPaid(@RequestParam long fineId){
        return new ResponseEntity(null);
    }

    //  ----------ADMIN-----------

    @PostMapping("/admin")
    public ResponseEntity<String> addAdmin(@RequestBody User user){
        return new ResponseEntity(null);
    }

    @GetMapping("/invalidData")
    public ResponseEntity<Set<InvalidCarData>> getInvalidCarData(){
        return null;                                                 // returns last [preset in config] amount of elements (for ex.last 10 elements)
    }

    @GetMapping("/invalidDataFiltered")
    public ResponseEntity<Set<InvalidCarData>> getInvalidDataFiltered(@RequestParam LocalDateTime from,
                                                                  @RequestParam LocalDateTime to){
        return null;
    }

    @GetMapping("/appErrors")
    public ResponseEntity<Set<AppError>> getAppErrors(){
        return null;                                                 // returns last [preset in config] amount of elements (for ex.last 10 elements)
    }

    @GetMapping("/appErrorsFiltered")
    public ResponseEntity<Set<AppError>> getAppErrorsFiltered(@RequestParam LocalDateTime from,
                                                             @RequestParam LocalDateTime to,
                                                             @RequestParam String errorSource){
        return null;                                                 // each of request params could be null
    }

    @GetMapping("/stats")
    public ResponseEntity<Set<Statistics>> getStats(){
        return null;                                                 // returns default statistics (maybe for last month)
    }

    @GetMapping("/statsFiltered")
    public ResponseEntity<Set<Statistics>> getStatsFiltered(@RequestParam LocalDateTime from,
                                                              @RequestParam LocalDateTime to){
        return null;
    }

}
