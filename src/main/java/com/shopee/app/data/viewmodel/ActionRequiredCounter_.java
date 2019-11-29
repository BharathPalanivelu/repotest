package com.shopee.app.data.viewmodel;

import android.content.Context;
import android.util.Pair;
import java.util.Set;
import org.a.a.a;

public final class ActionRequiredCounter_ extends ActionRequiredCounter {
    private Context context_;

    private void init_() {
    }

    private ActionRequiredCounter_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static ActionRequiredCounter_ getInstance_(Context context) {
        return new ActionRequiredCounter_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    public void saveInBg(Set<Pair<Long, Integer>> set) {
        final Set<Pair<Long, Integer>> set2 = set;
        a.a((a.C0532a) new a.C0532a("", 0, "") {
            public void execute() {
                try {
                    ActionRequiredCounter_.super.saveInBg(set2);
                } catch (Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        });
    }
}
