package com.google.android.exoplayer2.i.d;

import com.google.android.exoplayer2.s.v;

final class d {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f10078a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f10079b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10080c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f10081d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f10082e;

        private a(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
            this.f10078a = jArr;
            this.f10079b = iArr;
            this.f10080c = i;
            this.f10081d = jArr2;
            this.f10082e = iArr2;
        }
    }

    public static a a(int i, long[] jArr, int[] iArr, long j) {
        int[] iArr2 = iArr;
        int i2 = 8192 / i;
        int i3 = 0;
        for (int a2 : iArr2) {
            i3 += v.a(a2, i2);
        }
        long[] jArr2 = new long[i3];
        int[] iArr3 = new int[i3];
        long[] jArr3 = new long[i3];
        int[] iArr4 = new int[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < iArr2.length; i7++) {
            int i8 = iArr2[i7];
            long j2 = jArr[i7];
            while (i8 > 0) {
                int min = Math.min(i2, i8);
                jArr2[i4] = j2;
                iArr3[i4] = i * min;
                i6 = Math.max(i6, iArr3[i4]);
                jArr3[i4] = ((long) i5) * j;
                iArr4[i4] = 1;
                j2 += (long) iArr3[i4];
                i5 += min;
                i8 -= min;
                i4++;
            }
        }
        return new a(jArr2, iArr3, i6, jArr3, iArr4);
    }
}
