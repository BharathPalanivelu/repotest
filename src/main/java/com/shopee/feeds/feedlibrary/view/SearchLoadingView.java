package com.shopee.feeds.feedlibrary.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;

public class SearchLoadingView extends View {

    /* renamed from: a  reason: collision with root package name */
    boolean f28476a;

    /* renamed from: b  reason: collision with root package name */
    boolean f28477b;

    /* renamed from: c  reason: collision with root package name */
    private final float f28478c;

    /* renamed from: d  reason: collision with root package name */
    private final float f28479d;

    /* renamed from: e  reason: collision with root package name */
    private float f28480e;

    /* renamed from: f  reason: collision with root package name */
    private float f28481f;

    /* renamed from: g  reason: collision with root package name */
    private float f28482g;
    private float h;
    private float i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private float o;
    private float p;
    private Paint q;
    private Paint r;
    private Paint s;
    private Path t;
    private Path u;
    private Path v;
    private float w;
    /* access modifiers changed from: private */
    public ValueAnimator x;
    /* access modifiers changed from: private */
    public float y;

    public SearchLoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SearchLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SearchLoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f28478c = a(6.0f);
        this.f28479d = a(0.8f);
        this.f28476a = false;
        this.f28477b = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.i.SearchLoadingView);
        this.f28480e = obtainStyledAttributes.getDimension(c.i.SearchLoadingView_radius1, this.f28478c);
        this.f28481f = obtainStyledAttributes.getDimension(c.i.SearchLoadingView_radius2, this.f28478c);
        this.f28482g = obtainStyledAttributes.getDimension(c.i.SearchLoadingView_gap, this.f28479d);
        this.h = obtainStyledAttributes.getFloat(c.i.SearchLoadingView_rtlScale, 0.7f);
        this.i = obtainStyledAttributes.getFloat(c.i.SearchLoadingView_ltrScale, 1.3f);
        this.j = obtainStyledAttributes.getColor(c.i.SearchLoadingView_color1, -49088);
        this.k = obtainStyledAttributes.getColor(c.i.SearchLoadingView_color2, -16716050);
        this.l = obtainStyledAttributes.getColor(c.i.SearchLoadingView_mixColor, -16777216);
        this.m = obtainStyledAttributes.getInt(c.i.SearchLoadingView_duration, 350);
        this.n = obtainStyledAttributes.getInt(c.i.SearchLoadingView_pauseDuration, 80);
        this.o = obtainStyledAttributes.getFloat(c.i.SearchLoadingView_scaleStartFraction, 0.2f);
        this.p = obtainStyledAttributes.getFloat(c.i.SearchLoadingView_scaleEndFraction, 0.8f);
        obtainStyledAttributes.recycle();
        c();
        this.w = this.f28482g + this.f28480e + this.f28481f;
        d();
        e();
    }

    private void c() {
        float f2 = this.f28480e;
        if (f2 <= BitmapDescriptorFactory.HUE_RED) {
            f2 = this.f28478c;
        }
        this.f28480e = f2;
        float f3 = this.f28481f;
        if (f3 <= BitmapDescriptorFactory.HUE_RED) {
            f3 = this.f28478c;
        }
        this.f28481f = f3;
        float f4 = this.f28482g;
        if (f4 < BitmapDescriptorFactory.HUE_RED) {
            f4 = this.f28479d;
        }
        this.f28482g = f4;
        float f5 = this.h;
        if (f5 < BitmapDescriptorFactory.HUE_RED) {
            f5 = 0.7f;
        }
        this.h = f5;
        float f6 = this.i;
        if (f6 < BitmapDescriptorFactory.HUE_RED) {
            f6 = 1.3f;
        }
        this.i = f6;
        int i2 = this.m;
        if (i2 <= 0) {
            i2 = 350;
        }
        this.m = i2;
        int i3 = this.n;
        if (i3 < 0) {
            i3 = 80;
        }
        this.n = i3;
        float f7 = this.o;
        if (f7 < BitmapDescriptorFactory.HUE_RED || f7 > 0.5f) {
            this.o = 0.2f;
        }
        float f8 = this.p;
        if (((double) f8) < 0.5d || f8 > 1.0f) {
            this.p = 0.8f;
        }
    }

    private void d() {
        this.q = new Paint(1);
        this.r = new Paint(1);
        this.s = new Paint(1);
        this.q.setColor(this.j);
        this.r.setColor(this.k);
        this.s.setColor(this.l);
        this.t = new Path();
        this.u = new Path();
        this.v = new Path();
    }

    private void e() {
        this.y = BitmapDescriptorFactory.HUE_RED;
        a();
        this.x = ValueAnimator.ofFloat(new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
        this.x.setDuration((long) this.m);
        int i2 = this.n;
        if (i2 > 0) {
            this.x.setStartDelay((long) i2);
            this.x.setInterpolator(new AccelerateDecelerateInterpolator());
        } else {
            this.x.setRepeatCount(-1);
            this.x.setRepeatMode(1);
            this.x.setInterpolator(new LinearInterpolator());
        }
        this.x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = SearchLoadingView.this.y = valueAnimator.getAnimatedFraction();
                SearchLoadingView.this.invalidate();
            }
        });
        this.x.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                SearchLoadingView searchLoadingView = SearchLoadingView.this;
                searchLoadingView.f28477b = !searchLoadingView.f28477b;
            }

            public void onAnimationRepeat(Animator animator) {
                SearchLoadingView searchLoadingView = SearchLoadingView.this;
                searchLoadingView.f28477b = !searchLoadingView.f28477b;
            }

            public void onAnimationCancel(Animator animator) {
                SearchLoadingView.this.f28476a = true;
            }

            public void onAnimationEnd(Animator animator) {
                if (!SearchLoadingView.this.f28476a && SearchLoadingView.this.x != null) {
                    SearchLoadingView.this.x.start();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        float max = Math.max(Math.max(this.h, this.i), 1.0f);
        if (mode != 1073741824) {
            size = (int) (this.f28482g + (((this.f28480e * 2.0f) + (this.f28481f * 2.0f)) * max) + a(1.0f));
        }
        if (mode2 != 1073741824) {
            size2 = (int) ((Math.max(this.f28480e, this.f28481f) * 2.0f * max) + a(1.0f));
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Paint paint;
        Paint paint2;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        super.onDraw(canvas);
        float measuredHeight = ((float) getMeasuredHeight()) / 2.0f;
        if (this.f28477b) {
            f3 = this.f28480e;
            f2 = this.f28481f;
            paint2 = this.q;
            paint = this.r;
        } else {
            f3 = this.f28481f;
            f2 = this.f28480e;
            paint2 = this.r;
            paint = this.q;
        }
        float f7 = this.w;
        float measuredWidth = ((((float) getMeasuredWidth()) / 2.0f) - (f7 / 2.0f)) + (f7 * this.y);
        float f8 = this.w;
        float measuredWidth2 = (((float) getMeasuredWidth()) / 2.0f) + (f8 / 2.0f);
        float f9 = this.y;
        float f10 = measuredWidth2 - (f8 * f9);
        float f11 = this.o;
        if (f9 <= f11) {
            float f12 = (1.0f / f11) * f9;
            f5 = f3 * (((this.i - 1.0f) * f12) + 1.0f);
            f6 = ((this.h - 1.0f) * f12) + 1.0f;
        } else {
            float f13 = this.p;
            if (f9 >= f13) {
                float f14 = (f9 - 1.0f) / (f13 - 1.0f);
                f5 = f3 * (((this.i - 1.0f) * f14) + 1.0f);
                f4 = f2 * (((this.h - 1.0f) * f14) + 1.0f);
                this.t.reset();
                this.t.addCircle(measuredWidth, measuredHeight, f5, Path.Direction.CW);
                this.u.reset();
                this.u.addCircle(f10, measuredHeight, f4, Path.Direction.CW);
                this.v.op(this.t, this.u, Path.Op.INTERSECT);
                canvas.drawPath(this.t, paint2);
                canvas.drawPath(this.u, paint);
                canvas.drawPath(this.v, this.s);
            }
            f5 = f3 * this.i;
            f6 = this.h;
        }
        f4 = f2 * f6;
        this.t.reset();
        this.t.addCircle(measuredWidth, measuredHeight, f5, Path.Direction.CW);
        this.u.reset();
        this.u.addCircle(f10, measuredHeight, f4, Path.Direction.CW);
        this.v.op(this.t, this.u, Path.Op.INTERSECT);
        canvas.drawPath(this.t, paint2);
        canvas.drawPath(this.u, paint);
        canvas.drawPath(this.v, this.s);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
    }

    private float a(float f2) {
        return TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    public void a() {
        ValueAnimator valueAnimator = this.x;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.x = null;
        }
    }

    public void b() {
        if (this.x == null) {
            e();
        }
        if (this.x.isRunning()) {
            this.x.cancel();
        }
        post(new Runnable() {
            public void run() {
                SearchLoadingView searchLoadingView = SearchLoadingView.this;
                searchLoadingView.f28476a = false;
                searchLoadingView.f28477b = false;
                if (searchLoadingView.x != null) {
                    SearchLoadingView.this.x.start();
                }
            }
        });
    }

    public float getRadius1() {
        return this.f28480e;
    }

    public float getRadius2() {
        return this.f28481f;
    }

    public float getGap() {
        return this.f28482g;
    }

    public float getRtlScale() {
        return this.h;
    }

    public float getLtrScale() {
        return this.i;
    }

    public int getColor1() {
        return this.j;
    }

    public int getColor2() {
        return this.k;
    }

    public int getMixColor() {
        return this.l;
    }

    public int getDuration() {
        return this.m;
    }

    public int getPauseDuration() {
        return this.n;
    }

    public float getScaleStartFraction() {
        return this.o;
    }

    public float getScaleEndFraction() {
        return this.p;
    }
}
