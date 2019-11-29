package com.google.android.exoplayer2.i;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.l;
import java.io.EOFException;
import java.io.IOException;

public final class d implements m {
    public void a(long j, int i, int i2, int i3, m.a aVar) {
    }

    public void a(Format format) {
    }

    public int a(f fVar, int i, boolean z) throws IOException, InterruptedException {
        int a2 = fVar.a(i);
        if (a2 != -1) {
            return a2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public void a(l lVar, int i) {
        lVar.d(i);
    }
}
