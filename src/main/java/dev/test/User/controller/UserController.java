package dev.test.User.controller;

import dev.test.User.domain.UserEntity;
import dev.test.User.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;


    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public UserEntity create(@RequestParam("name") String user){
        return userService.createUser(user);

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

    /*
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam("name") String userName) {
        UserEntity user = userService.login(userName);

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", user != null);
        requestMap.put("message", user != null ? "로그인 성공" : "로그인 실패");
        requestMap.put("userInfo", user);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
    */

}
