package com.tencent.cos.xml.transfer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.qcloud.core.logger.QCloudLogger;
import java.util.LinkedList;
import java.util.List;

public class NetworkMonitor {
    static final String INTENT_ACTION_TRANSFER_ADD = "add_transfer";
    static final int MSG_CONNECT = 400;
    static final int MSG_DISCONNECT = 300;
    private HandlerThread handlerThread;
    private boolean isReceiverNotRegistered = true;
    private NetworkInfoReceiver networkInfoReceiver;
    private List<NetworkListener> networkListeners = new LinkedList();
    private Handler updateHandler;

    interface NetworkListener {
        void onDisconnect();

        void onReconnect();
    }

    NetworkMonitor() {
    }

    /* access modifiers changed from: package-private */
    public void addNetworkListener(NetworkListener networkListener) {
        this.networkListeners.add(networkListener);
    }

    /* access modifiers changed from: package-private */
    public void removeNetworkListener(NetworkListener networkListener) {
        this.networkListeners.remove(networkListener);
    }

    /* access modifiers changed from: package-private */
    public synchronized void register(Context context) {
        if (this.isReceiverNotRegistered) {
            QCloudLogger.i("TransferUtility", "registering receiver", new Object[0]);
            this.handlerThread = new HandlerThread("COSTransferUpdateHandlerThread");
            this.handlerThread.start();
            setHandlerLooper(context, this.handlerThread.getLooper());
            try {
                context.registerReceiver(this.networkInfoReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (IllegalArgumentException unused) {
                QCloudLogger.w("TransferUtility", "Ignoring the exception trying to register the receiver for connectivity change.", new Object[0]);
            } catch (IllegalStateException unused2) {
                try {
                    QCloudLogger.w("TransferUtility", "Ignoring the leak in registering the receiver.", new Object[0]);
                } catch (Throwable th) {
                    this.isReceiverNotRegistered = false;
                    throw th;
                }
            }
            this.isReceiverNotRegistered = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void unregister(Context context) {
        try {
            if (this.networkInfoReceiver != null) {
                QCloudLogger.i("TransferUtility", "unregistering receiver", new Object[0]);
                context.unregisterReceiver(this.networkInfoReceiver);
                this.isReceiverNotRegistered = true;
            }
        } catch (IllegalArgumentException unused) {
            QCloudLogger.w("TransferUtility", "exception trying to destroy the service", new Object[0]);
        }
    }

    class UpdateHandler extends Handler {
        public UpdateHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 400) {
                NetworkMonitor.this.notifyNetworkReconnect();
            } else if (message.what == 300) {
                NetworkMonitor.this.notifyNetworkDisconnect();
            }
        }
    }

    /* access modifiers changed from: private */
    public void notifyNetworkDisconnect() {
        QCloudLogger.i("TransferUtility", "pause transfer on network disconnect", new Object[0]);
        for (NetworkListener onDisconnect : this.networkListeners) {
            onDisconnect.onDisconnect();
        }
    }

    /* access modifiers changed from: private */
    public void notifyNetworkReconnect() {
        QCloudLogger.i("TransferUtility", "resume transfer on network reconnect", new Object[0]);
        for (NetworkListener onReconnect : this.networkListeners) {
            onReconnect.onReconnect();
        }
    }

    static class NetworkInfoReceiver extends BroadcastReceiver {
        private final ConnectivityManager connManager;
        private final Handler handler;

        public NetworkInfoReceiver(Context context, Handler handler2) {
            this.handler = handler2;
            this.connManager = (ConnectivityManager) context.getSystemService("connectivity");
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                boolean isNetworkConnected = isNetworkConnected();
                QCloudLogger.i("TransferUtility", "Network connected: " + isNetworkConnected, new Object[0]);
                this.handler.sendEmptyMessage(isNetworkConnected ? 400 : 300);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isNetworkConnected() {
            NetworkInfo activeNetworkInfo = this.connManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
    }

    private void setHandlerLooper(Context context, Looper looper) {
        this.updateHandler = new UpdateHandler(looper);
        this.networkInfoReceiver = new NetworkInfoReceiver(context.getApplicationContext(), this.updateHandler);
    }
}
