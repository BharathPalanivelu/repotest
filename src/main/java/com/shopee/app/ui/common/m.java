package com.shopee.app.ui.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.a;
import com.shopee.id.R;

public class m extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f21299a;

    public m(Context context) {
        super(context);
        a(context);
    }

    public m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        a(context, attributeSet);
    }

    public m(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
        a(context, attributeSet);
    }

    private void a(Context context) {
        if (!isInEditMode()) {
            this.f21299a = b.a(R.color.primary);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.IconImageView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.f21299a = obtainStyledAttributes.getColor(index, getResources().getColor(R.color.primary));
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        b();
    }

    public void setImageResource(int i) {
        setImageDrawable(b.f(i));
    }

    public void setColor(int i) {
        this.f21299a = i;
        b();
    }

    private void b() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Drawable g2 = androidx.core.graphics.drawable.a.g(drawable.mutate());
            androidx.core.graphics.drawable.a.a(g2, this.f21299a);
            setImageDrawable(g2);
            invalidate();
        }
    }
}
