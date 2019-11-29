package com.garena.android.gpns;

import android.os.Handler;
import android.os.Message;
import com.garena.android.gpns.network.NetworkResponseListener;
import com.garena.android.gpns.network.tcp.TCPPacket;
import com.garena.android.gpns.utility.AppLogger;
import com.garena.android.gpns.utility.TCPPacketFactory;

public class ServiceHandler extends Handler implements NetworkResponseListener {
    private static final int CONNECTION_DROPPED = 2;
    private static final int CONNECTION_OK = 4;
    private static final int ON_PACKET_ARRIVED = 0;
    private static final int PACKET_FAILED = 3;
    private static final int UNABLE_TO_CONNECT = 1;
    private final NetworkResponseListener mResponseListener;

    private String getConnectionName(int i) {
        return i == 0 ? "AUTH_SERVER" : "NOTIFICATION_SERVER";
    }

    public ServiceHandler(NetworkResponseListener networkResponseListener) {
        this.mResponseListener = networkResponseListener;
    }

    public void onUnableToConnect(int i) {
        obtainMessage(1, Integer.valueOf(i)).sendToTarget();
    }

    public void onPacketFailed(TCPPacket tCPPacket) {
        obtainMessage(3, tCPPacket).sendToTarget();
    }

    public void onResponseArrived(TCPPacket tCPPacket) {
        obtainMessage(0, tCPPacket).sendToTarget();
    }

    public void onConnectionDropped(int i) {
        obtainMessage(2, Integer.valueOf(i)).sendToTarget();
    }

    public void onConnectionOK(int i) {
        obtainMessage(4, Integer.valueOf(i)).sendToTarget();
    }

    public void handleMessage(Message message) {
        try {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                if (message.obj != null && (message.obj instanceof Integer)) {
                                    int intValue = ((Integer) message.obj).intValue();
                                    AppLogger.i("CONNECTION_OK : " + getConnectionName(intValue));
                                    AppLogger.f("CONNECTION_OK : " + getConnectionName(intValue));
                                    this.mResponseListener.onConnectionOK(intValue);
                                }
                            }
                        } else if (message.obj != null && (message.obj instanceof TCPPacket)) {
                            TCPPacket tCPPacket = (TCPPacket) message.obj;
                            AppLogger.i("PACKET_FAILED : " + TCPPacketFactory.getPacketName(tCPPacket.getCommand()));
                            AppLogger.f("PACKET_FAILED : " + TCPPacketFactory.getPacketName(tCPPacket.getCommand()));
                            this.mResponseListener.onPacketFailed(tCPPacket);
                        }
                    } else if (message.obj != null && (message.obj instanceof Integer)) {
                        int intValue2 = ((Integer) message.obj).intValue();
                        AppLogger.i("CONNECTION_DROPPED : " + getConnectionName(intValue2));
                        AppLogger.f("CONNECTION_DROPPED : " + getConnectionName(intValue2));
                        this.mResponseListener.onConnectionDropped(intValue2);
                    }
                } else if (message.obj != null && (message.obj instanceof Integer)) {
                    int intValue3 = ((Integer) message.obj).intValue();
                    AppLogger.i("UNABLE_TO_CONNECT : " + getConnectionName(intValue3));
                    AppLogger.f("UNABLE_TO_CONNECT : " + getConnectionName(intValue3));
                    this.mResponseListener.onUnableToConnect(intValue3);
                }
            } else if (message.obj != null && (message.obj instanceof TCPPacket)) {
                TCPPacket tCPPacket2 = (TCPPacket) message.obj;
                AppLogger.i("ON_PACKET_ARRIVED : " + TCPPacketFactory.getPacketName(tCPPacket2.getCommand()));
                AppLogger.f("ON_PACKET_ARRIVED : " + TCPPacketFactory.getPacketName(tCPPacket2.getCommand()));
                this.mResponseListener.onResponseArrived(tCPPacket2);
            }
        } catch (Exception e2) {
            AppLogger.e(e2);
        }
    }
}
