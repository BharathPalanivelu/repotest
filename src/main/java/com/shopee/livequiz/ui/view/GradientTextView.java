package com.shopee.livequiz.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.devspark.robototextview.widget.RobotoTextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.livequiz.b;

public class GradientTextView extends RobotoTextView {

    /* renamed from: a  reason: collision with root package name */
    private LinearGradient f29972a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f29973b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f29974c;

    /* renamed from: e  reason: collision with root package name */
    private int f29975e;

    /* renamed from: f  reason: collision with root package name */
    private int f29976f;

    /* renamed from: g  reason: collision with root package name */
    private Typeface f29977g;

    public GradientTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GradientTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29974c = new Rect();
        this.f29977g = Typeface.createFromAsset(b.a().c().getAssets(), "fonts/Neuzeit Grotesk Black.otf");
    }

    public void a(int i, int i2) {
        this.f29975e = i;
        this.f29976f = i2;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        this.f29973b = getPaint();
        this.f29973b.setTextAlign(Paint.Align.CENTER);
        String charSequence = getText().toString();
        this.f29973b.getTextBounds(charSequence, 0, charSequence.length(), this.f29974c);
        if (!(this.f29975e == 0 || this.f29976f == 0)) {
            this.f29972a = new LinearGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, getPaint().getTextSize(), new int[]{com.garena.android.appkit.tools.b.a(this.f29975e), com.garena.android.appkit.tools.b.a(this.f29976f)}, (float[]) null, Shader.TileMode.CLAMP);
            this.f29973b.setShader(this.f29972a);
        }
        this.f29973b.setTypeface(this.f29977g);
        canvas.drawText(charSequence, ((float) getMeasuredWidth()) / 2.0f, (((float) getMeasuredHeight()) / 2.0f) + (((float) this.f29974c.height()) / 2.0f), this.f29973b);
    }
}
