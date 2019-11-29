package com.otaliastudios.cameraview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.otaliastudios.cameraview.ab;

class aj extends u {

    /* renamed from: d  reason: collision with root package name */
    private GestureDetector f15545d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f15546e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f15547f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f15548g;
    /* access modifiers changed from: private */
    public final Runnable h = new Runnable() {
        public void run() {
            aj.this.b(false);
        }
    };

    public float a(float f2, float f3, float f4) {
        return BitmapDescriptorFactory.HUE_RED;
    }

    public aj(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        super.a(context);
        this.f15679c = new PointF[]{new PointF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED)};
        this.f15545d = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                boolean unused = aj.this.f15546e = true;
                aj.this.f15678b = s.TAP;
                return true;
            }

            public void onLongPress(MotionEvent motionEvent) {
                boolean unused = aj.this.f15546e = true;
                aj.this.f15678b = s.LONG_TAP;
            }
        });
        this.f15545d.setIsLongpressEnabled(true);
        LayoutInflater.from(getContext()).inflate(ab.b.cameraview_layout_focus_marker, this);
        this.f15547f = (FrameLayout) findViewById(ab.a.focusMarkerContainer);
        this.f15548g = (ImageView) findViewById(ab.a.fill);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f15677a) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f15546e = false;
        }
        this.f15545d.onTouchEvent(motionEvent);
        if (!this.f15546e) {
            return false;
        }
        this.f15679c[0].x = motionEvent.getX();
        this.f15679c[0].y = motionEvent.getY();
        return true;
    }

    public void a(PointF pointF) {
        PointF pointF2 = pointF;
        removeCallbacks(this.h);
        this.f15547f.clearAnimation();
        this.f15548g.clearAnimation();
        this.f15547f.setTranslationX((float) ((int) (pointF2.x - ((float) (this.f15547f.getWidth() / 2)))));
        this.f15547f.setTranslationY((float) ((int) (pointF2.y - ((float) (this.f15547f.getWidth() / 2)))));
        this.f15547f.setScaleX(1.36f);
        this.f15547f.setScaleY(1.36f);
        this.f15547f.setAlpha(1.0f);
        this.f15548g.setScaleX(BitmapDescriptorFactory.HUE_RED);
        this.f15548g.setScaleY(BitmapDescriptorFactory.HUE_RED);
        this.f15548g.setAlpha(1.0f);
        b(this.f15547f, 1.0f, 1.0f, 300, 0, (Animator.AnimatorListener) null);
        b(this.f15548g, 1.0f, 1.0f, 300, 0, new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                aj ajVar = aj.this;
                ajVar.postDelayed(ajVar.h, 2000);
            }
        });
    }

    public void b(boolean z) {
        if (z) {
            b(this.f15547f, 1.0f, BitmapDescriptorFactory.HUE_RED, 500, 0, (Animator.AnimatorListener) null);
            b(this.f15548g, 1.0f, BitmapDescriptorFactory.HUE_RED, 500, 0, (Animator.AnimatorListener) null);
            return;
        }
        b(this.f15548g, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 500, 0, (Animator.AnimatorListener) null);
        b(this.f15547f, 1.36f, 1.0f, 500, 0, new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                aj.b(aj.this.f15547f, 1.36f, BitmapDescriptorFactory.HUE_RED, 200, 1000, (Animator.AnimatorListener) null);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void b(View view, float f2, float f3, long j, long j2, Animator.AnimatorListener animatorListener) {
        view.animate().scaleX(f2).scaleY(f2).alpha(f3).setDuration(j).setStartDelay(j2).setListener(animatorListener).start();
    }
}
