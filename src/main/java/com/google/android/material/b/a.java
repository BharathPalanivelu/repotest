package com.google.android.material.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.f;
import androidx.core.g.w;
import androidx.core.widget.i;
import com.google.android.material.a;
import com.google.android.material.internal.l;
import com.google.android.material.internal.m;

public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final c f13165a;

    /* renamed from: b  reason: collision with root package name */
    private int f13166b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f13167c;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f13168e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f13169f;

    /* renamed from: g  reason: collision with root package name */
    private int f13170g;
    private int h;
    private int i;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.materialButtonStyle);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray a2 = l.a(context, attributeSet, a.k.MaterialButton, i2, a.j.Widget_MaterialComponents_Button, new int[0]);
        this.f13166b = a2.getDimensionPixelSize(a.k.MaterialButton_iconPadding, 0);
        this.f13167c = m.a(a2.getInt(a.k.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f13168e = com.google.android.material.f.a.a(getContext(), a2, a.k.MaterialButton_iconTint);
        this.f13169f = com.google.android.material.f.a.b(getContext(), a2, a.k.MaterialButton_icon);
        this.i = a2.getInteger(a.k.MaterialButton_iconGravity, 1);
        this.f13170g = a2.getDimensionPixelSize(a.k.MaterialButton_iconSize, 0);
        this.f13165a = new c(this);
        this.f13165a.a(a2);
        a2.recycle();
        setCompoundDrawablePadding(this.f13166b);
        b();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT < 21 && c()) {
            this.f13165a.a(canvas);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (c()) {
            this.f13165a.a(colorStateList);
        } else if (this.f13165a != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (c()) {
            return this.f13165a.c();
        }
        return super.getSupportBackgroundTintList();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (c()) {
            this.f13165a.a(mode);
        } else if (this.f13165a != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (c()) {
            return this.f13165a.d();
        }
        return super.getSupportBackgroundTintMode();
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public void setBackgroundColor(int i2) {
        if (c()) {
            this.f13165a.a(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? androidx.appcompat.a.a.a.b(getContext(), i2) : null);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (!c()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            Log.i("MaterialButton", "Setting a custom background is not supported.");
            this.f13165a.a();
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT == 21) {
            c cVar = this.f13165a;
            if (cVar != null) {
                cVar.a(i5 - i3, i4 - i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f13169f != null && this.i == 2) {
            int measureText = (int) getPaint().measureText(getText().toString());
            int i4 = this.f13170g;
            if (i4 == 0) {
                i4 = this.f13169f.getIntrinsicWidth();
            }
            int measuredWidth = (((((getMeasuredWidth() - measureText) - w.k(this)) - i4) - this.f13166b) - w.j(this)) / 2;
            if (a()) {
                measuredWidth = -measuredWidth;
            }
            if (this.h != measuredWidth) {
                this.h = measuredWidth;
                b();
            }
        }
    }

    private boolean a() {
        return w.g(this) == 1;
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setIconPadding(int i2) {
        if (this.f13166b != i2) {
            this.f13166b = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public int getIconPadding() {
        return this.f13166b;
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.f13170g != i2) {
            this.f13170g = i2;
            b();
        }
    }

    public int getIconSize() {
        return this.f13170g;
    }

    public void setIcon(Drawable drawable) {
        if (this.f13169f != drawable) {
            this.f13169f = drawable;
            b();
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? androidx.appcompat.a.a.a.b(getContext(), i2) : null);
    }

    public Drawable getIcon() {
        return this.f13169f;
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f13168e != colorStateList) {
            this.f13168e = colorStateList;
            b();
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public ColorStateList getIconTint() {
        return this.f13168e;
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f13167c != mode) {
            this.f13167c = mode;
            b();
        }
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f13167c;
    }

    private void b() {
        Drawable drawable = this.f13169f;
        if (drawable != null) {
            this.f13169f = drawable.mutate();
            androidx.core.graphics.drawable.a.a(this.f13169f, this.f13168e);
            PorterDuff.Mode mode = this.f13167c;
            if (mode != null) {
                androidx.core.graphics.drawable.a.a(this.f13169f, mode);
            }
            int i2 = this.f13170g;
            if (i2 == 0) {
                i2 = this.f13169f.getIntrinsicWidth();
            }
            int i3 = this.f13170g;
            if (i3 == 0) {
                i3 = this.f13169f.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f13169f;
            int i4 = this.h;
            drawable2.setBounds(i4, 0, i2 + i4, i3);
        }
        i.a(this, this.f13169f, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (c()) {
            this.f13165a.b(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        if (c()) {
            setRippleColor(androidx.appcompat.a.a.a.a(getContext(), i2));
        }
    }

    public ColorStateList getRippleColor() {
        if (c()) {
            return this.f13165a.e();
        }
        return null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (c()) {
            this.f13165a.c(colorStateList);
        }
    }

    public void setStrokeColorResource(int i2) {
        if (c()) {
            setStrokeColor(androidx.appcompat.a.a.a.a(getContext(), i2));
        }
    }

    public ColorStateList getStrokeColor() {
        if (c()) {
            return this.f13165a.f();
        }
        return null;
    }

    public void setStrokeWidth(int i2) {
        if (c()) {
            this.f13165a.b(i2);
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (c()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    public int getStrokeWidth() {
        if (c()) {
            return this.f13165a.g();
        }
        return 0;
    }

    public void setCornerRadius(int i2) {
        if (c()) {
            this.f13165a.c(i2);
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (c()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public int getCornerRadius() {
        if (c()) {
            return this.f13165a.h();
        }
        return 0;
    }

    public int getIconGravity() {
        return this.i;
    }

    public void setIconGravity(int i2) {
        this.i = i2;
    }

    private boolean c() {
        c cVar = this.f13165a;
        return cVar != null && !cVar.b();
    }
}
