package com.shopee.app.ui.common;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.uikit.a.b;
import com.shopee.id.R;

public class aq extends b {

    /* renamed from: a  reason: collision with root package name */
    private final int f21161a;

    /* renamed from: b  reason: collision with root package name */
    private float f21162b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private int f21163c;

    /* renamed from: d  reason: collision with root package name */
    private int f21164d;

    /* renamed from: e  reason: collision with root package name */
    private int f21165e = com.garena.android.appkit.tools.b.a(R.color.primary);

    public aq(int i) {
        this.f21161a = i;
    }

    public void a(int i) {
        this.f21165e = i;
    }

    public View a(FrameLayout frameLayout) {
        int width = ((LinearLayout) frameLayout.getChildAt(0)).getChildAt(0).getWidth();
        View view = new View(frameLayout.getContext());
        view.setBackgroundColor(this.f21165e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, b.a.f7691b);
        layoutParams.gravity = 80;
        frameLayout.addView(view, layoutParams);
        return view;
    }

    public void a(int i, View view, FrameLayout frameLayout, int i2) {
        this.f21163c = i2;
        this.f21164d = i;
        int i3 = (int) (((float) i2) * this.f21162b);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams != null) {
            if (i < this.f21161a - 1) {
                View childAt = ((LinearLayout) frameLayout.getChildAt(0)).getChildAt(i);
                View childAt2 = ((LinearLayout) frameLayout.getChildAt(0)).getChildAt(i + 1);
                if (i3 != 0 || layoutParams.width == 0) {
                    if (i3 == -1) {
                        i3 = 0;
                    }
                    float width = (((float) i3) * 1.0f) / ((float) ((View) frameLayout.getParent()).getWidth());
                    layoutParams.width = childAt.getWidth() + ((int) (((float) (childAt2.getWidth() - childAt.getWidth())) * width));
                    layoutParams.leftMargin = childAt.getLeft() + ((int) (((float) childAt.getWidth()) * width));
                }
            }
            if (i == this.f21161a - 1 && i > 0) {
                View childAt3 = ((LinearLayout) frameLayout.getChildAt(0)).getChildAt(i - 1);
                View childAt4 = ((LinearLayout) frameLayout.getChildAt(0)).getChildAt(i);
                if (i3 != 0 || layoutParams.width == 0) {
                    if (i3 == -1) {
                        i3 = com.garena.android.appkit.tools.b.b();
                    }
                    float width2 = (((float) i3) * 1.0f) / ((float) ((View) frameLayout.getParent()).getWidth());
                    layoutParams.width = childAt3.getWidth() + ((int) (((float) (childAt4.getWidth() - childAt3.getWidth())) * width2));
                    layoutParams.leftMargin = childAt3.getLeft() + ((int) (((float) childAt3.getWidth()) * width2));
                }
            }
            view.requestLayout();
        }
    }
}
