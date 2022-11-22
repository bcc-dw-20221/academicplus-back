package com.academicplus.domain.systemuser;

public enum Role {
    ROLE_ADMIN(1, "ROLE_ADMIN"),
    ROLE_STUDENT(2, "ROLE_STUDENT"),
    ROLE_PROFESSOR(3, "ROLE_PROFESSOR"),
    ROLE_ROOT(4, "ROLE_ROOT");

    private final int key;
    private final String value;

    Role(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
