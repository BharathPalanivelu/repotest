package com.shopee.app.ui.image.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.ui.image.editor.d.d;
import com.shopee.id.R;
import d.d.b.j;
import java.util.ArrayList;
import java.util.List;
import org.c.a.a;

public final class PageIndicatorView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final int f23018a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23019b;

    /* renamed from: c  reason: collision with root package name */
    private final List<View> f23020c;

    public PageIndicatorView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PageIndicatorView(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        this.f23018a = d.a(6, context);
        this.f23019b = b.a.f7693d;
        this.f23020c = new ArrayList();
    }

    public final void setIndicators(int i) {
        int i2 = 1;
        if (1 <= i) {
            while (true) {
                View view = new View(getContext());
                view.setBackgroundResource(R.drawable.grey_circle_bg);
                int i3 = this.f23018a;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
                a.a(layoutParams, this.f23019b);
                addView(view, layoutParams);
                this.f23020c.add(view);
                if (i2 != i) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public final void a(int i, boolean z) {
        if (i >= 0 && i < this.f23020c.size()) {
            View view = this.f23020c.get(i);
            if (z) {
                view.setBackgroundResource(R.drawable.white_circle_bg);
            } else {
                view.setBackgroundResource(R.drawable.grey_circle_bg);
            }
        }
    }
}
