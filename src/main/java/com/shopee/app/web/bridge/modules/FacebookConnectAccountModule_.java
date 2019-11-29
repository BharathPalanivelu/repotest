package com.shopee.app.web.bridge.modules;

import android.content.Context;
import org.a.a.b;

public final class FacebookConnectAccountModule_ extends FacebookConnectAccountModule {
    private Context context_;

    private void init_() {
    }

    private FacebookConnectAccountModule_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static FacebookConnectAccountModule_ getInstance_(Context context) {
        return new FacebookConnectAccountModule_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    public void resolvePromise(final String str) {
        b.a("", new Runnable() {
            public void run() {
                FacebookConnectAccountModule_.super.resolvePromise(str);
            }
        }, 0);
    }

    public void rejectPromise() {
        b.a("", new Runnable() {
            public void run() {
                FacebookConnectAccountModule_.super.rejectPromise();
            }
        }, 0);
    }
}
