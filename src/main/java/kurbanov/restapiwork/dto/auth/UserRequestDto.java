package kurbanov.restapiwork.dto.auth;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class UserRequestDto {
    private String email;
    private String password;
}
