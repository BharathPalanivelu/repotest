package com.airpay.paysdk.qrcode.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.core.g.i;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.LinkedList;
import java.util.List;

public class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Rect f4415a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f4416b;

    /* renamed from: c  reason: collision with root package name */
    private float f4417c;

    /* renamed from: d  reason: collision with root package name */
    private float f4418d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4419e = false;

    /* renamed from: f  reason: collision with root package name */
    private C0085a f4420f = C0085a.NONE;

    /* renamed from: g  reason: collision with root package name */
    private View f4421g;
    private View h;
    /* access modifiers changed from: private */
    public List<View> i = new LinkedList();

    /* renamed from: com.airpay.paysdk.qrcode.ui.a$a  reason: collision with other inner class name */
    private enum C0085a {
        NONE,
        HORIZONTAL,
        VERTICAL
    }

    public a(Context context) {
        super(context);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void a(Activity activity, Rect rect) {
        this.f4415a = rect;
        this.f4416b = activity;
    }

    /* access modifiers changed from: protected */
    public void setMovableView(View view) {
        this.h = view;
    }

    /* access modifiers changed from: protected */
    public void setTargetView(View view) {
        this.f4421g = view;
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        this.i.add(view);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.i.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f4420f == C0085a.VERTICAL) {
            return true;
        }
        int a2 = i.a(motionEvent);
        if (a2 == 0) {
            this.f4417c = motionEvent.getX();
            this.f4418d = motionEvent.getY();
        } else if (a2 == 1) {
            this.f4419e = false;
            this.f4420f = C0085a.NONE;
        } else if (a2 == 2) {
            if (motionEvent.getPointerCount() > 1) {
                this.f4419e = true;
            } else {
                float x = motionEvent.getX() - this.f4417c;
                float y = motionEvent.getY() - this.f4418d;
                if (this.f4420f == C0085a.NONE) {
                    if (Math.abs(y) > 10.0f) {
                        this.f4420f = C0085a.VERTICAL;
                    } else if (Math.abs(x) > 10.0f) {
                        this.f4420f = C0085a.HORIZONTAL;
                    }
                }
            }
        }
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (i.a(motionEvent) == 1) {
            this.f4420f = C0085a.NONE;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a2 = i.a(motionEvent);
        if (a2 == 0) {
            this.f4417c = motionEvent.getX();
            this.f4418d = motionEvent.getY();
        } else if (a2 == 1) {
            if (this.f4419e) {
                a((float) BitmapDescriptorFactory.HUE_RED);
            } else if (Math.abs(motionEvent.getY() - this.f4418d) > 100.0f) {
                b();
            } else {
                a((float) BitmapDescriptorFactory.HUE_RED);
            }
            this.f4419e = false;
            this.f4420f = C0085a.NONE;
        } else if (a2 == 2) {
            if (motionEvent.getPointerCount() > 1) {
                this.f4419e = true;
            } else {
                float x = motionEvent.getX() - this.f4417c;
                float y = motionEvent.getY() - this.f4418d;
                if (this.f4420f == C0085a.NONE) {
                    if (Math.abs(y) > 10.0f) {
                        this.f4420f = C0085a.VERTICAL;
                    } else if (Math.abs(x) > 10.0f) {
                        this.f4420f = C0085a.HORIZONTAL;
                    }
                }
                if (this.f4420f == C0085a.VERTICAL) {
                    a(y);
                }
                this.f4417c = motionEvent.getX();
            }
        }
        return true;
    }

    private void a(float f2) {
        View view = this.h;
        if (view != null) {
            view.setTranslationY(f2);
        }
    }

    public void b() {
        if (this.f4421g == null) {
            a(false);
            return;
        }
        float width = ((float) this.f4415a.width()) / ((float) this.f4421g.getWidth());
        float height = ((float) this.f4415a.height()) / ((float) this.f4421g.getHeight());
        int[] iArr = new int[2];
        this.f4421g.getLocationOnScreen(iArr);
        float f2 = (float) (this.f4415a.left - iArr[0]);
        float f3 = (float) (this.f4415a.top - iArr[1]);
        if (!this.i.isEmpty()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, BitmapDescriptorFactory.HUE_RED});
            ofFloat.setDuration(300);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    for (View alpha : a.this.i) {
                        alpha.setAlpha(floatValue);
                    }
                }
            });
            ofFloat.start();
        }
        this.f4421g.setPivotX(BitmapDescriptorFactory.HUE_RED);
        this.f4421g.setPivotY(BitmapDescriptorFactory.HUE_RED);
        this.f4421g.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(300).translationXBy(f2).translationYBy(f3).scaleX(width).scaleY(height).setListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                a.this.a(true);
            }
        }).start();
    }

    public void a(boolean z) {
        Activity activity = this.f4416b;
        if (activity != null) {
            activity.finish();
            if (z) {
                this.f4416b.overridePendingTransition(0, 0);
            }
        }
    }
}
