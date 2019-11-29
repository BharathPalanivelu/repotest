package com.garena.android.gpns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.garena.android.gpns.utility.CONSTANT;
import e.f;

public final class NotificationBroadcaster {
    public static void broadcast(Context context, Integer num, f fVar) {
        Intent intent = new Intent();
        intent.setAction(CONSTANT.ACTION.ACTION_NOTIFICATION());
        intent.addCategory("com.garena.android.gpns." + num);
        Bundle bundle = new Bundle();
        bundle.putString("DATA", new String(fVar.i()));
        intent.putExtras(bundle);
        context.sendBroadcast(intent);
    }

    private NotificationBroadcaster() {
    }
}
