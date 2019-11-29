package com.shopee.shopeetracker.worker;

import com.shopee.shopeetracker.Injection;
import com.shopee.shopeetracker.ShopeeTracker;
import com.shopee.shopeetracker.utils.Logger;

public class TrackerTaskRunnable implements Runnable {
    private String TAG = "TrackerTaskRunnable";

    public void run() {
        try {
            Logger.debug(this.TAG, "TrackerTaskRunnable task run");
            if (ShopeeTracker.isInitialized() && ShopeeTracker.getInstance().isEnabled()) {
                Logger.debug(this.TAG, "TrackerTaskRunnable send  events");
                Injection.provideEventSender().sendEvents();
            }
        } catch (Throwable th) {
            Logger.debug(th);
        }
    }
}
