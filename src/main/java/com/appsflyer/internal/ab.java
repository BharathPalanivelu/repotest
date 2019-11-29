package com.appsflyer.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ab extends FilterInputStream {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final int[] f119 = ac.f135;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final int[] f120 = ac.f134;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final int[] f121 = ac.f137;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final byte[] f122 = ac.f138;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final int[] f123 = ac.f136;

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int[] f124;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final byte[] f125 = new byte[16];

    /* renamed from: ʽ  reason: contains not printable characters */
    private final int f126;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f127 = 16;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f128 = 16;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f129 = Integer.MAX_VALUE;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final byte[] f130 = new byte[16];

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final byte[][] f131;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final int[] f132 = new int[4];

    public final boolean markSupported() {
        return false;
    }

    public ab(InputStream inputStream, int i, byte[] bArr, byte[][] bArr2) {
        super(inputStream);
        this.f126 = i;
        this.f124 = ac.m123(bArr, i);
        this.f131 = m122(bArr2);
    }

    public final int read() throws IOException {
        m121();
        int i = this.f128;
        if (i >= this.f127) {
            return -1;
        }
        byte[] bArr = this.f130;
        this.f128 = i + 1;
        return bArr[i] & 255;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = i;
        while (i4 < i3) {
            m121();
            int i5 = this.f128;
            if (i5 < this.f127) {
                byte[] bArr2 = this.f130;
                this.f128 = i5 + 1;
                bArr[i4] = bArr2[i5];
                i4++;
            } else if (i4 == i) {
                return -1;
            } else {
                return i2 - (i3 - i4);
            }
        }
        return i2;
    }

    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    public final int available() throws IOException {
        return this.f127 - this.f128;
    }

    public final void close() throws IOException {
        super.close();
    }

    public final synchronized void mark(int i) {
    }

    public final synchronized void reset() throws IOException {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static byte[][] m122(byte[][] bArr) {
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = new byte[bArr[i].length];
            for (int i2 = 0; i2 < bArr[i].length; i2++) {
                bArr2[i][bArr[i][i2]] = (byte) i2;
            }
        }
        return bArr2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private int m121() throws IOException {
        if (this.f129 == Integer.MAX_VALUE) {
            this.f129 = this.in.read();
        }
        int i = 16;
        if (this.f128 == 16) {
            this.f125[0] = (byte) this.f129;
            int i2 = 1;
            do {
                i2 += this.in.read(this.f125, i2, 16 - i2);
            } while (i2 < 16);
            m120(this.f125, this.f130);
            this.f129 = this.in.read();
            this.f128 = 0;
            if (this.f129 < 0) {
                i = 16 - (this.f130[15] & 255);
            }
            this.f127 = i;
        }
        return this.f127;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m120(byte[] bArr, byte[] bArr2) {
        int[] iArr = this.f132;
        char c2 = 1;
        byte b2 = (bArr[0] << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        int[] iArr2 = this.f124;
        iArr[0] = b2 ^ iArr2[0];
        iArr[1] = ((((bArr[4] << 24) | ((bArr[5] & 255) << 16)) | ((bArr[6] & 255) << 8)) | (bArr[7] & 255)) ^ iArr2[1];
        iArr[2] = ((((bArr[8] << 24) | ((bArr[9] & 255) << 16)) | ((bArr[10] & 255) << 8)) | (bArr[11] & 255)) ^ iArr2[2];
        iArr[3] = iArr2[3] ^ ((((bArr[12] << 24) | ((bArr[13] & 255) << 16)) | ((bArr[14] & 255) << 8)) | (bArr[15] & 255));
        int i = 1;
        int i2 = 4;
        while (i < this.f126) {
            int[] iArr3 = f121;
            int[] iArr4 = this.f132;
            byte[][] bArr3 = this.f131;
            int i3 = iArr3[iArr4[bArr3[0][0]] >>> 24];
            int[] iArr5 = f120;
            int i4 = i3 ^ iArr5[(iArr4[bArr3[c2][0]] >>> 16) & 255];
            int[] iArr6 = f119;
            int i5 = iArr6[(iArr4[bArr3[2][0]] >>> 8) & 255] ^ i4;
            int[] iArr7 = f123;
            int i6 = iArr7[iArr4[bArr3[3][0]] & 255] ^ i5;
            int[] iArr8 = this.f124;
            int i7 = i6 ^ iArr8[i2];
            int i8 = ((iArr6[(iArr4[bArr3[2][c2]] >>> 8) & 255] ^ (iArr3[iArr4[bArr3[0][c2]] >>> 24] ^ iArr5[(iArr4[bArr3[c2][c2]] >>> 16) & 255])) ^ iArr7[iArr4[bArr3[3][c2]] & 255]) ^ iArr8[i2 + 1];
            int i9 = (((iArr5[(iArr4[bArr3[c2][2]] >>> 16) & 255] ^ iArr3[iArr4[bArr3[0][2]] >>> 24]) ^ iArr6[(iArr4[bArr3[2][2]] >>> 8) & 255]) ^ iArr7[iArr4[bArr3[3][2]] & 255]) ^ iArr8[i2 + 2];
            iArr4[0] = i7;
            iArr4[1] = i8;
            iArr4[2] = i9;
            iArr4[3] = (((iArr3[iArr4[bArr3[0][3]] >>> 24] ^ iArr5[(iArr4[bArr3[1][3]] >>> 16) & 255]) ^ iArr6[(iArr4[bArr3[2][3]] >>> 8) & 255]) ^ iArr7[iArr4[bArr3[3][3]] & 255]) ^ iArr8[i2 + 3];
            i++;
            i2 += 4;
            c2 = 1;
        }
        int[] iArr9 = this.f124;
        int i10 = iArr9[i2];
        byte[] bArr4 = f122;
        int[] iArr10 = this.f132;
        byte[][] bArr5 = this.f131;
        bArr2[0] = (byte) (bArr4[iArr10[bArr5[0][0]] >>> 24] ^ (i10 >>> 24));
        bArr2[1] = (byte) (bArr4[(iArr10[bArr5[1][0]] >>> 16) & 255] ^ (i10 >>> 16));
        bArr2[2] = (byte) (bArr4[(iArr10[bArr5[2][0]] >>> 8) & 255] ^ (i10 >>> 8));
        bArr2[3] = (byte) (i10 ^ bArr4[iArr10[bArr5[3][0]] & 255]);
        int i11 = iArr9[i2 + 1];
        bArr2[4] = (byte) (bArr4[iArr10[bArr5[0][1]] >>> 24] ^ (i11 >>> 24));
        bArr2[5] = (byte) (bArr4[(iArr10[bArr5[1][1]] >>> 16) & 255] ^ (i11 >>> 16));
        bArr2[6] = (byte) (bArr4[(iArr10[bArr5[2][1]] >>> 8) & 255] ^ (i11 >>> 8));
        bArr2[7] = (byte) (i11 ^ bArr4[iArr10[bArr5[3][1]] & 255]);
        int i12 = iArr9[i2 + 2];
        bArr2[8] = (byte) (bArr4[iArr10[bArr5[0][2]] >>> 24] ^ (i12 >>> 24));
        bArr2[9] = (byte) (bArr4[(iArr10[bArr5[1][2]] >>> 16) & 255] ^ (i12 >>> 16));
        bArr2[10] = (byte) (bArr4[(iArr10[bArr5[2][2]] >>> 8) & 255] ^ (i12 >>> 8));
        bArr2[11] = (byte) (i12 ^ bArr4[iArr10[bArr5[3][2]] & 255]);
        int i13 = iArr9[i2 + 3];
        bArr2[12] = (byte) (bArr4[iArr10[bArr5[0][3]] >>> 24] ^ (i13 >>> 24));
        bArr2[13] = (byte) (bArr4[(iArr10[bArr5[1][3]] >>> 16) & 255] ^ (i13 >>> 16));
        bArr2[14] = (byte) (bArr4[(iArr10[bArr5[2][3]] >>> 8) & 255] ^ (i13 >>> 8));
        bArr2[15] = (byte) (i13 ^ bArr4[iArr10[bArr5[3][3]] & 255]);
    }
}
