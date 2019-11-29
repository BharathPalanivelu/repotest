package com.shopee.feeds.feedlibrary.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;

public class GradientTextView extends RobotoTextView {

    /* renamed from: a  reason: collision with root package name */
    private static final int f28450a = c.b.feeds_comment_comment_sticker_text_gradient_start;

    /* renamed from: b  reason: collision with root package name */
    private static final int f28451b = c.b.feeds_comment_comment_sticker_text_gradient_end;

    /* renamed from: c  reason: collision with root package name */
    private int f28452c;

    /* renamed from: e  reason: collision with root package name */
    private int f28453e;

    /* renamed from: f  reason: collision with root package name */
    private LinearGradient f28454f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f28455g;
    private int h;
    private Rect i;

    public GradientTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GradientTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.h = 0;
        this.i = new Rect();
        this.f28452c = f28450a;
        this.f28453e = f28451b;
    }

    public void a(int i2, int i3) {
        this.f28452c = i2;
        this.f28453e = i3;
        invalidate();
    }

    public void setStartColor(int i2) {
        this.f28452c = i2;
    }

    public void setEndColor(int i2) {
        this.f28453e = i2;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        this.h = getMeasuredWidth();
        this.f28455g = getPaint();
        String charSequence = getText().toString();
        this.f28455g.getTextBounds(charSequence, 0, charSequence.length(), this.i);
        this.f28454f = new LinearGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) this.h, BitmapDescriptorFactory.HUE_RED, new int[]{b.a(this.f28452c), b.a(this.f28453e)}, (float[]) null, Shader.TileMode.CLAMP);
        this.f28455g.setShader(this.f28454f);
        super.onDraw(canvas);
    }
}
