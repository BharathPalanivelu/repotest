package com.google.zxing.f;

public final class ab extends k {

    /* renamed from: a  reason: collision with root package name */
    private final String f14708a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14709b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14710c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f14711d;

    public ab(String str, String str2, String str3, boolean z) {
        super(l.WIFI);
        this.f14708a = str2;
        this.f14709b = str;
        this.f14710c = str3;
        this.f14711d = z;
    }

    public String a() {
        StringBuilder sb = new StringBuilder(80);
        a(this.f14708a, sb);
        a(this.f14709b, sb);
        a(this.f14710c, sb);
        a(Boolean.toString(this.f14711d), sb);
        return sb.toString();
    }
}
