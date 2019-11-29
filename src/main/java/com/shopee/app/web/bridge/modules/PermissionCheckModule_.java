package com.shopee.app.web.bridge.modules;

import android.content.Context;
import java.util.List;
import org.a.a.b;

public final class PermissionCheckModule_ extends PermissionCheckModule {
    private Context context_;

    private void init_() {
    }

    private PermissionCheckModule_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static PermissionCheckModule_ getInstance_(Context context) {
        return new PermissionCheckModule_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    /* access modifiers changed from: package-private */
    public void resolvePromise(final List<Boolean> list) {
        b.a("", new Runnable() {
            public void run() {
                PermissionCheckModule_.super.resolvePromise(list);
            }
        }, 0);
    }

    /* access modifiers changed from: package-private */
    public void rejectPromise() {
        b.a("", new Runnable() {
            public void run() {
                PermissionCheckModule_.super.rejectPromise();
            }
        }, 0);
    }
}
