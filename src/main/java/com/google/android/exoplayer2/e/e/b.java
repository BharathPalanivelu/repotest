package com.google.android.exoplayer2.e.e;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.e.e.h;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.e;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

final class b extends h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public e f9519a;

    /* renamed from: b  reason: collision with root package name */
    private a f9520b;

    b() {
    }

    public static boolean a(k kVar) {
        return kVar.b() >= 5 && kVar.g() == 127 && kVar.l() == 1179402563;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.f9519a = null;
            this.f9520b = null;
        }
    }

    private static boolean a(byte[] bArr) {
        return bArr[0] == -1;
    }

    /* access modifiers changed from: protected */
    public long b(k kVar) {
        if (!a(kVar.f10948a)) {
            return -1;
        }
        return (long) c(kVar);
    }

    /* access modifiers changed from: protected */
    public boolean a(k kVar, long j, h.a aVar) throws IOException, InterruptedException {
        byte[] bArr = kVar.f10948a;
        if (this.f9519a == null) {
            this.f9519a = new e(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, kVar.c());
            copyOfRange[4] = Byte.MIN_VALUE;
            aVar.f9550a = j.a((String) null, "audio/x-flac", (String) null, -1, this.f9519a.a(), this.f9519a.f10926f, this.f9519a.f10925e, Collections.singletonList(copyOfRange), (com.google.android.exoplayer2.c.a) null, 0, (String) null);
            return true;
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            this.f9520b = new a();
            this.f9520b.a(kVar);
            return true;
        } else if (!a(bArr)) {
            return true;
        } else {
            a aVar2 = this.f9520b;
            if (aVar2 != null) {
                aVar2.c(j);
                aVar.f9551b = this.f9520b;
            }
            return false;
        }
    }

    private int c(k kVar) {
        int i;
        int i2;
        int i3 = (kVar.f10948a[2] & 255) >> 4;
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
                kVar.d(4);
                kVar.z();
                int g2 = i3 == 6 ? kVar.g() : kVar.h();
                kVar.c(0);
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

    private class a implements f, m {

        /* renamed from: b  reason: collision with root package name */
        private long[] f9522b;

        /* renamed from: c  reason: collision with root package name */
        private long[] f9523c;

        /* renamed from: d  reason: collision with root package name */
        private long f9524d = -1;

        /* renamed from: e  reason: collision with root package name */
        private long f9525e = -1;

        public boolean a() {
            return true;
        }

        public m c() {
            return this;
        }

        public a() {
        }

        public void c(long j) {
            this.f9524d = j;
        }

        public void a(k kVar) {
            kVar.d(1);
            int k = kVar.k() / 18;
            this.f9522b = new long[k];
            this.f9523c = new long[k];
            for (int i = 0; i < k; i++) {
                this.f9522b[i] = kVar.p();
                this.f9523c[i] = kVar.p();
                kVar.d(2);
            }
        }

        public long a(g gVar) throws IOException, InterruptedException {
            long j = this.f9525e;
            if (j < 0) {
                return -1;
            }
            long j2 = -(j + 2);
            this.f9525e = -1;
            return j2;
        }

        public long a(long j) {
            long b2 = b.this.b(j);
            this.f9525e = this.f9522b[t.a(this.f9522b, b2, true, true)];
            return b2;
        }

        public long b(long j) {
            return this.f9524d + this.f9523c[t.a(this.f9522b, b.this.b(j), true, true)];
        }

        public long b() {
            return b.this.f9519a.b();
        }
    }
}
