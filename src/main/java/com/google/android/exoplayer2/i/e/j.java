package com.google.android.exoplayer2.i.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.e.h;
import com.google.android.exoplayer2.i.e.k;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.l;
import java.io.IOException;
import java.util.ArrayList;

final class j extends h {

    /* renamed from: a  reason: collision with root package name */
    private a f10190a;

    /* renamed from: b  reason: collision with root package name */
    private int f10191b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10192c;

    /* renamed from: d  reason: collision with root package name */
    private k.d f10193d;

    /* renamed from: e  reason: collision with root package name */
    private k.b f10194e;

    static int a(byte b2, int i, int i2) {
        return (b2 >> i2) & (255 >>> (8 - i));
    }

    j() {
    }

    public static boolean a(l lVar) {
        try {
            return k.a(1, lVar, true);
        } catch (p unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.f10190a = null;
            this.f10193d = null;
            this.f10194e = null;
        }
        this.f10191b = 0;
        this.f10192c = false;
    }

    /* access modifiers changed from: protected */
    public void c(long j) {
        super.c(j);
        int i = 0;
        this.f10192c = j != 0;
        k.d dVar = this.f10193d;
        if (dVar != null) {
            i = dVar.f10218g;
        }
        this.f10191b = i;
    }

    /* access modifiers changed from: protected */
    public long b(l lVar) {
        int i = 0;
        if ((lVar.f11422a[0] & 1) == 1) {
            return -1;
        }
        int a2 = a(lVar.f11422a[0], this.f10190a);
        if (this.f10192c) {
            i = (this.f10191b + a2) / 4;
        }
        long j = (long) i;
        a(lVar, j);
        this.f10192c = true;
        this.f10191b = a2;
        return j;
    }

    /* access modifiers changed from: protected */
    public boolean a(l lVar, long j, h.a aVar) throws IOException, InterruptedException {
        if (this.f10190a != null) {
            return false;
        }
        this.f10190a = c(lVar);
        if (this.f10190a == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10190a.f10195a.j);
        arrayList.add(this.f10190a.f10197c);
        aVar.f10184a = Format.a((String) null, "audio/vorbis", (String) null, this.f10190a.f10195a.f10216e, -1, this.f10190a.f10195a.f10213b, (int) this.f10190a.f10195a.f10214c, arrayList, (DrmInitData) null, 0, (String) null);
        return true;
    }

    /* access modifiers changed from: package-private */
    public a c(l lVar) throws IOException {
        if (this.f10193d == null) {
            this.f10193d = k.a(lVar);
            return null;
        } else if (this.f10194e == null) {
            this.f10194e = k.b(lVar);
            return null;
        } else {
            byte[] bArr = new byte[lVar.c()];
            System.arraycopy(lVar.f11422a, 0, bArr, 0, lVar.c());
            k.c[] a2 = k.a(lVar, this.f10193d.f10213b);
            return new a(this.f10193d, this.f10194e, bArr, a2, k.a(a2.length - 1));
        }
    }

    static void a(l lVar, long j) {
        lVar.b(lVar.c() + 4);
        lVar.f11422a[lVar.c() - 4] = (byte) ((int) (j & 255));
        lVar.f11422a[lVar.c() - 3] = (byte) ((int) ((j >>> 8) & 255));
        lVar.f11422a[lVar.c() - 2] = (byte) ((int) ((j >>> 16) & 255));
        lVar.f11422a[lVar.c() - 1] = (byte) ((int) ((j >>> 24) & 255));
    }

    private static int a(byte b2, a aVar) {
        if (!aVar.f10198d[a(b2, aVar.f10199e, 1)].f10208a) {
            return aVar.f10195a.f10218g;
        }
        return aVar.f10195a.h;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final k.d f10195a;

        /* renamed from: b  reason: collision with root package name */
        public final k.b f10196b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f10197c;

        /* renamed from: d  reason: collision with root package name */
        public final k.c[] f10198d;

        /* renamed from: e  reason: collision with root package name */
        public final int f10199e;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i) {
            this.f10195a = dVar;
            this.f10196b = bVar;
            this.f10197c = bArr;
            this.f10198d = cVarArr;
            this.f10199e = i;
        }
    }
}
