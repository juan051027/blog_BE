package dev.test.User.domain;

import lombok.*;
import dev.test.User.domain.UserEntity;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class SaveUserRequestDTO{

    private Long id;
    private String name;
    private String password;
    private Boolean online;

    public static UserEntity toEntity(SaveUserRequestDTO dto){
        return  UserEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .password(dto.getPassword())
                .online(dto.getOnline())
                .build();
    }

}
