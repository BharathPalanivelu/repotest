package com.google.android.libraries.places.internal;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.android.b.m;
import com.c.a.j;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.libraries.places.api.net.PlacesClient;

public class fx implements ny {

    /* renamed from: a  reason: collision with root package name */
    public final aw f12593a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f12594b;

    /* renamed from: c  reason: collision with root package name */
    public final dw f12595c;

    /* renamed from: d  reason: collision with root package name */
    public ny<Context> f12596d;

    /* renamed from: e  reason: collision with root package name */
    public ny<Context> f12597e;

    public static j a(Context context) {
        return (j) lt.a(fw.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    public /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public PlacesClient a() {
        return q();
    }

    public fx(Context context, aw awVar, dw dwVar) {
        this.f12593a = awVar;
        this.f12594b = context;
        this.f12595c = dwVar;
        b(context);
    }

    public static gb c() {
        return new gb((byte) 0);
    }

    public fg d() {
        return new fg(this.f12594b);
    }

    public m e() {
        return gb.a(this.f12597e.b());
    }

    public gg f() {
        return dq.a(e(), new dr());
    }

    public j g() {
        return a(this.f12597e.b());
    }

    public dq h() {
        return dr.a(g());
    }

    public fw i() {
        return ft.a(this.f12593a, d(), f(), h());
    }

    public FusedLocationProviderClient j() {
        return fv.a(this.f12597e.b());
    }

    public static fv k() {
        return new fv(new ft());
    }

    public d l() {
        return fu.a(j(), k());
    }

    public WifiManager m() {
        return fu.b(this.f12597e.b());
    }

    public j n() {
        return fw.a(m(), b.a());
    }

    public ClearcutLogger o() {
        return ds.a(this.f12594b);
    }

    public ds p() {
        return gg.a(o(), this.f12595c, (dz) this.f12593a);
    }

    public u q() {
        return dv.a(i(), l(), n(), p(), b.a());
    }

    public void b(Context context) {
        this.f12596d = new nw(lt.a(context, "instance cannot be null"));
        this.f12597e = nv.a(new av(this.f12596d));
    }

    public /* synthetic */ fx(Context context, aw awVar, dw dwVar, byte b2) {
        this(context, awVar, dwVar);
    }
}
