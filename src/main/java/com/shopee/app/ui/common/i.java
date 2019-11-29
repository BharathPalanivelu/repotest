package com.shopee.app.ui.common;

import android.animation.ObjectAnimator;
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.app.a;
import com.shopee.id.R;

public class i extends FrameLayout {
    private static Property<i, Float> i = new Property<i, Float>(Float.class, "shadowAlpha") {
        /* renamed from: a */
        public Float get(i iVar) {
            return Float.valueOf(iVar.h);
        }

        /* renamed from: a */
        public void set(i iVar, Float f2) {
            float unused = iVar.h = f2.floatValue();
            w.e(iVar);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private Drawable f21277a;

    /* renamed from: b  reason: collision with root package name */
    private NinePatchDrawable f21278b;

    /* renamed from: c  reason: collision with root package name */
    private int f21279c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21280d;

    /* renamed from: e  reason: collision with root package name */
    private int f21281e;

    /* renamed from: f  reason: collision with root package name */
    private int f21282f;

    /* renamed from: g  reason: collision with root package name */
    private ObjectAnimator f21283g;
    /* access modifiers changed from: private */
    public float h;

    public i(Context context) {
        this(context, (AttributeSet) null, 0);
        this.f21277a = context.getResources().getDrawable(R.drawable.bottom_shadow2);
        Drawable drawable = this.f21277a;
        if (drawable != null) {
            drawable.setCallback(this);
            Drawable drawable2 = this.f21277a;
            if (drawable2 instanceof NinePatchDrawable) {
                this.f21278b = (NinePatchDrawable) drawable2;
            }
        }
        boolean z = true;
        this.f21280d = true;
        if (this.f21280d && this.f21277a != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public i(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.h = 1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.DrawShadowFrameLayout, 0, 0);
        this.f21277a = obtainStyledAttributes.getDrawable(0);
        Drawable drawable = this.f21277a;
        if (drawable != null) {
            drawable.setCallback(this);
            Drawable drawable2 = this.f21277a;
            if (drawable2 instanceof NinePatchDrawable) {
                this.f21278b = (NinePatchDrawable) drawable2;
            }
        }
        boolean z = true;
        this.f21280d = obtainStyledAttributes.getBoolean(1, true);
        if (this.f21280d && this.f21277a != null) {
            z = false;
        }
        setWillNotDraw(z);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f21281e = i2;
        this.f21282f = i3;
        a();
    }

    private void a() {
        Drawable drawable = this.f21277a;
        if (drawable != null) {
            int i2 = this.f21279c;
            drawable.setBounds(0, i2, this.f21281e, b.a.m + i2);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f21277a != null && this.f21280d) {
            NinePatchDrawable ninePatchDrawable = this.f21278b;
            if (ninePatchDrawable != null) {
                ninePatchDrawable.getPaint().setAlpha((int) (this.h * 255.0f));
            }
            this.f21277a.draw(canvas);
        }
    }

    public void setShadowTopOffset(int i2) {
        this.f21279c = i2;
        a();
        w.e(this);
    }

    public void a(boolean z, boolean z2) {
        this.f21280d = z;
        ObjectAnimator objectAnimator = this.f21283g;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f21283g = null;
        }
        boolean z3 = false;
        if (z2 && this.f21277a != null) {
            Property<i, Float> property = i;
            float[] fArr = new float[2];
            float f2 = BitmapDescriptorFactory.HUE_RED;
            fArr[0] = z ? BitmapDescriptorFactory.HUE_RED : 1.0f;
            if (z) {
                f2 = 1.0f;
            }
            fArr[1] = f2;
            this.f21283g = ObjectAnimator.ofFloat(this, property, fArr);
            this.f21283g.setDuration(1000);
            this.f21283g.start();
        }
        w.e(this);
        if (!this.f21280d || this.f21277a == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
    }
}
