package com.rose.crud.user.registration;

import lombok.*;

@Data
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class RegistrationRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
