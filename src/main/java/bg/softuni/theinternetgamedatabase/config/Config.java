package bg.softuni.theinternetgamedatabase.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class Config {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {


   return  httpSecurity.authorizeHttpRequests(authorize -> authorize
                   // everyone can download static resources (css, js, images)
                   .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                   .requestMatchers("/login", "/register").anonymous()
                   .requestMatchers("/game/add", "/manufacture/add", "/roles/edit").hasAuthority("ADMIN")
                   .anyRequest().authenticated())
           .formLogin(login -> login
                   .loginPage("/login")
                   .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                   .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                   .defaultSuccessUrl("/")
                   .failureUrl("/login"))
           .logout(logout -> logout
                   .logoutUrl("/logout")
                   .logoutSuccessUrl("/login")
                   .deleteCookies("JSESSIONID")
                   .clearAuthentication(true))
           .csrf(AbstractHttpConfigurer::disable)
           .build();
    }
}
