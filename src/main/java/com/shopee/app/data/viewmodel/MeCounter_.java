package com.shopee.app.data.viewmodel;

import android.content.Context;
import org.a.a.a;

public final class MeCounter_ extends MeCounter {
    private Context context_;

    private void init_() {
    }

    private MeCounter_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static MeCounter_ getInstance_(Context context) {
        return new MeCounter_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    /* access modifiers changed from: package-private */
    public void saveCoin() {
        a.a((a.C0532a) new a.C0532a("", 0, "") {
            public void execute() {
                try {
                    MeCounter_.super.saveCoin();
                } catch (Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        });
    }

    public void saveInBg(int i) {
        final int i2 = i;
        a.a((a.C0532a) new a.C0532a("", 0, "") {
            public void execute() {
                try {
                    MeCounter_.super.saveInBg(i2);
                } catch (Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        });
    }
}
