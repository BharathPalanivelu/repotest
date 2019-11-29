package com.google.android.exoplayer2.p.a;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.google.android.exoplayer2.p.e;
import com.google.android.exoplayer2.p.g;
import com.google.android.exoplayer2.p.i;
import com.google.android.exoplayer2.p.j;
import com.google.android.exoplayer2.s.k;
import com.google.android.exoplayer2.s.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c extends d {

    /* renamed from: a  reason: collision with root package name */
    private final l f11043a = new l();

    /* renamed from: b  reason: collision with root package name */
    private final k f11044b = new k();

    /* renamed from: c  reason: collision with root package name */
    private final int f11045c;

    /* renamed from: d  reason: collision with root package name */
    private final a[] f11046d;

    /* renamed from: e  reason: collision with root package name */
    private a f11047e;

    /* renamed from: f  reason: collision with root package name */
    private List<com.google.android.exoplayer2.p.b> f11048f;

    /* renamed from: g  reason: collision with root package name */
    private List<com.google.android.exoplayer2.p.b> f11049g;
    private b h;
    private int i;

    public /* bridge */ /* synthetic */ void a(long j) {
        super.a(j);
    }

    public /* bridge */ /* synthetic */ void b(i iVar) throws g {
        super.a(iVar);
    }

    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    public /* bridge */ /* synthetic */ j g() throws g {
        return super.b();
    }

    public /* bridge */ /* synthetic */ i h() throws g {
        return super.a();
    }

    public c(int i2) {
        this.f11045c = i2 == -1 ? 1 : i2;
        this.f11046d = new a[8];
        for (int i3 = 0; i3 < 8; i3++) {
            this.f11046d[i3] = new a();
        }
        this.f11047e = this.f11046d[0];
        p();
    }

    public void c() {
        super.c();
        this.f11048f = null;
        this.f11049g = null;
        this.i = 0;
        this.f11047e = this.f11046d[this.i];
        p();
        this.h = null;
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return this.f11048f != this.f11049g;
    }

    /* access modifiers changed from: protected */
    public e f() {
        List<com.google.android.exoplayer2.p.b> list = this.f11048f;
        this.f11049g = list;
        return new f(list);
    }

    /* access modifiers changed from: protected */
    public void a(i iVar) {
        this.f11043a.a(iVar.f9881b.array(), iVar.f9881b.limit());
        while (this.f11043a.b() >= 3) {
            int g2 = this.f11043a.g() & 7;
            int i2 = g2 & 3;
            boolean z = false;
            boolean z2 = (g2 & 4) == 4;
            byte g3 = (byte) this.f11043a.g();
            byte g4 = (byte) this.f11043a.g();
            if ((i2 == 2 || i2 == 3) && z2) {
                if (i2 == 3) {
                    i();
                    int i3 = (g3 & 192) >> 6;
                    byte b2 = g3 & 63;
                    if (b2 == 0) {
                        b2 = 64;
                    }
                    this.h = new b(i3, b2);
                    byte[] bArr = this.h.f11059c;
                    b bVar = this.h;
                    int i4 = bVar.f11060d;
                    bVar.f11060d = i4 + 1;
                    bArr[i4] = g4;
                } else {
                    if (i2 == 2) {
                        z = true;
                    }
                    com.google.android.exoplayer2.s.a.a(z);
                    b bVar2 = this.h;
                    if (bVar2 == null) {
                        Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                    } else {
                        byte[] bArr2 = bVar2.f11059c;
                        b bVar3 = this.h;
                        int i5 = bVar3.f11060d;
                        bVar3.f11060d = i5 + 1;
                        bArr2[i5] = g3;
                        byte[] bArr3 = this.h.f11059c;
                        b bVar4 = this.h;
                        int i6 = bVar4.f11060d;
                        bVar4.f11060d = i6 + 1;
                        bArr3[i6] = g4;
                    }
                }
                if (this.h.f11060d == (this.h.f11058b * 2) - 1) {
                    i();
                }
            }
        }
    }

    private void i() {
        if (this.h != null) {
            j();
            this.h = null;
        }
    }

    private void j() {
        if (this.h.f11060d != (this.h.f11058b * 2) - 1) {
            Log.w("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.h.f11058b * 2) - 1) + ", but current index is " + this.h.f11060d + " (sequence number " + this.h.f11057a + "); ignoring packet");
            return;
        }
        this.f11044b.a(this.h.f11059c, this.h.f11060d);
        int c2 = this.f11044b.c(3);
        int c3 = this.f11044b.c(5);
        if (c2 == 7) {
            this.f11044b.b(2);
            c2 += this.f11044b.c(6);
        }
        if (c3 == 0) {
            if (c2 != 0) {
                Log.w("Cea708Decoder", "serviceNumber is non-zero (" + c2 + ") when blockSize is 0");
            }
        } else if (c2 == this.f11045c) {
            boolean z = false;
            while (this.f11044b.a() > 0) {
                int c4 = this.f11044b.c(8);
                if (c4 == 16) {
                    int c5 = this.f11044b.c(8);
                    if (c5 <= 31) {
                        c(c5);
                    } else if (c5 <= 127) {
                        g(c5);
                    } else if (c5 <= 159) {
                        d(c5);
                    } else if (c5 <= 255) {
                        h(c5);
                    } else {
                        Log.w("Cea708Decoder", "Invalid extended command: " + c5);
                    }
                } else if (c4 <= 31) {
                    a(c4);
                } else if (c4 <= 127) {
                    e(c4);
                } else if (c4 <= 159) {
                    b(c4);
                } else if (c4 <= 255) {
                    f(c4);
                } else {
                    Log.w("Cea708Decoder", "Invalid base command: " + c4);
                }
                z = true;
            }
            if (z) {
                this.f11048f = o();
            }
        }
    }

    private void a(int i2) {
        if (i2 == 0) {
            return;
        }
        if (i2 == 3) {
            this.f11048f = o();
        } else if (i2 != 8) {
            switch (i2) {
                case 12:
                    p();
                    return;
                case 13:
                    this.f11047e.a(10);
                    return;
                case 14:
                    return;
                default:
                    if (i2 >= 17 && i2 <= 23) {
                        Log.w("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i2);
                        this.f11044b.b(8);
                        return;
                    } else if (i2 < 24 || i2 > 31) {
                        Log.w("Cea708Decoder", "Invalid C0 command: " + i2);
                        return;
                    } else {
                        Log.w("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i2);
                        this.f11044b.b(16);
                        return;
                    }
            }
        } else {
            this.f11047e.f();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0093, code lost:
        if (r2 > 8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009b, code lost:
        if (r4.f11044b.e() == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009d, code lost:
        r4.f11046d[8 - r2].b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a6, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c5, code lost:
        if (r2 > 8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cd, code lost:
        if (r4.f11044b.e() == false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cf, code lost:
        r4.f11046d[8 - r2].a(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d9, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f3, code lost:
        if (r2 > 8) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fb, code lost:
        if (r4.f11044b.e() == false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fd, code lost:
        r4.f11046d[8 - r2].c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0106, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r5) {
        /*
            r4 = this;
            r0 = 16
            r1 = 8
            r2 = 1
            switch(r5) {
                case 128: goto L_0x0109;
                case 129: goto L_0x0109;
                case 130: goto L_0x0109;
                case 131: goto L_0x0109;
                case 132: goto L_0x0109;
                case 133: goto L_0x0109;
                case 134: goto L_0x0109;
                case 135: goto L_0x0109;
                case 136: goto L_0x00f3;
                case 137: goto L_0x00dc;
                case 138: goto L_0x00c5;
                case 139: goto L_0x00a9;
                case 140: goto L_0x0093;
                case 141: goto L_0x008c;
                case 142: goto L_0x0117;
                case 143: goto L_0x0087;
                case 144: goto L_0x0073;
                case 145: goto L_0x005d;
                case 146: goto L_0x0049;
                case 147: goto L_0x0008;
                case 148: goto L_0x0008;
                case 149: goto L_0x0008;
                case 150: goto L_0x0008;
                case 151: goto L_0x0033;
                case 152: goto L_0x0020;
                case 153: goto L_0x0020;
                case 154: goto L_0x0020;
                case 155: goto L_0x0020;
                case 156: goto L_0x0020;
                case 157: goto L_0x0020;
                case 158: goto L_0x0020;
                case 159: goto L_0x0020;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid C1 command: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "Cea708Decoder"
            android.util.Log.w(r0, r5)
            goto L_0x0117
        L_0x0020:
            int r5 = r5 + -152
            r4.i(r5)
            int r0 = r4.i
            if (r0 == r5) goto L_0x0117
            r4.i = r5
            com.google.android.exoplayer2.p.a.c$a[] r0 = r4.f11046d
            r5 = r0[r5]
            r4.f11047e = r5
            goto L_0x0117
        L_0x0033:
            com.google.android.exoplayer2.p.a.c$a r5 = r4.f11047e
            boolean r5 = r5.d()
            if (r5 != 0) goto L_0x0044
            com.google.android.exoplayer2.s.k r5 = r4.f11044b
            r0 = 32
            r5.b(r0)
            goto L_0x0117
        L_0x0044:
            r4.n()
            goto L_0x0117
        L_0x0049:
            com.google.android.exoplayer2.p.a.c$a r5 = r4.f11047e
            boolean r5 = r5.d()
            if (r5 != 0) goto L_0x0058
            com.google.android.exoplayer2.s.k r5 = r4.f11044b
            r5.b(r0)
            goto L_0x0117
        L_0x0058:
            r4.m()
            goto L_0x0117
        L_0x005d:
            com.google.android.exoplayer2.p.a.c$a r5 = r4.f11047e
            boolean r5 = r5.d()
            if (r5 != 0) goto L_0x006e
            com.google.android.exoplayer2.s.k r5 = r4.f11044b
            r0 = 24
            r5.b(r0)
            goto L_0x0117
        L_0x006e:
            r4.l()
            goto L_0x0117
        L_0x0073:
            com.google.android.exoplayer2.p.a.c$a r5 = r4.f11047e
            boolean r5 = r5.d()
            if (r5 != 0) goto L_0x0082
            com.google.android.exoplayer2.s.k r5 = r4.f11044b
            r5.b(r0)
            goto L_0x0117
        L_0x0082:
            r4.k()
            goto L_0x0117
        L_0x0087:
            r4.p()
            goto L_0x0117
        L_0x008c:
            com.google.android.exoplayer2.s.k r5 = r4.f11044b
            r5.b(r1)
            goto L_0x0117
        L_0x0093:
            if (r2 > r1) goto L_0x0117
            com.google.android.exoplayer2.s.k r5 = r4.f11044b
            boolean r5 = r5.e()
            if (r5 == 0) goto L_0x00a6
            com.google.android.exoplayer2.p.a.c$a[] r5 = r4.f11046d
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.b()
        L_0x00a6:
            int r2 = r2 + 1
            goto L_0x0093
        L_0x00a9:
            r5 = 1
        L_0x00aa:
            if (r5 > r1) goto L_0x0117
            com.google.android.exoplayer2.s.k r0 = r4.f11044b
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x00c2
            com.google.android.exoplayer2.p.a.c$a[] r0 = r4.f11046d
            int r3 = 8 - r5
            r0 = r0[r3]
            boolean r3 = r0.e()
            r3 = r3 ^ r2
            r0.a((boolean) r3)
        L_0x00c2:
            int r5 = r5 + 1
            goto L_0x00aa
        L_0x00c5:
            if (r2 > r1) goto L_0x0117
            com.google.android.exoplayer2.s.k r5 = r4.f11044b
            boolean r5 = r5.e()
            if (r5 == 0) goto L_0x00d9
            com.google.android.exoplayer2.p.a.c$a[] r5 = r4.f11046d
            int r0 = 8 - r2
            r5 = r5[r0]
            r0 = 0
            r5.a((boolean) r0)
        L_0x00d9:
            int r2 = r2 + 1
            goto L_0x00c5
        L_0x00dc:
            r5 = 1
        L_0x00dd:
            if (r5 > r1) goto L_0x0117
            com.google.android.exoplayer2.s.k r0 = r4.f11044b
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x00f0
            com.google.android.exoplayer2.p.a.c$a[] r0 = r4.f11046d
            int r3 = 8 - r5
            r0 = r0[r3]
            r0.a((boolean) r2)
        L_0x00f0:
            int r5 = r5 + 1
            goto L_0x00dd
        L_0x00f3:
            if (r2 > r1) goto L_0x0117
            com.google.android.exoplayer2.s.k r5 = r4.f11044b
            boolean r5 = r5.e()
            if (r5 == 0) goto L_0x0106
            com.google.android.exoplayer2.p.a.c$a[] r5 = r4.f11046d
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.c()
        L_0x0106:
            int r2 = r2 + 1
            goto L_0x00f3
        L_0x0109:
            int r5 = r5 + -128
            int r0 = r4.i
            if (r0 == r5) goto L_0x0117
            r4.i = r5
            com.google.android.exoplayer2.p.a.c$a[] r0 = r4.f11046d
            r5 = r0[r5]
            r4.f11047e = r5
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p.a.c.b(int):void");
    }

    private void c(int i2) {
        if (i2 > 7) {
            if (i2 <= 15) {
                this.f11044b.b(8);
            } else if (i2 <= 23) {
                this.f11044b.b(16);
            } else if (i2 <= 31) {
                this.f11044b.b(24);
            }
        }
    }

    private void d(int i2) {
        if (i2 <= 135) {
            this.f11044b.b(32);
        } else if (i2 <= 143) {
            this.f11044b.b(40);
        } else if (i2 <= 159) {
            this.f11044b.b(2);
            this.f11044b.b(this.f11044b.c(6) * 8);
        }
    }

    private void e(int i2) {
        if (i2 == 127) {
            this.f11047e.a(9835);
        } else {
            this.f11047e.a((char) (i2 & 255));
        }
    }

    private void f(int i2) {
        this.f11047e.a((char) (i2 & 255));
    }

    private void g(int i2) {
        if (i2 == 32) {
            this.f11047e.a(' ');
        } else if (i2 == 33) {
            this.f11047e.a(160);
        } else if (i2 == 37) {
            this.f11047e.a(8230);
        } else if (i2 == 42) {
            this.f11047e.a(352);
        } else if (i2 == 44) {
            this.f11047e.a(338);
        } else if (i2 == 63) {
            this.f11047e.a(376);
        } else if (i2 == 57) {
            this.f11047e.a(8482);
        } else if (i2 == 58) {
            this.f11047e.a(353);
        } else if (i2 == 60) {
            this.f11047e.a(339);
        } else if (i2 != 61) {
            switch (i2) {
                case 48:
                    this.f11047e.a(9608);
                    return;
                case 49:
                    this.f11047e.a(8216);
                    return;
                case 50:
                    this.f11047e.a(8217);
                    return;
                case 51:
                    this.f11047e.a(8220);
                    return;
                case 52:
                    this.f11047e.a(8221);
                    return;
                case 53:
                    this.f11047e.a(8226);
                    return;
                default:
                    switch (i2) {
                        case 118:
                            this.f11047e.a(8539);
                            return;
                        case 119:
                            this.f11047e.a(8540);
                            return;
                        case 120:
                            this.f11047e.a(8541);
                            return;
                        case 121:
                            this.f11047e.a(8542);
                            return;
                        case 122:
                            this.f11047e.a(9474);
                            return;
                        case 123:
                            this.f11047e.a(9488);
                            return;
                        case 124:
                            this.f11047e.a(9492);
                            return;
                        case 125:
                            this.f11047e.a(9472);
                            return;
                        case 126:
                            this.f11047e.a(9496);
                            return;
                        case 127:
                            this.f11047e.a(9484);
                            return;
                        default:
                            Log.w("Cea708Decoder", "Invalid G2 character: " + i2);
                            return;
                    }
            }
        } else {
            this.f11047e.a(8480);
        }
    }

    private void h(int i2) {
        if (i2 == 160) {
            this.f11047e.a(13252);
            return;
        }
        Log.w("Cea708Decoder", "Invalid G3 character: " + i2);
        this.f11047e.a('_');
    }

    private void k() {
        this.f11047e.a(this.f11044b.c(4), this.f11044b.c(2), this.f11044b.c(2), this.f11044b.e(), this.f11044b.e(), this.f11044b.c(3), this.f11044b.c(3));
    }

    private void l() {
        int a2 = a.a(this.f11044b.c(2), this.f11044b.c(2), this.f11044b.c(2), this.f11044b.c(2));
        int a3 = a.a(this.f11044b.c(2), this.f11044b.c(2), this.f11044b.c(2), this.f11044b.c(2));
        this.f11044b.b(2);
        this.f11047e.a(a2, a3, a.b(this.f11044b.c(2), this.f11044b.c(2), this.f11044b.c(2)));
    }

    private void m() {
        this.f11044b.b(4);
        int c2 = this.f11044b.c(4);
        this.f11044b.b(2);
        this.f11047e.a(c2, this.f11044b.c(6));
    }

    private void n() {
        int a2 = a.a(this.f11044b.c(2), this.f11044b.c(2), this.f11044b.c(2), this.f11044b.c(2));
        int c2 = this.f11044b.c(2);
        int b2 = a.b(this.f11044b.c(2), this.f11044b.c(2), this.f11044b.c(2));
        if (this.f11044b.e()) {
            c2 |= 4;
        }
        boolean e2 = this.f11044b.e();
        int c3 = this.f11044b.c(2);
        int c4 = this.f11044b.c(2);
        int c5 = this.f11044b.c(2);
        this.f11044b.b(8);
        this.f11047e.a(a2, b2, e2, c2, c3, c4, c5);
    }

    private void i(int i2) {
        a aVar = this.f11046d[i2];
        this.f11044b.b(2);
        boolean e2 = this.f11044b.e();
        boolean e3 = this.f11044b.e();
        boolean e4 = this.f11044b.e();
        int c2 = this.f11044b.c(3);
        boolean e5 = this.f11044b.e();
        int c3 = this.f11044b.c(7);
        int c4 = this.f11044b.c(8);
        int c5 = this.f11044b.c(4);
        int c6 = this.f11044b.c(4);
        this.f11044b.b(2);
        int c7 = this.f11044b.c(6);
        this.f11044b.b(2);
        aVar.a(e2, e3, e4, c2, e5, c3, c4, c6, c7, c5, this.f11044b.c(3), this.f11044b.c(3));
    }

    private List<com.google.android.exoplayer2.p.b> o() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 8; i2++) {
            if (!this.f11046d[i2].a() && this.f11046d[i2].e()) {
                arrayList.add(this.f11046d[i2].h());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void p() {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f11046d[i2].b();
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f11057a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11058b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f11059c;

        /* renamed from: d  reason: collision with root package name */
        int f11060d = 0;

        public b(int i, int i2) {
            this.f11057a = i;
            this.f11058b = i2;
            this.f11059c = new byte[((i2 * 2) - 1)];
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f11050a = a(2, 2, 2, 0);

        /* renamed from: b  reason: collision with root package name */
        public static final int f11051b = a(0, 0, 0, 0);

        /* renamed from: c  reason: collision with root package name */
        public static final int f11052c = a(0, 0, 0, 3);

        /* renamed from: d  reason: collision with root package name */
        private static final int[] f11053d = {0, 0, 0, 0, 0, 2, 0};

        /* renamed from: e  reason: collision with root package name */
        private static final int[] f11054e = {0, 0, 0, 0, 0, 0, 2};

        /* renamed from: f  reason: collision with root package name */
        private static final int[] f11055f = {3, 3, 3, 3, 3, 3, 1};

        /* renamed from: g  reason: collision with root package name */
        private static final boolean[] f11056g = {false, false, false, true, true, true, false};
        private static final int[] h;
        private static final int[] i = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] j = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] k;
        private int A;
        private int B;
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;
        private final List<SpannableString> l = new LinkedList();
        private final SpannableStringBuilder m = new SpannableStringBuilder();
        private boolean n;
        private boolean o;
        private int p;
        private boolean q;
        private int r;
        private int s;
        private int t;
        private int u;
        private boolean v;
        private int w;
        private int x;
        private int y;
        private int z;

        static {
            int i2 = f11051b;
            int i3 = f11052c;
            h = new int[]{i2, i3, i2, i2, i3, i2, i2};
            k = new int[]{i2, i2, i2, i2, i2, i3, i3};
        }

        public a() {
            b();
        }

        public boolean a() {
            return !d() || (this.l.isEmpty() && this.m.length() == 0);
        }

        public void b() {
            c();
            this.n = false;
            this.o = false;
            this.p = 4;
            this.q = false;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = 15;
            this.v = true;
            this.w = 0;
            this.x = 0;
            this.y = 0;
            int i2 = f11051b;
            this.z = i2;
            this.D = f11050a;
            this.F = i2;
        }

        public void c() {
            this.l.clear();
            this.m.clear();
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.E = -1;
            this.G = 0;
        }

        public boolean d() {
            return this.n;
        }

        public void a(boolean z2) {
            this.o = z2;
        }

        public boolean e() {
            return this.o;
        }

        public void a(boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            boolean z6 = z3;
            int i10 = i8;
            int i11 = i9;
            this.n = true;
            this.o = z2;
            this.v = z6;
            this.p = i2;
            this.q = z5;
            this.r = i3;
            this.s = i4;
            this.t = i7;
            int i12 = i5 + 1;
            if (this.u != i12) {
                this.u = i12;
                while (true) {
                    if ((!z6 || this.l.size() < this.u) && this.l.size() < 15) {
                        break;
                    }
                    this.l.remove(0);
                }
            }
            if (!(i10 == 0 || this.x == i10)) {
                this.x = i10;
                int i13 = i10 - 1;
                a(h[i13], f11052c, f11056g[i13], 0, f11054e[i13], f11055f[i13], f11053d[i13]);
            }
            if (i11 != 0 && this.y != i11) {
                this.y = i11;
                int i14 = i11 - 1;
                a(0, 1, 1, false, false, j[i14], i[i14]);
                a(f11050a, k[i14], f11051b);
            }
        }

        public void a(int i2, int i3, boolean z2, int i4, int i5, int i6, int i7) {
            this.z = i2;
            this.w = i7;
        }

        public void a(int i2, int i3, int i4, boolean z2, boolean z3, int i5, int i6) {
            if (this.A != -1) {
                if (!z2) {
                    this.m.setSpan(new StyleSpan(2), this.A, this.m.length(), 33);
                    this.A = -1;
                }
            } else if (z2) {
                this.A = this.m.length();
            }
            if (this.B != -1) {
                if (!z3) {
                    this.m.setSpan(new UnderlineSpan(), this.B, this.m.length(), 33);
                    this.B = -1;
                }
            } else if (z3) {
                this.B = this.m.length();
            }
        }

        public void a(int i2, int i3, int i4) {
            if (this.C != -1) {
                int i5 = this.D;
                if (i5 != i2) {
                    this.m.setSpan(new ForegroundColorSpan(i5), this.C, this.m.length(), 33);
                }
            }
            if (i2 != f11050a) {
                this.C = this.m.length();
                this.D = i2;
            }
            if (this.E != -1) {
                int i6 = this.F;
                if (i6 != i3) {
                    this.m.setSpan(new BackgroundColorSpan(i6), this.E, this.m.length(), 33);
                }
            }
            if (i3 != f11051b) {
                this.E = this.m.length();
                this.F = i3;
            }
        }

        public void a(int i2, int i3) {
            if (this.G != i2) {
                a(10);
            }
            this.G = i2;
        }

        public void f() {
            int length = this.m.length();
            if (length > 0) {
                this.m.delete(length - 1, length);
            }
        }

        public void a(char c2) {
            if (c2 == 10) {
                this.l.add(g());
                this.m.clear();
                if (this.A != -1) {
                    this.A = 0;
                }
                if (this.B != -1) {
                    this.B = 0;
                }
                if (this.C != -1) {
                    this.C = 0;
                }
                if (this.E != -1) {
                    this.E = 0;
                }
                while (true) {
                    if ((this.v && this.l.size() >= this.u) || this.l.size() >= 15) {
                        this.l.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.m.append(c2);
            }
        }

        public SpannableString g() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.m);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.A != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.A, length, 33);
                }
                if (this.B != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.B, length, 33);
                }
                if (this.C != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.D), this.C, length, 33);
                }
                if (this.E != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.F), this.E, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00ad  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.p.a.b h() {
            /*
                r15 = this;
                boolean r0 = r15.a()
                if (r0 == 0) goto L_0x0008
                r0 = 0
                return r0
            L_0x0008:
                android.text.SpannableStringBuilder r2 = new android.text.SpannableStringBuilder
                r2.<init>()
                r0 = 0
                r1 = 0
            L_0x000f:
                java.util.List<android.text.SpannableString> r3 = r15.l
                int r3 = r3.size()
                if (r1 >= r3) goto L_0x002a
                java.util.List<android.text.SpannableString> r3 = r15.l
                java.lang.Object r3 = r3.get(r1)
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.append(r3)
                r3 = 10
                r2.append(r3)
                int r1 = r1 + 1
                goto L_0x000f
            L_0x002a:
                android.text.SpannableString r1 = r15.g()
                r2.append(r1)
                int r1 = r15.w
                r3 = 2
                r4 = 3
                r5 = 1
                if (r1 == 0) goto L_0x005e
                if (r1 == r5) goto L_0x005b
                if (r1 == r3) goto L_0x0058
                if (r1 != r4) goto L_0x003f
                goto L_0x005e
            L_0x003f:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unexpected justification value: "
                r1.append(r2)
                int r2 = r15.w
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0058:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER
                goto L_0x0060
            L_0x005b:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE
                goto L_0x0060
            L_0x005e:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL
            L_0x0060:
                r6 = r1
                boolean r1 = r15.q
                if (r1 == 0) goto L_0x0070
                int r1 = r15.s
                float r1 = (float) r1
                r7 = 1120272384(0x42c60000, float:99.0)
                float r1 = r1 / r7
                int r8 = r15.r
                float r8 = (float) r8
                float r8 = r8 / r7
                goto L_0x007d
            L_0x0070:
                int r1 = r15.s
                float r1 = (float) r1
                r7 = 1129381888(0x43510000, float:209.0)
                float r1 = r1 / r7
                int r7 = r15.r
                float r7 = (float) r7
                r8 = 1116995584(0x42940000, float:74.0)
                float r8 = r7 / r8
            L_0x007d:
                r7 = 1063675494(0x3f666666, float:0.9)
                float r1 = r1 * r7
                r9 = 1028443341(0x3d4ccccd, float:0.05)
                float r10 = r1 + r9
                float r8 = r8 * r7
                float r7 = r8 + r9
                int r1 = r15.t
                int r8 = r1 % 3
                if (r8 != 0) goto L_0x0093
                r8 = 0
                goto L_0x0099
            L_0x0093:
                int r1 = r1 % r4
                if (r1 != r5) goto L_0x0098
                r8 = 1
                goto L_0x0099
            L_0x0098:
                r8 = 2
            L_0x0099:
                int r1 = r15.t
                int r9 = r1 / 3
                if (r9 != 0) goto L_0x00a1
                r9 = 0
                goto L_0x00a7
            L_0x00a1:
                int r1 = r1 / r4
                if (r1 != r5) goto L_0x00a6
                r9 = 1
                goto L_0x00a7
            L_0x00a6:
                r9 = 2
            L_0x00a7:
                int r1 = r15.z
                int r3 = f11051b
                if (r1 == r3) goto L_0x00ae
                r0 = 1
            L_0x00ae:
                com.google.android.exoplayer2.p.a.b r13 = new com.google.android.exoplayer2.p.a.b
                r5 = 0
                r11 = 1
                int r12 = r15.z
                int r14 = r15.p
                r1 = r13
                r3 = r6
                r4 = r7
                r6 = r8
                r7 = r10
                r8 = r9
                r9 = r11
                r10 = r0
                r11 = r12
                r12 = r14
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p.a.c.a.h():com.google.android.exoplayer2.p.a.b");
        }

        public static int b(int i2, int i3, int i4) {
            return a(i2, i3, i4, 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0030  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int a(int r4, int r5, int r6, int r7) {
            /*
                r0 = 4
                r1 = 0
                com.google.android.exoplayer2.s.a.a(r4, r1, r0)
                com.google.android.exoplayer2.s.a.a(r5, r1, r0)
                com.google.android.exoplayer2.s.a.a(r6, r1, r0)
                com.google.android.exoplayer2.s.a.a(r7, r1, r0)
                r0 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L_0x001b
                if (r7 == r0) goto L_0x001b
                r3 = 2
                if (r7 == r3) goto L_0x0020
                r3 = 3
                if (r7 == r3) goto L_0x001e
            L_0x001b:
                r7 = 255(0xff, float:3.57E-43)
                goto L_0x0022
            L_0x001e:
                r7 = 0
                goto L_0x0022
            L_0x0020:
                r7 = 127(0x7f, float:1.78E-43)
            L_0x0022:
                if (r4 <= r0) goto L_0x0027
                r4 = 255(0xff, float:3.57E-43)
                goto L_0x0028
            L_0x0027:
                r4 = 0
            L_0x0028:
                if (r5 <= r0) goto L_0x002d
                r5 = 255(0xff, float:3.57E-43)
                goto L_0x002e
            L_0x002d:
                r5 = 0
            L_0x002e:
                if (r6 <= r0) goto L_0x0032
                r1 = 255(0xff, float:3.57E-43)
            L_0x0032:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r1)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p.a.c.a.a(int, int, int, int):int");
        }
    }
}
