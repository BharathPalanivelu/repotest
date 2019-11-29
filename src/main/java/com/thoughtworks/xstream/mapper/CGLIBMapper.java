package com.thoughtworks.xstream.mapper;

import net.sf.cglib.proxy.Enhancer;

public class CGLIBMapper extends MapperWrapper {
    private static String DEFAULT_NAMING_MARKER = "$$EnhancerByCGLIB$$";
    private final String alias;

    public interface Marker {
    }

    public CGLIBMapper(Mapper mapper) {
        this(mapper, "CGLIB-enhanced-proxy");
    }

    public CGLIBMapper(Mapper mapper, String str) {
        super(mapper);
        this.alias = str;
    }

    public String serializedClass(Class cls) {
        String serializedClass = super.serializedClass(cls);
        if (cls == null) {
            return serializedClass;
        }
        String name = cls.getName();
        return (!name.equals(serializedClass) || name.indexOf(DEFAULT_NAMING_MARKER) <= 0 || !Enhancer.isEnhanced(cls)) ? serializedClass : this.alias;
    }

    public Class realClass(String str) {
        return str.equals(this.alias) ? Marker.class : super.realClass(str);
    }
}
