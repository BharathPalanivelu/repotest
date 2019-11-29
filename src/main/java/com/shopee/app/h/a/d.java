package com.shopee.app.h.a;

import com.beetalklib.a.a.b;

public abstract class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f17609a;

    /* renamed from: b  reason: collision with root package name */
    private String f17610b;

    public d(String str) {
        this.f17609a = str;
    }

    public void onError(int i) {
        if (i == 16 || i == 34) {
            a.a().a(this.f17609a, this.f17610b);
        }
    }

    public void a(String str) {
        this.f17610b = str;
    }
}
