package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.reflection.FieldDictionary;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.util.DependencyInjectionFactory;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.text.AttributedString;

public class JVM implements Caching {
    private static final float DEFAULT_JAVA_VERSION = 1.4f;
    private static final boolean canAllocateWithUnsafe;
    private static final boolean canCreateDerivedObjectOutputStream;
    private static final boolean canParseISO8601TimeZoneInDateFormat;
    private static final boolean canParseUTCDateFormat;
    private static final boolean canWriteWithUnsafe;
    private static final boolean isAWTAvailable = (loadClassForName("java.awt.Color", false) != null);
    private static final boolean isSQLAvailable;
    private static final boolean isSwingAvailable = (loadClassForName("javax.swing.LookAndFeel", false) != null);
    private static final float majorJavaVersion = getMajorJavaVersion();
    private static final boolean optimizedTreeMapPutAll;
    private static final boolean optimizedTreeSetAddAll;
    private static final Class reflectionProviderType;
    private static final boolean reverseFieldOrder = false;
    private static final String vendor = System.getProperty("java.vm.vendor");
    private ReflectionProvider reflectionProvider;

    public static boolean reverseFieldDefinition() {
        return false;
    }

    public void flushCache() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x004c  */
    static {
        /*
            java.lang.String r0 = "java.vm.vendor"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            vendor = r0
            float r0 = getMajorJavaVersion()
            majorJavaVersion = r0
            r0 = 0
            r1 = 1
            r2 = 0
            java.lang.String r3 = "sun.misc.Unsafe"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Error | Exception -> 0x0041 }
            java.lang.String r4 = "theUnsafe"
            java.lang.reflect.Field r4 = r3.getDeclaredField(r4)     // Catch:{ Error | Exception -> 0x0041 }
            r4.setAccessible(r1)     // Catch:{ Error | Exception -> 0x0041 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Error | Exception -> 0x0041 }
            java.lang.String r5 = "allocateInstance"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ Error | Exception -> 0x0041 }
            java.lang.Class<java.lang.Class> r7 = java.lang.Class.class
            r6[r2] = r7     // Catch:{ Error | Exception -> 0x0041 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r5, r6)     // Catch:{ Error | Exception -> 0x0041 }
            r3.setAccessible(r1)     // Catch:{ Error | Exception -> 0x0041 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ Error | Exception -> 0x0041 }
            java.lang.Class<com.thoughtworks.xstream.core.JVM$Test> r6 = com.thoughtworks.xstream.core.JVM.Test.class
            r5[r2] = r6     // Catch:{ Error | Exception -> 0x0041 }
            java.lang.Object r3 = r3.invoke(r4, r5)     // Catch:{ Error | Exception -> 0x0041 }
            if (r3 == 0) goto L_0x0041
            r3 = 1
            goto L_0x0042
        L_0x0041:
            r3 = 0
        L_0x0042:
            canAllocateWithUnsafe = r3
            java.lang.Class<com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider> r3 = com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider.class
            boolean r4 = canUseSunUnsafeReflectionProvider()
            if (r4 == 0) goto L_0x00df
            java.lang.String r4 = "com.thoughtworks.xstream.converters.reflection.SunUnsafeReflectionProvider"
            java.lang.Class r4 = loadClassForName(r4)
            if (r4 == 0) goto L_0x00df
            java.lang.Object r5 = com.thoughtworks.xstream.core.util.DependencyInjectionFactory.newInstance(r4, r0)     // Catch:{ ObjectAccessException -> 0x00df }
            com.thoughtworks.xstream.converters.reflection.ReflectionProvider r5 = (com.thoughtworks.xstream.converters.reflection.ReflectionProvider) r5     // Catch:{ ObjectAccessException -> 0x00df }
            java.lang.Class<com.thoughtworks.xstream.core.JVM$Test> r6 = com.thoughtworks.xstream.core.JVM.Test.class
            java.lang.Object r6 = r5.newInstance(r6)     // Catch:{ ObjectAccessException -> 0x00df }
            com.thoughtworks.xstream.core.JVM$Test r6 = (com.thoughtworks.xstream.core.JVM.Test) r6     // Catch:{ ObjectAccessException -> 0x00df }
            java.lang.String r7 = "o"
            java.lang.String r8 = "object"
            java.lang.Class<com.thoughtworks.xstream.core.JVM$Test> r9 = com.thoughtworks.xstream.core.JVM.Test.class
            r5.writeField(r6, r7, r8, r9)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.String r7 = "c"
            java.lang.Character r8 = new java.lang.Character     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            r9 = 99
            r8.<init>(r9)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.Class<com.thoughtworks.xstream.core.JVM$Test> r9 = com.thoughtworks.xstream.core.JVM.Test.class
            r5.writeField(r6, r7, r8, r9)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.String r7 = "b"
            java.lang.Byte r8 = new java.lang.Byte     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            r8.<init>(r1)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.Class<com.thoughtworks.xstream.core.JVM$Test> r9 = com.thoughtworks.xstream.core.JVM.Test.class
            r5.writeField(r6, r7, r8, r9)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.String r7 = "s"
            java.lang.Short r8 = new java.lang.Short     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            r8.<init>(r1)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.Class<com.thoughtworks.xstream.core.JVM$Test> r9 = com.thoughtworks.xstream.core.JVM.Test.class
            r5.writeField(r6, r7, r8, r9)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.String r7 = "i"
            java.lang.Integer r8 = new java.lang.Integer     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            r8.<init>(r1)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.Class<com.thoughtworks.xstream.core.JVM$Test> r9 = com.thoughtworks.xstream.core.JVM.Test.class
            r5.writeField(r6, r7, r8, r9)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.String r7 = "l"
            java.lang.Long r8 = new java.lang.Long     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            r9 = 1
            r8.<init>(r9)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.Class<com.thoughtworks.xstream.core.JVM$Test> r9 = com.thoughtworks.xstream.core.JVM.Test.class
            r5.writeField(r6, r7, r8, r9)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.String r7 = "f"
            java.lang.Float r8 = new java.lang.Float     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            r9 = 1065353216(0x3f800000, float:1.0)
            r8.<init>(r9)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.Class<com.thoughtworks.xstream.core.JVM$Test> r9 = com.thoughtworks.xstream.core.JVM.Test.class
            r5.writeField(r6, r7, r8, r9)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.String r7 = "d"
            java.lang.Double r8 = new java.lang.Double     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            r9 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r8.<init>(r9)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.Class<com.thoughtworks.xstream.core.JVM$Test> r9 = com.thoughtworks.xstream.core.JVM.Test.class
            r5.writeField(r6, r7, r8, r9)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.String r7 = "bool"
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            java.lang.Class<com.thoughtworks.xstream.core.JVM$Test> r9 = com.thoughtworks.xstream.core.JVM.Test.class
            r5.writeField(r6, r7, r8, r9)     // Catch:{ ObjectAccessException | IncompatibleClassChangeError -> 0x00d2 }
            r5 = 1
            goto L_0x00d4
        L_0x00d2:
            r5 = 0
            r4 = r0
        L_0x00d4:
            if (r4 != 0) goto L_0x00dd
            java.lang.String r4 = "com.thoughtworks.xstream.converters.reflection.SunLimitedUnsafeReflectionProvider"
            java.lang.Class r3 = loadClassForName(r4)     // Catch:{ ObjectAccessException -> 0x00e0 }
            goto L_0x00e0
        L_0x00dd:
            r3 = r4
            goto L_0x00e0
        L_0x00df:
            r5 = 0
        L_0x00e0:
            reflectionProviderType = r3
            canWriteWithUnsafe = r5
            com.thoughtworks.xstream.core.JVM$1 r3 = new com.thoughtworks.xstream.core.JVM$1
            r3.<init>()
            com.thoughtworks.xstream.core.util.PresortedMap r4 = new com.thoughtworks.xstream.core.util.PresortedMap
            r4.<init>(r3)
            java.lang.String r5 = "one"
            r4.put(r5, r0)
            java.lang.String r5 = "two"
            r4.put(r5, r0)
            java.util.TreeMap r5 = new java.util.TreeMap     // Catch:{ RuntimeException -> 0x0102 }
            r5.<init>(r3)     // Catch:{ RuntimeException -> 0x0102 }
            r5.putAll(r4)     // Catch:{ RuntimeException -> 0x0102 }
            r5 = 1
            goto L_0x0103
        L_0x0102:
            r5 = 0
        L_0x0103:
            optimizedTreeMapPutAll = r5
            com.thoughtworks.xstream.core.util.PresortedSet r5 = new com.thoughtworks.xstream.core.util.PresortedSet
            r5.<init>(r3)
            java.util.Set r4 = r4.keySet()
            r5.addAll(r4)
            java.util.TreeSet r4 = new java.util.TreeSet     // Catch:{ RuntimeException -> 0x011b }
            r4.<init>(r3)     // Catch:{ RuntimeException -> 0x011b }
            r4.addAll(r5)     // Catch:{ RuntimeException -> 0x011b }
            r3 = 1
            goto L_0x011c
        L_0x011b:
            r3 = 0
        L_0x011c:
            optimizedTreeSetAddAll = r3
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x012c }
            java.lang.String r4 = "z"
            r3.<init>(r4)     // Catch:{ ParseException -> 0x012c }
            java.lang.String r4 = "UTC"
            r3.parse(r4)     // Catch:{ ParseException -> 0x012c }
            r3 = 1
            goto L_0x012d
        L_0x012c:
            r3 = 0
        L_0x012d:
            canParseUTCDateFormat = r3
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ IllegalArgumentException | ParseException -> 0x013d }
            java.lang.String r4 = "X"
            r3.<init>(r4)     // Catch:{ IllegalArgumentException | ParseException -> 0x013d }
            java.lang.String r4 = "Z"
            r3.parse(r4)     // Catch:{ IllegalArgumentException | ParseException -> 0x013d }
            r3 = 1
            goto L_0x013e
        L_0x013d:
            r3 = 0
        L_0x013e:
            canParseISO8601TimeZoneInDateFormat = r3
            com.thoughtworks.xstream.core.util.CustomObjectOutputStream r3 = new com.thoughtworks.xstream.core.util.CustomObjectOutputStream     // Catch:{ IOException | RuntimeException -> 0x0147 }
            r3.<init>(r0)     // Catch:{ IOException | RuntimeException -> 0x0147 }
            r0 = 1
            goto L_0x0148
        L_0x0147:
            r0 = 0
        L_0x0148:
            canCreateDerivedObjectOutputStream = r0
            java.lang.String r0 = "java.awt.Color"
            java.lang.Class r0 = loadClassForName(r0, r2)
            if (r0 == 0) goto L_0x0154
            r0 = 1
            goto L_0x0155
        L_0x0154:
            r0 = 0
        L_0x0155:
            isAWTAvailable = r0
            java.lang.String r0 = "javax.swing.LookAndFeel"
            java.lang.Class r0 = loadClassForName(r0, r2)
            if (r0 == 0) goto L_0x0161
            r0 = 1
            goto L_0x0162
        L_0x0161:
            r0 = 0
        L_0x0162:
            isSwingAvailable = r0
            java.lang.String r0 = "java.sql.Date"
            java.lang.Class r0 = loadClassForName(r0)
            if (r0 == 0) goto L_0x016d
            goto L_0x016e
        L_0x016d:
            r1 = 0
        L_0x016e:
            isSQLAvailable = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.core.JVM.<clinit>():void");
    }

    static class Test {

        /* renamed from: b  reason: collision with root package name */
        private byte f32511b;
        private boolean bool;

        /* renamed from: c  reason: collision with root package name */
        private char f32512c;

        /* renamed from: d  reason: collision with root package name */
        private double f32513d;

        /* renamed from: f  reason: collision with root package name */
        private float f32514f;
        private int i;
        private long l;
        private Object o;
        private short s;

        Test() {
            throw new UnsupportedOperationException();
        }
    }

    private static final float getMajorJavaVersion() {
        try {
            if (isAndroid()) {
                return 1.5f;
            }
            return Float.parseFloat(System.getProperty("java.specification.version"));
        } catch (NumberFormatException unused) {
            return DEFAULT_JAVA_VERSION;
        }
    }

    public static boolean is14() {
        return majorJavaVersion >= DEFAULT_JAVA_VERSION;
    }

    public static boolean is15() {
        return majorJavaVersion >= 1.5f;
    }

    public static boolean is16() {
        return majorJavaVersion >= 1.6f;
    }

    public static boolean is17() {
        return majorJavaVersion >= 1.7f;
    }

    public static boolean is18() {
        return majorJavaVersion >= 1.8f;
    }

    public static boolean is19() {
        return majorJavaVersion >= 1.9f;
    }

    private static boolean isIBM() {
        return vendor.indexOf("IBM") != -1;
    }

    private static boolean isAndroid() {
        return vendor.indexOf("Android") != -1;
    }

    public static Class loadClassForName(String str) {
        return loadClassForName(str, true);
    }

    public Class loadClass(String str) {
        return loadClassForName(str, true);
    }

    public static Class loadClassForName(String str, boolean z) {
        try {
            return Class.forName(str, z, JVM.class.getClassLoader());
        } catch (ClassNotFoundException | LinkageError unused) {
            return null;
        }
    }

    public Class loadClass(String str, boolean z) {
        return loadClassForName(str, z);
    }

    public static ReflectionProvider newReflectionProvider() {
        return (ReflectionProvider) DependencyInjectionFactory.newInstance(reflectionProviderType, (Object[]) null);
    }

    public static ReflectionProvider newReflectionProvider(FieldDictionary fieldDictionary) {
        return (ReflectionProvider) DependencyInjectionFactory.newInstance(reflectionProviderType, new Object[]{fieldDictionary});
    }

    public static Class getStaxInputFactory() throws ClassNotFoundException {
        if (!is16()) {
            return null;
        }
        if (isIBM()) {
            return Class.forName("com.ibm.xml.xlxp.api.stax.XMLInputFactoryImpl");
        }
        return Class.forName("com.sun.xml.internal.stream.XMLInputFactoryImpl");
    }

    public static Class getStaxOutputFactory() throws ClassNotFoundException {
        if (!is16()) {
            return null;
        }
        if (isIBM()) {
            return Class.forName("com.ibm.xml.xlxp.api.stax.XMLOutputFactoryImpl");
        }
        return Class.forName("com.sun.xml.internal.stream.XMLOutputFactoryImpl");
    }

    public synchronized ReflectionProvider bestReflectionProvider() {
        if (this.reflectionProvider == null) {
            this.reflectionProvider = newReflectionProvider();
        }
        return this.reflectionProvider;
    }

    private static boolean canUseSunUnsafeReflectionProvider() {
        return canAllocateWithUnsafe && is14();
    }

    private static boolean canUseSunLimitedUnsafeReflectionProvider() {
        return canWriteWithUnsafe;
    }

    public static boolean isAWTAvailable() {
        return isAWTAvailable;
    }

    public boolean supportsAWT() {
        return isAWTAvailable;
    }

    public static boolean isSwingAvailable() {
        return isSwingAvailable;
    }

    public boolean supportsSwing() {
        return isSwingAvailable;
    }

    public static boolean isSQLAvailable() {
        return isSQLAvailable;
    }

    public boolean supportsSQL() {
        return isSQLAvailable;
    }

    public static boolean hasOptimizedTreeSetAddAll() {
        return optimizedTreeSetAddAll;
    }

    public static boolean hasOptimizedTreeMapPutAll() {
        return optimizedTreeMapPutAll;
    }

    public static boolean canParseUTCDateFormat() {
        return canParseUTCDateFormat;
    }

    public static boolean canParseISO8601TimeZoneInDateFormat() {
        return canParseISO8601TimeZoneInDateFormat;
    }

    public static boolean canCreateDerivedObjectOutputStream() {
        return canCreateDerivedObjectOutputStream;
    }

    public static void main(String[] strArr) {
        boolean z;
        boolean z2;
        String str;
        Field[] declaredFields = AttributedString.class.getDeclaredFields();
        boolean z3 = false;
        int i = 0;
        while (true) {
            if (i >= declaredFields.length) {
                break;
            } else if (!declaredFields[i].getName().equals("text")) {
                i++;
            } else if (i > 3) {
                z = true;
            }
        }
        z = false;
        Field[] declaredFields2 = Test.class.getDeclaredFields();
        int i2 = 0;
        while (true) {
            if (i2 >= declaredFields2.length) {
                break;
            } else if (!declaredFields2[i2].getName().equals("o")) {
                i2++;
            } else if (i2 > 3) {
                z2 = true;
            }
        }
        z2 = false;
        String str2 = null;
        try {
            str = getStaxInputFactory().getName();
        } catch (ClassNotFoundException e2) {
            str = e2.getMessage();
        } catch (NullPointerException unused) {
            str = null;
        }
        try {
            str2 = getStaxOutputFactory().getName();
        } catch (ClassNotFoundException e3) {
            str2 = e3.getMessage();
        } catch (NullPointerException unused2) {
        }
        System.out.println("XStream JVM diagnostics");
        System.out.println("java.specification.version: " + System.getProperty("java.specification.version"));
        System.out.println("java.specification.vendor: " + System.getProperty("java.specification.vendor"));
        System.out.println("java.specification.name: " + System.getProperty("java.specification.name"));
        System.out.println("java.vm.vendor: " + vendor);
        System.out.println("java.vendor: " + System.getProperty("java.vendor"));
        System.out.println("java.vm.name: " + System.getProperty("java.vm.name"));
        System.out.println("Version: " + majorJavaVersion);
        System.out.println("XStream support for enhanced Mode: " + canUseSunUnsafeReflectionProvider());
        System.out.println("XStream support for reduced Mode: " + canUseSunLimitedUnsafeReflectionProvider());
        System.out.println("Supports AWT: " + isAWTAvailable());
        System.out.println("Supports Swing: " + isSwingAvailable());
        System.out.println("Supports SQL: " + isSQLAvailable());
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("Java Beans EventHandler present: ");
        if (loadClassForName("java.beans.EventHandler") != null) {
            z3 = true;
        }
        sb.append(z3);
        printStream.println(sb.toString());
        System.out.println("Standard StAX XMLInputFactory: " + str);
        System.out.println("Standard StAX XMLOutputFactory: " + str2);
        System.out.println("Optimized TreeSet.addAll: " + hasOptimizedTreeSetAddAll());
        System.out.println("Optimized TreeMap.putAll: " + hasOptimizedTreeMapPutAll());
        System.out.println("Can parse UTC date format: " + canParseUTCDateFormat());
        System.out.println("Can create derive ObjectOutputStream: " + canCreateDerivedObjectOutputStream());
        System.out.println("Reverse field order detected for JDK: " + z);
        System.out.println("Reverse field order detected (only if JVM class itself has been compiled): " + z2);
    }
}
