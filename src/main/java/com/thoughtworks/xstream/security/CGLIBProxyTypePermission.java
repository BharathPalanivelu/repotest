package com.thoughtworks.xstream.security;

import net.sf.cglib.proxy.Proxy;

public class CGLIBProxyTypePermission implements TypePermission {
    public static final TypePermission PROXIES = new CGLIBProxyTypePermission();

    public int hashCode() {
        return 19;
    }

    public boolean allows(Class cls) {
        if (!(cls == null || cls == Object.class || cls.isInterface())) {
            if (!Proxy.isProxyClass(cls)) {
                String name = cls.getName();
                if (name.startsWith(Proxy.class.getPackage().getName() + ".")) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == CGLIBProxyTypePermission.class;
    }
}
