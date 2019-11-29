package com.shopee.app.ui.common;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.uikit.a.a.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.id.R;

public class ao extends b {

    /* renamed from: a  reason: collision with root package name */
    protected TextView f21153a;

    /* renamed from: b  reason: collision with root package name */
    private int f21154b = 0;

    /* renamed from: c  reason: collision with root package name */
    private f f21155c;

    /* renamed from: d  reason: collision with root package name */
    private int f21156d = com.garena.android.appkit.tools.b.a(R.color.black87);

    /* renamed from: e  reason: collision with root package name */
    private int f21157e = com.garena.android.appkit.tools.b.a(R.color.primary);

    /* renamed from: f  reason: collision with root package name */
    private float f21158f;

    /* renamed from: g  reason: collision with root package name */
    private float f21159g;

    public ao(Context context) {
        super(context);
        a(context, (String) null);
    }

    public ao(Context context, String str) {
        super(context);
        a(context, str);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, String str) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f21153a = new RobotoTextView(context);
        this.f21153a.setId(R.id.title_text);
        this.f21153a.setSingleLine(true);
        this.f21153a.setEllipsize(TextUtils.TruncateAt.END);
        this.f21153a.setGravity(17);
        this.f21153a.setPadding(b.a.f7693d, 0, b.a.f7693d, 0);
        TextView textView = this.f21153a;
        float f2 = this.f21159g;
        if (f2 <= BitmapDescriptorFactory.HUE_RED) {
            f2 = 14.0f;
        }
        textView.setTextSize(f2);
        com.devspark.robototextview.b.a(this.f21153a, com.devspark.robototextview.b.a(context, 4));
        this.f21153a.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        this.f21153a.setMinimumWidth(b.a.q);
        setBackgroundResource(R.drawable.tab_header_background);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (b.a.h * 4) - b.a.f7690a);
        layoutParams.gravity = 17;
        frameLayout.addView(this.f21153a, layoutParams);
        if (str != null) {
            this.f21155c = BadgeView_.a(getContext());
            this.f21155c.setTag(str);
            this.f21155c.c();
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 21;
            layoutParams2.rightMargin = b.a.f7694e;
            frameLayout.addView(this.f21155c, layoutParams2);
        }
        addView(frameLayout, new LinearLayout.LayoutParams(-1, Math.max(this.f21154b, b.a.h * 4)));
    }

    public void setTitle(String str) {
        this.f21153a.setText(str);
    }

    public void setTitle(int i) {
        this.f21153a.setText(i);
    }

    public void setDeselectedColor(int i) {
        this.f21156d = i;
        this.f21153a.setTextColor(this.f21156d);
    }

    public void setSelectedColor(int i) {
        this.f21157e = i;
    }

    public void setSelectedTextSize(float f2) {
        this.f21158f = f2;
    }

    public void setDeselectedTextSize(float f2) {
        this.f21159g = f2;
        float f3 = this.f21159g;
        if (f3 > BitmapDescriptorFactory.HUE_RED) {
            this.f21153a.setTextSize(f3);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f21155c != null) {
            float measuredWidth = (((float) (getMeasuredWidth() - this.f21153a.getMeasuredWidth())) / 2.0f) - ((float) this.f21155c.getMeasuredWidth());
            if (measuredWidth < BitmapDescriptorFactory.HUE_RED) {
                measuredWidth = BitmapDescriptorFactory.HUE_RED;
            }
            ((FrameLayout.LayoutParams) this.f21155c.getLayoutParams()).rightMargin = (int) measuredWidth;
            if (this.f21155c.f()) {
                ((FrameLayout.LayoutParams) this.f21155c.getLayoutParams()).gravity = 5;
                ((FrameLayout.LayoutParams) this.f21155c.getLayoutParams()).topMargin = b.a.f7695f;
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void a() {
        this.f21153a.setTextColor(this.f21157e);
        float f2 = this.f21158f;
        if (f2 > BitmapDescriptorFactory.HUE_RED) {
            this.f21153a.setTextSize(f2);
        }
    }

    public void b() {
        this.f21153a.setTextColor(this.f21156d);
        float f2 = this.f21159g;
        if (f2 > BitmapDescriptorFactory.HUE_RED) {
            this.f21153a.setTextSize(f2);
        }
    }

    public f getBadgeView() {
        return this.f21155c;
    }
}
