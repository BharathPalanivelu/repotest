package com.thoughtworks.xstream.security;

import com.thoughtworks.xstream.mapper.DynamicProxyMapper;
import java.lang.reflect.Proxy;

public class ProxyTypePermission implements TypePermission {
    public static final TypePermission PROXIES = new ProxyTypePermission();

    public int hashCode() {
        return 17;
    }

    public boolean allows(Class cls) {
        return cls != null && (Proxy.isProxyClass(cls) || cls == DynamicProxyMapper.DynamicProxy.class);
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == ProxyTypePermission.class;
    }
}
