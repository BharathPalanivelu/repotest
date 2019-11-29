package com.shopee.feeds.feedlibrary.view.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.devspark.robototextview.widget.RobotoTextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.util.l;
import com.tencent.rtmp.TXLivePushConfig;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f28722b = (b.class.getSimpleName() + "%s");

    /* renamed from: a  reason: collision with root package name */
    Runnable f28723a = new Runnable() {
        public void run() {
            b bVar = b.this;
            int unused = bVar.m = bVar.m + 5;
            b bVar2 = b.this;
            bVar2.a(bVar2.m);
            if (b.this.o <= 5) {
                int unused2 = b.this.p = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
            } else if (b.this.o > 5) {
                int unused3 = b.this.p = 6000;
            } else if (b.this.o > 8) {
                int unused4 = b.this.p = 12000;
            } else {
                int unused5 = b.this.p = 15000;
            }
            b.this.f();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Activity f28724c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public View f28725d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public View f28726e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public View f28727f;

    /* renamed from: g  reason: collision with root package name */
    private CircleProgressView f28728g;
    private TextView h;
    private RobotoTextView i;
    private RobotoTextView j;
    private ImageView k;
    private ImageView l;
    /* access modifiers changed from: private */
    public int m = 5;
    private boolean n = true;
    /* access modifiers changed from: private */
    public long o = 0;
    /* access modifiers changed from: private */
    public int p = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
    /* access modifiers changed from: private */
    public int q = 4;
    private Handler r = new Handler(Looper.myLooper());
    private a s;
    /* access modifiers changed from: private */
    public ValueAnimator t;
    private Animator.AnimatorListener u = new Animator.AnimatorListener() {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    };
    private ValueAnimator.AnimatorUpdateListener v = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.q == 2 && b.this.f28726e.getVisibility() != 8) {
                b.this.f28726e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            } else if (b.this.q == 3 && b.this.f28727f.getVisibility() != 8) {
                b.this.f28727f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    };

    class a extends Handler {
        a() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 291) {
                if (b.this.q == 2) {
                    b.this.f28726e.setVisibility(8);
                } else if (b.this.q == 3) {
                    b.this.f28727f.setVisibility(8);
                } else if (b.this.q == 1) {
                    b.this.f28725d.setVisibility(8);
                }
                int unused = b.this.q = 4;
            } else if (i == 292) {
                b.this.t.cancel();
                b.this.t.start();
            }
        }
    }

    public b(Activity activity) {
        this.f28724c = activity;
        this.s = new a();
        e();
    }

    private void e() {
        this.t = ValueAnimator.ofFloat(new float[]{1.0f, BitmapDescriptorFactory.HUE_RED}).setDuration(500);
        this.t.setRepeatCount(0);
        this.t.addUpdateListener(this.v);
        this.t.addListener(this.u);
    }

    public synchronized void a() {
        d();
        if (this.f28726e == null) {
            this.f28726e = View.inflate(this.f28724c, c.f.feeds_dialog_ins_success, (ViewGroup) null);
            this.k = (ImageView) this.f28726e.findViewById(c.e.iv_ins_state);
            this.i = (RobotoTextView) this.f28726e.findViewById(c.e.tv_ins_state);
            this.k.setImageResource(c.d.feeds_loading_success);
            this.i.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_instagram_login_connected));
            FrameLayout frameLayout = (FrameLayout) this.f28724c.findViewById(16908290);
            if (frameLayout != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.a(165, this.f28724c), l.a(124, this.f28724c));
                layoutParams.gravity = 17;
                frameLayout.addView(this.f28726e, layoutParams);
            }
        }
        this.f28726e.setVisibility(0);
        this.q = 2;
        this.s.sendEmptyMessageDelayed(292, 1000);
        this.s.sendEmptyMessageDelayed(291, 1500);
    }

    public synchronized void b() {
        d();
        if (this.f28727f == null) {
            this.f28727f = View.inflate(this.f28724c, c.f.feeds_dialog_ins_success, (ViewGroup) null);
            this.l = (ImageView) this.f28727f.findViewById(c.e.iv_ins_state);
            this.j = (RobotoTextView) this.f28727f.findViewById(c.e.tv_ins_state);
            this.l.setImageResource(c.d.feeds_loading_error);
            this.j.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_instagram_login_error));
            FrameLayout frameLayout = (FrameLayout) this.f28724c.findViewById(16908290);
            if (frameLayout != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.a(165, this.f28724c), l.a(124, this.f28724c));
                layoutParams.gravity = 17;
                frameLayout.addView(this.f28727f, layoutParams);
            }
        }
        if (this.f28725d != null) {
            this.f28725d.setVisibility(8);
        }
        this.f28727f.setVisibility(0);
        this.q = 3;
        this.s.sendEmptyMessageDelayed(292, 1000);
        this.s.sendEmptyMessageDelayed(291, 1500);
    }

    public synchronized void c() {
        d();
        this.m = 5;
        this.o = 0;
        this.p = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
        if (!this.f28724c.isFinishing()) {
            com.garena.android.appkit.d.a.b(f28722b, " do enter show in .......");
            if (this.f28725d == null) {
                this.f28725d = View.inflate(this.f28724c, c.f.feeds_dialog_post_progress, (ViewGroup) null);
                this.f28728g = (CircleProgressView) this.f28725d.findViewById(c.e.progress_circle);
                this.h = (TextView) this.f28725d.findViewById(c.e.tv_posting);
                this.h.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_text_loading));
                FrameLayout frameLayout = (FrameLayout) this.f28724c.findViewById(16908290);
                if (frameLayout != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.a(124, this.f28724c), l.a(124, this.f28724c));
                    layoutParams.gravity = 17;
                    frameLayout.addView(this.f28725d, layoutParams);
                }
            }
            this.f28725d.setVisibility(0);
            this.q = 1;
            if (this.n) {
                a(10);
                f();
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.m >= 90) {
            a(96);
            return;
        }
        this.o++;
        this.r.postDelayed(this.f28723a, (long) this.p);
    }

    public void a(int i2) {
        CircleProgressView circleProgressView = this.f28728g;
        if (circleProgressView != null && i2 >= this.m) {
            this.m = i2;
            circleProgressView.setProgressNotInUiThread(i2);
        }
    }

    private void g() {
        this.m = 0;
        this.o = 0;
        this.p = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
        View view = this.f28725d;
        if (view != null) {
            view.setVisibility(8);
        }
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void d() {
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        View view = this.f28726e;
        if (view != null) {
            view.setAlpha(1.0f);
            this.f28726e.setVisibility(8);
        }
        View view2 = this.f28727f;
        if (view2 != null) {
            view2.setAlpha(1.0f);
            this.f28727f.setVisibility(8);
        }
        View view3 = this.f28725d;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        a aVar = this.s;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages((Object) null);
        }
        g();
        this.q = 4;
    }

    public void a(boolean z) {
        if (z) {
            int i2 = this.q;
            if (i2 == 1) {
                View view = this.f28725d;
                if (view != null) {
                    view.setVisibility(0);
                }
            } else if (i2 == 2) {
                View view2 = this.f28726e;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            } else if (i2 == 3) {
                View view3 = this.f28727f;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
            }
        } else {
            View view4 = this.f28726e;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            View view5 = this.f28727f;
            if (view5 != null) {
                view5.setVisibility(8);
            }
            View view6 = this.f28725d;
            if (view6 != null) {
                view6.setVisibility(8);
            }
        }
    }
}
