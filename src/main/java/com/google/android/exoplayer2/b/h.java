package com.google.android.exoplayer2.b;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.g.a.a.g;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.s.k;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;
import java.util.List;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f9213a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f9214b = {-1, TXRecordCommon.AUDIO_SAMPLERATE_8000, TXRecordCommon.AUDIO_SAMPLERATE_16000, TXRecordCommon.AUDIO_SAMPLERATE_32000, -1, -1, 11025, 22050, TXRecordCommon.AUDIO_SAMPLERATE_44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f9215c = {64, 112, 128, JfifUtil.MARKER_SOFn, 224, 256, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static Format a(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        byte[] bArr2 = bArr;
        k kVar = new k(bArr);
        kVar.b(60);
        int i = f9213a[kVar.c(6)];
        int i2 = f9214b[kVar.c(4)];
        int c2 = kVar.c(5);
        int[] iArr = f9215c;
        int i3 = c2 >= iArr.length ? -1 : (iArr[c2] * 1000) / 2;
        kVar.b(10);
        return Format.a(str, "audio/vnd.dts", (String) null, i3, -1, i + (kVar.c(2) > 0 ? 1 : 0), i2, (List<byte[]>) null, drmInitData, 0, str2);
    }

    public static int a(byte[] bArr) {
        return ((((bArr[5] & 252) >> 2) | ((bArr[4] & 1) << 6)) + 1) * 32;
    }

    public static int a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
    }

    public static int b(byte[] bArr) {
        return (((bArr[7] & 240) >> 4) | ((bArr[5] & 2) << g.ZERO_TAG) | ((bArr[6] & 255) << 4)) + 1;
    }
}
