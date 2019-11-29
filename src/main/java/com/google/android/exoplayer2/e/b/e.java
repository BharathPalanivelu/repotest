package com.google.android.exoplayer2.e.b;

import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.n.k;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.IOException;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private final k f9359a = new k(8);

    /* renamed from: b  reason: collision with root package name */
    private int f9360b;

    public boolean a(g gVar) throws IOException, InterruptedException {
        g gVar2 = gVar;
        long d2 = gVar.d();
        long j = IjkMediaMeta.AV_CH_SIDE_RIGHT;
        if (d2 != -1 && d2 <= IjkMediaMeta.AV_CH_SIDE_RIGHT) {
            j = d2;
        }
        int i = (int) j;
        gVar2.c(this.f9359a.f10948a, 0, 4);
        this.f9360b = 4;
        for (long l = this.f9359a.l(); l != 440786851; l = ((l << 8) & -256) | ((long) (this.f9359a.f10948a[0] & 255))) {
            int i2 = this.f9360b + 1;
            this.f9360b = i2;
            if (i2 == i) {
                return false;
            }
            gVar2.c(this.f9359a.f10948a, 0, 1);
        }
        long b2 = b(gVar);
        long j2 = (long) this.f9360b;
        if (b2 == Long.MIN_VALUE || (d2 != -1 && j2 + b2 >= d2)) {
            return false;
        }
        while (true) {
            int i3 = this.f9360b;
            long j3 = j2 + b2;
            if (((long) i3) < j3) {
                if (b(gVar) == Long.MIN_VALUE) {
                    return false;
                }
                long b3 = b(gVar);
                if (b3 < 0 || b3 > 2147483647L) {
                    return false;
                }
                if (b3 != 0) {
                    gVar2.c((int) b3);
                    this.f9360b = (int) (((long) this.f9360b) + b3);
                }
            } else if (((long) i3) == j3) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private long b(g gVar) throws IOException, InterruptedException {
        int i = 0;
        gVar.c(this.f9359a.f10948a, 0, 1);
        byte b2 = this.f9359a.f10948a[0] & 255;
        if (b2 == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((b2 & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b2 & (i2 ^ -1);
        gVar.c(this.f9359a.f10948a, 1, i3);
        while (i < i3) {
            i++;
            i4 = (this.f9359a.f10948a[i] & 255) + (i4 << 8);
        }
        this.f9360b += i3 + 1;
        return (long) i4;
    }
}
