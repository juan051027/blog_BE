package dev.test.User.domain;

import dev.test.User.domain.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class SaveUserResponseDTO {
    private Long id;
    private String name;
    private String password;
    private Boolean online;

    public static UserEntity toEntity(SaveUserResponseDTO dto){
        return  UserEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .password(dto.getPassword())
                .online(dto.getOnline())
                .build();
    }
}
