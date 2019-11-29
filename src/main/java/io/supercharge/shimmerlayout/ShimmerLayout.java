package io.supercharge.shimmerlayout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import io.supercharge.shimmerlayout.a;

public class ShimmerLayout extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f33611a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f33612b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f33613c;

    /* renamed from: d  reason: collision with root package name */
    private ValueAnimator f33614d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f33615e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f33616f;

    /* renamed from: g  reason: collision with root package name */
    private Canvas f33617g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private float n;
    private float o;
    private ViewTreeObserver.OnPreDrawListener p;

    public ShimmerLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public ShimmerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.b.ShimmerLayout, 0, 0);
        try {
            this.m = obtainStyledAttributes.getInteger(a.b.ShimmerLayout_shimmer_angle, 20);
            this.k = obtainStyledAttributes.getInteger(a.b.ShimmerLayout_shimmer_animation_duration, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
            this.l = obtainStyledAttributes.getColor(a.b.ShimmerLayout_shimmer_color, a(a.C0526a.shimmer_color));
            this.j = obtainStyledAttributes.getBoolean(a.b.ShimmerLayout_shimmer_auto_start, false);
            this.n = obtainStyledAttributes.getFloat(a.b.ShimmerLayout_shimmer_mask_width, 0.5f);
            this.o = obtainStyledAttributes.getFloat(a.b.ShimmerLayout_shimmer_gradient_center_color_width, 0.1f);
            this.h = obtainStyledAttributes.getBoolean(a.b.ShimmerLayout_shimmer_reverse_animation, false);
            obtainStyledAttributes.recycle();
            setMaskWidth(this.n);
            setGradientCenterColorWidth(this.o);
            setShimmerAngle(this.m);
            if (this.j && getVisibility() == 0) {
                a();
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        d();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (!this.i || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            a(canvas);
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 != 0) {
            b();
        } else if (this.j) {
            a();
        }
    }

    public void a() {
        if (!this.i) {
            if (getWidth() == 0) {
                this.p = new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        ShimmerLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
                        ShimmerLayout.this.a();
                        return true;
                    }
                };
                getViewTreeObserver().addOnPreDrawListener(this.p);
                return;
            }
            getShimmerAnimation().start();
            this.i = true;
        }
    }

    public void b() {
        if (this.p != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.p);
        }
        d();
    }

    public void setShimmerColor(int i2) {
        this.l = i2;
        c();
    }

    public void setShimmerAnimationDuration(int i2) {
        this.k = i2;
        c();
    }

    public void setAnimationReversed(boolean z) {
        this.h = z;
        c();
    }

    public void setShimmerAngle(int i2) {
        if (i2 < -45 || 45 < i2) {
            throw new IllegalArgumentException(String.format("shimmerAngle value must be between %d and %d", new Object[]{(byte) -45, (byte) 45}));
        }
        this.m = i2;
        c();
    }

    public void setMaskWidth(float f2) {
        if (f2 <= BitmapDescriptorFactory.HUE_RED || 1.0f < f2) {
            throw new IllegalArgumentException(String.format("maskWidth value must be higher than %d and less or equal to %d", new Object[]{(byte) 0, (byte) 1}));
        }
        this.n = f2;
        c();
    }

    public void setGradientCenterColorWidth(float f2) {
        if (f2 <= BitmapDescriptorFactory.HUE_RED || 1.0f <= f2) {
            throw new IllegalArgumentException(String.format("gradientCenterColorWidth value must be higher than %d and less than %d", new Object[]{(byte) 0, (byte) 1}));
        }
        this.o = f2;
        c();
    }

    private void c() {
        if (this.i) {
            d();
            a();
        }
    }

    private void a(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f33615e = getMaskBitmap();
        Bitmap bitmap = this.f33615e;
        if (bitmap != null) {
            if (this.f33617g == null) {
                this.f33617g = new Canvas(bitmap);
            }
            this.f33617g.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f33617g.save();
            this.f33617g.translate((float) (-this.f33611a), BitmapDescriptorFactory.HUE_RED);
            super.dispatchDraw(this.f33617g);
            this.f33617g.restore();
            b(canvas);
            this.f33615e = null;
        }
    }

    private void b(Canvas canvas) {
        f();
        canvas.save();
        canvas.translate((float) this.f33611a, BitmapDescriptorFactory.HUE_RED);
        canvas.drawRect((float) this.f33612b.left, BitmapDescriptorFactory.HUE_RED, (float) this.f33612b.width(), (float) this.f33612b.height(), this.f33613c);
        canvas.restore();
    }

    private void d() {
        ValueAnimator valueAnimator = this.f33614d;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f33614d.removeAllUpdateListeners();
        }
        this.f33614d = null;
        this.f33613c = null;
        this.i = false;
        e();
    }

    private void e() {
        this.f33617g = null;
        Bitmap bitmap = this.f33616f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f33616f = null;
        }
    }

    private Bitmap getMaskBitmap() {
        if (this.f33616f == null) {
            this.f33616f = a(this.f33612b.width(), getHeight());
        }
        return this.f33616f;
    }

    private void f() {
        if (this.f33613c == null) {
            int b2 = b(this.l);
            float width = ((float) (getWidth() / 2)) * this.n;
            float height = this.m >= 0 ? (float) getHeight() : BitmapDescriptorFactory.HUE_RED;
            int i2 = this.l;
            ComposeShader composeShader = new ComposeShader(new LinearGradient(BitmapDescriptorFactory.HUE_RED, height, ((float) Math.cos(Math.toRadians((double) this.m))) * width, height + (((float) Math.sin(Math.toRadians((double) this.m))) * width), new int[]{b2, i2, i2, b2}, getGradientColorDistribution(), Shader.TileMode.CLAMP), new BitmapShader(this.f33615e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP), PorterDuff.Mode.DST_IN);
            this.f33613c = new Paint();
            this.f33613c.setAntiAlias(true);
            this.f33613c.setDither(true);
            this.f33613c.setFilterBitmap(true);
            this.f33613c.setShader(composeShader);
        }
    }

    private Animator getShimmerAnimation() {
        final int i2;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.f33614d;
        if (valueAnimator2 != null) {
            return valueAnimator2;
        }
        if (this.f33612b == null) {
            this.f33612b = g();
        }
        int width = getWidth();
        if (getWidth() > this.f33612b.width()) {
            i2 = -width;
        } else {
            i2 = -this.f33612b.width();
        }
        final int width2 = this.f33612b.width();
        int i3 = width - i2;
        if (this.h) {
            valueAnimator = ValueAnimator.ofInt(new int[]{i3, 0});
        } else {
            valueAnimator = ValueAnimator.ofInt(new int[]{0, i3});
        }
        this.f33614d = valueAnimator;
        this.f33614d.setDuration((long) this.k);
        this.f33614d.setRepeatCount(-1);
        this.f33614d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = ShimmerLayout.this.f33611a = i2 + ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (ShimmerLayout.this.f33611a + width2 >= 0) {
                    ShimmerLayout.this.invalidate();
                }
            }
        });
        return this.f33614d;
    }

    private Bitmap a(int i2, int i3) {
        try {
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ALPHA_8);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return null;
        }
    }

    private int a(int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return getContext().getColor(i2);
        }
        return getResources().getColor(i2);
    }

    private int b(int i2) {
        return Color.argb(0, Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    private Rect g() {
        return new Rect(0, 0, h(), getHeight());
    }

    private int h() {
        double width = (double) (((float) (getWidth() / 2)) * this.n);
        double cos = Math.cos(Math.toRadians((double) Math.abs(this.m)));
        Double.isNaN(width);
        double d2 = width / cos;
        double height = (double) getHeight();
        double tan = Math.tan(Math.toRadians((double) Math.abs(this.m)));
        Double.isNaN(height);
        return (int) (d2 + (height * tan));
    }

    private float[] getGradientColorDistribution() {
        float[] fArr = new float[4];
        fArr[0] = 0.0f;
        fArr[3] = 1.0f;
        float f2 = this.o;
        fArr[1] = 0.5f - (f2 / 2.0f);
        fArr[2] = (f2 / 2.0f) + 0.5f;
        return fArr;
    }
}
