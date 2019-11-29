package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.g.w;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class a extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    int f3017a;

    /* renamed from: b  reason: collision with root package name */
    private Animation.AnimationListener f3018b;

    a(Context context, int i) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f2);
        int i3 = (int) (BitmapDescriptorFactory.HUE_RED * f2);
        this.f3017a = (int) (3.5f * f2);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            w.b((View) this, f2 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0064a(this.f3017a));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f3017a, (float) i3, (float) i2, 503316480);
            int i4 = this.f3017a;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        w.a((View) this, (Drawable) shapeDrawable);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f3017a * 2), getMeasuredHeight() + (this.f3017a * 2));
        }
    }

    public void a(Animation.AnimationListener animationListener) {
        this.f3018b = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f3018b;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f3018b;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.a$a  reason: collision with other inner class name */
    private class C0064a extends OvalShape {

        /* renamed from: b  reason: collision with root package name */
        private RadialGradient f3020b;

        /* renamed from: c  reason: collision with root package name */
        private Paint f3021c = new Paint();

        C0064a(int i) {
            a.this.f3017a = i;
            a((int) rect().width());
        }

        /* access modifiers changed from: protected */
        public void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            a((int) f2);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = a.this.getWidth() / 2;
            float f2 = (float) width;
            float height = (float) (a.this.getHeight() / 2);
            canvas.drawCircle(f2, height, f2, this.f3021c);
            canvas.drawCircle(f2, height, (float) (width - a.this.f3017a), paint);
        }

        private void a(int i) {
            float f2 = (float) (i / 2);
            this.f3020b = new RadialGradient(f2, f2, (float) a.this.f3017a, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f3021c.setShader(this.f3020b);
        }
    }
}
