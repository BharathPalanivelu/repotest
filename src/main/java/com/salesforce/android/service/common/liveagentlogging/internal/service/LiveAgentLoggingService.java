package com.salesforce.android.service.common.liveagentlogging.internal.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LiveAgentLoggingService extends Service {
    private LiveAgentLoggingServiceDelegate mServiceDelegate = new LiveAgentLoggingServiceDelegate(this);

    public IBinder onBind(Intent intent) {
        return this.mServiceDelegate.onBind(intent);
    }

    public void onDestroy() {
        this.mServiceDelegate.onDestroy();
    }
}
