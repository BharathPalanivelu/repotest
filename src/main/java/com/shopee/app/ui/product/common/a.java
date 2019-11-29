package com.shopee.app.ui.product.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.a.a.f;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.a;
import com.shopee.id.R;

public class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    EditText f24609a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f24610b;

    /* renamed from: c  reason: collision with root package name */
    TextView f24611c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24612d;

    /* renamed from: e  reason: collision with root package name */
    ProgressBar f24613e;

    /* renamed from: f  reason: collision with root package name */
    View f24614f;

    /* renamed from: g  reason: collision with root package name */
    private int f24615g;
    private String h;
    private int i;
    private String j;
    private int k = 500;
    private String l;
    private String m;

    public a(Context context) {
        super(context);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.SPPriceOption);
        this.f24615g = obtainStyledAttributes.getResourceId(1, -1);
        this.h = obtainStyledAttributes.getString(4);
        this.i = obtainStyledAttributes.getInt(7, 0);
        this.l = obtainStyledAttributes.getString(6);
        this.j = obtainStyledAttributes.getString(0);
        this.k = obtainStyledAttributes.getInt(3, 500);
        this.m = obtainStyledAttributes.getString(5);
        obtainStyledAttributes.recycle();
        setBackgroundResource(R.drawable.bottom_border_white_background);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a(getContext());
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        setGravity(16);
        int i2 = this.f24615g;
        if (i2 != -1) {
            this.f24610b.setImageDrawable(b.f(i2));
        }
        e();
        d();
        if (this.f24609a != null) {
            this.f24609a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.k)});
        }
    }

    private void d() {
        this.f24609a.setEnabled(true);
        int i2 = this.i;
        if (i2 == 0) {
            this.f24609a.setText(this.l);
            this.f24609a.setHint(this.j);
            this.f24609a.setVisibility(0);
            this.f24612d.setVisibility(8);
            this.f24614f.setVisibility(8);
        } else if (i2 == 1) {
            this.f24612d.setVisibility(0);
            this.f24609a.setVisibility(8);
            this.f24612d.setText(this.l);
            this.f24609a.setEnabled(false);
            this.f24612d.setHint(this.j);
            this.f24614f.setVisibility(0);
        } else if (i2 == 2) {
            this.f24609a.setText(this.l);
            this.f24609a.setHint(this.j);
            this.f24609a.setVisibility(0);
            this.f24612d.setVisibility(8);
            this.f24609a.setInputType(2);
            this.f24614f.setVisibility(8);
        } else if (i2 == 3) {
            this.f24609a.setText(this.l);
            this.f24609a.setHint(this.j);
            this.f24609a.setVisibility(0);
            this.f24612d.setVisibility(8);
            this.f24609a.setInputType(8194);
            this.f24614f.setVisibility(8);
        }
    }

    private void e() {
        if (TextUtils.isEmpty(this.m)) {
            this.f24611c.setText(this.h);
        } else {
            f.a(getContext()).a(this.h).b().b().a(SQLBuilder.BLANK).b().b().a(this.m).a().a(b.a.f7696g).b(com.garena.android.appkit.tools.b.a(R.color.black50)).c().b().b().a(this.f24611c);
        }
    }

    public void b() {
        this.f24613e.setVisibility(0);
    }

    public void c() {
        this.f24613e.setVisibility(8);
    }

    public void setText(String str) {
        if (this.i == 1) {
            this.f24612d.setText(str);
        } else {
            this.f24609a.setText(str);
        }
    }

    public void setSmallText(String str) {
        this.m = str;
        e();
    }

    public String getText() {
        if (this.i == 1) {
            return this.f24612d.getText().toString().trim();
        }
        return this.f24609a.getText().toString().trim();
    }

    public void setHint(String str) {
        if (this.i == 1) {
            this.f24612d.setHint(str);
        } else {
            this.f24609a.setHint(str);
        }
    }

    public void setType(int i2) {
        if (i2 != this.i) {
            this.i = i2;
            d();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f24609a.isEnabled()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }
}
