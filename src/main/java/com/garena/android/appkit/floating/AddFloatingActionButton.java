package com.garena.android.appkit.floating;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import com.garena.android.appkit.c;

public class AddFloatingActionButton extends FloatingActionButton {
    int mPlusColor;

    public AddFloatingActionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AddFloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AddFloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    public void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.j.AddFloatingActionButton, 0, 0);
        this.mPlusColor = obtainStyledAttributes.getColor(c.j.AddFloatingActionButton_fab_plusIconColor, getColor(17170443));
        obtainStyledAttributes.recycle();
        super.init(context, attributeSet);
    }

    public int getPlusColor() {
        return this.mPlusColor;
    }

    public void setPlusColorResId(int i) {
        setPlusColor(getColor(i));
    }

    public void setPlusColor(int i) {
        if (this.mPlusColor != i) {
            this.mPlusColor = i;
            updateBackground();
        }
    }

    public void setIcon(int i) {
        throw new UnsupportedOperationException("Use FloatingActionButton if you want to use custom icon");
    }

    /* access modifiers changed from: package-private */
    public Drawable getIconDrawable() {
        final float dimension = getDimension(c.d.fab_icon_size);
        final float f2 = dimension / 2.0f;
        float dimension2 = getDimension(c.d.fab_plus_icon_size);
        final float dimension3 = getDimension(c.d.fab_plus_icon_stroke) / 2.0f;
        final float f3 = (dimension - dimension2) / 2.0f;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new Shape() {
            public void draw(Canvas canvas, Paint paint) {
                float f2 = f3;
                float f3 = f2;
                float f4 = dimension3;
                canvas.drawRect(f2, f3 - f4, dimension - f2, f3 + f4, paint);
                float f5 = f2;
                float f6 = dimension3;
                float f7 = f3;
                canvas.drawRect(f5 - f6, f7, f5 + f6, dimension - f7, paint);
            }
        });
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(this.mPlusColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        return shapeDrawable;
    }
}
