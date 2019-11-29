package com.google.android.material.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final View f13276a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13277b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f13278c = 0;

    public c(b bVar) {
        this.f13276a = (View) bVar;
    }

    public boolean a() {
        return this.f13277b;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f13277b);
        bundle.putInt("expandedComponentIdHint", this.f13278c);
        return bundle;
    }

    public void a(Bundle bundle) {
        this.f13277b = bundle.getBoolean("expanded", false);
        this.f13278c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f13277b) {
            d();
        }
    }

    public void a(int i) {
        this.f13278c = i;
    }

    public int c() {
        return this.f13278c;
    }

    private void d() {
        ViewParent parent = this.f13276a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).b(this.f13276a);
        }
    }
}
