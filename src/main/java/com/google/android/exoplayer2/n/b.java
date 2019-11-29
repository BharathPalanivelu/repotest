package com.google.android.exoplayer2.n;

import android.util.Pair;
import com.tencent.ugc.TXRecordCommon;
import java.util.ArrayList;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f10913a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f10914b = {96000, 88200, 64000, 48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000, 24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000, 12000, 11025, TXRecordCommon.AUDIO_SAMPLERATE_8000, 7350};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f10915c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> a(byte[] bArr) {
        j jVar = new j(bArr);
        int a2 = a(jVar);
        int b2 = b(jVar);
        int c2 = jVar.c(4);
        if (a2 == 5 || a2 == 29) {
            b2 = b(jVar);
            if (a(jVar) == 22) {
                c2 = jVar.c(4);
            }
        }
        int i = f10915c[c2];
        a.a(i != -1);
        return Pair.create(Integer.valueOf(b2), Integer.valueOf(i));
    }

    public static byte[] a(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        while (true) {
            int[] iArr = f10914b;
            if (i4 >= iArr.length) {
                break;
            }
            if (i == iArr[i4]) {
                i5 = i4;
            }
            i4++;
        }
        int i6 = -1;
        while (true) {
            int[] iArr2 = f10915c;
            if (i3 >= iArr2.length) {
                break;
            }
            if (i2 == iArr2[i3]) {
                i6 = i3;
            }
            i3++;
        }
        if (i != -1 && i6 != -1) {
            return a(2, i5, i6);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i + ", " + i2);
    }

    public static byte[] a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = f10913a;
        byte[] bArr3 = new byte[(bArr2.length + i2)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, f10913a.length, i2);
        return bArr3;
    }

    public static byte[][] b(byte[] bArr) {
        if (!b(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        do {
            arrayList.add(Integer.valueOf(i));
            i = a(bArr, i + f10913a.length);
        } while (i != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i2)).intValue();
            byte[] bArr3 = new byte[((i2 < arrayList.size() + -1 ? ((Integer) arrayList.get(i2 + 1)).intValue() : bArr.length) - intValue)];
            System.arraycopy(bArr, intValue, bArr3, 0, bArr3.length);
            bArr2[i2] = bArr3;
            i2++;
        }
        return bArr2;
    }

    private static int a(byte[] bArr, int i) {
        int length = bArr.length - f10913a.length;
        while (i <= length) {
            if (b(bArr, i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static boolean b(byte[] bArr, int i) {
        if (bArr.length - i <= f10913a.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f10913a;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private static int a(j jVar) {
        int c2 = jVar.c(5);
        return c2 == 31 ? jVar.c(6) + 32 : c2;
    }

    private static int b(j jVar) {
        int c2 = jVar.c(4);
        if (c2 == 15) {
            return jVar.c(24);
        }
        a.a(c2 < 13);
        return f10914b[c2];
    }
}
