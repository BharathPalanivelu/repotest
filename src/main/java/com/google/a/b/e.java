package com.google.a.b;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int f8869a = c();

    private static int c() {
        return a(System.getProperty("java.version"));
    }

    static int a(String str) {
        int b2 = b(str);
        if (b2 == -1) {
            b2 = c(str);
        }
        if (b2 == -1) {
            return 6;
        }
        return b2;
    }

    private static int b(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            return (parseInt != 1 || split.length <= 1) ? parseInt : Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static int c(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb.append(charAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int a() {
        return f8869a;
    }

    public static boolean b() {
        return f8869a >= 9;
    }
}
