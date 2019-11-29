package com.garena.android.gpns.external;

import android.content.Context;
import android.content.Intent;
import com.garena.android.gpns.GNotificationService;
import com.garena.android.gpns.utility.AlarmUtil;
import com.garena.android.gpns.utility.CONSTANT;

public class ServiceManager {
    private Context mContext;

    public ServiceManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void stop() {
        Context context = this.mContext;
        context.stopService(new Intent(context, GNotificationService.class));
        AlarmUtil.cancelLongPing(this.mContext);
        AlarmUtil.cancelShortPing(this.mContext);
        AlarmUtil.cancelWakeConnect(this.mContext);
    }

    public void requestToken() {
        Intent intent = new Intent(this.mContext, GNotificationService.class);
        intent.putExtra(CONSTANT.INTENT.INTENT_REQUEST, 1);
        this.mContext.startService(intent);
    }
}
