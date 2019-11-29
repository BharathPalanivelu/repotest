package com.path.android.jobqueue.network;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import com.path.android.jobqueue.network.NetworkEventProvider;

public class NetworkUtilImpl implements NetworkEventProvider, NetworkUtil {
    /* access modifiers changed from: private */
    public NetworkEventProvider.Listener listener;

    public NetworkUtilImpl(Context context) {
        context.getApplicationContext().registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (NetworkUtilImpl.this.listener != null) {
                    NetworkUtilImpl.this.listener.onNetworkChange(NetworkUtilImpl.this.isConnected(context));
                }
            }
        }, getNetworkIntentFilter());
    }

    public boolean isConnected(Context context) {
        if (isDozing(context)) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    @TargetApi(23)
    private static IntentFilter getNetworkIntentFilter() {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        }
        return intentFilter;
    }

    @TargetApi(23)
    private static boolean isDozing(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((PowerManager) context.getSystemService("power")).isDeviceIdleMode();
        }
        return false;
    }

    public void setListener(NetworkEventProvider.Listener listener2) {
        this.listener = listener2;
    }
}
