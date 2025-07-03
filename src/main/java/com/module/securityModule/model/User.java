package com.module.securityModule.model;



/**
 *
 * @author tunyaa
 */
//@Data
//@NoArgsConstructor
public class User {

    private String username;
    private String password;
    private String email;
    private String role = "ROLE_USER"; // ROLE_USER \ ROLE_ORGANIZER \ ROLE_ADMIN

}
