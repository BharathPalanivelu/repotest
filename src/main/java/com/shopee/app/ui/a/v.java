package com.shopee.app.ui.a;

import android.view.View;
import android.view.ViewGroup;
import com.shopee.app.tracking.ImpressionObserver;
import java.util.List;

public abstract class v<T> extends aa<T> {

    /* renamed from: b  reason: collision with root package name */
    private ImpressionObserver f19223b;

    public v(s<T> sVar, ImpressionObserver impressionObserver) {
        super(sVar);
        this.f19223b = impressionObserver;
    }

    public void a(List<T> list) {
        super.a(list);
        this.f19223b.b();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        this.f19223b.a(view);
        View view2 = super.getView(i, view, viewGroup);
        this.f19223b.a(view2, i);
        return view2;
    }
}
