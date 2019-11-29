package com.garena.android.gpns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.garena.android.gpns.storage.LocalStorage;
import com.garena.android.gpns.utility.CONSTANT;
import java.util.Timer;
import java.util.TimerTask;

public final class TokenBroadcaster {
    public static void broadcast(Context context) {
        long connectionId = LocalStorage.getConnectionId();
        if (connectionId != -1) {
            performBroadcast(context, connectionId);
            return;
        }
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new ReadConnectionIdTask(context, timer), 2000, 2000);
    }

    /* access modifiers changed from: private */
    public static void performBroadcast(Context context, long j) {
        try {
            Intent intent = new Intent();
            intent.setAction(CONSTANT.ACTION.ACTION_TOKEN());
            intent.addCategory("com.garena.android.gpns." + CONSTANT.CONFIG.PUSH_ID);
            Bundle bundle = new Bundle();
            bundle.putString("DATA", String.valueOf(j));
            intent.putExtras(bundle);
            context.sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    private TokenBroadcaster() {
    }

    private static class ReadConnectionIdTask extends TimerTask {
        private final Context mContext;
        private final Timer mTimer;

        protected ReadConnectionIdTask(Context context, Timer timer) {
            this.mContext = context;
            this.mTimer = timer;
        }

        public void run() {
            long connectionId = LocalStorage.getConnectionId();
            if (connectionId != -1) {
                TokenBroadcaster.performBroadcast(this.mContext, connectionId);
                this.mTimer.cancel();
            }
        }
    }
}
