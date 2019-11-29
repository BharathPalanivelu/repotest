package com.shopee.app.data.viewmodel;

import android.content.Context;
import java.util.Set;
import org.a.a.a;

public final class ActivityCounter_ extends ActivityCounter {
    private Context context_;

    private void init_() {
    }

    private ActivityCounter_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static ActivityCounter_ getInstance_(Context context) {
        return new ActivityCounter_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    public void saveInBg(Set<Long> set, boolean z) {
        final Set<Long> set2 = set;
        final boolean z2 = z;
        a.a((a.C0532a) new a.C0532a("", 0, "") {
            public void execute() {
                try {
                    ActivityCounter_.super.saveInBg(set2, z2);
                } catch (Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        });
    }
}
