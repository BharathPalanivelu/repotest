package com.google.android.exoplayer2.s;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f11404a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f11405b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c  reason: collision with root package name */
    private static final Object f11406c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static int[] f11407d = new int[10];

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f11411a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11412b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11413c;

        /* renamed from: d  reason: collision with root package name */
        public final float f11414d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f11415e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f11416f;

        /* renamed from: g  reason: collision with root package name */
        public final int f11417g;
        public final int h;
        public final int i;
        public final boolean j;

        public b(int i2, int i3, int i4, float f2, boolean z, boolean z2, int i5, int i6, int i7, boolean z3) {
            this.f11411a = i2;
            this.f11412b = i3;
            this.f11413c = i4;
            this.f11414d = f2;
            this.f11415e = z;
            this.f11416f = z2;
            this.f11417g = i5;
            this.h = i6;
            this.i = i7;
            this.j = z3;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f11408a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11409b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f11410c;

        public a(int i, int i2, boolean z) {
            this.f11408a = i;
            this.f11409b = i2;
            this.f11410c = z;
        }
    }

    public static int a(byte[] bArr, int i) {
        int i2;
        synchronized (f11406c) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                try {
                    i3 = c(bArr, i3, i);
                    if (i3 < i) {
                        if (f11407d.length <= i4) {
                            f11407d = Arrays.copyOf(f11407d, f11407d.length * 2);
                        }
                        f11407d[i4] = i3;
                        i3 += 3;
                        i4++;
                    }
                } finally {
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = f11407d[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i10 + 1;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    public static void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 < position) {
                byte b2 = byteBuffer.get(i) & 255;
                if (i2 == 3) {
                    if (b2 == 1 && (byteBuffer.get(i3) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (b2 == 0) {
                    i2++;
                }
                if (b2 != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static boolean a(String str, byte b2) {
        if ("video/avc".equals(str) && (b2 & 31) == 6) {
            return true;
        }
        if (!"video/hevc".equals(str) || ((b2 & 126) >> 1) != 39) {
            return false;
        }
        return true;
    }

    public static int b(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static int c(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0144  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.s.j.b a(byte[] r18, int r19, int r20) {
        /*
            com.google.android.exoplayer2.s.m r0 = new com.google.android.exoplayer2.s.m
            r1 = r18
            r2 = r19
            r3 = r20
            r0.<init>(r1, r2, r3)
            r1 = 8
            r0.a(r1)
            int r2 = r0.c(r1)
            r3 = 16
            r0.a(r3)
            int r5 = r0.d()
            r4 = 3
            r6 = 0
            r7 = 1
            r8 = 100
            if (r2 == r8) goto L_0x004c
            r8 = 110(0x6e, float:1.54E-43)
            if (r2 == r8) goto L_0x004c
            r8 = 122(0x7a, float:1.71E-43)
            if (r2 == r8) goto L_0x004c
            r8 = 244(0xf4, float:3.42E-43)
            if (r2 == r8) goto L_0x004c
            r8 = 44
            if (r2 == r8) goto L_0x004c
            r8 = 83
            if (r2 == r8) goto L_0x004c
            r8 = 86
            if (r2 == r8) goto L_0x004c
            r8 = 118(0x76, float:1.65E-43)
            if (r2 == r8) goto L_0x004c
            r8 = 128(0x80, float:1.794E-43)
            if (r2 == r8) goto L_0x004c
            r8 = 138(0x8a, float:1.93E-43)
            if (r2 != r8) goto L_0x0049
            goto L_0x004c
        L_0x0049:
            r2 = 1
            r9 = 0
            goto L_0x0086
        L_0x004c:
            int r2 = r0.d()
            if (r2 != r4) goto L_0x0057
            boolean r8 = r0.b()
            goto L_0x0058
        L_0x0057:
            r8 = 0
        L_0x0058:
            r0.d()
            r0.d()
            r0.a()
            boolean r9 = r0.b()
            if (r9 == 0) goto L_0x0085
            if (r2 == r4) goto L_0x006c
            r9 = 8
            goto L_0x006e
        L_0x006c:
            r9 = 12
        L_0x006e:
            r10 = 0
        L_0x006f:
            if (r10 >= r9) goto L_0x0085
            boolean r11 = r0.b()
            if (r11 == 0) goto L_0x0082
            r11 = 6
            if (r10 >= r11) goto L_0x007d
            r11 = 16
            goto L_0x007f
        L_0x007d:
            r11 = 64
        L_0x007f:
            a((com.google.android.exoplayer2.s.m) r0, (int) r11)
        L_0x0082:
            int r10 = r10 + 1
            goto L_0x006f
        L_0x0085:
            r9 = r8
        L_0x0086:
            int r8 = r0.d()
            int r11 = r8 + 4
            int r12 = r0.d()
            if (r12 != 0) goto L_0x009c
            int r8 = r0.d()
            int r8 = r8 + 4
            r18 = r5
            r13 = r8
            goto L_0x00c1
        L_0x009c:
            if (r12 != r7) goto L_0x00be
            boolean r8 = r0.b()
            r0.e()
            r0.e()
            int r10 = r0.d()
            long r13 = (long) r10
            r18 = r5
            r10 = 0
        L_0x00b0:
            long r4 = (long) r10
            int r15 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x00bb
            r0.d()
            int r10 = r10 + 1
            goto L_0x00b0
        L_0x00bb:
            r14 = r8
            r13 = 0
            goto L_0x00c2
        L_0x00be:
            r18 = r5
            r13 = 0
        L_0x00c1:
            r14 = 0
        L_0x00c2:
            r0.d()
            r0.a()
            int r4 = r0.d()
            int r4 = r4 + r7
            int r5 = r0.d()
            int r5 = r5 + r7
            boolean r10 = r0.b()
            r6 = 2
            int r8 = 2 - r10
            int r8 = r8 * r5
            if (r10 != 0) goto L_0x00e0
            r0.a()
        L_0x00e0:
            r0.a()
            int r4 = r4 * 16
            int r8 = r8 * 16
            boolean r5 = r0.b()
            if (r5 == 0) goto L_0x0118
            int r5 = r0.d()
            int r15 = r0.d()
            int r16 = r0.d()
            int r17 = r0.d()
            if (r2 != 0) goto L_0x0102
            int r6 = r6 - r10
            r3 = 1
            goto L_0x010e
        L_0x0102:
            r3 = 3
            if (r2 != r3) goto L_0x0107
            r3 = 1
            goto L_0x0108
        L_0x0107:
            r3 = 2
        L_0x0108:
            if (r2 != r7) goto L_0x010b
            r7 = 2
        L_0x010b:
            int r6 = r6 - r10
            int r6 = r6 * r7
        L_0x010e:
            int r5 = r5 + r15
            int r5 = r5 * r3
            int r4 = r4 - r5
            int r16 = r16 + r17
            int r16 = r16 * r6
            int r8 = r8 - r16
        L_0x0118:
            r6 = r4
            r7 = r8
            r2 = 1065353216(0x3f800000, float:1.0)
            boolean r3 = r0.b()
            if (r3 == 0) goto L_0x0163
            boolean r3 = r0.b()
            if (r3 == 0) goto L_0x0163
            int r1 = r0.c(r1)
            r3 = 255(0xff, float:3.57E-43)
            if (r1 != r3) goto L_0x0144
            r3 = 16
            int r1 = r0.c(r3)
            int r0 = r0.c(r3)
            if (r1 == 0) goto L_0x0142
            if (r0 == 0) goto L_0x0142
            float r1 = (float) r1
            float r0 = (float) r0
            float r2 = r1 / r0
        L_0x0142:
            r8 = r2
            goto L_0x0165
        L_0x0144:
            float[] r0 = f11405b
            int r3 = r0.length
            if (r1 >= r3) goto L_0x014d
            r0 = r0[r1]
            r8 = r0
            goto L_0x0165
        L_0x014d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Unexpected aspect_ratio_idc value: "
            r0.append(r3)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "NalUnitUtil"
            android.util.Log.w(r1, r0)
        L_0x0163:
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x0165:
            com.google.android.exoplayer2.s.j$b r0 = new com.google.android.exoplayer2.s.j$b
            r4 = r0
            r5 = r18
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.s.j.a(byte[], int, int):com.google.android.exoplayer2.s.j$b");
    }

    public static a b(byte[] bArr, int i, int i2) {
        m mVar = new m(bArr, i, i2);
        mVar.a(8);
        int d2 = mVar.d();
        int d3 = mVar.d();
        mVar.a();
        return new a(d2, d3, mVar.b());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0097, code lost:
        r8 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(byte[] r7, int r8, int r9, boolean[] r10) {
        /*
            int r0 = r9 - r8
            r1 = 0
            r2 = 1
            if (r0 < 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            com.google.android.exoplayer2.s.a.b(r3)
            if (r0 != 0) goto L_0x000f
            return r9
        L_0x000f:
            r3 = 2
            if (r10 == 0) goto L_0x0040
            boolean r4 = r10[r1]
            if (r4 == 0) goto L_0x001c
            a((boolean[]) r10)
            int r8 = r8 + -3
            return r8
        L_0x001c:
            if (r0 <= r2) goto L_0x002b
            boolean r4 = r10[r2]
            if (r4 == 0) goto L_0x002b
            byte r4 = r7[r8]
            if (r4 != r2) goto L_0x002b
            a((boolean[]) r10)
            int r8 = r8 - r3
            return r8
        L_0x002b:
            if (r0 <= r3) goto L_0x0040
            boolean r4 = r10[r3]
            if (r4 == 0) goto L_0x0040
            byte r4 = r7[r8]
            if (r4 != 0) goto L_0x0040
            int r4 = r8 + 1
            byte r4 = r7[r4]
            if (r4 != r2) goto L_0x0040
            a((boolean[]) r10)
            int r8 = r8 - r2
            return r8
        L_0x0040:
            int r4 = r9 + -1
            int r8 = r8 + r3
        L_0x0043:
            if (r8 >= r4) goto L_0x0067
            byte r5 = r7[r8]
            r5 = r5 & 254(0xfe, float:3.56E-43)
            if (r5 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            int r5 = r8 + -2
            byte r6 = r7[r5]
            if (r6 != 0) goto L_0x0062
            int r6 = r8 + -1
            byte r6 = r7[r6]
            if (r6 != 0) goto L_0x0062
            byte r6 = r7[r8]
            if (r6 != r2) goto L_0x0062
            if (r10 == 0) goto L_0x0061
            a((boolean[]) r10)
        L_0x0061:
            return r5
        L_0x0062:
            int r8 = r8 + -2
        L_0x0064:
            int r8 = r8 + 3
            goto L_0x0043
        L_0x0067:
            if (r10 == 0) goto L_0x00bb
            if (r0 <= r3) goto L_0x007e
            int r8 = r9 + -3
            byte r8 = r7[r8]
            if (r8 != 0) goto L_0x007c
            int r8 = r9 + -2
            byte r8 = r7[r8]
            if (r8 != 0) goto L_0x007c
            byte r8 = r7[r4]
            if (r8 != r2) goto L_0x007c
            goto L_0x0097
        L_0x007c:
            r8 = 0
            goto L_0x0098
        L_0x007e:
            if (r0 != r3) goto L_0x008f
            boolean r8 = r10[r3]
            if (r8 == 0) goto L_0x007c
            int r8 = r9 + -2
            byte r8 = r7[r8]
            if (r8 != 0) goto L_0x007c
            byte r8 = r7[r4]
            if (r8 != r2) goto L_0x007c
            goto L_0x0097
        L_0x008f:
            boolean r8 = r10[r2]
            if (r8 == 0) goto L_0x007c
            byte r8 = r7[r4]
            if (r8 != r2) goto L_0x007c
        L_0x0097:
            r8 = 1
        L_0x0098:
            r10[r1] = r8
            if (r0 <= r2) goto L_0x00a7
            int r8 = r9 + -2
            byte r8 = r7[r8]
            if (r8 != 0) goto L_0x00b1
            byte r8 = r7[r4]
            if (r8 != 0) goto L_0x00b1
            goto L_0x00af
        L_0x00a7:
            boolean r8 = r10[r3]
            if (r8 == 0) goto L_0x00b1
            byte r8 = r7[r4]
            if (r8 != 0) goto L_0x00b1
        L_0x00af:
            r8 = 1
            goto L_0x00b2
        L_0x00b1:
            r8 = 0
        L_0x00b2:
            r10[r2] = r8
            byte r7 = r7[r4]
            if (r7 != 0) goto L_0x00b9
            r1 = 1
        L_0x00b9:
            r10[r3] = r1
        L_0x00bb:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.s.j.a(byte[], int, int, boolean[]):int");
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static int c(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static void a(m mVar, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((mVar.e() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }
}
