package com.garena.pay.android.d;

import com.litesuits.orm.db.assit.SQLBuilder;

public class c {

    /* renamed from: a  reason: collision with root package name */
    int f8209a;

    /* renamed from: b  reason: collision with root package name */
    String f8210b;

    public c(int i, String str) {
        this.f8209a = i;
        if (str == null || str.trim().length() == 0) {
            this.f8210b = b.a(i);
            return;
        }
        this.f8210b = str + " (response: " + b.a(i) + SQLBuilder.PARENTHESES_RIGHT;
    }

    public int a() {
        return this.f8209a;
    }

    public String b() {
        return this.f8210b;
    }

    public boolean c() {
        return this.f8209a == 0;
    }

    public boolean d() {
        return !c();
    }

    public String toString() {
        return "IabResult: " + b();
    }
}
