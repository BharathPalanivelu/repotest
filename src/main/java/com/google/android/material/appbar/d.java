package com.google.android.material.appbar;

import android.view.View;
import androidx.core.g.w;

class d {

    /* renamed from: a  reason: collision with root package name */
    private final View f13159a;

    /* renamed from: b  reason: collision with root package name */
    private int f13160b;

    /* renamed from: c  reason: collision with root package name */
    private int f13161c;

    /* renamed from: d  reason: collision with root package name */
    private int f13162d;

    /* renamed from: e  reason: collision with root package name */
    private int f13163e;

    public d(View view) {
        this.f13159a = view;
    }

    public void a() {
        this.f13160b = this.f13159a.getTop();
        this.f13161c = this.f13159a.getLeft();
        c();
    }

    private void c() {
        View view = this.f13159a;
        w.h(view, this.f13162d - (view.getTop() - this.f13160b));
        View view2 = this.f13159a;
        w.i(view2, this.f13163e - (view2.getLeft() - this.f13161c));
    }

    public boolean a(int i) {
        if (this.f13162d == i) {
            return false;
        }
        this.f13162d = i;
        c();
        return true;
    }

    public boolean b(int i) {
        if (this.f13163e == i) {
            return false;
        }
        this.f13163e = i;
        c();
        return true;
    }

    public int b() {
        return this.f13162d;
    }
}
