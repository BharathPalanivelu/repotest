package com.shopee.app.application.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.garena.android.appkit.tools.a.a;
import com.shopee.app.application.a.b;
import com.shopee.app.application.ar;
import com.shopee.app.network.e;
import com.shopee.shopeetracker.Injection;
import com.shopee.shopeetracker.ShopeeTracker;

public class c implements b.a, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Handler f15821a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private boolean f15822b = true;

    /* renamed from: c  reason: collision with root package name */
    private int f15823c = -1;

    public void a(Activity activity) {
    }

    public void b(Activity activity) {
    }

    public void c(Activity activity) {
    }

    public void d(Activity activity) {
    }

    public void e(Activity activity) {
    }

    public void f(Activity activity) {
    }

    public void a(ar arVar, Activity activity) {
        this.f15822b = false;
        this.f15821a.removeCallbacks(this);
        a(arVar);
    }

    public void b(ar arVar, Activity activity) {
        this.f15822b = true;
        this.f15821a.postDelayed(this, 3000);
    }

    public void run() {
        if (this.f15822b) {
            this.f15823c = a.a();
            ar.f().e().cleanTemporaryFilesInteractor().f();
            a(false);
            ar.f().e().actionTracker().a();
            org.a.a.a.a((Runnable) new Runnable() {
                public void run() {
                    if (ShopeeTracker.isInitialized() && ShopeeTracker.getInstance().isEnabled()) {
                        Injection.provideEventSender().sendEvents();
                    }
                }
            });
        }
    }

    private void a(boolean z) {
        if (ShopeeTracker.isInitialized() && ShopeeTracker.getInstance().isEnabled()) {
            ShopeeTracker.getInstance().schedule(z);
        }
    }

    private void a(ar arVar) {
        boolean z = this.f15823c == -1;
        boolean z2 = this.f15823c > 0;
        if (z2) {
            com.shopee.app.pushnotification.c.a((Context) arVar);
            e.c().d();
            arVar.e().clearNotificationInteractor().a();
        }
        if (z || (z2 && a.a() - this.f15823c > 900)) {
            arVar.e().tracker().b(arVar.e().loggedInUser().getUserId());
        }
        a(true);
        this.f15823c = 0;
    }
}
