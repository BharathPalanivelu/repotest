package com.thoughtworks.xstream.core.util;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import com.thoughtworks.xstream.core.Caching;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SerializationMembers implements Caching {
    private static final Object[] EMPTY_ARGS = new Object[0];
    private static final Class[] EMPTY_CLASSES = new Class[0];
    private static final Map NO_FIELDS = Collections.EMPTY_MAP;
    private static final Method NO_METHOD = new Object() {
        private void noMethod() {
        }
    }.getClass().getDeclaredMethods()[0];
    private static final FastField[] OBJECT_TYPE_FIELDS = {new FastField(Object.class, "readResolve"), new FastField(Object.class, "writeReplace"), new FastField(Object.class, "readObject"), new FastField(Object.class, "writeObject")};
    private static final int PERSISTENT_FIELDS_MODIFIER = 26;
    private Map declaredCache = Collections.synchronizedMap(new HashMap());
    private final Map fieldCache = Collections.synchronizedMap(new HashMap());
    private Map resRepCache = Collections.synchronizedMap(new HashMap());

    public SerializationMembers() {
        int i = 0;
        while (true) {
            FastField[] fastFieldArr = OBJECT_TYPE_FIELDS;
            if (i >= fastFieldArr.length) {
                break;
            }
            this.declaredCache.put(fastFieldArr[i], NO_METHOD);
            i++;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            this.resRepCache.put(OBJECT_TYPE_FIELDS[i2], NO_METHOD);
        }
    }

    public Object callReadResolve(Object obj) {
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        Method rRMethod = getRRMethod(cls, "readResolve");
        if (rRMethod == null) {
            return obj;
        }
        try {
            return rRMethod.invoke(obj, EMPTY_ARGS);
        } catch (IllegalAccessException e2) {
            throw new ObjectAccessException("Could not call " + cls.getName() + ".readResolve()", e2);
        } catch (InvocationTargetException e3) {
            throw new ObjectAccessException("Could not call " + cls.getName() + ".readResolve()", e3.getTargetException());
        }
    }

    public Object callWriteReplace(Object obj) {
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        Method rRMethod = getRRMethod(cls, "writeReplace");
        if (rRMethod == null) {
            return obj;
        }
        try {
            return rRMethod.invoke(obj, EMPTY_ARGS);
        } catch (IllegalAccessException e2) {
            throw new ObjectAccessException("Could not call " + cls.getName() + ".writeReplace()", e2);
        } catch (InvocationTargetException e3) {
            throw new ObjectAccessException("Could not call " + cls.getName() + ".writeReplace()", e3.getTargetException());
        }
    }

    public boolean supportsReadObject(Class cls, boolean z) {
        return getMethod(cls, "readObject", new Class[]{ObjectInputStream.class}, z) != null;
    }

    public void callReadObject(Class cls, Object obj, ObjectInputStream objectInputStream) {
        try {
            getMethod(cls, "readObject", new Class[]{ObjectInputStream.class}, false).invoke(obj, new Object[]{objectInputStream});
        } catch (IllegalAccessException e2) {
            throw new ConversionException("Could not call " + obj.getClass().getName() + ".readObject()", e2);
        } catch (InvocationTargetException e3) {
            throw new ConversionException("Could not call " + obj.getClass().getName() + ".readObject()", e3.getTargetException());
        }
    }

    public boolean supportsWriteObject(Class cls, boolean z) {
        return getMethod(cls, "writeObject", new Class[]{ObjectOutputStream.class}, z) != null;
    }

    public void callWriteObject(Class cls, Object obj, ObjectOutputStream objectOutputStream) {
        try {
            getMethod(cls, "writeObject", new Class[]{ObjectOutputStream.class}, false).invoke(obj, new Object[]{objectOutputStream});
        } catch (IllegalAccessException e2) {
            throw new ConversionException("Could not call " + obj.getClass().getName() + ".writeObject()", e2);
        } catch (InvocationTargetException e3) {
            throw new ConversionException("Could not call " + obj.getClass().getName() + ".writeObject()", e3.getTargetException());
        }
    }

    private Method getMethod(Class cls, String str, Class[] clsArr, boolean z) {
        Method method = getMethod(cls, str, clsArr);
        if (method == NO_METHOD || (!z && !method.getDeclaringClass().equals(cls))) {
            return null;
        }
        return method;
    }

    private Method getMethod(Class cls, String str, Class[] clsArr) {
        if (cls == null) {
            return null;
        }
        FastField fastField = new FastField(cls, str);
        Method method = (Method) this.declaredCache.get(fastField);
        if (method == null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
            } catch (NoSuchMethodException unused) {
                method = getMethod(cls.getSuperclass(), str, clsArr);
            }
            this.declaredCache.put(fastField, method);
        }
        return method;
    }

    private Method getRRMethod(Class cls, String str) {
        Method method;
        FastField fastField = new FastField(cls, str);
        Method method2 = (Method) this.resRepCache.get(fastField);
        if (method2 == null) {
            Method method3 = getMethod(cls, str, EMPTY_CLASSES, true);
            if (method3 == null || method3.getDeclaringClass() == cls) {
                if (method3 == null) {
                    method = NO_METHOD;
                }
                method2 = method3;
                this.resRepCache.put(fastField, method2);
            } else {
                if ((method3.getModifiers() & 5) == 0 && ((method3.getModifiers() & 2) > 0 || cls.getPackage() != method3.getDeclaringClass().getPackage())) {
                    method = NO_METHOD;
                }
                method2 = method3;
                this.resRepCache.put(fastField, method2);
            }
            method2 = method;
            this.resRepCache.put(fastField, method2);
        }
        if (method2 == NO_METHOD) {
            return null;
        }
        return method2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
        throw new com.thoughtworks.xstream.converters.reflection.ObjectAccessException("Cannot get " + r9.getName() + ".serialPersistentFields.", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0069, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0085, code lost:
        throw new com.thoughtworks.xstream.converters.reflection.ObjectAccessException("Cannot get " + r9.getName() + ".serialPersistentFields.", r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c A[ExcHandler: ClassCastException (r2v3 'e' java.lang.ClassCastException A[CUSTOM_DECLARE]), Splitter:B:6:0x0018] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069 A[ExcHandler: IllegalAccessException (r2v2 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:6:0x0018] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map getSerializablePersistentFields(java.lang.Class r9) {
        /*
            r8 = this;
            java.lang.String r0 = ".serialPersistentFields."
            java.lang.String r1 = "Cannot get "
            r2 = 0
            if (r9 != 0) goto L_0x0008
            return r2
        L_0x0008:
            java.util.Map r3 = r8.fieldCache
            java.lang.String r4 = r9.getName()
            java.lang.Object r3 = r3.get(r4)
            java.util.Map r3 = (java.util.Map) r3
            if (r3 != 0) goto L_0x0093
            java.lang.String r4 = "serialPersistentFields"
            java.lang.reflect.Field r4 = r9.getDeclaredField(r4)     // Catch:{ NoSuchFieldException -> 0x0086, IllegalAccessException -> 0x0069, ClassCastException -> 0x004c }
            int r5 = r4.getModifiers()     // Catch:{ NoSuchFieldException -> 0x0086, IllegalAccessException -> 0x0069, ClassCastException -> 0x004c }
            r6 = 26
            r5 = r5 & r6
            if (r5 != r6) goto L_0x0086
            r5 = 1
            r4.setAccessible(r5)     // Catch:{ NoSuchFieldException -> 0x0086, IllegalAccessException -> 0x0069, ClassCastException -> 0x004c }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ NoSuchFieldException -> 0x0086, IllegalAccessException -> 0x0069, ClassCastException -> 0x004c }
            java.io.ObjectStreamField[] r4 = (java.io.ObjectStreamField[]) r4     // Catch:{ NoSuchFieldException -> 0x0086, IllegalAccessException -> 0x0069, ClassCastException -> 0x004c }
            java.io.ObjectStreamField[] r4 = (java.io.ObjectStreamField[]) r4     // Catch:{ NoSuchFieldException -> 0x0086, IllegalAccessException -> 0x0069, ClassCastException -> 0x004c }
            if (r4 == 0) goto L_0x0086
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ NoSuchFieldException -> 0x0086, IllegalAccessException -> 0x0069, ClassCastException -> 0x004c }
            r5.<init>()     // Catch:{ NoSuchFieldException -> 0x0086, IllegalAccessException -> 0x0069, ClassCastException -> 0x004c }
            r3 = 0
        L_0x0039:
            int r6 = r4.length     // Catch:{ NoSuchFieldException -> 0x004a, IllegalAccessException -> 0x0069, ClassCastException -> 0x004c }
            if (r3 >= r6) goto L_0x004a
            r6 = r4[r3]     // Catch:{ NoSuchFieldException -> 0x004a, IllegalAccessException -> 0x0069, ClassCastException -> 0x004c }
            java.lang.String r6 = r6.getName()     // Catch:{ NoSuchFieldException -> 0x004a, IllegalAccessException -> 0x0069, ClassCastException -> 0x004c }
            r7 = r4[r3]     // Catch:{ NoSuchFieldException -> 0x004a, IllegalAccessException -> 0x0069, ClassCastException -> 0x004c }
            r5.put(r6, r7)     // Catch:{ NoSuchFieldException -> 0x004a, IllegalAccessException -> 0x0069, ClassCastException -> 0x004c }
            int r3 = r3 + 1
            goto L_0x0039
        L_0x004a:
            r3 = r5
            goto L_0x0086
        L_0x004c:
            r2 = move-exception
            com.thoughtworks.xstream.converters.reflection.ObjectAccessException r3 = new com.thoughtworks.xstream.converters.reflection.ObjectAccessException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r9 = r9.getName()
            r4.append(r9)
            r4.append(r0)
            java.lang.String r9 = r4.toString()
            r3.<init>(r9, r2)
            throw r3
        L_0x0069:
            r2 = move-exception
            com.thoughtworks.xstream.converters.reflection.ObjectAccessException r3 = new com.thoughtworks.xstream.converters.reflection.ObjectAccessException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r9 = r9.getName()
            r4.append(r9)
            r4.append(r0)
            java.lang.String r9 = r4.toString()
            r3.<init>(r9, r2)
            throw r3
        L_0x0086:
            if (r3 != 0) goto L_0x008a
            java.util.Map r3 = NO_FIELDS
        L_0x008a:
            java.util.Map r0 = r8.fieldCache
            java.lang.String r9 = r9.getName()
            r0.put(r9, r3)
        L_0x0093:
            java.util.Map r9 = NO_FIELDS
            if (r3 != r9) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r2 = r3
        L_0x0099:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.core.util.SerializationMembers.getSerializablePersistentFields(java.lang.Class):java.util.Map");
    }

    public void flushCache() {
        this.declaredCache.keySet().retainAll(Arrays.asList(OBJECT_TYPE_FIELDS));
        this.resRepCache.keySet().retainAll(Arrays.asList(OBJECT_TYPE_FIELDS));
    }
}
