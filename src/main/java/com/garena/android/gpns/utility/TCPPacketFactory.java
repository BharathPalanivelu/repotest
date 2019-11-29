package com.garena.android.gpns.utility;

import com.garena.android.gpnprotocol.gpush.ConnectRequest;
import com.garena.android.gpnprotocol.gpush.GetGPidRequest;
import com.garena.android.gpnprotocol.gpush.PushMsgAck;
import com.garena.android.gpns.network.tcp.TCPPacket;
import com.garena.android.gpns.storage.LocalStorage;
import com.garena.android.gpns.utility.CONSTANT;

public final class TCPPacketFactory {
    public static String getPacketName(int i) {
        if (i == 1) {
            return "AUTH_REQUEST";
        }
        if (i == 2) {
            return "CONNECTION_REQUEST";
        }
        if (i == 3) {
            return "PUSH_ACK";
        }
        if (i == 4) {
            return "PING_REQUEST";
        }
        if (i == 5) {
            return "REGION_REQUEST";
        }
        switch (i) {
            case 17:
                return "AUTH_RESPONSE";
            case 18:
                return "PUSH_NOTIFICATION";
            case 19:
                return "PING_ACK";
            case 20:
                return "REGION_RESPONSE";
            default:
                return "UNKNOWN";
        }
    }

    public static TCPPacket newPushMessageAckPacket(int i) {
        PushMsgAck.Builder builder = new PushMsgAck.Builder();
        builder.Msgid(Integer.valueOf(i));
        return new TCPPacket(3, builder.build().toByteArray());
    }

    public static TCPPacket newConnectionRequestPacket(long j) {
        ConnectRequest.Builder builder = new ConnectRequest.Builder();
        builder.GPid(Long.valueOf(j));
        return new TCPPacket(2, builder.build().toByteArray());
    }

    public static TCPPacket newAuthRequestPacket() {
        GetGPidRequest.Builder builder = new GetGPidRequest.Builder();
        builder.Sign(Long.valueOf(LocalStorage.getDeviceId()));
        builder.OldId(Long.valueOf(LocalStorage.getConnectionId()));
        TCPPacket tCPPacket = new TCPPacket(1, builder.build().toByteArray());
        tCPPacket.setTimed(true);
        tCPPacket.setTimeout(30000);
        return tCPPacket;
    }

    public static TCPPacket newRegionRequestPacket() {
        TCPPacket tCPPacket = new TCPPacket(5, new byte[0]);
        tCPPacket.setTimed(true);
        tCPPacket.setTimeout(30000);
        return tCPPacket;
    }

    public static TCPPacket newPingRequestPacket() {
        TCPPacket tCPPacket = new TCPPacket(4, new byte[0]);
        tCPPacket.setTimed(true);
        tCPPacket.setTimeout(CONSTANT.TIME.MIN_1);
        return tCPPacket;
    }

    private TCPPacketFactory() {
    }
}
