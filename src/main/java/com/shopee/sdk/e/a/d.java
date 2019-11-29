package com.shopee.sdk.e.a;

import android.content.SharedPreferences;
import com.google.a.c.a;
import java.lang.reflect.Type;

public class d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f30352a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30353b;

    /* renamed from: c  reason: collision with root package name */
    private final String f30354c;

    /* renamed from: d  reason: collision with root package name */
    private final a f30355d;

    /* renamed from: e  reason: collision with root package name */
    private T f30356e;

    public d(SharedPreferences sharedPreferences, String str, String str2, Class<T> cls) {
        this(sharedPreferences, str, str2, (a) a.getParameterized(cls, new Type[0]));
    }

    public d(SharedPreferences sharedPreferences, String str, String str2, a aVar) {
        this.f30352a = sharedPreferences;
        this.f30353b = str;
        this.f30354c = str2;
        this.f30355d = aVar;
    }

    public T c() {
        T t = this.f30356e;
        if (t != null) {
            return t;
        }
        try {
            this.f30356e = com.shopee.sdk.f.a.f30357a.a(this.f30352a.getString(this.f30353b, this.f30354c), this.f30355d.getType());
            return this.f30356e;
        } catch (Exception unused) {
            this.f30352a.edit().putString(this.f30353b, this.f30354c).apply();
            return com.shopee.sdk.f.a.f30357a.a(this.f30354c, this.f30355d.getType());
        }
    }

    public void b(T t) {
        this.f30356e = t;
        this.f30352a.edit().putString(this.f30353b, com.shopee.sdk.f.a.f30357a.b(t, this.f30355d.getType())).apply();
    }
}
