package com.google.android.exoplayer2.e.e;

import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.e.e.h;
import com.google.android.exoplayer2.e.e.k;
import java.io.IOException;
import java.util.ArrayList;

final class j extends h {

    /* renamed from: a  reason: collision with root package name */
    private a f9556a;

    /* renamed from: b  reason: collision with root package name */
    private int f9557b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9558c;

    /* renamed from: d  reason: collision with root package name */
    private k.d f9559d;

    /* renamed from: e  reason: collision with root package name */
    private k.b f9560e;

    static int a(byte b2, int i, int i2) {
        return (b2 >> i2) & (255 >>> (8 - i));
    }

    j() {
    }

    public static boolean a(com.google.android.exoplayer2.n.k kVar) {
        try {
            return k.a(1, kVar, true);
        } catch (ak unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.f9556a = null;
            this.f9559d = null;
            this.f9560e = null;
        }
        this.f9557b = 0;
        this.f9558c = false;
    }

    /* access modifiers changed from: protected */
    public void c(long j) {
        super.c(j);
        int i = 0;
        this.f9558c = j != 0;
        k.d dVar = this.f9559d;
        if (dVar != null) {
            i = dVar.f9584g;
        }
        this.f9557b = i;
    }

    /* access modifiers changed from: protected */
    public long b(com.google.android.exoplayer2.n.k kVar) {
        int i = 0;
        if ((kVar.f10948a[0] & 1) == 1) {
            return -1;
        }
        int a2 = a(kVar.f10948a[0], this.f9556a);
        if (this.f9558c) {
            i = (this.f9557b + a2) / 4;
        }
        long j = (long) i;
        a(kVar, j);
        this.f9558c = true;
        this.f9557b = a2;
        return j;
    }

    /* access modifiers changed from: protected */
    public boolean a(com.google.android.exoplayer2.n.k kVar, long j, h.a aVar) throws IOException, InterruptedException {
        if (this.f9556a != null) {
            return false;
        }
        this.f9556a = c(kVar);
        if (this.f9556a == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f9556a.f9561a.j);
        arrayList.add(this.f9556a.f9563c);
        aVar.f9550a = com.google.android.exoplayer2.j.a((String) null, "audio/vorbis", (String) null, this.f9556a.f9561a.f9582e, -1, this.f9556a.f9561a.f9579b, (int) this.f9556a.f9561a.f9580c, arrayList, (com.google.android.exoplayer2.c.a) null, 0, (String) null);
        return true;
    }

    /* access modifiers changed from: package-private */
    public a c(com.google.android.exoplayer2.n.k kVar) throws IOException {
        if (this.f9559d == null) {
            this.f9559d = k.a(kVar);
            return null;
        } else if (this.f9560e == null) {
            this.f9560e = k.b(kVar);
            return null;
        } else {
            byte[] bArr = new byte[kVar.c()];
            System.arraycopy(kVar.f10948a, 0, bArr, 0, kVar.c());
            k.c[] a2 = k.a(kVar, this.f9559d.f9579b);
            return new a(this.f9559d, this.f9560e, bArr, a2, k.a(a2.length - 1));
        }
    }

    static void a(com.google.android.exoplayer2.n.k kVar, long j) {
        kVar.b(kVar.c() + 4);
        kVar.f10948a[kVar.c() - 4] = (byte) ((int) (j & 255));
        kVar.f10948a[kVar.c() - 3] = (byte) ((int) ((j >>> 8) & 255));
        kVar.f10948a[kVar.c() - 2] = (byte) ((int) ((j >>> 16) & 255));
        kVar.f10948a[kVar.c() - 1] = (byte) ((int) ((j >>> 24) & 255));
    }

    private static int a(byte b2, a aVar) {
        if (!aVar.f9564d[a(b2, aVar.f9565e, 1)].f9574a) {
            return aVar.f9561a.f9584g;
        }
        return aVar.f9561a.h;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final k.d f9561a;

        /* renamed from: b  reason: collision with root package name */
        public final k.b f9562b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f9563c;

        /* renamed from: d  reason: collision with root package name */
        public final k.c[] f9564d;

        /* renamed from: e  reason: collision with root package name */
        public final int f9565e;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i) {
            this.f9561a = dVar;
            this.f9562b = bVar;
            this.f9563c = bArr;
            this.f9564d = cVarArr;
            this.f9565e = i;
        }
    }
}
