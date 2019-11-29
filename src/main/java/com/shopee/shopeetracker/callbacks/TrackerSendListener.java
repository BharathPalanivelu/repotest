package com.shopee.shopeetracker.callbacks;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import com.shopee.d.a.b;
import com.shopee.d.a.b.a;
import com.shopee.shopeetracker.Injection;
import com.shopee.shopeetracker.ShopeeTracker;
import com.shopee.shopeetracker.callbacks.TrackerLifecycleCallbacks;
import com.shopee.shopeetracker.utils.Logger;

public class TrackerSendListener implements TrackerLifecycleCallbacks.Listener {
    private IntentFilter intentFilter;
    private boolean isFirst = true;
    private a networkChangeReceiver;

    public void onActivityCreated(Activity activity) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onAppInForeground(Activity activity) {
        try {
            registerReceiver();
            if (this.isFirst) {
                this.isFirst = false;
                Injection.provideScheduleService().execute(new b());
            }
        } catch (Exception e2) {
            Logger.debug((Throwable) e2);
        }
    }

    public void onAppInBackground(Activity activity) {
        try {
            unregisterReceiver();
            Injection.provideEventSender().delete();
            ShopeeTracker.getInstance().notifyToUpLoad();
        } catch (Exception e2) {
            Logger.debug((Throwable) e2);
        }
    }

    private void unregisterReceiver() {
        if (ShopeeTracker.isInitialized()) {
            Context context = ShopeeTracker.getInstance().getContext();
            a aVar = this.networkChangeReceiver;
            if (aVar != null) {
                context.unregisterReceiver(aVar);
            }
        }
    }

    private void registerReceiver() {
        if (ShopeeTracker.isInitialized() && ShopeeTracker.getInstance().isMonitorEnabled()) {
            Context context = ShopeeTracker.getInstance().getContext();
            if (this.networkChangeReceiver == null) {
                this.networkChangeReceiver = new a();
                this.intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            }
            Logger.debug("PingTask", "registerReceiver called");
            context.registerReceiver(this.networkChangeReceiver, this.intentFilter);
        }
    }
}
