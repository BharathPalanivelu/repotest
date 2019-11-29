package com.shopee.app.ui.actionbox2.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.app.a;
import com.shopee.app.ui.common.f;
import com.shopee.app.util.bm;
import com.shopee.id.R;

public class d extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageView f19441a;

    /* renamed from: b  reason: collision with root package name */
    TextView f19442b;

    /* renamed from: c  reason: collision with root package name */
    TextView f19443c;

    /* renamed from: d  reason: collision with root package name */
    f f19444d;

    /* renamed from: e  reason: collision with root package name */
    View f19445e;

    /* renamed from: f  reason: collision with root package name */
    View f19446f;

    /* renamed from: g  reason: collision with root package name */
    int f19447g;
    int h;
    int i;
    private String j;
    private String k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;

    public d(Context context) {
        super(context);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    @TargetApi(21)
    public d(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.ActionBoxHeader);
        this.j = obtainStyledAttributes.getString(2);
        this.l = obtainStyledAttributes.getResourceId(0, 0);
        this.k = obtainStyledAttributes.getString(1);
        this.m = obtainStyledAttributes.getBoolean(4, true);
        this.n = obtainStyledAttributes.getBoolean(3, false);
        this.o = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
    }

    public void setTitle(String str) {
        this.j = str;
        this.f19442b.setText(this.j);
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f19443c.setVisibility(0);
            this.f19443c.setText(bm.d(str));
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f19441a.setImageResource(this.l);
        this.f19442b.setText(this.j);
        this.f19443c.setText(this.k);
        if (this.m) {
            this.f19444d.c();
            this.f19444d.setVisibility(0);
        } else {
            this.f19444d.setVisibility(8);
        }
        if (this.n) {
            View view = this.f19446f;
            int i2 = this.f19447g;
            int i3 = this.h;
            view.setPadding(i2, i3, i2, i3);
            this.f19446f.setMinimumHeight(this.i);
        } else {
            View view2 = this.f19446f;
            int i4 = this.f19447g;
            view2.setPadding(i4, i4, i4, i4);
        }
        if (this.o) {
            setBackgroundResource(R.drawable.top_border_white_background_highlight);
        } else {
            setBackgroundResource(R.drawable.white_background_highlight);
        }
    }

    public void setBadgeCount(int i2) {
        this.f19444d.setNumber(Integer.valueOf(i2));
    }
}
