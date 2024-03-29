package com.thoughtworks.xstream.security;

public class InterfaceTypePermission implements TypePermission {
    public static final TypePermission INTERFACES = new InterfaceTypePermission();

    public int hashCode() {
        return 31;
    }

    public boolean allows(Class cls) {
        return cls != null && cls.isInterface();
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == InterfaceTypePermission.class;
    }
}
