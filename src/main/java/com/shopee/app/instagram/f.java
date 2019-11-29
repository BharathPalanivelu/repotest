package com.shopee.app.instagram;

import android.content.Context;
import org.a.a.a;

public final class f extends e {

    /* renamed from: a  reason: collision with root package name */
    private Context f17760a;

    private void k() {
    }

    private f(Context context) {
        this.f17760a = context;
        k();
    }

    public static f b(Context context) {
        return new f(context);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a.a((a.C0532a) new a.C0532a("", 0, "") {
            public void execute() {
                try {
                    f.super.e();
                } catch (Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void f() {
        a.a((a.C0532a) new a.C0532a("", 0, "") {
            public void execute() {
                try {
                    f.super.f();
                } catch (Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        });
    }
}
