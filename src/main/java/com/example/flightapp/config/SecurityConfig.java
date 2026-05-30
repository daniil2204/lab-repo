package com.example.flightapp.config;

import com.example.flightapp.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.http.HttpStatus;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            var userProfile = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
            var authorities = userProfile.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .toList();
            return new User(userProfile.getUsername(), userProfile.getPassword(), authorities);
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index.html", "/oauth2-demo.html", "/error/**").permitAll()
                        .anyRequest().authenticated()
                )
                // exceptionHandling temporarily disabled for Lab 4 (conflicts with httpBasic popup)
                // .exceptionHandling(ex -> ex
                //         .defaultAuthenticationEntryPointFor(
                //                 new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED),
                //                 request -> request.getHeader("X-Requested-With") != null
                //                         || (request.getHeader("Accept") != null
                //                             && request.getHeader("Accept").contains("application/json"))
                //         )
                // )
                .csrf(csrf -> csrf.disable())
                .httpBasic(basic -> {});
                // OAuth2 temporarily disabled for Lab 4 (AWS RDS)
                // .oauth2Login(oauth2 -> oauth2
                //         .defaultSuccessUrl("/oauth2-demo.html", true)
                //         .failureUrl("/oauth2-demo.html?error=true")
                // )
                // .logout(logout -> logout
                //         .logoutSuccessUrl("/oauth2-demo.html?logout=true")
                //         .invalidateHttpSession(true)
                //         .deleteCookies("JSESSIONID")
                // );
        return http.build();
    }
}
