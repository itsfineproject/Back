package mappers;

import application.entities.UserEntity;
import dtos.User;

public class UserMapper extends AbstractMapper<UserEntity, User> {

    public UserMapper(Class<UserEntity> entityClass, Class<User> dtoClass) {
        super(entityClass, dtoClass);
    }

}