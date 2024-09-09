package dev.test.Post.domain;

import lombok.*;
import dev.test.Post.domain.PostEntity;

@Getter

public class SavePostRequestDTO{

    private Long id;
    private String name;
    private String title;
    private String context;

    public static PostEntity toEntity(SavePostRequestDTO dto){
        return  PostEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .title(dto.getTitle())
                .content(dto.getContext())
                .build();
    }

}
