package com.shopee.app.ui.gallery;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class n extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private int f21982a;

    public n(int i) {
        this.f21982a = i;
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
        if (recyclerView.f(view) % 3 == 0) {
            rect.right = this.f21982a / 2;
        } else if (recyclerView.f(view) % 3 == 1) {
            int i = this.f21982a;
            rect.right = i / 2;
            rect.left = i / 2;
        } else {
            rect.left = this.f21982a / 2;
        }
        rect.top = this.f21982a;
    }
}
