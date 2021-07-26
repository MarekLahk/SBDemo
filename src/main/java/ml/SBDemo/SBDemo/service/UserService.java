package ml.SBDemo.SBDemo.service;

import ml.SBDemo.SBDemo.dto.UserDto;
import ml.SBDemo.SBDemo.mapper.UserMapper;
import ml.SBDemo.SBDemo.model.User;
import ml.SBDemo.SBDemo.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUser(Integer id) {
        return userMapper.toDto(userRepository.getById(id));
    }

    public UserDto createUser(UserDto userDto) {
        return userMapper.toDto(userRepository.save(userMapper.toModel(userDto)));
    }

    public UserDto updateUser(Integer id, UserDto userDto) throws Exception {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new Exception("No such user exists"));
        existingUser.setUserName(userDto.getUserName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        return userMapper.toDto(userRepository.save(existingUser));
    }

    public List<UserDto> searchUsers(UserDto userDto) {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public void deleteUser(Integer id) throws Exception {
         userRepository.deleteById(id);
    }
}
