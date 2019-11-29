package com.garena.android.gpns.network;

import android.os.HandlerThread;
import android.os.Looper;
import com.garena.android.gpns.network.exception.CannotSendPacketException;
import com.garena.android.gpns.network.exception.UnableToConnectException;
import com.garena.android.gpns.network.tcp.TCPConnection;
import com.garena.android.gpns.network.tcp.TCPPacket;
import com.garena.android.gpns.network.tcp.TCPPacketTimer;
import com.garena.android.gpns.utility.AppLogger;
import com.garena.android.gpns.utility.TCPPacketFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkThread extends HandlerThread implements NetworkRequestHandler, PacketReadListener, TCPPacketTimer.OnTimeoutListener {
    private static final String NETWORK_THREAD = "NETWORK_THREAD";
    private final ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
    private NetworkHandler mNetworkHandler;
    private ReadHandler mReadHandler;
    private final NetworkResponseListener mResponseHandler;
    private TCPConnection mTCPConnection;

    public NetworkThread(NetworkResponseListener networkResponseListener) {
        super(NETWORK_THREAD);
        this.mResponseHandler = networkResponseListener;
    }

    public void connectRegionServer() {
        disconnect();
        connect(2);
    }

    public void connectAuthenticationServer() {
        disconnect();
        connect(0);
    }

    public void connectNotificationServer() {
        disconnect();
        connect(1);
    }

    /* access modifiers changed from: protected */
    public void onLooperPrepared() {
        super.onLooperPrepared();
        this.mReadHandler = new ReadHandler(getLooper(), this);
    }

    public void sendPacket(TCPPacket tCPPacket) {
        try {
            if (!this.mTCPConnection.isDisconnected()) {
                this.mTCPConnection.sendDataSynchronous(tCPPacket.toByteArray());
                if (tCPPacket.isTimed()) {
                    TCPPacketTimer tCPPacketTimer = new TCPPacketTimer(tCPPacket);
                    tCPPacketTimer.setOnTimeoutListener(this);
                    tCPPacketTimer.start();
                    this.mTCPConnection.setTimer(tCPPacketTimer);
                    return;
                }
                return;
            }
            this.mResponseHandler.onPacketFailed(tCPPacket);
        } catch (CannotSendPacketException unused) {
            this.mResponseHandler.onPacketFailed(tCPPacket);
        }
    }

    public void onTimeout(TCPPacket tCPPacket) {
        AppLogger.i("TIMEOUT: " + TCPPacketFactory.getPacketName(tCPPacket.getCommand()));
        this.mTCPConnection.disconnect();
        this.mResponseHandler.onPacketFailed(tCPPacket);
    }

    public void onPacketRead(TCPPacket tCPPacket) {
        if (!this.mTCPConnection.isDisconnected()) {
            if (!this.mTCPConnection.getKeepConnected()) {
                this.mTCPConnection.disconnect();
            }
            TCPPacketTimer timer = this.mTCPConnection.getTimer();
            if (timer != null && timer.isWaitingFor(tCPPacket)) {
                timer.stop();
            }
            this.mResponseHandler.onResponseArrived(tCPPacket);
        }
    }

    public void onReadFailed(int i) {
        if (!this.mTCPConnection.isDisconnected()) {
            this.mTCPConnection.disconnect();
            this.mResponseHandler.onConnectionDropped(i);
        }
    }

    private void connect(int i) {
        this.mTCPConnection = TCPFactory.newConnection(i);
        try {
            this.mTCPConnection.connect();
            initPacketReceiver();
            this.mResponseHandler.onConnectionOK(i);
        } catch (UnableToConnectException unused) {
            this.mResponseHandler.onUnableToConnect(i);
        }
    }

    private void initPacketReceiver() {
        this.mExecutorService.submit(new ReceiverThread(this.mTCPConnection.getId(), TCPFactory.newPacketReader(this.mTCPConnection.getInputStream()), this.mReadHandler));
    }

    private void disconnect() {
        TCPConnection tCPConnection = this.mTCPConnection;
        if (tCPConnection != null) {
            tCPConnection.disconnect();
        }
    }

    public boolean isTCPDisconnected() {
        return this.mTCPConnection.isDisconnected();
    }

    public NetworkRequestHandler getHandler() {
        Looper looper = getLooper();
        if (this.mNetworkHandler == null && looper != null) {
            this.mNetworkHandler = new NetworkHandler(looper, this);
        }
        return this.mNetworkHandler;
    }

    public boolean quit() {
        this.mTCPConnection.disconnect();
        this.mExecutorService.shutdownNow();
        this.mNetworkHandler = null;
        return super.quit();
    }
}
