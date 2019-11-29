package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import java.lang.reflect.Field;

public class ReflectionProviderWrapper implements ReflectionProvider {
    protected final ReflectionProvider wrapped;

    public ReflectionProviderWrapper(ReflectionProvider reflectionProvider) {
        this.wrapped = reflectionProvider;
    }

    public boolean fieldDefinedInClass(String str, Class cls) {
        return this.wrapped.fieldDefinedInClass(str, cls);
    }

    public Field getField(Class cls, String str) {
        return this.wrapped.getField(cls, str);
    }

    public Field getFieldOrNull(Class cls, String str) {
        return this.wrapped.getFieldOrNull(cls, str);
    }

    public Class getFieldType(Object obj, String str, Class cls) {
        return this.wrapped.getFieldType(obj, str, cls);
    }

    public Object newInstance(Class cls) {
        return this.wrapped.newInstance(cls);
    }

    public void visitSerializableFields(Object obj, ReflectionProvider.Visitor visitor) {
        this.wrapped.visitSerializableFields(obj, visitor);
    }

    public void writeField(Object obj, String str, Object obj2, Class cls) {
        this.wrapped.writeField(obj, str, obj2, cls);
    }
}
