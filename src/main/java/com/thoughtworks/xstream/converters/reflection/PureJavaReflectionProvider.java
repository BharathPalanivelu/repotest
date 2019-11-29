package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.JVM;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class PureJavaReflectionProvider implements ReflectionProvider {
    protected FieldDictionary fieldDictionary;
    private transient Map serializedDataCache;

    public PureJavaReflectionProvider() {
        this(new FieldDictionary(new ImmutableFieldKeySorter()));
    }

    public PureJavaReflectionProvider(FieldDictionary fieldDictionary2) {
        this.fieldDictionary = fieldDictionary2;
        init();
    }

    public Object newInstance(Class cls) {
        try {
            Constructor[] declaredConstructors = cls.getDeclaredConstructors();
            for (Constructor constructor : declaredConstructors) {
                if (constructor.getParameterTypes().length == 0) {
                    if (!constructor.isAccessible()) {
                        constructor.setAccessible(true);
                    }
                    return constructor.newInstance(new Object[0]);
                }
            }
            if (Serializable.class.isAssignableFrom(cls)) {
                return instantiateUsingSerialization(cls);
            }
            throw new ObjectAccessException("Cannot construct " + cls.getName() + " as it does not have a no-args constructor");
        } catch (InstantiationException e2) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e2);
        } catch (IllegalAccessException e3) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e3);
        } catch (InvocationTargetException e4) {
            if (e4.getTargetException() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getTargetException());
            } else if (e4.getTargetException() instanceof Error) {
                throw ((Error) e4.getTargetException());
            } else {
                throw new ObjectAccessException("Constructor for " + cls.getName() + " threw an exception", e4.getTargetException());
            }
        }
    }

    private Object instantiateUsingSerialization(final Class cls) {
        Object readObject;
        try {
            synchronized (this.serializedDataCache) {
                byte[] bArr = (byte[]) this.serializedDataCache.get(cls);
                if (bArr == null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeShort(-21267);
                    dataOutputStream.writeShort(5);
                    dataOutputStream.writeByte(115);
                    dataOutputStream.writeByte(114);
                    dataOutputStream.writeUTF(cls.getName());
                    dataOutputStream.writeLong(ObjectStreamClass.lookup(cls).getSerialVersionUID());
                    dataOutputStream.writeByte(2);
                    dataOutputStream.writeShort(0);
                    dataOutputStream.writeByte(120);
                    dataOutputStream.writeByte(112);
                    bArr = byteArrayOutputStream.toByteArray();
                    this.serializedDataCache.put(cls, bArr);
                }
                readObject = new ObjectInputStream(new ByteArrayInputStream(bArr)) {
                    /* access modifiers changed from: protected */
                    public Class resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                        return Class.forName(objectStreamClass.getName(), false, cls.getClassLoader());
                    }
                }.readObject();
            }
            return readObject;
        } catch (IOException e2) {
            throw new ObjectAccessException("Cannot create " + cls.getName() + " by JDK serialization", e2);
        } catch (ClassNotFoundException e3) {
            throw new ObjectAccessException("Cannot find class " + e3.getMessage(), e3);
        }
    }

    public void visitSerializableFields(Object obj, ReflectionProvider.Visitor visitor) {
        Iterator fieldsFor = this.fieldDictionary.fieldsFor(obj.getClass());
        while (fieldsFor.hasNext()) {
            Field field = (Field) fieldsFor.next();
            if (fieldModifiersSupported(field)) {
                validateFieldAccess(field);
                try {
                    visitor.visit(field.getName(), field.getType(), field.getDeclaringClass(), field.get(obj));
                } catch (IllegalArgumentException e2) {
                    throw new ObjectAccessException("Could not get field " + field.getClass() + "." + field.getName(), e2);
                } catch (IllegalAccessException e3) {
                    throw new ObjectAccessException("Could not get field " + field.getClass() + "." + field.getName(), e3);
                }
            }
        }
    }

    public void writeField(Object obj, String str, Object obj2, Class cls) {
        Field field = this.fieldDictionary.field(obj.getClass(), str, cls);
        validateFieldAccess(field);
        try {
            field.set(obj, obj2);
        } catch (IllegalArgumentException e2) {
            throw new ObjectAccessException("Could not set field " + obj.getClass() + "." + field.getName(), e2);
        } catch (IllegalAccessException e3) {
            throw new ObjectAccessException("Could not set field " + obj.getClass() + "." + field.getName(), e3);
        }
    }

    public Class getFieldType(Object obj, String str, Class cls) {
        return this.fieldDictionary.field(obj.getClass(), str, cls).getType();
    }

    public boolean fieldDefinedInClass(String str, Class cls) {
        Field fieldOrNull = this.fieldDictionary.fieldOrNull(cls, str, (Class) null);
        return fieldOrNull != null && fieldModifiersSupported(fieldOrNull);
    }

    /* access modifiers changed from: protected */
    public boolean fieldModifiersSupported(Field field) {
        int modifiers = field.getModifiers();
        return !Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers);
    }

    /* access modifiers changed from: protected */
    public void validateFieldAccess(Field field) {
        if (!Modifier.isFinal(field.getModifiers())) {
            return;
        }
        if (!JVM.is15()) {
            throw new ObjectAccessException("Invalid final field " + field.getDeclaringClass().getName() + "." + field.getName());
        } else if (!field.isAccessible()) {
            field.setAccessible(true);
        }
    }

    public Field getField(Class cls, String str) {
        return this.fieldDictionary.field(cls, str, (Class) null);
    }

    public Field getFieldOrNull(Class cls, String str) {
        return this.fieldDictionary.fieldOrNull(cls, str, (Class) null);
    }

    public void setFieldDictionary(FieldDictionary fieldDictionary2) {
        this.fieldDictionary = fieldDictionary2;
    }

    private Object readResolve() {
        init();
        return this;
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.serializedDataCache = new WeakHashMap();
    }
}
