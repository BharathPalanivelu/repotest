package com.shopee.app.ui.common;

import android.view.View;
import android.widget.FrameLayout;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.uikit.a.b;
import com.shopee.id.R;

public class ap extends b {

    /* renamed from: a  reason: collision with root package name */
    private final int f21160a;

    public ap(int i) {
        this.f21160a = i;
    }

    public View a(FrameLayout frameLayout) {
        int width = frameLayout.getWidth() / this.f21160a;
        View view = new View(frameLayout.getContext());
        view.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.primary));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, b.a.f7691b);
        layoutParams.gravity = 80;
        frameLayout.addView(view, layoutParams);
        return view;
    }

    public void a(int i, View view, FrameLayout frameLayout, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (i2 != 0 || layoutParams.width == 0) {
            if (i2 == -1) {
                i2 = 0;
            }
            layoutParams.width = frameLayout.getWidth() / this.f21160a;
            int width = frameLayout.getWidth();
            int i3 = this.f21160a;
            layoutParams.leftMargin = ((width / i3) * i) + (i2 / i3);
            view.requestLayout();
        }
    }
}
