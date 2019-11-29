package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.a.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    boolean f2664a = false;

    /* renamed from: b  reason: collision with root package name */
    int f2665b = -1;

    /* renamed from: c  reason: collision with root package name */
    int[] f2666c;

    /* renamed from: d  reason: collision with root package name */
    View[] f2667d;

    /* renamed from: e  reason: collision with root package name */
    final SparseIntArray f2668e = new SparseIntArray();

    /* renamed from: f  reason: collision with root package name */
    final SparseIntArray f2669f = new SparseIntArray();

    /* renamed from: g  reason: collision with root package name */
    c f2670g = new a();
    final Rect h = new Rect();

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(a(context, attributeSet, i, i2).f2729b);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        a(i);
    }

    public void a(boolean z) {
        if (!z) {
            super.a(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public int a(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.i == 0) {
            return this.f2665b;
        }
        if (tVar.e() < 1) {
            return 0;
        }
        return a(pVar, tVar, tVar.e() - 1) + 1;
    }

    public int b(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.i == 1) {
            return this.f2665b;
        }
        if (tVar.e() < 1) {
            return 0;
        }
        return a(pVar, tVar, tVar.e() - 1) + 1;
    }

    public void a(RecyclerView.p pVar, RecyclerView.t tVar, View view, d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        int a2 = a(pVar, tVar, bVar.f());
        if (this.i == 0) {
            dVar.b((Object) d.c.a(bVar.a(), bVar.b(), a2, 1, this.f2665b > 1 && bVar.b() == this.f2665b, false));
        } else {
            dVar.b((Object) d.c.a(a2, 1, bVar.a(), bVar.b(), this.f2665b > 1 && bVar.b() == this.f2665b, false));
        }
    }

    public void c(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (tVar.a()) {
            P();
        }
        super.c(pVar, tVar);
        O();
    }

    public void a(RecyclerView.t tVar) {
        super.a(tVar);
        this.f2664a = false;
    }

    private void O() {
        this.f2668e.clear();
        this.f2669f.clear();
    }

    private void P() {
        int y = y();
        for (int i = 0; i < y; i++) {
            b bVar = (b) i(i).getLayoutParams();
            int f2 = bVar.f();
            this.f2668e.put(f2, bVar.b());
            this.f2669f.put(f2, bVar.a());
        }
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.f2670g.a();
    }

    public void a(RecyclerView recyclerView) {
        this.f2670g.a();
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        this.f2670g.a();
    }

    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f2670g.a();
    }

    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f2670g.a();
    }

    public RecyclerView.j a() {
        if (this.i == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    public RecyclerView.j a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public RecyclerView.j a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    public boolean a(RecyclerView.j jVar) {
        return jVar instanceof b;
    }

    public void a(c cVar) {
        this.f2670g = cVar;
    }

    private void Q() {
        int i;
        int i2;
        if (h() == 1) {
            i2 = B() - F();
            i = D();
        } else {
            i2 = C() - G();
            i = E();
        }
        m(i2 - i);
    }

    public void a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.f2666c == null) {
            super.a(rect, i, i2);
        }
        int D = D() + F();
        int E = E() + G();
        if (this.i == 1) {
            i4 = a(i2, rect.height() + E, K());
            int[] iArr = this.f2666c;
            i3 = a(i, iArr[iArr.length - 1] + D, J());
        } else {
            i3 = a(i, rect.width() + D, J());
            int[] iArr2 = this.f2666c;
            i4 = a(i2, iArr2[iArr2.length - 1] + E, K());
        }
        g(i3, i4);
    }

    private void m(int i) {
        this.f2666c = a(this.f2666c, this.f2665b, i);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public int a(int i, int i2) {
        if (this.i != 1 || !i()) {
            int[] iArr = this.f2666c;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.f2666c;
        int i3 = this.f2665b;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.p pVar, RecyclerView.t tVar, LinearLayoutManager.a aVar, int i) {
        super.a(pVar, tVar, aVar, i);
        Q();
        if (tVar.e() > 0 && !tVar.a()) {
            b(pVar, tVar, aVar, i);
        }
        R();
    }

    private void R() {
        View[] viewArr = this.f2667d;
        if (viewArr == null || viewArr.length != this.f2665b) {
            this.f2667d = new View[this.f2665b];
        }
    }

    public int a(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        Q();
        R();
        return super.a(i, pVar, tVar);
    }

    public int b(int i, RecyclerView.p pVar, RecyclerView.t tVar) {
        Q();
        R();
        return super.b(i, pVar, tVar);
    }

    private void b(RecyclerView.p pVar, RecyclerView.t tVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int b2 = b(pVar, tVar, aVar.f2686b);
        if (z) {
            while (b2 > 0 && aVar.f2686b > 0) {
                aVar.f2686b--;
                b2 = b(pVar, tVar, aVar.f2686b);
            }
            return;
        }
        int e2 = tVar.e() - 1;
        int i2 = aVar.f2686b;
        while (i2 < e2) {
            int i3 = i2 + 1;
            int b3 = b(pVar, tVar, i3);
            if (b3 <= b2) {
                break;
            }
            i2 = i3;
            b2 = b3;
        }
        aVar.f2686b = i2;
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.p pVar, RecyclerView.t tVar, int i, int i2, int i3) {
        j();
        int c2 = this.j.c();
        int d2 = this.j.d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View i5 = i(i);
            int d3 = d(i5);
            if (d3 >= 0 && d3 < i3 && b(pVar, tVar, d3) == 0) {
                if (((RecyclerView.j) i5.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view2 = i5;
                    }
                } else if (this.j.a(i5) < d2 && this.j.b(i5) >= c2) {
                    return i5;
                } else {
                    if (view == null) {
                        view = i5;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private int a(RecyclerView.p pVar, RecyclerView.t tVar, int i) {
        if (!tVar.a()) {
            return this.f2670g.c(i, this.f2665b);
        }
        int b2 = pVar.b(i);
        if (b2 != -1) {
            return this.f2670g.c(b2, this.f2665b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private int b(RecyclerView.p pVar, RecyclerView.t tVar, int i) {
        if (!tVar.a()) {
            return this.f2670g.b(i, this.f2665b);
        }
        int i2 = this.f2669f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b2 = pVar.b(i);
        if (b2 != -1) {
            return this.f2670g.b(b2, this.f2665b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int c(RecyclerView.p pVar, RecyclerView.t tVar, int i) {
        if (!tVar.a()) {
            return this.f2670g.a(i);
        }
        int i2 = this.f2668e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b2 = pVar.b(i);
        if (b2 != -1) {
            return this.f2670g.a(b2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.t tVar, LinearLayoutManager.c cVar, RecyclerView.i.a aVar) {
        int i = this.f2665b;
        for (int i2 = 0; i2 < this.f2665b && cVar.a(tVar) && i > 0; i2++) {
            int i3 = cVar.f2697d;
            aVar.b(i3, Math.max(0, cVar.f2700g));
            i -= this.f2670g.a(i3);
            cVar.f2697d += cVar.f2698e;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.p pVar, RecyclerView.t tVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        RecyclerView.p pVar2 = pVar;
        RecyclerView.t tVar2 = tVar;
        LinearLayoutManager.c cVar2 = cVar;
        LinearLayoutManager.b bVar2 = bVar;
        int i9 = this.j.i();
        boolean z2 = i9 != 1073741824;
        int i10 = y() > 0 ? this.f2666c[this.f2665b] : 0;
        if (z2) {
            Q();
        }
        boolean z3 = cVar2.f2698e == 1;
        int i11 = this.f2665b;
        if (!z3) {
            i11 = b(pVar2, tVar2, cVar2.f2697d) + c(pVar2, tVar2, cVar2.f2697d);
        }
        int i12 = 0;
        int i13 = 0;
        while (i13 < this.f2665b && cVar2.a(tVar2) && i11 > 0) {
            int i14 = cVar2.f2697d;
            int c2 = c(pVar2, tVar2, i14);
            if (c2 <= this.f2665b) {
                i11 -= c2;
                if (i11 < 0) {
                    break;
                }
                View a2 = cVar2.a(pVar2);
                if (a2 == null) {
                    break;
                }
                i12 += c2;
                this.f2667d[i13] = a2;
                i13++;
            } else {
                throw new IllegalArgumentException("Item at position " + i14 + " requires " + c2 + " spans but GridLayoutManager has only " + this.f2665b + " spans.");
            }
        }
        if (i13 == 0) {
            bVar2.f2691b = true;
            return;
        }
        float f2 = BitmapDescriptorFactory.HUE_RED;
        int i15 = i13;
        a(pVar, tVar, i13, i12, z3);
        int i16 = 0;
        for (int i17 = 0; i17 < i15; i17++) {
            View view = this.f2667d[i17];
            if (cVar2.k != null) {
                z = false;
                if (z3) {
                    a(view);
                } else {
                    a(view, 0);
                }
            } else if (z3) {
                b(view);
                z = false;
            } else {
                z = false;
                b(view, 0);
            }
            b(view, this.h);
            a(view, i9, z);
            int e2 = this.j.e(view);
            if (e2 > i16) {
                i16 = e2;
            }
            float f3 = (((float) this.j.f(view)) * 1.0f) / ((float) ((b) view.getLayoutParams()).f2672b);
            if (f3 > f2) {
                f2 = f3;
            }
        }
        if (z2) {
            a(f2, i10);
            i16 = 0;
            for (int i18 = 0; i18 < i15; i18++) {
                View view2 = this.f2667d[i18];
                a(view2, 1073741824, true);
                int e3 = this.j.e(view2);
                if (e3 > i16) {
                    i16 = e3;
                }
            }
        }
        for (int i19 = 0; i19 < i15; i19++) {
            View view3 = this.f2667d[i19];
            if (this.j.e(view3) != i16) {
                b bVar3 = (b) view3.getLayoutParams();
                Rect rect = bVar3.f2733d;
                int i20 = rect.top + rect.bottom + bVar3.topMargin + bVar3.bottomMargin;
                int i21 = rect.left + rect.right + bVar3.leftMargin + bVar3.rightMargin;
                int a3 = a(bVar3.f2671a, bVar3.f2672b);
                if (this.i == 1) {
                    i8 = a(a3, 1073741824, i21, bVar3.width, false);
                    i7 = View.MeasureSpec.makeMeasureSpec(i16 - i20, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16 - i21, 1073741824);
                    i7 = a(a3, 1073741824, i20, bVar3.height, false);
                    i8 = makeMeasureSpec;
                }
                a(view3, i8, i7, true);
            }
        }
        int i22 = 0;
        bVar2.f2690a = i16;
        if (this.i == 1) {
            if (cVar2.f2699f == -1) {
                int i23 = cVar2.f2695b;
                i = i23;
                i2 = i23 - i16;
            } else {
                int i24 = cVar2.f2695b;
                i2 = i24;
                i = i16 + i24;
            }
            i4 = 0;
            i3 = 0;
        } else if (cVar2.f2699f == -1) {
            int i25 = cVar2.f2695b;
            i2 = 0;
            i = 0;
            int i26 = i25 - i16;
            i3 = i25;
            i4 = i26;
        } else {
            i4 = cVar2.f2695b;
            i3 = i16 + i4;
            i2 = 0;
            i = 0;
        }
        while (i22 < i15) {
            View view4 = this.f2667d[i22];
            b bVar4 = (b) view4.getLayoutParams();
            if (this.i != 1) {
                i2 = E() + this.f2666c[bVar4.f2671a];
                i = this.j.f(view4) + i2;
            } else if (i()) {
                int D = D() + this.f2666c[this.f2665b - bVar4.f2671a];
                i5 = D;
                i6 = D - this.j.f(view4);
                int i27 = i2;
                int i28 = i;
                a(view4, i6, i27, i5, i28);
                if (!bVar4.d() || bVar4.e()) {
                    bVar2.f2692c = true;
                }
                bVar2.f2693d |= view4.hasFocusable();
                i22++;
                i4 = i6;
                i2 = i27;
                i3 = i5;
                i = i28;
            } else {
                i4 = D() + this.f2666c[bVar4.f2671a];
                i3 = this.j.f(view4) + i4;
            }
            i6 = i4;
            i5 = i3;
            int i272 = i2;
            int i282 = i;
            a(view4, i6, i272, i5, i282);
            if (!bVar4.d()) {
            }
            bVar2.f2692c = true;
            bVar2.f2693d |= view4.hasFocusable();
            i22++;
            i4 = i6;
            i2 = i272;
            i3 = i5;
            i = i282;
        }
        Arrays.fill(this.f2667d, (Object) null);
    }

    private void a(View view, int i, boolean z) {
        int i2;
        int i3;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f2733d;
        int i4 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i5 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int a2 = a(bVar.f2671a, bVar.f2672b);
        if (this.i == 1) {
            i2 = a(a2, i, i5, bVar.width, false);
            i3 = a(this.j.f(), A(), i4, bVar.height, true);
        } else {
            int a3 = a(a2, i, i4, bVar.height, false);
            int a4 = a(this.j.f(), z(), i5, bVar.width, true);
            i3 = a3;
            i2 = a4;
        }
        a(view, i2, i3, z);
    }

    private void a(float f2, int i) {
        m(Math.max(Math.round(f2 * ((float) this.f2665b)), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean z2;
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        if (z) {
            z2 = a(view, i, i2, jVar);
        } else {
            z2 = b(view, i, i2, jVar);
        }
        if (z2) {
            view.measure(i, i2);
        }
    }

    private void a(RecyclerView.p pVar, RecyclerView.t tVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z) {
            i6 = i;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = i - 1;
            i3 = -1;
        }
        while (i4 != i6) {
            View view = this.f2667d[i4];
            b bVar = (b) view.getLayoutParams();
            bVar.f2672b = c(pVar, tVar, d(view));
            bVar.f2671a = i5;
            i5 += bVar.f2672b;
            i4 += i3;
        }
    }

    public int b() {
        return this.f2665b;
    }

    public void a(int i) {
        if (i != this.f2665b) {
            this.f2664a = true;
            if (i >= 1) {
                this.f2665b = i;
                this.f2670g.a();
                r();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f2673a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        private boolean f2674b = false;

        public abstract int a(int i);

        public void a() {
            this.f2673a.clear();
        }

        /* access modifiers changed from: package-private */
        public int b(int i, int i2) {
            if (!this.f2674b) {
                return a(i, i2);
            }
            int i3 = this.f2673a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int a2 = a(i, i2);
            this.f2673a.put(i, a2);
            return a2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x003c A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.a(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.f2674b
                if (r2 == 0) goto L_0x0026
                android.util.SparseIntArray r2 = r5.f2673a
                int r2 = r2.size()
                if (r2 <= 0) goto L_0x0026
                int r2 = r5.b(r6)
                if (r2 < 0) goto L_0x0026
                android.util.SparseIntArray r3 = r5.f2673a
                int r3 = r3.get(r2)
                int r4 = r5.a(r2)
                int r3 = r3 + r4
                goto L_0x0036
            L_0x0026:
                r2 = 0
                r3 = 0
            L_0x0028:
                if (r2 >= r6) goto L_0x0039
                int r4 = r5.a(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x0033
                r3 = 0
                goto L_0x0036
            L_0x0033:
                if (r3 <= r7) goto L_0x0036
                r3 = r4
            L_0x0036:
                int r2 = r2 + 1
                goto L_0x0028
            L_0x0039:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x003d
                return r3
            L_0x003d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.a(int, int):int");
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            int size = this.f2673a.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f2673a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.f2673a.size()) {
                return -1;
            }
            return this.f2673a.keyAt(i4);
        }

        public int c(int i, int i2) {
            int a2 = a(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int a3 = a(i5);
                i3 += a3;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = a3;
                }
            }
            return i3 + a2 > i2 ? i4 + 1 : i4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d7, code lost:
        if (r13 == (r2 > r8)) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f7, code lost:
        if (r13 == r10) goto L_0x00bb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View a(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.p r25, androidx.recyclerview.widget.RecyclerView.t r26) {
        /*
            r22 = this;
            r0 = r22
            r1 = r25
            r2 = r26
            android.view.View r3 = r22.e((android.view.View) r23)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r5 = (androidx.recyclerview.widget.GridLayoutManager.b) r5
            int r6 = r5.f2671a
            int r7 = r5.f2671a
            int r5 = r5.f2672b
            int r7 = r7 + r5
            android.view.View r5 = super.a((android.view.View) r23, (int) r24, (androidx.recyclerview.widget.RecyclerView.p) r25, (androidx.recyclerview.widget.RecyclerView.t) r26)
            if (r5 != 0) goto L_0x0022
            return r4
        L_0x0022:
            r5 = r24
            int r5 = r0.f((int) r5)
            r9 = 1
            if (r5 != r9) goto L_0x002d
            r5 = 1
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            boolean r10 = r0.k
            if (r5 == r10) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0034:
            r5 = 0
        L_0x0035:
            r10 = -1
            if (r5 == 0) goto L_0x0040
            int r5 = r22.y()
            int r5 = r5 - r9
            r11 = -1
            r12 = -1
            goto L_0x0047
        L_0x0040:
            int r5 = r22.y()
            r11 = r5
            r5 = 0
            r12 = 1
        L_0x0047:
            int r13 = r0.i
            if (r13 != r9) goto L_0x0053
            boolean r13 = r22.i()
            if (r13 == 0) goto L_0x0053
            r13 = 1
            goto L_0x0054
        L_0x0053:
            r13 = 0
        L_0x0054:
            int r14 = r0.a((androidx.recyclerview.widget.RecyclerView.p) r1, (androidx.recyclerview.widget.RecyclerView.t) r2, (int) r5)
            r10 = r4
            r8 = -1
            r15 = 0
            r16 = 0
            r17 = -1
        L_0x005f:
            if (r5 == r11) goto L_0x0145
            int r9 = r0.a((androidx.recyclerview.widget.RecyclerView.p) r1, (androidx.recyclerview.widget.RecyclerView.t) r2, (int) r5)
            android.view.View r1 = r0.i((int) r5)
            if (r1 != r3) goto L_0x006d
            goto L_0x0145
        L_0x006d:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0087
            if (r9 == r14) goto L_0x0087
            if (r4 == 0) goto L_0x0079
            goto L_0x0145
        L_0x0079:
            r18 = r3
            r20 = r8
            r23 = r10
            r19 = r11
            r8 = r16
            r11 = r17
            goto L_0x0131
        L_0x0087:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r9 = (androidx.recyclerview.widget.GridLayoutManager.b) r9
            int r2 = r9.f2671a
            r18 = r3
            int r3 = r9.f2671a
            r19 = r11
            int r11 = r9.f2672b
            int r3 = r3 + r11
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00a3
            if (r2 != r6) goto L_0x00a3
            if (r3 != r7) goto L_0x00a3
            return r1
        L_0x00a3:
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00ab
            if (r4 == 0) goto L_0x00b3
        L_0x00ab:
            boolean r11 = r1.hasFocusable()
            if (r11 != 0) goto L_0x00bd
            if (r10 != 0) goto L_0x00bd
        L_0x00b3:
            r20 = r8
            r23 = r10
            r8 = r16
            r11 = r17
        L_0x00bb:
            r10 = 1
            goto L_0x0103
        L_0x00bd:
            int r11 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r7)
            int r11 = r20 - r11
            boolean r20 = r1.hasFocusable()
            if (r20 == 0) goto L_0x00da
            if (r11 <= r15) goto L_0x00d0
            goto L_0x00b3
        L_0x00d0:
            if (r11 != r15) goto L_0x00fa
            if (r2 <= r8) goto L_0x00d6
            r11 = 1
            goto L_0x00d7
        L_0x00d6:
            r11 = 0
        L_0x00d7:
            if (r13 != r11) goto L_0x00fa
            goto L_0x00b3
        L_0x00da:
            if (r4 != 0) goto L_0x00fa
            r20 = r8
            r23 = r10
            r8 = 0
            r10 = 1
            boolean r21 = r0.a((android.view.View) r1, (boolean) r8, (boolean) r10)
            if (r21 == 0) goto L_0x00fe
            r8 = r16
            if (r11 <= r8) goto L_0x00ef
            r11 = r17
            goto L_0x0103
        L_0x00ef:
            if (r11 != r8) goto L_0x0100
            r11 = r17
            if (r2 <= r11) goto L_0x00f6
            goto L_0x00f7
        L_0x00f6:
            r10 = 0
        L_0x00f7:
            if (r13 != r10) goto L_0x0102
            goto L_0x00bb
        L_0x00fa:
            r20 = r8
            r23 = r10
        L_0x00fe:
            r8 = r16
        L_0x0100:
            r11 = r17
        L_0x0102:
            r10 = 0
        L_0x0103:
            if (r10 == 0) goto L_0x0131
            boolean r10 = r1.hasFocusable()
            if (r10 == 0) goto L_0x0120
            int r4 = r9.f2671a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r10 = r23
            r15 = r3
            r16 = r8
            r17 = r11
            r8 = r4
            r4 = r1
            goto L_0x0139
        L_0x0120:
            int r8 = r9.f2671a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r10 = r1
            r16 = r3
            r17 = r8
            goto L_0x0137
        L_0x0131:
            r10 = r23
            r16 = r8
            r17 = r11
        L_0x0137:
            r8 = r20
        L_0x0139:
            int r5 = r5 + r12
            r1 = r25
            r2 = r26
            r3 = r18
            r11 = r19
            r9 = 1
            goto L_0x005f
        L_0x0145:
            r23 = r10
            if (r4 == 0) goto L_0x014a
            goto L_0x014c
        L_0x014a:
            r4 = r23
        L_0x014c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(android.view.View, int, androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$t):android.view.View");
    }

    public boolean c() {
        return this.n == null && !this.f2664a;
    }

    public static final class a extends c {
        public int a(int i) {
            return 1;
        }

        public int a(int i, int i2) {
            return i % i2;
        }
    }

    public static class b extends RecyclerView.j {

        /* renamed from: a  reason: collision with root package name */
        int f2671a = -1;

        /* renamed from: b  reason: collision with root package name */
        int f2672b = 0;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int a() {
            return this.f2671a;
        }

        public int b() {
            return this.f2672b;
        }
    }
}
