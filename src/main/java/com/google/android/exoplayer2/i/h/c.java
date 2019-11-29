package com.google.android.exoplayer2.i.h;

import android.util.Log;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.v;
import java.io.IOException;

final class c {
    public static b a(f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.s.a.a(fVar);
        l lVar = new l(16);
        if (a.a(fVar, lVar).f10403a != v.g("RIFF")) {
            return null;
        }
        fVar.c(lVar.f11422a, 0, 4);
        lVar.c(0);
        int n = lVar.n();
        if (n != v.g("WAVE")) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + n);
            return null;
        }
        a a2 = a.a(fVar, lVar);
        while (a2.f10403a != v.g("fmt ")) {
            fVar.c((int) a2.f10404b);
            a2 = a.a(fVar, lVar);
        }
        com.google.android.exoplayer2.s.a.b(a2.f10404b >= 16);
        fVar.c(lVar.f11422a, 0, 16);
        lVar.c(0);
        int i = lVar.i();
        int i2 = lVar.i();
        int u = lVar.u();
        int u2 = lVar.u();
        int i3 = lVar.i();
        int i4 = lVar.i();
        int i5 = (i2 * i4) / 8;
        if (i3 == i5) {
            int b2 = v.b(i4);
            if (b2 == 0) {
                Log.e("WavHeaderReader", "Unsupported WAV bit depth: " + i4);
                return null;
            } else if (i == 1 || i == 65534) {
                fVar.c(((int) a2.f10404b) - 16);
                return new b(i2, u, u2, i3, i4, b2);
            } else {
                Log.e("WavHeaderReader", "Unsupported WAV format type: " + i);
                return null;
            }
        } else {
            throw new p("Expected block alignment: " + i5 + "; got: " + i3);
        }
    }

    public static void a(f fVar, b bVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.s.a.a(fVar);
        com.google.android.exoplayer2.s.a.a(bVar);
        fVar.a();
        l lVar = new l(8);
        a a2 = a.a(fVar, lVar);
        while (a2.f10403a != v.g("data")) {
            Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + a2.f10403a);
            long j = a2.f10404b + 8;
            if (a2.f10403a == v.g("RIFF")) {
                j = 12;
            }
            if (j <= 2147483647L) {
                fVar.b((int) j);
                a2 = a.a(fVar, lVar);
            } else {
                throw new p("Chunk is too large (~2GB+) to skip; id: " + a2.f10403a);
            }
        }
        fVar.b(8);
        bVar.a(fVar.c(), a2.f10404b);
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f10403a;

        /* renamed from: b  reason: collision with root package name */
        public final long f10404b;

        private a(int i, long j) {
            this.f10403a = i;
            this.f10404b = j;
        }

        public static a a(f fVar, l lVar) throws IOException, InterruptedException {
            fVar.c(lVar.f11422a, 0, 8);
            lVar.c(0);
            return new a(lVar.n(), lVar.m());
        }
    }
}
