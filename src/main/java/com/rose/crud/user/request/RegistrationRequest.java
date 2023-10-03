package com.rose.crud.user.request;

import com.rose.crud.user.gender.Gender;
import com.rose.crud.user.role.Role;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class RegistrationRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Gender gender;
    private Role role;

}
