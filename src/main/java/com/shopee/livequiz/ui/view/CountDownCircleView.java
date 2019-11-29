package com.shopee.livequiz.ui.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.livequiz.c;

public class CountDownCircleView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final int f29952a = Color.parseColor("#FFFFFF");

    /* renamed from: b  reason: collision with root package name */
    private static final int f29953b = Color.parseColor("#F76E6B");

    /* renamed from: c  reason: collision with root package name */
    private int f29954c;

    /* renamed from: d  reason: collision with root package name */
    private int f29955d;

    /* renamed from: e  reason: collision with root package name */
    private int f29956e;

    /* renamed from: f  reason: collision with root package name */
    private int f29957f;

    /* renamed from: g  reason: collision with root package name */
    private int f29958g;
    private Paint h;
    private Paint i;
    private int j;
    private RectF k;
    private long l;
    private ValueAnimator m;
    private CountDownTimer n;
    /* access modifiers changed from: private */
    public a o;
    /* access modifiers changed from: private */
    public float p;

    public interface a {
        void a();

        void a(int i);
    }

    public CountDownCircleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CountDownCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountDownCircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29954c = f29952a;
        this.f29955d = f29953b;
        this.f29956e = a(5);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.i.CountDownCircleView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == c.i.CountDownCircleView_count_down_circle_color) {
                this.f29954c = obtainStyledAttributes.getColor(index, f29952a);
            } else if (index == c.i.CountDownCircleView_count_down_progress_color) {
                this.f29955d = obtainStyledAttributes.getColor(index, f29953b);
            } else if (index == c.i.CountDownCircleView_count_down_progress_width) {
                this.f29956e = (int) obtainStyledAttributes.getDimension(index, 5.0f);
            } else if (index == c.i.CountDownCircleView_count_down_circle_gradient_start_color) {
                this.f29957f = obtainStyledAttributes.getColor(index, f29952a);
            } else if (index == c.i.CountDownCircleView_count_down_circle_gradient_end_color) {
                this.f29958g = obtainStyledAttributes.getColor(index, f29952a);
            } else if (index == c.i.CountDownCircleView_count_down_radius) {
                this.j = (int) obtainStyledAttributes.getDimension(index, 10.0f);
            }
        }
        obtainStyledAttributes.recycle();
        d();
        this.m = ValueAnimator.ofFloat(new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
        this.m.setInterpolator(new LinearInterpolator());
        this.m.setRepeatCount(0);
        this.m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = CountDownCircleView.this.p = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CountDownCircleView.this.invalidate();
            }
        });
        this.m.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        });
    }

    private void d() {
        this.h = new Paint();
        this.h.setAntiAlias(true);
        this.h.setDither(true);
        this.h.setColor(this.f29954c);
        this.h.setShader(new LinearGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) this.j, new int[]{this.f29957f, this.f29958g}, (float[]) null, Shader.TileMode.CLAMP));
        this.i = new Paint();
        this.i.setAntiAlias(true);
        this.i.setDither(true);
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setStrokeWidth((float) this.f29956e);
        this.i.setColor(this.f29955d);
        this.i.setStrokeCap(Paint.Cap.SQUARE);
        float f2 = (float) (this.f29956e / 2);
        int i2 = this.j;
        this.k = new RectF(f2, f2, ((float) (i2 * 2)) - f2, ((float) (i2 * 2)) - f2);
    }

    public void a(int i2, int i3) {
        this.h.setShader(new LinearGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) this.j, new int[]{i2, i3}, (float[]) null, Shader.TileMode.CLAMP));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec((this.j * 2) + this.f29956e, 1073741824);
        }
        if (mode2 != 1073741824) {
            i3 = View.MeasureSpec.makeMeasureSpec((this.j * 2) + this.f29956e, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int i2 = this.f29956e;
        canvas.translate((float) (i2 / 2), (float) (i2 / 2));
        int i3 = this.j;
        canvas.drawCircle((float) i3, (float) i3, (float) i3, this.h);
        canvas.drawArc(this.k, -90.0f, this.p * 360.0f, false, this.i);
        canvas.restore();
    }

    public void setCountdownTime(long j2) {
        this.l = j2;
    }

    public void setCountDownListener(a aVar) {
        this.o = aVar;
    }

    public void a() {
        if (this.m.isRunning()) {
            this.m.cancel();
        }
        this.m.setDuration(this.l);
        this.n = new CountDownTimer(this.l + 1000, 1000) {
            public void onTick(long j) {
                if (CountDownCircleView.this.o != null) {
                    CountDownCircleView.this.o.a((int) (j / 1000));
                }
            }

            public void onFinish() {
                if (CountDownCircleView.this.o != null) {
                    CountDownCircleView.this.o.a();
                }
            }
        };
        this.m.start();
        this.n.start();
    }

    public void b() {
        if (this.m.isRunning()) {
            this.m.cancel();
        }
        CountDownTimer countDownTimer = this.n;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void c() {
        this.m.removeAllListeners();
        this.m.removeAllUpdateListeners();
        this.m = null;
        if (this.o != null) {
            this.o = null;
        }
    }

    private int a(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, getResources().getDisplayMetrics());
    }
}
