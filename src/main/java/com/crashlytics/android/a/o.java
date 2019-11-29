package com.crashlytics.android.a;

import android.content.Context;
import com.crashlytics.android.a.ad;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import io.a.a.a.a.b.g;
import io.a.a.a.a.d.f;
import io.a.a.a.a.e.e;
import io.a.a.a.a.g.b;
import io.a.a.a.c;
import io.a.a.a.i;
import io.a.a.a.l;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class o implements ac {

    /* renamed from: a  reason: collision with root package name */
    final ae f6350a;

    /* renamed from: b  reason: collision with root package name */
    f f6351b;

    /* renamed from: c  reason: collision with root package name */
    g f6352c = new g();

    /* renamed from: d  reason: collision with root package name */
    p f6353d = new u();

    /* renamed from: e  reason: collision with root package name */
    boolean f6354e = true;

    /* renamed from: f  reason: collision with root package name */
    boolean f6355f = true;

    /* renamed from: g  reason: collision with root package name */
    volatile int f6356g = -1;
    boolean h = false;
    boolean i = false;
    private final i j;
    private final e k;
    private final Context l;
    private final z m;
    private final ScheduledExecutorService n;
    private final AtomicReference<ScheduledFuture<?>> o = new AtomicReference<>();
    private final r p;

    public o(i iVar, Context context, ScheduledExecutorService scheduledExecutorService, z zVar, e eVar, ae aeVar, r rVar) {
        this.j = iVar;
        this.l = context;
        this.n = scheduledExecutorService;
        this.m = zVar;
        this.k = eVar;
        this.f6350a = aeVar;
        this.p = rVar;
    }

    public void a(b bVar, String str) {
        String str2;
        String str3;
        this.f6351b = j.a(new aa(this.j, str, bVar.f33201a, this.k, this.f6352c.a(this.l)));
        this.m.a(bVar);
        this.h = bVar.f33206f;
        this.i = bVar.f33207g;
        l h2 = c.h();
        StringBuilder sb = new StringBuilder();
        sb.append("Firebase analytics forwarding ");
        boolean z = this.h;
        String str4 = ViewProps.ENABLED;
        sb.append(z ? str4 : "disabled");
        h2.a("Answers", sb.toString());
        l h3 = c.h();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Firebase analytics including purchase events ");
        if (this.i) {
            str2 = str4;
        } else {
            str2 = "disabled";
        }
        sb2.append(str2);
        h3.a("Answers", sb2.toString());
        this.f6354e = bVar.h;
        l h4 = c.h();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Custom event tracking ");
        if (this.f6354e) {
            str3 = str4;
        } else {
            str3 = "disabled";
        }
        sb3.append(str3);
        h4.a("Answers", sb3.toString());
        this.f6355f = bVar.i;
        l h5 = c.h();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Predefined event tracking ");
        if (!this.f6355f) {
            str4 = "disabled";
        }
        sb4.append(str4);
        h5.a("Answers", sb4.toString());
        if (bVar.k > 1) {
            c.h().a("Answers", "Event sampling enabled");
            this.f6353d = new y(bVar.k);
        }
        this.f6356g = bVar.f33202b;
        a(0, (long) this.f6356g);
    }

    public void a(ad.a aVar) {
        ad a2 = aVar.a(this.f6350a);
        if (!this.f6354e && ad.b.CUSTOM.equals(a2.f6285c)) {
            l h2 = c.h();
            h2.a("Answers", "Custom events tracking disabled - skipping event: " + a2);
        } else if (!this.f6355f && ad.b.PREDEFINED.equals(a2.f6285c)) {
            l h3 = c.h();
            h3.a("Answers", "Predefined events tracking disabled - skipping event: " + a2);
        } else if (this.f6353d.a(a2)) {
            l h4 = c.h();
            h4.a("Answers", "Skipping filtered event: " + a2);
        } else {
            try {
                this.m.a(a2);
            } catch (IOException e2) {
                l h5 = c.h();
                h5.e("Answers", "Failed to write event: " + a2, e2);
            }
            e();
            boolean z = ad.b.CUSTOM.equals(a2.f6285c) || ad.b.PREDEFINED.equals(a2.f6285c);
            boolean equals = ProductAction.ACTION_PURCHASE.equals(a2.f6289g);
            if (this.h && z) {
                if (!equals || this.i) {
                    try {
                        this.p.a(a2);
                    } catch (Exception e3) {
                        l h6 = c.h();
                        h6.e("Answers", "Failed to map event to Firebase: " + a2, e3);
                    }
                }
            }
        }
    }

    public void e() {
        if (this.f6356g != -1) {
            a((long) this.f6356g, (long) this.f6356g);
        }
    }

    public void a() {
        if (this.f6351b == null) {
            io.a.a.a.a.b.i.a(this.l, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        io.a.a.a.a.b.i.a(this.l, "Sending all files");
        List<File> e2 = this.m.e();
        int i2 = 0;
        while (true) {
            try {
                if (e2.size() <= 0) {
                    break;
                }
                io.a.a.a.a.b.i.a(this.l, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(e2.size())}));
                boolean a2 = this.f6351b.a(e2);
                if (a2) {
                    i2 += e2.size();
                    this.m.a(e2);
                }
                if (!a2) {
                    break;
                }
                e2 = this.m.e();
            } catch (Exception e3) {
                Context context = this.l;
                io.a.a.a.a.b.i.a(context, "Failed to send batch of analytics files to server: " + e3.getMessage(), (Throwable) e3);
            }
        }
        if (i2 == 0) {
            this.m.g();
        }
    }

    public void d() {
        if (this.o.get() != null) {
            io.a.a.a.a.b.i.a(this.l, "Cancelling time-based rollover because no events are currently being generated.");
            this.o.get().cancel(false);
            this.o.set((Object) null);
        }
    }

    public void b() {
        this.m.f();
    }

    public boolean c() {
        try {
            return this.m.d();
        } catch (IOException e2) {
            io.a.a.a.a.b.i.a(this.l, "Failed to roll file over.", (Throwable) e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j2, long j3) {
        if (this.o.get() == null) {
            io.a.a.a.a.d.i iVar = new io.a.a.a.a.d.i(this.l, this);
            Context context = this.l;
            io.a.a.a.a.b.i.a(context, "Scheduling time based file roll over every " + j3 + " seconds");
            try {
                this.o.set(this.n.scheduleAtFixedRate(iVar, j2, j3, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e2) {
                io.a.a.a.a.b.i.a(this.l, "Failed to schedule time based file roll over", (Throwable) e2);
            }
        }
    }
}
