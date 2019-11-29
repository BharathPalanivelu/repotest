package com.garena.android.gpns;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.garena.android.gpns.logic.BroadcastManager;
import com.garena.android.gpns.logic.ServiceController;
import com.garena.android.gpns.network.PacketRouter;
import com.garena.android.gpns.notification.NotificationBus;
import com.garena.android.gpns.storage.LocalStorage;
import com.garena.android.gpns.ui.TokenBroadcaster;
import com.garena.android.gpns.utility.AppLogger;
import com.garena.android.gpns.utility.CONSTANT;
import com.garena.android.gpns.utility.DeviceUtil;

public class GNotificationService extends Service {
    private static volatile boolean isRunning = false;
    protected static BroadcastManager mBroadcastManager;
    protected static volatile NotificationBus mBus;
    protected static Context mContext;
    private static ServiceController mServiceController;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mBroadcastManager = new BroadcastManager(mContext);
        AppLogger.i("ON-CREATE: " + this);
        onCreateService();
        isRunning = true;
    }

    private void onCreateService() {
        PacketRouter.registerProcessors();
        AppLogger.init(getApplicationContext());
        if (LocalStorage.getDeviceId() == -1) {
            LocalStorage.setDeviceId(Math.abs(DeviceUtil.generateDeviceId()));
        }
        AppLogger.i(String.format("DEVICE_ID %02X", new Object[]{Long.valueOf(LocalStorage.getDeviceId())}));
        ServiceController serviceController = mServiceController;
        if (serviceController != null) {
            serviceController.destroy();
        }
        mServiceController = new ServiceController(mContext);
        if (DeviceUtil.isConnectedToNetwork(mContext)) {
            mServiceController.setupConnection();
        } else {
            mBroadcastManager.registerNetworkChangeReceiver();
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null && intent.getIntExtra(CONSTANT.INTENT.INTENT_REQUEST, 0) == 1) {
            TokenBroadcaster.broadcast(mContext);
        }
        return 1;
    }

    public void onDestroy() {
        super.onDestroy();
        mBroadcastManager.unregisterNetworkChangeReceiver();
        AppLogger.i("ON-DESTROY: " + this);
        onDestroyService();
        isRunning = false;
    }

    public void onDestroyService() {
        mServiceController.destroy();
        mServiceController = null;
    }

    public static NotificationBus getBus() {
        if (mBus == null) {
            synchronized (NotificationBus.class) {
                if (mBus == null) {
                    mBus = new NotificationBus();
                }
            }
        }
        return mBus;
    }

    public static BroadcastManager getBroadcastManager() {
        return mBroadcastManager;
    }

    public static Context getContext() {
        return mContext;
    }

    public static boolean isServiceRunning() {
        return isRunning;
    }
}
