package com.google.zxing.f;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    private final l f14732a;

    public abstract String a();

    protected k(l lVar) {
        this.f14732a = lVar;
    }

    public final l b() {
        return this.f14732a;
    }

    public final String toString() {
        return a();
    }

    public static void a(String str, StringBuilder sb) {
        if (str != null && !str.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(10);
            }
            sb.append(str);
        }
    }

    public static void a(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String a2 : strArr) {
                a(a2, sb);
            }
        }
    }
}
