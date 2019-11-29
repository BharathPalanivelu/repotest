package com.shopee.feeds.feedlibrary.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.devspark.robototextview.widget.RobotoEditText;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;

public class GradientEditText extends RobotoEditText {

    /* renamed from: a  reason: collision with root package name */
    private static final int f28443a = c.b.feeds_comment_comment_sticker_text_gradient_start;

    /* renamed from: b  reason: collision with root package name */
    private static final int f28444b = c.b.feeds_comment_comment_sticker_text_gradient_end;

    /* renamed from: c  reason: collision with root package name */
    private int f28445c = f28443a;

    /* renamed from: d  reason: collision with root package name */
    private int f28446d = f28444b;

    /* renamed from: e  reason: collision with root package name */
    private LinearGradient f28447e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f28448f;

    /* renamed from: g  reason: collision with root package name */
    private int f28449g = 0;
    private int h = 0;
    private Rect i = new Rect();

    public GradientEditText(Context context) {
        super(context);
    }

    public GradientEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GradientEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setStartColor(int i2) {
        this.f28445c = i2;
    }

    public void setEndColor(int i2) {
        this.f28446d = i2;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        String obj = getText().toString();
        this.f28448f = getPaint();
        if (TextUtils.isEmpty(obj)) {
            this.f28448f.setShader((Shader) null);
        } else {
            this.f28449g = getMeasuredWidth();
            this.f28448f.getTextBounds(obj, 0, obj.length(), this.i);
            this.f28447e = new LinearGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) this.f28449g, BitmapDescriptorFactory.HUE_RED, new int[]{b.a(this.f28445c), b.a(this.f28446d)}, (float[]) null, Shader.TileMode.CLAMP);
            this.f28448f.setShader(this.f28447e);
        }
        super.onDraw(canvas);
    }
}
