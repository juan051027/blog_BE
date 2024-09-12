package dev.test.User.controller;

import dev.test.User.domain.UserEntity;
import dev.test.User.service.UserCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserCRUDService userCRUDService;


    public UserController(UserCRUDService userCRUDService){
        this.userCRUDService = userCRUDService;
    }

    //name과 password 등록하기
    @PostMapping
    public UserEntity create(@RequestParam(value="name") String user, @RequestParam(value="pw") String pw){
        return userCRUDService.createUser(user, pw);

    }

    //저장된 모든 UserEntity 불러오기
    @GetMapping("/all")
    public List<UserEntity> getAllUsers(){
        return userCRUDService.findUsers();
    }

    //하나의 UserEntity 이름으로 불러오기
    @GetMapping
    public UserEntity getOneUser(Long id) {
        return userCRUDService.findOneUser(id);
    }

    //원래 name 과 바꿀 name 입력후 교체
    @PutMapping
    public UserEntity updateUserName(String name, String change){
        return userCRUDService.updateUserName(name, change);
    }

    //id값으로 Entity 삭제
    @DeleteMapping
    public Long deleteUser(@RequestParam(value="id") long id){
        return userCRUDService.deleteUser(id);
    }

    //name 과 password 입력 후 일치하면 online true 로 변경
    @PutMapping("/login")
    public UserEntity userLogin(@RequestParam(value="name") String name,@RequestParam(value="pw")String pw){
        return userCRUDService.userLogin(name,pw);
    }

}
