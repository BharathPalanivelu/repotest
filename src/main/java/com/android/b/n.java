package com.android.b;

import com.android.b.b;

public class n<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f4626a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f4627b;

    /* renamed from: c  reason: collision with root package name */
    public final s f4628c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4629d;

    public interface a {
        void onErrorResponse(s sVar);
    }

    public interface b<T> {
        void onResponse(T t);
    }

    public static <T> n<T> a(T t, b.a aVar) {
        return new n<>(t, aVar);
    }

    public static <T> n<T> a(s sVar) {
        return new n<>(sVar);
    }

    public boolean a() {
        return this.f4628c == null;
    }

    private n(T t, b.a aVar) {
        this.f4629d = false;
        this.f4626a = t;
        this.f4627b = aVar;
        this.f4628c = null;
    }

    private n(s sVar) {
        this.f4629d = false;
        this.f4626a = null;
        this.f4627b = null;
        this.f4628c = sVar;
    }
}
