package com.crashlytics.android.a;

import android.content.Context;
import com.crashlytics.android.a.ad;
import io.a.a.a.a.d.d;
import io.a.a.a.a.e.e;
import io.a.a.a.a.g.b;
import io.a.a.a.c;
import io.a.a.a.i;
import java.util.concurrent.ScheduledExecutorService;

class f implements d {

    /* renamed from: a  reason: collision with root package name */
    final ScheduledExecutorService f6317a;

    /* renamed from: b  reason: collision with root package name */
    ac f6318b = new n();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final i f6319c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Context f6320d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final g f6321e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final ag f6322f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final e f6323g;
    /* access modifiers changed from: private */
    public final r h;

    public f(i iVar, Context context, g gVar, ag agVar, e eVar, ScheduledExecutorService scheduledExecutorService, r rVar) {
        this.f6319c = iVar;
        this.f6320d = context;
        this.f6321e = gVar;
        this.f6322f = agVar;
        this.f6323g = eVar;
        this.f6317a = scheduledExecutorService;
        this.h = rVar;
    }

    public void a(ad.a aVar) {
        a(aVar, false, false);
    }

    public void b(ad.a aVar) {
        a(aVar, false, true);
    }

    public void c(ad.a aVar) {
        a(aVar, true, false);
    }

    public void a(final b bVar, final String str) {
        b((Runnable) new Runnable() {
            public void run() {
                try {
                    f.this.f6318b.a(bVar, str);
                } catch (Exception e2) {
                    c.h().e("Answers", "Failed to set analytics settings data", e2);
                }
            }
        });
    }

    public void a() {
        b((Runnable) new Runnable() {
            public void run() {
                try {
                    ac acVar = f.this.f6318b;
                    f.this.f6318b = new n();
                    acVar.b();
                } catch (Exception e2) {
                    c.h().e("Answers", "Failed to disable events", e2);
                }
            }
        });
    }

    public void a(String str) {
        b((Runnable) new Runnable() {
            public void run() {
                try {
                    f.this.f6318b.a();
                } catch (Exception e2) {
                    c.h().e("Answers", "Failed to send events files", e2);
                }
            }
        });
    }

    public void b() {
        b((Runnable) new Runnable() {
            public void run() {
                try {
                    ae a2 = f.this.f6322f.a();
                    z a3 = f.this.f6321e.a();
                    a3.a((d) f.this);
                    f.this.f6318b = new o(f.this.f6319c, f.this.f6320d, f.this.f6317a, a3, f.this.f6323g, a2, f.this.h);
                } catch (Exception e2) {
                    c.h().e("Answers", "Failed to enable events", e2);
                }
            }
        });
    }

    public void c() {
        b((Runnable) new Runnable() {
            public void run() {
                try {
                    f.this.f6318b.c();
                } catch (Exception e2) {
                    c.h().e("Answers", "Failed to flush events", e2);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(final ad.a aVar, boolean z, final boolean z2) {
        AnonymousClass6 r0 = new Runnable() {
            public void run() {
                try {
                    f.this.f6318b.a(aVar);
                    if (z2) {
                        f.this.f6318b.c();
                    }
                } catch (Exception e2) {
                    c.h().e("Answers", "Failed to process event", e2);
                }
            }
        };
        if (z) {
            a((Runnable) r0);
        } else {
            b((Runnable) r0);
        }
    }

    private void a(Runnable runnable) {
        try {
            this.f6317a.submit(runnable).get();
        } catch (Exception e2) {
            c.h().e("Answers", "Failed to run events task", e2);
        }
    }

    private void b(Runnable runnable) {
        try {
            this.f6317a.submit(runnable);
        } catch (Exception e2) {
            c.h().e("Answers", "Failed to submit events task", e2);
        }
    }
}
