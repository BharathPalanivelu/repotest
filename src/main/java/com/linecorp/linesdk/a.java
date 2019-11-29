package com.linecorp.linesdk;

import java.util.NoSuchElementException;

public class a<R> {

    /* renamed from: a  reason: collision with root package name */
    private static final a<?> f14994a = new a<>(b.SUCCESS, (Object) null, LineApiError.f14985a);

    /* renamed from: b  reason: collision with root package name */
    private final b f14995b;

    /* renamed from: c  reason: collision with root package name */
    private final R f14996c;

    /* renamed from: d  reason: collision with root package name */
    private final LineApiError f14997d;

    private a(b bVar, R r, LineApiError lineApiError) {
        this.f14995b = bVar;
        this.f14996c = r;
        this.f14997d = lineApiError;
    }

    public static <T> a<T> a(T t) {
        return t == null ? f14994a : new a<>(b.SUCCESS, t, LineApiError.f14985a);
    }

    public static <T> a<T> a(b bVar, LineApiError lineApiError) {
        return new a<>(bVar, (Object) null, lineApiError);
    }

    public boolean a() {
        return this.f14995b == b.SUCCESS;
    }

    public b b() {
        return this.f14995b;
    }

    public R c() {
        R r = this.f14996c;
        if (r != null) {
            return r;
        }
        throw new NoSuchElementException("response data is null. Please check result by isSuccess before.");
    }

    public LineApiError d() {
        return this.f14997d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f14995b != aVar.f14995b) {
            return false;
        }
        R r = this.f14996c;
        if (r == null ? aVar.f14996c == null : r.equals(aVar.f14996c)) {
            return this.f14997d.equals(aVar.f14997d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f14995b.hashCode() * 31;
        R r = this.f14996c;
        return ((hashCode + (r != null ? r.hashCode() : 0)) * 31) + this.f14997d.hashCode();
    }

    public String toString() {
        return "LineApiResponse{errorData=" + this.f14997d + ", responseCode=" + this.f14995b + ", responseData=" + this.f14996c + '}';
    }
}
