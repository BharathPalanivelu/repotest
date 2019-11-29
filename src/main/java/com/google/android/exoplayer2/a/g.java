package com.google.android.exoplayer2.a;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.j;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f9031a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f9032b = {-1, TXRecordCommon.AUDIO_SAMPLERATE_8000, TXRecordCommon.AUDIO_SAMPLERATE_16000, TXRecordCommon.AUDIO_SAMPLERATE_32000, -1, -1, 11025, 22050, TXRecordCommon.AUDIO_SAMPLERATE_44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f9033c = {64, 112, 128, JfifUtil.MARKER_SOFn, 224, 256, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static j a(byte[] bArr, String str, String str2, a aVar) {
        byte[] bArr2 = bArr;
        com.google.android.exoplayer2.n.j jVar = new com.google.android.exoplayer2.n.j(bArr);
        jVar.b(60);
        int i = f9031a[jVar.c(6)];
        int i2 = f9032b[jVar.c(4)];
        int c2 = jVar.c(5);
        int[] iArr = f9033c;
        int i3 = c2 >= iArr.length ? -1 : (iArr[c2] * 1000) / 2;
        jVar.b(10);
        return j.a(str, "audio/vnd.dts", (String) null, i3, -1, i + (jVar.c(2) > 0 ? 1 : 0), i2, (List<byte[]>) null, aVar, 0, str2);
    }

    public static int a(byte[] bArr) {
        return ((((bArr[5] & 252) >> 2) | ((bArr[4] & 1) << 6)) + 1) * 32;
    }

    public static int a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
    }

    public static int b(byte[] bArr) {
        return (((bArr[7] & 240) >> 4) | ((bArr[5] & 2) << com.g.a.a.g.ZERO_TAG) | ((bArr[6] & 255) << 4)) + 1;
    }
}
