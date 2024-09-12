package dev.test.Post.controller;

import dev.test.Post.domain.ChangeContentRequestDTO;
import dev.test.Post.domain.DeletePostRequestDTO;
import dev.test.Post.domain.SavePostRequestDTO;
import dev.test.Post.service.PostCRUDService;
import dev.test.Post.domain.PostEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.String;
import java.lang.Long;

import java.util.List;


@CrossOrigin("*")
@RequestMapping("/post")
@RestController
public class PostController {

    private final PostCRUDService postCRUDService;


    public PostController(PostCRUDService postCRUDService){
        this.postCRUDService = postCRUDService;
    }

    //이름 제목 내용 입력 online 상태일 시에만 가능 false 면 null 반환
    @PostMapping
    public PostEntity create(@RequestBody SavePostRequestDTO savePostRequestDTO){

        return postCRUDService.createPost(savePostRequestDTO);

    }

    //모든 저장된 PostEntity 불러오기
    @GetMapping("/all")
    public List<PostEntity> getAllPosts(){
        return postCRUDService.findPosts();
    }

    //id로 하나의 PostEntity 불러오기
    @GetMapping
    public PostEntity getOnePost(@RequestParam(value = "id") Long id) {
        return postCRUDService.findOnePost(id);
    }

    //id 값으로 게시글 찾고 내용 수정하기
    @PutMapping
    public PostEntity updateUserPost(@RequestBody ChangeContentRequestDTO changeContentRequestDTO){
        return postCRUDService.changePostContent(changeContentRequestDTO)   ;
    }

    //id 값으로 PostEntity 삭제
    @DeleteMapping
    public void deletePost(@RequestBody DeletePostRequestDTO deletePostRequestDTO){
        PostEntity postEntity = new PostEntity();
        postEntity.setId(deletePostRequestDTO.getId());
        postCRUDService.deletePost(deletePostRequestDTO);
    }

}
