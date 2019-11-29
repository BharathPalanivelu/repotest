package com.garena.android.gpns.logic;

import android.content.Context;
import com.garena.android.gpns.GNotificationService;
import com.garena.android.gpns.ServiceHandler;
import com.garena.android.gpns.network.NetworkRequestHandler;
import com.garena.android.gpns.network.NetworkResponseListener;
import com.garena.android.gpns.network.NetworkThread;
import com.garena.android.gpns.network.PacketRouter;
import com.garena.android.gpns.network.tcp.TCPPacket;
import com.garena.android.gpns.notification.NotifyItem;
import com.garena.android.gpns.notification.event.NotifyEvent;
import com.garena.android.gpns.storage.LocalStorage;
import com.garena.android.gpns.utility.AlarmUtil;
import com.garena.android.gpns.utility.AppLogger;
import com.garena.android.gpns.utility.CONSTANT;
import com.garena.android.gpns.utility.DeviceUtil;
import com.garena.android.gpns.utility.TCPPacketFactory;

public class ServiceController implements NetworkResponseListener {
    private final NotifyItem mAckPushMessage = new NotifyItem() {
        public void onNotify(NotifyEvent notifyEvent) {
            if (notifyEvent.notifyData instanceof TCPPacket) {
                ServiceController.this.mNetworkRequestHandler.sendPacket((TCPPacket) notifyEvent.notifyData);
            }
        }
    };
    private final NotifyItem mConnectToAuthServer = new NotifyItem() {
        public void onNotify(NotifyEvent notifyEvent) {
            ServiceController.this.connectToAuthServer();
        }
    };
    private final NotifyItem mConnectToLiveServer = new NotifyItem() {
        public void onNotify(NotifyEvent notifyEvent) {
            ServiceController.this.connectToNotificationServer();
        }
    };
    /* access modifiers changed from: private */
    public final Context mContext;
    private AppLogger.NetworkThreadExceptionHandler mExceptionHandler = new AppLogger.NetworkThreadExceptionHandler() {
        public void uncaughtException(Thread thread, Throwable th) {
            super.uncaughtException(thread, th);
            ServiceController serviceController = ServiceController.this;
            serviceController.scheduleWakeConnect(serviceController.getTimeout());
        }
    };
    /* access modifiers changed from: private */
    public NetworkRequestHandler mNetworkRequestHandler;
    /* access modifiers changed from: private */
    public NetworkThread mNetworkThread;
    private NotifyItem mOnLongPing = new NotifyItem() {
        public void onNotify(NotifyEvent notifyEvent) {
            if (ServiceController.this.isStateValid()) {
                ServiceController.this.mNetworkRequestHandler.sendPacket(TCPPacketFactory.newPingRequestPacket());
            }
        }
    };
    private NotifyItem mOnShortPing = new NotifyItem() {
        public void onNotify(NotifyEvent notifyEvent) {
            if (ServiceController.this.isStateValid()) {
                if (!DeviceUtil.isConnectedToNetwork(ServiceController.this.mContext)) {
                    ServiceController.this.notifyInternetDisconnected();
                } else if (ServiceController.this.mNetworkThread.isTCPDisconnected()) {
                    ServiceController.this.scheduleWakeConnect(30000);
                }
            }
        }
    };
    private NotifyItem mOnWakeConnect = new NotifyItem() {
        public void onNotify(NotifyEvent notifyEvent) {
            if (System.currentTimeMillis() - LocalStorage.getRegionRequestTime() >= 86400000) {
                ServiceController.this.connectToRegionServer();
            } else {
                ServiceController.this.connectToAuthServer();
            }
        }
    };
    private NotifyItem mPerformPing = new NotifyItem() {
        public void onNotify(NotifyEvent notifyEvent) {
            if (notifyEvent.notifyData instanceof TCPPacket) {
                ServiceController.this.mNetworkRequestHandler.sendPacket((TCPPacket) notifyEvent.notifyData);
            }
        }
    };
    private ServiceHandler mServiceHandler;
    private int mTimeout = 30000;

    public ServiceController(Context context) {
        this.mContext = context;
        this.mServiceHandler = new ServiceHandler(this);
        registerNotifications();
    }

    /* access modifiers changed from: private */
    public void connectToRegionServer() {
        NetworkThread networkThread = this.mNetworkThread;
        if (networkThread == null || !networkThread.isAlive()) {
            this.mNetworkThread = new NetworkThread(this.mServiceHandler);
            this.mNetworkThread.start();
            this.mNetworkThread.setUncaughtExceptionHandler(this.mExceptionHandler);
            this.mNetworkRequestHandler = this.mNetworkThread.getHandler();
        }
        this.mNetworkRequestHandler.connectRegionServer();
    }

    /* access modifiers changed from: private */
    public void connectToAuthServer() {
        NetworkThread networkThread = this.mNetworkThread;
        if (networkThread == null || !networkThread.isAlive()) {
            this.mNetworkThread = new NetworkThread(this.mServiceHandler);
            this.mNetworkThread.start();
            this.mNetworkThread.setUncaughtExceptionHandler(this.mExceptionHandler);
            this.mNetworkRequestHandler = this.mNetworkThread.getHandler();
        }
        this.mNetworkRequestHandler.connectAuthenticationServer();
    }

    /* access modifiers changed from: private */
    public void connectToNotificationServer() {
        NetworkThread networkThread = this.mNetworkThread;
        if (networkThread == null || !networkThread.isAlive()) {
            this.mNetworkThread = new NetworkThread(this.mServiceHandler);
            this.mNetworkThread.start();
            this.mNetworkThread.setUncaughtExceptionHandler(this.mExceptionHandler);
            this.mNetworkRequestHandler = this.mNetworkThread.getHandler();
        }
        this.mNetworkRequestHandler.connectNotificationServer();
    }

    /* access modifiers changed from: private */
    public int getTimeout() {
        int i = this.mTimeout;
        if (i > 600000) {
            this.mTimeout = 600000;
            i = 600000;
        }
        this.mTimeout *= 2;
        return i;
    }

    private void resetTimeout() {
        this.mTimeout = 30000;
    }

    public void onConnectionOK(int i) {
        if (i == 0) {
            sendAuthPacket();
        } else if (i == 1) {
            requestNotification();
            schedulePingAlarms();
            resetTimeout();
        } else if (i == 2) {
            sendRegionPacket();
        }
    }

    public void onUnableToConnect(int i) {
        if (i != 0 && i != 1 && i != 2) {
            return;
        }
        if (DeviceUtil.isConnectedToNetwork(this.mContext)) {
            scheduleWakeConnect(getTimeout());
        } else {
            notifyInternetDisconnected();
        }
    }

    public void onPacketFailed(TCPPacket tCPPacket) {
        if (DeviceUtil.isConnectedToNetwork(this.mContext)) {
            scheduleWakeConnect(getTimeout());
        } else {
            notifyInternetDisconnected();
        }
    }

    public void onResponseArrived(TCPPacket tCPPacket) {
        PacketRouter.route(tCPPacket);
    }

    public void onConnectionDropped(int i) {
        if (i != 0 && i != 1 && i != 2) {
            return;
        }
        if (DeviceUtil.isConnectedToNetwork(this.mContext)) {
            scheduleWakeConnect(getTimeout());
        } else {
            notifyInternetDisconnected();
        }
    }

    private void sendRegionPacket() {
        this.mNetworkRequestHandler.sendPacket(TCPPacketFactory.newRegionRequestPacket());
    }

    private void sendAuthPacket() {
        this.mNetworkRequestHandler.sendPacket(TCPPacketFactory.newAuthRequestPacket());
    }

    private void requestNotification() {
        this.mNetworkRequestHandler.sendPacket(TCPPacketFactory.newConnectionRequestPacket(LocalStorage.getConnectionId()));
    }

    /* access modifiers changed from: private */
    public boolean isStateValid() {
        return (this.mNetworkThread == null || this.mNetworkRequestHandler == null) ? false : true;
    }

    private void registerNotifications() {
        GNotificationService.getBus().register(CONSTANT.BUS.WAKE_CONNECT, this.mOnWakeConnect);
        GNotificationService.getBus().register(CONSTANT.BUS.SHORT_PING, this.mOnShortPing);
        GNotificationService.getBus().register(CONSTANT.BUS.LONG_PING, this.mOnLongPing);
        GNotificationService.getBus().register(CONSTANT.BUS.CONNECT_NOTIFICATION_SERVER, this.mConnectToLiveServer);
        GNotificationService.getBus().register(CONSTANT.BUS.ACK_PUSH_MSG, this.mAckPushMessage);
        GNotificationService.getBus().register(CONSTANT.BUS.PERFORM_PING, this.mPerformPing);
        GNotificationService.getBus().register(CONSTANT.BUS.CONNECT_AUTHENTICATION_SERVER, this.mConnectToAuthServer);
    }

    private void schedulePingAlarms() {
        AppLogger.i("SCHEDULE_PING_ALARM");
        AlarmUtil.scheduleShortPing(this.mContext);
        AlarmUtil.scheduleLongPing(this.mContext);
    }

    /* access modifiers changed from: private */
    public void scheduleWakeConnect(int i) {
        AppLogger.i("SCHEDULE_WAKE_CONNECT : " + i);
        AppLogger.f("SCHEDULE_WAKE_CONNECT : " + i);
        AlarmUtil.cancelShortPing(this.mContext);
        AlarmUtil.cancelLongPing(this.mContext);
        AlarmUtil.scheduleWakeConnect(this.mContext, i);
    }

    /* access modifiers changed from: private */
    public void notifyInternetDisconnected() {
        AppLogger.i("NOTIFY_INTERNET_DISCONNECTED");
        AppLogger.f("NOTIFY_INTERNET_DISCONNECTED");
        AlarmUtil.cancelShortPing(this.mContext);
        AlarmUtil.cancelLongPing(this.mContext);
        GNotificationService.getBroadcastManager().registerNetworkChangeReceiver();
    }

    public void setupConnection() {
        AppLogger.i("SETUP_CONNECTION");
        scheduleWakeConnect(10000);
    }

    public void destroy() {
        GNotificationService.getBus().clearAll();
        this.mServiceHandler = null;
        NetworkThread networkThread = this.mNetworkThread;
        if (networkThread != null) {
            networkThread.quit();
        }
    }
}
