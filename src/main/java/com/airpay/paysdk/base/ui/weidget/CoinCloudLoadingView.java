package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.content.b;
import com.airpay.paysdk.base.d.l;
import com.airpay.paysdk.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class CoinCloudLoadingView extends j {

    /* renamed from: a  reason: collision with root package name */
    private final int f3889a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3890b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3891c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3892d;

    /* renamed from: e  reason: collision with root package name */
    private float f3893e;

    /* renamed from: f  reason: collision with root package name */
    private float f3894f;

    /* renamed from: g  reason: collision with root package name */
    private float f3895g;
    private float h;
    private float i;
    private float j;
    private int k;
    private int l;
    private int m;
    private int n;
    private float o;
    private float p;
    private Paint q;
    private Paint r;
    private Bitmap s;
    private Bitmap t;
    private Rect u;
    private Rect v;
    private RectF w;
    private RectF x;
    private Interpolator y;

    public CoinCloudLoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CoinCloudLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoinCloudLoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3889a = l.a(getContext(), 44.0f);
        this.f3890b = l.a(getContext(), 65.0f);
        this.f3891c = l.a(getContext(), 26.0f);
        this.f3892d = l.a(getContext(), 26.0f);
        this.m = 31;
        this.n = -37;
        this.l = b.c(context, c.b.bg_color_dark);
        this.k = b.c(context, c.b.bg_color_normal);
        this.s = BitmapFactory.decodeResource(getResources(), c.d.com_garena_beepay_loading_cloud);
        this.t = BitmapFactory.decodeResource(getResources(), c.d.com_garena_beepay_loading_symbol);
        this.u = new Rect();
        Rect rect = this.u;
        rect.left = 0;
        rect.top = 0;
        rect.right = this.s.getWidth();
        this.u.bottom = this.s.getHeight();
        this.v = new Rect();
        Rect rect2 = this.v;
        rect2.left = 0;
        rect2.top = 0;
        rect2.right = this.t.getWidth();
        this.v.bottom = this.t.getHeight();
        this.w = new RectF();
        this.x = new RectF();
        this.y = androidx.core.g.b.b.a(0.65f, BitmapDescriptorFactory.HUE_RED, 0.35f, 1.0f);
        int i3 = this.k;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.k.CoinCloudLoadingView);
            this.l = obtainStyledAttributes.getColor(c.k.CoinCloudLoadingView_colorForeground, this.l);
            this.k = obtainStyledAttributes.getColor(c.k.CoinCloudLoadingView_colorBackground, this.k);
            i3 = obtainStyledAttributes.getColor(c.k.CoinCloudLoadingView_colorSymbol, i3);
            obtainStyledAttributes.recycle();
        }
        this.q = new Paint();
        this.q.setStyle(Paint.Style.FILL);
        this.q.setAntiAlias(true);
        this.q.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.MULTIPLY));
        this.r = new Paint();
        this.r.setStyle(Paint.Style.FILL);
        this.r.setAntiAlias(true);
        this.r.setColorFilter(new PorterDuffColorFilter(this.l, PorterDuff.Mode.MULTIPLY));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(a(this.f3890b, i2), a(this.f3889a, i3));
    }

    private int a(int i2, int i3) {
        return View.MeasureSpec.getMode(i3) == 1073741824 ? View.MeasureSpec.getSize(i3) : i2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        float min = (float) Math.min(getWidth() / this.f3890b, getHeight() / this.f3889a);
        this.i = ((float) this.f3889a) * min;
        this.j = ((float) this.f3890b) * min;
        RectF rectF = this.w;
        rectF.left = BitmapDescriptorFactory.HUE_RED;
        rectF.top = BitmapDescriptorFactory.HUE_RED;
        float f2 = this.j;
        rectF.right = f2;
        float f3 = this.i;
        rectF.bottom = f3;
        this.f3894f = ((float) this.f3892d) * min;
        this.f3893e = min * ((float) this.f3891c);
        this.f3895g = (f3 - this.f3893e) / 2.0f;
        this.h = (f2 - this.f3894f) / 2.0f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.k);
        canvas.drawBitmap(this.s, this.u, this.w, this.r);
        a(this.x, this.h, this.o, this.f3894f, this.f3893e);
        canvas.drawBitmap(this.t, this.v, this.x, this.q);
        a(this.x, this.h, this.p, this.f3894f, this.f3893e);
        canvas.drawBitmap(this.t, this.v, this.x, this.q);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.o = a(this.m);
        this.p = a(this.n);
        this.m++;
        this.n++;
        int i2 = this.m;
        if (i2 > 0) {
            this.m = i2 % 147;
        }
        int i3 = this.n;
        if (i3 > 0) {
            this.n = i3 % 147;
        }
    }

    private void a(RectF rectF, float f2, float f3, float f4, float f5) {
        rectF.left = f2;
        rectF.top = f3;
        rectF.right = rectF.left + f4;
        rectF.bottom = rectF.top + f5;
    }

    private float a(int i2) {
        if (i2 <= 0 || i2 > 78) {
            return BitmapDescriptorFactory.HUE_RED - this.f3893e;
        }
        if (i2 < 31) {
            float interpolation = this.y.getInterpolation(((float) i2) / 31.0f);
            float f2 = this.f3895g;
            float f3 = this.f3893e;
            return (interpolation * (f2 + f3)) - f3;
        } else if (i2 >= 31 && i2 <= 47) {
            return this.f3895g;
        } else {
            float interpolation2 = this.y.getInterpolation((((float) i2) - 47.0f) / 31.0f);
            float f4 = this.i;
            float f5 = this.f3895g;
            return (interpolation2 * (f4 - f5)) + f5;
        }
    }
}
