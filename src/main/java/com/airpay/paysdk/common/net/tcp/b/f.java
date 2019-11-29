package com.airpay.paysdk.common.net.tcp.b;

import com.airpay.paysdk.common.net.tcp.d.a;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private int f4061a;

    /* renamed from: b  reason: collision with root package name */
    private a f4062b;

    /* renamed from: c  reason: collision with root package name */
    private int f4063c;

    /* renamed from: d  reason: collision with root package name */
    private int f4064d;

    /* renamed from: e  reason: collision with root package name */
    private String f4065e;

    public f(int i, int i2, a aVar) {
        this.f4061a = i;
        this.f4062b = aVar;
        this.f4063c = i2;
    }

    public f(int i, a aVar) {
        this.f4062b = aVar;
        this.f4063c = i;
    }

    public int a() {
        return this.f4061a;
    }

    public byte[] b() {
        return this.f4062b.b();
    }

    public int c() {
        return this.f4063c;
    }

    public int d() {
        return this.f4064d;
    }

    public void a(int i) {
        this.f4064d = i;
    }

    public String e() {
        return this.f4065e;
    }

    public void a(String str) {
        this.f4065e = str;
    }
}
