package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.e;
import com.google.android.exoplayer2.n.k;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class b implements com.google.android.exoplayer2.f.b {
    public a a(e eVar) {
        ByteBuffer byteBuffer = eVar.f9280b;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        k kVar = new k(array, limit);
        String x = kVar.x();
        String x2 = kVar.x();
        long l = kVar.l();
        kVar.d(4);
        return new a(new a(x, x2, (kVar.l() * 1000) / l, kVar.l(), Arrays.copyOfRange(array, kVar.d(), limit)));
    }
}
