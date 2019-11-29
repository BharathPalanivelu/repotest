package com.google.android.exoplayer2.j.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.n.j;
import com.google.android.exoplayer2.n.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f10480a = {0, 7, 8, 15};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f10481b = {0, 119, -120, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f10482c = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: d  reason: collision with root package name */
    private final Paint f10483d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    private final Paint f10484e;

    /* renamed from: f  reason: collision with root package name */
    private final Canvas f10485f;

    /* renamed from: g  reason: collision with root package name */
    private final C0175b f10486g;
    private final a h;
    private final h i;
    private Bitmap j;

    private static int a(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    public b(int i2, int i3) {
        this.f10483d.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f10483d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f10483d.setPathEffect((PathEffect) null);
        this.f10484e = new Paint();
        this.f10484e.setStyle(Paint.Style.FILL);
        this.f10484e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.f10484e.setPathEffect((PathEffect) null);
        this.f10485f = new Canvas();
        this.f10486g = new C0175b(719, 575, 0, 719, 0, 575);
        this.h = new a(0, b(), c(), d());
        this.i = new h(i2, i3);
    }

    public void a() {
        this.i.a();
    }

    public List<com.google.android.exoplayer2.j.a> a(byte[] bArr, int i2) {
        int i3;
        int i4;
        SparseArray<g> sparseArray;
        j jVar = new j(bArr, i2);
        while (jVar.a() >= 48 && jVar.c(8) == 15) {
            a(jVar, this.i);
        }
        if (this.i.i == null) {
            return Collections.emptyList();
        }
        C0175b bVar = this.i.h != null ? this.i.h : this.f10486g;
        if (!(this.j != null && bVar.f10491a + 1 == this.j.getWidth() && bVar.f10492b + 1 == this.j.getHeight())) {
            this.j = Bitmap.createBitmap(bVar.f10491a + 1, bVar.f10492b + 1, Bitmap.Config.ARGB_8888);
            this.f10485f.setBitmap(this.j);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray2 = this.i.i.f10504d;
        for (int i5 = 0; i5 < sparseArray2.size(); i5++) {
            e valueAt = sparseArray2.valueAt(i5);
            f fVar = this.i.f10522c.get(sparseArray2.keyAt(i5));
            int i6 = valueAt.f10505a + bVar.f10493c;
            int i7 = valueAt.f10506b + bVar.f10495e;
            float f2 = (float) i6;
            float f3 = (float) i7;
            float f4 = f3;
            float f5 = f2;
            this.f10485f.clipRect(f2, f3, (float) Math.min(fVar.f10509c + i6, bVar.f10494d), (float) Math.min(fVar.f10510d + i7, bVar.f10496f), Region.Op.REPLACE);
            a aVar = this.i.f10523d.get(fVar.f10513g);
            if (aVar == null) {
                aVar = this.i.f10525f.get(fVar.f10513g);
                if (aVar == null) {
                    aVar = this.h;
                }
            }
            SparseArray<g> sparseArray3 = fVar.k;
            int i8 = 0;
            while (i8 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i8);
                g valueAt2 = sparseArray3.valueAt(i8);
                c cVar = this.i.f10524e.get(keyAt);
                c cVar2 = cVar == null ? this.i.f10526g.get(keyAt) : cVar;
                if (cVar2 != null) {
                    i4 = i8;
                    sparseArray = sparseArray3;
                    a(cVar2, aVar, fVar.f10512f, valueAt2.f10516c + i6, i7 + valueAt2.f10517d, cVar2.f10498b ? null : this.f10483d, this.f10485f);
                } else {
                    i4 = i8;
                    sparseArray = sparseArray3;
                }
                i8 = i4 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.f10508b) {
                if (fVar.f10512f == 3) {
                    i3 = aVar.f10490d[fVar.h];
                } else if (fVar.f10512f == 2) {
                    i3 = aVar.f10489c[fVar.i];
                } else {
                    i3 = aVar.f10488b[fVar.j];
                }
                this.f10484e.setColor(i3);
                this.f10485f.drawRect(f5, f4, (float) (fVar.f10509c + i6), (float) (fVar.f10510d + i7), this.f10484e);
            }
            arrayList.add(new com.google.android.exoplayer2.j.a(Bitmap.createBitmap(this.j, i6, i7, fVar.f10509c, fVar.f10510d), f5 / ((float) bVar.f10491a), 0, f4 / ((float) bVar.f10492b), 0, ((float) fVar.f10509c) / ((float) bVar.f10491a), ((float) fVar.f10510d) / ((float) bVar.f10492b)));
            this.f10485f.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return arrayList;
    }

    private static void a(j jVar, h hVar) {
        int c2 = jVar.c(8);
        int c3 = jVar.c(16);
        int c4 = jVar.c(16);
        int c5 = jVar.c() + c4;
        if (c4 * 8 > jVar.a()) {
            Log.w("DvbParser", "Data field length exceeds limit");
            jVar.b(jVar.a());
            return;
        }
        switch (c2) {
            case 16:
                if (c3 == hVar.f10520a) {
                    d dVar = hVar.i;
                    d a2 = a(jVar, c4);
                    if (a2.f10503c == 0) {
                        if (!(dVar == null || dVar.f10502b == a2.f10502b)) {
                            hVar.i = a2;
                            break;
                        }
                    } else {
                        hVar.i = a2;
                        hVar.f10522c.clear();
                        hVar.f10523d.clear();
                        hVar.f10524e.clear();
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.i;
                if (c3 == hVar.f10520a && dVar2 != null) {
                    f b2 = b(jVar, c4);
                    if (dVar2.f10503c == 0) {
                        b2.a(hVar.f10522c.get(b2.f10507a));
                    }
                    hVar.f10522c.put(b2.f10507a, b2);
                    break;
                }
            case 18:
                if (c3 != hVar.f10520a) {
                    if (c3 == hVar.f10521b) {
                        a c6 = c(jVar, c4);
                        hVar.f10525f.put(c6.f10487a, c6);
                        break;
                    }
                } else {
                    a c7 = c(jVar, c4);
                    hVar.f10523d.put(c7.f10487a, c7);
                    break;
                }
                break;
            case 19:
                if (c3 != hVar.f10520a) {
                    if (c3 == hVar.f10521b) {
                        c b3 = b(jVar);
                        hVar.f10526g.put(b3.f10497a, b3);
                        break;
                    }
                } else {
                    c b4 = b(jVar);
                    hVar.f10524e.put(b4.f10497a, b4);
                    break;
                }
                break;
            case 20:
                if (c3 == hVar.f10520a) {
                    hVar.h = a(jVar);
                    break;
                }
                break;
        }
        jVar.d(c5 - jVar.c());
    }

    private static C0175b a(j jVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        jVar.b(4);
        boolean d2 = jVar.d();
        jVar.b(3);
        int c2 = jVar.c(16);
        int c3 = jVar.c(16);
        if (d2) {
            int c4 = jVar.c(16);
            int c5 = jVar.c(16);
            int c6 = jVar.c(16);
            i2 = jVar.c(16);
            i4 = c5;
            i3 = c6;
            i5 = c4;
        } else {
            i4 = c2;
            i2 = c3;
            i5 = 0;
            i3 = 0;
        }
        return new C0175b(c2, c3, i5, i4, i3, i2);
    }

    private static d a(j jVar, int i2) {
        int c2 = jVar.c(8);
        int c3 = jVar.c(4);
        int c4 = jVar.c(2);
        jVar.b(2);
        int i3 = i2 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int c5 = jVar.c(8);
            jVar.b(8);
            i3 -= 6;
            sparseArray.put(c5, new e(jVar.c(16), jVar.c(16)));
        }
        return new d(c2, c3, c4, sparseArray);
    }

    private static f b(j jVar, int i2) {
        int i3;
        int i4;
        j jVar2 = jVar;
        int c2 = jVar2.c(8);
        jVar2.b(4);
        boolean d2 = jVar.d();
        jVar2.b(3);
        int i5 = 16;
        int c3 = jVar2.c(16);
        int c4 = jVar2.c(16);
        int c5 = jVar2.c(3);
        int c6 = jVar2.c(3);
        int i6 = 2;
        jVar2.b(2);
        int c7 = jVar2.c(8);
        int c8 = jVar2.c(8);
        int c9 = jVar2.c(4);
        int c10 = jVar2.c(2);
        jVar2.b(2);
        int i7 = i2 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i7 > 0) {
            int c11 = jVar2.c(i5);
            int c12 = jVar2.c(i6);
            int c13 = jVar2.c(i6);
            int c14 = jVar2.c(12);
            int i8 = c10;
            jVar2.b(4);
            int c15 = jVar2.c(12);
            i7 -= 6;
            if (c12 == 1 || c12 == 2) {
                i7 -= 2;
                i4 = jVar2.c(8);
                i3 = jVar2.c(8);
            } else {
                i4 = 0;
                i3 = 0;
            }
            sparseArray.put(c11, new g(c12, c13, c14, c15, i4, i3));
            c10 = i8;
            i6 = 2;
            i5 = 16;
        }
        return new f(c2, d2, c3, c4, c5, c6, c7, c8, c9, c10, sparseArray);
    }

    private static a c(j jVar, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        j jVar2 = jVar;
        int i8 = 8;
        int c2 = jVar2.c(8);
        jVar2.b(8);
        int i9 = 2;
        int i10 = i2 - 2;
        int[] b2 = b();
        int[] c3 = c();
        int[] d2 = d();
        while (i10 > 0) {
            int c4 = jVar2.c(i8);
            int c5 = jVar2.c(i8);
            int i11 = i10 - 2;
            int[] iArr = (c5 & 128) != 0 ? b2 : (c5 & 64) != 0 ? c3 : d2;
            if ((c5 & 1) != 0) {
                i6 = jVar2.c(i8);
                i5 = jVar2.c(i8);
                i4 = jVar2.c(i8);
                i3 = jVar2.c(i8);
                i7 = i11 - 4;
            } else {
                i4 = jVar2.c(4) << 4;
                i7 = i11 - 2;
                int c6 = jVar2.c(4) << 4;
                i3 = jVar2.c(i9) << 6;
                i6 = jVar2.c(6) << i9;
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
            iArr[c4] = a((byte) (255 - (i3 & 255)), t.a((int) (d3 + (1.402d * d4)), 0, 255), t.a((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 0, 255), t.a((int) (d3 + (d5 * 1.772d)), 0, 255));
            i10 = i7;
            c2 = c2;
            i8 = 8;
            i9 = 2;
        }
        return new a(c2, b2, c3, d2);
    }

    private static c b(j jVar) {
        byte[] bArr;
        int c2 = jVar.c(16);
        jVar.b(4);
        int c3 = jVar.c(2);
        boolean d2 = jVar.d();
        jVar.b(1);
        byte[] bArr2 = null;
        if (c3 == 1) {
            jVar.b(jVar.c(8) * 16);
        } else if (c3 == 0) {
            int c4 = jVar.c(16);
            int c5 = jVar.c(16);
            if (c4 > 0) {
                bArr2 = new byte[c4];
                jVar.a(bArr2, 0, c4);
            }
            if (c5 > 0) {
                bArr = new byte[c5];
                jVar.a(bArr, 0, c5);
                return new c(c2, d2, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(c2, d2, bArr2, bArr);
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
            iArr = aVar.f10490d;
        } else if (i2 == 2) {
            iArr = aVar.f10489c;
        } else {
            iArr = aVar.f10488b;
        }
        int[] iArr2 = iArr;
        int i5 = i2;
        int i6 = i3;
        Paint paint2 = paint;
        Canvas canvas2 = canvas;
        a(cVar.f10499c, iArr2, i5, i6, i4, paint2, canvas2);
        a(cVar.f10500d, iArr2, i5, i6, i4 + 1, paint2, canvas2);
    }

    private static void a(byte[] bArr, int[] iArr, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        byte[] bArr2;
        int a2;
        byte[] bArr3;
        byte[] bArr4;
        int i5 = i2;
        byte[] bArr5 = bArr;
        j jVar = new j(bArr);
        int i6 = i3;
        int i7 = i4;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        while (jVar.a() != 0) {
            int c2 = jVar.c(8);
            if (c2 != 240) {
                switch (c2) {
                    case 16:
                        if (i5 != 3) {
                            if (i5 != 2) {
                                bArr2 = null;
                                a2 = a(jVar, iArr, bArr2, i6, i7, paint, canvas);
                                jVar.e();
                                break;
                            } else {
                                bArr3 = bArr7 == null ? f10480a : bArr7;
                            }
                        } else {
                            bArr3 = bArr6 == null ? f10481b : bArr6;
                        }
                        bArr2 = bArr3;
                        a2 = a(jVar, iArr, bArr2, i6, i7, paint, canvas);
                        jVar.e();
                    case 17:
                        a2 = b(jVar, iArr, i5 == 3 ? f10482c : null, i6, i7, paint, canvas);
                        jVar.e();
                        break;
                    case 18:
                        a2 = c(jVar, iArr, (byte[]) null, i6, i7, paint, canvas);
                        break;
                    default:
                        switch (c2) {
                            case 32:
                                bArr7 = a(4, 4, jVar);
                                continue;
                            case 33:
                                bArr4 = a(4, 8, jVar);
                                break;
                            case 34:
                                bArr4 = a(16, 8, jVar);
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(com.google.android.exoplayer2.n.j r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
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
            boolean r5 = r13.d()
            r6 = 1
            if (r5 != 0) goto L_0x0019
            r12 = r2
            r3 = r4
            r11 = 1
            goto L_0x0063
        L_0x0019:
            boolean r4 = r13.d()
            r5 = 3
            if (r4 == 0) goto L_0x002c
            int r4 = r13.c(r5)
            int r4 = r4 + r5
            int r3 = r13.c(r3)
        L_0x0029:
            r12 = r2
            r11 = r4
            goto L_0x0063
        L_0x002c:
            boolean r4 = r13.d()
            if (r4 != 0) goto L_0x0060
            int r4 = r13.c(r3)
            if (r4 == 0) goto L_0x005c
            if (r4 == r6) goto L_0x0058
            if (r4 == r3) goto L_0x004c
            if (r4 == r5) goto L_0x003f
            goto L_0x0060
        L_0x003f:
            r4 = 8
            int r4 = r13.c(r4)
            int r4 = r4 + 29
            int r3 = r13.c(r3)
            goto L_0x0029
        L_0x004c:
            r4 = 4
            int r4 = r13.c(r4)
            int r4 = r4 + 12
            int r3 = r13.c(r3)
            goto L_0x0029
        L_0x0058:
            r12 = r2
            r3 = 0
            r11 = 2
            goto L_0x0063
        L_0x005c:
            r3 = 0
            r11 = 0
            r12 = 1
            goto L_0x0063
        L_0x0060:
            r12 = r2
            r3 = 0
            r11 = 0
        L_0x0063:
            if (r11 == 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            if (r15 == 0) goto L_0x006b
            byte r3 = r15[r3]
        L_0x006b:
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
        L_0x007f:
            int r10 = r10 + r11
            if (r12 == 0) goto L_0x0083
            return r10
        L_0x0083:
            r2 = r12
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.b.b.a(com.google.android.exoplayer2.n.j, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f A[LOOP:0: B:1:0x0009->B:33:0x008f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int b(com.google.android.exoplayer2.n.j r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
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
            boolean r4 = r13.d()
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
            boolean r4 = r13.d()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.b.b.b(com.google.android.exoplayer2.n.j, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int c(com.google.android.exoplayer2.n.j r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
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
            boolean r4 = r13.d()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.b.b.c(com.google.android.exoplayer2.n.j, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static byte[] a(int i2, int i3, j jVar) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) jVar.c(i3);
        }
        return bArr;
    }

    private static final class h {

        /* renamed from: a  reason: collision with root package name */
        public final int f10520a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10521b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseArray<f> f10522c = new SparseArray<>();

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<a> f10523d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<c> f10524e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        public final SparseArray<a> f10525f = new SparseArray<>();

        /* renamed from: g  reason: collision with root package name */
        public final SparseArray<c> f10526g = new SparseArray<>();
        public C0175b h;
        public d i;

        public h(int i2, int i3) {
            this.f10520a = i2;
            this.f10521b = i3;
        }

        public void a() {
            this.f10522c.clear();
            this.f10523d.clear();
            this.f10524e.clear();
            this.f10525f.clear();
            this.f10526g.clear();
            this.h = null;
            this.i = null;
        }
    }

    /* renamed from: com.google.android.exoplayer2.j.b.b$b  reason: collision with other inner class name */
    private static final class C0175b {

        /* renamed from: a  reason: collision with root package name */
        public final int f10491a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10492b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10493c;

        /* renamed from: d  reason: collision with root package name */
        public final int f10494d;

        /* renamed from: e  reason: collision with root package name */
        public final int f10495e;

        /* renamed from: f  reason: collision with root package name */
        public final int f10496f;

        public C0175b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f10491a = i;
            this.f10492b = i2;
            this.f10493c = i3;
            this.f10494d = i4;
            this.f10495e = i5;
            this.f10496f = i6;
        }
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f10501a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10502b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10503c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<e> f10504d;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.f10501a = i;
            this.f10502b = i2;
            this.f10503c = i3;
            this.f10504d = sparseArray;
        }
    }

    private static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f10505a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10506b;

        public e(int i, int i2) {
            this.f10505a = i;
            this.f10506b = i2;
        }
    }

    private static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final int f10507a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f10508b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10509c;

        /* renamed from: d  reason: collision with root package name */
        public final int f10510d;

        /* renamed from: e  reason: collision with root package name */
        public final int f10511e;

        /* renamed from: f  reason: collision with root package name */
        public final int f10512f;

        /* renamed from: g  reason: collision with root package name */
        public final int f10513g;
        public final int h;
        public final int i;
        public final int j;
        public final SparseArray<g> k;

        public f(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, SparseArray<g> sparseArray) {
            this.f10507a = i2;
            this.f10508b = z;
            this.f10509c = i3;
            this.f10510d = i4;
            this.f10511e = i5;
            this.f10512f = i6;
            this.f10513g = i7;
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
        public final int f10514a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10515b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10516c;

        /* renamed from: d  reason: collision with root package name */
        public final int f10517d;

        /* renamed from: e  reason: collision with root package name */
        public final int f10518e;

        /* renamed from: f  reason: collision with root package name */
        public final int f10519f;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f10514a = i;
            this.f10515b = i2;
            this.f10516c = i3;
            this.f10517d = i4;
            this.f10518e = i5;
            this.f10519f = i6;
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f10487a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f10488b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f10489c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f10490d;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f10487a = i;
            this.f10488b = iArr;
            this.f10489c = iArr2;
            this.f10490d = iArr3;
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f10497a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f10498b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f10499c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f10500d;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.f10497a = i;
            this.f10498b = z;
            this.f10499c = bArr;
            this.f10500d = bArr2;
        }
    }
}
