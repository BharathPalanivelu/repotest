package com.google.c;

final class o {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?> f13991a = a();

    static Class<?> a() {
        try {
            return Class.forName("com.google.c.n");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static p b() {
        if (f13991a != null) {
            try {
                return a("newInstance");
            } catch (Exception unused) {
            }
        }
        return new p();
    }

    public static p c() {
        if (f13991a != null) {
            try {
                return a("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return p.f13993b;
    }

    private static final p a(String str) throws Exception {
        return (p) f13991a.getMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }
}
