package com.shopee.app.util;

import android.content.SharedPreferences;
import com.google.a.c.a;
import com.shopee.app.web.WebRegister;

public class ad<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final SharedPreferences f26128a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f26129b;

    /* renamed from: c  reason: collision with root package name */
    protected final String f26130c;

    /* renamed from: d  reason: collision with root package name */
    private final a f26131d;

    public ad(SharedPreferences sharedPreferences, String str, String str2, a aVar) {
        this.f26128a = sharedPreferences;
        this.f26129b = str;
        this.f26130c = str2;
        this.f26131d = aVar;
    }

    public T a() {
        try {
            return WebRegister.GSON.a(this.f26128a.getString(this.f26129b, this.f26130c), this.f26131d.getType());
        } catch (Exception unused) {
            this.f26128a.edit().putString(this.f26129b, this.f26130c).apply();
            return WebRegister.GSON.a(this.f26130c, this.f26131d.getType());
        }
    }

    public void a(T t) {
        this.f26128a.edit().putString(this.f26129b, WebRegister.GSON.b(t, this.f26131d.getType())).apply();
    }

    public void b() {
        this.f26128a.edit().remove(this.f26129b).apply();
    }
}
