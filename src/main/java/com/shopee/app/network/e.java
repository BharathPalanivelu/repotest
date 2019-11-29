package com.shopee.app.network;

import com.beetalklib.network.a.a.a;
import com.beetalklib.network.a.c.c;
import com.beetalklib.network.d.f;
import com.garena.f.b;
import com.garena.f.d;
import com.garena.f.g;
import com.garena.f.i;
import com.garena.f.j;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.h.p;
import com.shopee.app.network.c.i.w;
import com.squareup.wire.Message;
import javax.net.ssl.SSLSocketFactory;

public class e implements b, com.garena.f.e {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f18471a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static e f18472b;

    /* renamed from: c  reason: collision with root package name */
    private final SettingConfigStore f18473c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f18474d = true;

    /* renamed from: e  reason: collision with root package name */
    private p f18475e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f18476f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public d f18477g;
    private final int h;
    private Runnable i = new Runnable() {
        public void run() {
            synchronized (this) {
                boolean unused = e.this.f18474d = true;
                e.this.f18476f.a(true);
                e.this.f18477g.c();
                e.this.a("Do Connect");
            }
        }
    };

    public static e c() {
        e eVar = f18472b;
        if (eVar == null) {
            synchronized (f18471a) {
                eVar = f18472b;
                if (eVar == null) {
                    eVar = new e();
                    f18472b = eVar;
                }
            }
        }
        return eVar;
    }

    private e() {
        ar f2 = ar.f();
        this.f18475e = f2.e().serverManager();
        this.f18473c = f2.e().settingConfigStore();
        this.h = this.f18473c.getRequestTimeout();
        f.a();
        this.f18477g = f2.l().a(f2.e().forbiddenZoneStore().a(), this);
        this.f18476f = new a(new h());
    }

    public void d() {
        com.garena.android.appkit.f.e.a().a(this.i);
    }

    public boolean e() {
        return this.f18477g.b();
    }

    public void a(final boolean z) {
        com.garena.android.appkit.f.e.a().a(new Runnable() {
            public void run() {
                synchronized (this) {
                    boolean unused = e.this.f18474d = z;
                    e.this.f18476f.a(z);
                    e.this.f18477g.d();
                    e eVar = e.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Do Disconnect | Retry: ");
                    sb.append(z ? "YES" : "NO");
                    eVar.a(sb.toString());
                }
            }
        });
    }

    public boolean f() {
        return this.f18477g.a();
    }

    public com.garena.f.a.e a(com.garena.f.a.e eVar) {
        f c2 = ((com.shopee.app.network.e.a) eVar.a().b()).c();
        com.shopee.app.network.a.a a2 = f.a(c2.a());
        if (a2 == null) {
            byte[] b2 = c2.b();
            c.a().a(c2.a(), b2, b2.length);
            return new com.garena.f.a.e((j) null);
        }
        if (a2 instanceof w) {
            byte[] b3 = c2.b();
            c.a().a(c2.a(), b3, b3.length);
        }
        return eVar;
    }

    public int a(f fVar, String str, String str2, Message message) {
        this.f18477g.a(new i.a().a((com.garena.h.e) new com.shopee.app.network.e.a(str2, message, fVar)).a(str).a(this.h).a()).a(new com.garena.f.f() {
            public void a(i iVar, j jVar) {
                if (jVar.a() == com.garena.h.a.d.SENDING_FAILED) {
                    com.shopee.app.network.e.a aVar = (com.shopee.app.network.e.a) jVar.b();
                    byte[] bytes = aVar.a().getBytes();
                    c.a().b(aVar.c().a(), bytes, bytes.length);
                }
            }

            public void b(i iVar, j jVar) {
                com.shopee.app.network.e.a aVar = (com.shopee.app.network.e.a) jVar.b();
                byte[] b2 = aVar.c().b();
                c.a().a(aVar.c().a(), b2, b2.length);
            }
        });
        return 1;
    }

    public com.garena.h.b.a b() {
        String str = com.shopee.app.util.i.f7039b;
        String[] split = this.f18475e.b().split(":");
        if (this.f18473c.sslEnabled()) {
            try {
                return new com.garena.h.b.a("SHOPEE_CORE_SERVER_SSL", split[0], 20443, SSLSocketFactory.getDefault().createSocket(split[0], 20443));
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
        return new com.garena.h.b.a("SHOPEE_CORE_SERVER", split[0], Integer.parseInt(split[1]));
    }

    public synchronized void a() {
        a("Notify Connected");
        this.f18476f.e();
        c.a().a(235, new byte[0], 0);
    }

    public synchronized void a(com.garena.h.a.d dVar) {
        a("Notify Disconnected");
        this.f18476f.d();
        c.a().a(236, new byte[0], 0);
    }

    public g b(com.garena.h.a.d dVar) {
        if (this.f18476f.b()) {
            if (dVar == com.garena.h.a.d.UNKNOWN_HOST || this.f18476f.c()) {
                a("Switch Server");
                this.f18475e.e();
                this.f18476f.a();
            }
            int f2 = this.f18476f.f();
            a("Delay Retry | In: " + f2 + "ms");
            return g.a(f2);
        }
        a("Closed Forever");
        return g.f7979a;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        com.garena.android.appkit.d.a.a("CONNECTION: %1$s", str);
    }
}
