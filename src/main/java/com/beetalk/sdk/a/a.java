package com.beetalk.sdk.a;

import android.content.Context;
import android.content.SharedPreferences;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected SharedPreferences f5370a;

    /* access modifiers changed from: protected */
    public abstract Context a();

    /* access modifiers changed from: protected */
    public String c() {
        return "";
    }

    public a() {
        b();
    }

    public void b() {
        if (this.f5370a == null) {
            Context a2 = a();
            if (a2 != null) {
                this.f5370a = a2.getSharedPreferences(c(), 0);
            }
        }
    }

    public void a(String str, long j) {
        SharedPreferences sharedPreferences = this.f5370a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(str, j);
            edit.apply();
        }
    }
}
