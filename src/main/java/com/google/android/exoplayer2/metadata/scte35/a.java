package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.b;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.s.k;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.s;
import java.nio.ByteBuffer;

public final class a implements com.google.android.exoplayer2.metadata.a {

    /* renamed from: a  reason: collision with root package name */
    private final l f10910a = new l();

    /* renamed from: b  reason: collision with root package name */
    private final k f10911b = new k();

    /* renamed from: c  reason: collision with root package name */
    private s f10912c;

    public Metadata a(d dVar) throws b {
        if (this.f10912c == null || dVar.f10836d != this.f10912c.c()) {
            this.f10912c = new s(dVar.f9882c);
            this.f10912c.c(dVar.f9882c - dVar.f10836d);
        }
        ByteBuffer byteBuffer = dVar.f9881b;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f10910a.a(array, limit);
        this.f10911b.a(array, limit);
        this.f10911b.b(39);
        long c2 = (((long) this.f10911b.c(1)) << 32) | ((long) this.f10911b.c(32));
        this.f10911b.b(20);
        int c3 = this.f10911b.c(12);
        int c4 = this.f10911b.c(8);
        Metadata.Entry entry = null;
        this.f10910a.d(14);
        if (c4 == 0) {
            entry = new SpliceNullCommand();
        } else if (c4 == 255) {
            entry = PrivateCommand.a(this.f10910a, c3, c2);
        } else if (c4 == 4) {
            entry = SpliceScheduleCommand.a(this.f10910a);
        } else if (c4 == 5) {
            entry = SpliceInsertCommand.a(this.f10910a, c2, this.f10912c);
        } else if (c4 == 6) {
            entry = TimeSignalCommand.a(this.f10910a, c2, this.f10912c);
        }
        if (entry == null) {
            return new Metadata(new Metadata.Entry[0]);
        }
        return new Metadata(entry);
    }
}
