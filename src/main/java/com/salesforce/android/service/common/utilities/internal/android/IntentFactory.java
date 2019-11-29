package com.salesforce.android.service.common.utilities.internal.android;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class IntentFactory {
    public Intent createIntent(Context context, Class<?> cls) {
        return new Intent(context, cls);
    }

    public IntentFilter createIntentFilter(String str) {
        return new IntentFilter(str);
    }

    public PendingIntent createActivityPendingIntent(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getActivity(context, i, intent, i2);
    }
}
