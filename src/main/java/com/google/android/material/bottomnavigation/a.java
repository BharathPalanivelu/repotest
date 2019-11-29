package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.at;
import androidx.core.content.b;
import androidx.core.g.t;
import androidx.core.g.w;
import com.google.android.material.a;

public class a extends FrameLayout implements n.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f13230a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private final int f13231b;

    /* renamed from: c  reason: collision with root package name */
    private float f13232c;

    /* renamed from: d  reason: collision with root package name */
    private float f13233d;

    /* renamed from: e  reason: collision with root package name */
    private float f13234e;

    /* renamed from: f  reason: collision with root package name */
    private int f13235f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13236g;
    private ImageView h;
    private final TextView i;
    private final TextView j;
    private int k;
    private i l;
    private ColorStateList m;

    public boolean a() {
        return false;
    }

    public a(Context context) {
        this(context, (AttributeSet) null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(a.h.design_bottom_navigation_item, this, true);
        setBackgroundResource(a.e.design_bottom_navigation_item_background);
        this.f13231b = resources.getDimensionPixelSize(a.d.design_bottom_navigation_margin);
        this.h = (ImageView) findViewById(a.f.icon);
        this.i = (TextView) findViewById(a.f.smallLabel);
        this.j = (TextView) findViewById(a.f.largeLabel);
        w.d((View) this.i, 2);
        w.d((View) this.j, 2);
        setFocusable(true);
        a(this.i.getTextSize(), this.j.getTextSize());
    }

    public void a(i iVar, int i2) {
        this.l = iVar;
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setIcon(iVar.getIcon());
        setTitle(iVar.getTitle());
        setId(iVar.getItemId());
        if (!TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(iVar.getContentDescription());
        }
        at.a(this, iVar.getTooltipText());
        setVisibility(iVar.isVisible() ? 0 : 8);
    }

    public void setItemPosition(int i2) {
        this.k = i2;
    }

    public int getItemPosition() {
        return this.k;
    }

    public void setShifting(boolean z) {
        if (this.f13236g != z) {
            this.f13236g = z;
            if (this.l != null) {
                setChecked(this.l.isChecked());
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f13235f != i2) {
            this.f13235f = i2;
            if (this.l != null) {
                setChecked(this.l.isChecked());
            }
        }
    }

    public i getItemData() {
        return this.l;
    }

    public void setTitle(CharSequence charSequence) {
        this.i.setText(charSequence);
        this.j.setText(charSequence);
        i iVar = this.l;
        if (iVar == null || TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        TextView textView = this.j;
        textView.setPivotX((float) (textView.getWidth() / 2));
        TextView textView2 = this.j;
        textView2.setPivotY((float) textView2.getBaseline());
        TextView textView3 = this.i;
        textView3.setPivotX((float) (textView3.getWidth() / 2));
        TextView textView4 = this.i;
        textView4.setPivotY((float) textView4.getBaseline());
        int i2 = this.f13235f;
        if (i2 != -1) {
            if (i2 == 0) {
                if (z) {
                    a(this.h, this.f13231b, 49);
                    a(this.j, 1.0f, 1.0f, 0);
                } else {
                    a(this.h, this.f13231b, 17);
                    a(this.j, 0.5f, 0.5f, 4);
                }
                this.i.setVisibility(4);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    a(this.h, this.f13231b, 17);
                    this.j.setVisibility(8);
                    this.i.setVisibility(8);
                }
            } else if (z) {
                a(this.h, (int) (((float) this.f13231b) + this.f13232c), 49);
                a(this.j, 1.0f, 1.0f, 0);
                TextView textView5 = this.i;
                float f2 = this.f13233d;
                a(textView5, f2, f2, 4);
            } else {
                a(this.h, this.f13231b, 49);
                TextView textView6 = this.j;
                float f3 = this.f13234e;
                a(textView6, f3, f3, 4);
                a(this.i, 1.0f, 1.0f, 0);
            }
        } else if (this.f13236g) {
            if (z) {
                a(this.h, this.f13231b, 49);
                a(this.j, 1.0f, 1.0f, 0);
            } else {
                a(this.h, this.f13231b, 17);
                a(this.j, 0.5f, 0.5f, 4);
            }
            this.i.setVisibility(4);
        } else if (z) {
            a(this.h, (int) (((float) this.f13231b) + this.f13232c), 49);
            a(this.j, 1.0f, 1.0f, 0);
            TextView textView7 = this.i;
            float f4 = this.f13233d;
            a(textView7, f4, f4, 4);
        } else {
            a(this.h, this.f13231b, 49);
            TextView textView8 = this.j;
            float f5 = this.f13234e;
            a(textView8, f5, f5, 4);
            a(this.i, 1.0f, 1.0f, 0);
        }
        refreshDrawableState();
        setSelected(z);
    }

    private void a(View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private void a(View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.i.setEnabled(z);
        this.j.setEnabled(z);
        this.h.setEnabled(z);
        if (z) {
            w.a((View) this, t.a(getContext(), 1002));
        } else {
            w.a((View) this, (t) null);
        }
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        i iVar = this.l;
        if (iVar != null && iVar.isCheckable() && this.l.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f13230a);
        }
        return onCreateDrawableState;
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
            androidx.core.graphics.drawable.a.a(drawable, this.m);
        }
        this.h.setImageDrawable(drawable);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.m = colorStateList;
        i iVar = this.l;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.h.setLayoutParams(layoutParams);
    }

    public void setTextAppearanceInactive(int i2) {
        androidx.core.widget.i.a(this.i, i2);
        a(this.i.getTextSize(), this.j.getTextSize());
    }

    public void setTextAppearanceActive(int i2) {
        androidx.core.widget.i.a(this.j, i2);
        a(this.i.getTextSize(), this.j.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.i.setTextColor(colorStateList);
            this.j.setTextColor(colorStateList);
        }
    }

    private void a(float f2, float f3) {
        this.f13232c = f2 - f3;
        this.f13233d = (f3 * 1.0f) / f2;
        this.f13234e = (f2 * 1.0f) / f3;
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : b.a(getContext(), i2));
    }

    public void setItemBackground(Drawable drawable) {
        w.a((View) this, drawable);
    }
}
