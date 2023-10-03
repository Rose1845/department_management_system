package com.rose.crud.user.role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permissions {
    ADMIN_CREATE("POST"),
    ADMIN_DELETE("DELETE"),
    ADMIN_READ("READ"),
    ADMIN_UPDATE("UPDATE"),


    MANAGER_CREATE("POST"),
    MANAGER_DELETE("DELETE"),
    MANAGER_READ("READ"),
    MANAGER_UPDATE("UPDDATE"),
    ;
    @Getter
    private final String permission;

}
