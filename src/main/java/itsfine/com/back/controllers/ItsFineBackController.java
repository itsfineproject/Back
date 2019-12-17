package itsfine.com.back.controllers;

import itsfine.com.back.dtos.Car;
import itsfine.com.back.dtos.Fine;
import itsfine.com.back.dtos.InvalidCarData;
import itsfine.com.back.dtos.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class ItsFineBackController {

//  ----------USER-----------

    @PostMapping("/user")
    public ResponseEntity addUser(@RequestBody User user){
        return new ResponseEntity(null);
    }

    @PutMapping("/user")
    public ResponseEntity editUser(@RequestBody User user){
        return new ResponseEntity(null);
    }

    @GetMapping("/user")
    public User getUserDetails(@RequestBody User user){
        return null;
    }

    //  ----------CAR-----------

    @GetMapping("/userCars")
    public List<Car> getUserCars(@RequestBody User user){
        return null;
    }

    @PostMapping("/car")
    public ResponseEntity addCar(@RequestBody Car car){
        return new ResponseEntity(null);
    }

    @PutMapping("/car")
    public ResponseEntity editCar(@RequestBody Car car){
        return new ResponseEntity(null);
    }

    @DeleteMapping("/car")
    public ResponseEntity removeCar(@RequestBody Car car){
        return new ResponseEntity(null);
    }

    //  ----------FINE-----------

    @GetMapping("/carFines")
    public List<Fine> getCarFines(@RequestBody Car car){
        return null;
    }

    @PutMapping("/pay")
    public ResponseEntity fineSetPaid(@RequestBody Fine fine){
        return new ResponseEntity(null);
    }

    //  ----------ADMIN-----------

    @PutMapping("/admin")
    public ResponseEntity setAdmin(@RequestBody User user){
        return new ResponseEntity(null);
    }

    @GetMapping("/invalidDataByParkingIds")
    public List<InvalidCarData> getInvalidDataByParkingIdsByPeriod(@RequestParam LocalDateTime from,
                                                             @RequestParam LocalDateTime to,
                                                             @RequestParam Set<Integer> parkingIds){
        return null;
    }

    @GetMapping("/invalidData")
    public List<InvalidCarData> getAllInvalidDataByPeriod(@RequestParam LocalDateTime from,
                                                          @RequestParam LocalDateTime to){
        return null;
    }

    @DeleteMapping("/invalidData")
    public ResponseEntity removeInvalidData(@RequestParam Set<Integer> invalidDataIds){
        return new ResponseEntity(null);
    }

    @GetMapping("/finesByParkingIds")
    public List<Fine> getAllFinesByParkingIdsByPeriod(@RequestParam LocalDateTime from,
                                                          @RequestParam LocalDateTime to,
                                                          @RequestParam Set<Integer> parkingIds){
        return null;
    }

    @GetMapping("/finesByPeriod")
    public List<Fine> getAllFinesByPeriod(@RequestParam LocalDateTime from,
                                          @RequestParam LocalDateTime to){
        return null;
    }

    @GetMapping("/mostFinedUsers")
    public Map<User, Double> getMostFinedUsers(){             // Double = sum of fines
        return null;
    }

    @GetMapping("/mostFiningParkings")
    public Map<Integer, Double> getMostFiningParkings(){      // Integer = parking Id, Double = amount of fines
        return null;
    }

    @GetMapping("/mostFiningPeriod")
    public Map<String, Double> getMostFiningPeriod(){         // String = period from-to, Double = sum
        return null;
    }

    @GetMapping("/mostInvalidParkings")
    public Map<Integer, Long> getMostInvalidDataParkings(){   // Integer = parking Id, Long = invalid data amount
        return null;
    }

    @GetMapping("/currentLogs")
    public void getCurrentLogsByPeriod(){

    }
}
