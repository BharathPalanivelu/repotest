package com.afollestad.materialdialogs.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.afollestad.materialdialogs.a.a;
import com.afollestad.materialdialogs.e;
import com.afollestad.materialdialogs.g;

public class MDButton extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3167a = false;

    /* renamed from: b  reason: collision with root package name */
    private e f3168b;

    /* renamed from: c  reason: collision with root package name */
    private int f3169c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f3170d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f3171e;

    public MDButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0, 0);
    }

    public MDButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i, 0);
    }

    @TargetApi(21)
    public MDButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f3169c = context.getResources().getDimensionPixelSize(g.d.md_dialog_frame_margin);
        this.f3168b = e.END;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z, boolean z2) {
        if (this.f3167a != z || z2) {
            setGravity(z ? this.f3168b.getGravityInt() | 16 : 17);
            if (Build.VERSION.SDK_INT >= 17) {
                setTextAlignment(z ? this.f3168b.getTextAlignment() : 4);
            }
            a.a((View) this, z ? this.f3170d : this.f3171e);
            if (z) {
                setPadding(this.f3169c, getPaddingTop(), this.f3169c, getPaddingBottom());
            }
            this.f3167a = z;
        }
    }

    public void setStackedGravity(e eVar) {
        this.f3168b = eVar;
    }

    public void setStackedSelector(Drawable drawable) {
        this.f3170d = drawable;
        if (this.f3167a) {
            a(true, true);
        }
    }

    public void setDefaultSelector(Drawable drawable) {
        this.f3171e = drawable;
        if (!this.f3167a) {
            a(false, true);
        }
    }

    public void setAllCapsCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 14) {
            setAllCaps(z);
        } else if (z) {
            setTransformationMethod(new androidx.appcompat.d.a(getContext()));
        } else {
            setTransformationMethod((TransformationMethod) null);
        }
    }
}
