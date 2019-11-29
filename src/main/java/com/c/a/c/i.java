package com.c.a.c;

import com.c.a.i.h;
import java.security.MessageDigest;

public final class i<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final a<Object> f6108a = new a<Object>() {
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final T f6109b;

    /* renamed from: c  reason: collision with root package name */
    private final a<T> f6110c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6111d;

    /* renamed from: e  reason: collision with root package name */
    private volatile byte[] f6112e;

    public interface a<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    public static <T> i<T> a(String str) {
        return new i<>(str, (Object) null, c());
    }

    public static <T> i<T> a(String str, T t) {
        return new i<>(str, t, c());
    }

    public static <T> i<T> a(String str, T t, a<T> aVar) {
        return new i<>(str, t, aVar);
    }

    i(String str, T t, a<T> aVar) {
        this.f6111d = h.a(str);
        this.f6109b = t;
        this.f6110c = (a) h.a(aVar);
    }

    public T a() {
        return this.f6109b;
    }

    public void a(T t, MessageDigest messageDigest) {
        this.f6110c.a(b(), t, messageDigest);
    }

    private byte[] b() {
        if (this.f6112e == null) {
            this.f6112e = this.f6111d.getBytes(h.f6107a);
        }
        return this.f6112e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f6111d.equals(((i) obj).f6111d);
        }
        return false;
    }

    public int hashCode() {
        return this.f6111d.hashCode();
    }

    private static <T> a<T> c() {
        return f6108a;
    }

    public String toString() {
        return "Option{key='" + this.f6111d + '\'' + '}';
    }
}
