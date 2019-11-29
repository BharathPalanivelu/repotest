package com.google.android.exoplayer2.i.b;

import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.s.l;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.IOException;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private final l f10000a = new l(8);

    /* renamed from: b  reason: collision with root package name */
    private int f10001b;

    public boolean a(f fVar) throws IOException, InterruptedException {
        f fVar2 = fVar;
        long d2 = fVar.d();
        long j = IjkMediaMeta.AV_CH_SIDE_RIGHT;
        if (d2 != -1 && d2 <= IjkMediaMeta.AV_CH_SIDE_RIGHT) {
            j = d2;
        }
        int i = (int) j;
        fVar2.c(this.f10000a.f11422a, 0, 4);
        this.f10001b = 4;
        for (long l = this.f10000a.l(); l != 440786851; l = ((l << 8) & -256) | ((long) (this.f10000a.f11422a[0] & 255))) {
            int i2 = this.f10001b + 1;
            this.f10001b = i2;
            if (i2 == i) {
                return false;
            }
            fVar2.c(this.f10000a.f11422a, 0, 1);
        }
        long b2 = b(fVar);
        long j2 = (long) this.f10001b;
        if (b2 == Long.MIN_VALUE || (d2 != -1 && j2 + b2 >= d2)) {
            return false;
        }
        while (true) {
            int i3 = this.f10001b;
            long j3 = j2 + b2;
            if (((long) i3) < j3) {
                if (b(fVar) == Long.MIN_VALUE) {
                    return false;
                }
                long b3 = b(fVar);
                if (b3 < 0 || b3 > 2147483647L) {
                    return false;
                }
                if (b3 != 0) {
                    fVar2.c((int) b3);
                    this.f10001b = (int) (((long) this.f10001b) + b3);
                }
            } else if (((long) i3) == j3) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private long b(f fVar) throws IOException, InterruptedException {
        int i = 0;
        fVar.c(this.f10000a.f11422a, 0, 1);
        byte b2 = this.f10000a.f11422a[0] & 255;
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
        fVar.c(this.f10000a.f11422a, 1, i3);
        while (i < i3) {
            i++;
            i4 = (this.f10000a.f11422a[i] & 255) + (i4 << 8);
        }
        this.f10001b += i3 + 1;
        return (long) i4;
    }
}
