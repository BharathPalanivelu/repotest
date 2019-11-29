package com.thoughtworks.xstream.converters.reflection;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.WeakHashMap;

public class SunUnsafeReflectionProvider extends SunLimitedUnsafeReflectionProvider {
    private transient Map fieldOffsetCache;

    public SunUnsafeReflectionProvider() {
    }

    public SunUnsafeReflectionProvider(FieldDictionary fieldDictionary) {
        super(fieldDictionary);
    }

    public void writeField(Object obj, String str, Object obj2, Class cls) {
        write(this.fieldDictionary.field(obj.getClass(), str, cls), obj, obj2);
    }

    private void write(Field field, Object obj, Object obj2) {
        if (exception == null) {
            try {
                long fieldOffset = getFieldOffset(field);
                Class<?> type = field.getType();
                if (!type.isPrimitive()) {
                    unsafe.putObject(obj, fieldOffset, obj2);
                } else if (type.equals(Integer.TYPE)) {
                    unsafe.putInt(obj, fieldOffset, ((Integer) obj2).intValue());
                } else if (type.equals(Long.TYPE)) {
                    unsafe.putLong(obj, fieldOffset, ((Long) obj2).longValue());
                } else if (type.equals(Short.TYPE)) {
                    unsafe.putShort(obj, fieldOffset, ((Short) obj2).shortValue());
                } else if (type.equals(Character.TYPE)) {
                    unsafe.putChar(obj, fieldOffset, ((Character) obj2).charValue());
                } else if (type.equals(Byte.TYPE)) {
                    unsafe.putByte(obj, fieldOffset, ((Byte) obj2).byteValue());
                } else if (type.equals(Float.TYPE)) {
                    unsafe.putFloat(obj, fieldOffset, ((Float) obj2).floatValue());
                } else if (type.equals(Double.TYPE)) {
                    unsafe.putDouble(obj, fieldOffset, ((Double) obj2).doubleValue());
                } else if (type.equals(Boolean.TYPE)) {
                    unsafe.putBoolean(obj, fieldOffset, ((Boolean) obj2).booleanValue());
                } else {
                    throw new ObjectAccessException("Could not set field " + obj.getClass() + "." + field.getName() + ": Unknown type " + type);
                }
            } catch (IllegalArgumentException e2) {
                throw new ObjectAccessException("Could not set field " + obj.getClass() + "." + field.getName(), e2);
            }
        } else {
            throw new ObjectAccessException("Could not set field " + obj.getClass() + "." + field.getName(), exception);
        }
    }

    private synchronized long getFieldOffset(Field field) {
        Long l;
        l = (Long) this.fieldOffsetCache.get(field);
        if (l == null) {
            l = new Long(unsafe.objectFieldOffset(field));
            this.fieldOffsetCache.put(field, l);
        }
        return l.longValue();
    }

    private Object readResolve() {
        init();
        return this;
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.fieldOffsetCache = new WeakHashMap();
    }
}
