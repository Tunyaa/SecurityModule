package com.module.securityModule.model;

import java.util.Collection;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 *
 * @author tunyaa
 */
@Data
@NoArgsConstructor
public class User {

    private String username;
    private String password;
    private String email;
    private String role = "ROLE_USER"; // ROLE_USER \ ROLE_ORGANIZER \ ROLE_ADMIN

}
