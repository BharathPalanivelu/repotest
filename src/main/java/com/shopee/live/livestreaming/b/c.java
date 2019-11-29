package com.shopee.live.livestreaming.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.a.o;
import com.shopee.e.a.a;
import com.shopee.live.livestreaming.b.b;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f28773a;

    /* renamed from: b  reason: collision with root package name */
    private TXCloudVideoView f28774b;

    /* renamed from: c  reason: collision with root package name */
    private a f28775c;

    /* renamed from: d  reason: collision with root package name */
    private b.a f28776d;

    /* renamed from: e  reason: collision with root package name */
    private String f28777e = "";

    /* renamed from: f  reason: collision with root package name */
    private int f28778f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f28779g;
    private boolean h;
    private boolean i = true;
    private float j = 1.0f;
    private float k = 1.0f;
    private float l = 1.0f;

    public void c() {
    }

    public void d() {
    }

    public View a(Context context) {
        this.f28773a = context;
        this.f28774b = new TXCloudVideoView(context);
        f();
        return this.f28774b;
    }

    public void a(o oVar) {
        if (oVar.c("url") != null) {
            this.f28777e = oVar.c("url").c();
        }
        if (oVar.c("type") != null) {
            this.f28778f = oVar.c("type").g();
        }
        if (oVar.c("renderAdjust") != null) {
            this.f28779g = oVar.c("renderAdjust").h();
        }
        if (oVar.c("autoAdjustCacheTime") != null) {
            this.i = oVar.c("autoAdjustCacheTime").h();
        }
        if (oVar.c("minAutoAdjustCacheTime") != null) {
            this.l = oVar.c("minAutoAdjustCacheTime").e();
        }
        if (oVar.c("maxAutoAdjustCacheTime") != null) {
            this.k = oVar.c("maxAutoAdjustCacheTime").e();
        }
        if (oVar.c("cacheTime") != null) {
            this.j = oVar.c("cacheTime").e();
        }
        int i2 = this.f28778f;
        if (i2 < 0 || i2 > 3) {
            this.f28778f = 0;
        }
        f();
    }

    private void f() {
        if (!TextUtils.isEmpty(this.f28777e) && this.f28773a != null) {
            if (this.f28775c == null) {
                if (h()) {
                    d dVar = new d(this.f28773a);
                    dVar.a(this.i, this.l, this.k, this.j);
                    this.f28775c = dVar;
                } else {
                    this.f28775c = new e(this.f28773a);
                }
                this.f28775c.a(this.f28779g);
                b.a aVar = this.f28776d;
                if (aVar != null) {
                    this.f28775c.a(aVar);
                }
            }
            TXCloudVideoView tXCloudVideoView = this.f28774b;
            if (tXCloudVideoView != null) {
                this.f28775c.a(tXCloudVideoView);
            }
            boolean z = this.h;
            if (z) {
                this.f28775c.b(z);
                a.a("TXVideoView: %s", "init, setMute");
            }
        }
    }

    public void a() {
        g().a(this.f28777e, this.f28778f);
    }

    public void b() {
        g().a();
    }

    public void a(int i2) {
        g().a(i2);
    }

    public void a(boolean z) {
        this.h = z;
        g().b(z);
        a.a("TXVideoView: %s", "setMute");
    }

    public void a(b.a aVar) {
        this.f28776d = aVar;
        if (this.f28776d != null) {
            g().a(this.f28776d);
        }
    }

    public void e() {
        g().b();
        this.f28774b.onDestroy();
    }

    private a g() {
        a aVar = this.f28775c;
        if (aVar != null) {
            return aVar;
        }
        return new a() {
            public void a() {
            }

            public void a(int i) {
            }

            public void a(b.a aVar) {
            }

            public void a(TXCloudVideoView tXCloudVideoView) {
            }

            public void a(String str, int i) {
            }

            public void a(boolean z) {
            }

            public void b() {
            }

            public void b(boolean z) {
            }
        };
    }

    private boolean h() {
        return this.f28778f != 2;
    }
}
