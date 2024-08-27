package User.service;

import User.domain.UserEntity;
import User.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.lang.String;


@Service
@Transactional


public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Long join(UserEntity user){
        validateDuplicateUser(user);
        return user.getId();
    }

    private void validateDuplicateUser(UserEntity user){
        userRepository.findByName(user.getName())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<UserEntity> findUsers(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> findOneUser(Long id){
        return userRepository.findById(id);
    }

    @Transactional
    public UserEntity updateUser(String name, String changeName){
        UserEntity userEntity = userRepository.findByName(name).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        userEntity.setName(changeName);
        return userRepository.save(userEntity);
    }

    @Transactional
    public Long deleteUser(long id){
        userRepository.deleteById(id);
        return id;
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
