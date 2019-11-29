package com.airpay.paysdk.pay.ui;

import androidx.m.a.a.c;
import java.lang.ref.WeakReference;

public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f4305a;

    /* renamed from: b  reason: collision with root package name */
    private c f4306b;

    /* renamed from: c  reason: collision with root package name */
    private int f4307c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Runnable f4308d = new Runnable() {
        public void run() {
            b.this.d();
            com.airpay.paysdk.common.c.a.a().a(b.this.f4308d, (long) b.this.f4305a);
        }
    };

    public interface a {
        void onStop();
    }

    public b(c cVar, int i) {
        this.f4306b = cVar;
        this.f4305a = i;
    }

    public void a() {
        d();
        com.airpay.paysdk.common.c.a.a().a(this.f4308d, (long) this.f4305a);
    }

    public void b() {
        com.airpay.paysdk.common.c.a.a().b(this.f4308d);
        this.f4306b.stop();
        this.f4306b = null;
    }

    public void c() {
        com.airpay.paysdk.common.c.a.a().b(this.f4308d);
        this.f4306b.stop();
    }

    public void a(a aVar) {
        com.airpay.paysdk.common.c.a.a().b(this.f4308d);
        if (aVar != null) {
            int a2 = (this.f4307c + this.f4305a) - com.airpay.paysdk.base.d.c.a();
            if (a2 > 0) {
                final WeakReference weakReference = new WeakReference(aVar);
                com.airpay.paysdk.common.c.a.a().a(new Runnable() {
                    public void run() {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.onStop();
                        }
                    }
                }, (long) a2);
                return;
            }
            aVar.onStop();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.f4306b.isRunning()) {
            this.f4306b.stop();
        }
        this.f4306b.start();
        this.f4307c = com.airpay.paysdk.base.d.c.a();
    }
}
