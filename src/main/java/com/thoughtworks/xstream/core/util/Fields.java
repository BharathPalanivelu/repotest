package com.thoughtworks.xstream.core.util;

import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Fields {
    public static Field locate(Class cls, Class cls2, boolean z) {
        Field field = null;
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                if (Modifier.isStatic(declaredFields[i].getModifiers()) == z && cls2.isAssignableFrom(declaredFields[i].getType())) {
                    field = declaredFields[i];
                }
            }
            if (field != null && !field.isAccessible()) {
                field.setAccessible(true);
            }
        } catch (NoClassDefFoundError | SecurityException unused) {
        }
        return field;
    }

    public static Field find(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException e2) {
            throw new IllegalArgumentException("Could not access " + cls.getName() + "." + str + " field: " + e2.getMessage());
        } catch (NoClassDefFoundError e3) {
            throw new ObjectAccessException("Could not access " + cls.getName() + "." + str + " field: " + e3.getMessage());
        }
    }

    public static void write(Field field, Object obj, Object obj2) {
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e2) {
            throw new ObjectAccessException("Could not write " + field.getType().getName() + "." + field.getName() + " field", e2);
        } catch (NoClassDefFoundError e3) {
            throw new ObjectAccessException("Could not write " + field.getType().getName() + "." + field.getName() + " field", e3);
        }
    }

    public static Object read(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e2) {
            throw new ObjectAccessException("Could not read " + field.getType().getName() + "." + field.getName() + " field", e2);
        } catch (NoClassDefFoundError e3) {
            throw new ObjectAccessException("Could not read " + field.getType().getName() + "." + field.getName() + " field", e3);
        }
    }
}
