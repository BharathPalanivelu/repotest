package com.shopee.livequiz.ui.view.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    protected View f29998a;

    /* renamed from: b  reason: collision with root package name */
    protected long f29999b;

    /* access modifiers changed from: protected */
    public int getContentId() {
        return 0;
    }

    public a(Context context) {
        this(context, (AttributeSet) null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29998a = View.inflate(context, getContentId(), this);
    }

    public void a() {
        setVisibility(0);
        this.f29999b = System.currentTimeMillis();
    }

    public void b() {
        setVisibility(8);
        this.f29999b = 0;
    }

    public boolean c() {
        return getVisibility() == 0;
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return getContext().getResources().getConfiguration().orientation == 2;
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i, int i2, int i3, int i4) {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            if (i >= 0) {
                layoutParams.leftMargin = i;
            }
            if (i2 >= 0) {
                layoutParams.topMargin = i2;
            }
            if (i3 >= 0) {
                layoutParams.rightMargin = i3;
            }
            if (i4 >= 0) {
                layoutParams.bottomMargin = i4;
            }
            view.setLayoutParams(layoutParams);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void b(View view, int i, int i2, int i3, int i4) {
        try {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            if (i >= 0) {
                layoutParams.leftMargin = i;
            }
            if (i2 >= 0) {
                layoutParams.topMargin = i2;
            }
            if (i3 >= 0) {
                layoutParams.rightMargin = i3;
            }
            if (i4 >= 0) {
                layoutParams.bottomMargin = i4;
            }
            view.setLayoutParams(layoutParams);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i, int i2) {
        try {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            if (i >= 0) {
                layoutParams.width = i;
            }
            if (i2 >= 0) {
                layoutParams.height = i2;
            }
            view.setLayoutParams(layoutParams);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
