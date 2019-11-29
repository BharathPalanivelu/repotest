package androidx.j.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.SparseBooleanArray;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final C0058b f2378a = new C0058b() {
        public boolean a(int i, float[] fArr) {
            return !b(fArr) && !a(fArr) && !c(fArr);
        }

        private boolean a(float[] fArr) {
            return fArr[2] <= 0.05f;
        }

        private boolean b(float[] fArr) {
            return fArr[2] >= 0.95f;
        }

        private boolean c(float[] fArr) {
            return fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f2379b;

    /* renamed from: c  reason: collision with root package name */
    private final List<c> f2380c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<c, c> f2381d = new androidx.b.a();

    /* renamed from: e  reason: collision with root package name */
    private final SparseBooleanArray f2382e = new SparseBooleanArray();

    /* renamed from: f  reason: collision with root package name */
    private final c f2383f = b();

    /* renamed from: androidx.j.a.b$b  reason: collision with other inner class name */
    public interface C0058b {
        boolean a(int i, float[] fArr);
    }

    public static a a(Bitmap bitmap) {
        return new a(bitmap);
    }

    b(List<c> list, List<c> list2) {
        this.f2379b = list;
        this.f2380c = list2;
    }

    public int a(int i) {
        return a(c.f2399b, i);
    }

    public c a(c cVar) {
        return this.f2381d.get(cVar);
    }

    public int a(c cVar, int i) {
        c a2 = a(cVar);
        return a2 != null ? a2.a() : i;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int size = this.f2380c.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.f2380c.get(i);
            cVar.k();
            this.f2381d.put(cVar, b(cVar));
        }
        this.f2382e.clear();
    }

    private c b(c cVar) {
        c c2 = c(cVar);
        if (c2 != null && cVar.j()) {
            this.f2382e.append(c2.a(), true);
        }
        return c2;
    }

    private c c(c cVar) {
        int size = this.f2379b.size();
        float f2 = BitmapDescriptorFactory.HUE_RED;
        c cVar2 = null;
        for (int i = 0; i < size; i++) {
            c cVar3 = this.f2379b.get(i);
            if (a(cVar3, cVar)) {
                float b2 = b(cVar3, cVar);
                if (cVar2 == null || b2 > f2) {
                    cVar2 = cVar3;
                    f2 = b2;
                }
            }
        }
        return cVar2;
    }

    private boolean a(c cVar, c cVar2) {
        float[] b2 = cVar.b();
        if (b2[1] < cVar2.a() || b2[1] > cVar2.c() || b2[2] < cVar2.d() || b2[2] > cVar2.f() || this.f2382e.get(cVar.a())) {
            return false;
        }
        return true;
    }

    private float b(c cVar, c cVar2) {
        float[] b2 = cVar.b();
        c cVar3 = this.f2383f;
        int c2 = cVar3 != null ? cVar3.c() : 1;
        float g2 = cVar2.g();
        float f2 = BitmapDescriptorFactory.HUE_RED;
        float abs = g2 > BitmapDescriptorFactory.HUE_RED ? (1.0f - Math.abs(b2[1] - cVar2.b())) * cVar2.g() : BitmapDescriptorFactory.HUE_RED;
        float h = cVar2.h() > BitmapDescriptorFactory.HUE_RED ? cVar2.h() * (1.0f - Math.abs(b2[2] - cVar2.e())) : BitmapDescriptorFactory.HUE_RED;
        if (cVar2.i() > BitmapDescriptorFactory.HUE_RED) {
            f2 = cVar2.i() * (((float) cVar.c()) / ((float) c2));
        }
        return abs + h + f2;
    }

    private c b() {
        int size = this.f2379b.size();
        int i = RNCartPanelDataEntity.NULL_VALUE;
        c cVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar2 = this.f2379b.get(i2);
            if (cVar2.c() > i) {
                i = cVar2.c();
                cVar = cVar2;
            }
        }
        return cVar;
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final int f2391a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2392b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2393c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2394d;

        /* renamed from: e  reason: collision with root package name */
        private final int f2395e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2396f;

        /* renamed from: g  reason: collision with root package name */
        private int f2397g;
        private int h;
        private float[] i;

        public c(int i2, int i3) {
            this.f2391a = Color.red(i2);
            this.f2392b = Color.green(i2);
            this.f2393c = Color.blue(i2);
            this.f2394d = i2;
            this.f2395e = i3;
        }

        public int a() {
            return this.f2394d;
        }

        public float[] b() {
            if (this.i == null) {
                this.i = new float[3];
            }
            androidx.core.graphics.a.a(this.f2391a, this.f2392b, this.f2393c, this.i);
            return this.i;
        }

        public int c() {
            return this.f2395e;
        }

        public int d() {
            f();
            return this.f2397g;
        }

        public int e() {
            f();
            return this.h;
        }

        private void f() {
            int i2;
            int i3;
            if (!this.f2396f) {
                int a2 = androidx.core.graphics.a.a(-1, this.f2394d, 4.5f);
                int a3 = androidx.core.graphics.a.a(-1, this.f2394d, 3.0f);
                if (a2 == -1 || a3 == -1) {
                    int a4 = androidx.core.graphics.a.a(-16777216, this.f2394d, 4.5f);
                    int a5 = androidx.core.graphics.a.a(-16777216, this.f2394d, 3.0f);
                    if (a4 == -1 || a5 == -1) {
                        if (a2 != -1) {
                            i2 = androidx.core.graphics.a.c(-1, a2);
                        } else {
                            i2 = androidx.core.graphics.a.c(-16777216, a4);
                        }
                        this.h = i2;
                        if (a3 != -1) {
                            i3 = androidx.core.graphics.a.c(-1, a3);
                        } else {
                            i3 = androidx.core.graphics.a.c(-16777216, a5);
                        }
                        this.f2397g = i3;
                        this.f2396f = true;
                        return;
                    }
                    this.h = androidx.core.graphics.a.c(-16777216, a4);
                    this.f2397g = androidx.core.graphics.a.c(-16777216, a5);
                    this.f2396f = true;
                    return;
                }
                this.h = androidx.core.graphics.a.c(-1, a2);
                this.f2397g = androidx.core.graphics.a.c(-1, a3);
                this.f2396f = true;
            }
        }

        public String toString() {
            return getClass().getSimpleName() + " [RGB: #" + Integer.toHexString(a()) + ']' + " [HSL: " + Arrays.toString(b()) + ']' + " [Population: " + this.f2395e + ']' + " [Title Text: #" + Integer.toHexString(d()) + ']' + " [Body Text: #" + Integer.toHexString(e()) + ']';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f2395e == cVar.f2395e && this.f2394d == cVar.f2394d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f2394d * 31) + this.f2395e;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<c> f2384a;

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f2385b;

        /* renamed from: c  reason: collision with root package name */
        private final List<c> f2386c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private int f2387d = 16;

        /* renamed from: e  reason: collision with root package name */
        private int f2388e = 12544;

        /* renamed from: f  reason: collision with root package name */
        private int f2389f = -1;

        /* renamed from: g  reason: collision with root package name */
        private final List<C0058b> f2390g = new ArrayList();
        private Rect h;

        public a(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            this.f2390g.add(b.f2378a);
            this.f2385b = bitmap;
            this.f2384a = null;
            this.f2386c.add(c.f2398a);
            this.f2386c.add(c.f2399b);
            this.f2386c.add(c.f2400c);
            this.f2386c.add(c.f2401d);
            this.f2386c.add(c.f2402e);
            this.f2386c.add(c.f2403f);
        }

        public b a() {
            List<c> list;
            C0058b[] bVarArr;
            Bitmap bitmap = this.f2385b;
            if (bitmap != null) {
                Bitmap b2 = b(bitmap);
                Rect rect = this.h;
                if (!(b2 == this.f2385b || rect == null)) {
                    double width = (double) b2.getWidth();
                    double width2 = (double) this.f2385b.getWidth();
                    Double.isNaN(width);
                    Double.isNaN(width2);
                    double d2 = width / width2;
                    double d3 = (double) rect.left;
                    Double.isNaN(d3);
                    rect.left = (int) Math.floor(d3 * d2);
                    double d4 = (double) rect.top;
                    Double.isNaN(d4);
                    rect.top = (int) Math.floor(d4 * d2);
                    double d5 = (double) rect.right;
                    Double.isNaN(d5);
                    rect.right = Math.min((int) Math.ceil(d5 * d2), b2.getWidth());
                    double d6 = (double) rect.bottom;
                    Double.isNaN(d6);
                    rect.bottom = Math.min((int) Math.ceil(d6 * d2), b2.getHeight());
                }
                int[] a2 = a(b2);
                int i = this.f2387d;
                if (this.f2390g.isEmpty()) {
                    bVarArr = null;
                } else {
                    List<C0058b> list2 = this.f2390g;
                    bVarArr = (C0058b[]) list2.toArray(new C0058b[list2.size()]);
                }
                a aVar = new a(a2, i, bVarArr);
                if (b2 != this.f2385b) {
                    b2.recycle();
                }
                list = aVar.a();
            } else {
                list = this.f2384a;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            b bVar = new b(list, this.f2386c);
            bVar.a();
            return bVar;
        }

        private int[] a(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.h.height();
            int[] iArr2 = new int[(width2 * height2)];
            for (int i = 0; i < height2; i++) {
                System.arraycopy(iArr, ((this.h.top + i) * width) + this.h.left, iArr2, i * width2, width2);
            }
            return iArr2;
        }

        private Bitmap b(Bitmap bitmap) {
            double d2 = -1.0d;
            if (this.f2388e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i = this.f2388e;
                if (width > i) {
                    double d3 = (double) i;
                    double d4 = (double) width;
                    Double.isNaN(d3);
                    Double.isNaN(d4);
                    d2 = Math.sqrt(d3 / d4);
                }
            } else if (this.f2389f > 0) {
                int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
                int i2 = this.f2389f;
                if (max > i2) {
                    double d5 = (double) i2;
                    double d6 = (double) max;
                    Double.isNaN(d5);
                    Double.isNaN(d6);
                    d2 = d5 / d6;
                }
            }
            if (d2 <= 0.0d) {
                return bitmap;
            }
            double width2 = (double) bitmap.getWidth();
            Double.isNaN(width2);
            int ceil = (int) Math.ceil(width2 * d2);
            double height = (double) bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, ceil, (int) Math.ceil(height * d2), false);
        }
    }
}
