package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.shopee.app.react.protocol.BridgeResult;
import org.a.a.b;

public final class AddReminderModule_ extends AddReminderModule {
    private Context context_;

    private void init_() {
    }

    private AddReminderModule_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static AddReminderModule_ getInstance_(Context context) {
        return new AddReminderModule_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    public void resolvePromise(final BridgeResult<?> bridgeResult) {
        b.a("", new Runnable() {
            public void run() {
                AddReminderModule_.super.resolvePromise(bridgeResult);
            }
        }, 0);
    }
}
