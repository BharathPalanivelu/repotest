package com.google.zxing.f;

public final class s extends k {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f14741a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f14742b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14743c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14744d;

    public s(String str, String str2, String str3, String str4) {
        super(l.SMS);
        this.f14741a = new String[]{str};
        this.f14742b = new String[]{str2};
        this.f14743c = str3;
        this.f14744d = str4;
    }

    public s(String[] strArr, String[] strArr2, String str, String str2) {
        super(l.SMS);
        this.f14741a = strArr;
        this.f14742b = strArr2;
        this.f14743c = str;
        this.f14744d = str2;
    }

    public String a() {
        StringBuilder sb = new StringBuilder(100);
        a(this.f14741a, sb);
        a(this.f14743c, sb);
        a(this.f14744d, sb);
        return sb.toString();
    }
}
