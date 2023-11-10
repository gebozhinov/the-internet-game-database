package bg.softuni.theinternetgamedatabase.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
public class Config {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {


     httpSecurity.authorizeHttpRequests((authorize) -> authorize
             // everyone can download static resources (css, js, images)
             .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
             // everyone can log in and register
             .requestMatchers("/", "/login", "/register").permitAll());


     return httpSecurity.build();
    }
}
