package com.shopee.app.util.datapoint;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DataPointBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private b f26305a = new b();

    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getExtras() != null) {
            this.f26305a.a(intent);
        }
    }
}
