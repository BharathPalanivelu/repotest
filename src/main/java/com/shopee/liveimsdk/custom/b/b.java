package com.shopee.liveimsdk.custom.b;

import f.b.a.a;
import f.e;
import f.n;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f29610a;

    /* renamed from: b  reason: collision with root package name */
    private OkHttpClient f29611b;

    /* renamed from: c  reason: collision with root package name */
    private CookieJar f29612c;

    /* renamed from: d  reason: collision with root package name */
    private n f29613d;

    public void a(String str) {
    }

    private b() {
    }

    public static b a() {
        if (f29610a == null) {
            f29610a = new b();
        }
        return f29610a;
    }

    public n b() {
        if (this.f29613d == null) {
            this.f29613d = new n.a().a(a.a()).a((e.a) a.a()).a(com.shopee.sdk.b.a().g().a()).a();
        }
        return this.f29613d;
    }

    public static void c() {
        b bVar = f29610a;
        if (bVar != null) {
            bVar.f29611b = null;
            bVar.f29612c = null;
            bVar.f29613d = null;
        }
        f29610a = null;
    }
}
