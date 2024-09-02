package dev.test.User.controller;

import dev.test.User.domain.UserEntity;
import dev.test.User.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;


    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public UserEntity create(@RequestParam(value="name") String user, @RequestParam(value="pw") String pw){
        return userService.createUser(user, pw);

    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers(){
        return userService.findUsers();
    }

    @GetMapping
    public UserEntity getOneUser(Long id) {
        return userService.findOneUser(id);
    }

    @PutMapping("/user")
    public UserEntity updateUser(String name, String change){
        return userService.updateUser(name, change);
    }

    @DeleteMapping("/user")
    public Long deleteUser(long id){
        return userService.deleteUser(id);
    }

}
