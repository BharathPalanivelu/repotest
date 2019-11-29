package com.shopee.b.a;

import android.content.Context;
import d.d.b.j;
import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final long f27099a;

    /* renamed from: b  reason: collision with root package name */
    private final String f27100b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27101c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f27102d;

    /* renamed from: e  reason: collision with root package name */
    private final String f27103e;

    public d(Context context) {
        j.b(context, "context");
        a aVar = new a(context);
        this.f27099a = aVar.r() / ((long) 1000);
        this.f27100b = aVar.q();
        this.f27101c = aVar.s();
        this.f27102d = aVar.t();
        this.f27103e = aVar.u();
    }

    public final long a() {
        return this.f27099a;
    }

    public final String b() {
        return this.f27100b;
    }

    public final String c() {
        return this.f27101c;
    }

    public final boolean d() {
        return this.f27102d;
    }

    public final String e() {
        return this.f27103e;
    }

    public final JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("boot_timestamp", this.f27099a);
            jSONObject.put("carrier", this.f27100b);
            jSONObject.put("timezone", this.f27101c);
            jSONObject.put("jailbreak", this.f27102d);
            jSONObject.put("phone_number", this.f27103e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
