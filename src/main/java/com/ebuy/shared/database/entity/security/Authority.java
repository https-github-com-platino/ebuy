package com.ebuy.shared.database.entity.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Abdur Rahim Nishad
 * @created 22/12/2020 - 5:55 PM
 * @project Ebuy
 */
public class Authority implements GrantedAuthority {
    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
