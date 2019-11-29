package com.shopee.feeds.feedlibrary.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class a extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private int f28513a;

    /* renamed from: b  reason: collision with root package name */
    private int f28514b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f28515c;

    public a(int i, int i2, boolean z) {
        this.f28513a = i;
        this.f28514b = i2;
        this.f28515c = z;
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
        int f2 = recyclerView.f(view);
        int i = this.f28513a;
        int i2 = f2 % i;
        if (this.f28515c) {
            int i3 = this.f28514b;
            rect.left = i3 - ((i2 * i3) / i);
            rect.right = ((i2 + 1) * i3) / i;
            if (f2 < i) {
                rect.top = i3;
            }
            rect.bottom = this.f28514b;
            return;
        }
        int i4 = this.f28514b;
        rect.left = (i2 * i4) / i;
        rect.right = i4 - (((i2 + 1) * i4) / i);
        if (f2 < i) {
            rect.top = i4;
        }
        rect.bottom = this.f28514b;
    }
}
