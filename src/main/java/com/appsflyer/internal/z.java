package com.appsflyer.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public final class z extends FilterInputStream {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final short f291 = ((short) ((int) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d))));

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f292;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f293;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f294;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int[] f295 = new int[8];

    /* renamed from: ˋ  reason: contains not printable characters */
    private int[] f296 = new int[8];

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f297 = 8;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f298;

    /* renamed from: ͺ  reason: contains not printable characters */
    private int f299;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int[] f300 = new int[8];

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f301;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f302;

    public final boolean markSupported() {
        return false;
    }

    public z(InputStream inputStream, int[] iArr, int i, byte[] bArr, int i2, int i3) throws IOException {
        super(inputStream);
        this.f294 = Math.min(Math.max(i2, 5), 16);
        this.f301 = i3;
        if (i3 == 3) {
            this.f296 = m214(bArr);
        }
        long j = ((((long) iArr[0]) & 4294967295L) << 32) | (4294967295L & ((long) iArr[1]));
        if (i == 0) {
            this.f292 = (int) j;
            long j2 = j >> 3;
            short s = f291;
            this.f293 = (int) ((((long) s) * j2) >> 32);
            this.f299 = (int) (j >> 32);
            this.f298 = (int) (j2 + ((long) s));
        } else {
            int i4 = (int) j;
            this.f292 = i4;
            this.f293 = i4 * i;
            this.f299 = i4 ^ i;
            this.f298 = (int) (j >> 32);
        }
        this.f302 = this.in.read();
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int read = read();
        if (read == -1) {
            return -1;
        }
        bArr[i] = (byte) read;
        int i3 = 1;
        while (i3 < i2) {
            int read2 = read();
            if (read2 == -1) {
                return i3;
            }
            bArr[i + i3] = (byte) read2;
            i3++;
        }
        return i3;
    }

    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    public final int available() throws IOException {
        return 8 - this.f297;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int[] m214(byte[] bArr) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = bArr[i] & 255;
        }
        return iArr;
    }

    public final int read() throws IOException {
        if (this.f297 == 8) {
            int i = this.f302;
            if (i == -1) {
                Arrays.fill(this.f295, -1);
            } else {
                this.f295[0] = i;
                for (int i2 = 1; i2 < 8; i2++) {
                    this.f295[i2] = this.in.read();
                }
                if (this.f301 == 3) {
                    int[] iArr = this.f295;
                    System.arraycopy(iArr, 0, this.f300, 0, iArr.length);
                }
                int[] iArr2 = this.f295;
                int i3 = ((iArr2[0] << 24) & -16777216) + ((iArr2[1] << 16) & 16711680) + ((iArr2[2] << 8) & 65280) + (iArr2[3] & 255);
                int i4 = (-16777216 & (iArr2[4] << 24)) + (16711680 & (iArr2[5] << 16)) + ((iArr2[6] << 8) & 65280) + (iArr2[7] & 255);
                int i5 = 0;
                while (true) {
                    int i6 = this.f294;
                    if (i5 >= i6) {
                        break;
                    }
                    short s = f291;
                    i4 -= ((((i6 - i5) * s) + i3) ^ ((i3 << 4) + this.f299)) ^ ((i3 >>> 5) + this.f298);
                    i3 -= (((i4 << 4) + this.f292) ^ ((s * (i6 - i5)) + i4)) ^ ((i4 >>> 5) + this.f293);
                    i5++;
                }
                int[] iArr3 = this.f295;
                iArr3[0] = i3 >>> 24;
                iArr3[1] = (i3 >> 16) & 255;
                iArr3[2] = (i3 >> 8) & 255;
                iArr3[3] = i3 & 255;
                iArr3[4] = i4 >>> 24;
                iArr3[5] = (i4 >> 16) & 255;
                iArr3[6] = (i4 >> 8) & 255;
                iArr3[7] = i4 & 255;
                if (this.f301 == 3) {
                    for (int i7 = 0; i7 < 8; i7++) {
                        int[] iArr4 = this.f295;
                        iArr4[i7] = (iArr4[i7] ^ this.f296[i7]) & 255;
                    }
                    int[] iArr5 = this.f300;
                    System.arraycopy(iArr5, 0, this.f296, 0, iArr5.length);
                }
                this.f302 = this.in.read();
                if (this.f302 == -1) {
                    int[] iArr6 = this.f295;
                    Arrays.fill(iArr6, 8 - iArr6[7], 8, -1);
                }
            }
            this.f297 = 0;
        }
        int[] iArr7 = this.f295;
        int i8 = this.f297;
        this.f297 = i8 + 1;
        return iArr7[i8];
    }
}
