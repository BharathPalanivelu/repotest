package com.linecorp.linesdk.a;

import android.content.Context;
import com.linecorp.a.a.a.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14998a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14999b;

    /* renamed from: c  reason: collision with root package name */
    private final b f15000c;

    public a(Context context, String str) {
        this(context.getApplicationContext(), str, c.a());
    }

    private a(Context context, String str, b bVar) {
        this.f14998a = context;
        this.f14999b = "com.linecorp.linesdk.accesstoken." + str;
        this.f15000c = bVar;
    }

    public final void a(d dVar) {
        this.f14998a.getSharedPreferences(this.f14999b, 0).edit().putString("accessToken", a(dVar.f15029a)).putString("expiresIn", a(dVar.f15030b)).putString("issuedClientTime", a(dVar.f15031c)).putString("refreshToken", a(dVar.f15032d)).apply();
    }

    private String a(String str) {
        return this.f15000c.a(this.f14998a, str);
    }

    private String a(long j) {
        return this.f15000c.a(this.f14998a, String.valueOf(j));
    }
}
