package com.garena.android.gpns.network;

import com.garena.android.gpns.network.exception.ConnectionDroppedException;
import com.garena.android.gpns.network.tcp.TCPPacket;
import java.io.InputStream;

public class TCPPacketReader {
    private static final int COMMAND_FIELD_SIZE = 1;
    private static final int LENGTH_FIELD_SIZE = 4;
    private final InputStream mInputStream;

    public TCPPacketReader(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    private byte[] readNBytes(int i) throws Exception {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (true) {
            int read = this.mInputStream.read(bArr, i2, i);
            if (read <= 0) {
                return null;
            }
            if (read >= i) {
                return bArr;
            }
            i2 += read;
            i -= read;
        }
    }

    private static int byteArrayToInt(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public TCPPacket readPacket() throws ConnectionDroppedException {
        try {
            int byteArrayToInt = byteArrayToInt(readNBytes(4));
            byte[] readNBytes = readNBytes(1);
            return new TCPPacket(readNBytes[0], readNBytes(byteArrayToInt - 1));
        } catch (Exception e2) {
            throw new ConnectionDroppedException(e2);
        }
    }
}
