package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.shopee.app.ui.datapoint.data.CollectDataEvent;
import org.a.a.b;

public final class DataPointModule_ extends DataPointModule {
    private Context context_;

    private void init_() {
    }

    private DataPointModule_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static DataPointModule_ getInstance_(Context context) {
        return new DataPointModule_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    public void sendBackEvent(final CollectDataEvent collectDataEvent) {
        b.a("", new Runnable() {
            public void run() {
                DataPointModule_.super.sendBackEvent(collectDataEvent);
            }
        }, 0);
    }
}
