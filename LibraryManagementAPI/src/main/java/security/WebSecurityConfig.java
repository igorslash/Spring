package security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import service.UserService;

@EqualsAndHashCode(callSuper = true)
@EnableWebSecurity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class WebSecurityConfig extends WebSecurityConfiguration {

    private UserService userService;

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.getDefaultUserDetailsService().loadUserByUsername(String.valueOf(userService
                .findByUsername(String.valueOf(userService)).getId()));
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}