package com.garena.android.gpns.network;

import android.util.Pair;
import com.garena.android.gpns.network.tcp.TCPConnection;
import com.garena.android.gpns.storage.LocalStorage;
import com.garena.android.gpns.utility.CONSTANT;
import java.io.InputStream;

public final class TCPFactory {
    public static TCPConnection newConnection(int i) {
        if (i == 0) {
            Pair<String, Integer> parseIPAndPort = parseIPAndPort(LocalStorage.getAuthServerAddress());
            TCPConnection newConnection = newConnection((String) parseIPAndPort.first, ((Integer) parseIPAndPort.second).intValue(), i);
            newConnection.setKeepConnected(false);
            return newConnection;
        } else if (i == 1) {
            Pair<String, Integer> parseIPAndPort2 = parseIPAndPort(LocalStorage.getConnectionAddress());
            TCPConnection newConnection2 = newConnection((String) parseIPAndPort2.first, ((Integer) parseIPAndPort2.second).intValue(), i);
            newConnection2.setKeepConnected(true);
            return newConnection2;
        } else if (i != 2) {
            return null;
        } else {
            TCPConnection newConnection3 = newConnection(CONSTANT.NETWORK.SERVER_IP, CONSTANT.NETWORK.SERVER_PORT, i);
            newConnection3.setKeepConnected(false);
            return newConnection3;
        }
    }

    public static TCPConnection newConnection(String str, int i, int i2) {
        return new TCPConnection(str, i, i2);
    }

    public static TCPPacketReader newPacketReader(InputStream inputStream) {
        return new TCPPacketReader(inputStream);
    }

    private static Pair<String, Integer> parseIPAndPort(String str) {
        String[] split = str.split(":");
        return new Pair<>(split[0], Integer.valueOf(Integer.parseInt(split[1])));
    }

    private TCPFactory() {
    }
}
