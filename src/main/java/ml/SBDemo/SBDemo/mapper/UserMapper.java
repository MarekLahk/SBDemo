package ml.SBDemo.SBDemo.mapper;

import ml.SBDemo.SBDemo.dto.UserDto;
import ml.SBDemo.SBDemo.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    public UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    UserDto toDto(User model);

    User toModel(UserDto userDto);

    List<UserDto> toDtoList(List<User> users);

    List<User> toUserList(List<UserDto> Dtos);

}
