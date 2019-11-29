package com.shopee.app.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.shopee.app.tracking.ImpressionObserver;
import java.util.List;

public abstract class u<T> extends z<T> {

    /* renamed from: b  reason: collision with root package name */
    private ImpressionObserver f19222b;

    /* access modifiers changed from: protected */
    public abstract n<T> a(Context context, int i);

    protected u(ImpressionObserver impressionObserver) {
        this.f19222b = impressionObserver;
    }

    public void a(List<T> list) {
        super.a(list);
        this.f19222b.b();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        this.f19222b.a(view);
        View view2 = super.getView(i, view, viewGroup);
        this.f19222b.a(view2, i);
        return view2;
    }
}
