package com.shopee.feeds.feedlibrary.data.d;

import android.content.SharedPreferences;
import com.shopee.feeds.feedlibrary.data.a.a;
import com.shopee.sdk.e.a.c;
import com.shopee.sdk.e.a.d;

public class b extends com.shopee.sdk.e.b {

    /* renamed from: a  reason: collision with root package name */
    private d<com.shopee.feeds.feedlibrary.data.a.b> f27731a;

    /* renamed from: b  reason: collision with root package name */
    private c.a.a.a.b f27732b;

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.sdk.e.a.b<a> f27733c;

    /* renamed from: d  reason: collision with root package name */
    private c.a.a.a.b f27734d;

    /* renamed from: e  reason: collision with root package name */
    private c.a.a.a.b f27735e;

    /* renamed from: f  reason: collision with root package name */
    private c.a.a.a.b f27736f;

    /* renamed from: g  reason: collision with root package name */
    private c f27737g;
    private c h;
    private c i;
    private c j;

    public b(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f27731a = new d<>(sharedPreferences, "feed_setting", com.shopee.sdk.f.a.f30358b, com.shopee.feeds.feedlibrary.data.a.b.class);
        this.f27732b = new c.a.a.a.b(sharedPreferences, "feed_status", 0);
        this.f27734d = new c.a.a.a.b(sharedPreferences, "user_type", 0);
        this.f27733c = new com.shopee.sdk.e.a.b<>(sharedPreferences, "feed_list", a.class);
        this.f27735e = new c.a.a.a.b(sharedPreferences, "feed_share_ins", 0);
        this.f27736f = new c.a.a.a.b(sharedPreferences, "feed_save_album", 0);
        this.f27737g = new c(sharedPreferences, "feed_save_album", Integer.class, Integer.class);
        this.h = new c(sharedPreferences, "feed_share_ins", Integer.class, Integer.class);
        this.i = new c(sharedPreferences, "feed_share_ins", Integer.class, Integer.class);
        this.j = new c(sharedPreferences, "feed_picture_opi", Integer.class, Integer.class);
    }

    public boolean a() {
        return this.f27734d.a() == 5;
    }

    public void a(int i2) {
        this.f27734d.a(i2);
    }

    public void a(int i2, int i3) {
        this.f27737g.a(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void b(int i2, int i3) {
        this.h.a(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public boolean b(int i2) {
        c cVar = this.f27737g;
        return (cVar == null || cVar.a(Integer.valueOf(i2)) == null || ((Integer) this.f27737g.a(Integer.valueOf(i2))).intValue() != 1) ? false : true;
    }

    public boolean c(int i2) {
        c cVar = this.h;
        return (cVar == null || cVar.a(Integer.valueOf(i2)) == null || ((Integer) this.h.a(Integer.valueOf(i2))).intValue() != 1) ? false : true;
    }

    public void c(int i2, int i3) {
        this.i.a(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void d(int i2, int i3) {
        this.j.a(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public int d(int i2) {
        c cVar = this.i;
        if (cVar == null || cVar.a(Integer.valueOf(i2)) == null) {
            return 2;
        }
        c cVar2 = this.i;
        if (cVar2 == null || cVar2.a(Integer.valueOf(i2)) == null) {
            return 0;
        }
        return ((Integer) this.i.a(Integer.valueOf(i2))).intValue();
    }
}
