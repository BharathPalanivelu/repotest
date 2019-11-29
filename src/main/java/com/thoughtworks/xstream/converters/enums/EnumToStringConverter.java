package com.thoughtworks.xstream.converters.enums;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EnumToStringConverter<T extends Enum<T>> extends AbstractSingleValueConverter {
    private final Class<T> enumType;
    private final Map<String, T> strings;
    private final EnumMap<T, String> values;

    public EnumToStringConverter(Class<T> cls) {
        this(cls, extractStringMap(cls), (EnumMap) null);
    }

    public EnumToStringConverter(Class<T> cls, Map<String, T> map) {
        this(cls, map, buildValueMap(cls, map));
    }

    private EnumToStringConverter(Class<T> cls, Map<String, T> map, EnumMap<T, String> enumMap) {
        this.enumType = cls;
        this.strings = map;
        this.values = enumMap;
    }

    private static <T extends Enum<T>> Map<String, T> extractStringMap(Class<T> cls) {
        checkType(cls);
        EnumSet<E> allOf = EnumSet.allOf(cls);
        HashMap hashMap = new HashMap(allOf.size());
        Iterator it = allOf.iterator();
        while (it.hasNext()) {
            Enum enumR = (Enum) it.next();
            if (hashMap.put(enumR.toString(), enumR) != null) {
                throw new IllegalArgumentException("Enum type " + cls.getName() + " does not have unique string representations for its values");
            }
        }
        return hashMap;
    }

    private static <T> void checkType(Class<T> cls) {
        if (!Enum.class.isAssignableFrom(cls) && cls != Enum.class) {
            throw new IllegalArgumentException("Converter can only handle enum types");
        }
    }

    private static <T extends Enum<T>> EnumMap<T, String> buildValueMap(Class<T> cls, Map<String, T> map) {
        EnumMap<T, String> enumMap = new EnumMap<>(cls);
        for (Map.Entry next : map.entrySet()) {
            enumMap.put((Enum) next.getValue(), next.getKey());
        }
        return enumMap;
    }

    public boolean canConvert(Class cls) {
        return this.enumType.isAssignableFrom(cls);
    }

    public String toString(Object obj) {
        Enum cast = Enum.class.cast(obj);
        EnumMap<T, String> enumMap = this.values;
        return enumMap == null ? cast.toString() : enumMap.get(cast);
    }

    public Object fromString(String str) {
        if (str == null) {
            return null;
        }
        Enum enumR = (Enum) this.strings.get(str);
        if (enumR != null) {
            return enumR;
        }
        throw new ConversionException("Invalid string representation for enum type " + this.enumType.getName() + ": <" + str + SimpleComparison.GREATER_THAN_OPERATION);
    }
}
