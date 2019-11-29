package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class l {

    /* renamed from: a  reason: collision with root package name */
    boolean f2951a = true;

    /* renamed from: b  reason: collision with root package name */
    int f2952b;

    /* renamed from: c  reason: collision with root package name */
    int f2953c;

    /* renamed from: d  reason: collision with root package name */
    int f2954d;

    /* renamed from: e  reason: collision with root package name */
    int f2955e;

    /* renamed from: f  reason: collision with root package name */
    int f2956f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f2957g = 0;
    boolean h;
    boolean i;

    l() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.t tVar) {
        int i2 = this.f2953c;
        return i2 >= 0 && i2 < tVar.e();
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.p pVar) {
        View c2 = pVar.c(this.f2953c);
        this.f2953c += this.f2954d;
        return c2;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2952b + ", mCurrentPosition=" + this.f2953c + ", mItemDirection=" + this.f2954d + ", mLayoutDirection=" + this.f2955e + ", mStartLine=" + this.f2956f + ", mEndLine=" + this.f2957g + '}';
    }
}
