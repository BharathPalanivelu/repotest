package com.google.zxing.e.b;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.zxing.j;
import com.google.zxing.q;
import com.google.zxing.y;
import com.google.zxing.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.zxing.c.b f14679a;

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f14680b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f14681c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f14682d = new int[5];

    /* renamed from: e  reason: collision with root package name */
    private final z f14683e;

    public e(com.google.zxing.c.b bVar, z zVar) {
        this.f14679a = bVar;
        this.f14683e = zVar;
    }

    /* access modifiers changed from: package-private */
    public final f a(Map<j, ?> map) throws q {
        Map<j, ?> map2 = map;
        boolean z = map2 != null && map2.containsKey(j.TRY_HARDER);
        boolean z2 = map2 != null && map2.containsKey(j.PURE_BARCODE);
        int d2 = this.f14679a.d();
        int c2 = this.f14679a.c();
        int i = (d2 * 3) / 228;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        int i3 = i;
        boolean z3 = false;
        while (i2 < d2 && !z3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            boolean z4 = z3;
            int i4 = i3;
            int i5 = 0;
            int i6 = 0;
            while (i5 < c2) {
                if (this.f14679a.a(i5, i2)) {
                    if ((i6 & 1) == 1) {
                        i6++;
                    }
                    iArr[i6] = iArr[i6] + 1;
                } else if ((i6 & 1) != 0) {
                    iArr[i6] = iArr[i6] + 1;
                } else if (i6 == 4) {
                    if (!a(iArr)) {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    } else if (a(iArr, i2, i5, z2)) {
                        if (this.f14681c) {
                            z4 = c();
                        } else {
                            int b2 = b();
                            if (b2 > iArr[2]) {
                                i2 += (b2 - iArr[2]) - 2;
                                i5 = c2 - 1;
                            }
                        }
                        iArr[0] = 0;
                        iArr[1] = 0;
                        iArr[2] = 0;
                        iArr[3] = 0;
                        iArr[4] = 0;
                        i6 = 0;
                        i4 = 2;
                    } else {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    }
                    i6 = 3;
                } else {
                    i6++;
                    iArr[i6] = iArr[i6] + 1;
                }
                i5++;
            }
            if (!a(iArr) || !a(iArr, i2, c2, z2)) {
                i3 = i4;
            } else {
                int i7 = iArr[0];
                if (this.f14681c) {
                    i3 = i7;
                    z3 = c();
                    i2 += i3;
                } else {
                    i3 = i7;
                }
            }
            z3 = z4;
            i2 += i3;
        }
        d[] d3 = d();
        y.a(d3);
        return new f(d3);
    }

    private static float a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    protected static boolean a(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f2 = ((float) i) / 7.0f;
        float f3 = f2 / 2.0f;
        if (Math.abs(f2 - ((float) iArr[0])) >= f3 || Math.abs(f2 - ((float) iArr[1])) >= f3 || Math.abs((f2 * 3.0f) - ((float) iArr[2])) >= 3.0f * f3 || Math.abs(f2 - ((float) iArr[3])) >= f3 || Math.abs(f2 - ((float) iArr[4])) >= f3) {
            return false;
        }
        return true;
    }

    private int[] a() {
        int[] iArr = this.f14682d;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int[] a2 = a();
        int i10 = 0;
        while (i7 >= i10 && i8 >= i10 && this.f14679a.a(i8 - i10, i7 - i10)) {
            a2[2] = a2[2] + 1;
            i10++;
        }
        if (i7 < i10 || i8 < i10) {
            return false;
        }
        while (i7 >= i10 && i8 >= i10 && !this.f14679a.a(i8 - i10, i7 - i10) && a2[1] <= i9) {
            a2[1] = a2[1] + 1;
            i10++;
        }
        if (i7 < i10 || i8 < i10 || a2[1] > i9) {
            return false;
        }
        while (i7 >= i10 && i8 >= i10 && this.f14679a.a(i8 - i10, i7 - i10) && a2[0] <= i9) {
            a2[0] = a2[0] + 1;
            i10++;
        }
        if (a2[0] > i9) {
            return false;
        }
        int d2 = this.f14679a.d();
        int c2 = this.f14679a.c();
        int i11 = 1;
        while (true) {
            i5 = i7 + i11;
            if (i5 >= d2) {
                break;
            }
            int i12 = i8 + i11;
            if (i12 >= c2 || !this.f14679a.a(i12, i5)) {
                break;
            }
            a2[2] = a2[2] + 1;
            i11++;
        }
        if (i5 >= d2 || i8 + i11 >= c2) {
            return false;
        }
        while (true) {
            i6 = i7 + i11;
            if (i6 >= d2) {
                break;
            }
            int i13 = i8 + i11;
            if (i13 >= c2 || this.f14679a.a(i13, i6) || a2[3] >= i9) {
                break;
            }
            a2[3] = a2[3] + 1;
            i11++;
        }
        if (i6 >= d2 || i8 + i11 >= c2 || a2[3] >= i9) {
            return false;
        }
        while (true) {
            int i14 = i7 + i11;
            if (i14 >= d2) {
                break;
            }
            int i15 = i8 + i11;
            if (i15 >= c2 || !this.f14679a.a(i15, i14) || a2[4] >= i9) {
                break;
            }
            a2[4] = a2[4] + 1;
            i11++;
        }
        if (a2[4] < i9 && Math.abs(((((a2[0] + a2[1]) + a2[2]) + a2[3]) + a2[4]) - i4) < i4 * 2 && a(a2)) {
            return true;
        }
        return false;
    }

    private float b(int i, int i2, int i3, int i4) {
        com.google.zxing.c.b bVar = this.f14679a;
        int d2 = bVar.d();
        int[] a2 = a();
        int i5 = i;
        while (i5 >= 0 && bVar.a(i2, i5)) {
            a2[2] = a2[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bVar.a(i2, i5) && a2[1] <= i3) {
            a2[1] = a2[1] + 1;
            i5--;
        }
        if (i5 < 0 || a2[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bVar.a(i2, i5) && a2[0] <= i3) {
            a2[0] = a2[0] + 1;
            i5--;
        }
        if (a2[0] > i3) {
            return Float.NaN;
        }
        int i6 = i + 1;
        while (i6 < d2 && bVar.a(i2, i6)) {
            a2[2] = a2[2] + 1;
            i6++;
        }
        if (i6 == d2) {
            return Float.NaN;
        }
        while (i6 < d2 && !bVar.a(i2, i6) && a2[3] < i3) {
            a2[3] = a2[3] + 1;
            i6++;
        }
        if (i6 == d2 || a2[3] >= i3) {
            return Float.NaN;
        }
        while (i6 < d2 && bVar.a(i2, i6) && a2[4] < i3) {
            a2[4] = a2[4] + 1;
            i6++;
        }
        if (a2[4] < i3 && Math.abs(((((a2[0] + a2[1]) + a2[2]) + a2[3]) + a2[4]) - i4) * 5 < i4 * 2 && a(a2)) {
            return a(a2, i6);
        }
        return Float.NaN;
    }

    private float c(int i, int i2, int i3, int i4) {
        com.google.zxing.c.b bVar = this.f14679a;
        int c2 = bVar.c();
        int[] a2 = a();
        int i5 = i;
        while (i5 >= 0 && bVar.a(i5, i2)) {
            a2[2] = a2[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bVar.a(i5, i2) && a2[1] <= i3) {
            a2[1] = a2[1] + 1;
            i5--;
        }
        if (i5 < 0 || a2[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bVar.a(i5, i2) && a2[0] <= i3) {
            a2[0] = a2[0] + 1;
            i5--;
        }
        if (a2[0] > i3) {
            return Float.NaN;
        }
        int i6 = i + 1;
        while (i6 < c2 && bVar.a(i6, i2)) {
            a2[2] = a2[2] + 1;
            i6++;
        }
        if (i6 == c2) {
            return Float.NaN;
        }
        while (i6 < c2 && !bVar.a(i6, i2) && a2[3] < i3) {
            a2[3] = a2[3] + 1;
            i6++;
        }
        if (i6 == c2 || a2[3] >= i3) {
            return Float.NaN;
        }
        while (i6 < c2 && bVar.a(i6, i2) && a2[4] < i3) {
            a2[4] = a2[4] + 1;
            i6++;
        }
        if (a2[4] < i3 && Math.abs(((((a2[0] + a2[1]) + a2[2]) + a2[3]) + a2[4]) - i4) * 5 < i4 && a(a2)) {
            return a(a2, i6);
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final boolean a(int[] iArr, int i, int i2, boolean z) {
        boolean z2 = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a2 = (int) a(iArr, i2);
        float b2 = b(i, a2, iArr[2], i3);
        if (!Float.isNaN(b2)) {
            int i4 = (int) b2;
            float c2 = c(a2, i4, iArr[2], i3);
            if (!Float.isNaN(c2) && (!z || a(i4, (int) c2, iArr[2], i3))) {
                float f2 = ((float) i3) / 7.0f;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.f14680b.size()) {
                        break;
                    }
                    d dVar = this.f14680b.get(i5);
                    if (dVar.a(f2, b2, c2)) {
                        this.f14680b.set(i5, dVar.b(b2, c2, f2));
                        z2 = true;
                        break;
                    }
                    i5++;
                }
                if (!z2) {
                    d dVar2 = new d(c2, b2, f2);
                    this.f14680b.add(dVar2);
                    z zVar = this.f14683e;
                    if (zVar != null) {
                        zVar.a(dVar2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private int b() {
        if (this.f14680b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d next : this.f14680b) {
            if (next.d() >= 2) {
                if (dVar == null) {
                    dVar = next;
                } else {
                    this.f14681c = true;
                    return ((int) (Math.abs(dVar.a() - next.a()) - Math.abs(dVar.b() - next.b()))) / 2;
                }
            }
        }
        return 0;
    }

    private boolean c() {
        int size = this.f14680b.size();
        float f2 = BitmapDescriptorFactory.HUE_RED;
        int i = 0;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        for (d next : this.f14680b) {
            if (next.d() >= 2) {
                i++;
                f3 += next.c();
            }
        }
        if (i < 3) {
            return false;
        }
        float f4 = f3 / ((float) size);
        for (d c2 : this.f14680b) {
            f2 += Math.abs(c2.c() - f4);
        }
        if (f2 <= f3 * 0.05f) {
            return true;
        }
        return false;
    }

    private d[] d() throws q {
        int size = this.f14680b.size();
        if (size >= 3) {
            float f2 = BitmapDescriptorFactory.HUE_RED;
            if (size > 3) {
                float f3 = BitmapDescriptorFactory.HUE_RED;
                float f4 = BitmapDescriptorFactory.HUE_RED;
                for (d c2 : this.f14680b) {
                    float c3 = c2.c();
                    f3 += c3;
                    f4 += c3 * c3;
                }
                float f5 = (float) size;
                float f6 = f3 / f5;
                float sqrt = (float) Math.sqrt((double) ((f4 / f5) - (f6 * f6)));
                Collections.sort(this.f14680b, new b(f6));
                float max = Math.max(0.2f * f6, sqrt);
                int i = 0;
                while (i < this.f14680b.size() && this.f14680b.size() > 3) {
                    if (Math.abs(this.f14680b.get(i).c() - f6) > max) {
                        this.f14680b.remove(i);
                        i--;
                    }
                    i++;
                }
            }
            if (this.f14680b.size() > 3) {
                for (d c4 : this.f14680b) {
                    f2 += c4.c();
                }
                Collections.sort(this.f14680b, new a(f2 / ((float) this.f14680b.size())));
                List<d> list = this.f14680b;
                list.subList(3, list.size()).clear();
            }
            return new d[]{this.f14680b.get(0), this.f14680b.get(1), this.f14680b.get(2)};
        }
        throw q.a();
    }

    private static final class b implements Serializable, Comparator<d> {
        private final float average;

        private b(float f2) {
            this.average = f2;
        }

        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            float abs = Math.abs(dVar2.c() - this.average);
            float abs2 = Math.abs(dVar.c() - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    private static final class a implements Serializable, Comparator<d> {
        private final float average;

        private a(float f2) {
            this.average = f2;
        }

        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            if (dVar2.d() != dVar.d()) {
                return dVar2.d() - dVar.d();
            }
            float abs = Math.abs(dVar2.c() - this.average);
            float abs2 = Math.abs(dVar.c() - this.average);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }
}
