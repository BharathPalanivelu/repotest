package com.garena.android.gpns.network;

import com.garena.android.gpns.network.exception.ConnectionDroppedException;
import com.garena.android.gpns.utility.AppLogger;

public class ReceiverThread implements Runnable {
    private final int mConnectionId;
    private final TCPPacketReader mPacketReader;
    private final PacketReadListener mReadListener;

    public ReceiverThread(int i, TCPPacketReader tCPPacketReader, PacketReadListener packetReadListener) {
        this.mConnectionId = i;
        this.mPacketReader = tCPPacketReader;
        this.mReadListener = packetReadListener;
    }

    public void run() {
        try {
            runPacketReadingLoop();
        } catch (Exception e2) {
            AppLogger.e(e2);
        }
    }

    private void runPacketReadingLoop() {
        while (!Thread.interrupted()) {
            try {
                this.mReadListener.onPacketRead(this.mPacketReader.readPacket());
            } catch (ConnectionDroppedException unused) {
                this.mReadListener.onReadFailed(this.mConnectionId);
                return;
            }
        }
    }
}
