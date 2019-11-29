package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.i implements RecyclerView.s.b, i.d {

    /* renamed from: a  reason: collision with root package name */
    private c f2675a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2676b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2677c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2678d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2679e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2680f;

    /* renamed from: g  reason: collision with root package name */
    private final b f2681g;
    private int h;
    int i;
    p j;
    boolean k;
    int l;
    int m;
    SavedState n;
    final a o;

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.p pVar, RecyclerView.t tVar, a aVar, int i2) {
    }

    public boolean d() {
        return true;
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i2, boolean z) {
        this.i = 1;
        this.f2677c = false;
        this.k = false;
        this.f2678d = false;
        this.f2679e = true;
        this.l = -1;
        this.m = RNCartPanelDataEntity.NULL_VALUE;
        this.n = null;
        this.o = new a();
        this.f2681g = new b();
        this.h = 2;
        b(i2);
        b(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.i = 1;
        this.f2677c = false;
        this.k = false;
        this.f2678d = false;
        this.f2679e = true;
        this.l = -1;
        this.m = RNCartPanelDataEntity.NULL_VALUE;
        this.n = null;
        this.o = new a();
        this.f2681g = new b();
        this.h = 2;
        RecyclerView.i.b a2 = a(context, attributeSet, i2, i3);
        b(a2.f2728a);
        b(a2.f2730c);
        a(a2.f2731d);
    }

    public RecyclerView.j a() {
        return new RecyclerView.j(-2, -2);
    }

    public void a(RecyclerView recyclerView, RecyclerView.p pVar) {
        super.a(recyclerView, pVar);
        if (this.f2680f) {
            c(pVar);
            pVar.a();
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (y() > 0) {
            accessibilityEvent.setFromIndex(n());
            accessibilityEvent.setToIndex(p());
        }
    }

    public Parcelable e() {
        SavedState savedState = this.n;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (y() > 0) {
            j();
            boolean z = this.f2676b ^ this.k;
            savedState2.f2684c = z;
            if (z) {
                View P = P();
                savedState2.f2683b = this.j.d() - this.j.b(P);
                savedState2.f2682a = d(P);
            } else {
                View O = O();
                savedState2.f2682a = d(O);
                savedState2.f2683b = this.j.a(O) - this.j.c();
            }
        } else {
            savedState2.b();
        }
        return savedState2;
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.n = (SavedState) parcelable;
            r();
        }
    }

    public boolean f() {
        return this.i == 0;
    }

    public boolean g() {
        return this.i == 1;
    }

    public void a(boolean z) {
        a((String) null);
        if (this.f2678d != z) {
            this.f2678d = z;
            r();
        }
    }

    public int h() {
        return this.i;
    }

    public void b(int i2) {
        if (i2 == 0 || i2 == 1) {
            a((String) null);
            if (i2 != this.i || this.j == null) {
                this.j = p.a(this, i2);
                this.o.f2685a = this.j;
                this.i = i2;
                r();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i2);
    }

    private void b() {
        if (this.i == 1 || !i()) {
            this.k = this.f2677c;
        } else {
            this.k = !this.f2677c;
        }
    }

    public void b(boolean z) {
        a((String) null);
        if (z != this.f2677c) {
            this.f2677c = z;
            r();
        }
    }

    public View c(int i2) {
        int y = y();
        if (y == 0) {
            return null;
        }
        int d2 = i2 - d(i(0));
        if (d2 >= 0 && d2 < y) {
            View i3 = i(d2);
            if (d(i3) == i2) {
                return i3;
            }
        }
        return super.c(i2);
    }

    /* access modifiers changed from: protected */
    public int b(RecyclerView.t tVar) {
        if (tVar.d()) {
            return this.j.f();
        }
        return 0;
    }

    public void a(RecyclerView recyclerView, RecyclerView.t tVar, int i2) {
        m mVar = new m(recyclerView.getContext());
        mVar.c(i2);
        a((RecyclerView.s) mVar);
    }

    public PointF d(int i2) {
        if (y() == 0) {
            return null;
        }
        boolean z = false;
        int i3 = 1;
        if (i2 < d(i(0))) {
            z = true;
        }
        if (z != this.k) {
            i3 = -1;
        }
        if (this.i == 0) {
            return new PointF((float) i3, BitmapDescriptorFactory.HUE_RED);
        }
        return new PointF(BitmapDescriptorFactory.HUE_RED, (float) i3);
    }

    public void c(RecyclerView.p pVar, RecyclerView.t tVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = -1;
        if (!(this.n == null && this.l == -1) && tVar.e() == 0) {
            c(pVar);
            return;
        }
        SavedState savedState = this.n;
        if (savedState != null && savedState.a()) {
            this.l = this.n.f2682a;
        }
        j();
        this.f2675a.f2694a = false;
        b();
        View H = H();
        if (!this.o.f2689e || this.l != -1 || this.n != null) {
            this.o.a();
            a aVar = this.o;
            aVar.f2688d = this.k ^ this.f2678d;
            a(pVar, tVar, aVar);
            this.o.f2689e = true;
        } else if (H != null && (this.j.a(H) >= this.j.d() || this.j.b(H) <= this.j.c())) {
            this.o.a(H, d(H));
        }
        int b2 = b(tVar);
        if (this.f2675a.j >= 0) {
            i2 = b2;
            b2 = 0;
        } else {
            i2 = 0;
        }
        int c2 = b2 + this.j.c();
        int g2 = i2 + this.j.g();
        if (tVar.a()) {
            int i11 = this.l;
            if (!(i11 == -1 || this.m == Integer.MIN_VALUE)) {
                View c3 = c(i11);
                if (c3 != null) {
                    if (this.k) {
                        i8 = this.j.d() - this.j.b(c3);
                        i9 = this.m;
                    } else {
                        i9 = this.j.a(c3) - this.j.c();
                        i8 = this.m;
                    }
                    int i12 = i8 - i9;
                    if (i12 > 0) {
                        c2 += i12;
                    } else {
                        g2 -= i12;
                    }
                }
            }
        }
        if (!this.o.f2688d ? !this.k : this.k) {
            i10 = 1;
        }
        a(pVar, tVar, this.o, i10);
        a(pVar);
        this.f2675a.l = l();
        this.f2675a.i = tVar.a();
        if (this.o.f2688d) {
            b(this.o);
            c cVar = this.f2675a;
            cVar.h = c2;
            a(pVar, cVar, tVar, false);
            i4 = this.f2675a.f2695b;
            int i13 = this.f2675a.f2697d;
            if (this.f2675a.f2696c > 0) {
                g2 += this.f2675a.f2696c;
            }
            a(this.o);
            c cVar2 = this.f2675a;
            cVar2.h = g2;
            cVar2.f2697d += this.f2675a.f2698e;
            a(pVar, this.f2675a, tVar, false);
            i3 = this.f2675a.f2695b;
            if (this.f2675a.f2696c > 0) {
                int i14 = this.f2675a.f2696c;
                h(i13, i4);
                c cVar3 = this.f2675a;
                cVar3.h = i14;
                a(pVar, cVar3, tVar, false);
                i4 = this.f2675a.f2695b;
            }
        } else {
            a(this.o);
            c cVar4 = this.f2675a;
            cVar4.h = g2;
            a(pVar, cVar4, tVar, false);
            i3 = this.f2675a.f2695b;
            int i15 = this.f2675a.f2697d;
            if (this.f2675a.f2696c > 0) {
                c2 += this.f2675a.f2696c;
            }
            b(this.o);
            c cVar5 = this.f2675a;
            cVar5.h = c2;
            cVar5.f2697d += this.f2675a.f2698e;
            a(pVar, this.f2675a, tVar, false);
            i4 = this.f2675a.f2695b;
            if (this.f2675a.f2696c > 0) {
                int i16 = this.f2675a.f2696c;
                a(i15, i3);
                c cVar6 = this.f2675a;
                cVar6.h = i16;
                a(pVar, cVar6, tVar, false);
                i3 = this.f2675a.f2695b;
            }
        }
        if (y() > 0) {
            if (this.k ^ this.f2678d) {
                int a2 = a(i3, pVar, tVar, true);
                i7 = i4 + a2;
                i5 = i3 + a2;
                i6 = b(i7, pVar, tVar, false);
            } else {
                int b3 = b(i4, pVar, tVar, true);
                i7 = i4 + b3;
                i5 = i3 + b3;
                i6 = a(i5, pVar, tVar, false);
            }
            i4 = i7 + i6;
            i3 = i5 + i6;
        }
        b(pVar, tVar, i4, i3);
        if (!tVar.a()) {
            this.j.a();
        } else {
            this.o.a();
        }
        this.f2676b = this.f2678d;
    }

    public void a(RecyclerView.t tVar) {
        super.a(tVar);
        this.n = null;
        this.l = -1;
        this.m = RNCartPanelDataEntity.NULL_VALUE;
        this.o.a();
    }

    private void b(RecyclerView.p pVar, RecyclerView.t tVar, int i2, int i3) {
        RecyclerView.p pVar2 = pVar;
        RecyclerView.t tVar2 = tVar;
        if (tVar.b() && y() != 0 && !tVar.a() && c()) {
            List<RecyclerView.w> c2 = pVar.c();
            int size = c2.size();
            int d2 = d(i(0));
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                RecyclerView.w wVar = c2.get(i6);
                if (!wVar.isRemoved()) {
                    char c3 = 1;
                    if ((wVar.getLayoutPosition() < d2) != this.k) {
                        c3 = 65535;
                    }
                    if (c3 == 65535) {
                        i4 += this.j.e(wVar.itemView);
                    } else {
                        i5 += this.j.e(wVar.itemView);
                    }
                }
            }
            this.f2675a.k = c2;
            if (i4 > 0) {
                h(d(O()), i2);
                c cVar = this.f2675a;
                cVar.h = i4;
                cVar.f2696c = 0;
                cVar.a();
                a(pVar2, this.f2675a, tVar2, false);
            }
            if (i5 > 0) {
                a(d(P()), i3);
                c cVar2 = this.f2675a;
                cVar2.h = i5;
                cVar2.f2696c = 0;
                cVar2.a();
                a(pVar2, this.f2675a, tVar2, false);
            }
            this.f2675a.k = null;
        }
    }

    private void a(RecyclerView.p pVar, RecyclerView.t tVar, a aVar) {
        if (!a(tVar, aVar) && !b(pVar, tVar, aVar)) {
            aVar.b();
            aVar.f2686b = this.f2678d ? tVar.e() - 1 : 0;
        }
    }

    private boolean b(RecyclerView.p pVar, RecyclerView.t tVar, a aVar) {
        View view;
        int i2;
        boolean z = false;
        if (y() == 0) {
            return false;
        }
        View H = H();
        if (H != null && aVar.a(H, tVar)) {
            aVar.a(H, d(H));
            return true;
        } else if (this.f2676b != this.f2678d) {
            return false;
        } else {
            if (aVar.f2688d) {
                view = f(pVar, tVar);
            } else {
                view = g(pVar, tVar);
            }
            if (view == null) {
                return false;
            }
            aVar.b(view, d(view));
            if (!tVar.a() && c()) {
                if (this.j.a(view) >= this.j.d() || this.j.b(view) < this.j.c()) {
                    z = true;
                }
                if (z) {
                    if (aVar.f2688d) {
                        i2 = this.j.d();
                    } else {
                        i2 = this.j.c();
                    }
                    aVar.f2687c = i2;
                }
            }
            return true;
        }
    }

    private boolean a(RecyclerView.t tVar, a aVar) {
        int i2;
        boolean z = false;
        if (!tVar.a()) {
            int i3 = this.l;
            if (i3 != -1) {
                if (i3 < 0 || i3 >= tVar.e()) {
                    this.l = -1;
                    this.m = RNCartPanelDataEntity.NULL_VALUE;
                } else {
                    aVar.f2686b = this.l;
                    SavedState savedState = this.n;
                    if (savedState != null && savedState.a()) {
                        aVar.f2688d = this.n.f2684c;
                        if (aVar.f2688d) {
                            aVar.f2687c = this.j.d() - this.n.f2683b;
                        } else {
                            aVar.f2687c = this.j.c() + this.n.f2683b;
                        }
                        return true;
                    } else if (this.m == Integer.MIN_VALUE) {
                        View c2 = c(this.l);
                        if (c2 == null) {
                            if (y() > 0) {
                                if ((this.l < d(i(0))) == this.k) {
                                    z = true;
                                }
                                aVar.f2688d = z;
                            }
                            aVar.b();
                        } else if (this.j.e(c2) > this.j.f()) {
                            aVar.b();
                            return true;
                        } else if (this.j.a(c2) - this.j.c() < 0) {
                            aVar.f2687c = this.j.c();
                            aVar.f2688d = false;
                            return true;
                        } else if (this.j.d() - this.j.b(c2) < 0) {
                            aVar.f2687c = this.j.d();
                            aVar.f2688d = true;
                            return true;
                        } else {
                            if (aVar.f2688d) {
                                i2 = this.j.b(c2) + this.j.b();
                            } else {
                                i2 = this.j.a(c2);
                            }
                            aVar.f2687c = i2;
                        }
                        return true;
                    } else {
                        boolean z2 = this.k;
                        aVar.f2688d = z2;
                        if (z2) {
                            aVar.f2687c = this.j.d() - this.m;
                        } else {
                            aVar.f2687c = this.j.c() + this.m;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int a(int i2, RecyclerView.p pVar, RecyclerView.t tVar, boolean z) {
        int d2 = this.j.d() - i2;
        if (d2 <= 0) {
            return 0;
        }
        int i3 = -c(-d2, pVar, tVar);
        int i4 = i2 + i3;
        if (z) {
            int d3 = this.j.d() - i4;
            if (d3 > 0) {
                this.j.a(d3);
                return d3 + i3;
            }
        }
        return i3;
    }

    private int b(int i2, RecyclerView.p pVar, RecyclerView.t tVar, boolean z) {
        int c2 = i2 - this.j.c();
        if (c2 <= 0) {
            return 0;
        }
        int i3 = -c(c2, pVar, tVar);
        int i4 = i2 + i3;
        if (!z) {
            return i3;
        }
        int c3 = i4 - this.j.c();
        if (c3 <= 0) {
            return i3;
        }
        this.j.a(-c3);
        return i3 - c3;
    }

    private void a(a aVar) {
        a(aVar.f2686b, aVar.f2687c);
    }

    private void a(int i2, int i3) {
        this.f2675a.f2696c = this.j.d() - i3;
        this.f2675a.f2698e = this.k ? -1 : 1;
        c cVar = this.f2675a;
        cVar.f2697d = i2;
        cVar.f2699f = 1;
        cVar.f2695b = i3;
        cVar.f2700g = RNCartPanelDataEntity.NULL_VALUE;
    }

    private void b(a aVar) {
        h(aVar.f2686b, aVar.f2687c);
    }

    private void h(int i2, int i3) {
        this.f2675a.f2696c = i3 - this.j.c();
        c cVar = this.f2675a;
        cVar.f2697d = i2;
        cVar.f2698e = this.k ? 1 : -1;
        c cVar2 = this.f2675a;
        cVar2.f2699f = -1;
        cVar2.f2695b = i3;
        cVar2.f2700g = RNCartPanelDataEntity.NULL_VALUE;
    }

    /* access modifiers changed from: protected */
    public boolean i() {
        return w() == 1;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (this.f2675a == null) {
            this.f2675a = k();
        }
    }

    /* access modifiers changed from: package-private */
    public c k() {
        return new c();
    }

    public void e(int i2) {
        this.l = i2;
        this.m = RNCartPanelDataEntity.NULL_VALUE;
        SavedState savedState = this.n;
        if (savedState != null) {
            savedState.b();
        }
        r();
    }

    public void b(int i2, int i3) {
        this.l = i2;
        this.m = i3;
        SavedState savedState = this.n;
        if (savedState != null) {
            savedState.b();
        }
        r();
    }

    public int a(int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.i == 1) {
            return 0;
        }
        return c(i2, pVar, tVar);
    }

    public int b(int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.i == 0) {
            return 0;
        }
        return c(i2, pVar, tVar);
    }

    public int c(RecyclerView.t tVar) {
        return i(tVar);
    }

    public int d(RecyclerView.t tVar) {
        return i(tVar);
    }

    public int e(RecyclerView.t tVar) {
        return j(tVar);
    }

    public int f(RecyclerView.t tVar) {
        return j(tVar);
    }

    public int g(RecyclerView.t tVar) {
        return k(tVar);
    }

    public int h(RecyclerView.t tVar) {
        return k(tVar);
    }

    private int i(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        j();
        p pVar = this.j;
        View a2 = a(!this.f2679e, true);
        return r.a(tVar, pVar, a2, b(!this.f2679e, true), this, this.f2679e, this.k);
    }

    private int j(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        j();
        p pVar = this.j;
        View a2 = a(!this.f2679e, true);
        return r.a(tVar, pVar, a2, b(!this.f2679e, true), this, this.f2679e);
    }

    private int k(RecyclerView.t tVar) {
        if (y() == 0) {
            return 0;
        }
        j();
        p pVar = this.j;
        View a2 = a(!this.f2679e, true);
        return r.b(tVar, pVar, a2, b(!this.f2679e, true), this, this.f2679e);
    }

    private void a(int i2, int i3, boolean z, RecyclerView.t tVar) {
        int i4;
        this.f2675a.l = l();
        this.f2675a.h = b(tVar);
        c cVar = this.f2675a;
        cVar.f2699f = i2;
        int i5 = -1;
        if (i2 == 1) {
            cVar.h += this.j.g();
            View P = P();
            c cVar2 = this.f2675a;
            if (!this.k) {
                i5 = 1;
            }
            cVar2.f2698e = i5;
            this.f2675a.f2697d = d(P) + this.f2675a.f2698e;
            this.f2675a.f2695b = this.j.b(P);
            i4 = this.j.b(P) - this.j.d();
        } else {
            View O = O();
            this.f2675a.h += this.j.c();
            c cVar3 = this.f2675a;
            if (this.k) {
                i5 = 1;
            }
            cVar3.f2698e = i5;
            this.f2675a.f2697d = d(O) + this.f2675a.f2698e;
            this.f2675a.f2695b = this.j.a(O);
            i4 = (-this.j.a(O)) + this.j.c();
        }
        c cVar4 = this.f2675a;
        cVar4.f2696c = i3;
        if (z) {
            cVar4.f2696c -= i4;
        }
        this.f2675a.f2700g = i4;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.j.h() == 0 && this.j.e() == 0;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.t tVar, c cVar, RecyclerView.i.a aVar) {
        int i2 = cVar.f2697d;
        if (i2 >= 0 && i2 < tVar.e()) {
            aVar.b(i2, Math.max(0, cVar.f2700g));
        }
    }

    public void a(int i2, RecyclerView.i.a aVar) {
        int i3;
        boolean z;
        SavedState savedState = this.n;
        int i4 = -1;
        if (savedState == null || !savedState.a()) {
            b();
            z = this.k;
            i3 = this.l;
            if (i3 == -1) {
                i3 = z ? i2 - 1 : 0;
            }
        } else {
            z = this.n.f2684c;
            i3 = this.n.f2682a;
        }
        if (!z) {
            i4 = 1;
        }
        for (int i5 = 0; i5 < this.h && i3 >= 0 && i3 < i2; i5++) {
            aVar.b(i3, 0);
            i3 += i4;
        }
    }

    public void a(int i2, int i3, RecyclerView.t tVar, RecyclerView.i.a aVar) {
        if (this.i != 0) {
            i2 = i3;
        }
        if (y() != 0 && i2 != 0) {
            j();
            a(i2 > 0 ? 1 : -1, Math.abs(i2), true, tVar);
            a(tVar, this.f2675a, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        if (y() == 0 || i2 == 0) {
            return 0;
        }
        this.f2675a.f2694a = true;
        j();
        int i3 = i2 > 0 ? 1 : -1;
        int abs = Math.abs(i2);
        a(i3, abs, true, tVar);
        int a2 = this.f2675a.f2700g + a(pVar, this.f2675a, tVar, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i2 = i3 * a2;
        }
        this.j.a(-i2);
        this.f2675a.j = i2;
        return i2;
    }

    public void a(String str) {
        if (this.n == null) {
            super.a(str);
        }
    }

    private void a(RecyclerView.p pVar, int i2, int i3) {
        if (i2 != i3) {
            if (i3 > i2) {
                for (int i4 = i3 - 1; i4 >= i2; i4--) {
                    a(i4, pVar);
                }
                return;
            }
            while (i2 > i3) {
                a(i2, pVar);
                i2--;
            }
        }
    }

    private void a(RecyclerView.p pVar, int i2) {
        if (i2 >= 0) {
            int y = y();
            if (this.k) {
                int i3 = y - 1;
                for (int i4 = i3; i4 >= 0; i4--) {
                    View i5 = i(i4);
                    if (this.j.b(i5) > i2 || this.j.c(i5) > i2) {
                        a(pVar, i3, i4);
                        return;
                    }
                }
                return;
            }
            for (int i6 = 0; i6 < y; i6++) {
                View i7 = i(i6);
                if (this.j.b(i7) > i2 || this.j.c(i7) > i2) {
                    a(pVar, 0, i6);
                    return;
                }
            }
        }
    }

    private void b(RecyclerView.p pVar, int i2) {
        int y = y();
        if (i2 >= 0) {
            int e2 = this.j.e() - i2;
            if (this.k) {
                for (int i3 = 0; i3 < y; i3++) {
                    View i4 = i(i3);
                    if (this.j.a(i4) < e2 || this.j.d(i4) < e2) {
                        a(pVar, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i5 = y - 1;
            for (int i6 = i5; i6 >= 0; i6--) {
                View i7 = i(i6);
                if (this.j.a(i7) < e2 || this.j.d(i7) < e2) {
                    a(pVar, i5, i6);
                    return;
                }
            }
        }
    }

    private void a(RecyclerView.p pVar, c cVar) {
        if (cVar.f2694a && !cVar.l) {
            if (cVar.f2699f == -1) {
                b(pVar, cVar.f2700g);
            } else {
                a(pVar, cVar.f2700g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int a(RecyclerView.p pVar, c cVar, RecyclerView.t tVar, boolean z) {
        int i2 = cVar.f2696c;
        if (cVar.f2700g != Integer.MIN_VALUE) {
            if (cVar.f2696c < 0) {
                cVar.f2700g += cVar.f2696c;
            }
            a(pVar, cVar);
        }
        int i3 = cVar.f2696c + cVar.h;
        b bVar = this.f2681g;
        while (true) {
            if ((!cVar.l && i3 <= 0) || !cVar.a(tVar)) {
                break;
            }
            bVar.a();
            a(pVar, tVar, cVar, bVar);
            if (!bVar.f2691b) {
                cVar.f2695b += bVar.f2690a * cVar.f2699f;
                if (!bVar.f2692c || this.f2675a.k != null || !tVar.a()) {
                    cVar.f2696c -= bVar.f2690a;
                    i3 -= bVar.f2690a;
                }
                if (cVar.f2700g != Integer.MIN_VALUE) {
                    cVar.f2700g += bVar.f2690a;
                    if (cVar.f2696c < 0) {
                        cVar.f2700g += cVar.f2696c;
                    }
                    a(pVar, cVar);
                }
                if (z && bVar.f2693d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.f2696c;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.p pVar, RecyclerView.t tVar, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View a2 = cVar.a(pVar);
        if (a2 == null) {
            bVar.f2691b = true;
            return;
        }
        RecyclerView.j jVar = (RecyclerView.j) a2.getLayoutParams();
        if (cVar.k == null) {
            if (this.k == (cVar.f2699f == -1)) {
                b(a2);
            } else {
                b(a2, 0);
            }
        } else {
            if (this.k == (cVar.f2699f == -1)) {
                a(a2);
            } else {
                a(a2, 0);
            }
        }
        a(a2, 0, 0);
        bVar.f2690a = this.j.e(a2);
        if (this.i == 1) {
            if (i()) {
                i6 = B() - F();
                i5 = i6 - this.j.f(a2);
            } else {
                i5 = D();
                i6 = this.j.f(a2) + i5;
            }
            if (cVar.f2699f == -1) {
                int i7 = cVar.f2695b;
                i4 = cVar.f2695b - bVar.f2690a;
                i3 = i6;
                i2 = i7;
            } else {
                int i8 = cVar.f2695b;
                i2 = cVar.f2695b + bVar.f2690a;
                i3 = i6;
                i4 = i8;
            }
        } else {
            int E = E();
            int f2 = this.j.f(a2) + E;
            if (cVar.f2699f == -1) {
                i4 = E;
                i3 = cVar.f2695b;
                i2 = f2;
                i5 = cVar.f2695b - bVar.f2690a;
            } else {
                int i9 = cVar.f2695b;
                i3 = cVar.f2695b + bVar.f2690a;
                i4 = E;
                i2 = f2;
                i5 = i9;
            }
        }
        a(a2, i5, i4, i3, i2);
        if (jVar.d() || jVar.e()) {
            bVar.f2692c = true;
        }
        bVar.f2693d = a2.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return (A() == 1073741824 || z() == 1073741824 || !N()) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public int f(int i2) {
        if (i2 == 1) {
            return (this.i != 1 && i()) ? 1 : -1;
        }
        if (i2 == 2) {
            return (this.i != 1 && i()) ? -1 : 1;
        }
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 == 130 && this.i == 1) {
                        return 1;
                    }
                    return RNCartPanelDataEntity.NULL_VALUE;
                } else if (this.i == 0) {
                    return 1;
                } else {
                    return RNCartPanelDataEntity.NULL_VALUE;
                }
            } else if (this.i == 1) {
                return -1;
            } else {
                return RNCartPanelDataEntity.NULL_VALUE;
            }
        } else if (this.i == 0) {
            return -1;
        } else {
            return RNCartPanelDataEntity.NULL_VALUE;
        }
    }

    private View O() {
        return i(this.k ? y() - 1 : 0);
    }

    private View P() {
        return i(this.k ? 0 : y() - 1);
    }

    private View a(boolean z, boolean z2) {
        if (this.k) {
            return a(y() - 1, -1, z, z2);
        }
        return a(0, y(), z, z2);
    }

    private View b(boolean z, boolean z2) {
        if (this.k) {
            return a(0, y(), z, z2);
        }
        return a(y() - 1, -1, z, z2);
    }

    private View f(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.k) {
            return h(pVar, tVar);
        }
        return i(pVar, tVar);
    }

    private View g(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.k) {
            return i(pVar, tVar);
        }
        return h(pVar, tVar);
    }

    private View h(RecyclerView.p pVar, RecyclerView.t tVar) {
        return a(pVar, tVar, 0, y(), tVar.e());
    }

    private View i(RecyclerView.p pVar, RecyclerView.t tVar) {
        return a(pVar, tVar, y() - 1, -1, tVar.e());
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.p pVar, RecyclerView.t tVar, int i2, int i3, int i4) {
        j();
        int c2 = this.j.c();
        int d2 = this.j.d();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View i6 = i(i2);
            int d3 = d(i6);
            if (d3 >= 0 && d3 < i4) {
                if (((RecyclerView.j) i6.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view2 = i6;
                    }
                } else if (this.j.a(i6) < d2 && this.j.b(i6) >= c2) {
                    return i6;
                } else {
                    if (view == null) {
                        view = i6;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    private View j(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.k) {
            return l(pVar, tVar);
        }
        return m(pVar, tVar);
    }

    private View k(RecyclerView.p pVar, RecyclerView.t tVar) {
        if (this.k) {
            return m(pVar, tVar);
        }
        return l(pVar, tVar);
    }

    private View l(RecyclerView.p pVar, RecyclerView.t tVar) {
        return c(0, y());
    }

    private View m(RecyclerView.p pVar, RecyclerView.t tVar) {
        return c(y() - 1, -1);
    }

    public int n() {
        View a2 = a(0, y(), false, true);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    public int o() {
        View a2 = a(0, y(), true, false);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    public int p() {
        View a2 = a(y() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    public int q() {
        View a2 = a(y() - 1, -1, true, false);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    /* access modifiers changed from: package-private */
    public View a(int i2, int i3, boolean z, boolean z2) {
        j();
        int i4 = 320;
        int i5 = z ? 24579 : 320;
        if (!z2) {
            i4 = 0;
        }
        if (this.i == 0) {
            return this.r.a(i2, i3, i5, i4);
        }
        return this.s.a(i2, i3, i5, i4);
    }

    /* access modifiers changed from: package-private */
    public View c(int i2, int i3) {
        int i4;
        int i5;
        j();
        if ((i3 > i2 ? 1 : i3 < i2 ? (char) 65535 : 0) == 0) {
            return i(i2);
        }
        if (this.j.a(i(i2)) < this.j.c()) {
            i5 = 16644;
            i4 = 16388;
        } else {
            i5 = 4161;
            i4 = 4097;
        }
        if (this.i == 0) {
            return this.r.a(i2, i3, i5, i4);
        }
        return this.s.a(i2, i3, i5, i4);
    }

    public View a(View view, int i2, RecyclerView.p pVar, RecyclerView.t tVar) {
        View view2;
        View view3;
        b();
        if (y() == 0) {
            return null;
        }
        int f2 = f(i2);
        if (f2 == Integer.MIN_VALUE) {
            return null;
        }
        j();
        j();
        a(f2, (int) (((float) this.j.f()) * 0.33333334f), false, tVar);
        c cVar = this.f2675a;
        cVar.f2700g = RNCartPanelDataEntity.NULL_VALUE;
        cVar.f2694a = false;
        a(pVar, cVar, tVar, true);
        if (f2 == -1) {
            view2 = k(pVar, tVar);
        } else {
            view2 = j(pVar, tVar);
        }
        if (f2 == -1) {
            view3 = O();
        } else {
            view3 = P();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    public boolean c() {
        return this.n == null && this.f2676b == this.f2678d;
    }

    public void a(View view, View view2, int i2, int i3) {
        a("Cannot drop a view during a scroll or layout calculation");
        j();
        b();
        int d2 = d(view);
        int d3 = d(view2);
        char c2 = d2 < d3 ? (char) 1 : 65535;
        if (this.k) {
            if (c2 == 1) {
                b(d3, this.j.d() - (this.j.a(view2) + this.j.e(view)));
            } else {
                b(d3, this.j.d() - this.j.b(view2));
            }
        } else if (c2 == 65535) {
            b(d3, this.j.a(view2));
        } else {
            b(d3, this.j.b(view2) - this.j.e(view));
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f2694a = true;

        /* renamed from: b  reason: collision with root package name */
        int f2695b;

        /* renamed from: c  reason: collision with root package name */
        int f2696c;

        /* renamed from: d  reason: collision with root package name */
        int f2697d;

        /* renamed from: e  reason: collision with root package name */
        int f2698e;

        /* renamed from: f  reason: collision with root package name */
        int f2699f;

        /* renamed from: g  reason: collision with root package name */
        int f2700g;
        int h = 0;
        boolean i = false;
        int j;
        List<RecyclerView.w> k = null;
        boolean l;

        c() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(RecyclerView.t tVar) {
            int i2 = this.f2697d;
            return i2 >= 0 && i2 < tVar.e();
        }

        /* access modifiers changed from: package-private */
        public View a(RecyclerView.p pVar) {
            if (this.k != null) {
                return b();
            }
            View c2 = pVar.c(this.f2697d);
            this.f2697d += this.f2698e;
            return c2;
        }

        private View b() {
            int size = this.k.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.k.get(i2).itemView;
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                if (!jVar.d() && this.f2697d == jVar.f()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b2 = b(view);
            if (b2 == null) {
                this.f2697d = -1;
            } else {
                this.f2697d = ((RecyclerView.j) b2.getLayoutParams()).f();
            }
        }

        public View b(View view) {
            int size = this.k.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.k.get(i3).itemView;
                RecyclerView.j jVar = (RecyclerView.j) view3.getLayoutParams();
                if (view3 != view && !jVar.d()) {
                    int f2 = (jVar.f() - this.f2697d) * this.f2698e;
                    if (f2 >= 0 && f2 < i2) {
                        if (f2 == 0) {
                            return view3;
                        }
                        view2 = view3;
                        i2 = f2;
                    }
                }
            }
            return view2;
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
        int f2682a;

        /* renamed from: b  reason: collision with root package name */
        int f2683b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2684c;

        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f2682a = parcel.readInt();
            this.f2683b = parcel.readInt();
            this.f2684c = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.f2682a = savedState.f2682a;
            this.f2683b = savedState.f2683b;
            this.f2684c = savedState.f2684c;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f2682a >= 0;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f2682a = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2682a);
            parcel.writeInt(this.f2683b);
            parcel.writeInt(this.f2684c ? 1 : 0);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        p f2685a;

        /* renamed from: b  reason: collision with root package name */
        int f2686b;

        /* renamed from: c  reason: collision with root package name */
        int f2687c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2688d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2689e;

        a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2686b = -1;
            this.f2687c = RNCartPanelDataEntity.NULL_VALUE;
            this.f2688d = false;
            this.f2689e = false;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int i;
            if (this.f2688d) {
                i = this.f2685a.d();
            } else {
                i = this.f2685a.c();
            }
            this.f2687c = i;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2686b + ", mCoordinate=" + this.f2687c + ", mLayoutFromEnd=" + this.f2688d + ", mValid=" + this.f2689e + '}';
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, RecyclerView.t tVar) {
            RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
            return !jVar.d() && jVar.f() >= 0 && jVar.f() < tVar.e();
        }

        public void a(View view, int i) {
            int b2 = this.f2685a.b();
            if (b2 >= 0) {
                b(view, i);
                return;
            }
            this.f2686b = i;
            if (this.f2688d) {
                int d2 = (this.f2685a.d() - b2) - this.f2685a.b(view);
                this.f2687c = this.f2685a.d() - d2;
                if (d2 > 0) {
                    int e2 = this.f2687c - this.f2685a.e(view);
                    int c2 = this.f2685a.c();
                    int min = e2 - (c2 + Math.min(this.f2685a.a(view) - c2, 0));
                    if (min < 0) {
                        this.f2687c += Math.min(d2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int a2 = this.f2685a.a(view);
            int c3 = a2 - this.f2685a.c();
            this.f2687c = a2;
            if (c3 > 0) {
                int d3 = (this.f2685a.d() - Math.min(0, (this.f2685a.d() - b2) - this.f2685a.b(view))) - (a2 + this.f2685a.e(view));
                if (d3 < 0) {
                    this.f2687c -= Math.min(c3, -d3);
                }
            }
        }

        public void b(View view, int i) {
            if (this.f2688d) {
                this.f2687c = this.f2685a.b(view) + this.f2685a.b();
            } else {
                this.f2687c = this.f2685a.a(view);
            }
            this.f2686b = i;
        }
    }

    protected static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2690a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2691b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2692c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2693d;

        protected b() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2690a = 0;
            this.f2691b = false;
            this.f2692c = false;
            this.f2693d = false;
        }
    }
}
