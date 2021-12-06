package com.sha.springbootbookseller.util;

import com.sha.springbootbookseller.model.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SecurityUtils {

    public static final String Role_PREFIX="ROLE_";

    public static SimpleGrantedAuthority convertToAuthority(String role)
    {
        String formattedRole = role.startsWith(Role_PREFIX) ? role : Role_PREFIX+role;
        return new SimpleGrantedAuthority(formattedRole);
    }
}
