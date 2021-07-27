package ml.SBDemo.SBDemo.controller;

import ml.SBDemo.SBDemo.dto.UserDto;
import ml.SBDemo.SBDemo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "users/{id}")
    public UserDto getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @GetMapping(path = "users")
    public Page<UserDto> searchUsers(UserDto userDto) {
        return userService.searchUsers(userDto);
    }

    @PostMapping(path = "users")
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping(path = "users/{id}")
    public UserDto updateUser(@PathVariable Integer id, @Valid @RequestBody UserDto userDto) throws Exception {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping(path = "users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id) throws Exception {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
