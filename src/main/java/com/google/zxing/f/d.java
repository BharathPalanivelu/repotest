package com.google.zxing.f;

public final class d extends k {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f14712a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f14713b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14714c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f14715d;

    /* renamed from: e  reason: collision with root package name */
    private final String[] f14716e;

    /* renamed from: f  reason: collision with root package name */
    private final String[] f14717f;

    /* renamed from: g  reason: collision with root package name */
    private final String[] f14718g;
    private final String h;
    private final String i;
    private final String[] j;
    private final String[] k;
    private final String l;
    private final String m;
    private final String n;
    private final String[] o;
    private final String[] p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(l.ADDRESSBOOK);
        this.f14712a = strArr;
        this.f14713b = strArr2;
        this.f14714c = str;
        this.f14715d = strArr3;
        this.f14716e = strArr4;
        this.f14717f = strArr5;
        this.f14718g = strArr6;
        this.h = str2;
        this.i = str3;
        this.j = strArr7;
        this.k = strArr8;
        this.l = str4;
        this.m = str5;
        this.n = str6;
        this.o = strArr9;
        this.p = strArr10;
    }

    public String a() {
        StringBuilder sb = new StringBuilder(100);
        a(this.f14712a, sb);
        a(this.f14713b, sb);
        a(this.f14714c, sb);
        a(this.n, sb);
        a(this.l, sb);
        a(this.j, sb);
        a(this.f14715d, sb);
        a(this.f14717f, sb);
        a(this.h, sb);
        a(this.o, sb);
        a(this.m, sb);
        a(this.p, sb);
        a(this.i, sb);
        return sb.toString();
    }
}
