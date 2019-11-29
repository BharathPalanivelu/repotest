package com.google.android.exoplayer2.a;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f8967a = {1, 2, 3, 6};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f8968b = {48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f8969c = {24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f8970d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f8971e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, JfifUtil.MARKER_SOFn, 224, 256, 320, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 576, 640};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f8972f = {69, 87, 104, 121, 139, 174, JfifUtil.MARKER_RST0, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int a() {
        return 1536;
    }

    /* renamed from: com.google.android.exoplayer2.a.a$a  reason: collision with other inner class name */
    public static final class C0155a {

        /* renamed from: a  reason: collision with root package name */
        public final String f8973a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8974b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8975c;

        /* renamed from: d  reason: collision with root package name */
        public final int f8976d;

        /* renamed from: e  reason: collision with root package name */
        public final int f8977e;

        private C0155a(String str, int i, int i2, int i3, int i4) {
            this.f8973a = str;
            this.f8975c = i;
            this.f8974b = i2;
            this.f8976d = i3;
            this.f8977e = i4;
        }
    }

    public static j a(k kVar, String str, String str2, com.google.android.exoplayer2.c.a aVar) {
        int i = f8968b[(kVar.g() & JfifUtil.MARKER_SOFn) >> 6];
        int g2 = kVar.g();
        int i2 = f8970d[(g2 & 56) >> 3];
        if ((g2 & 4) != 0) {
            i2++;
        }
        return j.a(str, "audio/ac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, aVar, 0, str2);
    }

    public static j b(k kVar, String str, String str2, com.google.android.exoplayer2.c.a aVar) {
        k kVar2 = kVar;
        kVar.d(2);
        int i = f8968b[(kVar.g() & JfifUtil.MARKER_SOFn) >> 6];
        int g2 = kVar.g();
        int i2 = f8970d[(g2 & 14) >> 1];
        if ((g2 & 1) != 0) {
            i2++;
        }
        return j.a(str, "audio/eac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, aVar, 0, str2);
    }

    public static C0155a a(com.google.android.exoplayer2.n.j jVar) {
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        int b2 = jVar.b();
        jVar.b(40);
        boolean z = jVar.c(5) == 16;
        jVar.a(b2);
        int i6 = 6;
        if (z) {
            jVar.b(21);
            int c2 = (jVar.c(11) + 1) * 2;
            int c3 = jVar.c(2);
            if (c3 == 3) {
                i5 = f8969c[jVar.c(2)];
            } else {
                i6 = f8967a[jVar.c(2)];
                i5 = f8968b[c3];
            }
            i4 = jVar.c(3);
            i = i6 * 256;
            i2 = c2;
            i3 = i5;
            str = "audio/eac3";
        } else {
            jVar.b(32);
            int c4 = jVar.c(2);
            int a2 = a(c4, jVar.c(6));
            jVar.b(8);
            i4 = jVar.c(3);
            if (!((i4 & 1) == 0 || i4 == 1)) {
                jVar.b(2);
            }
            if ((i4 & 4) != 0) {
                jVar.b(2);
            }
            if (i4 == 2) {
                jVar.b(2);
            }
            i2 = a2;
            i3 = f8968b[c4];
            str = "audio/ac3";
            i = 1536;
        }
        return new C0155a(str, f8970d[i4] + (jVar.d() ? 1 : 0), i3, i2, i);
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
            i = f8967a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }

    private static int a(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = f8968b;
        if (i >= iArr.length || i2 < 0) {
            return -1;
        }
        int[] iArr2 = f8972f;
        if (i3 >= iArr2.length) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return (iArr2[i3] + (i2 % 2)) * 2;
        }
        int i5 = f8971e[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }
}
