package com.google.android.exoplayer2.e.h;

import android.util.Log;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import java.io.IOException;

final class c {
    public static b a(g gVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.n.a.a(gVar);
        k kVar = new k(16);
        if (a.a(gVar, kVar).f9766a != t.g("RIFF")) {
            return null;
        }
        gVar.c(kVar.f10948a, 0, 4);
        kVar.c(0);
        int n = kVar.n();
        if (n != t.g("WAVE")) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + n);
            return null;
        }
        a a2 = a.a(gVar, kVar);
        while (a2.f9766a != t.g("fmt ")) {
            gVar.c((int) a2.f9767b);
            a2 = a.a(gVar, kVar);
        }
        com.google.android.exoplayer2.n.a.b(a2.f9767b >= 16);
        gVar.c(kVar.f10948a, 0, 16);
        kVar.c(0);
        int i = kVar.i();
        int i2 = kVar.i();
        int u = kVar.u();
        int u2 = kVar.u();
        int i3 = kVar.i();
        int i4 = kVar.i();
        int i5 = (i2 * i4) / 8;
        if (i3 == i5) {
            int b2 = t.b(i4);
            if (b2 == 0) {
                Log.e("WavHeaderReader", "Unsupported WAV bit depth: " + i4);
                return null;
            } else if (i == 1 || i == 65534) {
                gVar.c(((int) a2.f9767b) - 16);
                return new b(i2, u, u2, i3, i4, b2);
            } else {
                Log.e("WavHeaderReader", "Unsupported WAV format type: " + i);
                return null;
            }
        } else {
            throw new ak("Expected block alignment: " + i5 + "; got: " + i3);
        }
    }

    public static void a(g gVar, b bVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.n.a.a(gVar);
        com.google.android.exoplayer2.n.a.a(bVar);
        gVar.a();
        k kVar = new k(8);
        a a2 = a.a(gVar, kVar);
        while (a2.f9766a != t.g("data")) {
            Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + a2.f9766a);
            long j = a2.f9767b + 8;
            if (a2.f9766a == t.g("RIFF")) {
                j = 12;
            }
            if (j <= 2147483647L) {
                gVar.b((int) j);
                a2 = a.a(gVar, kVar);
            } else {
                throw new ak("Chunk is too large (~2GB+) to skip; id: " + a2.f9766a);
            }
        }
        gVar.b(8);
        bVar.a(gVar.c(), a2.f9767b);
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f9766a;

        /* renamed from: b  reason: collision with root package name */
        public final long f9767b;

        private a(int i, long j) {
            this.f9766a = i;
            this.f9767b = j;
        }

        public static a a(g gVar, k kVar) throws IOException, InterruptedException {
            gVar.c(kVar.f10948a, 0, 8);
            kVar.c(0);
            return new a(kVar.n(), kVar.m());
        }
    }
}
