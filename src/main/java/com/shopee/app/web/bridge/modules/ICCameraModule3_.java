package com.shopee.app.web.bridge.modules;

import android.content.Context;
import org.a.a.a;
import org.a.a.b;

public final class ICCameraModule3_ extends ICCameraModule3 {
    private Context context_;

    private void init_() {
    }

    private ICCameraModule3_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static ICCameraModule3_ getInstance_(Context context) {
        return new ICCameraModule3_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    public void resolvePromise$app_indonesiaRelease(final String str) {
        b.a("", new Runnable() {
            public void run() {
                ICCameraModule3_.super.resolvePromise$app_indonesiaRelease(str);
            }
        }, 0);
    }

    public void onError$app_indonesiaRelease(final int i, final String str) {
        b.a("", new Runnable() {
            public void run() {
                ICCameraModule3_.super.onError$app_indonesiaRelease(i, str);
            }
        }, 0);
    }

    public void imageToBase64$app_indonesiaRelease(String str, int i) {
        final String str2 = str;
        final int i2 = i;
        a.a((a.C0532a) new a.C0532a("", 0, "") {
            public void execute() {
                try {
                    ICCameraModule3_.super.imageToBase64$app_indonesiaRelease(str2, i2);
                } catch (Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        });
    }
}
