package dev.test.Post.service;

import dev.test.Post.domain.PostEntity;
import dev.test.Post.repository.PostRepository;
import dev.test.User.domain.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public PostEntity createPost(String title, String content){
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(title);
        postEntity.setContent(content);
        postRepository.save(postEntity);
        return postEntity;
    }

    public List<PostEntity> findPosts(){
        return postRepository.findAll();
    }

    public PostEntity findOnePost(Long id){
        return postRepository.findById(id).get();
    }

    public PostEntity updateUserPost(String name, String changePost){
        PostEntity postEntity = postRepository.findByName(name);
        if(postEntity == null) return null;

        postEntity.setContent(changePost);
        postRepository.save(postEntity);

        return postEntity;
    }

    public Long deletePost(long id){
        postRepository.deleteById(id);
        return id;
    }
}
