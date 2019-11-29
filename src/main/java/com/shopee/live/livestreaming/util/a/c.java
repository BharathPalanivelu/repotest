package com.shopee.live.livestreaming.util.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shopee.live.livestreaming.util.f;

public class c extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("level", 0);
        if (intExtra >= 0) {
            f.a().a(intExtra);
        }
    }
}
