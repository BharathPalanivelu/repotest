package com.shopee.live.livestreaming.ui.audience;

import android.app.Application;
import com.shopee.live.livestreaming.a.c;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.util.b;

// renamed from: com.shopee.live.livestreaming.ui.audience.a;
//public class a extends c<e> {
public class classA extends c<e> {

    /* renamed from: b  reason: collision with root package name */
    private b f28926b;

    /* renamed from: c  reason: collision with root package name */
    private LiveStreamingSessionEntity.Session f28927c;

    /* renamed from: d  reason: collision with root package name */
    private com.shopee.live.livestreaming.ui.view.b.a f28928d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f28929e = false;

    public classA(e eVar, com.shopee.live.livestreaming.ui.view.b.b bVar) {
        this.f28926b = new b(eVar);
        this.f28928d = new com.shopee.live.livestreaming.ui.view.b.a();
        this.f28928d.a(bVar);
        this.f28928d.c(100);
    }

    public void a(LiveStreamingSessionEntity.Session session) {
        if (session != null) {
            this.f28927c = session;
            this.f28929e = false;
            this.f28926b.a(session.getSession_id());
            this.f28926b.b(session.getUid());
            this.f28926b.a();
        }
    }

    public void c() {
        if (this.f28927c != null) {
            this.f28929e = false;
            this.f28926b.a();
        }
    }

    public void d() {
        if (!this.f28929e) {
            this.f28926b.f();
        }
    }

    public void e() {
        this.f28926b.b();
    }

    public void f() {
        this.f28926b.e();
    }

    public void g() {
        this.f28926b.c();
    }

    public void a(int i) {
        this.f28928d.a(i);
    }

    public void h() {
        this.f28928d.a();
    }

    public void a(Application application) {
        this.f28928d.a(application);
    }
}
