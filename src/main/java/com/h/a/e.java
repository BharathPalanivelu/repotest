package com.h.a;

import android.content.SharedPreferences;
import com.h.a.c;

public abstract class e<ValueType, T extends c> {

    /* renamed from: a  reason: collision with root package name */
    private final T f14796a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f14797b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14798c;

    /* access modifiers changed from: protected */
    public abstract ValueType a(SharedPreferences sharedPreferences, String str, ValueType valuetype);

    /* access modifiers changed from: protected */
    public abstract void a(SharedPreferences.Editor editor, String str, ValueType valuetype);

    protected e(T t, SharedPreferences sharedPreferences, String str) {
        this.f14797b = sharedPreferences;
        this.f14798c = str;
        this.f14796a = t;
    }

    public T a(ValueType valuetype) {
        a(this.f14796a.w(), this.f14798c, valuetype);
        return this.f14796a;
    }

    public ValueType b(ValueType valuetype) {
        return a(this.f14797b, this.f14798c, valuetype);
    }
}
