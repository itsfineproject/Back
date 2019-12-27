package itsfine.com.back.mappers;

import itsfine.com.back.dtos.User;
import itsfine.com.back.entities.UserEntity;
import itsfine.com.back.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;

public class UserMapper extends AbstractMapper<UserEntity, User> {

    @Autowired
    RoleRepository roleRepository;

    public UserMapper(Class<UserEntity> entityClass, Class<User> dtoClass) {
        super(entityClass, dtoClass);
    }

    public void setupMapper(){
        modelMapper.createTypeMap(User.class, UserEntity.class)
                .addMappings(m->m.skip(UserEntity::setRoles))
                .setPostConverter(toEntityConverter());
        modelMapper.createTypeMap(UserEntity.class, User.class)
                .addMappings(m->m.skip(User::setRoles))
                .setPostConverter(toDtoConverter());
    }

    @Override
    void mapSpecificFieldsToEntity(User user, UserEntity userEntity) {
        userEntity.setRoles(user.getRoles().stream()
                .map(role->roleRepository.findByRole(role).orElse(null))
                .collect(Collectors.toList()));
    }

    @Override
    void mapSpecificFieldsToDto(UserEntity userEntity, User user) {
        user.setRoles(userEntity.getRoles().stream()
                .map(role->role.getRole())
                .collect(Collectors.toList()));
    }

}