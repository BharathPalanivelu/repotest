package com.garena.android.gpns.network.tcp;

import com.garena.android.gpns.utility.CONSTANT;

public class TCPPacket {
    private int mCommand;
    private byte[] mData;
    private boolean mIsTimed = false;
    private int timeout = CONSTANT.TIME.MIN_1;

    public TCPPacket(int i, byte[] bArr) {
        this.mCommand = i;
        this.mData = bArr;
    }

    public int getCommand() {
        return this.mCommand;
    }

    public byte[] getData() {
        return this.mData;
    }

    private static void assignInt(byte[] bArr, int i) {
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((65280 & i) >> 8);
        bArr[2] = (byte) ((16711680 & i) >> 16);
        bArr[3] = (byte) ((i & -16777216) >> 24);
    }

    public byte[] toByteArray() {
        int length = this.mData.length + 5;
        byte[] bArr = new byte[length];
        bArr[4] = (byte) this.mCommand;
        assignInt(bArr, length - 4);
        byte[] bArr2 = this.mData;
        System.arraycopy(bArr2, 0, bArr, 5, bArr2.length);
        return bArr;
    }

    public void setTimed(boolean z) {
        this.mIsTimed = z;
    }

    public boolean isTimed() {
        return this.mIsTimed;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }
}
