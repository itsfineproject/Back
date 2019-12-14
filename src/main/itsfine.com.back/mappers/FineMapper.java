package mappers;

import application.entities.FineEntity;
import application.repositories.CarRepository;
import dtos.Fine;
import org.springframework.beans.factory.annotation.Autowired;

public class FineMapper extends AbstractMapper<FineEntity, Fine> {

    @Autowired
    private CarRepository carRepository;

    public FineMapper(Class<FineEntity> entityClass, Class<Fine> dtoClass) {
        super(entityClass, dtoClass);
    }

    public void setupMapper(){
        modelMapper.createTypeMap(Fine.class, FineEntity.class)
                .addMappings(m->m.skip(FineEntity::setCar))
                .setPostConverter(toEntityConverter());
        modelMapper.createTypeMap(FineEntity.class, Fine.class)
                .addMappings(m->m.skip(Fine::setCarId))
                .setPostConverter(toDtoConverter());
    }

    @Override
    void mapSpecificFieldsToEntity(Fine fine, FineEntity fineEntity) {
        fineEntity.setCar(carRepository.findById(fine.getCarId()).orElse(null));
    }

    @Override
    void mapSpecificFieldsToDto(FineEntity fineEntity, Fine fine) {
        fine.setCarId(fineEntity.getCar().getId());
    }
}
