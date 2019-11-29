package com.google.zxing.f;

public final class u extends k {

    /* renamed from: a  reason: collision with root package name */
    private final String f14745a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14746b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14747c;

    public u(String str, String str2, String str3) {
        super(l.TEL);
        this.f14745a = str;
        this.f14746b = str2;
        this.f14747c = str3;
    }

    public String a() {
        StringBuilder sb = new StringBuilder(20);
        a(this.f14745a, sb);
        a(this.f14747c, sb);
        return sb.toString();
    }
}
