package itsfine.com.back.config;

import itsfine.com.back.mappers.CarMapper;
import itsfine.com.back.mappers.FineMapper;
import itsfine.com.back.mappers.UserMapper;
import itsfine.com.back.dtos.Car;
import itsfine.com.back.dtos.Fine;
import itsfine.com.back.dtos.User;
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
