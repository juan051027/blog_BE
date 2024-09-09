package dev.test.Post.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import dev.test.Post.domain.SavePostRequestDTO;

import java.lang.Long;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String content;
}
