package com.shopee.livequiz.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.garena.android.appkit.tools.b;
import com.shopee.livequiz.c;
import com.shopee.livequiz.ui.view.a;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f29844a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public float[] f29845b = new float[2];

    /* renamed from: c  reason: collision with root package name */
    private ValueAnimator f29846c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public com.shopee.livequiz.ui.view.a f29847d;

    public interface a {
        void a();
    }

    public d(Context context) {
        this.f29844a = context;
    }

    public void a(ViewGroup viewGroup, ImageView imageView, final a aVar) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.f29847d = new com.shopee.livequiz.ui.view.a(this.f29844a);
        this.f29847d.setLayoutParams(layoutParams);
        viewGroup.addView(this.f29847d);
        final ImageView movingHeart = this.f29847d.getMovingHeart();
        viewGroup.getLocationInWindow(new int[2]);
        int[] iArr = new int[2];
        imageView.getLocationInWindow(iArr);
        int[] iArr2 = {m.c() / 2, b.d(c.b.livequiz_extra_life_animation_view_margin_top) + (b.d(c.b.livequiz_extra_life_animation_view_size) / 2)};
        int i = iArr[0];
        int d2 = iArr[1] - b.d(c.b.livequiz_header_top_margin);
        int i2 = iArr2[0];
        int d3 = iArr2[1] - b.d(c.b.livequiz_header_top_margin);
        Path path = new Path();
        float f2 = (float) d2;
        path.moveTo((float) i, f2);
        path.quadTo((float) ((i + i2) / 2), f2, (float) i2, (float) d3);
        final PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f29846c = ValueAnimator.ofFloat(new float[]{0.0f, pathMeasure.getLength()});
        Math.abs(i - i2);
        Math.abs(d2 - d3);
        this.f29846c.setDuration(500);
        this.f29846c.setInterpolator(new AccelerateInterpolator());
        this.f29846c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                movingHeart.setVisibility(0);
                pathMeasure.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), d.this.f29845b, (float[]) null);
                movingHeart.setTranslationX(d.this.f29845b[0]);
                movingHeart.setTranslationY(d.this.f29845b[1]);
                d.this.f29847d.a(valueAnimator.getAnimatedFraction());
            }
        });
        this.f29846c.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                movingHeart.setVisibility(8);
                d.this.f29847d.a();
            }

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
            }
        });
        this.f29847d.setListener(new a.C0460a() {
            public void a() {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
        this.f29846c.start();
    }

    public boolean a() {
        com.shopee.livequiz.ui.view.a aVar = this.f29847d;
        if (aVar == null || !aVar.b()) {
            ValueAnimator valueAnimator = this.f29846c;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return false;
            }
        }
        return true;
    }
}
