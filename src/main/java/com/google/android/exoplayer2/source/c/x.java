package com.google.android.exoplayer2.source.c;

import android.text.TextUtils;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.q;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class x implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11768a = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f11769b = Pattern.compile("MPEGTS:(\\d+)");

    /* renamed from: c  reason: collision with root package name */
    private final String f11770c;

    /* renamed from: d  reason: collision with root package name */
    private final q f11771d;

    /* renamed from: e  reason: collision with root package name */
    private final k f11772e = new k();

    /* renamed from: f  reason: collision with root package name */
    private h f11773f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f11774g = new byte[1024];
    private int h;

    public void c() {
    }

    public x(String str, q qVar) {
        this.f11770c = str;
        this.f11771d = qVar;
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        throw new IllegalStateException();
    }

    public void a(h hVar) {
        this.f11773f = hVar;
        hVar.a(new m.a(-9223372036854775807L));
    }

    public void a(long j, long j2) {
        throw new IllegalStateException();
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        int i;
        int d2 = (int) gVar.d();
        int i2 = this.h;
        byte[] bArr = this.f11774g;
        if (i2 == bArr.length) {
            if (d2 != -1) {
                i = d2;
            } else {
                i = bArr.length;
            }
            this.f11774g = Arrays.copyOf(bArr, (i * 3) / 2);
        }
        byte[] bArr2 = this.f11774g;
        int i3 = this.h;
        int a2 = gVar.a(bArr2, i3, bArr2.length - i3);
        if (a2 != -1) {
            this.h += a2;
            if (d2 == -1 || this.h != d2) {
                return 0;
            }
        }
        a();
        return -1;
    }

    private void a() throws ak {
        k kVar = new k(this.f11774g);
        try {
            com.google.android.exoplayer2.j.f.h.a(kVar);
            long j = 0;
            long j2 = 0;
            while (true) {
                String y = kVar.y();
                if (TextUtils.isEmpty(y)) {
                    Matcher b2 = com.google.android.exoplayer2.j.f.h.b(kVar);
                    if (b2 == null) {
                        a(0);
                        return;
                    }
                    long a2 = com.google.android.exoplayer2.j.f.h.a(b2.group(1));
                    long c2 = this.f11771d.c((j + a2) - j2);
                    n a3 = a(c2 - a2);
                    this.f11772e.a(this.f11774g, this.h);
                    a3.a(this.f11772e, this.h);
                    a3.a(c2, 1, this.h, 0, (byte[]) null);
                    return;
                } else if (y.startsWith("X-TIMESTAMP-MAP")) {
                    Matcher matcher = f11768a.matcher(y);
                    if (matcher.find()) {
                        Matcher matcher2 = f11769b.matcher(y);
                        if (matcher2.find()) {
                            j2 = com.google.android.exoplayer2.j.f.h.a(matcher.group(1));
                            j = q.d(Long.parseLong(matcher2.group(1)));
                        } else {
                            throw new ak("X-TIMESTAMP-MAP doesn't contain media timestamp: " + y);
                        }
                    } else {
                        throw new ak("X-TIMESTAMP-MAP doesn't contain local timestamp: " + y);
                    }
                }
            }
        } catch (com.google.android.exoplayer2.j.f e2) {
            throw new ak((Throwable) e2);
        }
    }

    private n a(long j) {
        n a2 = this.f11773f.a(0, 3);
        a2.a(j.a((String) null, "text/vtt", (String) null, -1, 0, this.f11770c, (a) null, j));
        this.f11773f.a();
        return a2;
    }
}
