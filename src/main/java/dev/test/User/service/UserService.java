package dev.test.User.service;

import dev.test.User.domain.UserEntity;
import dev.test.User.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
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

    public UserEntity createUser(String name){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
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

    public UserEntity updateUser(String name, String changeName){
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
}
