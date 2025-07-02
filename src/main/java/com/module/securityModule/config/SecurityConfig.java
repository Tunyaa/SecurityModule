package com.module.securityModule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

/**
 *
 * @author tunyaa
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/user").permitAll()
                .requestMatchers("/admin").hasRole("ROLE_ADMIN")
                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                .loginPage("/login").permitAll()
                );
        return http.build();
    }
}
