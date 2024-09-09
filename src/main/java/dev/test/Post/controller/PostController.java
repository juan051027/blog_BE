package dev.test.Post.controller;

import dev.test.Post.domain.SavePostRequestDTO;
import dev.test.Post.service.PostService;
import dev.test.Post.domain.PostEntity;
import dev.test.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.lang.String;
import java.lang.Long;

import java.util.List;


@CrossOrigin("*")
@RequestMapping("/post")
@RestController
public class PostController {

    private final PostService postService;


    public PostController(PostService postService){
        this.postService = postService;
    }

    //이름 제목 내용 입력 online 상태일 시에만 가능 false 면 null 반환
    @PostMapping
    public PostEntity create(@RequestParam(value ="name")String name, @RequestParam(value="title") String title, @RequestParam(value="post") String post){
        return postService.createPost(name, title, post);

    }

    //모든 저장된 PostEntity 불러오기
    @GetMapping("/all")
    public List<PostEntity> getAllPosts(){
        return postService.findPosts();
    }

    //id로 하나의 PostEntity 불러오기
    @GetMapping
    public PostEntity getOnePost(Long id) {
        return postService.findOnePost(id);
    }

    //id 값으로 게시글 찾고 내용 수정하기
    @PutMapping
    public PostEntity updateUserPost(@RequestParam(value = "id") Long id, @RequestParam(value = "post") String change){
        return postService.updateUserPost(id, change);
    }

    //id 값으로 PostEntity 삭제
    @DeleteMapping
    public void deletePost(@RequestBody SavePostRequestDTO savePostRequestDTO){
        postService.deletePost(savePostRequestDTO);
    }

}
