package itsfine.com.back.mappers;

import itsfine.com.back.application.entities.UserEntity;
import itsfine.com.back.dtos.User;

public class UserMapper extends AbstractMapper<UserEntity, User> {

    public UserMapper(Class<UserEntity> entityClass, Class<User> dtoClass) {
        super(entityClass, dtoClass);
    }

}