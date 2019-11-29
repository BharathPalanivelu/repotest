package com.google.android.exoplayer2.e.g;

import android.util.SparseArray;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.n.i;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class j implements h {

    /* renamed from: a  reason: collision with root package name */
    private final s f9644a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9645b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9646c;

    /* renamed from: d  reason: collision with root package name */
    private final n f9647d = new n(7, 128);

    /* renamed from: e  reason: collision with root package name */
    private final n f9648e = new n(8, 128);

    /* renamed from: f  reason: collision with root package name */
    private final n f9649f = new n(6, 128);

    /* renamed from: g  reason: collision with root package name */
    private long f9650g;
    private final boolean[] h = new boolean[3];
    private String i;
    private n j;
    private a k;
    private boolean l;
    private long m;
    private final k n = new k();

    public void b() {
    }

    public j(s sVar, boolean z, boolean z2) {
        this.f9644a = sVar;
        this.f9645b = z;
        this.f9646c = z2;
    }

    public void a() {
        i.a(this.h);
        this.f9647d.a();
        this.f9648e.a();
        this.f9649f.a();
        this.k.b();
        this.f9650g = 0;
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.i = dVar.c();
        this.j = hVar.a(dVar.b(), 2);
        this.k = new a(this.j, this.f9645b, this.f9646c);
        this.f9644a.a(hVar, dVar);
    }

    public void a(long j2, boolean z) {
        this.m = j2;
    }

    public void a(k kVar) {
        int d2 = kVar.d();
        int c2 = kVar.c();
        byte[] bArr = kVar.f10948a;
        this.f9650g += (long) kVar.b();
        this.j.a(kVar, kVar.b());
        while (true) {
            int a2 = i.a(bArr, d2, c2, this.h);
            if (a2 == c2) {
                a(bArr, d2, c2);
                return;
            }
            int b2 = i.b(bArr, a2);
            int i2 = a2 - d2;
            if (i2 > 0) {
                a(bArr, d2, a2);
            }
            int i3 = c2 - a2;
            long j2 = this.f9650g - ((long) i3);
            a(j2, i3, i2 < 0 ? -i2 : 0, this.m);
            a(j2, b2, this.m);
            d2 = a2 + 3;
        }
    }

    private void a(long j2, int i2, long j3) {
        if (!this.l || this.k.a()) {
            this.f9647d.a(i2);
            this.f9648e.a(i2);
        }
        this.f9649f.a(i2);
        this.k.a(j2, i2, j3);
    }

    private void a(byte[] bArr, int i2, int i3) {
        if (!this.l || this.k.a()) {
            this.f9647d.a(bArr, i2, i3);
            this.f9648e.a(bArr, i2, i3);
        }
        this.f9649f.a(bArr, i2, i3);
        this.k.a(bArr, i2, i3);
    }

    private void a(long j2, int i2, int i3, long j3) {
        int i4 = i3;
        if (!this.l || this.k.a()) {
            this.f9647d.b(i4);
            this.f9648e.b(i4);
            if (!this.l) {
                if (this.f9647d.b() && this.f9648e.b()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.f9647d.f9692a, this.f9647d.f9693b));
                    arrayList.add(Arrays.copyOf(this.f9648e.f9692a, this.f9648e.f9693b));
                    i.b a2 = i.a(this.f9647d.f9692a, 3, this.f9647d.f9693b);
                    i.a b2 = i.b(this.f9648e.f9692a, 3, this.f9648e.f9693b);
                    this.j.a(com.google.android.exoplayer2.j.a(this.i, "video/avc", (String) null, -1, -1, a2.f10938b, a2.f10939c, -1.0f, (List<byte[]>) arrayList, -1, a2.f10940d, (com.google.android.exoplayer2.c.a) null));
                    this.l = true;
                    this.k.a(a2);
                    this.k.a(b2);
                    this.f9647d.a();
                    this.f9648e.a();
                }
            } else if (this.f9647d.b()) {
                this.k.a(i.a(this.f9647d.f9692a, 3, this.f9647d.f9693b));
                this.f9647d.a();
            } else if (this.f9648e.b()) {
                this.k.a(i.b(this.f9648e.f9692a, 3, this.f9648e.f9693b));
                this.f9648e.a();
            }
        }
        if (this.f9649f.b(i3)) {
            this.n.a(this.f9649f.f9692a, i.a(this.f9649f.f9692a, this.f9649f.f9693b));
            this.n.c(4);
            this.f9644a.a(j3, this.n);
        }
        this.k.a(j2, i2);
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f9651a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f9652b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f9653c;

        /* renamed from: d  reason: collision with root package name */
        private final SparseArray<i.b> f9654d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        private final SparseArray<i.a> f9655e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        private final l f9656f = new l(this.f9657g, 0, 0);

        /* renamed from: g  reason: collision with root package name */
        private byte[] f9657g = new byte[128];
        private int h;
        private int i;
        private long j;
        private boolean k;
        private long l;
        private C0165a m = new C0165a();
        private C0165a n = new C0165a();
        private boolean o;
        private long p;
        private long q;
        private boolean r;

        public a(n nVar, boolean z, boolean z2) {
            this.f9651a = nVar;
            this.f9652b = z;
            this.f9653c = z2;
            b();
        }

        public boolean a() {
            return this.f9653c;
        }

        public void a(i.b bVar) {
            this.f9654d.append(bVar.f10937a, bVar);
        }

        public void a(i.a aVar) {
            this.f9655e.append(aVar.f10934a, aVar);
        }

        public void b() {
            this.k = false;
            this.o = false;
            this.n.a();
        }

        public void a(long j2, int i2, long j3) {
            this.i = i2;
            this.l = j3;
            this.j = j2;
            if (!this.f9652b || this.i != 1) {
                if (this.f9653c) {
                    int i3 = this.i;
                    if (!(i3 == 5 || i3 == 1 || i3 == 2)) {
                        return;
                    }
                } else {
                    return;
                }
            }
            C0165a aVar = this.m;
            this.m = this.n;
            this.n = aVar;
            this.n.a();
            this.h = 0;
            this.k = true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x0101  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0104  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0108  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x011a  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0120  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0150  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(byte[] r24, int r25, int r26) {
            /*
                r23 = this;
                r0 = r23
                r1 = r25
                boolean r2 = r0.k
                if (r2 != 0) goto L_0x0009
                return
            L_0x0009:
                int r2 = r26 - r1
                byte[] r3 = r0.f9657g
                int r4 = r3.length
                int r5 = r0.h
                int r6 = r5 + r2
                r7 = 2
                if (r4 >= r6) goto L_0x001e
                int r5 = r5 + r2
                int r5 = r5 * 2
                byte[] r3 = java.util.Arrays.copyOf(r3, r5)
                r0.f9657g = r3
            L_0x001e:
                byte[] r3 = r0.f9657g
                int r4 = r0.h
                r5 = r24
                java.lang.System.arraycopy(r5, r1, r3, r4, r2)
                int r1 = r0.h
                int r1 = r1 + r2
                r0.h = r1
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                byte[] r2 = r0.f9657g
                int r3 = r0.h
                r4 = 0
                r1.a(r2, r4, r3)
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                r2 = 8
                boolean r1 = r1.b(r2)
                if (r1 != 0) goto L_0x0041
                return
            L_0x0041:
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                r2 = 1
                r1.a(r2)
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                int r10 = r1.c(r7)
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                r3 = 5
                r1.a(r3)
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                boolean r1 = r1.b()
                if (r1 != 0) goto L_0x005c
                return
            L_0x005c:
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                r1.c()
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                boolean r1 = r1.b()
                if (r1 != 0) goto L_0x006a
                return
            L_0x006a:
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                int r11 = r1.c()
                boolean r1 = r0.f9653c
                if (r1 != 0) goto L_0x007c
                r0.k = r4
                com.google.android.exoplayer2.e.g.j$a$a r1 = r0.n
                r1.a((int) r11)
                return
            L_0x007c:
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                boolean r1 = r1.b()
                if (r1 != 0) goto L_0x0085
                return
            L_0x0085:
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                int r13 = r1.c()
                android.util.SparseArray<com.google.android.exoplayer2.n.i$a> r1 = r0.f9655e
                int r1 = r1.indexOfKey(r13)
                if (r1 >= 0) goto L_0x0096
                r0.k = r4
                return
            L_0x0096:
                android.util.SparseArray<com.google.android.exoplayer2.n.i$a> r1 = r0.f9655e
                java.lang.Object r1 = r1.get(r13)
                com.google.android.exoplayer2.n.i$a r1 = (com.google.android.exoplayer2.n.i.a) r1
                android.util.SparseArray<com.google.android.exoplayer2.n.i$b> r5 = r0.f9654d
                int r6 = r1.f10935b
                java.lang.Object r5 = r5.get(r6)
                r9 = r5
                com.google.android.exoplayer2.n.i$b r9 = (com.google.android.exoplayer2.n.i.b) r9
                boolean r5 = r9.f10941e
                if (r5 == 0) goto L_0x00bb
                com.google.android.exoplayer2.n.l r5 = r0.f9656f
                boolean r5 = r5.b(r7)
                if (r5 != 0) goto L_0x00b6
                return
            L_0x00b6:
                com.google.android.exoplayer2.n.l r5 = r0.f9656f
                r5.a(r7)
            L_0x00bb:
                com.google.android.exoplayer2.n.l r5 = r0.f9656f
                int r6 = r9.f10943g
                boolean r5 = r5.b(r6)
                if (r5 != 0) goto L_0x00c6
                return
            L_0x00c6:
                com.google.android.exoplayer2.n.l r5 = r0.f9656f
                int r6 = r9.f10943g
                int r12 = r5.c(r6)
                boolean r5 = r9.f10942f
                if (r5 != 0) goto L_0x00f9
                com.google.android.exoplayer2.n.l r5 = r0.f9656f
                boolean r5 = r5.b(r2)
                if (r5 != 0) goto L_0x00db
                return
            L_0x00db:
                com.google.android.exoplayer2.n.l r5 = r0.f9656f
                boolean r5 = r5.a()
                if (r5 == 0) goto L_0x00f7
                com.google.android.exoplayer2.n.l r6 = r0.f9656f
                boolean r6 = r6.b(r2)
                if (r6 != 0) goto L_0x00ec
                return
            L_0x00ec:
                com.google.android.exoplayer2.n.l r6 = r0.f9656f
                boolean r6 = r6.a()
                r14 = r5
                r16 = r6
                r15 = 1
                goto L_0x00fd
            L_0x00f7:
                r14 = r5
                goto L_0x00fa
            L_0x00f9:
                r14 = 0
            L_0x00fa:
                r15 = 0
                r16 = 0
            L_0x00fd:
                int r5 = r0.i
                if (r5 != r3) goto L_0x0104
                r17 = 1
                goto L_0x0106
            L_0x0104:
                r17 = 0
            L_0x0106:
                if (r17 == 0) goto L_0x011a
                com.google.android.exoplayer2.n.l r3 = r0.f9656f
                boolean r3 = r3.b()
                if (r3 != 0) goto L_0x0111
                return
            L_0x0111:
                com.google.android.exoplayer2.n.l r3 = r0.f9656f
                int r3 = r3.c()
                r18 = r3
                goto L_0x011c
            L_0x011a:
                r18 = 0
            L_0x011c:
                int r3 = r9.h
                if (r3 != 0) goto L_0x0150
                com.google.android.exoplayer2.n.l r2 = r0.f9656f
                int r3 = r9.i
                boolean r2 = r2.b(r3)
                if (r2 != 0) goto L_0x012b
                return
            L_0x012b:
                com.google.android.exoplayer2.n.l r2 = r0.f9656f
                int r3 = r9.i
                int r2 = r2.c(r3)
                boolean r1 = r1.f10936c
                if (r1 == 0) goto L_0x014d
                if (r14 != 0) goto L_0x014d
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                boolean r1 = r1.b()
                if (r1 != 0) goto L_0x0142
                return
            L_0x0142:
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                int r1 = r1.d()
                r20 = r1
                r19 = r2
                goto L_0x0190
            L_0x014d:
                r19 = r2
                goto L_0x018e
            L_0x0150:
                int r3 = r9.h
                if (r3 != r2) goto L_0x018c
                boolean r2 = r9.j
                if (r2 != 0) goto L_0x018c
                com.google.android.exoplayer2.n.l r2 = r0.f9656f
                boolean r2 = r2.b()
                if (r2 != 0) goto L_0x0161
                return
            L_0x0161:
                com.google.android.exoplayer2.n.l r2 = r0.f9656f
                int r2 = r2.d()
                boolean r1 = r1.f10936c
                if (r1 == 0) goto L_0x0185
                if (r14 != 0) goto L_0x0185
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                boolean r1 = r1.b()
                if (r1 != 0) goto L_0x0176
                return
            L_0x0176:
                com.google.android.exoplayer2.n.l r1 = r0.f9656f
                int r1 = r1.d()
                r22 = r1
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x0194
            L_0x0185:
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x0192
            L_0x018c:
                r19 = 0
            L_0x018e:
                r20 = 0
            L_0x0190:
                r21 = 0
            L_0x0192:
                r22 = 0
            L_0x0194:
                com.google.android.exoplayer2.e.g.j$a$a r8 = r0.n
                r8.a(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                r0.k = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.g.j.a.a(byte[], int, int):void");
        }

        public void a(long j2, int i2) {
            boolean z = false;
            if (this.i == 9 || (this.f9653c && this.n.a(this.m))) {
                if (this.o) {
                    a(i2 + ((int) (j2 - this.j)));
                }
                this.p = this.j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            boolean z2 = this.r;
            int i3 = this.i;
            if (i3 == 5 || (this.f9652b && i3 == 1 && this.n.b())) {
                z = true;
            }
            this.r = z2 | z;
        }

        private void a(int i2) {
            boolean z = this.r;
            int i3 = (int) (this.j - this.p);
            this.f9651a.a(this.q, z ? 1 : 0, i3, i2, (byte[]) null);
        }

        /* renamed from: com.google.android.exoplayer2.e.g.j$a$a  reason: collision with other inner class name */
        private static final class C0165a {

            /* renamed from: a  reason: collision with root package name */
            private boolean f9658a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f9659b;

            /* renamed from: c  reason: collision with root package name */
            private i.b f9660c;

            /* renamed from: d  reason: collision with root package name */
            private int f9661d;

            /* renamed from: e  reason: collision with root package name */
            private int f9662e;

            /* renamed from: f  reason: collision with root package name */
            private int f9663f;

            /* renamed from: g  reason: collision with root package name */
            private int f9664g;
            private boolean h;
            private boolean i;
            private boolean j;
            private boolean k;
            private int l;
            private int m;
            private int n;
            private int o;
            private int p;

            private C0165a() {
            }

            public void a() {
                this.f9659b = false;
                this.f9658a = false;
            }

            public void a(int i2) {
                this.f9662e = i2;
                this.f9659b = true;
            }

            public void a(i.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                this.f9660c = bVar;
                this.f9661d = i2;
                this.f9662e = i3;
                this.f9663f = i4;
                this.f9664g = i5;
                this.h = z;
                this.i = z2;
                this.j = z3;
                this.k = z4;
                this.l = i6;
                this.m = i7;
                this.n = i8;
                this.o = i9;
                this.p = i10;
                this.f9658a = true;
                this.f9659b = true;
            }

            public boolean b() {
                if (this.f9659b) {
                    int i2 = this.f9662e;
                    if (i2 == 7 || i2 == 2) {
                        return true;
                    }
                }
                return false;
            }

            /* access modifiers changed from: private */
            public boolean a(C0165a aVar) {
                if (this.f9658a) {
                    if (!aVar.f9658a || this.f9663f != aVar.f9663f || this.f9664g != aVar.f9664g || this.h != aVar.h) {
                        return true;
                    }
                    if (this.i && aVar.i && this.j != aVar.j) {
                        return true;
                    }
                    int i2 = this.f9661d;
                    int i3 = aVar.f9661d;
                    if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                        return true;
                    }
                    if (this.f9660c.h == 0 && aVar.f9660c.h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                        return true;
                    }
                    if (this.f9660c.h == 1 && aVar.f9660c.h == 1 && (this.o != aVar.o || this.p != aVar.p)) {
                        return true;
                    }
                    boolean z = this.k;
                    boolean z2 = aVar.k;
                    if (z == z2) {
                        return z && z2 && this.l != aVar.l;
                    }
                    return true;
                }
            }
        }
    }
}
