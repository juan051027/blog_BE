package dev.test.User.service;

import dev.test.User.domain.UserEntity;
import dev.test.User.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.lang.String;


@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Long join(UserEntity user){
        validateDuplicateUser(user);
        return user.getId();
    }

    public UserEntity createUser(String name, String pw){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setPassword(pw);
        userRepository.save(userEntity);
        return userEntity;
    }

    private boolean validateDuplicateUser(UserEntity user){
        UserEntity userEntity = userRepository.findByName(user.getName());
        return userEntity != null;
    }

    public List<UserEntity> findUsers(){
        return userRepository.findAll();
    }

    public UserEntity findOneUser(Long id){
        return userRepository.findById(id).get();
    }

    public UserEntity updateUserName(String name, String changeName){
        UserEntity userEntity = userRepository.findByName(name);
        if(userEntity == null) return null;

        userEntity.setName(changeName);
        userRepository.save(userEntity);

        return userEntity;
    }

    public Long deleteUser(long id){
        userRepository.deleteById(id);
        return id;
    }

    public UserEntity userLogin(String name, String pw){
        UserEntity userEntity = userRepository.findByName(name);
        String userpassword = userEntity.getPassword();

        if(userpassword.equals(pw)) userEntity.setOnline(true);
        userRepository.save(userEntity);
        return userEntity;
    }

    public boolean loginCheck(String name){
        UserEntity userEntity = userRepository.findByName(name);
        boolean onlinestatus = userEntity.isOnline();
        return onlinestatus;
    }

}
