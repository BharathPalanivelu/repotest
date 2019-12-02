package com.shopee.live.livestreaming.ui.floatwindow.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.shopee.live.livestreaming.a.h;
import com.shopee.live.livestreaming.ui.audience.activity.LiveStreamingAudienceActivity;
import com.shopee.live.livestreaming.ui.audience.activity.LiveStreamingReplayActivity;
import com.shopee.live.livestreaming.ui.floatwindow.a.b;
import com.shopee.live.livestreaming.ui.floatwindow.a.c;

public class FloatVideoService extends Service implements com.shopee.live.livestreaming.ui.floatwindow.service.b {

    /* renamed from: a  reason: collision with root package name */
    private interfaceA f29074a;

    /* renamed from: b  reason: collision with root package name */
    private com.shopee.live.livestreaming.ui.floatwindow.b.a f29075b;

    /* renamed from: c  reason: collision with root package name */
    private h f29076c;

    /* renamed from: d  reason: collision with root package name */
    private c f29077d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29078e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f29079f;

    public IBinder onBind(Intent intent) {
        this.f29076c = new h(getApplication());
        return new a();
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        b();
        h hVar = this.f29076c;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f29075b != null) {
            this.f29075b = null;
        }
        this.f29077d = null;
        if (this.f29078e) {
            com.shopee.live.livestreaming.ui.audience.c.p();
        }
    }

    // ini dipanggil sama com.shopee.live.livestreaming.ui.floatwindow.b.b()
    // antara close atau video cover
    // ini pindah ke LiveStreamingReplayActivity atau LiveStreamingAudienceActivity
    public void a() {
        b();
        try {
            Intent intent = new Intent(this, this.f29074a.f29082a == 2 ? LiveStreamingReplayActivity.class : LiveStreamingAudienceActivity.class);
            intent.addFlags(335544320);
            startActivity(intent);
        } catch (Exception e2) {
            com.shopee.e.a.a.a(e2, "back failure", new Object[0]);
        }
    }

    public void b() {
        c();
        f();
    }

    public void c() {
        c cVar = this.f29077d;
        if (cVar != null) {
            cVar.a();
        }
        this.f29079f = false;
    }

    // ini gerbang masuk
    /* access modifiers changed from: private */
    public void a(interfaceA aVar) {
        this.f29074a = aVar;
        if (this.f29074a.f29082a == 1) {
            this.f29077d = new com.shopee.live.livestreaming.ui.floatwindow.a.a();
        } else {
            this.f29077d = new com.shopee.live.livestreaming.ui.floatwindow.a.b();
        }
        if (this.f29075b == null) {
            this.f29075b = new com.shopee.live.livestreaming.ui.floatwindow.b.a();
            this.f29075b.a(getApplicationContext());
            this.f29075b.a((com.shopee.live.livestreaming.ui.floatwindow.service.b) this);
        }
        this.f29075b.a(this.f29074a.f29085d, this.f29074a.f29086e);
        this.f29075b.a(this.f29074a.f29084c);
        this.f29075b.a();
        this.f29079f = true;
        this.f29078e = true;
        com.shopee.live.livestreaming.ui.audience.c.o();
        h hVar = this.f29076c;
        if (hVar != null) {
            hVar.a((h.a) new h.a() {
                public void a() {
                    FloatVideoService.this.d();
                }

                public void b() {
                    FloatVideoService.this.e();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.f29078e && this.f29075b != null) {
            c cVar = this.f29077d;
            if (cVar != null) {
                cVar.a();
            }
            this.f29075b.b();
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.f29078e) {
            com.shopee.live.livestreaming.ui.floatwindow.b.a aVar = this.f29075b;
            if (aVar != null) {
                aVar.a();
                c cVar = this.f29077d;
                if (cVar != null) {
                    cVar.b();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        com.shopee.live.livestreaming.ui.floatwindow.b.a aVar = this.f29075b;
        if (aVar != null && this.f29078e) {
            // ada disini dia, yang buat2 viewnya
            aVar.b();
            this.f29078e = false;
        }
    }

    public class a extends Binder {
        public a() {
        }

        public void a(interfaceA aVar) {
            FloatVideoService.this.a(aVar);
        }

        public void a() {
            FloatVideoService.this.f();
        }
    }
}
