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

    @PutMapping
    public UserEntity updateUserName(String name, String change){
        return userService.updateUserName(name, change);
    }

    @DeleteMapping
    public Long deleteUser(@RequestParam(value="id") long id){
        return userService.deleteUser(id);
    }

    @PutMapping("/online")
    public UserEntity userLogin(@RequestParam(value="name") String name,@RequestParam(value="pw")String pw){
        return userService.userLogin(name,pw);
    }

}
