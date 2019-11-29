package com.shopee.b.a;

import android.content.Context;
import com.facebook.common.util.ByteConstants;
import d.d.b.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final float f27085a;

    /* renamed from: b  reason: collision with root package name */
    private final float f27086b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f27087c;

    /* renamed from: d  reason: collision with root package name */
    private final int f27088d;

    /* renamed from: e  reason: collision with root package name */
    private final long f27089e;

    /* renamed from: f  reason: collision with root package name */
    private final long f27090f;

    /* renamed from: g  reason: collision with root package name */
    private final int f27091g;

    public b(Context context) {
        j.b(context, "context");
        a aVar = new a(context);
        this.f27085a = aVar.x();
        this.f27086b = aVar.v();
        this.f27087c = aVar.w();
        this.f27088d = aVar.y();
        this.f27089e = aVar.m() / ((long) ByteConstants.MB);
        this.f27091g = aVar.z();
        this.f27090f = aVar.n() / ((long) 1024);
    }

    public final float a() {
        return this.f27085a;
    }

    public final float b() {
        return this.f27086b;
    }

    public final boolean c() {
        return this.f27087c;
    }

    public final int d() {
        return this.f27088d;
    }

    public final long e() {
        return this.f27089e;
    }

    public final long f() {
        return this.f27090f;
    }

    public final int g() {
        return this.f27091g;
    }
}
