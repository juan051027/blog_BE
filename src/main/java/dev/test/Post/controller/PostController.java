package dev.test.Post.controller;

import dev.test.Post.service.PostService;
import dev.test.Post.domain.PostEntity;
import dev.test.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/post")
@RestController
public class PostController {

    private final PostService postService;


    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public PostEntity create(@RequestParam(value="title") String title, @RequestParam(value="post") String post){
        return postService.createPost(title, post);

    }

    @GetMapping("/all")
    public List<PostEntity> getAllUsers(){
        return postService.findPosts();
    }

    @GetMapping("/post")
    public PostEntity getOneUser(Long id) {
        return postService.findOnePost(id);
    }

    @PutMapping("/user")
    public PostEntity updateUserName(String name, String change){
        return postService.updateUserPost(name, change);
    }

    @DeleteMapping("/user")
    public Long deleteUser(long id){
        return postService.deletePost(id);
    }

}
