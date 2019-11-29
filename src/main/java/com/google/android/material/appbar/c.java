package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class c<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a  reason: collision with root package name */
    private d f13156a;

    /* renamed from: b  reason: collision with root package name */
    private int f13157b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f13158c = 0;

    public c() {
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        a(coordinatorLayout, v, i);
        if (this.f13156a == null) {
            this.f13156a = new d(v);
        }
        this.f13156a.a();
        int i2 = this.f13157b;
        if (i2 != 0) {
            this.f13156a.a(i2);
            this.f13157b = 0;
        }
        int i3 = this.f13158c;
        if (i3 == 0) {
            return true;
        }
        this.f13156a.b(i3);
        this.f13158c = 0;
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.b((View) v, i);
    }

    public boolean a(int i) {
        d dVar = this.f13156a;
        if (dVar != null) {
            return dVar.a(i);
        }
        this.f13157b = i;
        return false;
    }

    public int b() {
        d dVar = this.f13156a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }
}
