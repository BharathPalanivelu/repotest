package com.shopee.feeds.feedlibrary.view;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;

public class ToogleButton extends View {
    private ValueAnimator.AnimatorUpdateListener A;

    /* renamed from: a  reason: collision with root package name */
    a f28494a;

    /* renamed from: b  reason: collision with root package name */
    private int f28495b;

    /* renamed from: c  reason: collision with root package name */
    private int f28496c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f28497d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f28498e;

    /* renamed from: f  reason: collision with root package name */
    private int f28499f;

    /* renamed from: g  reason: collision with root package name */
    private int f28500g;
    private int h;
    private int i;
    private Paint j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public boolean l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    /* access modifiers changed from: private */
    public float t;
    private float u;
    /* access modifiers changed from: private */
    public float v;
    /* access modifiers changed from: private */
    public float w;
    private ValueAnimator x;
    /* access modifiers changed from: private */
    public final ArgbEvaluator y;
    private Animator.AnimatorListener z;

    public interface a {
        void a();

        void a(boolean z);
    }

    public ToogleButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public ToogleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ToogleButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = 1;
        this.l = false;
        this.y = new ArgbEvaluator();
        this.z = new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                if (ToogleButton.this.k == 1) {
                    int unused = ToogleButton.this.k = 0;
                    boolean unused2 = ToogleButton.this.l = false;
                    if (ToogleButton.this.f28494a != null) {
                        ToogleButton.this.f28494a.a(true);
                    }
                } else if (ToogleButton.this.k == 0) {
                    int unused3 = ToogleButton.this.k = 1;
                    boolean unused4 = ToogleButton.this.l = false;
                    if (ToogleButton.this.f28494a != null) {
                        ToogleButton.this.f28494a.a(false);
                    }
                }
            }
        };
        this.A = new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float b2 = (ToogleButton.this.t - (ToogleButton.this.v * 2.0f)) - 10.0f;
                if (ToogleButton.this.k == 1) {
                    float unused = ToogleButton.this.w = b2 * ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ToogleButton toogleButton = ToogleButton.this;
                    int unused2 = toogleButton.f28497d = ((Integer) toogleButton.y.evaluate(((Float) valueAnimator.getAnimatedValue()).floatValue(), Integer.valueOf(ToogleButton.this.getResources().getColor(c.b.grey_200)), Integer.valueOf(ToogleButton.this.f28498e))).intValue();
                } else if (ToogleButton.this.k == 0) {
                    float unused3 = ToogleButton.this.w = b2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * b2);
                    ToogleButton toogleButton2 = ToogleButton.this;
                    int unused4 = toogleButton2.f28497d = ((Integer) toogleButton2.y.evaluate(((Float) valueAnimator.getAnimatedValue()).floatValue(), Integer.valueOf(ToogleButton.this.f28498e), Integer.valueOf(ToogleButton.this.getResources().getColor(c.b.grey_200)))).intValue();
                }
                ToogleButton.this.postInvalidate();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.i.ToogleButton, i2, 0);
        this.f28495b = (int) obtainStyledAttributes.getDimension(c.i.ToogleButton_border_width, TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.f28496c = obtainStyledAttributes.getColor(c.i.ToogleButton_border_color, getResources().getColor(c.b.grey_500));
        this.f28497d = obtainStyledAttributes.getColor(c.i.ToogleButton_feeds_bg_color, getResources().getColor(c.b.white));
        this.f28498e = obtainStyledAttributes.getColor(c.i.ToogleButton_checked_color, getResources().getColor(c.b.toogle_green));
        this.f28499f = obtainStyledAttributes.getDimensionPixelOffset(c.i.ToogleButton_circle_radius, (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics()));
        this.f28500g = obtainStyledAttributes.getColor(c.i.ToogleButton_shadow_color, getResources().getColor(c.b.grey_500));
        this.h = obtainStyledAttributes.getColor(c.i.ToogleButton_button_color, getResources().getColor(c.b.white));
        this.i = obtainStyledAttributes.getInt(c.i.ToogleButton_animation_duration, 300);
        obtainStyledAttributes.recycle();
        d();
    }

    private void d() {
        this.j = new Paint();
        this.j.setAntiAlias(true);
        this.j.setDither(true);
        this.j.setStyle(Paint.Style.STROKE);
        this.x = ValueAnimator.ofFloat(new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f}).setDuration((long) this.i);
        this.x.setRepeatCount(0);
        this.x.addUpdateListener(this.A);
        this.x.addListener(this.z);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(58, 1073741824);
        }
        if (mode2 == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(36, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int i6 = this.f28495b;
        this.s = (float) ((i3 - i6) - i6);
        this.t = (float) ((i2 - i6) - i6);
        this.u = this.s * 0.5f;
        this.v = (this.u - ((float) i6)) - 4.0f;
        this.m = (float) i6;
        this.n = (float) i6;
        this.o = (float) (i2 - i6);
        this.p = (float) (i3 - i6);
        this.q = (this.m + this.o) * 0.5f;
        this.r = (this.n + this.p) * 0.5f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.j.setStrokeWidth((float) this.f28495b);
        this.j.setColor(getResources().getColor(c.b.white));
        this.j.setStyle(Paint.Style.FILL);
        a(canvas, this.j);
        float f2 = this.w;
        float f3 = this.u;
        float f4 = ((f2 * f3) / (this.t - (f3 * 2.0f))) * 0.5f;
        if (f4 != BitmapDescriptorFactory.HUE_RED) {
            this.j.setColor(this.f28497d);
            this.j.setStrokeWidth(f4 * 2.0f);
            this.j.setStyle(Paint.Style.STROKE);
            RectF rectF = new RectF(this.m + f4, this.n + f4, this.o - f4, this.p - f4);
            float f5 = this.u;
            canvas.drawRoundRect(rectF, f5, f5, this.j);
            this.j.setStyle(Paint.Style.FILL);
            this.j.setStrokeWidth(1.0f);
            float f6 = this.m;
            int i2 = this.f28495b;
            float f7 = this.u;
            canvas.drawCircle(f6 + ((float) i2) + f7, ((float) i2) + f7, f7 - ((float) i2), this.j);
            float f8 = this.m;
            float f9 = this.u;
            int i3 = this.f28495b;
            float f10 = f8 + f9 + ((float) i3);
            float f11 = this.n;
            canvas.drawRect(f10, f11 + ((float) i3), (this.w + f9) - ((float) i3), (f11 + (f9 * 2.0f)) - ((float) i3), this.j);
        }
        this.j.setColor(this.h);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setStrokeWidth((float) this.f28495b);
        float f12 = this.v;
        canvas.drawCircle(this.w + f12 + ((float) this.f28495b) + 5.0f, this.r, f12, this.j);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 0) {
            if (this.l) {
                return false;
            }
            int i2 = this.k;
            if (i2 == 1) {
                a();
            } else if (i2 == 0) {
                b();
            }
            a aVar = this.f28494a;
            if (aVar != null) {
                aVar.a();
            }
        }
        return true;
    }

    public void a() {
        this.l = true;
        this.x.start();
    }

    public void b() {
        this.l = true;
        this.x.start();
    }

    private void a(Canvas canvas, Paint paint) {
        paint.setColor(getResources().getColor(c.b.grey_200));
        RectF rectF = new RectF(this.m, this.n, this.o, this.p);
        float f2 = this.u;
        canvas.drawRoundRect(rectF, f2, f2, paint);
    }

    public void setOnCheckListener(a aVar) {
        this.f28494a = aVar;
    }

    public boolean c() {
        return this.k == 0;
    }
}
