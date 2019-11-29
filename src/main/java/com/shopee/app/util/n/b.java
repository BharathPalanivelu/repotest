package com.shopee.app.util.n;

import android.text.TextUtils;
import com.garena.android.appkit.tools.a.a;
import com.shopee.app.application.ar;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f26452a = false;

    /* renamed from: b  reason: collision with root package name */
    private String f26453b;

    /* renamed from: c  reason: collision with root package name */
    private long f26454c;

    /* renamed from: d  reason: collision with root package name */
    private String f26455d;

    /* renamed from: e  reason: collision with root package name */
    private int f26456e;

    /* renamed from: f  reason: collision with root package name */
    private long f26457f;

    public b(String str) {
        this.f26454c = 0;
        this.f26456e = 0;
        this.f26457f = 0;
        this.f26453b = str;
    }

    public b() {
        this.f26454c = 0;
        this.f26456e = 0;
        this.f26457f = 0;
        this.f26453b = "";
    }

    public void a(String str) {
        this.f26453b = str;
    }

    public void a() {
        if (f26452a) {
            long b2 = a.b();
            long j = this.f26457f;
            if (j == 0) {
                this.f26457f = b2;
                return;
            }
            if (b2 - j < 500) {
                this.f26456e++;
            } else if (b2 - j > 2000) {
                this.f26456e = 0;
            }
            if (this.f26456e >= 7) {
                this.f26456e = 0;
                com.garena.reactpush.a.a.a(this.f26453b, new RuntimeException(this.f26453b + " has run multiple times in a short interval. You may want to check it."));
            }
            this.f26457f = b2;
        }
    }

    public void b() {
        if (f26452a) {
            this.f26455d = Thread.currentThread().getName();
            this.f26454c = a.b();
        }
    }

    public void c() {
        if (f26452a) {
            com.garena.android.appkit.d.a.b("_INTERACTOR: " + this.f26453b, new Object[0]);
            if (this.f26455d.equals(Thread.currentThread().getName())) {
                long b2 = a.b() - this.f26454c;
                if (b2 > 600) {
                    String str = this.f26453b;
                    com.garena.reactpush.a.a.a(str, new RuntimeException(this.f26453b + " has a running time of " + b2 + "ms. You may want to optimize this."));
                }
            }
        }
    }

    public void a(Exception exc) {
        if (f26452a) {
            com.garena.reactpush.a.a.a((Throwable) exc);
        }
        if (!b(exc)) {
            ar.f().e().fabricClient().a((Throwable) exc, "crash_from:Interactor");
        }
    }

    public static boolean b(Exception exc) {
        boolean z = !TextUtils.isEmpty(exc.getMessage()) && exc.getMessage().contains("attempt to re-open an already-closed");
        boolean z2 = !TextUtils.isEmpty(exc.getMessage()) && exc.getMessage().contains("already closed");
        boolean z3 = !TextUtils.isEmpty(exc.getMessage()) && exc.getMessage().contains("connection pool has been closed");
        if (z2 || z || z3) {
            return true;
        }
        return false;
    }
}
