package com.garena.android.uikit.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.garena.android.uikit.a.a.b;
import com.garena.android.uikit.a.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public abstract class a implements c.a {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<WeakReference<b>> f7711a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<WeakReference<com.garena.android.uikit.a.a.a>> f7712b = new ArrayList<>();

    public abstract int b();

    public abstract b d(Context context, int i);

    public abstract com.garena.android.uikit.a.a.a e(Context context, int i);

    public b a(Context context, int i) {
        if (i >= b() || i < 0) {
            return null;
        }
        return d(context, i);
    }

    public LinearLayout.LayoutParams b(Context context, int i) {
        return new LinearLayout.LayoutParams(0, -2, 1.0f);
    }

    public com.garena.android.uikit.a.a.a c(Context context, int i) {
        if (i >= b() || i < 0) {
            return null;
        }
        return e(context, i);
    }

    public void a(int i, int i2, View view, View view2, View view3, View view4, boolean z) {
        if (i != -1) {
            if (view instanceof b) {
                ((b) view).b();
            }
            if (view3 instanceof com.garena.android.uikit.a.a.a) {
                ((com.garena.android.uikit.a.a.a) view3).b();
            }
        }
        if (view2 instanceof b) {
            ((b) view2).a();
        }
        if (z && (view4 instanceof com.garena.android.uikit.a.a.a)) {
            ((com.garena.android.uikit.a.a.a) view4).a();
        }
    }

    public void a() {
        this.f7711a.clear();
        this.f7712b.clear();
    }
}
