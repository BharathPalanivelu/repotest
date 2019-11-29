package com.shopee.sdk.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.util.Property;
import android.widget.FrameLayout;
import androidx.core.g.w;
import com.garena.android.appkit.tools.a.b;
import com.shopee.sdk.a;

public class DrawShadowFrameLayout extends FrameLayout {
    private static Property<DrawShadowFrameLayout, Float> h = new Property<DrawShadowFrameLayout, Float>(Float.class, "shadowAlpha") {
        /* renamed from: a */
        public Float get(DrawShadowFrameLayout drawShadowFrameLayout) {
            return Float.valueOf(drawShadowFrameLayout.f30457g);
        }

        /* renamed from: a */
        public void set(DrawShadowFrameLayout drawShadowFrameLayout, Float f2) {
            float unused = drawShadowFrameLayout.f30457g = f2.floatValue();
            w.e(drawShadowFrameLayout);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private Drawable f30451a;

    /* renamed from: b  reason: collision with root package name */
    private NinePatchDrawable f30452b;

    /* renamed from: c  reason: collision with root package name */
    private int f30453c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f30454d;

    /* renamed from: e  reason: collision with root package name */
    private int f30455e;

    /* renamed from: f  reason: collision with root package name */
    private int f30456f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public float f30457g;

    public DrawShadowFrameLayout(Context context) {
        this(context, (AttributeSet) null, 0);
        this.f30451a = context.getResources().getDrawable(a.C0467a.bottom_shadow2);
        Drawable drawable = this.f30451a;
        if (drawable != null) {
            drawable.setCallback(this);
            Drawable drawable2 = this.f30451a;
            if (drawable2 instanceof NinePatchDrawable) {
                this.f30452b = (NinePatchDrawable) drawable2;
            }
        }
        boolean z = true;
        this.f30454d = true;
        if (this.f30454d && this.f30451a != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public DrawShadowFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawShadowFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30457g = 1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.d.DrawShadowFrameLayout, 0, 0);
        this.f30451a = obtainStyledAttributes.getDrawable(a.d.DrawShadowFrameLayout_shadowDrawable);
        Drawable drawable = this.f30451a;
        if (drawable != null) {
            drawable.setCallback(this);
            Drawable drawable2 = this.f30451a;
            if (drawable2 instanceof NinePatchDrawable) {
                this.f30452b = (NinePatchDrawable) drawable2;
            }
        }
        boolean z = true;
        this.f30454d = obtainStyledAttributes.getBoolean(a.d.DrawShadowFrameLayout_shadowVisible, true);
        if (this.f30454d && this.f30451a != null) {
            z = false;
        }
        setWillNotDraw(z);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f30455e = i;
        this.f30456f = i2;
        a();
    }

    private void a() {
        Drawable drawable = this.f30451a;
        if (drawable != null) {
            int i = this.f30453c;
            drawable.setBounds(0, i, this.f30455e, b.a.m + i);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f30451a != null && this.f30454d) {
            NinePatchDrawable ninePatchDrawable = this.f30452b;
            if (ninePatchDrawable != null) {
                ninePatchDrawable.getPaint().setAlpha((int) (this.f30457g * 255.0f));
            }
            this.f30451a.draw(canvas);
        }
    }

    public void setShadowTopOffset(int i) {
        this.f30453c = i;
        a();
        w.e(this);
    }
}
