package com.shopee.b.a;

import android.content.Context;
import com.facebook.common.util.ByteConstants;
import d.d.b.j;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f27092a;

    /* renamed from: b  reason: collision with root package name */
    private final String f27093b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27094c;

    /* renamed from: d  reason: collision with root package name */
    private final String f27095d;

    /* renamed from: e  reason: collision with root package name */
    private final String f27096e;

    /* renamed from: f  reason: collision with root package name */
    private final String f27097f;

    /* renamed from: g  reason: collision with root package name */
    private final String f27098g;
    private final String h;
    private final String i;
    private final long j;
    private final long k;
    private final long l;
    private final int m;
    private final int n;

    public c(Context context) {
        j.b(context, "context");
        a aVar = new a(context);
        this.f27092a = aVar.a();
        this.f27093b = aVar.b();
        this.f27094c = aVar.c();
        this.f27095d = aVar.d();
        this.f27096e = aVar.e();
        this.f27097f = aVar.g();
        this.f27098g = aVar.h();
        this.h = aVar.i();
        this.i = aVar.j();
        this.j = aVar.f() / ((long) 1000);
        this.k = aVar.k() / ((long) 1024);
        this.l = aVar.l() / ((long) ByteConstants.MB);
        this.m = aVar.p();
        this.n = aVar.o();
    }

    public final String a() {
        return this.f27092a;
    }

    public final String b() {
        return this.f27093b;
    }

    public final String c() {
        return this.f27094c;
    }

    public final String d() {
        return this.f27095d;
    }

    public final String e() {
        return this.f27096e;
    }

    public final String f() {
        return this.f27097f;
    }

    public final String g() {
        return this.f27098g;
    }

    public final String h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final long j() {
        return this.j;
    }

    public final long k() {
        return this.k;
    }

    public final long l() {
        return this.l;
    }

    public final int m() {
        return this.m;
    }

    public final int n() {
        return this.n;
    }

    public final JSONObject o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manufacturer", this.f27092a);
            jSONObject.put("model", this.f27093b);
            jSONObject.put("kernel", this.f27094c);
            jSONObject.put("product", this.f27095d);
            jSONObject.put("brand", this.f27096e);
            jSONObject.put("device_name", this.f27097f);
            jSONObject.put("mac_address", this.f27098g);
            jSONObject.put("bluetooth_mac_address", this.h);
            jSONObject.put("android_ID", this.i);
            jSONObject.put("build_time", this.j);
            jSONObject.put("total_memory", this.k);
            jSONObject.put("total_storage", this.l);
            jSONObject.put("screen_width", this.m);
            jSONObject.put("screen_height", this.n);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
