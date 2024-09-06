package dev.test.Post.controller;

import dev.test.Post.service.PostService;
import dev.test.Post.domain.PostEntity;
import dev.test.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.lang.String;

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
    public PostEntity create(@RequestParam(value ="name")String name, @RequestParam(value="title") String title, @RequestParam(value="post") String post){
        return postService.createPost(name, title, post);

    }

    @GetMapping("/all")
    public List<PostEntity> getAllPosts(){
        return postService.findPosts();
    }

    @GetMapping("/post")
    public PostEntity getOnePost(Long id) {
        return postService.findOnePost(id);
    }

    @PutMapping("/post")
    public PostEntity updateUserPost(String name, String change){
        return postService.updateUserPost(name, change);
    }

    @DeleteMapping("/post")
    public Long deletePost(long id){
        return postService.deletePost(id);
    }

}
