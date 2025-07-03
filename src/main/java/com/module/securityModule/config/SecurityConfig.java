package com.module.securityModule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

/**
 *
 * @author tunyaa
 */
@Configuration
@EnableWebSecurity // Открывает доступ к настройке компонентов безопасности
public class SecurityConfig {

    @Bean // Метод определяет как будут обрабатываться HTTP-запросы(аутентификация, авторизация, защита от атак)
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/").permitAll()
                .requestMatchers("/user").authenticated()
                .requestMatchers("/organizer").hasAnyRole("ORGANIZER", "ADMIN")
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                .loginPage("/login").permitAll()
                );
        return http.build();
    }
}
