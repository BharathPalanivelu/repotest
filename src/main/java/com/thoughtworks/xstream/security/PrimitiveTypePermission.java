package com.thoughtworks.xstream.security;

import com.thoughtworks.xstream.core.util.Primitives;

public class PrimitiveTypePermission implements TypePermission {
    public static final TypePermission PRIMITIVES = new PrimitiveTypePermission();

    public int hashCode() {
        return 7;
    }

    public boolean allows(Class cls) {
        return (cls != null && cls.isPrimitive()) || Primitives.isBoxed(cls);
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == PrimitiveTypePermission.class;
    }
}
