package com.shopee.app.ui.home.follow.a;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f22216a;

    /* renamed from: b  reason: collision with root package name */
    private a f22217b;

    /* renamed from: c  reason: collision with root package name */
    private int f22218c = 0;

    public c(ViewGroup viewGroup, a aVar) {
        this.f22216a = viewGroup;
        this.f22217b = aVar;
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.f22216a.getWindowVisibleDisplayFrame(rect);
        int height = this.f22216a.getRootView().getHeight();
        int i = height - rect.bottom;
        if (i != a()) {
            a(i);
            if (i > height / 3) {
                this.f22217b.a(i);
            } else {
                this.f22217b.a();
            }
        }
    }

    private int a() {
        return this.f22218c;
    }

    private void a(int i) {
        this.f22218c = i;
    }
}
