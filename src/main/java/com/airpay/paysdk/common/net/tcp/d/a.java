package com.airpay.paysdk.common.net.tcp.d;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f4066a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f4067b;

    public a(int i, byte[] bArr) {
        this.f4066a = i;
        this.f4067b = bArr;
    }

    private static void a(byte[] bArr, int i) {
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((65280 & i) >> 8);
        bArr[2] = (byte) ((16711680 & i) >> 16);
        bArr[3] = (byte) ((i & -16777216) >> 24);
    }

    public int a() {
        return this.f4066a;
    }

    public byte[] b() {
        return this.f4067b;
    }

    public byte[] c() {
        int length = this.f4067b.length + 6;
        byte[] bArr = new byte[length];
        int i = this.f4066a;
        bArr[5] = (byte) (i & 255);
        bArr[4] = (byte) ((i & 65280) >> 8);
        a(bArr, length - 4);
        byte[] bArr2 = this.f4067b;
        System.arraycopy(bArr2, 0, bArr, 6, bArr2.length);
        return bArr;
    }

    public int d() {
        return this.f4067b.length;
    }
}
