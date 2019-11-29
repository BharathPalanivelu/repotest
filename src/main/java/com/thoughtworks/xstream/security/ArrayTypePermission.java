package com.thoughtworks.xstream.security;

public class ArrayTypePermission implements TypePermission {
    public static final TypePermission ARRAYS = new ArrayTypePermission();

    public int hashCode() {
        return 13;
    }

    public boolean allows(Class cls) {
        return cls != null && cls.isArray();
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == ArrayTypePermission.class;
    }
}
