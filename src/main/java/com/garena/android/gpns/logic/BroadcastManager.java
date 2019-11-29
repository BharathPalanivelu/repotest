package com.garena.android.gpns.logic;

import android.content.Context;
import android.content.IntentFilter;

public class BroadcastManager {
    private boolean isNetworkChangeRegistered = false;
    private Context mContext;
    private NetworkChangeReceiver mNetworkChangeReceiver;

    public BroadcastManager(Context context) {
        this.mContext = context;
        this.mNetworkChangeReceiver = new NetworkChangeReceiver();
    }

    public void registerNetworkChangeReceiver() {
        if (!this.isNetworkChangeRegistered) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.mContext.registerReceiver(this.mNetworkChangeReceiver, intentFilter);
        }
        this.isNetworkChangeRegistered = true;
    }

    public void unregisterNetworkChangeReceiver() {
        if (this.isNetworkChangeRegistered) {
            this.mContext.unregisterReceiver(this.mNetworkChangeReceiver);
        }
        this.isNetworkChangeRegistered = false;
    }
}
