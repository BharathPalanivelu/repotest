package com.google.android.exoplayer2.s;

import android.util.Pair;
import com.tencent.ugc.TXRecordCommon;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f11387a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f11388b = {96000, 88200, 64000, 48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000, 24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000, 12000, 11025, TXRecordCommon.AUDIO_SAMPLERATE_8000, 7350};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f11389c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> a(byte[] bArr) {
        k kVar = new k(bArr);
        int a2 = a(kVar);
        int b2 = b(kVar);
        int c2 = kVar.c(4);
        if (a2 == 5 || a2 == 29) {
            b2 = b(kVar);
            if (a(kVar) == 22) {
                c2 = kVar.c(4);
            }
        }
        int i = f11389c[c2];
        a.a(i != -1);
        return Pair.create(Integer.valueOf(b2), Integer.valueOf(i));
    }

    public static byte[] a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = f11387a;
        byte[] bArr3 = new byte[(bArr2.length + i2)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, f11387a.length, i2);
        return bArr3;
    }

    private static int a(k kVar) {
        int c2 = kVar.c(5);
        return c2 == 31 ? kVar.c(6) + 32 : c2;
    }

    private static int b(k kVar) {
        int c2 = kVar.c(4);
        if (c2 == 15) {
            return kVar.c(24);
        }
        a.a(c2 < 13);
        return f11388b[c2];
    }
}
