package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.mapper.Mapper;

public class ReflectionConverter extends AbstractReflectionConverter {
    private static final Class eventHandlerType = JVM.loadClassForName("java.beans.EventHandler");
    private Class type;

    public ReflectionConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider);
    }

    public ReflectionConverter(Mapper mapper, ReflectionProvider reflectionProvider, Class cls) {
        this(mapper, reflectionProvider);
        this.type = cls;
    }

    public boolean canConvert(Class cls) {
        Class cls2 = this.type;
        return ((cls2 != null && cls2 == cls) || !(this.type != null || cls == null || cls == eventHandlerType)) && canAccess(cls);
    }
}
