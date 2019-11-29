package com.shopee.app.web.bridge.modules;

import android.content.Context;
import org.a.a.a;
import org.a.a.b;

@Deprecated
public final class ICImageModule1_ extends ICImageModule1 {
    private Context context_;

    private void init_() {
    }

    private ICImageModule1_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static ICImageModule1_ getInstance_(Context context) {
        return new ICImageModule1_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    /* access modifiers changed from: package-private */
    public void resolvePromise(final String str, final int i) {
        b.a("", new Runnable() {
            public void run() {
                ICImageModule1_.super.resolvePromise(str, i);
            }
        }, 0);
    }

    /* access modifiers changed from: package-private */
    public void rejectPromise(final int i, final String str) {
        b.a("", new Runnable() {
            public void run() {
                ICImageModule1_.super.rejectPromise(i, str);
            }
        }, 0);
    }

    /* access modifiers changed from: package-private */
    public void imageToBase64(String str, int i) {
        final String str2 = str;
        final int i2 = i;
        a.a((a.C0532a) new a.C0532a("", 0, "") {
            public void execute() {
                try {
                    ICImageModule1_.super.imageToBase64(str2, i2);
                } catch (Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        });
    }
}
