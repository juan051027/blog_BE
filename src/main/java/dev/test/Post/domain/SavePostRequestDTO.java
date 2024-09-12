package dev.test.Post.domain;

import lombok.*;
import dev.test.Post.domain.PostEntity;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SavePostRequestDTO{

    private String name;
    private String title;
    private String content;

    public static PostEntity toEntity(SavePostRequestDTO dto){
        return  PostEntity.builder()
                .name(dto.getName())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

}
