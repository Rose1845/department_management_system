package com.rose.crud.user.role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    MANAGER(
        Set.of(
                Permissions.MANAGER_CREATE,
                Permissions.MANAGER_DELETE,
                Permissions.MANAGER_UPDATE,
                Permissions.MANAGER_READ
        )
    ),
    ADMIN(
            Set.of(
                    Permissions.ADMIN_DELETE,
                    Permissions.ADMIN_UPDATE,
                    Permissions.ADMIN_CREATE,
                    Permissions.ADMIN_READ,
                    Permissions.MANAGER_CREATE,
                    Permissions.MANAGER_DELETE,
                    Permissions.MANAGER_UPDATE,
                    Permissions.MANAGER_READ
            )
    ),
    
    ;
    @Getter
    private final Set<Permissions> permissions;
  public List<SimpleGrantedAuthority> simpleGrantedAuthorities(){
      var authorities = getPermissions()
              .stream()
              .map(permissions -> new SimpleGrantedAuthority(permissions.name()))
              .collect(Collectors.toList());
      authorities.add(new SimpleGrantedAuthority(this.name()));
      return authorities;
  }
}


