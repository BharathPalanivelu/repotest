package io.a.a.a.a.g;

import android.content.Context;
import io.a.a.a.a.b.g;
import io.a.a.a.a.b.l;
import io.a.a.a.a.b.p;
import io.a.a.a.a.b.t;
import io.a.a.a.a.e.e;
import io.a.a.a.c;
import io.a.a.a.i;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<t> f33257a;

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f33258b;

    /* renamed from: c  reason: collision with root package name */
    private s f33259c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f33260d;

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final q f33261a = new q();
    }

    public static q a() {
        return a.f33261a;
    }

    private q() {
        this.f33257a = new AtomicReference<>();
        this.f33258b = new CountDownLatch(1);
        this.f33260d = false;
    }

    public synchronized q a(i iVar, p pVar, e eVar, String str, String str2, String str3) {
        i iVar2 = iVar;
        synchronized (this) {
            if (this.f33260d) {
                return this;
            }
            if (this.f33259c == null) {
                Context r = iVar.r();
                String c2 = pVar.c();
                String a2 = new g().a(r);
                String i = pVar.i();
                t tVar = new t();
                k kVar = new k();
                i iVar3 = new i(iVar2);
                String k = io.a.a.a.a.b.i.k(r);
                String str4 = str3;
                l lVar = new l(iVar2, str4, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{c2}), eVar);
                String g2 = pVar.g();
                String f2 = pVar.f();
                String str5 = f2;
                String str6 = str2;
                String str7 = str;
                i iVar4 = iVar;
                this.f33259c = new j(iVar4, new w(a2, g2, str5, pVar.e(), pVar.k(), pVar.b(), pVar.l(), io.a.a.a.a.b.i.a(io.a.a.a.a.b.i.m(r)), str6, str7, l.determineFrom(i).getId(), k), tVar, kVar, iVar3, lVar);
            }
            this.f33260d = true;
            return this;
        }
    }

    public t b() {
        try {
            this.f33258b.await();
            return this.f33257a.get();
        } catch (InterruptedException unused) {
            c.h().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean c() {
        t a2;
        a2 = this.f33259c.a();
        a(a2);
        return a2 != null;
    }

    public synchronized boolean d() {
        t a2;
        a2 = this.f33259c.a(r.SKIP_CACHE_LOOKUP);
        a(a2);
        if (a2 == null) {
            c.h().e("Fabric", "Failed to force reload of settings from Crashlytics.", (Throwable) null);
        }
        return a2 != null;
    }

    private void a(t tVar) {
        this.f33257a.set(tVar);
        this.f33258b.countDown();
    }
}
