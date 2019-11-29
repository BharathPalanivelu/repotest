package com.shopee.app.web.bridge.modules;

import android.content.Context;
import org.a.a.b;

public final class PermissionRequestModule_ extends PermissionRequestModule {
    private Context context_;

    private void init_() {
    }

    private PermissionRequestModule_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static PermissionRequestModule_ getInstance_(Context context) {
        return new PermissionRequestModule_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    /* access modifiers changed from: package-private */
    public void resolvePromise() {
        b.a("", new Runnable() {
            public void run() {
                PermissionRequestModule_.super.resolvePromise();
            }
        }, 0);
    }

    /* access modifiers changed from: package-private */
    public void rejectPromise() {
        b.a("", new Runnable() {
            public void run() {
                PermissionRequestModule_.super.rejectPromise();
            }
        }, 0);
    }
}
