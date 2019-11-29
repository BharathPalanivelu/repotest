package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.core.util.Types;
import com.thoughtworks.xstream.mapper.Mapper;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class LambdaMapper extends MapperWrapper {
    public LambdaMapper(Mapper mapper) {
        super(mapper);
    }

    public String serializedClass(Class<Mapper.Null> cls) {
        Class<Mapper.Null> cls2 = null;
        if (Types.isLambdaType(cls)) {
            if (Serializable.class.isAssignableFrom(cls)) {
                Class<Mapper.Null>[] interfaces = cls.getInterfaces();
                if (interfaces.length > 1) {
                    int i = 0;
                    while (cls2 == null && i < interfaces.length) {
                        Class<Mapper.Null> cls3 = interfaces[i];
                        Method[] methods = cls3.getMethods();
                        int length = methods.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            Method method = methods[i2];
                            if (!method.isDefault() && !Modifier.isStatic(method.getModifiers())) {
                                cls2 = cls3;
                                break;
                            }
                            i2++;
                        }
                        i++;
                    }
                } else {
                    cls2 = interfaces[0];
                }
            } else {
                cls2 = Mapper.Null.class;
            }
        }
        if (cls2 != null) {
            cls = cls2;
        }
        return super.serializedClass(cls);
    }
}
