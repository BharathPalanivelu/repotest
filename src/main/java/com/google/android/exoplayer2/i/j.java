package com.google.android.exoplayer2.i;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.qalsdk.im_open.http;
import com.tencent.ugc.TXRecordCommon;

public final class j {
    private static final String[] h = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] i = {TXRecordCommon.AUDIO_SAMPLERATE_44100, 48000, TXRecordCommon.AUDIO_SAMPLERATE_32000};
    private static final int[] j = {32, 64, 96, 128, 160, JfifUtil.MARKER_SOFn, 224, 256, 288, 320, 352, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, http.Requested_Range_Not_Satisfiable, 448};
    private static final int[] k = {32, 48, 56, 64, 80, 96, 112, 128, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 160, 176, JfifUtil.MARKER_SOFn, 224, 256};
    private static final int[] l = {32, 48, 56, 64, 80, 96, 112, 128, 160, JfifUtil.MARKER_SOFn, 224, 256, 320, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT};
    private static final int[] m = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, JfifUtil.MARKER_SOFn, 224, 256, 320};
    private static final int[] n = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 160};

    /* renamed from: a  reason: collision with root package name */
    public int f10409a;

    /* renamed from: b  reason: collision with root package name */
    public String f10410b;

    /* renamed from: c  reason: collision with root package name */
    public int f10411c;

    /* renamed from: d  reason: collision with root package name */
    public int f10412d;

    /* renamed from: e  reason: collision with root package name */
    public int f10413e;

    /* renamed from: f  reason: collision with root package name */
    public int f10414f;

    /* renamed from: g  reason: collision with root package name */
    public int f10415g;

    public static int a(int i2) {
        int i3;
        if ((i2 & -2097152) != -2097152) {
            return -1;
        }
        int i4 = (i2 >>> 19) & 3;
        if (i4 == 1) {
            return -1;
        }
        int i5 = (i2 >>> 17) & 3;
        if (i5 == 0) {
            return -1;
        }
        int i6 = (i2 >>> 12) & 15;
        if (i6 == 0 || i6 == 15) {
            return -1;
        }
        int i7 = (i2 >>> 10) & 3;
        if (i7 == 3) {
            return -1;
        }
        int i8 = i[i7];
        if (i4 == 2) {
            i8 /= 2;
        } else if (i4 == 0) {
            i8 /= 4;
        }
        int i9 = (i2 >>> 9) & 1;
        if (i5 == 3) {
            return ((((i4 == 3 ? j[i6 - 1] : k[i6 - 1]) * 12000) / i8) + i9) * 4;
        }
        if (i4 == 3) {
            i3 = i5 == 2 ? l[i6 - 1] : m[i6 - 1];
        } else {
            i3 = n[i6 - 1];
        }
        int i10 = 144000;
        if (i4 == 3) {
            return ((i3 * 144000) / i8) + i9;
        }
        if (i5 == 1) {
            i10 = 72000;
        }
        return ((i10 * i3) / i8) + i9;
    }

    public static boolean a(int i2, j jVar) {
        int i3;
        int i4;
        int i5;
        if ((i2 & -2097152) != -2097152) {
            return false;
        }
        int i6 = (i2 >>> 19) & 3;
        if (i6 == 1) {
            return false;
        }
        int i7 = (i2 >>> 17) & 3;
        if (i7 == 0) {
            return false;
        }
        int i8 = (i2 >>> 12) & 15;
        if (i8 == 0 || i8 == 15) {
            return false;
        }
        int i9 = (i2 >>> 10) & 3;
        if (i9 == 3) {
            return false;
        }
        int i10 = i[i9];
        if (i6 == 2) {
            i10 /= 2;
        } else if (i6 == 0) {
            i10 /= 4;
        }
        int i11 = i10;
        int i12 = (i2 >>> 9) & 1;
        int i13 = 1152;
        if (i7 == 3) {
            i5 = i6 == 3 ? j[i8 - 1] : k[i8 - 1];
            i4 = (((i5 * 12000) / i11) + i12) * 4;
            i3 = BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        } else {
            int i14 = 144000;
            if (i6 == 3) {
                i5 = i7 == 2 ? l[i8 - 1] : m[i8 - 1];
                i4 = ((144000 * i5) / i11) + i12;
                i3 = 1152;
            } else {
                i5 = n[i8 - 1];
                if (i7 == 1) {
                    i13 = 576;
                }
                if (i7 == 1) {
                    i14 = 72000;
                }
                i4 = ((i14 * i5) / i11) + i12;
                i3 = i13;
            }
        }
        jVar.a(i6, h[3 - i7], i4, i11, ((i2 >> 6) & 3) == 3 ? 1 : 2, i5 * 1000, i3);
        return true;
    }

    private void a(int i2, String str, int i3, int i4, int i5, int i6, int i7) {
        this.f10409a = i2;
        this.f10410b = str;
        this.f10411c = i3;
        this.f10412d = i4;
        this.f10413e = i5;
        this.f10414f = i6;
        this.f10415g = i7;
    }
}
