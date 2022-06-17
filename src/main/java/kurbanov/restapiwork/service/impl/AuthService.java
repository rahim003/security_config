package kurbanov.restapiwork.service.impl;

import kurbanov.restapiwork.dto.auth.UserRequestDto;
import kurbanov.restapiwork.dto.auth.UserResponse;
import kurbanov.restapiwork.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public UserResponse authenticate(UserRequestDto authRequest) {
        Authentication authentication;

        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
        ));

        String generatedToken = jwtUtils.generateToken(authentication);

        return UserResponse.builder()
                .email(authRequest.getEmail())
                .token(generatedToken)
                .build();
    }
}
