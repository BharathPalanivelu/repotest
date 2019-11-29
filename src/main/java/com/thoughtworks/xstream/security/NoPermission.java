package com.thoughtworks.xstream.security;

public class NoPermission implements TypePermission {
    private final TypePermission permission;

    public NoPermission(TypePermission typePermission) {
        this.permission = typePermission;
    }

    public boolean allows(Class cls) {
        TypePermission typePermission = this.permission;
        if (typePermission != null && !typePermission.allows(cls)) {
            return false;
        }
        throw new ForbiddenClassException(cls);
    }
}
