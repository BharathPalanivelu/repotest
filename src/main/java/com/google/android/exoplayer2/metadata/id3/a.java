package com.google.android.exoplayer2.metadata.id3;

import android.util.Log;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.v;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class a implements com.google.android.exoplayer2.metadata.a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f10880a = v.g("ID3");

    /* renamed from: b  reason: collision with root package name */
    private final C0178a f10881b;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.a$a  reason: collision with other inner class name */
    public interface C0178a {
        boolean a(int i, int i2, int i3, int i4, int i5);
    }

    private static String a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16" : "ISO-8859-1";
    }

    private static int b(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public a() {
        this((C0178a) null);
    }

    public a(C0178a aVar) {
        this.f10881b = aVar;
    }

    public Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.f9881b;
        return a(byteBuffer.array(), byteBuffer.limit());
    }

    public Metadata a(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        l lVar = new l(bArr, i);
        b a2 = a(lVar);
        if (a2 == null) {
            return null;
        }
        int d2 = lVar.d();
        int i2 = a2.f10882a == 2 ? 6 : 10;
        int b2 = a2.f10884c;
        if (a2.f10883b) {
            b2 = f(lVar, a2.f10884c);
        }
        lVar.b(d2 + b2);
        boolean z = false;
        if (!a(lVar, a2.f10882a, i2, false)) {
            if (a2.f10882a != 4 || !a(lVar, 4, i2, true)) {
                Log.w("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + a2.f10882a);
                return null;
            }
            z = true;
        }
        while (lVar.b() >= i2) {
            Id3Frame a3 = a(a2.f10882a, lVar, z, i2, this.f10881b);
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static b a(l lVar) {
        if (lVar.b() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int k = lVar.k();
        if (k != f10880a) {
            Log.w("Id3Decoder", "Unexpected first three bytes of ID3 tag header: " + k);
            return null;
        }
        int g2 = lVar.g();
        boolean z = true;
        lVar.d(1);
        int g3 = lVar.g();
        int s = lVar.s();
        if (g2 == 2) {
            if ((g3 & 64) != 0) {
                Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (g2 == 3) {
            if ((g3 & 64) != 0) {
                int n = lVar.n();
                lVar.d(n);
                s -= n + 4;
            }
        } else if (g2 == 4) {
            if ((g3 & 64) != 0) {
                int s2 = lVar.s();
                lVar.d(s2 - 4);
                s -= s2;
            }
            if ((g3 & 16) != 0) {
                s -= 10;
            }
        } else {
            Log.w("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + g2);
            return null;
        }
        if (g2 >= 4 || (g3 & 128) == 0) {
            z = false;
        }
        return new b(g2, z, s);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        if ((r10 & 1) != 0) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0085, code lost:
        if ((r10 & 128) != 0) goto L_0x0078;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009b A[SYNTHETIC, Splitter:B:49:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0097 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.google.android.exoplayer2.s.l r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.d()
        L_0x0008:
            int r3 = r18.b()     // Catch:{ all -> 0x00b2 }
            r4 = 1
            r5 = r20
            if (r3 < r5) goto L_0x00ae
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0022
            int r7 = r18.n()     // Catch:{ all -> 0x00b2 }
            long r8 = r18.l()     // Catch:{ all -> 0x00b2 }
            int r10 = r18.h()     // Catch:{ all -> 0x00b2 }
            goto L_0x002c
        L_0x0022:
            int r7 = r18.k()     // Catch:{ all -> 0x00b2 }
            int r8 = r18.k()     // Catch:{ all -> 0x00b2 }
            long r8 = (long) r8
            r10 = 0
        L_0x002c:
            r11 = 0
            if (r7 != 0) goto L_0x003a
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x003a
            if (r10 != 0) goto L_0x003a
            r1.c(r2)
            return r4
        L_0x003a:
            r7 = 4
            if (r0 != r7) goto L_0x006b
            if (r21 != 0) goto L_0x006b
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L_0x004b
            r1.c(r2)
            return r6
        L_0x004b:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L_0x006b:
            if (r0 != r7) goto L_0x007a
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0073
            r3 = 1
            goto L_0x0074
        L_0x0073:
            r3 = 0
        L_0x0074:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x0089
        L_0x0078:
            r7 = 1
            goto L_0x008a
        L_0x007a:
            if (r0 != r3) goto L_0x0088
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0082
            r3 = 1
            goto L_0x0083
        L_0x0082:
            r3 = 0
        L_0x0083:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0089
            goto L_0x0078
        L_0x0088:
            r3 = 0
        L_0x0089:
            r7 = 0
        L_0x008a:
            if (r3 == 0) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            r4 = 0
        L_0x008e:
            if (r7 == 0) goto L_0x0092
            int r4 = r4 + 4
        L_0x0092:
            long r3 = (long) r4
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x009b
            r1.c(r2)
            return r6
        L_0x009b:
            int r3 = r18.b()     // Catch:{ all -> 0x00b2 }
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a8
            r1.c(r2)
            return r6
        L_0x00a8:
            int r3 = (int) r8
            r1.d(r3)     // Catch:{ all -> 0x00b2 }
            goto L_0x0008
        L_0x00ae:
            r1.c(r2)
            return r4
        L_0x00b2:
            r0 = move-exception
            r1.c(r2)
            goto L_0x00b8
        L_0x00b7:
            throw r0
        L_0x00b8:
            goto L_0x00b7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.a.a(com.google.android.exoplayer2.s.l, int, int, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0193, code lost:
        if (r13 == 67) goto L_0x0195;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.metadata.id3.Id3Frame a(int r19, com.google.android.exoplayer2.s.l r20, boolean r21, int r22, com.google.android.exoplayer2.metadata.id3.a.C0178a r23) {
        /*
            r0 = r19
            r7 = r20
            int r8 = r20.g()
            int r9 = r20.g()
            int r10 = r20.g()
            r11 = 3
            if (r0 < r11) goto L_0x0019
            int r1 = r20.g()
            r13 = r1
            goto L_0x001a
        L_0x0019:
            r13 = 0
        L_0x001a:
            r14 = 4
            if (r0 != r14) goto L_0x003c
            int r1 = r20.t()
            if (r21 != 0) goto L_0x003a
            r2 = r1 & 255(0xff, float:3.57E-43)
            int r3 = r1 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 7
            r2 = r2 | r3
            int r3 = r1 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 14
            r2 = r2 | r3
            int r1 = r1 >> 24
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 21
            r1 = r1 | r2
        L_0x003a:
            r15 = r1
            goto L_0x0048
        L_0x003c:
            if (r0 != r11) goto L_0x0043
            int r1 = r20.t()
            goto L_0x003a
        L_0x0043:
            int r1 = r20.k()
            goto L_0x003a
        L_0x0048:
            if (r0 < r11) goto L_0x0050
            int r1 = r20.h()
            r6 = r1
            goto L_0x0051
        L_0x0050:
            r6 = 0
        L_0x0051:
            r16 = 0
            if (r8 != 0) goto L_0x0067
            if (r9 != 0) goto L_0x0067
            if (r10 != 0) goto L_0x0067
            if (r13 != 0) goto L_0x0067
            if (r15 != 0) goto L_0x0067
            if (r6 != 0) goto L_0x0067
            int r0 = r20.c()
            r7.c(r0)
            return r16
        L_0x0067:
            int r1 = r20.d()
            int r5 = r1 + r15
            int r1 = r20.c()
            java.lang.String r4 = "Id3Decoder"
            if (r5 <= r1) goto L_0x0082
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            android.util.Log.w(r4, r0)
            int r0 = r20.c()
            r7.c(r0)
            return r16
        L_0x0082:
            if (r23 == 0) goto L_0x009a
            r1 = r23
            r2 = r19
            r3 = r8
            r12 = r4
            r4 = r9
            r14 = r5
            r5 = r10
            r18 = r6
            r6 = r13
            boolean r1 = r1.a(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x009e
            r7.c(r14)
            return r16
        L_0x009a:
            r12 = r4
            r14 = r5
            r18 = r6
        L_0x009e:
            r1 = 1
            if (r0 != r11) goto L_0x00bc
            r2 = r18
            r3 = r2 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x00a9
            r3 = 1
            goto L_0x00aa
        L_0x00a9:
            r3 = 0
        L_0x00aa:
            r4 = r2 & 64
            if (r4 == 0) goto L_0x00b0
            r4 = 1
            goto L_0x00b1
        L_0x00b0:
            r4 = 0
        L_0x00b1:
            r2 = r2 & 32
            if (r2 == 0) goto L_0x00b7
            r2 = 1
            goto L_0x00b8
        L_0x00b7:
            r2 = 0
        L_0x00b8:
            r17 = r3
            r6 = 0
            goto L_0x00f2
        L_0x00bc:
            r2 = r18
            r3 = 4
            if (r0 != r3) goto L_0x00ec
            r3 = r2 & 64
            if (r3 == 0) goto L_0x00c7
            r3 = 1
            goto L_0x00c8
        L_0x00c7:
            r3 = 0
        L_0x00c8:
            r4 = r2 & 8
            if (r4 == 0) goto L_0x00ce
            r4 = 1
            goto L_0x00cf
        L_0x00ce:
            r4 = 0
        L_0x00cf:
            r5 = r2 & 4
            if (r5 == 0) goto L_0x00d5
            r5 = 1
            goto L_0x00d6
        L_0x00d5:
            r5 = 0
        L_0x00d6:
            r6 = r2 & 2
            if (r6 == 0) goto L_0x00dc
            r6 = 1
            goto L_0x00dd
        L_0x00dc:
            r6 = 0
        L_0x00dd:
            r2 = r2 & r1
            if (r2 == 0) goto L_0x00e3
            r17 = 1
            goto L_0x00e5
        L_0x00e3:
            r17 = 0
        L_0x00e5:
            r2 = r3
            r3 = r17
            r17 = r4
            r4 = r5
            goto L_0x00f2
        L_0x00ec:
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r17 = 0
        L_0x00f2:
            if (r17 != 0) goto L_0x021c
            if (r4 == 0) goto L_0x00f8
            goto L_0x021c
        L_0x00f8:
            if (r2 == 0) goto L_0x00ff
            int r15 = r15 + -1
            r7.d(r1)
        L_0x00ff:
            if (r3 == 0) goto L_0x0107
            int r15 = r15 + -4
            r1 = 4
            r7.d(r1)
        L_0x0107:
            if (r6 == 0) goto L_0x010e
            int r1 = f(r7, r15)
            r15 = r1
        L_0x010e:
            r1 = 84
            r2 = 2
            r3 = 88
            if (r8 != r1) goto L_0x0123
            if (r9 != r3) goto L_0x0123
            if (r10 != r3) goto L_0x0123
            if (r0 == r2) goto L_0x011d
            if (r13 != r3) goto L_0x0123
        L_0x011d:
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = a((com.google.android.exoplayer2.s.l) r7, (int) r15)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            goto L_0x01e9
        L_0x0123:
            if (r8 != r1) goto L_0x0132
            java.lang.String r1 = a((int) r0, (int) r8, (int) r9, (int) r10, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = a((com.google.android.exoplayer2.s.l) r7, (int) r15, (java.lang.String) r1)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            goto L_0x01e9
        L_0x012f:
            r0 = move-exception
            goto L_0x0218
        L_0x0132:
            r4 = 87
            if (r8 != r4) goto L_0x0144
            if (r9 != r3) goto L_0x0144
            if (r10 != r3) goto L_0x0144
            if (r0 == r2) goto L_0x013e
            if (r13 != r3) goto L_0x0144
        L_0x013e:
            com.google.android.exoplayer2.metadata.id3.UrlLinkFrame r1 = b((com.google.android.exoplayer2.s.l) r7, (int) r15)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            goto L_0x01e9
        L_0x0144:
            r3 = 87
            if (r8 != r3) goto L_0x0152
            java.lang.String r1 = a((int) r0, (int) r8, (int) r9, (int) r10, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            com.google.android.exoplayer2.metadata.id3.UrlLinkFrame r1 = b((com.google.android.exoplayer2.s.l) r7, (int) r15, (java.lang.String) r1)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            goto L_0x01e9
        L_0x0152:
            r3 = 73
            r4 = 80
            if (r8 != r4) goto L_0x0168
            r5 = 82
            if (r9 != r5) goto L_0x0168
            if (r10 != r3) goto L_0x0168
            r5 = 86
            if (r13 != r5) goto L_0x0168
            com.google.android.exoplayer2.metadata.id3.PrivFrame r1 = c(r7, r15)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            goto L_0x01e9
        L_0x0168:
            r5 = 71
            r6 = 79
            if (r8 != r5) goto L_0x0180
            r5 = 69
            if (r9 != r5) goto L_0x0180
            if (r10 != r6) goto L_0x0180
            r5 = 66
            if (r13 == r5) goto L_0x017a
            if (r0 != r2) goto L_0x0180
        L_0x017a:
            com.google.android.exoplayer2.metadata.id3.GeobFrame r1 = d(r7, r15)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            goto L_0x01e9
        L_0x0180:
            r5 = 67
            if (r0 != r2) goto L_0x018b
            if (r8 != r4) goto L_0x019a
            if (r9 != r3) goto L_0x019a
            if (r10 != r5) goto L_0x019a
            goto L_0x0195
        L_0x018b:
            r11 = 65
            if (r8 != r11) goto L_0x019a
            if (r9 != r4) goto L_0x019a
            if (r10 != r3) goto L_0x019a
            if (r13 != r5) goto L_0x019a
        L_0x0195:
            com.google.android.exoplayer2.metadata.id3.ApicFrame r1 = a((com.google.android.exoplayer2.s.l) r7, (int) r15, (int) r0)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            goto L_0x01e9
        L_0x019a:
            if (r8 != r5) goto L_0x01ad
            if (r9 != r6) goto L_0x01ad
            r3 = 77
            if (r10 != r3) goto L_0x01ad
            r3 = 77
            if (r13 == r3) goto L_0x01a8
            if (r0 != r2) goto L_0x01ad
        L_0x01a8:
            com.google.android.exoplayer2.metadata.id3.CommentFrame r1 = e(r7, r15)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            goto L_0x01e9
        L_0x01ad:
            if (r8 != r5) goto L_0x01c9
            r2 = 72
            if (r9 != r2) goto L_0x01c9
            r2 = 65
            if (r10 != r2) goto L_0x01c9
            if (r13 != r4) goto L_0x01c9
            r1 = r20
            r2 = r15
            r3 = r19
            r4 = r21
            r5 = r22
            r6 = r23
            com.google.android.exoplayer2.metadata.id3.ChapterFrame r1 = a(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            goto L_0x01e9
        L_0x01c9:
            if (r8 != r5) goto L_0x01e1
            if (r9 != r1) goto L_0x01e1
            if (r10 != r6) goto L_0x01e1
            if (r13 != r5) goto L_0x01e1
            r1 = r20
            r2 = r15
            r3 = r19
            r4 = r21
            r5 = r22
            r6 = r23
            com.google.android.exoplayer2.metadata.id3.ChapterTocFrame r1 = b(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            goto L_0x01e9
        L_0x01e1:
            java.lang.String r1 = a((int) r0, (int) r8, (int) r9, (int) r10, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            com.google.android.exoplayer2.metadata.id3.BinaryFrame r1 = c(r7, r15, r1)     // Catch:{ UnsupportedEncodingException -> 0x020f }
        L_0x01e9:
            if (r1 != 0) goto L_0x020b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x020f }
            r2.<init>()     // Catch:{ UnsupportedEncodingException -> 0x020f }
            java.lang.String r3 = "Failed to decode frame: id="
            r2.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            java.lang.String r0 = a((int) r0, (int) r8, (int) r9, (int) r10, (int) r13)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            r2.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            java.lang.String r0 = ", frameSize="
            r2.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            r2.append(r15)     // Catch:{ UnsupportedEncodingException -> 0x020f }
            java.lang.String r0 = r2.toString()     // Catch:{ UnsupportedEncodingException -> 0x020f }
            android.util.Log.w(r12, r0)     // Catch:{ UnsupportedEncodingException -> 0x020f }
        L_0x020b:
            r7.c(r14)
            return r1
        L_0x020f:
            java.lang.String r0 = "Unsupported character encoding"
            android.util.Log.w(r12, r0)     // Catch:{ all -> 0x012f }
            r7.c(r14)
            return r16
        L_0x0218:
            r7.c(r14)
            throw r0
        L_0x021c:
            java.lang.String r0 = "Skipping unsupported compressed or encrypted frame"
            android.util.Log.w(r12, r0)
            r7.c(r14)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.a.a(int, com.google.android.exoplayer2.s.l, boolean, int, com.google.android.exoplayer2.metadata.id3.a$a):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    private static TextInformationFrame a(l lVar, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int g2 = lVar.g();
        String a2 = a(g2);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        lVar.a(bArr, 0, i2);
        int a3 = a(bArr, 0, g2);
        String str = new String(bArr, 0, a3, a2);
        int b2 = a3 + b(g2);
        return new TextInformationFrame("TXXX", str, b2 < bArr.length ? new String(bArr, b2, a(bArr, b2, g2) - b2, a2) : "");
    }

    private static TextInformationFrame a(l lVar, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int g2 = lVar.g();
        String a2 = a(g2);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        lVar.a(bArr, 0, i2);
        return new TextInformationFrame(str, (String) null, new String(bArr, 0, a(bArr, 0, g2), a2));
    }

    private static UrlLinkFrame b(l lVar, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int g2 = lVar.g();
        String a2 = a(g2);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        lVar.a(bArr, 0, i2);
        int a3 = a(bArr, 0, g2);
        String str = new String(bArr, 0, a3, a2);
        int b2 = a3 + b(g2);
        return new UrlLinkFrame("WXXX", str, b2 < bArr.length ? new String(bArr, b2, b(bArr, b2) - b2, "ISO-8859-1") : "");
    }

    private static UrlLinkFrame b(l lVar, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        lVar.a(bArr, 0, i);
        return new UrlLinkFrame(str, (String) null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    private static PrivFrame c(l lVar, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        lVar.a(bArr, 0, i);
        int b2 = b(bArr, 0);
        return new PrivFrame(new String(bArr, 0, b2, "ISO-8859-1"), b(bArr, b2 + 1, bArr.length));
    }

    private static GeobFrame d(l lVar, int i) throws UnsupportedEncodingException {
        int g2 = lVar.g();
        String a2 = a(g2);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        lVar.a(bArr, 0, i2);
        int b2 = b(bArr, 0);
        String str = new String(bArr, 0, b2, "ISO-8859-1");
        int i3 = b2 + 1;
        int a3 = a(bArr, i3, g2);
        String str2 = new String(bArr, i3, a3 - i3, a2);
        int b3 = a3 + b(g2);
        int a4 = a(bArr, b3, g2);
        return new GeobFrame(str, str2, new String(bArr, b3, a4 - b3, a2), b(bArr, a4 + b(g2), bArr.length));
    }

    private static ApicFrame a(l lVar, int i, int i2) throws UnsupportedEncodingException {
        int i3;
        String str;
        int g2 = lVar.g();
        String a2 = a(g2);
        int i4 = i - 1;
        byte[] bArr = new byte[i4];
        lVar.a(bArr, 0, i4);
        if (i2 == 2) {
            str = "image/" + v.d(new String(bArr, 0, 3, "ISO-8859-1"));
            if (str.equals("image/jpg")) {
                str = "image/jpeg";
            }
            i3 = 2;
        } else {
            i3 = b(bArr, 0);
            String d2 = v.d(new String(bArr, 0, i3, "ISO-8859-1"));
            if (d2.indexOf(47) == -1) {
                str = "image/" + d2;
            } else {
                str = d2;
            }
        }
        int i5 = i3 + 2;
        int a3 = a(bArr, i5, g2);
        return new ApicFrame(str, new String(bArr, i5, a3 - i5, a2), bArr[i3 + 1] & 255, b(bArr, a3 + b(g2), bArr.length));
    }

    private static CommentFrame e(l lVar, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int g2 = lVar.g();
        String a2 = a(g2);
        byte[] bArr = new byte[3];
        lVar.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        lVar.a(bArr2, 0, i2);
        int a3 = a(bArr2, 0, g2);
        String str2 = new String(bArr2, 0, a3, a2);
        int b2 = a3 + b(g2);
        return new CommentFrame(str, str2, b2 < bArr2.length ? new String(bArr2, b2, a(bArr2, b2, g2) - b2, a2) : "");
    }

    private static ChapterFrame a(l lVar, int i, int i2, boolean z, int i3, C0178a aVar) throws UnsupportedEncodingException {
        l lVar2 = lVar;
        int d2 = lVar.d();
        int b2 = b(lVar2.f11422a, d2);
        String str = new String(lVar2.f11422a, d2, b2 - d2, "ISO-8859-1");
        lVar.c(b2 + 1);
        int n = lVar.n();
        int n2 = lVar.n();
        long l = lVar.l();
        long j = l == 4294967295L ? -1 : l;
        long l2 = lVar.l();
        long j2 = l2 == 4294967295L ? -1 : l2;
        ArrayList arrayList = new ArrayList();
        int i4 = d2 + i;
        while (lVar.d() < i4) {
            Id3Frame a2 = a(i2, lVar, z, i3, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, n, n2, j, j2, id3FrameArr);
    }

    private static ChapterTocFrame b(l lVar, int i, int i2, boolean z, int i3, C0178a aVar) throws UnsupportedEncodingException {
        l lVar2 = lVar;
        int d2 = lVar.d();
        int b2 = b(lVar2.f11422a, d2);
        String str = new String(lVar2.f11422a, d2, b2 - d2, "ISO-8859-1");
        lVar.c(b2 + 1);
        int g2 = lVar.g();
        boolean z2 = (g2 & 2) != 0;
        boolean z3 = (g2 & 1) != 0;
        int g3 = lVar.g();
        String[] strArr = new String[g3];
        for (int i4 = 0; i4 < g3; i4++) {
            int d3 = lVar.d();
            int b3 = b(lVar2.f11422a, d3);
            strArr[i4] = new String(lVar2.f11422a, d3, b3 - d3, "ISO-8859-1");
            lVar.c(b3 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = d2 + i;
        while (lVar.d() < i5) {
            Id3Frame a2 = a(i2, lVar, z, i3, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    private static BinaryFrame c(l lVar, int i, String str) {
        byte[] bArr = new byte[i];
        lVar.a(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    private static int f(l lVar, int i) {
        byte[] bArr = lVar.f11422a;
        int d2 = lVar.d();
        while (true) {
            int i2 = d2 + 1;
            if (i2 >= i) {
                return i;
            }
            if ((bArr[d2] & 255) == 255 && bArr[i2] == 0) {
                System.arraycopy(bArr, d2 + 2, bArr, i2, (i - d2) - 2);
                i--;
            }
            d2 = i2;
        }
    }

    private static String a(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    private static int a(byte[] bArr, int i, int i2) {
        int b2 = b(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return b2;
        }
        while (b2 < bArr.length - 1) {
            if (b2 % 2 == 0 && bArr[b2 + 1] == 0) {
                return b2;
            }
            b2 = b(bArr, b2 + 1);
        }
        return bArr.length;
    }

    private static int b(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static byte[] b(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return new byte[0];
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    private static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f10882a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f10883b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f10884c;

        public b(int i, boolean z, int i2) {
            this.f10882a = i;
            this.f10883b = z;
            this.f10884c = i2;
        }
    }
}
