package com.google.android.exoplayer2.source.c;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.p.g.h;
import com.google.android.exoplayer2.s.s;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class l implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11719a = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f11720b = Pattern.compile("MPEGTS:(\\d+)");

    /* renamed from: c  reason: collision with root package name */
    private final String f11721c;

    /* renamed from: d  reason: collision with root package name */
    private final s f11722d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.s.l f11723e = new com.google.android.exoplayer2.s.l();

    /* renamed from: f  reason: collision with root package name */
    private g f11724f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f11725g = new byte[1024];
    private int h;

    public void c() {
    }

    public l(String str, s sVar) {
        this.f11721c = str;
        this.f11722d = sVar;
    }

    public boolean a(f fVar) throws IOException, InterruptedException {
        throw new IllegalStateException();
    }

    public void a(g gVar) {
        this.f11724f = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    public void a(long j, long j2) {
        throw new IllegalStateException();
    }

    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        int i;
        int d2 = (int) fVar.d();
        int i2 = this.h;
        byte[] bArr = this.f11725g;
        if (i2 == bArr.length) {
            if (d2 != -1) {
                i = d2;
            } else {
                i = bArr.length;
            }
            this.f11725g = Arrays.copyOf(bArr, (i * 3) / 2);
        }
        byte[] bArr2 = this.f11725g;
        int i3 = this.h;
        int a2 = fVar.a(bArr2, i3, bArr2.length - i3);
        if (a2 != -1) {
            this.h += a2;
            if (d2 == -1 || this.h != d2) {
                return 0;
            }
        }
        a();
        return -1;
    }

    private void a() throws p {
        com.google.android.exoplayer2.s.l lVar = new com.google.android.exoplayer2.s.l(this.f11725g);
        try {
            h.a(lVar);
            long j = 0;
            long j2 = 0;
            while (true) {
                String y = lVar.y();
                if (TextUtils.isEmpty(y)) {
                    Matcher b2 = h.b(lVar);
                    if (b2 == null) {
                        a(0);
                        return;
                    }
                    long a2 = h.a(b2.group(1));
                    long c2 = this.f11722d.c((j + a2) - j2);
                    m a3 = a(c2 - a2);
                    this.f11723e.a(this.f11725g, this.h);
                    a3.a(this.f11723e, this.h);
                    a3.a(c2, 1, this.h, 0, (m.a) null);
                    return;
                } else if (y.startsWith("X-TIMESTAMP-MAP")) {
                    Matcher matcher = f11719a.matcher(y);
                    if (matcher.find()) {
                        Matcher matcher2 = f11720b.matcher(y);
                        if (matcher2.find()) {
                            j2 = h.a(matcher.group(1));
                            j = s.d(Long.parseLong(matcher2.group(1)));
                        } else {
                            throw new p("X-TIMESTAMP-MAP doesn't contain media timestamp: " + y);
                        }
                    } else {
                        throw new p("X-TIMESTAMP-MAP doesn't contain local timestamp: " + y);
                    }
                }
            }
        } catch (com.google.android.exoplayer2.p.g e2) {
            throw new p((Throwable) e2);
        }
    }

    private m a(long j) {
        m a2 = this.f11724f.a(0, 3);
        a2.a(Format.a((String) null, "text/vtt", (String) null, -1, 0, this.f11721c, (DrmInitData) null, j));
        this.f11724f.a();
        return a2;
    }
}
