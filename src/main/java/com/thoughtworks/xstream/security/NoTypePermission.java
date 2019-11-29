package com.thoughtworks.xstream.security;

public class NoTypePermission implements TypePermission {
    public static final TypePermission NONE = new NoTypePermission();

    public int hashCode() {
        return 1;
    }

    public boolean allows(Class cls) {
        throw new ForbiddenClassException(cls);
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == NoTypePermission.class;
    }
}
