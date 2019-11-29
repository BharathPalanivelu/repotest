package com.google.android.exoplayer2.e;

import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import java.io.EOFException;
import java.io.IOException;

public final class e implements n {
    public void a(long j, int i, int i2, int i3, byte[] bArr) {
    }

    public void a(j jVar) {
    }

    public int a(g gVar, int i, boolean z) throws IOException, InterruptedException {
        int a2 = gVar.a(i);
        if (a2 != -1) {
            return a2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public void a(k kVar, int i) {
        kVar.d(i);
    }
}
