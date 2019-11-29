package com.shopee.app.data;

import com.shopee.app.web.WebRegister;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f17147a;

    /* renamed from: b  reason: collision with root package name */
    private String f17148b;

    /* renamed from: c  reason: collision with root package name */
    private String f17149c;

    /* renamed from: d  reason: collision with root package name */
    private long f17150d;

    /* renamed from: e  reason: collision with root package name */
    private long f17151e;

    public int a() {
        return this.f17147a;
    }

    public void a(int i) {
        this.f17147a = i;
    }

    public String b() {
        return this.f17148b;
    }

    public void a(String str) {
        this.f17148b = str;
    }

    public void b(String str) {
        this.f17149c = str;
    }

    public long c() {
        return this.f17150d;
    }

    public void a(long j) {
        this.f17150d = j;
    }

    public long d() {
        return this.f17151e;
    }

    public void b(long j) {
        this.f17151e = j;
    }

    public String toString() {
        return WebRegister.GSON.b((Object) this);
    }
}
