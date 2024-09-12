package dev.test.Post.service;

import dev.test.Post.domain.ChangeContentRequestDTO;
import dev.test.Post.domain.DeletePostRequestDTO;
import dev.test.Post.domain.PostEntity;
import dev.test.Post.domain.SavePostRequestDTO;
import dev.test.Post.repository.PostRepository;

import dev.test.User.service.UserCRUDService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Long;
import java.util.List;

@Service
@Transactional

public class PostCRUDService {
    private final PostRepository postRepository;

    @Autowired
    private UserCRUDService userCRUDService;


    public PostCRUDService(PostRepository postRepository){
        this.postRepository = postRepository;
    }


    public PostEntity createPost(SavePostRequestDTO savePostRequestDTO){
        PostEntity postEntity = new PostEntity();
        postEntity.setName(savePostRequestDTO.getName());
        postEntity.setContent(savePostRequestDTO.getContent());
        postEntity.setTitle(savePostRequestDTO.getTitle());

        if(LoginCheck(postEntity.getName())){

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

    public PostEntity changePostContent(ChangeContentRequestDTO changeContentRequestDTO){
        PostEntity postEntity = new PostEntity();
        postEntity.setId(changeContentRequestDTO.getId());
        postEntity.setName(changeContentRequestDTO.getName());
        postEntity.setTitle(postEntity.getTitle());
        postEntity.setContent(changeContentRequestDTO.getContent());
        postRepository.save(postEntity);

        return postEntity;
    }

    public void deletePost(DeletePostRequestDTO deletePostRequestDTO){
        PostEntity postEntity = new PostEntity();
        postEntity.setId(deletePostRequestDTO.getId());
        postRepository.deleteById(postEntity.getId());
    }

    public boolean LoginCheck(String name){
        return userCRUDService.loginCheck(name);
    }

}
