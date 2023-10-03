package com.rose.crud.user.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rose.crud.user.gender.Gender;
import com.rose.crud.user.role.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Data
@Builder
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public  class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Boolean isEnabled = false;
    private String otp;
    private LocalDateTime createdAt;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.simpleGrantedAuthorities();
    }


}
