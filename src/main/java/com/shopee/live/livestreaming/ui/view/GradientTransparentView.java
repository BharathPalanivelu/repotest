package com.shopee.live.livestreaming.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;

public class GradientTransparentView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f29153a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f29154b;

    /* renamed from: c  reason: collision with root package name */
    private int f29155c;

    /* renamed from: d  reason: collision with root package name */
    private int f29156d;

    public GradientTransparentView(Context context) {
        super(context);
    }

    public GradientTransparentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        boolean z = width > height;
        float f2 = (float) width;
        float f3 = 0.5f;
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f2, ((float) getHeight()) * (z ? 0.5f : 0.251f), z ? getTopPaintForLandscape() : getTopPaintForPortrait());
        float f4 = (float) height;
        if (!z) {
            f3 = 0.406f;
        }
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f4 - (f3 * f4), f2, f4, z ? getBottomPaintForLandscape() : getBottomPaintForPortrait());
        this.f29155c = width;
        this.f29156d = height;
    }

    private Paint getTopPaintForPortrait() {
        if (!(this.f29153a != null && this.f29155c == getWidth() && this.f29156d == getHeight())) {
            int a2 = b.a(c.b.black_45);
            int a3 = b.a(c.b.black_40);
            int a4 = b.a(c.b.black_35);
            int a5 = b.a(c.b.black_30);
            int a6 = b.a(c.b.black_25);
            int a7 = b.a(c.b.black_20);
            int a8 = b.a(c.b.black_15);
            int a9 = b.a(c.b.black_10);
            int a10 = b.a(c.b.black_5);
            int a11 = b.a(c.b.black_1);
            int a12 = b.a(c.b.black_0);
            this.f29153a = new Paint();
            this.f29153a.setShader(new LinearGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0.251f * ((float) getHeight()), new int[]{a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12}, (float[]) null, Shader.TileMode.CLAMP));
        }
        return this.f29153a;
    }

    private Paint getBottomPaintForPortrait() {
        if (!(this.f29154b != null && this.f29155c == getWidth() && this.f29156d == getHeight())) {
            int a2 = b.a(c.b.black_45);
            int a3 = b.a(c.b.black_40);
            int a4 = b.a(c.b.black_35);
            int a5 = b.a(c.b.black_30);
            int a6 = b.a(c.b.black_25);
            int a7 = b.a(c.b.black_20);
            int a8 = b.a(c.b.black_15);
            int a9 = b.a(c.b.black_10);
            int a10 = b.a(c.b.black_5);
            int a11 = b.a(c.b.black_1);
            int a12 = b.a(c.b.black_0);
            this.f29154b = new Paint();
            float height = (float) getHeight();
            int[] iArr = {a12, a11, a10, a9, a8, a7, a6, a5, a4, a3, a2};
            LinearGradient linearGradient = r13;
            LinearGradient linearGradient2 = new LinearGradient(BitmapDescriptorFactory.HUE_RED, height - (0.406f * height), BitmapDescriptorFactory.HUE_RED, height, iArr, (float[]) null, Shader.TileMode.CLAMP);
            this.f29154b.setShader(linearGradient);
        }
        return this.f29154b;
    }

    private Paint getTopPaintForLandscape() {
        if (!(this.f29153a != null && this.f29155c == getWidth() && this.f29156d == getHeight())) {
            int a2 = b.a(c.b.black_45);
            int a3 = b.a(c.b.black_9);
            int a4 = b.a(c.b.black_0);
            this.f29153a = new Paint();
            this.f29153a.setShader(new LinearGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0.5f * ((float) getHeight()), new int[]{a2, a3, a4}, (float[]) null, Shader.TileMode.CLAMP));
        }
        return this.f29153a;
    }

    private Paint getBottomPaintForLandscape() {
        if (!(this.f29154b != null && this.f29155c == getWidth() && this.f29156d == getHeight())) {
            int a2 = b.a(c.b.black_45);
            int a3 = b.a(c.b.black_9);
            int a4 = b.a(c.b.black_0);
            this.f29154b = new Paint();
            float height = (float) getHeight();
            this.f29154b.setShader(new LinearGradient(BitmapDescriptorFactory.HUE_RED, height - (0.5f * height), BitmapDescriptorFactory.HUE_RED, height, new int[]{a4, a3, a2}, (float[]) null, Shader.TileMode.CLAMP));
        }
        return this.f29154b;
    }
}
