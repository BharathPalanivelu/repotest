package com.shopee.livequiz.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.shopee.livequiz.c;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.c.f;

public class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    View f29988a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f29989b;

    /* renamed from: c  reason: collision with root package name */
    RelativeLayout f29990c;

    /* renamed from: d  reason: collision with root package name */
    LottieAnimationView f29991d;

    /* renamed from: e  reason: collision with root package name */
    TextView f29992e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f29993f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f29994g;
    /* access modifiers changed from: private */
    public C0460a h;

    /* renamed from: com.shopee.livequiz.ui.view.a$a  reason: collision with other inner class name */
    public interface C0460a {
        void a();
    }

    public a(Context context) {
        this(context, (AttributeSet) null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29994g = false;
        c();
    }

    private void c() {
        this.f29988a = LayoutInflater.from(getContext()).inflate(c.f.livesdk_shopee_layout_extra_life_used, this, true);
        this.f29989b = (ImageView) this.f29988a.findViewById(c.d.iv_move_heart);
        this.f29990c = (RelativeLayout) this.f29988a.findViewById(c.d.rl_wrap_lottie);
        this.f29991d = (LottieAnimationView) this.f29988a.findViewById(c.d.animation_view);
        this.f29992e = (TextView) this.f29988a.findViewById(c.d.tv_finish);
        this.f29991d.a((ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() == 1.0f) {
                    a.this.f29991d.d();
                    boolean unused = a.this.f29994g = true;
                    f.b(new e() {
                        public void a() {
                            a.this.f29990c.callOnClick();
                        }
                    }, 1000);
                } else {
                    boolean unused2 = a.this.f29994g = false;
                }
                a.this.f29992e.setVisibility(0);
                a.this.f29992e.setAlpha(valueAnimator.getAnimatedFraction());
            }
        });
        this.f29990c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (a.this.f29994g) {
                    boolean unused = a.this.f29994g = false;
                    ViewGroup viewGroup = (ViewGroup) a.this.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(a.this);
                    }
                    boolean unused2 = a.this.f29993f = false;
                    if (a.this.h != null) {
                        a.this.h.a();
                        C0460a unused3 = a.this.h = null;
                    }
                }
            }
        });
    }

    public void a() {
        this.f29992e.setText(com.shopee.livequiz.g.e.a().a("t_ls_life_revived"));
        this.f29991d.setImageAssetsFolder("images");
        this.f29991d.setAnimation("extra_life.json");
        this.f29991d.b();
        this.f29993f = true;
    }

    public void a(float f2) {
        this.f29990c.getBackground().mutate().setAlpha((int) (f2 * 256.0f));
    }

    public ImageView getMovingHeart() {
        return this.f29989b;
    }

    public boolean b() {
        return this.f29993f;
    }

    public void setListener(C0460a aVar) {
        this.h = aVar;
    }
}
