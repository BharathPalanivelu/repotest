package com.google.android.exoplayer2.f.c;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.e;
import com.google.android.exoplayer2.n.j;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.q;
import java.nio.ByteBuffer;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final k f9829a = new k();

    /* renamed from: b  reason: collision with root package name */
    private final j f9830b = new j();

    /* renamed from: c  reason: collision with root package name */
    private q f9831c;

    public a a(e eVar) throws com.google.android.exoplayer2.f.c {
        if (this.f9831c == null || eVar.f9855d != this.f9831c.c()) {
            this.f9831c = new q(eVar.f9281c);
            this.f9831c.c(eVar.f9281c - eVar.f9855d);
        }
        ByteBuffer byteBuffer = eVar.f9280b;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f9829a.a(array, limit);
        this.f9830b.a(array, limit);
        this.f9830b.b(39);
        long c2 = (((long) this.f9830b.c(1)) << 32) | ((long) this.f9830b.c(32));
        this.f9830b.b(20);
        int c3 = this.f9830b.c(12);
        int c4 = this.f9830b.c(8);
        a.C0166a aVar = null;
        this.f9829a.d(14);
        if (c4 == 0) {
            aVar = new e();
        } else if (c4 == 255) {
            aVar = a.a(this.f9829a, c3, c2);
        } else if (c4 == 4) {
            aVar = f.a(this.f9829a);
        } else if (c4 == 5) {
            aVar = d.a(this.f9829a, c2, this.f9831c);
        } else if (c4 == 6) {
            aVar = g.a(this.f9829a, c2, this.f9831c);
        }
        if (aVar == null) {
            return new a(new a.C0166a[0]);
        }
        return new a(aVar);
    }
}
