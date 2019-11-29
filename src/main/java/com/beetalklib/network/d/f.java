package com.beetalklib.network.d;

public class f {

    /* renamed from: a  reason: collision with root package name */
    protected int f5522a;

    /* renamed from: b  reason: collision with root package name */
    protected byte[] f5523b;

    public f(int i, byte[] bArr) {
        this.f5522a = i;
        this.f5523b = bArr;
    }

    public int a() {
        return this.f5522a;
    }

    public byte[] b() {
        return this.f5523b;
    }

    protected static void a(byte[] bArr, int i) {
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((65280 & i) >> 8);
        bArr[2] = (byte) ((16711680 & i) >> 16);
        bArr[3] = (byte) ((i & -16777216) >> 24);
    }

    public byte[] c() {
        int length = this.f5523b.length + 5;
        byte[] bArr = new byte[length];
        bArr[4] = (byte) this.f5522a;
        a(bArr, length - 4);
        byte[] bArr2 = this.f5523b;
        System.arraycopy(bArr2, 0, bArr, 5, bArr2.length);
        return bArr;
    }
}
