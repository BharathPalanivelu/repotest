package com.shopee.d.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shopee.d.a.b;
import com.shopee.shopeetracker.Injection;
import com.shopee.shopeetracker.utils.Logger;
import java.util.concurrent.TimeUnit;

public class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private long f27126a;

    public void onReceive(Context context, Intent intent) {
        if (!isInitialStickyBroadcast() && System.currentTimeMillis() - this.f27126a >= 2000) {
            this.f27126a = System.currentTimeMillis();
            Logger.debug("NetworkChangeReceiver", "onReceive called");
            Injection.provideScheduleService().schedule(new b(), 500, TimeUnit.MILLISECONDS);
        }
    }
}
