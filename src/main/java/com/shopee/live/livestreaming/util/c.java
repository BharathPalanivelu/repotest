package com.shopee.live.livestreaming.util;

import com.shopee.live.livestreaming.data.entity.LiveStreamingRoomConfigEntity;
import com.shopee.live.livestreaming.ui.audience.e;
import com.shopee.sdk.b;
import java.text.DecimalFormat;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private e f29432a;

    /* renamed from: b  reason: collision with root package name */
    private LiveStreamingRoomConfigEntity f29433b;

    /* renamed from: c  reason: collision with root package name */
    private String f29434c;

    /* renamed from: d  reason: collision with root package name */
    private String f29435d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29436e = true;

    public c(e eVar) {
        this.f29432a = eVar;
    }

    private boolean e() {
        return this.f29433b.getCoin_status() == 0;
    }

    private boolean f() {
        return b.a().d().b();
    }

    private boolean g() {
        return this.f29433b.getClaim_times_left() == 0;
    }

    private boolean h() {
        return this.f29433b.getRemain_locks() == 0;
    }

    private boolean i() {
        return 1 == this.f29433b.getCan_claim();
    }

    private boolean j() {
        return k() || l();
    }

    private boolean k() {
        return e() && f() && !g() && i();
    }

    private boolean l() {
        return !e() && f() && !g() && i();
    }

    private boolean m() {
        return e() && f() && !g() && !i() && h();
    }

    private boolean n() {
        return e() && f() && !g() && !i() && !h();
    }

    private boolean o() {
        return e() && f() && g();
    }

    private boolean p() {
        return e() && !f();
    }

    public void a(float f2) {
        this.f29434c = new DecimalFormat("#.##").format((double) f2);
        String str = this.f29434c;
        this.f29435d = str;
        if ((!str.contains(".") && this.f29434c.length() == 5) || this.f29434c.length() > 5) {
            this.f29434c = "";
        }
    }

    public void a(LiveStreamingRoomConfigEntity liveStreamingRoomConfigEntity) {
        this.f29433b = liveStreamingRoomConfigEntity;
    }

    public String a() {
        return this.f29435d;
    }

    public String b() {
        return this.f29434c;
    }

    public boolean c() {
        return this.f29436e;
    }

    public void d() {
        if (j()) {
            this.f29432a.a(this.f29434c);
            this.f29432a.h();
            com.shopee.live.livestreaming.ui.audience.c.a(1);
        } else if (n()) {
            this.f29432a.c();
        } else if (m()) {
            this.f29432a.g();
            com.shopee.live.livestreaming.ui.audience.c.a(2);
        } else if (p()) {
            this.f29432a.a(this.f29434c);
            this.f29432a.e();
            com.shopee.live.livestreaming.ui.audience.c.a(4);
        } else if (o()) {
            com.shopee.live.livestreaming.ui.audience.c.a(3);
            this.f29432a.f();
        } else {
            this.f29436e = false;
            this.f29432a.d();
        }
    }
}
