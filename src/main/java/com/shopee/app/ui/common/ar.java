package com.shopee.app.ui.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.c;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class ar {

    /* renamed from: a  reason: collision with root package name */
    private Context f21166a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f21167b;

    /* renamed from: c  reason: collision with root package name */
    private View f21168c;

    /* renamed from: d  reason: collision with root package name */
    private int f21169d;

    /* renamed from: e  reason: collision with root package name */
    private int f21170e;

    /* renamed from: f  reason: collision with root package name */
    private int f21171f;

    /* renamed from: g  reason: collision with root package name */
    private int f21172g;
    private int h;
    private int i;
    private List<Integer> j = new ArrayList();
    private int k;
    private int l;
    private View.OnClickListener m;
    /* access modifiers changed from: private */
    public a n;
    /* access modifiers changed from: private */
    public FrameLayout o;
    /* access modifiers changed from: private */
    public Animation p;

    public interface a {
        void a();
    }

    public ar(Context context, RelativeLayout relativeLayout, View view, int i2, int i3, int i4, int i5, int i6, int i7, List<Integer> list, int i8, int i9, FrameLayout frameLayout, View.OnClickListener onClickListener, a aVar) {
        this.f21166a = context;
        this.f21167b = relativeLayout;
        this.f21168c = view;
        this.f21169d = i2;
        this.f21170e = i3;
        this.f21171f = i4;
        this.f21172g = i5;
        this.h = i6;
        this.i = i7;
        this.j = list;
        this.k = i8;
        this.l = i9;
        this.o = frameLayout;
        this.m = onClickListener;
        this.n = aVar;
        try {
            c();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void a() {
        if (this.p == null) {
            FrameLayout frameLayout = this.o;
            if (frameLayout != null && frameLayout.getVisibility() == 0) {
                this.p = AnimationUtils.loadAnimation(this.f21166a, R.anim.fade_out_animation_long);
                this.o.startAnimation(this.p);
                this.p.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        ar.this.o.setVisibility(8);
                        Animation unused = ar.this.p = null;
                        if (ar.this.n != null) {
                            ar.this.n.a();
                        }
                    }
                });
            }
        }
    }

    public void b() {
        FrameLayout frameLayout = this.o;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    private void c() {
        this.o = new FrameLayout(this.f21166a);
        int a2 = c.a().a(40);
        int a3 = c.a().a(40);
        FrameLayout frameLayout = (FrameLayout) View.inflate(this.f21166a, R.layout.tool_tip_description_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = a3 - c.a().a(22);
        int i2 = this.f21169d;
        if (i2 > 0) {
            frameLayout.setBackgroundResource(i2);
        }
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            frameLayout.setOnClickListener(onClickListener);
        }
        View view = this.f21168c;
        if (view != null) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            this.o.addView(frameLayout, layoutParams);
        }
        ImageView imageView = (ImageView) View.inflate(this.f21166a, R.layout.tool_tip_triangle_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a2, a3);
        layoutParams2.bottomMargin = b.a.f7690a;
        int i3 = this.k;
        if (i3 > 0) {
            layoutParams2.gravity = i3;
        }
        int i4 = this.l;
        if (i4 > 0) {
            layoutParams2.rightMargin = i4;
        }
        this.o.addView(imageView, layoutParams2);
        if (this.f21170e > 0) {
            imageView.setImageDrawable(this.f21166a.getResources().getDrawable(this.f21170e));
        }
        a(9.0f, 7000);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = this.f21171f;
        layoutParams3.rightMargin = this.f21172g;
        layoutParams3.topMargin = this.h;
        layoutParams3.bottomMargin = this.i;
        List<Integer> list = this.j;
        if (list != null) {
            for (Integer intValue : list) {
                layoutParams3.addRule(intValue.intValue());
            }
        }
        this.f21167b.addView(this.o, layoutParams3);
        this.o.startAnimation(AnimationUtils.loadAnimation(this.f21166a, R.anim.fade_in_animation_long));
    }

    /* access modifiers changed from: private */
    public void a(final float f2, final long j2) {
        if (j2 > 0) {
            this.o.animate().translationYBy(f2).setDuration(650).setInterpolator(new DecelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ar.this.a(-f2, j2 - 650);
                }
            });
            return;
        }
        this.o.postDelayed(new Runnable() {
            public void run() {
                ar.this.a();
            }
        }, 1000);
    }
}
