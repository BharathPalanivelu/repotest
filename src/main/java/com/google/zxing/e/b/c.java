package com.google.zxing.e.b;

import com.google.zxing.c.a.a;
import com.google.zxing.c.b;
import com.google.zxing.c.g;
import com.google.zxing.c.i;
import com.google.zxing.c.k;
import com.google.zxing.j;
import com.google.zxing.m;
import com.google.zxing.q;
import com.google.zxing.y;
import com.google.zxing.z;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f14675a;

    /* renamed from: b  reason: collision with root package name */
    private z f14676b;

    public c(b bVar) {
        this.f14675a = bVar;
    }

    public final g a(Map<j, ?> map) throws q, m {
        this.f14676b = map == null ? null : (z) map.get(j.NEED_RESULT_POINT_CALLBACK);
        return a(new e(this.f14675a, this.f14676b).a(map));
    }

    /* access modifiers changed from: protected */
    public final g a(f fVar) throws q, m {
        y[] yVarArr;
        d b2 = fVar.b();
        d c2 = fVar.c();
        d a2 = fVar.a();
        float a3 = a((y) b2, (y) c2, (y) a2);
        if (a3 >= 1.0f) {
            int a4 = a((y) b2, (y) c2, (y) a2, a3);
            com.google.zxing.e.a.j a5 = com.google.zxing.e.a.j.a(a4);
            int d2 = a5.d() - 7;
            a aVar = null;
            if (a5.b().length > 0) {
                float a6 = (c2.a() - b2.a()) + a2.a();
                float b3 = (c2.b() - b2.b()) + a2.b();
                float f2 = 1.0f - (3.0f / ((float) d2));
                int a7 = (int) (b2.a() + ((a6 - b2.a()) * f2));
                int b4 = (int) (b2.b() + (f2 * (b3 - b2.b())));
                int i = 4;
                while (true) {
                    if (i > 16) {
                        break;
                    }
                    try {
                        aVar = a(a3, a7, b4, (float) i);
                        break;
                    } catch (q unused) {
                        i <<= 1;
                    }
                }
            }
            b a8 = a(this.f14675a, a(b2, c2, a2, aVar, a4), a4);
            if (aVar == null) {
                yVarArr = new y[]{a2, b2, c2};
            } else {
                yVarArr = new y[]{a2, b2, c2, aVar};
            }
            return new g(a8, yVarArr);
        }
        throw q.a();
    }

    private static k a(y yVar, y yVar2, y yVar3, y yVar4, int i) {
        float f2;
        float f3;
        float f4;
        float f5 = ((float) i) - 3.5f;
        if (yVar4 != null) {
            f3 = yVar4.a();
            f2 = yVar4.b();
            f4 = f5 - 3.0f;
        } else {
            f3 = (yVar2.a() - yVar.a()) + yVar3.a();
            f2 = (yVar2.b() - yVar.b()) + yVar3.b();
            f4 = f5;
        }
        return k.a(3.5f, 3.5f, f5, 3.5f, f4, f4, 3.5f, f5, yVar.a(), yVar.b(), yVar2.a(), yVar2.b(), f3, f2, yVar3.a(), yVar3.b());
    }

    private static b a(b bVar, k kVar, int i) throws q {
        return i.a().a(bVar, i, i, kVar);
    }

    private static int a(y yVar, y yVar2, y yVar3, float f2) throws q {
        int a2 = ((a.a(y.a(yVar, yVar2) / f2) + a.a(y.a(yVar, yVar3) / f2)) / 2) + 7;
        int i = a2 & 3;
        if (i == 0) {
            return a2 + 1;
        }
        if (i == 2) {
            return a2 - 1;
        }
        if (i != 3) {
            return a2;
        }
        throw q.a();
    }

    /* access modifiers changed from: protected */
    public final float a(y yVar, y yVar2, y yVar3) {
        return (a(yVar, yVar2) + a(yVar, yVar3)) / 2.0f;
    }

    private float a(y yVar, y yVar2) {
        float a2 = a((int) yVar.a(), (int) yVar.b(), (int) yVar2.a(), (int) yVar2.b());
        float a3 = a((int) yVar2.a(), (int) yVar2.b(), (int) yVar.a(), (int) yVar.b());
        if (Float.isNaN(a2)) {
            return a3 / 7.0f;
        }
        return Float.isNaN(a3) ? a2 / 7.0f : (a2 + a3) / 14.0f;
    }

    private float a(int i, int i2, int i3, int i4) {
        float f2;
        int i5;
        float f3;
        float b2 = b(i, i2, i3, i4);
        int i6 = i - (i3 - i);
        int i7 = 0;
        if (i6 < 0) {
            f2 = ((float) i) / ((float) (i - i6));
            i5 = 0;
        } else if (i6 >= this.f14675a.c()) {
            f2 = ((float) ((this.f14675a.c() - 1) - i)) / ((float) (i6 - i));
            i5 = this.f14675a.c() - 1;
        } else {
            i5 = i6;
            f2 = 1.0f;
        }
        float f4 = (float) i2;
        int i8 = (int) (f4 - (((float) (i4 - i2)) * f2));
        if (i8 < 0) {
            f3 = f4 / ((float) (i2 - i8));
        } else if (i8 >= this.f14675a.d()) {
            f3 = ((float) ((this.f14675a.d() - 1) - i2)) / ((float) (i8 - i2));
            i7 = this.f14675a.d() - 1;
        } else {
            i7 = i8;
            f3 = 1.0f;
        }
        return (b2 + b(i, i2, (int) (((float) i) + (((float) (i5 - i)) * f3)), i7)) - 1.0f;
    }

    private float b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        c cVar;
        boolean z2;
        int i10 = 1;
        boolean z3 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z3) {
            i5 = i;
            i7 = i2;
            i6 = i3;
            i8 = i4;
        } else {
            i7 = i;
            i5 = i2;
            i8 = i3;
            i6 = i4;
        }
        int abs = Math.abs(i8 - i7);
        int abs2 = Math.abs(i6 - i5);
        int i11 = (-abs) / 2;
        int i12 = -1;
        int i13 = i7 < i8 ? 1 : -1;
        if (i5 < i6) {
            i12 = 1;
        }
        int i14 = i8 + i13;
        int i15 = i5;
        int i16 = i11;
        int i17 = 0;
        int i18 = i7;
        while (true) {
            if (i18 == i14) {
                i9 = i14;
                break;
            }
            int i19 = z3 ? i15 : i18;
            int i20 = z3 ? i18 : i15;
            if (i17 == i10) {
                cVar = this;
                z = z3;
                i9 = i14;
                z2 = true;
            } else {
                cVar = this;
                z = z3;
                i9 = i14;
                z2 = false;
            }
            if (z2 == cVar.f14675a.a(i19, i20)) {
                if (i17 == 2) {
                    return a.a(i18, i15, i7, i5);
                }
                i17++;
            }
            i16 += abs2;
            if (i16 > 0) {
                if (i15 == i6) {
                    break;
                }
                i15 += i12;
                i16 -= abs;
            }
            i18 += i13;
            i14 = i9;
            z3 = z;
            i10 = 1;
        }
        if (i17 == 2) {
            return a.a(i9, i6, i7, i5);
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final a a(float f2, int i, int i2, float f3) throws q {
        int i3 = (int) (f3 * f2);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.f14675a.c() - 1, i + i3) - max;
        float f4 = 3.0f * f2;
        if (((float) min) >= f4) {
            int max2 = Math.max(0, i2 - i3);
            int min2 = Math.min(this.f14675a.d() - 1, i2 + i3) - max2;
            if (((float) min2) >= f4) {
                return new b(this.f14675a, max, max2, min, min2, f2, this.f14676b).a();
            }
            throw q.a();
        }
        throw q.a();
    }
}
