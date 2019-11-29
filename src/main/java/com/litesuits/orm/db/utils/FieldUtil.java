package com.litesuits.orm.db.utils;

import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.model.Primarykey;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class FieldUtil {
    public static boolean isIgnored(Field field) {
        return field.getAnnotation(Ignore.class) != null;
    }

    public static boolean isInvalid(Field field) {
        return (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) || isIgnored(field) || field.isSynthetic();
    }

    public static boolean isLong(Field field) {
        return field.getType() == Long.TYPE || field.getType() == Long.class;
    }

    public static boolean isInteger(Field field) {
        return field.getType() == Integer.TYPE || field.getType() != Integer.class;
    }

    public static boolean isSerializable(Field field) {
        for (Class<Serializable> cls : field.getType().getInterfaces()) {
            if (Serializable.class == cls) {
                return true;
            }
        }
        return false;
    }

    public static void set(Field field, Object obj, Object obj2) throws IllegalArgumentException, IllegalAccessException {
        field.setAccessible(true);
        field.set(obj, obj2);
    }

    public static Object get(Field field, Object obj) throws IllegalArgumentException, IllegalAccessException {
        field.setAccessible(true);
        return field.get(obj);
    }

    public static Class<?> getGenericType(Field field) {
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            Type type = ((ParameterizedType) genericType).getActualTypeArguments()[0];
            if (type instanceof Class) {
                return (Class) type;
            }
            return null;
        } else if (genericType instanceof Class) {
            return (Class) genericType;
        } else {
            return null;
        }
    }

    public static Class<?> getComponentType(Field field) {
        return field.getType().getComponentType();
    }

    public static Object getAssignedKeyObject(Primarykey primarykey, Object obj) throws IllegalArgumentException, IllegalAccessException {
        Object obj2 = get(primarykey.field, obj);
        if (primarykey.isAssignedByMyself() || (primarykey.isAssignedBySystem() && obj2 != null && ((Number) obj2).longValue() > 0)) {
            return obj2;
        }
        return null;
    }

    public static boolean setKeyValueIfneed(Object obj, Primarykey primarykey, Object obj2, long j) throws IllegalArgumentException, IllegalAccessException {
        if (primarykey == null || !primarykey.isAssignedBySystem()) {
            return false;
        }
        if (obj2 != null && ((Number) obj2).longValue() >= 1) {
            return false;
        }
        setNumber(obj, primarykey.field, j);
        return true;
    }

    public static List<Field> getAllDeclaredFields(Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        Class<? super Object> cls2 = cls;
        while (cls2 != null && cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            for (Field field : declaredFields) {
                if (!isInvalid(field)) {
                    linkedList.addLast(field);
                }
            }
            cls2 = cls2.getSuperclass();
        }
        return linkedList;
    }

    public static void setNumber(Object obj, Field field, long j) throws IllegalAccessException {
        field.setAccessible(true);
        Class<?> type = field.getType();
        if (type == Long.TYPE) {
            field.setLong(obj, j);
        } else if (type == Integer.TYPE) {
            field.setInt(obj, (int) j);
        } else if (type == Short.TYPE) {
            field.setShort(obj, (short) ((int) j));
        } else if (type == Byte.TYPE) {
            field.setByte(obj, (byte) ((int) j));
        } else if (type == Long.class) {
            field.set(obj, new Long(j));
        } else if (type == Integer.class) {
            field.set(obj, new Integer((int) j));
        } else if (type == Short.class) {
            field.set(obj, new Short((short) ((int) j)));
        } else if (type == Byte.class) {
            field.set(obj, new Byte((byte) ((int) j)));
        } else {
            throw new RuntimeException("field is not a number class");
        }
    }

    public static boolean isNumber(Class<?> cls) {
        return cls == Long.TYPE || cls == Long.class || cls == Integer.TYPE || cls == Integer.class || cls == Short.TYPE || cls == Short.class || cls == Byte.TYPE || cls == Byte.class;
    }
}
