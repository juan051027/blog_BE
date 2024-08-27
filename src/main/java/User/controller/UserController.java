package User.controller;

import User.domain.UserEntity;
import User.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
public class UserController {

    private final UserService userService;


    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user/join")
    public Long create(@RequestBody UserEntity user){
        return userService.join(user);

    }

    @GetMapping("/user/findall")
    public List<UserEntity> getAllUsers(){
        return userService.findUsers();
    }

    @GetMapping("/user/find")
    public Optional<UserEntity> getOneUser(Long id) {
        return userService.findOneUser(id);
    }

    @PutMapping("/user/update")
    public UserEntity updateUser(String name, String change){
        return userService.updateUser(name, change);
    }

    @DeleteMapping("/user/delete")
    public Long deleteUser(long id){
        return userService.deleteUser(id);
    }

}
