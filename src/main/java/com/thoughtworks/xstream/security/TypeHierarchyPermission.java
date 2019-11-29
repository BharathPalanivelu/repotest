package com.thoughtworks.xstream.security;

public class TypeHierarchyPermission implements TypePermission {
    private Class type;

    public TypeHierarchyPermission(Class cls) {
        this.type = cls;
    }

    public boolean allows(Class cls) {
        if (cls == null) {
            return false;
        }
        return this.type.isAssignableFrom(cls);
    }
}
