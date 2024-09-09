package dev.test.Post.service;

import dev.test.Post.domain.PostEntity;
import dev.test.Post.repository.PostRepository;

import dev.test.User.repository.UserRepository;
import dev.test.User.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Long;
import java.util.List;

@Service
@Transactional

public class PostService {
    private final PostRepository postRepository;

    @Autowired
    private UserService userService;


    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }


    public PostEntity createPost(String name,String title, String content){
        if(LoginCheck(name)){
        PostEntity postEntity = new PostEntity();

        postEntity.setName(name);
        postEntity.setTitle(title);
        postEntity.setContent(content);

        postRepository.save(postEntity);
        return postEntity;
        }
        else return null;
    }

    public List<PostEntity> findPosts(){
        return postRepository.findAll();
    }

    public PostEntity findOnePost(Long id){
        return postRepository.findById(id).get();
    }

    public PostEntity updateUserPost(Long id, String changePost){
        PostEntity postEntity = postRepository.findById(id).get();
        if(postEntity == null) return null;

        postEntity.setContent(changePost);
        postRepository.save(postEntity);

        return postEntity;
    }

    public Long deletePost(Long id){
        postRepository.deleteById(id);
        return id;
    }

    public boolean LoginCheck(String name){
        return userService.loginCheck(name);
    }



}
