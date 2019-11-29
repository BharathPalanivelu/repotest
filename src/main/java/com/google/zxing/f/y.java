package com.google.zxing.f;

import java.util.regex.Pattern;

public final class y extends k {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f14751a = Pattern.compile(":/*([^/@]+)@[^/]+");

    /* renamed from: b  reason: collision with root package name */
    private final String f14752b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14753c;

    public y(String str, String str2) {
        super(l.URI);
        this.f14752b = a(str);
        this.f14753c = str2;
    }

    public String a() {
        StringBuilder sb = new StringBuilder(30);
        a(this.f14753c, sb);
        a(this.f14752b, sb);
        return sb.toString();
    }

    private static String a(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(58);
        if (indexOf < 0) {
            return "http://" + trim;
        } else if (!a(trim, indexOf)) {
            return trim;
        } else {
            return "http://" + trim;
        }
    }

    private static boolean a(String str, int i) {
        int i2 = i + 1;
        int indexOf = str.indexOf(47, i2);
        if (indexOf < 0) {
            indexOf = str.length();
        }
        return q.a(str, i2, indexOf - i2);
    }
}
