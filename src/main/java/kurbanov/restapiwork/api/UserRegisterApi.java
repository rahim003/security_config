package kurbanov.restapiwork.api;

import kurbanov.restapiwork.dto.auth.UserRequestDto;
import kurbanov.restapiwork.dto.auth.UserResponse;
import kurbanov.restapiwork.service.impl.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/api/authentication")
@AllArgsConstructor
public class UserRegisterApi {

    private final AuthService authService;

    @PostMapping
    @PermitAll
    public UserResponse authenticate(@RequestBody UserRequestDto authRequest) {
        return authService.authenticate(authRequest);
    }
}
