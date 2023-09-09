package com.rose.crud.user.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class LoginRequest {
    private String email;
    private String password;
}
