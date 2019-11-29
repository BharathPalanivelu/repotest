package com.google.android.exoplayer2.i.e;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.e.h;
import com.google.android.exoplayer2.s.f;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.v;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

final class b extends h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public f f10151a;

    /* renamed from: b  reason: collision with root package name */
    private a f10152b;

    b() {
    }

    public static boolean a(l lVar) {
        return lVar.b() >= 5 && lVar.g() == 127 && lVar.l() == 1179402563;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.f10151a = null;
            this.f10152b = null;
        }
    }

    private static boolean a(byte[] bArr) {
        return bArr[0] == -1;
    }

    /* access modifiers changed from: protected */
    public long b(l lVar) {
        if (!a(lVar.f11422a)) {
            return -1;
        }
        return (long) c(lVar);
    }

    /* access modifiers changed from: protected */
    public boolean a(l lVar, long j, h.a aVar) throws IOException, InterruptedException {
        byte[] bArr = lVar.f11422a;
        if (this.f10151a == null) {
            this.f10151a = new f(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, lVar.c());
            copyOfRange[4] = Byte.MIN_VALUE;
            aVar.f10184a = Format.a((String) null, "audio/flac", (String) null, -1, this.f10151a.a(), this.f10151a.f11400f, this.f10151a.f11399e, Collections.singletonList(copyOfRange), (DrmInitData) null, 0, (String) null);
            return true;
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            this.f10152b = new a();
            this.f10152b.a(lVar);
            return true;
        } else if (!a(bArr)) {
            return true;
        } else {
            a aVar2 = this.f10152b;
            if (aVar2 != null) {
                aVar2.c(j);
                aVar.f10185b = this.f10152b;
            }
            return false;
        }
    }

    private int c(l lVar) {
        int i;
        int i2;
        int i3 = (lVar.f11422a[2] & 255) >> 4;
        switch (i3) {
            case 1:
                return JfifUtil.MARKER_SOFn;
            case 2:
            case 3:
            case 4:
            case 5:
                i = 576;
                i2 = i3 - 2;
                break;
            case 6:
            case 7:
                lVar.d(4);
                lVar.z();
                int g2 = i3 == 6 ? lVar.g() : lVar.h();
                lVar.c(0);
                return g2 + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i = 256;
                i2 = i3 - 8;
                break;
            default:
                return -1;
        }
        return i << i2;
    }

    private class a implements f, com.google.android.exoplayer2.i.l {

        /* renamed from: b  reason: collision with root package name */
        private long[] f10154b;

        /* renamed from: c  reason: collision with root package name */
        private long[] f10155c;

        /* renamed from: d  reason: collision with root package name */
        private long f10156d = -1;

        /* renamed from: e  reason: collision with root package name */
        private long f10157e = -1;

        public boolean a() {
            return true;
        }

        public com.google.android.exoplayer2.i.l c() {
            return this;
        }

        public a() {
        }

        public void c(long j) {
            this.f10156d = j;
        }

        public void a(l lVar) {
            lVar.d(1);
            int k = lVar.k() / 18;
            this.f10154b = new long[k];
            this.f10155c = new long[k];
            for (int i = 0; i < k; i++) {
                this.f10154b[i] = lVar.p();
                this.f10155c[i] = lVar.p();
                lVar.d(2);
            }
        }

        public long a(com.google.android.exoplayer2.i.f fVar) throws IOException, InterruptedException {
            long j = this.f10157e;
            if (j < 0) {
                return -1;
            }
            long j2 = -(j + 2);
            this.f10157e = -1;
            return j2;
        }

        public long a(long j) {
            long b2 = b.this.b(j);
            this.f10157e = this.f10154b[v.a(this.f10154b, b2, true, true)];
            return b2;
        }

        public long b(long j) {
            return this.f10156d + this.f10155c[v.a(this.f10154b, b.this.b(j), true, true)];
        }

        public long b() {
            return b.this.f10151a.b();
        }
    }
}
