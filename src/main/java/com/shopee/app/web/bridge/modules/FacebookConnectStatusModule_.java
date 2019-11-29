package com.shopee.app.web.bridge.modules;

import android.content.Context;
import org.a.a.a;
import org.a.a.b;

public final class FacebookConnectStatusModule_ extends FacebookConnectStatusModule {
    private Context context_;

    private void init_() {
    }

    private FacebookConnectStatusModule_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static FacebookConnectStatusModule_ getInstance_(Context context) {
        return new FacebookConnectStatusModule_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    public void resolvePromise(final int i, final String str) {
        b.a("", new Runnable() {
            public void run() {
                FacebookConnectStatusModule_.super.resolvePromise(i, str);
            }
        }, 0);
    }

    public void rejectPromise() {
        b.a("", new Runnable() {
            public void run() {
                FacebookConnectStatusModule_.super.rejectPromise();
            }
        }, 0);
    }

    public void checkFbConnectStatus() {
        a.a((a.C0532a) new a.C0532a("", 0, "") {
            public void execute() {
                try {
                    FacebookConnectStatusModule_.super.checkFbConnectStatus();
                } catch (Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        });
    }
}
