package dev.test.Post.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class SavePostResponseDTO {
    private Long id;
    private String name;
    private String title;
    private String context;

    public static PostEntity toEntity(SavePostResponseDTO dto){
        return  PostEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .title(dto.getTitle())
                .content(dto.getContext())
                .build();
    }
}
