package com.garena.reactpush.b;

import android.content.SharedPreferences;
import com.garena.reactpush.b;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final SharedPreferences f8334a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f8335b;

    /* renamed from: c  reason: collision with root package name */
    protected final String f8336c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.a.c.a f8337d;

    public a(SharedPreferences sharedPreferences, String str, String str2, com.google.a.c.a aVar) {
        this.f8334a = sharedPreferences;
        this.f8335b = str;
        this.f8336c = str2;
        this.f8337d = aVar;
    }

    public T a() {
        try {
            return b.f6698a.a(this.f8334a.getString(this.f8335b, this.f8336c), this.f8337d.getType());
        } catch (Exception unused) {
            this.f8334a.edit().putString(this.f8335b, this.f8336c).apply();
            return b.f6698a.a(this.f8336c, this.f8337d.getType());
        }
    }

    public void a(T t) {
        try {
            this.f8334a.edit().putString(this.f8335b, b.f6698a.b(t, this.f8337d.getType())).apply();
        } catch (OutOfMemoryError unused) {
            this.f8334a.edit().putString(this.f8335b, this.f8336c).apply();
        }
    }
}
