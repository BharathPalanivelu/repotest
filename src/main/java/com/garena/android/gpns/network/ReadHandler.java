package com.garena.android.gpns.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.garena.android.gpns.network.tcp.TCPPacket;

public class ReadHandler extends Handler implements PacketReadListener {
    private static final int ON_PACKET_READ = 0;
    private static final int ON_READ_FAILED = 1;
    private final PacketReadListener mReadListener;

    public ReadHandler(Looper looper, PacketReadListener packetReadListener) {
        super(looper);
        this.mReadListener = packetReadListener;
    }

    public void onPacketRead(TCPPacket tCPPacket) {
        obtainMessage(0, tCPPacket).sendToTarget();
    }

    public void onReadFailed(int i) {
        obtainMessage(1, Integer.valueOf(i)).sendToTarget();
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i == 1 && message.obj != null) {
                this.mReadListener.onReadFailed(((Integer) message.obj).intValue());
            }
        } else if (message.obj != null) {
            this.mReadListener.onPacketRead((TCPPacket) message.obj);
        }
    }
}
