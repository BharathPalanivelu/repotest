package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.shopee.app.react.protocol.BridgeResult;
import org.a.a.b;

public final class CancelReminderModule_ extends CancelReminderModule {
    private Context context_;

    private void init_() {
    }

    private CancelReminderModule_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static CancelReminderModule_ getInstance_(Context context) {
        return new CancelReminderModule_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    public void resolvePromise(final BridgeResult<?> bridgeResult) {
        b.a("", new Runnable() {
            public void run() {
                CancelReminderModule_.super.resolvePromise(bridgeResult);
            }
        }, 0);
    }
}
