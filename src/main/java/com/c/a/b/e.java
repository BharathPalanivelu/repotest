package com.c.a.b;

import android.graphics.Bitmap;
import android.util.Log;
import com.c.a.b.a;
import com.tencent.imsdk.TIMGroupManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5625a = "e";

    /* renamed from: b  reason: collision with root package name */
    private int[] f5626b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f5627c;

    /* renamed from: d  reason: collision with root package name */
    private ByteBuffer f5628d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f5629e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f5630f;

    /* renamed from: g  reason: collision with root package name */
    private int f5631g;
    private int h;
    private short[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    private int[] m;
    private int n;
    private c o;
    private a.C0098a p;
    private Bitmap q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private Bitmap.Config x;

    public e(a.C0098a aVar, c cVar, ByteBuffer byteBuffer, int i2) {
        this(aVar);
        a(cVar, byteBuffer, i2);
    }

    public e(a.C0098a aVar) {
        this.f5627c = new int[256];
        this.f5631g = 0;
        this.h = 0;
        this.x = Bitmap.Config.ARGB_8888;
        this.p = aVar;
        this.o = new c();
    }

    public ByteBuffer a() {
        return this.f5628d;
    }

    public void b() {
        this.n = (this.n + 1) % this.o.f5616c;
    }

    public int a(int i2) {
        if (i2 < 0 || i2 >= this.o.f5616c) {
            return -1;
        }
        return this.o.f5618e.get(i2).i;
    }

    public int c() {
        if (this.o.f5616c <= 0) {
            return 0;
        }
        int i2 = this.n;
        if (i2 < 0) {
            return 0;
        }
        return a(i2);
    }

    public int d() {
        return this.o.f5616c;
    }

    public int e() {
        return this.n;
    }

    public void f() {
        this.n = -1;
    }

    public int g() {
        return this.f5628d.limit() + this.l.length + (this.m.length * 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00db, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap h() {
        /*
            r7 = this;
            monitor-enter(r7)
            com.c.a.b.c r0 = r7.o     // Catch:{ all -> 0x00dc }
            int r0 = r0.f5616c     // Catch:{ all -> 0x00dc }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r7.n     // Catch:{ all -> 0x00dc }
            if (r0 >= 0) goto L_0x003b
        L_0x000d:
            java.lang.String r0 = f5625a     // Catch:{ all -> 0x00dc }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00dc }
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = f5625a     // Catch:{ all -> 0x00dc }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r3.<init>()     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = "Unable to decode frame, frameCount="
            r3.append(r4)     // Catch:{ all -> 0x00dc }
            com.c.a.b.c r4 = r7.o     // Catch:{ all -> 0x00dc }
            int r4 = r4.f5616c     // Catch:{ all -> 0x00dc }
            r3.append(r4)     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = ", framePointer="
            r3.append(r4)     // Catch:{ all -> 0x00dc }
            int r4 = r7.n     // Catch:{ all -> 0x00dc }
            r3.append(r4)     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00dc }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00dc }
        L_0x0039:
            r7.s = r2     // Catch:{ all -> 0x00dc }
        L_0x003b:
            int r0 = r7.s     // Catch:{ all -> 0x00dc }
            r3 = 0
            if (r0 == r2) goto L_0x00ba
            int r0 = r7.s     // Catch:{ all -> 0x00dc }
            r4 = 2
            if (r0 != r4) goto L_0x0047
            goto L_0x00ba
        L_0x0047:
            r0 = 0
            r7.s = r0     // Catch:{ all -> 0x00dc }
            com.c.a.b.c r4 = r7.o     // Catch:{ all -> 0x00dc }
            java.util.List<com.c.a.b.b> r4 = r4.f5618e     // Catch:{ all -> 0x00dc }
            int r5 = r7.n     // Catch:{ all -> 0x00dc }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00dc }
            com.c.a.b.b r4 = (com.c.a.b.b) r4     // Catch:{ all -> 0x00dc }
            int r5 = r7.n     // Catch:{ all -> 0x00dc }
            int r5 = r5 - r2
            if (r5 < 0) goto L_0x0066
            com.c.a.b.c r6 = r7.o     // Catch:{ all -> 0x00dc }
            java.util.List<com.c.a.b.b> r6 = r6.f5618e     // Catch:{ all -> 0x00dc }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x00dc }
            com.c.a.b.b r5 = (com.c.a.b.b) r5     // Catch:{ all -> 0x00dc }
            goto L_0x0067
        L_0x0066:
            r5 = r3
        L_0x0067:
            int[] r6 = r4.k     // Catch:{ all -> 0x00dc }
            if (r6 == 0) goto L_0x006e
            int[] r6 = r4.k     // Catch:{ all -> 0x00dc }
            goto L_0x0072
        L_0x006e:
            com.c.a.b.c r6 = r7.o     // Catch:{ all -> 0x00dc }
            int[] r6 = r6.f5614a     // Catch:{ all -> 0x00dc }
        L_0x0072:
            r7.f5626b = r6     // Catch:{ all -> 0x00dc }
            int[] r6 = r7.f5626b     // Catch:{ all -> 0x00dc }
            if (r6 != 0) goto L_0x009c
            java.lang.String r0 = f5625a     // Catch:{ all -> 0x00dc }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00dc }
            if (r0 == 0) goto L_0x0098
            java.lang.String r0 = f5625a     // Catch:{ all -> 0x00dc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r1.<init>()     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = "No valid color table found for frame #"
            r1.append(r4)     // Catch:{ all -> 0x00dc }
            int r4 = r7.n     // Catch:{ all -> 0x00dc }
            r1.append(r4)     // Catch:{ all -> 0x00dc }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00dc }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00dc }
        L_0x0098:
            r7.s = r2     // Catch:{ all -> 0x00dc }
            monitor-exit(r7)
            return r3
        L_0x009c:
            boolean r1 = r4.f5612f     // Catch:{ all -> 0x00dc }
            if (r1 == 0) goto L_0x00b4
            int[] r1 = r7.f5626b     // Catch:{ all -> 0x00dc }
            int[] r2 = r7.f5627c     // Catch:{ all -> 0x00dc }
            int[] r3 = r7.f5626b     // Catch:{ all -> 0x00dc }
            int r3 = r3.length     // Catch:{ all -> 0x00dc }
            java.lang.System.arraycopy(r1, r0, r2, r0, r3)     // Catch:{ all -> 0x00dc }
            int[] r1 = r7.f5627c     // Catch:{ all -> 0x00dc }
            r7.f5626b = r1     // Catch:{ all -> 0x00dc }
            int[] r1 = r7.f5626b     // Catch:{ all -> 0x00dc }
            int r2 = r4.h     // Catch:{ all -> 0x00dc }
            r1[r2] = r0     // Catch:{ all -> 0x00dc }
        L_0x00b4:
            android.graphics.Bitmap r0 = r7.a(r4, r5)     // Catch:{ all -> 0x00dc }
            monitor-exit(r7)
            return r0
        L_0x00ba:
            java.lang.String r0 = f5625a     // Catch:{ all -> 0x00dc }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00dc }
            if (r0 == 0) goto L_0x00da
            java.lang.String r0 = f5625a     // Catch:{ all -> 0x00dc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r1.<init>()     // Catch:{ all -> 0x00dc }
            java.lang.String r2 = "Unable to decode frame, status="
            r1.append(r2)     // Catch:{ all -> 0x00dc }
            int r2 = r7.s     // Catch:{ all -> 0x00dc }
            r1.append(r2)     // Catch:{ all -> 0x00dc }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00dc }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00dc }
        L_0x00da:
            monitor-exit(r7)
            return r3
        L_0x00dc:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.b.e.h():android.graphics.Bitmap");
    }

    public void i() {
        this.o = null;
        byte[] bArr = this.l;
        if (bArr != null) {
            this.p.a(bArr);
        }
        int[] iArr = this.m;
        if (iArr != null) {
            this.p.a(iArr);
        }
        Bitmap bitmap = this.q;
        if (bitmap != null) {
            this.p.a(bitmap);
        }
        this.q = null;
        this.f5628d = null;
        this.w = false;
        byte[] bArr2 = this.f5629e;
        if (bArr2 != null) {
            this.p.a(bArr2);
        }
        byte[] bArr3 = this.f5630f;
        if (bArr3 != null) {
            this.p.a(bArr3);
        }
    }

    public synchronized void a(c cVar, ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(i2);
            this.s = 0;
            this.o = cVar;
            this.w = false;
            this.n = -1;
            this.f5628d = byteBuffer.asReadOnlyBuffer();
            this.f5628d.position(0);
            this.f5628d.order(ByteOrder.LITTLE_ENDIAN);
            this.r = false;
            Iterator<b> it = cVar.f5618e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().f5613g == 3) {
                        this.r = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.t = highestOneBit;
            this.v = cVar.f5619f / highestOneBit;
            this.u = cVar.f5620g / highestOneBit;
            this.l = this.p.a(cVar.f5619f * cVar.f5620g);
            this.m = this.p.b(this.v * this.u);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    public void a(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.x = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
        if (r0.o.j == r1.h) goto L_0x004f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap a(com.c.a.b.b r18, com.c.a.b.b r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            int[] r10 = r0.m
            r11 = 0
            if (r2 != 0) goto L_0x001a
            android.graphics.Bitmap r3 = r0.q
            if (r3 == 0) goto L_0x0014
            com.c.a.b.a$a r4 = r0.p
            r4.a((android.graphics.Bitmap) r3)
        L_0x0014:
            r3 = 0
            r0.q = r3
            java.util.Arrays.fill(r10, r11)
        L_0x001a:
            r12 = 3
            if (r2 == 0) goto L_0x0028
            int r3 = r2.f5613g
            if (r3 != r12) goto L_0x0028
            android.graphics.Bitmap r3 = r0.q
            if (r3 != 0) goto L_0x0028
            java.util.Arrays.fill(r10, r11)
        L_0x0028:
            r13 = 2
            r14 = 1
            if (r2 == 0) goto L_0x0090
            int r3 = r2.f5613g
            if (r3 <= 0) goto L_0x0090
            int r3 = r2.f5613g
            if (r3 != r13) goto L_0x007c
            boolean r3 = r1.f5612f
            if (r3 != 0) goto L_0x0049
            com.c.a.b.c r3 = r0.o
            int r3 = r3.l
            int[] r4 = r1.k
            if (r4 == 0) goto L_0x0050
            com.c.a.b.c r4 = r0.o
            int r4 = r4.j
            int r5 = r1.h
            if (r4 != r5) goto L_0x0050
            goto L_0x004f
        L_0x0049:
            int r3 = r0.n
            if (r3 != 0) goto L_0x004f
            r0.w = r14
        L_0x004f:
            r3 = 0
        L_0x0050:
            int r4 = r2.f5610d
            int r5 = r0.t
            int r4 = r4 / r5
            int r5 = r2.f5608b
            int r6 = r0.t
            int r5 = r5 / r6
            int r6 = r2.f5609c
            int r7 = r0.t
            int r6 = r6 / r7
            int r2 = r2.f5607a
            int r7 = r0.t
            int r2 = r2 / r7
            int r7 = r0.v
            int r5 = r5 * r7
            int r5 = r5 + r2
            int r4 = r4 * r7
            int r4 = r4 + r5
        L_0x006c:
            if (r5 >= r4) goto L_0x0090
            int r2 = r5 + r6
            r7 = r5
        L_0x0071:
            if (r7 >= r2) goto L_0x0078
            r10[r7] = r3
            int r7 = r7 + 1
            goto L_0x0071
        L_0x0078:
            int r2 = r0.v
            int r5 = r5 + r2
            goto L_0x006c
        L_0x007c:
            int r2 = r2.f5613g
            if (r2 != r12) goto L_0x0090
            android.graphics.Bitmap r2 = r0.q
            if (r2 == 0) goto L_0x0090
            r4 = 0
            int r8 = r0.v
            r6 = 0
            r7 = 0
            int r9 = r0.u
            r3 = r10
            r5 = r8
            r2.getPixels(r3, r4, r5, r6, r7, r8, r9)
        L_0x0090:
            r17.a((com.c.a.b.b) r18)
            int r2 = r1.f5610d
            int r3 = r0.t
            int r2 = r2 / r3
            int r3 = r1.f5608b
            int r4 = r0.t
            int r3 = r3 / r4
            int r4 = r1.f5609c
            int r5 = r0.t
            int r4 = r4 / r5
            int r5 = r1.f5607a
            int r6 = r0.t
            int r5 = r5 / r6
            r6 = 8
            int r7 = r0.n
            if (r7 != 0) goto L_0x00af
            r7 = 1
            goto L_0x00b0
        L_0x00af:
            r7 = 0
        L_0x00b0:
            r6 = 0
            r8 = 1
            r9 = 8
        L_0x00b4:
            if (r11 >= r2) goto L_0x013b
            boolean r15 = r1.f5611e
            if (r15 == 0) goto L_0x00d0
            r15 = 4
            if (r6 < r2) goto L_0x00cd
            int r8 = r8 + 1
            if (r8 == r13) goto L_0x00cc
            if (r8 == r12) goto L_0x00c9
            if (r8 == r15) goto L_0x00c6
            goto L_0x00cd
        L_0x00c6:
            r6 = 1
            r9 = 2
            goto L_0x00cd
        L_0x00c9:
            r6 = 2
            r9 = 4
            goto L_0x00cd
        L_0x00cc:
            r6 = 4
        L_0x00cd:
            int r15 = r6 + r9
            goto L_0x00d2
        L_0x00d0:
            r15 = r6
            r6 = r11
        L_0x00d2:
            int r6 = r6 + r3
            int r12 = r0.u
            if (r6 >= r12) goto L_0x012b
            int r12 = r0.v
            int r6 = r6 * r12
            int r16 = r6 + r5
            int r13 = r16 + r4
            int r14 = r6 + r12
            if (r14 >= r13) goto L_0x00e5
            int r13 = r6 + r12
        L_0x00e5:
            int r6 = r0.t
            int r6 = r6 * r11
            int r12 = r1.f5609c
            int r6 = r6 * r12
            int r12 = r13 - r16
            int r14 = r0.t
            int r12 = r12 * r14
            int r12 = r12 + r6
            r14 = r6
            r6 = r16
        L_0x00f7:
            if (r6 >= r13) goto L_0x012b
            r19 = r2
            int r2 = r0.t
            r16 = r3
            r3 = 1
            if (r2 != r3) goto L_0x010d
            byte[] r2 = r0.l
            byte r2 = r2[r14]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int[] r3 = r0.f5626b
            r2 = r3[r2]
            goto L_0x0113
        L_0x010d:
            int r2 = r1.f5609c
            int r2 = r0.a((int) r14, (int) r12, (int) r2)
        L_0x0113:
            if (r2 == 0) goto L_0x0118
            r10[r6] = r2
            goto L_0x0121
        L_0x0118:
            boolean r2 = r0.w
            if (r2 != 0) goto L_0x0121
            if (r7 == 0) goto L_0x0121
            r2 = 1
            r0.w = r2
        L_0x0121:
            int r2 = r0.t
            int r14 = r14 + r2
            int r6 = r6 + 1
            r2 = r19
            r3 = r16
            goto L_0x00f7
        L_0x012b:
            r19 = r2
            r16 = r3
            int r11 = r11 + 1
            r2 = r19
            r6 = r15
            r3 = r16
            r12 = 3
            r13 = 2
            r14 = 1
            goto L_0x00b4
        L_0x013b:
            boolean r2 = r0.r
            if (r2 == 0) goto L_0x0160
            int r2 = r1.f5613g
            if (r2 == 0) goto L_0x0148
            int r1 = r1.f5613g
            r2 = 1
            if (r1 != r2) goto L_0x0160
        L_0x0148:
            android.graphics.Bitmap r1 = r0.q
            if (r1 != 0) goto L_0x0152
            android.graphics.Bitmap r1 = r17.m()
            r0.q = r1
        L_0x0152:
            android.graphics.Bitmap r1 = r0.q
            r3 = 0
            int r7 = r0.v
            r5 = 0
            r6 = 0
            int r8 = r0.u
            r2 = r10
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
        L_0x0160:
            android.graphics.Bitmap r9 = r17.m()
            r3 = 0
            int r7 = r0.v
            r5 = 0
            r6 = 0
            int r8 = r0.u
            r1 = r9
            r2 = r10
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.b.e.a(com.c.a.b.b, com.c.a.b.b):android.graphics.Bitmap");
    }

    private int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.t + i2; i10++) {
            byte[] bArr = this.l;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f5626b[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.t + i12; i13++) {
            byte[] bArr2 = this.l;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f5626b[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r2v15, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.c.a.b.b r27) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = 0
            r0.f5631g = r2
            r0.h = r2
            if (r1 == 0) goto L_0x0012
            java.nio.ByteBuffer r3 = r0.f5628d
            int r4 = r1.j
            r3.position(r4)
        L_0x0012:
            if (r1 != 0) goto L_0x001f
            com.c.a.b.c r1 = r0.o
            int r1 = r1.f5619f
            com.c.a.b.c r3 = r0.o
            int r3 = r3.f5620g
            int r1 = r1 * r3
            goto L_0x0025
        L_0x001f:
            int r3 = r1.f5609c
            int r1 = r1.f5610d
            int r1 = r1 * r3
        L_0x0025:
            byte[] r3 = r0.l
            if (r3 == 0) goto L_0x002c
            int r3 = r3.length
            if (r3 >= r1) goto L_0x0034
        L_0x002c:
            com.c.a.b.a$a r3 = r0.p
            byte[] r3 = r3.a((int) r1)
            r0.l = r3
        L_0x0034:
            short[] r3 = r0.i
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x003e
            short[] r3 = new short[r4]
            r0.i = r3
        L_0x003e:
            byte[] r3 = r0.j
            if (r3 != 0) goto L_0x0046
            byte[] r3 = new byte[r4]
            r0.j = r3
        L_0x0046:
            byte[] r3 = r0.k
            if (r3 != 0) goto L_0x0050
            r3 = 4097(0x1001, float:5.741E-42)
            byte[] r3 = new byte[r3]
            r0.k = r3
        L_0x0050:
            int r3 = r26.k()
            r5 = 1
            int r6 = r5 << r3
            int r7 = r6 + 1
            int r8 = r6 + 2
            int r3 = r3 + r5
            int r9 = r5 << r3
            int r9 = r9 - r5
            r10 = 0
        L_0x0060:
            if (r10 >= r6) goto L_0x006e
            short[] r11 = r0.i
            r11[r10] = r2
            byte[] r11 = r0.j
            byte r12 = (byte) r10
            r11[r10] = r12
            int r10 = r10 + 1
            goto L_0x0060
        L_0x006e:
            r10 = -1
            r21 = r3
            r19 = r8
            r22 = r9
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = -1
        L_0x0082:
            if (r11 >= r1) goto L_0x0178
            r2 = 3
            if (r12 != 0) goto L_0x0092
            int r12 = r26.l()
            if (r12 > 0) goto L_0x0091
            r0.s = r2
            goto L_0x0178
        L_0x0091:
            r15 = 0
        L_0x0092:
            byte[] r4 = r0.f5629e
            byte r4 = r4[r15]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r13
            int r14 = r14 + r4
            int r13 = r13 + 8
            int r15 = r15 + r5
            int r12 = r12 + r10
            r23 = r18
            r5 = r20
            r4 = r21
            r18 = r11
            r11 = r19
            r19 = r17
        L_0x00aa:
            if (r13 < r4) goto L_0x0160
            r10 = r14 & r22
            int r14 = r14 >> r4
            int r13 = r13 - r4
            if (r10 != r6) goto L_0x00b9
            r4 = r3
            r11 = r8
            r22 = r9
            r5 = -1
        L_0x00b7:
            r10 = -1
            goto L_0x00aa
        L_0x00b9:
            if (r10 <= r11) goto L_0x00be
            r0.s = r2
            goto L_0x00c0
        L_0x00be:
            if (r10 != r7) goto L_0x00d2
        L_0x00c0:
            r21 = r4
            r20 = r5
            r17 = r19
            r2 = 0
            r4 = 4096(0x1000, float:5.74E-42)
            r5 = 1
            r10 = -1
            r19 = r11
            r11 = r18
            r18 = r23
            goto L_0x0082
        L_0x00d2:
            r2 = -1
            if (r5 != r2) goto L_0x00e6
            byte[] r5 = r0.k
            int r20 = r19 + 1
            byte[] r2 = r0.j
            byte r2 = r2[r10]
            r5[r19] = r2
            r5 = r10
            r23 = r5
            r19 = r20
            r2 = 3
            goto L_0x00b7
        L_0x00e6:
            if (r10 < r11) goto L_0x00f7
            byte[] r2 = r0.k
            int r20 = r19 + 1
            r24 = r3
            r3 = r23
            byte r3 = (byte) r3
            r2[r19] = r3
            r2 = r5
            r19 = r20
            goto L_0x00fa
        L_0x00f7:
            r24 = r3
            r2 = r10
        L_0x00fa:
            if (r2 < r6) goto L_0x0111
            byte[] r3 = r0.k
            int r20 = r19 + 1
            r23 = r6
            byte[] r6 = r0.j
            byte r6 = r6[r2]
            r3[r19] = r6
            short[] r3 = r0.i
            short r2 = r3[r2]
            r19 = r20
            r6 = r23
            goto L_0x00fa
        L_0x0111:
            r23 = r6
            byte[] r3 = r0.j
            byte r2 = r3[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r6 = r0.k
            int r20 = r19 + 1
            r25 = r7
            byte r7 = (byte) r2
            r6[r19] = r7
            r6 = 4096(0x1000, float:5.74E-42)
            if (r11 >= r6) goto L_0x013e
            short[] r6 = r0.i
            short r5 = (short) r5
            r6[r11] = r5
            r3[r11] = r7
            int r11 = r11 + 1
            r3 = r11 & r22
            if (r3 != 0) goto L_0x013c
            r6 = 4096(0x1000, float:5.74E-42)
            if (r11 >= r6) goto L_0x013e
            int r4 = r4 + 1
            int r22 = r22 + r11
            goto L_0x013e
        L_0x013c:
            r6 = 4096(0x1000, float:5.74E-42)
        L_0x013e:
            r19 = r20
        L_0x0140:
            if (r19 <= 0) goto L_0x0153
            byte[] r3 = r0.l
            int r5 = r16 + 1
            byte[] r7 = r0.k
            int r19 = r19 + -1
            byte r7 = r7[r19]
            r3[r16] = r7
            int r18 = r18 + 1
            r16 = r5
            goto L_0x0140
        L_0x0153:
            r5 = r10
            r6 = r23
            r3 = r24
            r7 = r25
            r10 = -1
            r23 = r2
            r2 = 3
            goto L_0x00aa
        L_0x0160:
            r24 = r3
            r3 = r23
            r21 = r4
            r20 = r5
            r17 = r19
            r2 = 0
            r4 = 4096(0x1000, float:5.74E-42)
            r5 = 1
            r19 = r11
            r11 = r18
            r18 = r3
            r3 = r24
            goto L_0x0082
        L_0x0178:
            r2 = r16
        L_0x017a:
            if (r2 >= r1) goto L_0x0184
            byte[] r3 = r0.l
            r4 = 0
            r3[r2] = r4
            int r2 = r2 + 1
            goto L_0x017a
        L_0x0184:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.b.e.a(com.c.a.b.b):void");
    }

    private void j() {
        if (this.f5631g <= this.h) {
            if (this.f5630f == null) {
                this.f5630f = this.p.a((int) TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
            }
            this.h = 0;
            this.f5631g = Math.min(this.f5628d.remaining(), TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
            this.f5628d.get(this.f5630f, 0, this.f5631g);
        }
    }

    private int k() {
        try {
            j();
            byte[] bArr = this.f5630f;
            int i2 = this.h;
            this.h = i2 + 1;
            return bArr[i2] & 255;
        } catch (Exception unused) {
            this.s = 1;
            return 0;
        }
    }

    private int l() {
        int k2 = k();
        if (k2 > 0) {
            try {
                if (this.f5629e == null) {
                    this.f5629e = this.p.a(255);
                }
                int i2 = this.f5631g - this.h;
                if (i2 >= k2) {
                    System.arraycopy(this.f5630f, this.h, this.f5629e, 0, k2);
                    this.h += k2;
                } else if (this.f5628d.remaining() + i2 >= k2) {
                    System.arraycopy(this.f5630f, this.h, this.f5629e, 0, i2);
                    this.h = this.f5631g;
                    j();
                    int i3 = k2 - i2;
                    System.arraycopy(this.f5630f, 0, this.f5629e, i2, i3);
                    this.h += i3;
                } else {
                    this.s = 1;
                }
            } catch (Exception e2) {
                Log.w(f5625a, "Error Reading Block", e2);
                this.s = 1;
            }
        }
        return k2;
    }

    private Bitmap m() {
        Bitmap a2 = this.p.a(this.v, this.u, this.w ? Bitmap.Config.ARGB_8888 : this.x);
        a2.setHasAlpha(true);
        return a2;
    }
}
