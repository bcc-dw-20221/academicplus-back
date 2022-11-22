package com.academicplus.domain.systemuser;

import com.academicplus.domain.Identifier;

import java.util.List;

public class SystemUser {
    private SystemUserID identifier;
    private String username;
    private String password;
    private List<Role> roles;

    public SystemUser(SystemUserID identifier, String username, String password, List<Role> roles) {
        this.identifier = identifier;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public static SystemUser create(SystemUserID identifier, String username, String password, List<Role> roles) {
        return new SystemUser(identifier, username, password, roles);
    }

    public SystemUserID getIdentifier() {
        return identifier;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
