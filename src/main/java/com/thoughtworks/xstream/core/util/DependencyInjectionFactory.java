package com.thoughtworks.xstream.core.util;

import java.util.BitSet;

public class DependencyInjectionFactory {
    public static Object newInstance(Class cls, Object[] objArr) {
        return newInstance(cls, objArr, (BitSet) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0177, code lost:
        r22 = 1;
        r7 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object newInstance(java.lang.Class r28, java.lang.Object[] r29, java.util.BitSet r30) {
        /*
            r0 = r29
            r1 = r30
            if (r0 == 0) goto L_0x0014
            int r2 = r0.length
            r3 = 63
            if (r2 > r3) goto L_0x000c
            goto L_0x0014
        L_0x000c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "More than 63 arguments are not supported"
            r0.<init>(r1)
            throw r0
        L_0x0014:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r8 = "Cannot construct "
            r10 = 1
            if (r0 == 0) goto L_0x01a7
            int r11 = r0.length
            if (r11 <= 0) goto L_0x01a7
            java.lang.reflect.Constructor[] r11 = r28.getConstructors()
            int r12 = r11.length
            if (r12 <= r10) goto L_0x0030
            com.thoughtworks.xstream.core.util.DependencyInjectionFactory$1 r12 = new com.thoughtworks.xstream.core.util.DependencyInjectionFactory$1
            r12.<init>()
            java.util.Arrays.sort(r11, r12)
        L_0x0030:
            int r12 = r0.length
            com.thoughtworks.xstream.core.util.DependencyInjectionFactory$TypedValue[] r12 = new com.thoughtworks.xstream.core.util.DependencyInjectionFactory.TypedValue[r12]
            r13 = 0
        L_0x0034:
            int r14 = r0.length
            if (r13 >= r14) goto L_0x005e
            r14 = r0[r13]
            java.lang.Class r15 = r14.getClass()
            boolean r16 = r15.isPrimitive()
            if (r16 == 0) goto L_0x0048
            java.lang.Class r15 = com.thoughtworks.xstream.core.util.Primitives.box(r15)
            goto L_0x0053
        L_0x0048:
            java.lang.Class<com.thoughtworks.xstream.core.util.TypedNull> r10 = com.thoughtworks.xstream.core.util.TypedNull.class
            if (r15 != r10) goto L_0x0053
            com.thoughtworks.xstream.core.util.TypedNull r14 = (com.thoughtworks.xstream.core.util.TypedNull) r14
            java.lang.Class r15 = r14.getType()
            r14 = 0
        L_0x0053:
            com.thoughtworks.xstream.core.util.DependencyInjectionFactory$TypedValue r10 = new com.thoughtworks.xstream.core.util.DependencyInjectionFactory$TypedValue
            r10.<init>(r15, r14)
            r12[r13] = r10
            int r13 = r13 + 1
            r10 = 1
            goto L_0x0034
        L_0x005e:
            r10 = 2147483647(0x7fffffff, float:NaN)
            r5 = 0
            r10 = 0
            r13 = 0
            r14 = 2147483647(0x7fffffff, float:NaN)
            r15 = 0
            r17 = 0
            r19 = 0
        L_0x006c:
            if (r10 != 0) goto L_0x0177
            int r6 = r11.length
            if (r13 >= r6) goto L_0x0177
            r6 = r11[r13]
            java.lang.Class[] r7 = r6.getParameterTypes()
            int r9 = r7.length
            int r3 = r0.length
            if (r9 <= r3) goto L_0x007c
            goto L_0x008b
        L_0x007c:
            int r3 = r7.length
            if (r3 != 0) goto L_0x0086
            if (r15 != 0) goto L_0x0177
            r7 = r6
            r22 = 1
            goto L_0x017a
        L_0x0086:
            int r3 = r7.length
            if (r14 <= r3) goto L_0x0091
            if (r15 == 0) goto L_0x0090
        L_0x008b:
            r4 = 0
            r22 = 1
            goto L_0x0171
        L_0x0090:
            int r14 = r7.length
        L_0x0091:
            r3 = 0
        L_0x0092:
            int r4 = r7.length
            if (r3 >= r4) goto L_0x00a8
            r4 = r7[r3]
            boolean r4 = r4.isPrimitive()
            if (r4 == 0) goto L_0x00a5
            r4 = r7[r3]
            java.lang.Class r4 = com.thoughtworks.xstream.core.util.Primitives.box(r4)
            r7[r3] = r4
        L_0x00a5:
            int r3 = r3 + 1
            goto L_0x0092
        L_0x00a8:
            r2.clear()
            r3 = 0
            r4 = 0
            r17 = 0
        L_0x00af:
            int r9 = r7.length
            if (r3 >= r9) goto L_0x00dd
            int r9 = r7.length
            int r9 = r9 + r4
            int r9 = r9 - r3
            int r0 = r12.length
            if (r9 > r0) goto L_0x00dd
            r0 = r7[r3]
            r9 = r12[r4]
            java.lang.Class r9 = r9.type
            boolean r0 = r0.isAssignableFrom(r9)
            if (r0 == 0) goto L_0x00d8
            r0 = r12[r4]
            java.lang.Object r0 = r0.value
            r2.add(r0)
            r22 = 1
            long r24 = r22 << r4
            long r17 = r17 | r24
            int r3 = r3 + 1
            int r0 = r7.length
            if (r3 != r0) goto L_0x00d8
            r10 = r6
            goto L_0x00dd
        L_0x00d8:
            int r4 = r4 + 1
            r0 = r29
            goto L_0x00af
        L_0x00dd:
            if (r10 != 0) goto L_0x008b
            int r0 = r12.length
            com.thoughtworks.xstream.core.util.DependencyInjectionFactory$TypedValue[] r0 = new com.thoughtworks.xstream.core.util.DependencyInjectionFactory.TypedValue[r0]
            int r3 = r0.length
            r4 = 0
            java.lang.System.arraycopy(r12, r4, r0, r4, r3)
            r2.clear()
            r3 = 0
            r17 = 0
        L_0x00ed:
            int r9 = r7.length
            if (r3 >= r9) goto L_0x0157
            r9 = -1
            r9 = 0
            r21 = -1
        L_0x00f4:
            int r4 = r0.length
            if (r9 >= r4) goto L_0x0138
            r4 = r0[r9]
            if (r4 != 0) goto L_0x00fe
            r25 = r6
            goto L_0x0133
        L_0x00fe:
            r4 = r0[r9]
            java.lang.Class r4 = r4.type
            r25 = r6
            r6 = r7[r3]
            if (r4 != r6) goto L_0x010b
            r21 = r9
            goto L_0x013a
        L_0x010b:
            r4 = r7[r3]
            r6 = r0[r9]
            java.lang.Class r6 = r6.type
            boolean r4 = r4.isAssignableFrom(r6)
            if (r4 == 0) goto L_0x0133
            if (r21 < 0) goto L_0x0131
            r4 = r0[r21]
            java.lang.Class r4 = r4.type
            r6 = r0[r9]
            java.lang.Class r6 = r6.type
            if (r4 == r6) goto L_0x0133
            r4 = r0[r21]
            java.lang.Class r4 = r4.type
            r6 = r0[r9]
            java.lang.Class r6 = r6.type
            boolean r4 = r4.isAssignableFrom(r6)
            if (r4 == 0) goto L_0x0133
        L_0x0131:
            r21 = r9
        L_0x0133:
            int r9 = r9 + 1
            r6 = r25
            goto L_0x00f4
        L_0x0138:
            r25 = r6
        L_0x013a:
            if (r21 < 0) goto L_0x0152
            r4 = r0[r21]
            java.lang.Object r4 = r4.value
            r2.add(r4)
            r22 = 1
            long r26 = r22 << r21
            long r17 = r17 | r26
            r4 = 0
            r0[r21] = r4
            int r3 = r3 + 1
            r6 = r25
            r4 = 0
            goto L_0x00ed
        L_0x0152:
            r4 = 0
            r22 = 1
            r0 = 0
            goto L_0x015d
        L_0x0157:
            r25 = r6
            r4 = 0
            r22 = 1
            r0 = 1
        L_0x015d:
            if (r0 == 0) goto L_0x0171
            if (r15 == 0) goto L_0x0166
            int r0 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r0 < 0) goto L_0x0166
            goto L_0x0171
        L_0x0166:
            java.lang.Object r0 = r2.clone()
            java.util.List r0 = (java.util.List) r0
            r5 = r0
            r19 = r17
            r15 = r25
        L_0x0171:
            int r13 = r13 + 1
            r0 = r29
            goto L_0x006c
        L_0x0177:
            r22 = 1
            r7 = r10
        L_0x017a:
            if (r7 != 0) goto L_0x01a5
            if (r15 == 0) goto L_0x0187
            r2.clear()
            r2.addAll(r5)
            r17 = r19
            goto L_0x01ad
        L_0x0187:
            com.thoughtworks.xstream.converters.reflection.ObjectAccessException r0 = new com.thoughtworks.xstream.converters.reflection.ObjectAccessException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r8)
            java.lang.String r2 = r28.getName()
            r1.append(r2)
            java.lang.String r2 = ", none of the dependencies match any constructor's parameters"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01a5:
            r15 = r7
            goto L_0x01ad
        L_0x01a7:
            r4 = 0
            r22 = 1
            r15 = r4
            r17 = 0
        L_0x01ad:
            if (r15 != 0) goto L_0x01b4
            java.lang.Object r0 = r28.newInstance()     // Catch:{ InstantiationException -> 0x0240, IllegalAccessException -> 0x0226, InvocationTargetException -> 0x020c, SecurityException -> 0x01f2, ExceptionInInitializerError -> 0x01d8 }
            goto L_0x01bc
        L_0x01b4:
            java.lang.Object[] r0 = r2.toArray()     // Catch:{ InstantiationException -> 0x0240, IllegalAccessException -> 0x0226, InvocationTargetException -> 0x020c, SecurityException -> 0x01f2, ExceptionInInitializerError -> 0x01d8 }
            java.lang.Object r0 = r15.newInstance(r0)     // Catch:{ InstantiationException -> 0x0240, IllegalAccessException -> 0x0226, InvocationTargetException -> 0x020c, SecurityException -> 0x01f2, ExceptionInInitializerError -> 0x01d8 }
        L_0x01bc:
            if (r1 == 0) goto L_0x01d7
            r30.clear()     // Catch:{ InstantiationException -> 0x0240, IllegalAccessException -> 0x0226, InvocationTargetException -> 0x020c, SecurityException -> 0x01f2, ExceptionInInitializerError -> 0x01d8 }
            r2 = 0
        L_0x01c2:
            int r3 = (r22 > r17 ? 1 : (r22 == r17 ? 0 : -1))
            if (r3 >= 0) goto L_0x01d7
            long r3 = r17 & r22
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x01d1
            r1.set(r2)     // Catch:{ InstantiationException -> 0x0240, IllegalAccessException -> 0x0226, InvocationTargetException -> 0x020c, SecurityException -> 0x01f2, ExceptionInInitializerError -> 0x01d8 }
        L_0x01d1:
            r3 = 1
            long r22 = r22 << r3
            int r2 = r2 + 1
            goto L_0x01c2
        L_0x01d7:
            return r0
        L_0x01d8:
            r0 = move-exception
            com.thoughtworks.xstream.converters.reflection.ObjectAccessException r1 = new com.thoughtworks.xstream.converters.reflection.ObjectAccessException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r8)
            java.lang.String r3 = r28.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x01f2:
            r0 = move-exception
            com.thoughtworks.xstream.converters.reflection.ObjectAccessException r1 = new com.thoughtworks.xstream.converters.reflection.ObjectAccessException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r8)
            java.lang.String r3 = r28.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x020c:
            r0 = move-exception
            com.thoughtworks.xstream.converters.reflection.ObjectAccessException r1 = new com.thoughtworks.xstream.converters.reflection.ObjectAccessException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r8)
            java.lang.String r3 = r28.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x0226:
            r0 = move-exception
            com.thoughtworks.xstream.converters.reflection.ObjectAccessException r1 = new com.thoughtworks.xstream.converters.reflection.ObjectAccessException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r8)
            java.lang.String r3 = r28.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x0240:
            r0 = move-exception
            com.thoughtworks.xstream.converters.reflection.ObjectAccessException r1 = new com.thoughtworks.xstream.converters.reflection.ObjectAccessException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r8)
            java.lang.String r3 = r28.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            goto L_0x025b
        L_0x025a:
            throw r1
        L_0x025b:
            goto L_0x025a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.core.util.DependencyInjectionFactory.newInstance(java.lang.Class, java.lang.Object[], java.util.BitSet):java.lang.Object");
    }

    private static class TypedValue {
        final Class type;
        final Object value;

        public TypedValue(Class cls, Object obj) {
            this.type = cls;
            this.value = obj;
        }

        public String toString() {
            return this.type.getName() + ":" + this.value;
        }
    }
}
