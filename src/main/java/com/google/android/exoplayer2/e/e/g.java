package com.google.android.exoplayer2.e.e;

import com.garena.android.gpns.utility.CONSTANT;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.e.e.h;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class g extends h {

    /* renamed from: a  reason: collision with root package name */
    private static final int f9540a = t.g("Opus");

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f9541b = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: c  reason: collision with root package name */
    private boolean f9542c;

    g() {
    }

    public static boolean a(k kVar) {
        int b2 = kVar.b();
        byte[] bArr = f9541b;
        if (b2 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        kVar.a(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, f9541b);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.f9542c = false;
        }
    }

    /* access modifiers changed from: protected */
    public long b(k kVar) {
        return b(a(kVar.f10948a));
    }

    /* access modifiers changed from: protected */
    public boolean a(k kVar, long j, h.a aVar) throws IOException, InterruptedException {
        boolean z = true;
        if (!this.f9542c) {
            byte[] copyOf = Arrays.copyOf(kVar.f10948a, kVar.c());
            byte b2 = copyOf[9] & 255;
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            a(arrayList, ((copyOf[11] & 255) << 8) | (copyOf[10] & 255));
            a(arrayList, 3840);
            aVar.f9550a = j.a((String) null, "audio/opus", (String) null, -1, -1, b2, 48000, arrayList, (a) null, 0, (String) null);
            this.f9542c = true;
            return true;
        }
        if (kVar.n() != f9540a) {
            z = false;
        }
        kVar.c(0);
        return z;
    }

    private void a(List<byte[]> list, int i) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i) * 1000000000) / 48000).array());
    }

    private long a(byte[] bArr) {
        byte b2 = bArr[0] & 255;
        byte b3 = b2 & 3;
        byte b4 = 2;
        if (b3 == 0) {
            b4 = 1;
        } else if (!(b3 == 1 || b3 == 2)) {
            b4 = bArr[1] & 63;
        }
        int i = b2 >> 3;
        int i2 = i & 3;
        return (long) (b4 * (i >= 16 ? 2500 << i2 : i >= 12 ? 10000 << (i2 & 1) : i2 == 3 ? CONSTANT.TIME.MIN_1 : 10000 << i2));
    }
}
