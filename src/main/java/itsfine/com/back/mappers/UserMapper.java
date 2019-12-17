package itsfine.com.back.mappers;


import itsfine.com.back.dtos.User;
import itsfine.com.back.entities.UserEntity;

public class UserMapper extends AbstractMapper<UserEntity, User> {

    public UserMapper(Class<UserEntity> entityClass, Class<User> dtoClass) {
        super(entityClass, dtoClass);
    }

}