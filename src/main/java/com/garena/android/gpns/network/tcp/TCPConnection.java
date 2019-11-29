package com.garena.android.gpns.network.tcp;

import com.garena.android.gpns.network.exception.CannotSendPacketException;
import com.garena.android.gpns.network.exception.UnableToConnectException;
import com.garena.android.gpns.utility.AppLogger;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPConnection {
    public static final int STATUS_CONNECTED = 0;
    public static final int STATUS_DISCONNECTED = 1;
    private final String mIP;
    private int mId = -1;
    private InputStream mInput;
    private boolean mKeepConnected = true;
    private OutputStream mOutput;
    private final int mPort;
    private Socket mSocket;
    private int mStatus;
    private TCPPacketTimer mTimer;

    public TCPConnection(String str, int i, int i2) {
        this.mIP = str;
        this.mPort = i;
        this.mId = i2;
    }

    public int getId() {
        return this.mId;
    }

    public boolean getKeepConnected() {
        return this.mKeepConnected;
    }

    public void setKeepConnected(boolean z) {
        this.mKeepConnected = z;
    }

    public void connect() throws UnableToConnectException {
        disconnect();
        try {
            this.mSocket = new Socket(this.mIP, this.mPort);
            this.mSocket.setTcpNoDelay(true);
            this.mSocket.setKeepAlive(true);
            this.mInput = this.mSocket.getInputStream();
            this.mOutput = this.mSocket.getOutputStream();
            this.mOutput.flush();
            setStatus(0);
        } catch (IOException e2) {
            AppLogger.e(e2);
            disconnect();
            throw new UnableToConnectException(e2);
        }
    }

    public InputStream getInputStream() {
        return this.mInput;
    }

    public void disconnect() {
        stopTimer();
        setStatus(1);
        close();
    }

    public void sendDataSynchronous(byte[] bArr) throws CannotSendPacketException {
        sendDataSynchronous(bArr, 0, bArr.length);
    }

    public void sendDataSynchronous(byte[] bArr, int i, int i2) throws CannotSendPacketException {
        try {
            this.mOutput.write(bArr, i, i2);
            this.mOutput.flush();
        } catch (Exception e2) {
            AppLogger.e(e2);
            disconnect();
            throw new CannotSendPacketException(e2);
        }
    }

    public boolean isDisconnected() {
        return this.mStatus == 1;
    }

    private void setStatus(int i) {
        this.mStatus = i;
    }

    /* access modifiers changed from: protected */
    public void close() {
        close(this.mSocket);
        close((Closeable) this.mInput);
        close((Closeable) this.mOutput);
    }

    private void close(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
        }
    }

    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void stopTimer() {
        TCPPacketTimer tCPPacketTimer = this.mTimer;
        if (tCPPacketTimer != null) {
            tCPPacketTimer.stop();
        }
    }

    public synchronized void setTimer(TCPPacketTimer tCPPacketTimer) {
        stopTimer();
        this.mTimer = tCPPacketTimer;
    }

    public synchronized TCPPacketTimer getTimer() {
        return this.mTimer;
    }
}
