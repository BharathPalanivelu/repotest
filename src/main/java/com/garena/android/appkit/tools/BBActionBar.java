package com.garena.android.appkit.tools;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.c;
import com.garena.android.appkit.tools.a.b;

public class BBActionBar extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f7677a;

    /* renamed from: b  reason: collision with root package name */
    protected int f7678b = c.h.bbactionbar;

    /* renamed from: c  reason: collision with root package name */
    protected int f7679c = -1;

    /* renamed from: d  reason: collision with root package name */
    protected int f7680d;

    /* renamed from: e  reason: collision with root package name */
    protected int f7681e;

    /* renamed from: f  reason: collision with root package name */
    private int f7682f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f7683g;
    private LayoutInflater h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private RelativeLayout m;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private int f7684a = 0;

        public abstract void a(View view);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof a) {
            ((a) tag).a(view);
        }
    }

    public BBActionBar(Context context) {
        super(context);
        a(context);
    }

    public BBActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.j.BBActionBar);
        this.f7680d = obtainStyledAttributes.getColor(0, -65536);
        this.f7682f = obtainStyledAttributes.getResourceId(c.j.BBActionBar_background_drawable, c.e.abc_cab_background_internal_bg);
        this.f7678b = obtainStyledAttributes.getResourceId(2, this.f7678b);
        this.f7679c = obtainStyledAttributes.getResourceId(3, this.f7679c);
        this.f7681e = obtainStyledAttributes.getColor(4, -16777216);
        a(context);
    }

    private void a(Context context) {
        this.h = LayoutInflater.from(context);
        this.i = (LinearLayout) this.h.inflate(this.f7678b, (ViewGroup) null);
        addView(this.i, new LinearLayout.LayoutParams(-1, -1));
        this.m = (RelativeLayout) this.i.findViewById(c.f.action_bar_root_relative);
        this.m.setBackgroundColor(this.f7680d);
        if (this.f7680d == -65536) {
            this.m.setBackgroundResource(this.f7682f);
        }
        this.j = (LinearLayout) this.i.findViewById(c.f.actionbar_actions);
        this.f7683g = (TextView) findViewById(c.f.actionbar_title_lab);
        this.f7677a = (LinearLayout) findViewById(c.f.actionbar_home_btn);
        this.f7677a.setClickable(true);
        int i2 = this.f7679c;
        if (i2 != -1) {
            this.f7677a.setBackgroundDrawable(b.f(i2));
        }
        this.k = (LinearLayout) this.i.findViewById(c.f.actionbar_item_host);
        this.l = (LinearLayout) findViewById(c.f.actionbar_title_bg);
        if (c.a().b() <= 240) {
            this.f7683g.setTextSize(2, 18.0f);
        }
    }

    public void setTitleIcon(int i2) {
        a(i2, 10);
    }

    public void a(int i2, int i3) {
        if (i2 > -1) {
            this.f7683g.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
            this.f7683g.setCompoundDrawablePadding(c.a().a(i3));
            return;
        }
        this.f7683g.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f7683g.setCompoundDrawablePadding(0);
    }

    public void setHomeBtnClickable(boolean z) {
        this.f7677a.setClickable(z);
    }

    public void setHomeAction(View.OnClickListener onClickListener) {
        this.f7677a.setOnClickListener(onClickListener);
    }

    public int getActionCount() {
        return this.j.getChildCount();
    }

    public void setTitle(CharSequence charSequence) {
        if (this.f7683g == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f7683g.setVisibility(8);
            return;
        }
        this.f7683g.setVisibility(0);
        this.f7683g.setText(charSequence);
    }

    public void setTitleBackground(int i2) {
        this.f7683g.setBackgroundDrawable(b.f(i2));
        this.f7683g.setPadding(b.a.f7694e, 0, b.a.j, 0);
        this.f7683g.setGravity(16);
    }

    public void setTitleClickListener(View.OnClickListener onClickListener) {
        this.f7683g.setOnClickListener(onClickListener);
    }

    public void setBackground(int i2) {
        this.i.setBackgroundDrawable(b.f(i2));
    }

    public void setHomeBtnBackground(int i2) {
        this.f7677a.setBackgroundDrawable(b.f(i2));
    }

    public void setTitleFontColor(int i2) {
        this.f7683g.setTextColor(i2);
    }

    public void setHomeIcon(int i2) {
        ((ImageView) this.i.findViewById(c.f.actionbar_home_icon)).setImageDrawable(b.f(i2));
    }

    public void setTitleViewOrientation(int i2) {
        this.l.setOrientation(i2);
        if (1 == i2) {
            this.f7683g.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        } else {
            this.f7683g.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        }
    }
}
