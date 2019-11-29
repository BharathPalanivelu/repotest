package com.garena.android.appkit.tools;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.garena.android.appkit.c;

public class BBBadgeView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private int f7685a = 0;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f7686b;

    public BBBadgeView(Context context) {
        super(context);
        a();
    }

    public BBBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BBBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void setNumber(int i) {
        if (i > this.f7685a) {
            setText(b.a(c.i.notification_max_plus, Integer.valueOf(this.f7685a)));
            return;
        }
        setText(Integer.toString(i));
    }

    public void setMaxNumber(int i) {
        this.f7685a = i;
    }

    private void a() {
        setTypeface(Typeface.DEFAULT_BOLD);
        int b2 = b(5);
        setPadding(b2, 0, b2, 0);
        setTextColor(-1);
        if (this.f7686b == null) {
            this.f7686b = b();
            setBackgroundDrawable(this.f7686b);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    private ShapeDrawable b() {
        float b2 = (float) b(8);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{b2, b2, b2, b2, b2, b2, b2, b2}, (RectF) null, (float[]) null));
        Paint paint = shapeDrawable.getPaint();
        int parseColor = Color.parseColor("#CCFF0000");
        if (!isInEditMode()) {
            parseColor = b.a(c.C0125c.appkit_badge_color);
        }
        paint.setShader(new RadialGradient(37.5f, 12.5f, 50.0f, parseColor, -65536, Shader.TileMode.CLAMP));
        return shapeDrawable;
    }

    private ShapeDrawable a(int i) {
        float b2 = (float) b(8);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{b2, b2, b2, b2, b2, b2, b2, b2}, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setShader(new RadialGradient(37.5f, 12.5f, 50.0f, i, i, Shader.TileMode.CLAMP));
        return shapeDrawable;
    }

    public void setBackgroundShapeColor(int i) {
        setBackgroundDrawable((Drawable) null);
        this.f7686b = a(i);
        setBackgroundDrawable(this.f7686b);
    }

    private int b(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }
}
