package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.s.l;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a implements com.google.android.exoplayer2.metadata.a {
    public Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.f9881b;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        l lVar = new l(array, limit);
        String x = lVar.x();
        String x2 = lVar.x();
        long l = lVar.l();
        lVar.d(4);
        return new Metadata(new EventMessage(x, x2, (lVar.l() * 1000) / l, lVar.l(), Arrays.copyOfRange(array, lVar.d(), limit)));
    }
}
