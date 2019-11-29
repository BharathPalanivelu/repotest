package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.core.Caching;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FieldDictionary implements Caching {
    private transient Map keyedByFieldKeyCache;
    private transient Map keyedByFieldNameCache;
    private final FieldKeySorter sorter;

    public FieldDictionary() {
        this(new ImmutableFieldKeySorter());
    }

    public FieldDictionary(FieldKeySorter fieldKeySorter) {
        this.sorter = fieldKeySorter;
        init();
    }

    private void init() {
        this.keyedByFieldNameCache = new HashMap();
        this.keyedByFieldKeyCache = new HashMap();
        this.keyedByFieldNameCache.put(Object.class, Collections.EMPTY_MAP);
        this.keyedByFieldKeyCache.put(Object.class, Collections.EMPTY_MAP);
    }

    public Iterator serializableFieldsFor(Class cls) {
        return fieldsFor(cls);
    }

    public Iterator fieldsFor(Class cls) {
        return buildMap(cls, true).values().iterator();
    }

    public Field field(Class cls, String str, Class cls2) {
        Field fieldOrNull = fieldOrNull(cls, str, cls2);
        if (fieldOrNull != null) {
            return fieldOrNull;
        }
        throw new MissingFieldException(cls.getName(), str);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.thoughtworks.xstream.converters.reflection.FieldKey] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.reflect.Field fieldOrNull(java.lang.Class r3, java.lang.String r4, java.lang.Class r5) {
        /*
            r2 = this;
            if (r5 == 0) goto L_0x0004
            r0 = 1
            goto L_0x0005
        L_0x0004:
            r0 = 0
        L_0x0005:
            java.util.Map r3 = r2.buildMap(r3, r0)
            if (r5 == 0) goto L_0x0012
            com.thoughtworks.xstream.converters.reflection.FieldKey r0 = new com.thoughtworks.xstream.converters.reflection.FieldKey
            r1 = -1
            r0.<init>(r4, r5, r1)
            r4 = r0
        L_0x0012:
            java.lang.Object r3 = r3.get(r4)
            java.lang.reflect.Field r3 = (java.lang.reflect.Field) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.converters.reflection.FieldDictionary.fieldOrNull(java.lang.Class, java.lang.String, java.lang.Class):java.lang.reflect.Field");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d5, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        if (r13 == false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d9, code lost:
        r12 = r11.keyedByFieldKeyCache.get(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e0, code lost:
        r12 = r11.keyedByFieldNameCache.get(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ea, code lost:
        return (java.util.Map) r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map buildMap(java.lang.Class r12, boolean r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.Map r0 = r11.keyedByFieldNameCache     // Catch:{ all -> 0x00eb }
            boolean r0 = r0.containsKey(r12)     // Catch:{ all -> 0x00eb }
            if (r0 != 0) goto L_0x00d6
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00eb }
            r0.<init>()     // Catch:{ all -> 0x00eb }
        L_0x000e:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            boolean r1 = r1.equals(r12)     // Catch:{ all -> 0x00eb }
            r2 = 0
            if (r1 != 0) goto L_0x0021
            if (r12 == 0) goto L_0x0021
            r0.add(r2, r12)     // Catch:{ all -> 0x00eb }
            java.lang.Class r12 = r12.getSuperclass()     // Catch:{ all -> 0x00eb }
            goto L_0x000e
        L_0x0021:
            java.util.Map r12 = java.util.Collections.EMPTY_MAP     // Catch:{ all -> 0x00eb }
            java.util.Map r1 = java.util.Collections.EMPTY_MAP     // Catch:{ all -> 0x00eb }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00eb }
        L_0x0029:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x00eb }
            if (r3 == 0) goto L_0x00d1
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x00eb }
            java.lang.Class r3 = (java.lang.Class) r3     // Catch:{ all -> 0x00eb }
            java.util.Map r4 = r11.keyedByFieldNameCache     // Catch:{ all -> 0x00eb }
            boolean r4 = r4.containsKey(r3)     // Catch:{ all -> 0x00eb }
            if (r4 != 0) goto L_0x00bf
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x00eb }
            r4.<init>(r12)     // Catch:{ all -> 0x00eb }
            com.thoughtworks.xstream.core.util.OrderRetainingMap r12 = new com.thoughtworks.xstream.core.util.OrderRetainingMap     // Catch:{ all -> 0x00eb }
            r12.<init>(r1)     // Catch:{ all -> 0x00eb }
            java.lang.reflect.Field[] r1 = r3.getDeclaredFields()     // Catch:{ all -> 0x00eb }
            boolean r5 = com.thoughtworks.xstream.core.JVM.reverseFieldDefinition()     // Catch:{ all -> 0x00eb }
            r6 = 1
            if (r5 == 0) goto L_0x0065
            int r5 = r1.length     // Catch:{ all -> 0x00eb }
            int r5 = r5 >> r6
        L_0x0054:
            int r7 = r5 + -1
            if (r5 <= 0) goto L_0x0065
            int r5 = r1.length     // Catch:{ all -> 0x00eb }
            int r5 = r5 - r7
            int r5 = r5 - r6
            r8 = r1[r7]     // Catch:{ all -> 0x00eb }
            r9 = r1[r5]     // Catch:{ all -> 0x00eb }
            r1[r7] = r9     // Catch:{ all -> 0x00eb }
            r1[r5] = r8     // Catch:{ all -> 0x00eb }
            r5 = r7
            goto L_0x0054
        L_0x0065:
            r5 = 0
        L_0x0066:
            int r7 = r1.length     // Catch:{ all -> 0x00eb }
            if (r5 >= r7) goto L_0x00ac
            r7 = r1[r5]     // Catch:{ all -> 0x00eb }
            boolean r8 = r7.isAccessible()     // Catch:{ all -> 0x00eb }
            if (r8 != 0) goto L_0x0074
            r7.setAccessible(r6)     // Catch:{ all -> 0x00eb }
        L_0x0074:
            com.thoughtworks.xstream.converters.reflection.FieldKey r8 = new com.thoughtworks.xstream.converters.reflection.FieldKey     // Catch:{ all -> 0x00eb }
            java.lang.String r9 = r7.getName()     // Catch:{ all -> 0x00eb }
            java.lang.Class r10 = r7.getDeclaringClass()     // Catch:{ all -> 0x00eb }
            r8.<init>(r9, r10, r5)     // Catch:{ all -> 0x00eb }
            java.lang.String r9 = r7.getName()     // Catch:{ all -> 0x00eb }
            java.lang.Object r9 = r4.get(r9)     // Catch:{ all -> 0x00eb }
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9     // Catch:{ all -> 0x00eb }
            if (r9 == 0) goto L_0x009f
            int r10 = r9.getModifiers()     // Catch:{ all -> 0x00eb }
            r10 = r10 & 8
            if (r10 != 0) goto L_0x009f
            if (r9 == 0) goto L_0x00a6
            int r9 = r7.getModifiers()     // Catch:{ all -> 0x00eb }
            r9 = r9 & 8
            if (r9 != 0) goto L_0x00a6
        L_0x009f:
            java.lang.String r9 = r7.getName()     // Catch:{ all -> 0x00eb }
            r4.put(r9, r7)     // Catch:{ all -> 0x00eb }
        L_0x00a6:
            r12.put(r8, r7)     // Catch:{ all -> 0x00eb }
            int r5 = r5 + 1
            goto L_0x0066
        L_0x00ac:
            com.thoughtworks.xstream.converters.reflection.FieldKeySorter r1 = r11.sorter     // Catch:{ all -> 0x00eb }
            java.util.Map r1 = r1.sort(r3, r12)     // Catch:{ all -> 0x00eb }
            java.util.Map r12 = r11.keyedByFieldNameCache     // Catch:{ all -> 0x00eb }
            r12.put(r3, r4)     // Catch:{ all -> 0x00eb }
            java.util.Map r12 = r11.keyedByFieldKeyCache     // Catch:{ all -> 0x00eb }
            r12.put(r3, r1)     // Catch:{ all -> 0x00eb }
            r12 = r4
            goto L_0x0029
        L_0x00bf:
            java.util.Map r12 = r11.keyedByFieldNameCache     // Catch:{ all -> 0x00eb }
            java.lang.Object r12 = r12.get(r3)     // Catch:{ all -> 0x00eb }
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ all -> 0x00eb }
            java.util.Map r1 = r11.keyedByFieldKeyCache     // Catch:{ all -> 0x00eb }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x00eb }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x00eb }
            goto L_0x0029
        L_0x00d1:
            if (r13 == 0) goto L_0x00d4
            r12 = r1
        L_0x00d4:
            monitor-exit(r11)     // Catch:{ all -> 0x00eb }
            return r12
        L_0x00d6:
            monitor-exit(r11)     // Catch:{ all -> 0x00eb }
            if (r13 == 0) goto L_0x00e0
            java.util.Map r13 = r11.keyedByFieldKeyCache
            java.lang.Object r12 = r13.get(r12)
            goto L_0x00e6
        L_0x00e0:
            java.util.Map r13 = r11.keyedByFieldNameCache
            java.lang.Object r12 = r13.get(r12)
        L_0x00e6:
            java.util.Map r12 = (java.util.Map) r12
            java.util.Map r12 = (java.util.Map) r12
            return r12
        L_0x00eb:
            r12 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x00eb }
            goto L_0x00ef
        L_0x00ee:
            throw r12
        L_0x00ef:
            goto L_0x00ee
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.converters.reflection.FieldDictionary.buildMap(java.lang.Class, boolean):java.util.Map");
    }

    public synchronized void flushCache() {
        Set<Object> singleton = Collections.singleton(Object.class);
        this.keyedByFieldNameCache.keySet().retainAll(singleton);
        this.keyedByFieldKeyCache.keySet().retainAll(singleton);
        if (this.sorter instanceof Caching) {
            ((Caching) this.sorter).flushCache();
        }
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        init();
        return this;
    }
}
