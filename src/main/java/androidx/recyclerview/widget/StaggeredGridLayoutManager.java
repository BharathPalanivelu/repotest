package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.g.a.d;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.i implements RecyclerView.s.b {
    private SavedState A;
    private int B;
    private final Rect C = new Rect();
    private final a D = new a();
    private boolean E = false;
    private boolean F = true;
    private int[] G;
    private final Runnable H = new Runnable() {
        public void run() {
            StaggeredGridLayoutManager.this.b();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    c[] f2778a;

    /* renamed from: b  reason: collision with root package name */
    p f2779b;

    /* renamed from: c  reason: collision with root package name */
    p f2780c;

    /* renamed from: d  reason: collision with root package name */
    boolean f2781d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f2782e = false;

    /* renamed from: f  reason: collision with root package name */
    int f2783f = -1;

    /* renamed from: g  reason: collision with root package name */
    int f2784g = RNCartPanelDataEntity.NULL_VALUE;
    LazySpanLookup h = new LazySpanLookup();
    private int i = -1;
    private int j;
    private int k;
    private final l l;
    private BitSet m;
    private int n = 2;
    private boolean o;
    private boolean z;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.i.b a2 = a(context, attributeSet, i2, i3);
        b(a2.f2728a);
        a(a2.f2729b);
        a(a2.f2730c);
        this.l = new l();
        P();
    }

    public boolean d() {
        return this.n != 0;
    }

    private void P() {
        this.f2779b = p.a(this, this.j);
        this.f2780c = p.a(this, 1 - this.j);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        int i2;
        int i3;
        if (y() == 0 || this.n == 0 || !t()) {
            return false;
        }
        if (this.f2782e) {
            i3 = p();
            i2 = q();
        } else {
            i3 = q();
            i2 = p();
        }
        if (i3 == 0 && h() != null) {
            this.h.a();
            M();
            r();
            return true;
        } else if (!this.E) {
            return false;
        } else {
            int i4 = this.f2782e ? -1 : 1;
            int i5 = i2 + 1;
            LazySpanLookup.FullSpanItem a2 = this.h.a(i3, i5, i4, true);
            if (a2 == null) {
                this.E = false;
                this.h.a(i5);
                return false;
            }
            LazySpanLookup.FullSpanItem a3 = this.h.a(i3, a2.f2788a, i4 * -1, true);
            if (a3 == null) {
                this.h.a(a2.f2788a);
            } else {
                this.h.a(a3.f2788a + 1);
            }
            M();
            r();
            return true;
        }
    }

    public void l(int i2) {
        if (i2 == 0) {
            b();
        }
    }

    public void a(RecyclerView recyclerView, RecyclerView.p pVar) {
        super.a(recyclerView, pVar);
        a(this.H);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.f2778a[i2].e();
        }
        recyclerView.requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View h() {
        /*
            r12 = this;
            int r0 = r12.y()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.i
            r2.<init>(r3)
            int r3 = r12.i
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.j
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.k()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.f2782e
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.i((int) r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f2806a
            int r9 = r9.f2812e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f2806a
            boolean r9 = r12.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f2806a
            int r9 = r9.f2812e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f2807b
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.i((int) r9)
            boolean r10 = r12.f2782e
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.p r10 = r12.f2779b
            int r10 = r10.b((android.view.View) r7)
            androidx.recyclerview.widget.p r11 = r12.f2779b
            int r11 = r11.b((android.view.View) r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.p r10 = r12.f2779b
            int r10 = r10.a((android.view.View) r7)
            androidx.recyclerview.widget.p r11 = r12.f2779b
            int r11 = r11.a((android.view.View) r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = 1
            goto L_0x008b
        L_0x008a:
            r10 = 0
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r8.f2806a
            int r8 = r8.f2812e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r9.f2806a
            int r9 = r9.f2812e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.h():android.view.View");
    }

    private boolean a(c cVar) {
        if (this.f2782e) {
            if (cVar.d() < this.f2779b.d()) {
                return !cVar.c(cVar.f2808a.get(cVar.f2808a.size() - 1)).f2807b;
            }
        } else if (cVar.b() > this.f2779b.c()) {
            return !cVar.c(cVar.f2808a.get(0)).f2807b;
        }
        return false;
    }

    public void a(int i2) {
        a((String) null);
        if (i2 != this.i) {
            j();
            this.i = i2;
            this.m = new BitSet(this.i);
            this.f2778a = new c[this.i];
            for (int i3 = 0; i3 < this.i; i3++) {
                this.f2778a[i3] = new c(i3);
            }
            r();
        }
    }

    public void b(int i2) {
        if (i2 == 0 || i2 == 1) {
            a((String) null);
            if (i2 != this.j) {
                this.j = i2;
                p pVar = this.f2779b;
                this.f2779b = this.f2780c;
                this.f2780c = pVar;
                r();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void a(boolean z2) {
        a((String) null);
        SavedState savedState = this.A;
        if (!(savedState == null || savedState.h == z2)) {
            this.A.h = z2;
        }
        this.f2781d = z2;
        r();
    }

    public void a(String str) {
        if (this.A == null) {
            super.a(str);
        }
    }

    public int i() {
        return this.i;
    }

    public void j() {
        this.h.a();
        r();
    }

    private void Q() {
        if (this.j == 1 || !k()) {
            this.f2782e = this.f2781d;
        } else {
            this.f2782e = !this.f2781d;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return w() == 1;
    }

    public void a(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        int D2 = D() + F();
        int E2 = E() + G();
        if (this.j == 1) {
            i5 = a(i3, rect.height() + E2, K());
            i4 = a(i2, (this.k * this.i) + D2, J());
        } else {
            i4 = a(i2, rect.width() + D2, J());
            i5 = a(i3, (this.k * this.i) + E2, K());
        }
        g(i4, i5);
    }

    public void c(RecyclerView.p pVar, RecyclerView.t tVar) {
        a(pVar, tVar, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0161, code lost:
        if (b() != false) goto L_0x0165;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(androidx.recyclerview.widget.RecyclerView.p r9, androidx.recyclerview.widget.RecyclerView.t r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r0 = r8.D
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.A
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.f2783f
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.e()
            if (r1 != 0) goto L_0x0018
            r8.c((androidx.recyclerview.widget.RecyclerView.p) r9)
            r0.a()
            return
        L_0x0018:
            boolean r1 = r0.f2803e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.f2783f
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.A
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.a()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.A
            if (r5 == 0) goto L_0x0037
            r8.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.a) r0)
            goto L_0x003e
        L_0x0037:
            r8.Q()
            boolean r5 = r8.f2782e
            r0.f2801c = r5
        L_0x003e:
            r8.a((androidx.recyclerview.widget.RecyclerView.t) r10, (androidx.recyclerview.widget.StaggeredGridLayoutManager.a) r0)
            r0.f2803e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.A
            if (r5 != 0) goto L_0x0060
            int r5 = r8.f2783f
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f2801c
            boolean r6 = r8.o
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.k()
            boolean r6 = r8.z
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.h
            r5.a()
            r0.f2802d = r4
        L_0x0060:
            int r5 = r8.y()
            if (r5 <= 0) goto L_0x00cb
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.A
            if (r5 == 0) goto L_0x006e
            int r5 = r5.f2794c
            if (r5 >= r4) goto L_0x00cb
        L_0x006e:
            boolean r5 = r0.f2802d
            if (r5 == 0) goto L_0x0090
            r1 = 0
        L_0x0073:
            int r5 = r8.i
            if (r1 >= r5) goto L_0x00cb
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f2778a
            r5 = r5[r1]
            r5.e()
            int r5 = r0.f2800b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008d
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f2778a
            r5 = r5[r1]
            int r6 = r0.f2800b
            r5.c((int) r6)
        L_0x008d:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x0090:
            if (r1 != 0) goto L_0x00b1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.D
            int[] r1 = r1.f2804f
            if (r1 != 0) goto L_0x0099
            goto L_0x00b1
        L_0x0099:
            r1 = 0
        L_0x009a:
            int r5 = r8.i
            if (r1 >= r5) goto L_0x00cb
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f2778a
            r5 = r5[r1]
            r5.e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r6 = r8.D
            int[] r6 = r6.f2804f
            r6 = r6[r1]
            r5.c((int) r6)
            int r1 = r1 + 1
            goto L_0x009a
        L_0x00b1:
            r1 = 0
        L_0x00b2:
            int r5 = r8.i
            if (r1 >= r5) goto L_0x00c4
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f2778a
            r5 = r5[r1]
            boolean r6 = r8.f2782e
            int r7 = r0.f2800b
            r5.a((boolean) r6, (int) r7)
            int r1 = r1 + 1
            goto L_0x00b2
        L_0x00c4:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.D
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f2778a
            r1.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.c[]) r5)
        L_0x00cb:
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9)
            androidx.recyclerview.widget.l r1 = r8.l
            r1.f2951a = r3
            r8.E = r3
            androidx.recyclerview.widget.p r1 = r8.f2780c
            int r1 = r1.f()
            r8.f((int) r1)
            int r1 = r0.f2799a
            r8.b((int) r1, (androidx.recyclerview.widget.RecyclerView.t) r10)
            boolean r1 = r0.f2801c
            if (r1 == 0) goto L_0x0102
            r8.m(r2)
            androidx.recyclerview.widget.l r1 = r8.l
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.l) r1, (androidx.recyclerview.widget.RecyclerView.t) r10)
            r8.m(r4)
            androidx.recyclerview.widget.l r1 = r8.l
            int r2 = r0.f2799a
            androidx.recyclerview.widget.l r5 = r8.l
            int r5 = r5.f2954d
            int r2 = r2 + r5
            r1.f2953c = r2
            androidx.recyclerview.widget.l r1 = r8.l
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.l) r1, (androidx.recyclerview.widget.RecyclerView.t) r10)
            goto L_0x011d
        L_0x0102:
            r8.m(r4)
            androidx.recyclerview.widget.l r1 = r8.l
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.l) r1, (androidx.recyclerview.widget.RecyclerView.t) r10)
            r8.m(r2)
            androidx.recyclerview.widget.l r1 = r8.l
            int r2 = r0.f2799a
            androidx.recyclerview.widget.l r5 = r8.l
            int r5 = r5.f2954d
            int r2 = r2 + r5
            r1.f2953c = r2
            androidx.recyclerview.widget.l r1 = r8.l
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.l) r1, (androidx.recyclerview.widget.RecyclerView.t) r10)
        L_0x011d:
            r8.R()
            int r1 = r8.y()
            if (r1 <= 0) goto L_0x0137
            boolean r1 = r8.f2782e
            if (r1 == 0) goto L_0x0131
            r8.b((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.RecyclerView.t) r10, (boolean) r4)
            r8.c((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.RecyclerView.t) r10, (boolean) r3)
            goto L_0x0137
        L_0x0131:
            r8.c((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.RecyclerView.t) r10, (boolean) r4)
            r8.b((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.RecyclerView.t) r10, (boolean) r3)
        L_0x0137:
            if (r11 == 0) goto L_0x0164
            boolean r11 = r10.a()
            if (r11 != 0) goto L_0x0164
            int r11 = r8.n
            if (r11 == 0) goto L_0x0155
            int r11 = r8.y()
            if (r11 <= 0) goto L_0x0155
            boolean r11 = r8.E
            if (r11 != 0) goto L_0x0153
            android.view.View r11 = r8.h()
            if (r11 == 0) goto L_0x0155
        L_0x0153:
            r11 = 1
            goto L_0x0156
        L_0x0155:
            r11 = 0
        L_0x0156:
            if (r11 == 0) goto L_0x0164
            java.lang.Runnable r11 = r8.H
            r8.a((java.lang.Runnable) r11)
            boolean r11 = r8.b()
            if (r11 == 0) goto L_0x0164
            goto L_0x0165
        L_0x0164:
            r4 = 0
        L_0x0165:
            boolean r11 = r10.a()
            if (r11 == 0) goto L_0x0170
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.D
            r11.a()
        L_0x0170:
            boolean r11 = r0.f2801c
            r8.o = r11
            boolean r11 = r8.k()
            r8.z = r11
            if (r4 == 0) goto L_0x0184
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.D
            r11.a()
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.RecyclerView.t) r10, (boolean) r3)
        L_0x0184:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$t, boolean):void");
    }

    public void a(RecyclerView.t tVar) {
        super.a(tVar);
        this.f2783f = -1;
        this.f2784g = RNCartPanelDataEntity.NULL_VALUE;
        this.A = null;
        this.D.a();
    }

    private void R() {
        if (this.f2780c.h() != 1073741824) {
            int y = y();
            float f2 = BitmapDescriptorFactory.HUE_RED;
            for (int i2 = 0; i2 < y; i2++) {
                View i3 = i(i2);
                float e2 = (float) this.f2780c.e(i3);
                if (e2 >= f2) {
                    if (((b) i3.getLayoutParams()).a()) {
                        e2 = (e2 * 1.0f) / ((float) this.i);
                    }
                    f2 = Math.max(f2, e2);
                }
            }
            int i4 = this.k;
            int round = Math.round(f2 * ((float) this.i));
            if (this.f2780c.h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f2780c.f());
            }
            f(round);
            if (this.k != i4) {
                for (int i5 = 0; i5 < y; i5++) {
                    View i6 = i(i5);
                    b bVar = (b) i6.getLayoutParams();
                    if (!bVar.f2807b) {
                        if (!k() || this.j != 1) {
                            int i7 = bVar.f2806a.f2812e * this.k;
                            int i8 = bVar.f2806a.f2812e * i4;
                            if (this.j == 1) {
                                i6.offsetLeftAndRight(i7 - i8);
                            } else {
                                i6.offsetTopAndBottom(i7 - i8);
                            }
                        } else {
                            i6.offsetLeftAndRight(((-((this.i - 1) - bVar.f2806a.f2812e)) * this.k) - ((-((this.i - 1) - bVar.f2806a.f2812e)) * i4));
                        }
                    }
                }
            }
        }
    }

    private void a(a aVar) {
        int i2;
        if (this.A.f2794c > 0) {
            if (this.A.f2794c == this.i) {
                for (int i3 = 0; i3 < this.i; i3++) {
                    this.f2778a[i3].e();
                    int i4 = this.A.f2795d[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        if (this.A.i) {
                            i2 = this.f2779b.d();
                        } else {
                            i2 = this.f2779b.c();
                        }
                        i4 += i2;
                    }
                    this.f2778a[i3].c(i4);
                }
            } else {
                this.A.a();
                SavedState savedState = this.A;
                savedState.f2792a = savedState.f2793b;
            }
        }
        this.z = this.A.j;
        a(this.A.h);
        Q();
        if (this.A.f2792a != -1) {
            this.f2783f = this.A.f2792a;
            aVar.f2801c = this.A.i;
        } else {
            aVar.f2801c = this.f2782e;
        }
        if (this.A.f2796e > 1) {
            this.h.f2786a = this.A.f2797f;
            this.h.f2787b = this.A.f2798g;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.t tVar, a aVar) {
        if (!b(tVar, aVar) && !c(tVar, aVar)) {
            aVar.b();
            aVar.f2799a = 0;
        }
    }

    private boolean c(RecyclerView.t tVar, a aVar) {
        int i2;
        if (this.o) {
            i2 = w(tVar.e());
        } else {
            i2 = v(tVar.e());
        }
        aVar.f2799a = i2;
        aVar.f2800b = RNCartPanelDataEntity.NULL_VALUE;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean b(RecyclerView.t tVar, a aVar) {
        int i2;
        int i3;
        boolean z2 = false;
        if (!tVar.a()) {
            int i4 = this.f2783f;
            if (i4 != -1) {
                if (i4 < 0 || i4 >= tVar.e()) {
                    this.f2783f = -1;
                    this.f2784g = RNCartPanelDataEntity.NULL_VALUE;
                } else {
                    SavedState savedState = this.A;
                    if (savedState == null || savedState.f2792a == -1 || this.A.f2794c < 1) {
                        View c2 = c(this.f2783f);
                        if (c2 != null) {
                            if (this.f2782e) {
                                i2 = p();
                            } else {
                                i2 = q();
                            }
                            aVar.f2799a = i2;
                            if (this.f2784g != Integer.MIN_VALUE) {
                                if (aVar.f2801c) {
                                    aVar.f2800b = (this.f2779b.d() - this.f2784g) - this.f2779b.b(c2);
                                } else {
                                    aVar.f2800b = (this.f2779b.c() + this.f2784g) - this.f2779b.a(c2);
                                }
                                return true;
                            } else if (this.f2779b.e(c2) > this.f2779b.f()) {
                                if (aVar.f2801c) {
                                    i3 = this.f2779b.d();
                                } else {
                                    i3 = this.f2779b.c();
                                }
                                aVar.f2800b = i3;
                                return true;
                            } else {
                                int a2 = this.f2779b.a(c2) - this.f2779b.c();
                                if (a2 < 0) {
                                    aVar.f2800b = -a2;
                                    return true;
                                }
                                int d2 = this.f2779b.d() - this.f2779b.b(c2);
                                if (d2 < 0) {
                                    aVar.f2800b = d2;
                                    return true;
                                }
                                aVar.f2800b = RNCartPanelDataEntity.NULL_VALUE;
                            }
                        } else {
                            aVar.f2799a = this.f2783f;
                            int i5 = this.f2784g;
                            if (i5 == Integer.MIN_VALUE) {
                                if (u(aVar.f2799a) == 1) {
                                    z2 = true;
                                }
                                aVar.f2801c = z2;
                                aVar.b();
                            } else {
                                aVar.a(i5);
                            }
                            aVar.f2802d = true;
                        }
                    } else {
                        aVar.f2800b = RNCartPanelDataEntity.NULL_VALUE;
                        aVar.f2799a = this.f2783f;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) {
        this.k = i2 / this.i;
        this.B = View.MeasureSpec.makeMeasureSpec(i2, this.f2780c.h());
    }

    public boolean c() {
        return this.A == null;
    }

    public int[] a(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.i];
        } else if (iArr.length < this.i) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.i + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.i; i2++) {
            iArr[i2] = this.f2778a[i2].j();
        }
        return iArr;
    }

    public int[] b(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.i];
        } else if (iArr.length < this.i) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.i + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.i; i2++) {
            iArr[i2] = this.f2778a[i2].l();
        }
        return iArr;
    }

    public int[] c(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.i];
        } else if (iArr.length < this.i) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.i + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.i; i2++) {
            iArr[i2] = this.f2778a[i2].n();
        }
        return iArr;
    }

    public int c(RecyclerView.t tVar) {
        return b(tVar);
    }

    private int b(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        return r.a(tVar, this.f2779b, b(!this.F), d(!this.F), this, this.F, this.f2782e);
    }

    public int d(RecyclerView.t tVar) {
        return b(tVar);
    }

    public int e(RecyclerView.t tVar) {
        return i(tVar);
    }

    private int i(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        return r.a(tVar, this.f2779b, b(!this.F), d(!this.F), this, this.F);
    }

    public int f(RecyclerView.t tVar) {
        return i(tVar);
    }

    public int g(RecyclerView.t tVar) {
        return j(tVar);
    }

    private int j(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        return r.b(tVar, this.f2779b, b(!this.F), d(!this.F), this, this.F);
    }

    public int h(RecyclerView.t tVar) {
        return j(tVar);
    }

    private void a(View view, b bVar, boolean z2) {
        if (bVar.f2807b) {
            if (this.j == 1) {
                a(view, this.B, a(C(), A(), E() + G(), bVar.height, true), z2);
            } else {
                a(view, a(B(), z(), D() + F(), bVar.width, true), this.B, z2);
            }
        } else if (this.j == 1) {
            a(view, a(this.k, z(), 0, bVar.width, false), a(C(), A(), E() + G(), bVar.height, true), z2);
        } else {
            a(view, a(B(), z(), D() + F(), bVar.width, true), a(this.k, A(), 0, bVar.height, false), z2);
        }
    }

    private void a(View view, int i2, int i3, boolean z2) {
        boolean z3;
        b(view, this.C);
        b bVar = (b) view.getLayoutParams();
        int b2 = b(i2, bVar.leftMargin + this.C.left, bVar.rightMargin + this.C.right);
        int b3 = b(i3, bVar.topMargin + this.C.top, bVar.bottomMargin + this.C.bottom);
        if (z2) {
            z3 = a(view, b2, b3, (RecyclerView.j) bVar);
        } else {
            z3 = b(view, b2, b3, (RecyclerView.j) bVar);
        }
        if (z3) {
            view.measure(b2, b3);
        }
    }

    private int b(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode);
        }
        return i2;
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.A = (SavedState) parcelable;
            r();
        }
    }

    public Parcelable e() {
        int i2;
        int i3;
        int i4;
        SavedState savedState = this.A;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.h = this.f2781d;
        savedState2.i = this.o;
        savedState2.j = this.z;
        LazySpanLookup lazySpanLookup = this.h;
        if (lazySpanLookup == null || lazySpanLookup.f2786a == null) {
            savedState2.f2796e = 0;
        } else {
            savedState2.f2797f = this.h.f2786a;
            savedState2.f2796e = savedState2.f2797f.length;
            savedState2.f2798g = this.h.f2787b;
        }
        if (y() > 0) {
            if (this.o) {
                i2 = p();
            } else {
                i2 = q();
            }
            savedState2.f2792a = i2;
            savedState2.f2793b = l();
            int i5 = this.i;
            savedState2.f2794c = i5;
            savedState2.f2795d = new int[i5];
            for (int i6 = 0; i6 < this.i; i6++) {
                if (this.o) {
                    i3 = this.f2778a[i6].b((int) RNCartPanelDataEntity.NULL_VALUE);
                    if (i3 != Integer.MIN_VALUE) {
                        i4 = this.f2779b.d();
                    } else {
                        savedState2.f2795d[i6] = i3;
                    }
                } else {
                    i3 = this.f2778a[i6].a((int) RNCartPanelDataEntity.NULL_VALUE);
                    if (i3 != Integer.MIN_VALUE) {
                        i4 = this.f2779b.c();
                    } else {
                        savedState2.f2795d[i6] = i3;
                    }
                }
                i3 -= i4;
                savedState2.f2795d[i6] = i3;
            }
        } else {
            savedState2.f2792a = -1;
            savedState2.f2793b = -1;
            savedState2.f2794c = 0;
        }
        return savedState2;
    }

    public void a(RecyclerView.p pVar, RecyclerView.t tVar, View view, d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        if (this.j == 0) {
            dVar.b((Object) d.c.a(bVar.b(), bVar.f2807b ? this.i : 1, -1, -1, bVar.f2807b, false));
        } else {
            dVar.b((Object) d.c.a(-1, -1, bVar.b(), bVar.f2807b ? this.i : 1, bVar.f2807b, false));
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (y() > 0) {
            View b2 = b(false);
            View d2 = d(false);
            if (b2 != null && d2 != null) {
                int d3 = d(b2);
                int d4 = d(d2);
                if (d3 < d4) {
                    accessibilityEvent.setFromIndex(d3);
                    accessibilityEvent.setToIndex(d4);
                    return;
                }
                accessibilityEvent.setFromIndex(d4);
                accessibilityEvent.setToIndex(d3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int l() {
        View view;
        if (this.f2782e) {
            view = d(true);
        } else {
            view = b(true);
        }
        if (view == null) {
            return -1;
        }
        return d(view);
    }

    public int a(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.j == 0) {
            return this.i;
        }
        return super.a(pVar, tVar);
    }

    public int b(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.j == 1) {
            return this.i;
        }
        return super.b(pVar, tVar);
    }

    /* access modifiers changed from: package-private */
    public View b(boolean z2) {
        int c2 = this.f2779b.c();
        int d2 = this.f2779b.d();
        int y = y();
        View view = null;
        for (int i2 = 0; i2 < y; i2++) {
            View i3 = i(i2);
            int a2 = this.f2779b.a(i3);
            if (this.f2779b.b(i3) > c2 && a2 < d2) {
                if (a2 >= c2 || !z2) {
                    return i3;
                }
                if (view == null) {
                    view = i3;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public View d(boolean z2) {
        int c2 = this.f2779b.c();
        int d2 = this.f2779b.d();
        View view = null;
        for (int y = y() - 1; y >= 0; y--) {
            View i2 = i(y);
            int a2 = this.f2779b.a(i2);
            int b2 = this.f2779b.b(i2);
            if (b2 > c2 && a2 < d2) {
                if (b2 <= d2 || !z2) {
                    return i2;
                }
                if (view == null) {
                    view = i2;
                }
            }
        }
        return view;
    }

    private void b(RecyclerView.p pVar, RecyclerView.t tVar, boolean z2) {
        int r = r(RNCartPanelDataEntity.NULL_VALUE);
        if (r != Integer.MIN_VALUE) {
            int d2 = this.f2779b.d() - r;
            if (d2 > 0) {
                int i2 = d2 - (-c(-d2, pVar, tVar));
                if (z2 && i2 > 0) {
                    this.f2779b.a(i2);
                }
            }
        }
    }

    private void c(RecyclerView.p pVar, RecyclerView.t tVar, boolean z2) {
        int q = q(Integer.MAX_VALUE);
        if (q != Integer.MAX_VALUE) {
            int c2 = q - this.f2779b.c();
            if (c2 > 0) {
                int c3 = c2 - c(c2, pVar, tVar);
                if (z2 && c3 > 0) {
                    this.f2779b.a(-c3);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r5, androidx.recyclerview.widget.RecyclerView.t r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.l r0 = r4.l
            r1 = 0
            r0.f2952b = r1
            r0.f2953c = r5
            boolean r0 = r4.v()
            r2 = 1
            if (r0 == 0) goto L_0x002e
            int r6 = r6.c()
            r0 = -1
            if (r6 == r0) goto L_0x002e
            boolean r0 = r4.f2782e
            if (r6 >= r5) goto L_0x001b
            r5 = 1
            goto L_0x001c
        L_0x001b:
            r5 = 0
        L_0x001c:
            if (r0 != r5) goto L_0x0025
            androidx.recyclerview.widget.p r5 = r4.f2779b
            int r5 = r5.f()
            goto L_0x002f
        L_0x0025:
            androidx.recyclerview.widget.p r5 = r4.f2779b
            int r5 = r5.f()
            r6 = r5
            r5 = 0
            goto L_0x0030
        L_0x002e:
            r5 = 0
        L_0x002f:
            r6 = 0
        L_0x0030:
            boolean r0 = r4.u()
            if (r0 == 0) goto L_0x004d
            androidx.recyclerview.widget.l r0 = r4.l
            androidx.recyclerview.widget.p r3 = r4.f2779b
            int r3 = r3.c()
            int r3 = r3 - r6
            r0.f2956f = r3
            androidx.recyclerview.widget.l r6 = r4.l
            androidx.recyclerview.widget.p r0 = r4.f2779b
            int r0 = r0.d()
            int r0 = r0 + r5
            r6.f2957g = r0
            goto L_0x005d
        L_0x004d:
            androidx.recyclerview.widget.l r0 = r4.l
            androidx.recyclerview.widget.p r3 = r4.f2779b
            int r3 = r3.e()
            int r3 = r3 + r5
            r0.f2957g = r3
            androidx.recyclerview.widget.l r5 = r4.l
            int r6 = -r6
            r5.f2956f = r6
        L_0x005d:
            androidx.recyclerview.widget.l r5 = r4.l
            r5.h = r1
            r5.f2951a = r2
            androidx.recyclerview.widget.p r6 = r4.f2779b
            int r6 = r6.h()
            if (r6 != 0) goto L_0x0074
            androidx.recyclerview.widget.p r6 = r4.f2779b
            int r6 = r6.e()
            if (r6 != 0) goto L_0x0074
            r1 = 1
        L_0x0074:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, androidx.recyclerview.widget.RecyclerView$t):void");
    }

    private void m(int i2) {
        l lVar = this.l;
        lVar.f2955e = i2;
        int i3 = 1;
        if (this.f2782e != (i2 == -1)) {
            i3 = -1;
        }
        lVar.f2954d = i3;
    }

    public void j(int i2) {
        super.j(i2);
        for (int i3 = 0; i3 < this.i; i3++) {
            this.f2778a[i3].d(i2);
        }
    }

    public void k(int i2) {
        super.k(i2);
        for (int i3 = 0; i3 < this.i; i3++) {
            this.f2778a[i3].d(i2);
        }
    }

    public void b(RecyclerView recyclerView, int i2, int i3) {
        c(i2, i3, 2);
    }

    public void a(RecyclerView recyclerView, int i2, int i3) {
        c(i2, i3, 1);
    }

    public void a(RecyclerView recyclerView) {
        this.h.a();
        r();
    }

    public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        c(i2, i3, 8);
    }

    public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
        c(i2, i3, 4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f2782e
            if (r0 == 0) goto L_0x0009
            int r0 = r6.p()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.q()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001b
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001d
        L_0x0016:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L_0x001f
        L_0x001b:
            int r2 = r7 + r8
        L_0x001d:
            r3 = r2
            r2 = r7
        L_0x001f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.h
            r4.b(r2)
            r4 = 1
            if (r9 == r4) goto L_0x003e
            r5 = 2
            if (r9 == r5) goto L_0x0038
            if (r9 == r1) goto L_0x002d
            goto L_0x0043
        L_0x002d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.h
            r9.a((int) r7, (int) r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.h
            r7.b(r8, r4)
            goto L_0x0043
        L_0x0038:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.h
            r9.a((int) r7, (int) r8)
            goto L_0x0043
        L_0x003e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.h
            r9.b(r7, r8)
        L_0x0043:
            if (r3 > r0) goto L_0x0046
            return
        L_0x0046:
            boolean r7 = r6.f2782e
            if (r7 == 0) goto L_0x004f
            int r7 = r6.q()
            goto L_0x0053
        L_0x004f:
            int r7 = r6.p()
        L_0x0053:
            if (r2 > r7) goto L_0x0058
            r6.r()
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c(int, int, int):void");
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r9v4 */
    private int a(RecyclerView.p pVar, l lVar, RecyclerView.t tVar) {
        int i2;
        int i3;
        int i4;
        c cVar;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        int i12;
        int i13;
        RecyclerView.p pVar2 = pVar;
        l lVar2 = lVar;
        ? r9 = 0;
        this.m.set(0, this.i, true);
        if (this.l.i) {
            i2 = lVar2.f2955e == 1 ? Integer.MAX_VALUE : RNCartPanelDataEntity.NULL_VALUE;
        } else {
            if (lVar2.f2955e == 1) {
                i13 = lVar2.f2957g + lVar2.f2952b;
            } else {
                i13 = lVar2.f2956f - lVar2.f2952b;
            }
            i2 = i13;
        }
        a(lVar2.f2955e, i2);
        if (this.f2782e) {
            i3 = this.f2779b.d();
        } else {
            i3 = this.f2779b.c();
        }
        int i14 = i3;
        boolean z3 = false;
        while (lVar.a(tVar) && (this.l.i || !this.m.isEmpty())) {
            View a2 = lVar2.a(pVar2);
            b bVar = (b) a2.getLayoutParams();
            int f2 = bVar.f();
            int c2 = this.h.c(f2);
            boolean z4 = c2 == -1;
            if (z4) {
                cVar = bVar.f2807b ? this.f2778a[r9] : a(lVar2);
                this.h.a(f2, cVar);
            } else {
                cVar = this.f2778a[c2];
            }
            c cVar2 = cVar;
            bVar.f2806a = cVar2;
            if (lVar2.f2955e == 1) {
                b(a2);
            } else {
                b(a2, (int) r9);
            }
            a(a2, bVar, (boolean) r9);
            if (lVar2.f2955e == 1) {
                if (bVar.f2807b) {
                    i12 = r(i14);
                } else {
                    i12 = cVar2.b(i14);
                }
                int e2 = this.f2779b.e(a2) + i12;
                if (z4 && bVar.f2807b) {
                    LazySpanLookup.FullSpanItem n2 = n(i12);
                    n2.f2789b = -1;
                    n2.f2788a = f2;
                    this.h.a(n2);
                }
                i5 = e2;
                i6 = i12;
            } else {
                if (bVar.f2807b) {
                    i11 = q(i14);
                } else {
                    i11 = cVar2.a(i14);
                }
                i6 = i11 - this.f2779b.e(a2);
                if (z4 && bVar.f2807b) {
                    LazySpanLookup.FullSpanItem o2 = o(i11);
                    o2.f2789b = 1;
                    o2.f2788a = f2;
                    this.h.a(o2);
                }
                i5 = i11;
            }
            if (bVar.f2807b && lVar2.f2954d == -1) {
                if (z4) {
                    this.E = true;
                } else {
                    if (lVar2.f2955e == 1) {
                        z2 = n();
                    } else {
                        z2 = o();
                    }
                    if (!z2) {
                        LazySpanLookup.FullSpanItem f3 = this.h.f(f2);
                        if (f3 != null) {
                            f3.f2791d = true;
                        }
                        this.E = true;
                    }
                }
            }
            a(a2, bVar, lVar2);
            if (!k() || this.j != 1) {
                if (bVar.f2807b) {
                    i9 = this.f2780c.c();
                } else {
                    i9 = (cVar2.f2812e * this.k) + this.f2780c.c();
                }
                i8 = i9;
                i7 = this.f2780c.e(a2) + i9;
            } else {
                if (bVar.f2807b) {
                    i10 = this.f2780c.d();
                } else {
                    i10 = this.f2780c.d() - (((this.i - 1) - cVar2.f2812e) * this.k);
                }
                i7 = i10;
                i8 = i10 - this.f2780c.e(a2);
            }
            if (this.j == 1) {
                a(a2, i8, i6, i7, i5);
            } else {
                a(a2, i6, i8, i5, i7);
            }
            if (bVar.f2807b) {
                a(this.l.f2955e, i2);
            } else {
                a(cVar2, this.l.f2955e, i2);
            }
            a(pVar2, this.l);
            if (this.l.h && a2.hasFocusable()) {
                if (bVar.f2807b) {
                    this.m.clear();
                } else {
                    this.m.set(cVar2.f2812e, false);
                    z3 = true;
                    r9 = 0;
                }
            }
            z3 = true;
            r9 = 0;
        }
        if (!z3) {
            a(pVar2, this.l);
        }
        if (this.l.f2955e == -1) {
            i4 = this.f2779b.c() - q(this.f2779b.c());
        } else {
            i4 = r(this.f2779b.d()) - this.f2779b.d();
        }
        if (i4 > 0) {
            return Math.min(lVar2.f2952b, i4);
        }
        return 0;
    }

    private LazySpanLookup.FullSpanItem n(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f2790c = new int[this.i];
        for (int i3 = 0; i3 < this.i; i3++) {
            fullSpanItem.f2790c[i3] = i2 - this.f2778a[i3].b(i2);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem o(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f2790c = new int[this.i];
        for (int i3 = 0; i3 < this.i; i3++) {
            fullSpanItem.f2790c[i3] = this.f2778a[i3].a(i2) - i2;
        }
        return fullSpanItem;
    }

    private void a(View view, b bVar, l lVar) {
        if (lVar.f2955e == 1) {
            if (bVar.f2807b) {
                p(view);
            } else {
                bVar.f2806a.b(view);
            }
        } else if (bVar.f2807b) {
            q(view);
        } else {
            bVar.f2806a.a(view);
        }
    }

    private void a(RecyclerView.p pVar, l lVar) {
        int i2;
        int i3;
        if (lVar.f2951a && !lVar.i) {
            if (lVar.f2952b == 0) {
                if (lVar.f2955e == -1) {
                    b(pVar, lVar.f2957g);
                } else {
                    a(pVar, lVar.f2956f);
                }
            } else if (lVar.f2955e == -1) {
                int p = lVar.f2956f - p(lVar.f2956f);
                if (p < 0) {
                    i3 = lVar.f2957g;
                } else {
                    i3 = lVar.f2957g - Math.min(p, lVar.f2952b);
                }
                b(pVar, i3);
            } else {
                int s = s(lVar.f2957g) - lVar.f2957g;
                if (s < 0) {
                    i2 = lVar.f2956f;
                } else {
                    i2 = Math.min(s, lVar.f2952b) + lVar.f2956f;
                }
                a(pVar, i2);
            }
        }
    }

    private void p(View view) {
        for (int i2 = this.i - 1; i2 >= 0; i2--) {
            this.f2778a[i2].b(view);
        }
    }

    private void q(View view) {
        for (int i2 = this.i - 1; i2 >= 0; i2--) {
            this.f2778a[i2].a(view);
        }
    }

    private void a(int i2, int i3) {
        for (int i4 = 0; i4 < this.i; i4++) {
            if (!this.f2778a[i4].f2808a.isEmpty()) {
                a(this.f2778a[i4], i2, i3);
            }
        }
    }

    private void a(c cVar, int i2, int i3) {
        int i4 = cVar.i();
        if (i2 == -1) {
            if (cVar.b() + i4 <= i3) {
                this.m.set(cVar.f2812e, false);
            }
        } else if (cVar.d() - i4 >= i3) {
            this.m.set(cVar.f2812e, false);
        }
    }

    private int p(int i2) {
        int a2 = this.f2778a[0].a(i2);
        for (int i3 = 1; i3 < this.i; i3++) {
            int a3 = this.f2778a[i3].a(i2);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int q(int i2) {
        int a2 = this.f2778a[0].a(i2);
        for (int i3 = 1; i3 < this.i; i3++) {
            int a3 = this.f2778a[i3].a(i2);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        int b2 = this.f2778a[0].b((int) RNCartPanelDataEntity.NULL_VALUE);
        for (int i2 = 1; i2 < this.i; i2++) {
            if (this.f2778a[i2].b((int) RNCartPanelDataEntity.NULL_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        int a2 = this.f2778a[0].a((int) RNCartPanelDataEntity.NULL_VALUE);
        for (int i2 = 1; i2 < this.i; i2++) {
            if (this.f2778a[i2].a((int) RNCartPanelDataEntity.NULL_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    private int r(int i2) {
        int b2 = this.f2778a[0].b(i2);
        for (int i3 = 1; i3 < this.i; i3++) {
            int b3 = this.f2778a[i3].b(i2);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private int s(int i2) {
        int b2 = this.f2778a[0].b(i2);
        for (int i3 = 1; i3 < this.i; i3++) {
            int b3 = this.f2778a[i3].b(i2);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private void a(RecyclerView.p pVar, int i2) {
        while (y() > 0) {
            View i3 = i(0);
            if (this.f2779b.b(i3) <= i2 && this.f2779b.c(i3) <= i2) {
                b bVar = (b) i3.getLayoutParams();
                if (bVar.f2807b) {
                    int i4 = 0;
                    while (i4 < this.i) {
                        if (this.f2778a[i4].f2808a.size() != 1) {
                            i4++;
                        } else {
                            return;
                        }
                    }
                    for (int i5 = 0; i5 < this.i; i5++) {
                        this.f2778a[i5].h();
                    }
                } else if (bVar.f2806a.f2808a.size() != 1) {
                    bVar.f2806a.h();
                } else {
                    return;
                }
                a(i3, pVar);
            } else {
                return;
            }
        }
    }

    private void b(RecyclerView.p pVar, int i2) {
        int y = y() - 1;
        while (y >= 0) {
            View i3 = i(y);
            if (this.f2779b.a(i3) >= i2 && this.f2779b.d(i3) >= i2) {
                b bVar = (b) i3.getLayoutParams();
                if (bVar.f2807b) {
                    int i4 = 0;
                    while (i4 < this.i) {
                        if (this.f2778a[i4].f2808a.size() != 1) {
                            i4++;
                        } else {
                            return;
                        }
                    }
                    for (int i5 = 0; i5 < this.i; i5++) {
                        this.f2778a[i5].g();
                    }
                } else if (bVar.f2806a.f2808a.size() != 1) {
                    bVar.f2806a.g();
                } else {
                    return;
                }
                a(i3, pVar);
                y--;
            } else {
                return;
            }
        }
    }

    private boolean t(int i2) {
        if (this.j == 0) {
            if ((i2 == -1) != this.f2782e) {
                return true;
            }
            return false;
        }
        if (((i2 == -1) == this.f2782e) == k()) {
            return true;
        }
        return false;
    }

    private c a(l lVar) {
        int i2;
        int i3;
        int i4 = -1;
        if (t(lVar.f2955e)) {
            i3 = this.i - 1;
            i2 = -1;
        } else {
            i3 = 0;
            i4 = this.i;
            i2 = 1;
        }
        c cVar = null;
        if (lVar.f2955e == 1) {
            int i5 = Integer.MAX_VALUE;
            int c2 = this.f2779b.c();
            while (i3 != i4) {
                c cVar2 = this.f2778a[i3];
                int b2 = cVar2.b(c2);
                if (b2 < i5) {
                    cVar = cVar2;
                    i5 = b2;
                }
                i3 += i2;
            }
            return cVar;
        }
        int i6 = RNCartPanelDataEntity.NULL_VALUE;
        int d2 = this.f2779b.d();
        while (i3 != i4) {
            c cVar3 = this.f2778a[i3];
            int a2 = cVar3.a(d2);
            if (a2 > i6) {
                cVar = cVar3;
                i6 = a2;
            }
            i3 += i2;
        }
        return cVar;
    }

    public boolean g() {
        return this.j == 1;
    }

    public boolean f() {
        return this.j == 0;
    }

    public int a(int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        return c(i2, pVar, tVar);
    }

    public int b(int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        return c(i2, pVar, tVar);
    }

    private int u(int i2) {
        if (y() != 0) {
            if ((i2 < q()) != this.f2782e) {
                return -1;
            }
            return 1;
        } else if (this.f2782e) {
            return 1;
        } else {
            return -1;
        }
    }

    public PointF d(int i2) {
        int u = u(i2);
        PointF pointF = new PointF();
        if (u == 0) {
            return null;
        }
        if (this.j == 0) {
            pointF.x = (float) u;
            pointF.y = BitmapDescriptorFactory.HUE_RED;
        } else {
            pointF.x = BitmapDescriptorFactory.HUE_RED;
            pointF.y = (float) u;
        }
        return pointF;
    }

    public void a(RecyclerView recyclerView, RecyclerView.t tVar, int i2) {
        m mVar = new m(recyclerView.getContext());
        mVar.c(i2);
        a((RecyclerView.s) mVar);
    }

    public void e(int i2) {
        SavedState savedState = this.A;
        if (!(savedState == null || savedState.f2792a == i2)) {
            this.A.b();
        }
        this.f2783f = i2;
        this.f2784g = RNCartPanelDataEntity.NULL_VALUE;
        r();
    }

    public void a(int i2, int i3, RecyclerView.t tVar, RecyclerView.i.a aVar) {
        int i4;
        int i5;
        if (this.j != 0) {
            i2 = i3;
        }
        if (y() != 0 && i2 != 0) {
            a(i2, tVar);
            int[] iArr = this.G;
            if (iArr == null || iArr.length < this.i) {
                this.G = new int[this.i];
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.i; i7++) {
                if (this.l.f2954d == -1) {
                    i5 = this.l.f2956f;
                    i4 = this.f2778a[i7].a(this.l.f2956f);
                } else {
                    i5 = this.f2778a[i7].b(this.l.f2957g);
                    i4 = this.l.f2957g;
                }
                int i8 = i5 - i4;
                if (i8 >= 0) {
                    this.G[i6] = i8;
                    i6++;
                }
            }
            Arrays.sort(this.G, 0, i6);
            for (int i9 = 0; i9 < i6 && this.l.a(tVar); i9++) {
                aVar.b(this.l.f2953c, this.G[i9]);
                this.l.f2953c += this.l.f2954d;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, RecyclerView.t tVar) {
        int i3;
        int i4;
        if (i2 > 0) {
            i4 = p();
            i3 = 1;
        } else {
            i4 = q();
            i3 = -1;
        }
        this.l.f2951a = true;
        b(i4, tVar);
        m(i3);
        l lVar = this.l;
        lVar.f2953c = i4 + lVar.f2954d;
        this.l.f2952b = Math.abs(i2);
    }

    /* access modifiers changed from: package-private */
    public int c(int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        if (y() == 0 || i2 == 0) {
            return 0;
        }
        a(i2, tVar);
        int a2 = a(pVar, this.l, tVar);
        if (this.l.f2952b >= a2) {
            i2 = i2 < 0 ? -a2 : a2;
        }
        this.f2779b.a(-i2);
        this.o = this.f2782e;
        l lVar = this.l;
        lVar.f2952b = 0;
        a(pVar, lVar);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        int y = y();
        if (y == 0) {
            return 0;
        }
        return d(i(y - 1));
    }

    /* access modifiers changed from: package-private */
    public int q() {
        if (y() == 0) {
            return 0;
        }
        return d(i(0));
    }

    private int v(int i2) {
        int y = y();
        for (int i3 = 0; i3 < y; i3++) {
            int d2 = d(i(i3));
            if (d2 >= 0 && d2 < i2) {
                return d2;
            }
        }
        return 0;
    }

    private int w(int i2) {
        for (int y = y() - 1; y >= 0; y--) {
            int d2 = d(i(y));
            if (d2 >= 0 && d2 < i2) {
                return d2;
            }
        }
        return 0;
    }

    public RecyclerView.j a() {
        if (this.j == 0) {
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

    public int O() {
        return this.j;
    }

    public View a(View view, int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (y() == 0) {
            return null;
        }
        View e2 = e(view);
        if (e2 == null) {
            return null;
        }
        Q();
        int x = x(i2);
        if (x == Integer.MIN_VALUE) {
            return null;
        }
        b bVar = (b) e2.getLayoutParams();
        boolean z2 = bVar.f2807b;
        c cVar = bVar.f2806a;
        if (x == 1) {
            i3 = p();
        } else {
            i3 = q();
        }
        b(i3, tVar);
        m(x);
        l lVar = this.l;
        lVar.f2953c = lVar.f2954d + i3;
        this.l.f2952b = (int) (((float) this.f2779b.f()) * 0.33333334f);
        l lVar2 = this.l;
        lVar2.h = true;
        lVar2.f2951a = false;
        a(pVar, lVar2, tVar);
        this.o = this.f2782e;
        if (!z2) {
            View a2 = cVar.a(i3, x);
            if (!(a2 == null || a2 == e2)) {
                return a2;
            }
        }
        if (t(x)) {
            for (int i7 = this.i - 1; i7 >= 0; i7--) {
                View a3 = this.f2778a[i7].a(i3, x);
                if (a3 != null && a3 != e2) {
                    return a3;
                }
            }
        } else {
            for (int i8 = 0; i8 < this.i; i8++) {
                View a4 = this.f2778a[i8].a(i3, x);
                if (a4 != null && a4 != e2) {
                    return a4;
                }
            }
        }
        boolean z3 = (this.f2781d ^ true) == (x == -1);
        if (!z2) {
            if (z3) {
                i6 = cVar.k();
            } else {
                i6 = cVar.m();
            }
            View c2 = c(i6);
            if (!(c2 == null || c2 == e2)) {
                return c2;
            }
        }
        if (t(x)) {
            for (int i9 = this.i - 1; i9 >= 0; i9--) {
                if (i9 != cVar.f2812e) {
                    if (z3) {
                        i5 = this.f2778a[i9].k();
                    } else {
                        i5 = this.f2778a[i9].m();
                    }
                    View c3 = c(i5);
                    if (!(c3 == null || c3 == e2)) {
                        return c3;
                    }
                }
            }
        } else {
            for (int i10 = 0; i10 < this.i; i10++) {
                if (z3) {
                    i4 = this.f2778a[i10].k();
                } else {
                    i4 = this.f2778a[i10].m();
                }
                View c4 = c(i4);
                if (c4 != null && c4 != e2) {
                    return c4;
                }
            }
        }
        return null;
    }

    private int x(int i2) {
        if (i2 == 1) {
            return (this.j != 1 && k()) ? 1 : -1;
        }
        if (i2 == 2) {
            return (this.j != 1 && k()) ? -1 : 1;
        }
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 == 130 && this.j == 1) {
                        return 1;
                    }
                    return RNCartPanelDataEntity.NULL_VALUE;
                } else if (this.j == 0) {
                    return 1;
                } else {
                    return RNCartPanelDataEntity.NULL_VALUE;
                }
            } else if (this.j == 1) {
                return -1;
            } else {
                return RNCartPanelDataEntity.NULL_VALUE;
            }
        } else if (this.j == 0) {
            return -1;
        } else {
            return RNCartPanelDataEntity.NULL_VALUE;
        }
    }

    public static class b extends RecyclerView.j {

        /* renamed from: a  reason: collision with root package name */
        c f2806a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2807b;

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

        public boolean a() {
            return this.f2807b;
        }

        public final int b() {
            c cVar = this.f2806a;
            if (cVar == null) {
                return -1;
            }
            return cVar.f2812e;
        }
    }

    class c {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f2808a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f2809b = RNCartPanelDataEntity.NULL_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f2810c = RNCartPanelDataEntity.NULL_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f2811d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f2812e;

        c(int i) {
            this.f2812e = i;
        }

        /* access modifiers changed from: package-private */
        public int a(int i) {
            int i2 = this.f2809b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f2808a.size() == 0) {
                return i;
            }
            a();
            return this.f2809b;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            View view = this.f2808a.get(0);
            b c2 = c(view);
            this.f2809b = StaggeredGridLayoutManager.this.f2779b.a(view);
            if (c2.f2807b) {
                LazySpanLookup.FullSpanItem f2 = StaggeredGridLayoutManager.this.h.f(c2.f());
                if (f2 != null && f2.f2789b == -1) {
                    this.f2809b -= f2.a(this.f2812e);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int b() {
            int i = this.f2809b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            a();
            return this.f2809b;
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            int i2 = this.f2810c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f2808a.size() == 0) {
                return i;
            }
            c();
            return this.f2810c;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            ArrayList<View> arrayList = this.f2808a;
            View view = arrayList.get(arrayList.size() - 1);
            b c2 = c(view);
            this.f2810c = StaggeredGridLayoutManager.this.f2779b.b(view);
            if (c2.f2807b) {
                LazySpanLookup.FullSpanItem f2 = StaggeredGridLayoutManager.this.h.f(c2.f());
                if (f2 != null && f2.f2789b == 1) {
                    this.f2810c += f2.a(this.f2812e);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int d() {
            int i = this.f2810c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            c();
            return this.f2810c;
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            b c2 = c(view);
            c2.f2806a = this;
            this.f2808a.add(0, view);
            this.f2809b = RNCartPanelDataEntity.NULL_VALUE;
            if (this.f2808a.size() == 1) {
                this.f2810c = RNCartPanelDataEntity.NULL_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.f2811d += StaggeredGridLayoutManager.this.f2779b.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(View view) {
            b c2 = c(view);
            c2.f2806a = this;
            this.f2808a.add(view);
            this.f2810c = RNCartPanelDataEntity.NULL_VALUE;
            if (this.f2808a.size() == 1) {
                this.f2809b = RNCartPanelDataEntity.NULL_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.f2811d += StaggeredGridLayoutManager.this.f2779b.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z, int i) {
            int i2;
            if (z) {
                i2 = b((int) RNCartPanelDataEntity.NULL_VALUE);
            } else {
                i2 = a((int) RNCartPanelDataEntity.NULL_VALUE);
            }
            e();
            if (i2 != Integer.MIN_VALUE) {
                if (z && i2 < StaggeredGridLayoutManager.this.f2779b.d()) {
                    return;
                }
                if (z || i2 <= StaggeredGridLayoutManager.this.f2779b.c()) {
                    if (i != Integer.MIN_VALUE) {
                        i2 += i;
                    }
                    this.f2810c = i2;
                    this.f2809b = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f2808a.clear();
            f();
            this.f2811d = 0;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f2809b = RNCartPanelDataEntity.NULL_VALUE;
            this.f2810c = RNCartPanelDataEntity.NULL_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void c(int i) {
            this.f2809b = i;
            this.f2810c = i;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int size = this.f2808a.size();
            View remove = this.f2808a.remove(size - 1);
            b c2 = c(remove);
            c2.f2806a = null;
            if (c2.d() || c2.e()) {
                this.f2811d -= StaggeredGridLayoutManager.this.f2779b.e(remove);
            }
            if (size == 1) {
                this.f2809b = RNCartPanelDataEntity.NULL_VALUE;
            }
            this.f2810c = RNCartPanelDataEntity.NULL_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            View remove = this.f2808a.remove(0);
            b c2 = c(remove);
            c2.f2806a = null;
            if (this.f2808a.size() == 0) {
                this.f2810c = RNCartPanelDataEntity.NULL_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.f2811d -= StaggeredGridLayoutManager.this.f2779b.e(remove);
            }
            this.f2809b = RNCartPanelDataEntity.NULL_VALUE;
        }

        public int i() {
            return this.f2811d;
        }

        /* access modifiers changed from: package-private */
        public b c(View view) {
            return (b) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public void d(int i) {
            int i2 = this.f2809b;
            if (i2 != Integer.MIN_VALUE) {
                this.f2809b = i2 + i;
            }
            int i3 = this.f2810c;
            if (i3 != Integer.MIN_VALUE) {
                this.f2810c = i3 + i;
            }
        }

        public int j() {
            if (StaggeredGridLayoutManager.this.f2781d) {
                return a(this.f2808a.size() - 1, -1, false);
            }
            return a(0, this.f2808a.size(), false);
        }

        public int k() {
            if (StaggeredGridLayoutManager.this.f2781d) {
                return b(this.f2808a.size() - 1, -1, true);
            }
            return b(0, this.f2808a.size(), true);
        }

        public int l() {
            if (StaggeredGridLayoutManager.this.f2781d) {
                return a(this.f2808a.size() - 1, -1, true);
            }
            return a(0, this.f2808a.size(), true);
        }

        public int m() {
            if (StaggeredGridLayoutManager.this.f2781d) {
                return b(0, this.f2808a.size(), true);
            }
            return b(this.f2808a.size() - 1, -1, true);
        }

        public int n() {
            if (StaggeredGridLayoutManager.this.f2781d) {
                return a(0, this.f2808a.size(), true);
            }
            return a(this.f2808a.size() - 1, -1, true);
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int c2 = StaggeredGridLayoutManager.this.f2779b.c();
            int d2 = StaggeredGridLayoutManager.this.f2779b.d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f2808a.get(i);
                int a2 = StaggeredGridLayoutManager.this.f2779b.a(view);
                int b2 = StaggeredGridLayoutManager.this.f2779b.b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? a2 < d2 : a2 <= d2;
                if (!z3 ? b2 > c2 : b2 >= c2) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                        if (a2 < c2 || b2 > d2) {
                            return StaggeredGridLayoutManager.this.d(view);
                        }
                    } else if (a2 >= c2 && b2 <= d2) {
                        return StaggeredGridLayoutManager.this.d(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2, boolean z) {
            return a(i, i2, z, true, false);
        }

        /* access modifiers changed from: package-private */
        public int b(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f2808a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f2808a.get(size);
                    if ((StaggeredGridLayoutManager.this.f2781d && StaggeredGridLayoutManager.this.d(view2) >= i) || ((!StaggeredGridLayoutManager.this.f2781d && StaggeredGridLayoutManager.this.d(view2) <= i) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f2808a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f2808a.get(i3);
                    if ((StaggeredGridLayoutManager.this.f2781d && StaggeredGridLayoutManager.this.d(view3) <= i) || ((!StaggeredGridLayoutManager.this.f2781d && StaggeredGridLayoutManager.this.d(view3) >= i) || !view3.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }
    }

    static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        int[] f2786a;

        /* renamed from: b  reason: collision with root package name */
        List<FullSpanItem> f2787b;

        LazySpanLookup() {
        }

        /* access modifiers changed from: package-private */
        public int a(int i) {
            List<FullSpanItem> list = this.f2787b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f2787b.get(size).f2788a >= i) {
                        this.f2787b.remove(size);
                    }
                }
            }
            return b(i);
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            int[] iArr = this.f2786a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int g2 = g(i);
            if (g2 == -1) {
                int[] iArr2 = this.f2786a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f2786a.length;
            }
            int i2 = g2 + 1;
            Arrays.fill(this.f2786a, i, i2, -1);
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int c(int i) {
            int[] iArr = this.f2786a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        /* access modifiers changed from: package-private */
        public void a(int i, c cVar) {
            e(i);
            this.f2786a[i] = cVar.f2812e;
        }

        /* access modifiers changed from: package-private */
        public int d(int i) {
            int length = this.f2786a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* access modifiers changed from: package-private */
        public void e(int i) {
            int[] iArr = this.f2786a;
            if (iArr == null) {
                this.f2786a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f2786a, -1);
            } else if (i >= iArr.length) {
                this.f2786a = new int[d(i)];
                System.arraycopy(iArr, 0, this.f2786a, 0, iArr.length);
                int[] iArr2 = this.f2786a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.f2786a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2787b = null;
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2) {
            int[] iArr = this.f2786a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                e(i3);
                int[] iArr2 = this.f2786a;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.f2786a;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                c(i, i2);
            }
        }

        private void c(int i, int i2) {
            List<FullSpanItem> list = this.f2787b;
            if (list != null) {
                int i3 = i + i2;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f2787b.get(size);
                    if (fullSpanItem.f2788a >= i) {
                        if (fullSpanItem.f2788a < i3) {
                            this.f2787b.remove(size);
                        } else {
                            fullSpanItem.f2788a -= i2;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i, int i2) {
            int[] iArr = this.f2786a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                e(i3);
                int[] iArr2 = this.f2786a;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.f2786a, i, i3, -1);
                d(i, i2);
            }
        }

        private void d(int i, int i2) {
            List<FullSpanItem> list = this.f2787b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f2787b.get(size);
                    if (fullSpanItem.f2788a >= i) {
                        fullSpanItem.f2788a += i2;
                    }
                }
            }
        }

        private int g(int i) {
            if (this.f2787b == null) {
                return -1;
            }
            FullSpanItem f2 = f(i);
            if (f2 != null) {
                this.f2787b.remove(f2);
            }
            int size = this.f2787b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f2787b.get(i2).f2788a >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            this.f2787b.remove(i2);
            return this.f2787b.get(i2).f2788a;
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f2787b == null) {
                this.f2787b = new ArrayList();
            }
            int size = this.f2787b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f2787b.get(i);
                if (fullSpanItem2.f2788a == fullSpanItem.f2788a) {
                    this.f2787b.remove(i);
                }
                if (fullSpanItem2.f2788a >= fullSpanItem.f2788a) {
                    this.f2787b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f2787b.add(fullSpanItem);
        }

        public FullSpanItem f(int i) {
            List<FullSpanItem> list = this.f2787b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f2787b.get(size);
                if (fullSpanItem.f2788a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem a(int i, int i2, int i3, boolean z) {
            List<FullSpanItem> list = this.f2787b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f2787b.get(i4);
                if (fullSpanItem.f2788a >= i2) {
                    return null;
                }
                if (fullSpanItem.f2788a >= i && (i3 == 0 || fullSpanItem.f2789b == i3 || (z && fullSpanItem.f2791d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* renamed from: a */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };

            /* renamed from: a  reason: collision with root package name */
            int f2788a;

            /* renamed from: b  reason: collision with root package name */
            int f2789b;

            /* renamed from: c  reason: collision with root package name */
            int[] f2790c;

            /* renamed from: d  reason: collision with root package name */
            boolean f2791d;

            public int describeContents() {
                return 0;
            }

            FullSpanItem(Parcel parcel) {
                this.f2788a = parcel.readInt();
                this.f2789b = parcel.readInt();
                this.f2791d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f2790c = new int[readInt];
                    parcel.readIntArray(this.f2790c);
                }
            }

            FullSpanItem() {
            }

            /* access modifiers changed from: package-private */
            public int a(int i) {
                int[] iArr = this.f2790c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f2788a);
                parcel.writeInt(this.f2789b);
                parcel.writeInt(this.f2791d ? 1 : 0);
                int[] iArr = this.f2790c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f2790c);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f2788a + ", mGapDir=" + this.f2789b + ", mHasUnwantedGapAfter=" + this.f2791d + ", mGapPerSpan=" + Arrays.toString(this.f2790c) + '}';
            }
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f2792a;

        /* renamed from: b  reason: collision with root package name */
        int f2793b;

        /* renamed from: c  reason: collision with root package name */
        int f2794c;

        /* renamed from: d  reason: collision with root package name */
        int[] f2795d;

        /* renamed from: e  reason: collision with root package name */
        int f2796e;

        /* renamed from: f  reason: collision with root package name */
        int[] f2797f;

        /* renamed from: g  reason: collision with root package name */
        List<LazySpanLookup.FullSpanItem> f2798g;
        boolean h;
        boolean i;
        boolean j;

        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f2792a = parcel.readInt();
            this.f2793b = parcel.readInt();
            this.f2794c = parcel.readInt();
            int i2 = this.f2794c;
            if (i2 > 0) {
                this.f2795d = new int[i2];
                parcel.readIntArray(this.f2795d);
            }
            this.f2796e = parcel.readInt();
            int i3 = this.f2796e;
            if (i3 > 0) {
                this.f2797f = new int[i3];
                parcel.readIntArray(this.f2797f);
            }
            boolean z = false;
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1 ? true : z;
            this.f2798g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f2794c = savedState.f2794c;
            this.f2792a = savedState.f2792a;
            this.f2793b = savedState.f2793b;
            this.f2795d = savedState.f2795d;
            this.f2796e = savedState.f2796e;
            this.f2797f = savedState.f2797f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.f2798g = savedState.f2798g;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2795d = null;
            this.f2794c = 0;
            this.f2796e = 0;
            this.f2797f = null;
            this.f2798g = null;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f2795d = null;
            this.f2794c = 0;
            this.f2792a = -1;
            this.f2793b = -1;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f2792a);
            parcel.writeInt(this.f2793b);
            parcel.writeInt(this.f2794c);
            if (this.f2794c > 0) {
                parcel.writeIntArray(this.f2795d);
            }
            parcel.writeInt(this.f2796e);
            if (this.f2796e > 0) {
                parcel.writeIntArray(this.f2797f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.f2798g);
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        int f2799a;

        /* renamed from: b  reason: collision with root package name */
        int f2800b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2801c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2802d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2803e;

        /* renamed from: f  reason: collision with root package name */
        int[] f2804f;

        a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2799a = -1;
            this.f2800b = RNCartPanelDataEntity.NULL_VALUE;
            this.f2801c = false;
            this.f2802d = false;
            this.f2803e = false;
            int[] iArr = this.f2804f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(c[] cVarArr) {
            int length = cVarArr.length;
            int[] iArr = this.f2804f;
            if (iArr == null || iArr.length < length) {
                this.f2804f = new int[StaggeredGridLayoutManager.this.f2778a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f2804f[i] = cVarArr[i].a((int) RNCartPanelDataEntity.NULL_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int i;
            if (this.f2801c) {
                i = StaggeredGridLayoutManager.this.f2779b.d();
            } else {
                i = StaggeredGridLayoutManager.this.f2779b.c();
            }
            this.f2800b = i;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            if (this.f2801c) {
                this.f2800b = StaggeredGridLayoutManager.this.f2779b.d() - i;
            } else {
                this.f2800b = StaggeredGridLayoutManager.this.f2779b.c() + i;
            }
        }
    }
}
