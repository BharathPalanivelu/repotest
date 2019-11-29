package com.shopee.app.web.bridge.modules;

import android.content.Context;
import org.a.a.b;

public final class SharingPanelModule_ extends SharingPanelModule {
    private Context context_;

    private void init_() {
    }

    private SharingPanelModule_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static SharingPanelModule_ getInstance_(Context context) {
        return new SharingPanelModule_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    public void resolvePromise(final String str, final boolean z) {
        b.a("", new Runnable() {
            public void run() {
                SharingPanelModule_.super.resolvePromise(str, z);
            }
        }, 0);
    }

    public void rejectPromise() {
        b.a("", new Runnable() {
            public void run() {
                SharingPanelModule_.super.rejectPromise();
            }
        }, 0);
    }
}
