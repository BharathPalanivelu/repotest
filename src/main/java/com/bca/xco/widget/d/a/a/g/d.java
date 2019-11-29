package com.bca.xco.widget.d.a.a.g;

import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.b.h;
import okhttp3.internal.http2.Header;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final h f4910a = h.a(Header.RESPONSE_STATUS_UTF8);

    /* renamed from: b  reason: collision with root package name */
    public static final h f4911b = h.a(Header.TARGET_METHOD_UTF8);

    /* renamed from: c  reason: collision with root package name */
    public static final h f4912c = h.a(Header.TARGET_PATH_UTF8);

    /* renamed from: d  reason: collision with root package name */
    public static final h f4913d = h.a(Header.TARGET_SCHEME_UTF8);

    /* renamed from: e  reason: collision with root package name */
    public static final h f4914e = h.a(Header.TARGET_AUTHORITY_UTF8);

    /* renamed from: f  reason: collision with root package name */
    public final h f4915f;

    /* renamed from: g  reason: collision with root package name */
    public final h f4916g;
    final int h;

    public d(String str, String str2) {
        this(h.a(str), h.a(str2));
    }

    public d(h hVar, String str) {
        this(hVar, h.a(str));
    }

    public d(h hVar, h hVar2) {
        this.f4915f = hVar;
        this.f4916g = hVar2;
        this.h = hVar.e() + 32 + hVar2.e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f4915f.equals(dVar.f4915f) || !this.f4916g.equals(dVar.f4916g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f4915f.hashCode()) * 31) + this.f4916g.hashCode();
    }

    public String toString() {
        return c.a("%s: %s", this.f4915f.a(), this.f4916g.a());
    }
}
