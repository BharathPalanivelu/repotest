package com.google.android.exoplayer2.b;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.s.k;
import com.google.android.exoplayer2.s.l;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f9141a = {1, 2, 3, 6};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f9142b = {48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f9143c = {24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f9144d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f9145e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, JfifUtil.MARKER_SOFn, 224, 256, 320, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 576, 640};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f9146f = {69, 87, 104, 121, 139, 174, JfifUtil.MARKER_RST0, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int a() {
        return 1536;
    }

    /* renamed from: com.google.android.exoplayer2.b.a$a  reason: collision with other inner class name */
    public static final class C0157a {

        /* renamed from: a  reason: collision with root package name */
        public final String f9147a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9148b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9149c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9150d;

        /* renamed from: e  reason: collision with root package name */
        public final int f9151e;

        private C0157a(String str, int i, int i2, int i3, int i4) {
            this.f9147a = str;
            this.f9149c = i;
            this.f9148b = i2;
            this.f9150d = i3;
            this.f9151e = i4;
        }
    }

    public static Format a(l lVar, String str, String str2, DrmInitData drmInitData) {
        int i = f9142b[(lVar.g() & JfifUtil.MARKER_SOFn) >> 6];
        int g2 = lVar.g();
        int i2 = f9144d[(g2 & 56) >> 3];
        if ((g2 & 4) != 0) {
            i2++;
        }
        return Format.a(str, "audio/ac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, drmInitData, 0, str2);
    }

    public static Format b(l lVar, String str, String str2, DrmInitData drmInitData) {
        l lVar2 = lVar;
        lVar.d(2);
        int i = f9142b[(lVar.g() & JfifUtil.MARKER_SOFn) >> 6];
        int g2 = lVar.g();
        int i2 = f9144d[(g2 & 14) >> 1];
        if ((g2 & 1) != 0) {
            i2++;
        }
        return Format.a(str, "audio/eac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, drmInitData, 0, str2);
    }

    public static C0157a a(k kVar) {
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        int b2 = kVar.b();
        kVar.b(40);
        boolean z = kVar.c(5) == 16;
        kVar.a(b2);
        int i6 = 6;
        if (z) {
            kVar.b(21);
            int c2 = (kVar.c(11) + 1) * 2;
            int c3 = kVar.c(2);
            if (c3 == 3) {
                i5 = f9143c[kVar.c(2)];
            } else {
                i6 = f9141a[kVar.c(2)];
                i5 = f9142b[c3];
            }
            i4 = kVar.c(3);
            i = i6 * 256;
            i2 = c2;
            i3 = i5;
            str = "audio/eac3";
        } else {
            kVar.b(32);
            int c4 = kVar.c(2);
            int a2 = a(c4, kVar.c(6));
            kVar.b(8);
            i4 = kVar.c(3);
            if (!((i4 & 1) == 0 || i4 == 1)) {
                kVar.b(2);
            }
            if ((i4 & 4) != 0) {
                kVar.b(2);
            }
            if (i4 == 2) {
                kVar.b(2);
            }
            i2 = a2;
            i3 = f9142b[c4];
            str = "audio/ac3";
            i = 1536;
        }
        return new C0157a(str, f9144d[i4] + (kVar.e() ? 1 : 0), i3, i2, i);
    }

    public static int a(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        return a((bArr[4] & 192) >> 6, bArr[4] & 63);
    }

    public static int a(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = f9141a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }

    private static int a(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = f9142b;
        if (i >= iArr.length || i2 < 0) {
            return -1;
        }
        int[] iArr2 = f9146f;
        if (i3 >= iArr2.length) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return (iArr2[i3] + (i2 % 2)) * 2;
        }
        int i5 = f9145e[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }
}
