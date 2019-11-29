package com.shopee.app.application.a.a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.a.b;
import com.shopee.app.application.ar;

public class a implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private static long f15813a = -1;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Handler f15814b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private int f15815c = 0;

    /* renamed from: d  reason: collision with root package name */
    private Runnable f15816d = new Runnable() {
        public void run() {
            if (a.this.a()) {
                com.garena.android.appkit.b.b.a("ACTIVITY_KILL_SIGNAL", new com.garena.android.appkit.b.a(), b.a.UI_BUS);
                a.this.f15814b.postDelayed(a.this.f15817e, 5000);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Runnable f15817e = new Runnable() {
        public void run() {
            if (a.this.a()) {
                System.exit(0);
            }
        }
    };

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
        this.f15815c = 0;
        this.f15814b.removeCallbacks(this.f15816d);
        this.f15814b.removeCallbacks(this.f15817e);
    }

    public void b(ar arVar, Activity activity) {
        this.f15815c = com.garena.android.appkit.tools.a.a.a();
        f15813a = (long) arVar.e().settingConfigStore().selfKillInterval();
        long j = f15813a;
        if (j > 0) {
            this.f15814b.postDelayed(this.f15816d, j * 1000);
        }
    }

    /* access modifiers changed from: private */
    public boolean a() {
        return this.f15815c != 0 && com.garena.android.appkit.tools.a.a.a() - this.f15815c > 10;
    }
}
