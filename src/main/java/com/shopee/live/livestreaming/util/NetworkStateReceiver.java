package com.shopee.live.livestreaming.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NetworkStateReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private a f29360a;

    /* renamed from: b  reason: collision with root package name */
    private int f29361b = -1;

    public interface a {
        void a(int i);
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            int a2 = y.a(context);
            a aVar = this.f29360a;
            if (aVar != null && a2 != this.f29361b) {
                this.f29361b = a2;
                aVar.a(this.f29361b);
            }
        }
    }

    public void a(a aVar) {
        this.f29360a = aVar;
    }
}
