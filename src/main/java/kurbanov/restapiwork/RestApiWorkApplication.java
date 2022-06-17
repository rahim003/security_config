package kurbanov.restapiwork;

import kurbanov.restapiwork.entity.Role;
import kurbanov.restapiwork.entity.User;
import kurbanov.restapiwork.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
@AllArgsConstructor
public class RestApiWorkApplication {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(RestApiWorkApplication.class, args);
        
    }
    @PostConstruct
    public void init() {
        User user = new User();
        user.setName("Essen");
        user.setEmail("esen@gmail.com");
        user.setPassword(passwordEncoder.encode("123123"));
        user.setRole(Role.ADMIN);
        user.setSurname("Niyazov");
        userRepository.save(user);
    }
}
