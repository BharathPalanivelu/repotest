package com.google.android.exoplayer2.p.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.s.k;
import com.google.android.exoplayer2.s.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f11076a = {0, 7, 8, 15};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f11077b = {0, 119, -120, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f11078c = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: d  reason: collision with root package name */
    private final Paint f11079d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    private final Paint f11080e;

    /* renamed from: f  reason: collision with root package name */
    private final Canvas f11081f;

    /* renamed from: g  reason: collision with root package name */
    private final C0182b f11082g;
    private final a h;
    private final h i;
    private Bitmap j;

    private static int a(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    public b(int i2, int i3) {
        this.f11079d.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f11079d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f11079d.setPathEffect((PathEffect) null);
        this.f11080e = new Paint();
        this.f11080e.setStyle(Paint.Style.FILL);
        this.f11080e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.f11080e.setPathEffect((PathEffect) null);
        this.f11081f = new Canvas();
        this.f11082g = new C0182b(719, 575, 0, 719, 0, 575);
        this.h = new a(0, b(), c(), d());
        this.i = new h(i2, i3);
    }

    public void a() {
        this.i.a();
    }

    public List<com.google.android.exoplayer2.p.b> a(byte[] bArr, int i2) {
        int i3;
        int i4;
        SparseArray<g> sparseArray;
        k kVar = new k(bArr, i2);
        while (kVar.a() >= 48 && kVar.c(8) == 15) {
            a(kVar, this.i);
        }
        if (this.i.i == null) {
            return Collections.emptyList();
        }
        C0182b bVar = this.i.h != null ? this.i.h : this.f11082g;
        if (!(this.j != null && bVar.f11087a + 1 == this.j.getWidth() && bVar.f11088b + 1 == this.j.getHeight())) {
            this.j = Bitmap.createBitmap(bVar.f11087a + 1, bVar.f11088b + 1, Bitmap.Config.ARGB_8888);
            this.f11081f.setBitmap(this.j);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray2 = this.i.i.f11100d;
        for (int i5 = 0; i5 < sparseArray2.size(); i5++) {
            e valueAt = sparseArray2.valueAt(i5);
            f fVar = this.i.f11118c.get(sparseArray2.keyAt(i5));
            int i6 = valueAt.f11101a + bVar.f11089c;
            int i7 = valueAt.f11102b + bVar.f11091e;
            float f2 = (float) i6;
            float f3 = (float) i7;
            float f4 = f3;
            float f5 = f2;
            this.f11081f.clipRect(f2, f3, (float) Math.min(fVar.f11105c + i6, bVar.f11090d), (float) Math.min(fVar.f11106d + i7, bVar.f11092f), Region.Op.REPLACE);
            a aVar = this.i.f11119d.get(fVar.f11109g);
            if (aVar == null) {
                aVar = this.i.f11121f.get(fVar.f11109g);
                if (aVar == null) {
                    aVar = this.h;
                }
            }
            SparseArray<g> sparseArray3 = fVar.k;
            int i8 = 0;
            while (i8 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i8);
                g valueAt2 = sparseArray3.valueAt(i8);
                c cVar = this.i.f11120e.get(keyAt);
                c cVar2 = cVar == null ? this.i.f11122g.get(keyAt) : cVar;
                if (cVar2 != null) {
                    i4 = i8;
                    sparseArray = sparseArray3;
                    a(cVar2, aVar, fVar.f11108f, valueAt2.f11112c + i6, i7 + valueAt2.f11113d, cVar2.f11094b ? null : this.f11079d, this.f11081f);
                } else {
                    i4 = i8;
                    sparseArray = sparseArray3;
                }
                i8 = i4 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.f11104b) {
                if (fVar.f11108f == 3) {
                    i3 = aVar.f11086d[fVar.h];
                } else if (fVar.f11108f == 2) {
                    i3 = aVar.f11085c[fVar.i];
                } else {
                    i3 = aVar.f11084b[fVar.j];
                }
                this.f11080e.setColor(i3);
                this.f11081f.drawRect(f5, f4, (float) (fVar.f11105c + i6), (float) (fVar.f11106d + i7), this.f11080e);
            }
            arrayList.add(new com.google.android.exoplayer2.p.b(Bitmap.createBitmap(this.j, i6, i7, fVar.f11105c, fVar.f11106d), f5 / ((float) bVar.f11087a), 0, f4 / ((float) bVar.f11088b), 0, ((float) fVar.f11105c) / ((float) bVar.f11087a), ((float) fVar.f11106d) / ((float) bVar.f11088b)));
            this.f11081f.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return arrayList;
    }

    private static void a(k kVar, h hVar) {
        int c2 = kVar.c(8);
        int c3 = kVar.c(16);
        int c4 = kVar.c(16);
        int c5 = kVar.c() + c4;
        if (c4 * 8 > kVar.a()) {
            Log.w("DvbParser", "Data field length exceeds limit");
            kVar.b(kVar.a());
            return;
        }
        switch (c2) {
            case 16:
                if (c3 == hVar.f11116a) {
                    d dVar = hVar.i;
                    d a2 = a(kVar, c4);
                    if (a2.f11099c == 0) {
                        if (!(dVar == null || dVar.f11098b == a2.f11098b)) {
                            hVar.i = a2;
                            break;
                        }
                    } else {
                        hVar.i = a2;
                        hVar.f11118c.clear();
                        hVar.f11119d.clear();
                        hVar.f11120e.clear();
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.i;
                if (c3 == hVar.f11116a && dVar2 != null) {
                    f b2 = b(kVar, c4);
                    if (dVar2.f11099c == 0) {
                        b2.a(hVar.f11118c.get(b2.f11103a));
                    }
                    hVar.f11118c.put(b2.f11103a, b2);
                    break;
                }
            case 18:
                if (c3 != hVar.f11116a) {
                    if (c3 == hVar.f11117b) {
                        a c6 = c(kVar, c4);
                        hVar.f11121f.put(c6.f11083a, c6);
                        break;
                    }
                } else {
                    a c7 = c(kVar, c4);
                    hVar.f11119d.put(c7.f11083a, c7);
                    break;
                }
                break;
            case 19:
                if (c3 != hVar.f11116a) {
                    if (c3 == hVar.f11117b) {
                        c b3 = b(kVar);
                        hVar.f11122g.put(b3.f11093a, b3);
                        break;
                    }
                } else {
                    c b4 = b(kVar);
                    hVar.f11120e.put(b4.f11093a, b4);
                    break;
                }
                break;
            case 20:
                if (c3 == hVar.f11116a) {
                    hVar.h = a(kVar);
                    break;
                }
                break;
        }
        kVar.d(c5 - kVar.c());
    }

    private static C0182b a(k kVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        kVar.b(4);
        boolean e2 = kVar.e();
        kVar.b(3);
        int c2 = kVar.c(16);
        int c3 = kVar.c(16);
        if (e2) {
            int c4 = kVar.c(16);
            int c5 = kVar.c(16);
            int c6 = kVar.c(16);
            i2 = kVar.c(16);
            i4 = c5;
            i3 = c6;
            i5 = c4;
        } else {
            i4 = c2;
            i2 = c3;
            i5 = 0;
            i3 = 0;
        }
        return new C0182b(c2, c3, i5, i4, i3, i2);
    }

    private static d a(k kVar, int i2) {
        int c2 = kVar.c(8);
        int c3 = kVar.c(4);
        int c4 = kVar.c(2);
        kVar.b(2);
        int i3 = i2 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int c5 = kVar.c(8);
            kVar.b(8);
            i3 -= 6;
            sparseArray.put(c5, new e(kVar.c(16), kVar.c(16)));
        }
        return new d(c2, c3, c4, sparseArray);
    }

    private static f b(k kVar, int i2) {
        int i3;
        int i4;
        k kVar2 = kVar;
        int c2 = kVar2.c(8);
        kVar2.b(4);
        boolean e2 = kVar.e();
        kVar2.b(3);
        int i5 = 16;
        int c3 = kVar2.c(16);
        int c4 = kVar2.c(16);
        int c5 = kVar2.c(3);
        int c6 = kVar2.c(3);
        int i6 = 2;
        kVar2.b(2);
        int c7 = kVar2.c(8);
        int c8 = kVar2.c(8);
        int c9 = kVar2.c(4);
        int c10 = kVar2.c(2);
        kVar2.b(2);
        int i7 = i2 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i7 > 0) {
            int c11 = kVar2.c(i5);
            int c12 = kVar2.c(i6);
            int c13 = kVar2.c(i6);
            int c14 = kVar2.c(12);
            int i8 = c10;
            kVar2.b(4);
            int c15 = kVar2.c(12);
            i7 -= 6;
            if (c12 == 1 || c12 == 2) {
                i7 -= 2;
                i4 = kVar2.c(8);
                i3 = kVar2.c(8);
            } else {
                i4 = 0;
                i3 = 0;
            }
            sparseArray.put(c11, new g(c12, c13, c14, c15, i4, i3));
            c10 = i8;
            i6 = 2;
            i5 = 16;
        }
        return new f(c2, e2, c3, c4, c5, c6, c7, c8, c9, c10, sparseArray);
    }

    private static a c(k kVar, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        k kVar2 = kVar;
        int i8 = 8;
        int c2 = kVar2.c(8);
        kVar2.b(8);
        int i9 = 2;
        int i10 = i2 - 2;
        int[] b2 = b();
        int[] c3 = c();
        int[] d2 = d();
        while (i10 > 0) {
            int c4 = kVar2.c(i8);
            int c5 = kVar2.c(i8);
            int i11 = i10 - 2;
            int[] iArr = (c5 & 128) != 0 ? b2 : (c5 & 64) != 0 ? c3 : d2;
            if ((c5 & 1) != 0) {
                i6 = kVar2.c(i8);
                i5 = kVar2.c(i8);
                i4 = kVar2.c(i8);
                i3 = kVar2.c(i8);
                i7 = i11 - 4;
            } else {
                i4 = kVar2.c(4) << 4;
                i7 = i11 - 2;
                int c6 = kVar2.c(4) << 4;
                i3 = kVar2.c(i9) << 6;
                i6 = kVar2.c(6) << i9;
                i5 = c6;
            }
            if (i6 == 0) {
                i5 = 0;
                i4 = 0;
                i3 = 255;
            }
            double d3 = (double) i6;
            double d4 = (double) (i5 - 128);
            Double.isNaN(d4);
            Double.isNaN(d3);
            double d5 = (double) (i4 - 128);
            Double.isNaN(d5);
            Double.isNaN(d3);
            Double.isNaN(d4);
            Double.isNaN(d5);
            Double.isNaN(d3);
            iArr[c4] = a((byte) (255 - (i3 & 255)), v.a((int) (d3 + (1.402d * d4)), 0, 255), v.a((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 0, 255), v.a((int) (d3 + (d5 * 1.772d)), 0, 255));
            i10 = i7;
            c2 = c2;
            i8 = 8;
            i9 = 2;
        }
        return new a(c2, b2, c3, d2);
    }

    private static c b(k kVar) {
        byte[] bArr;
        int c2 = kVar.c(16);
        kVar.b(4);
        int c3 = kVar.c(2);
        boolean e2 = kVar.e();
        kVar.b(1);
        byte[] bArr2 = null;
        if (c3 == 1) {
            kVar.b(kVar.c(8) * 16);
        } else if (c3 == 0) {
            int c4 = kVar.c(16);
            int c5 = kVar.c(16);
            if (c4 > 0) {
                bArr2 = new byte[c4];
                kVar.a(bArr2, 0, c4);
            }
            if (c5 > 0) {
                bArr = new byte[c5];
                kVar.a(bArr, 0, c5);
                return new c(c2, e2, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(c2, e2, bArr2, bArr);
    }

    private static int[] b() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] c() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (i2 < 8) {
                iArr[i2] = a(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                int i3 = 127;
                int i4 = (i2 & 1) != 0 ? 127 : 0;
                int i5 = (i2 & 2) != 0 ? 127 : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = a(255, i4, i5, i3);
            }
        }
        return iArr;
    }

    private static int[] d() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = 255;
            if (i2 < 8) {
                int i4 = (i2 & 1) != 0 ? 255 : 0;
                int i5 = (i2 & 2) != 0 ? 255 : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = a(63, i4, i5, i3);
            } else {
                int i6 = i2 & 136;
                int i7 = 170;
                int i8 = 85;
                if (i6 == 0) {
                    int i9 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0);
                    int i10 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0);
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = a(255, i9, i10, i8 + i7);
                } else if (i6 != 8) {
                    int i11 = 43;
                    if (i6 == 128) {
                        int i12 = ((i2 & 1) != 0 ? 43 : 0) + 127 + ((i2 & 16) != 0 ? 85 : 0);
                        int i13 = ((i2 & 2) != 0 ? 43 : 0) + 127 + ((i2 & 32) != 0 ? 85 : 0);
                        if ((i2 & 4) == 0) {
                            i11 = 0;
                        }
                        int i14 = i11 + 127;
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = a(255, i12, i13, i14 + i8);
                    } else if (i6 == 136) {
                        int i15 = ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0);
                        int i16 = ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0);
                        if ((i2 & 4) == 0) {
                            i11 = 0;
                        }
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = a(255, i15, i16, i11 + i8);
                    }
                } else {
                    int i17 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0);
                    int i18 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0);
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = a(127, i17, i18, i8 + i7);
                }
            }
        }
        return iArr;
    }

    private static void a(c cVar, a aVar, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i2 == 3) {
            iArr = aVar.f11086d;
        } else if (i2 == 2) {
            iArr = aVar.f11085c;
        } else {
            iArr = aVar.f11084b;
        }
        int[] iArr2 = iArr;
        int i5 = i2;
        int i6 = i3;
        Paint paint2 = paint;
        Canvas canvas2 = canvas;
        a(cVar.f11095c, iArr2, i5, i6, i4, paint2, canvas2);
        a(cVar.f11096d, iArr2, i5, i6, i4 + 1, paint2, canvas2);
    }

    private static void a(byte[] bArr, int[] iArr, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        byte[] bArr2;
        int a2;
        byte[] bArr3;
        byte[] bArr4;
        int i5 = i2;
        byte[] bArr5 = bArr;
        k kVar = new k(bArr);
        int i6 = i3;
        int i7 = i4;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        while (kVar.a() != 0) {
            int c2 = kVar.c(8);
            if (c2 != 240) {
                switch (c2) {
                    case 16:
                        if (i5 != 3) {
                            if (i5 != 2) {
                                bArr2 = null;
                                a2 = a(kVar, iArr, bArr2, i6, i7, paint, canvas);
                                kVar.f();
                                break;
                            } else {
                                bArr3 = bArr7 == null ? f11076a : bArr7;
                            }
                        } else {
                            bArr3 = bArr6 == null ? f11077b : bArr6;
                        }
                        bArr2 = bArr3;
                        a2 = a(kVar, iArr, bArr2, i6, i7, paint, canvas);
                        kVar.f();
                    case 17:
                        a2 = b(kVar, iArr, i5 == 3 ? f11078c : null, i6, i7, paint, canvas);
                        kVar.f();
                        break;
                    case 18:
                        a2 = c(kVar, iArr, (byte[]) null, i6, i7, paint, canvas);
                        break;
                    default:
                        switch (c2) {
                            case 32:
                                bArr7 = a(4, 4, kVar);
                                continue;
                            case 33:
                                bArr4 = a(4, 8, kVar);
                                break;
                            case 34:
                                bArr4 = a(16, 8, kVar);
                                break;
                            default:
                                continue;
                        }
                        bArr6 = bArr4;
                        break;
                }
                i6 = a2;
            } else {
                i7 += 2;
                i6 = i3;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0083 A[LOOP:0: B:1:0x0009->B:30:0x0083, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0082 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(com.google.android.exoplayer2.s.k r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 2
            int r4 = r13.c(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0015
            r12 = r2
            r3 = r4
        L_0x0013:
            r11 = 1
            goto L_0x0061
        L_0x0015:
            boolean r4 = r13.e()
            r6 = 3
            if (r4 == 0) goto L_0x0028
            int r4 = r13.c(r6)
            int r4 = r4 + r6
            int r3 = r13.c(r3)
        L_0x0025:
            r12 = r2
            r11 = r4
            goto L_0x0061
        L_0x0028:
            boolean r4 = r13.e()
            if (r4 == 0) goto L_0x0031
            r12 = r2
            r3 = 0
            goto L_0x0013
        L_0x0031:
            int r4 = r13.c(r3)
            if (r4 == 0) goto L_0x005e
            if (r4 == r5) goto L_0x005a
            if (r4 == r3) goto L_0x004e
            if (r4 == r6) goto L_0x0041
            r12 = r2
            r3 = 0
            r11 = 0
            goto L_0x0061
        L_0x0041:
            r4 = 8
            int r4 = r13.c(r4)
            int r4 = r4 + 29
            int r3 = r13.c(r3)
            goto L_0x0025
        L_0x004e:
            r4 = 4
            int r4 = r13.c(r4)
            int r4 = r4 + 12
            int r3 = r13.c(r3)
            goto L_0x0025
        L_0x005a:
            r12 = r2
            r3 = 0
            r11 = 2
            goto L_0x0061
        L_0x005e:
            r3 = 0
            r11 = 0
            r12 = 1
        L_0x0061:
            if (r11 == 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            if (r15 == 0) goto L_0x0069
            byte r3 = r15[r3]
        L_0x0069:
            r2 = r14[r3]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r11
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x007f:
            int r10 = r10 + r11
            if (r12 == 0) goto L_0x0083
            return r10
        L_0x0083:
            r2 = r12
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p.b.b.a(com.google.android.exoplayer2.s.k, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f A[LOOP:0: B:1:0x0009->B:33:0x008f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int b(com.google.android.exoplayer2.s.k r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 4
            int r4 = r13.c(r3)
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0017
            r12 = r2
            r3 = r4
        L_0x0014:
            r11 = 1
            goto L_0x006f
        L_0x0017:
            boolean r4 = r13.e()
            r7 = 3
            if (r4 != 0) goto L_0x002e
            int r3 = r13.c(r7)
            if (r3 == 0) goto L_0x002a
            int r3 = r3 + 2
            r12 = r2
            r11 = r3
            r3 = 0
            goto L_0x006f
        L_0x002a:
            r3 = 0
            r11 = 0
            r12 = 1
            goto L_0x006f
        L_0x002e:
            boolean r4 = r13.e()
            if (r4 != 0) goto L_0x0040
            int r4 = r13.c(r5)
            int r4 = r4 + r3
            int r3 = r13.c(r3)
        L_0x003d:
            r12 = r2
            r11 = r4
            goto L_0x006f
        L_0x0040:
            int r4 = r13.c(r5)
            if (r4 == 0) goto L_0x006c
            if (r4 == r6) goto L_0x0068
            if (r4 == r5) goto L_0x005d
            if (r4 == r7) goto L_0x0050
            r12 = r2
            r3 = 0
            r11 = 0
            goto L_0x006f
        L_0x0050:
            r4 = 8
            int r4 = r13.c(r4)
            int r4 = r4 + 25
            int r3 = r13.c(r3)
            goto L_0x003d
        L_0x005d:
            int r4 = r13.c(r3)
            int r4 = r4 + 9
            int r3 = r13.c(r3)
            goto L_0x003d
        L_0x0068:
            r12 = r2
            r3 = 0
            r11 = 2
            goto L_0x006f
        L_0x006c:
            r12 = r2
            r3 = 0
            goto L_0x0014
        L_0x006f:
            if (r11 == 0) goto L_0x008b
            if (r8 == 0) goto L_0x008b
            if (r15 == 0) goto L_0x0077
            byte r3 = r15[r3]
        L_0x0077:
            r2 = r14[r3]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r11
            float r5 = (float) r2
            int r2 = r1 + 1
            float r6 = (float) r2
            r2 = r19
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x008b:
            int r10 = r10 + r11
            if (r12 == 0) goto L_0x008f
            return r10
        L_0x008f:
            r2 = r12
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p.b.b.b(com.google.android.exoplayer2.s.k, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int c(com.google.android.exoplayer2.s.k r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 8
            int r4 = r13.c(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0016
            r12 = r2
            r3 = r4
            r11 = 1
            goto L_0x0035
        L_0x0016:
            boolean r4 = r13.e()
            r6 = 7
            if (r4 != 0) goto L_0x002b
            int r3 = r13.c(r6)
            if (r3 == 0) goto L_0x0027
            r12 = r2
            r11 = r3
            r3 = 0
            goto L_0x0035
        L_0x0027:
            r3 = 0
            r11 = 0
            r12 = 1
            goto L_0x0035
        L_0x002b:
            int r4 = r13.c(r6)
            int r3 = r13.c(r3)
            r12 = r2
            r11 = r4
        L_0x0035:
            if (r11 == 0) goto L_0x0053
            if (r8 == 0) goto L_0x0053
            if (r15 == 0) goto L_0x003d
            byte r3 = r15[r3]
        L_0x003d:
            r2 = r14[r3]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r11
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0053:
            int r10 = r10 + r11
            if (r12 == 0) goto L_0x0057
            return r10
        L_0x0057:
            r2 = r12
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p.b.b.c(com.google.android.exoplayer2.s.k, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static byte[] a(int i2, int i3, k kVar) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) kVar.c(i3);
        }
        return bArr;
    }

    private static final class h {

        /* renamed from: a  reason: collision with root package name */
        public final int f11116a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11117b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseArray<f> f11118c = new SparseArray<>();

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<a> f11119d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<c> f11120e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        public final SparseArray<a> f11121f = new SparseArray<>();

        /* renamed from: g  reason: collision with root package name */
        public final SparseArray<c> f11122g = new SparseArray<>();
        public C0182b h;
        public d i;

        public h(int i2, int i3) {
            this.f11116a = i2;
            this.f11117b = i3;
        }

        public void a() {
            this.f11118c.clear();
            this.f11119d.clear();
            this.f11120e.clear();
            this.f11121f.clear();
            this.f11122g.clear();
            this.h = null;
            this.i = null;
        }
    }

    /* renamed from: com.google.android.exoplayer2.p.b.b$b  reason: collision with other inner class name */
    private static final class C0182b {

        /* renamed from: a  reason: collision with root package name */
        public final int f11087a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11088b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11089c;

        /* renamed from: d  reason: collision with root package name */
        public final int f11090d;

        /* renamed from: e  reason: collision with root package name */
        public final int f11091e;

        /* renamed from: f  reason: collision with root package name */
        public final int f11092f;

        public C0182b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f11087a = i;
            this.f11088b = i2;
            this.f11089c = i3;
            this.f11090d = i4;
            this.f11091e = i5;
            this.f11092f = i6;
        }
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f11097a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11098b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11099c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<e> f11100d;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.f11097a = i;
            this.f11098b = i2;
            this.f11099c = i3;
            this.f11100d = sparseArray;
        }
    }

    private static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f11101a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11102b;

        public e(int i, int i2) {
            this.f11101a = i;
            this.f11102b = i2;
        }
    }

    private static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final int f11103a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f11104b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11105c;

        /* renamed from: d  reason: collision with root package name */
        public final int f11106d;

        /* renamed from: e  reason: collision with root package name */
        public final int f11107e;

        /* renamed from: f  reason: collision with root package name */
        public final int f11108f;

        /* renamed from: g  reason: collision with root package name */
        public final int f11109g;
        public final int h;
        public final int i;
        public final int j;
        public final SparseArray<g> k;

        public f(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, SparseArray<g> sparseArray) {
            this.f11103a = i2;
            this.f11104b = z;
            this.f11105c = i3;
            this.f11106d = i4;
            this.f11107e = i5;
            this.f11108f = i6;
            this.f11109g = i7;
            this.h = i8;
            this.i = i9;
            this.j = i10;
            this.k = sparseArray;
        }

        public void a(f fVar) {
            if (fVar != null) {
                SparseArray<g> sparseArray = fVar.k;
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    this.k.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
                }
            }
        }
    }

    private static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final int f11110a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11111b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11112c;

        /* renamed from: d  reason: collision with root package name */
        public final int f11113d;

        /* renamed from: e  reason: collision with root package name */
        public final int f11114e;

        /* renamed from: f  reason: collision with root package name */
        public final int f11115f;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f11110a = i;
            this.f11111b = i2;
            this.f11112c = i3;
            this.f11113d = i4;
            this.f11114e = i5;
            this.f11115f = i6;
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f11083a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f11084b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f11085c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f11086d;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f11083a = i;
            this.f11084b = iArr;
            this.f11085c = iArr2;
            this.f11086d = iArr3;
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f11093a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f11094b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f11095c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f11096d;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.f11093a = i;
            this.f11094b = z;
            this.f11095c = bArr;
            this.f11096d = bArr2;
        }
    }
}
