package com.airpay.paysdk.pay.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f4159a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4160b = false;

    public static c a() {
        if (f4159a == null) {
            synchronized (c.class) {
                if (f4159a == null) {
                    f4159a = new c();
                }
            }
        }
        return f4159a;
    }

    public boolean b() {
        return this.f4160b;
    }

    public void c() {
        this.f4160b = false;
    }

    public void d() {
        this.f4160b = true;
    }
}
