package dev.test.Post.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ChangeContentRequestDTO {
    private Long id;
    private String name;
    private String title;
    private String content;
}
