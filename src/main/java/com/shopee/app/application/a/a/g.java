package com.shopee.app.application.a.a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.garena.android.appkit.f.e;
import com.shopee.app.application.a.b;
import com.shopee.app.application.ar;

public class g implements b.a, Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static int f15829a = 3000;

    /* renamed from: b  reason: collision with root package name */
    public static int f15830b = 60000;

    /* renamed from: c  reason: collision with root package name */
    private Handler f15831c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private boolean f15832d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15833e = false;

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
        this.f15832d = false;
        this.f15831c.removeCallbacks(this);
        b();
    }

    public void b(ar arVar, Activity activity) {
        this.f15832d = true;
        this.f15831c.postDelayed(this, (long) a(arVar));
    }

    public void run() {
        if (this.f15832d) {
            c();
        }
    }

    private void b() {
        e.a().a(new Runnable() {
            public void run() {
                com.shopee.app.network.e.c().d();
            }
        });
    }

    private void c() {
        e.a().a(new Runnable() {
            public void run() {
                com.shopee.app.network.e.c().a(false);
            }
        });
    }

    public void a() {
        this.f15833e = true;
    }

    private int a(ar arVar) {
        int i = f15829a;
        try {
            com.shopee.app.util.k.g a2 = arVar.e().productUploader().a();
            if (a2 != null && a2.a()) {
                i = f15830b;
            }
        } catch (Exception unused) {
        }
        if (!this.f15833e) {
            return i;
        }
        int i2 = f15830b;
        this.f15833e = false;
        return i2;
    }
}
