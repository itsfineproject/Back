package mappers;


import application.entities.CarEntity;
import application.repositories.UserRepository;
import dtos.Car;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

public class CarMapper extends AbstractMapper<CarEntity, Car> {

    @Autowired
    UserRepository userRepository;

    public CarMapper(Class<CarEntity> entityClass, Class<Car> dtoClass) {
        super(entityClass, dtoClass);
    }

    @PostConstruct
    public void setupMapper(){
        modelMapper.createTypeMap(Car.class, CarEntity.class)
                .addMappings(m->m.skip(CarEntity::setUser));
        modelMapper.createTypeMap(CarEntity.class, Car.class)
                .addMappings(m->m.skip(Car::setUserId))
                .setPostConverter(toDtoConverter());
    }

    @Override
    void mapSpecificFieldsToEntity(Car car, CarEntity carEntity) {
        carEntity.setUser(userRepository.findById(car.getUserId()).orElse(null));
    }

    @Override
    void mapSpecificFieldsToDto(CarEntity carEntity, Car car) {
        car.setUserId(carEntity.getUser().getId());
    }
}
