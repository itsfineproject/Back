package application.config;

import application.entities.CarEntity;
import application.entities.FineEntity;
import application.entities.UserEntity;
import mappers.CarMapper;
import mappers.FineMapper;
import mappers.UserMapper;
import dtos.Car;
import dtos.Fine;
import dtos.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Configuration
public class MapperConfig {
    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true);
        return mapper;
    }

    @Bean
    public CarMapper carMapper(){return new CarMapper(CarEntity.class, Car.class);    }

    @Bean
    public UserMapper userMapper(){
        return new UserMapper(UserEntity.class, User.class);
    }

    @Bean
    public FineMapper fineMapper(){
        return new FineMapper(FineEntity.class, Fine.class);
    }

}
