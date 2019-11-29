package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.shopee.app.ui.sharing.base.data.a;
import org.a.a.b;

public final class SharingModule_ extends SharingModule {
    private Context context_;

    private void init_() {
    }

    private SharingModule_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static SharingModule_ getInstance_(Context context) {
        return new SharingModule_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    public void resolvePromise(final a aVar) {
        b.a("", new Runnable() {
            public void run() {
                SharingModule_.super.resolvePromise(aVar);
            }
        }, 0);
    }
}
