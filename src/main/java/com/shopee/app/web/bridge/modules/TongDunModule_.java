package com.shopee.app.web.bridge.modules;

import android.content.Context;
import org.a.a.a;

public final class TongDunModule_ extends TongDunModule {
    private Context context_;

    private void init_() {
    }

    private TongDunModule_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static TongDunModule_ getInstance_(Context context) {
        return new TongDunModule_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    public void collectBlackbox() {
        a.a((a.C0532a) new a.C0532a("", 0, "") {
            public void execute() {
                try {
                    TongDunModule_.super.collectBlackbox();
                } catch (Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        });
    }
}
