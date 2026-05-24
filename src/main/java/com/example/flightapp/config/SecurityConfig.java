package com.example.flightapp.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.http.HttpStatus;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index.html", "/oauth2-demo.html", "/error/**").permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(ex -> ex
                        .defaultAuthenticationEntryPointFor(
                                new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED),
                                request -> request.getHeader("X-Requested-With") != null
                                        || (request.getHeader("Accept") != null
                                            && request.getHeader("Accept").contains("application/json"))
                        )
                )
                .csrf(csrf -> csrf.disable())
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/oauth2-demo.html", true)
                        .failureUrl("/oauth2-demo.html?error=true")
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/oauth2-demo.html?logout=true")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );
        return http.build();
    }
}
