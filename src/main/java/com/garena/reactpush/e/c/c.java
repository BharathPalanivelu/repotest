package com.garena.reactpush.e.c;

import android.content.Context;
import com.garena.reactpush.b.b;
import com.garena.reactpush.c.d;
import com.garena.reactpush.c.f;
import com.garena.reactpush.d.a;
import com.garena.reactpush.d.h;
import com.garena.reactpush.data.BundleState;
import com.garena.reactpush.e.c.a;
import java.util.concurrent.CountDownLatch;

public class c implements com.garena.reactpush.d.c {

    /* renamed from: a  reason: collision with root package name */
    private b f8420a;

    /* renamed from: b  reason: collision with root package name */
    private a f8421b;

    /* renamed from: c  reason: collision with root package name */
    private a f8422c;

    /* renamed from: d  reason: collision with root package name */
    private h f8423d;

    /* renamed from: e  reason: collision with root package name */
    private Context f8424e;

    public c(b bVar, a aVar, a aVar2, h hVar, Context context) {
        this.f8420a = bVar;
        this.f8421b = aVar;
        this.f8422c = aVar2;
        this.f8423d = hVar;
        this.f8424e = context;
    }

    public void a(final com.garena.reactpush.d.b bVar, final boolean z) {
        if (a(z)) {
            bVar.f();
        } else {
            com.garena.reactpush.c.a.a(new Runnable() {
                public void run() {
                    c.this.b(bVar, z);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(com.garena.reactpush.d.b bVar, boolean z) {
        a(bVar);
        BundleState c2 = this.f8420a.c();
        boolean a2 = this.f8421b.a();
        if (!a2) {
            com.garena.reactpush.b.f6701d.a("Loading Disk Bundle.");
            a2 = this.f8421b.a(this.f8420a.a(), c2);
            d dVar = com.garena.reactpush.b.f6701d;
            dVar.a("Loading Disk Bundle. [Valid=" + a2 + "]");
        }
        if (!a2) {
            boolean a3 = this.f8423d.a(this.f8424e);
            c2.setNeedImageZipDownload(true);
            this.f8420a.a(c2);
            d dVar2 = com.garena.reactpush.b.f6701d;
            dVar2.a("Loading Packaged Bundle. [Success=" + a3 + "]");
            if (a3) {
                a2 = this.f8421b.a(this.f8420a.a(), c2);
            }
        }
        if (!a2) {
            d(bVar);
        }
        if (a2) {
            if (a(z)) {
                c(bVar);
            } else {
                this.f8422c.a(this.f8420a.a());
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                this.f8422c.a((a.C0144a) new a.C0144a() {
                    public void a() {
                        countDownLatch.countDown();
                    }
                });
                this.f8422c.a(z);
                try {
                    countDownLatch.await();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                c(bVar);
                this.f8422c.a((a.C0144a) null);
                com.garena.reactpush.b.f6701d.a("Loading Disk Bundle. [Done]");
                e(bVar);
            }
            c2.setSyncLocalSuccess();
            this.f8420a.a(c2);
            b(bVar);
            this.f8423d.a();
        }
    }

    private boolean a(boolean z) {
        return (!z && this.f8422c.b()) || this.f8422c.c();
    }

    /* access modifiers changed from: protected */
    public void a(final com.garena.reactpush.d.b bVar) {
        f.a(new Runnable() {
            public void run() {
                bVar.d();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void b(final com.garena.reactpush.d.b bVar) {
        f.a(new Runnable() {
            public void run() {
                bVar.e();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void c(final com.garena.reactpush.d.b bVar) {
        f.a(new Runnable() {
            public void run() {
                bVar.f();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void d(final com.garena.reactpush.d.b bVar) {
        f.a(new Runnable() {
            public void run() {
                bVar.s_();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void e(final com.garena.reactpush.d.b bVar) {
        f.a(new Runnable() {
            public void run() {
                bVar.t_();
            }
        });
    }
}
