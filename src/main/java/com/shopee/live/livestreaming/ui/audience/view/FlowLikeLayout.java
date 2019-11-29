package com.shopee.live.livestreaming.ui.audience.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;
import java.util.Random;

public class FlowLikeLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f29038a = {c.d.live_streaming_ic_like_1, c.d.live_streaming_ic_like_2, c.d.live_streaming_ic_like_3, c.d.live_streaming_ic_like_4, c.d.live_streaming_ic_like_5, c.d.live_streaming_ic_like_6, c.d.live_streaming_ic_like_7, c.d.live_streaming_ic_like_8, c.d.live_streaming_ic_like_9, c.d.live_streaming_ic_like_10, c.d.live_streaming_ic_like_1, c.d.live_streaming_ic_like_2, c.d.live_streaming_ic_like_3, c.d.live_streaming_ic_like_4, c.d.live_streaming_ic_like_5, c.d.live_streaming_ic_like_6, c.d.live_streaming_ic_like_7, c.d.live_streaming_ic_like_8, c.d.live_streaming_ic_like_9, c.d.live_streaming_ic_like_10};

    /* renamed from: b  reason: collision with root package name */
    private int f29039b;

    /* renamed from: c  reason: collision with root package name */
    private int f29040c;

    /* renamed from: d  reason: collision with root package name */
    private Interpolator[] f29041d;

    /* renamed from: e  reason: collision with root package name */
    private Random f29042e;

    /* renamed from: f  reason: collision with root package name */
    private SparseArray<ImageView> f29043f;

    /* renamed from: g  reason: collision with root package name */
    private int f29044g;

    public FlowLikeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlowLikeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLikeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29041d = new Interpolator[3];
        this.f29042e = new Random();
        a(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f29039b = getMeasuredWidth();
        this.f29040c = getMeasuredHeight();
    }

    private void a(Context context) {
        this.f29041d[0] = new AccelerateDecelerateInterpolator();
        this.f29041d[1] = new AccelerateInterpolator(0.4f);
        this.f29041d[2] = new DecelerateInterpolator(0.4f);
        this.f29044g = b.d(c.C0439c.live_audience_flow_like_icon_size);
        this.f29043f = new SparseArray<>();
        for (int i = 0; i < f29038a.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(f29038a[i]);
            imageView.setVisibility(8);
            int i2 = this.f29044g;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
            layoutParams.gravity = 81;
            imageView.setLayoutParams(layoutParams);
            imageView.setTag(false);
            addView(imageView);
            this.f29043f.put(i, imageView);
        }
    }

    public void a() {
        final ImageView freeImage = getFreeImage();
        if (freeImage != null) {
            ((FrameLayout.LayoutParams) freeImage.getLayoutParams()).gravity = 81;
            freeImage.setRotation((float) this.f29042e.nextInt(360));
            AnimatorSet a2 = a(freeImage, this.f29044g);
            if (a2 != null) {
                freeImage.setVisibility(0);
                freeImage.setTag(true);
                a2.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        freeImage.setTag(false);
                        super.onAnimationEnd(animator);
                    }
                });
                a2.start();
            }
        }
    }

    private AnimatorSet a(ImageView imageView, int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", new float[]{0.6f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{0.6f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{0.6f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.setInterpolator(this.f29041d[new Random().nextInt(3)]);
        animatorSet.setDuration(180);
        ValueAnimator a2 = a((View) imageView, i);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(new Animator[]{animatorSet, a2});
        animatorSet2.setTarget(imageView);
        return animatorSet2;
    }

    private ValueAnimator a(View view, int i) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new a(a(2), a(1)), new Object[]{new PointF((float) ((this.f29039b - i) / 2), (float) (this.f29040c - i)), new PointF((float) this.f29042e.nextInt(Math.max(getWidth(), 1)), BitmapDescriptorFactory.HUE_RED)});
        ofObject.addUpdateListener(new a(view));
        ofObject.setTarget(view);
        ofObject.setDuration(3000);
        return ofObject;
    }

    private PointF a(int i) {
        PointF pointF = new PointF();
        pointF.x = (float) this.f29042e.nextInt(Math.max(this.f29039b, 1));
        pointF.y = ((float) this.f29042e.nextInt(Math.max(this.f29040c, 1))) / ((float) i);
        return pointF;
    }

    private class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        private View f29048b;

        public a(View view) {
            this.f29048b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PointF pointF = (PointF) valueAnimator.getAnimatedValue();
            this.f29048b.setX(pointF.x);
            this.f29048b.setY(pointF.y);
            this.f29048b.setAlpha(1.0f - valueAnimator.getAnimatedFraction());
        }
    }

    private ImageView getFreeImage() {
        int nextInt = new Random().nextInt(20);
        for (int i = nextInt; i < 20; i++) {
            ImageView imageView = this.f29043f.get(i);
            if (!((Boolean) imageView.getTag()).booleanValue()) {
                return imageView;
            }
        }
        for (int i2 = 0; i2 <= nextInt; i2++) {
            ImageView imageView2 = this.f29043f.get(i2);
            if (!((Boolean) imageView2.getTag()).booleanValue()) {
                return imageView2;
            }
        }
        return null;
    }
}
