package com.module.securityModule.config;

import com.module.securityModule.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/", true)
                )
                .logout(logout -> logout.permitAll());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

        User user = new User("user", passwordEncoder.encode("user123"), "ROLE_USER");
        User organizer = new User("organizer", passwordEncoder.encode("organizer123"), "ROLE_ORGANIZER");
        User admin = new User("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN");

        return new InMemoryUserDetailsManager(user, organizer, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
