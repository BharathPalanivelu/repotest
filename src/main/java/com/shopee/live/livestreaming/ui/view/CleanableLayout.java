package com.shopee.live.livestreaming.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSDriverException;
import android.renderscript.RSIllegalArgumentException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.android.appkit.f.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.p;
import com.shopee.live.livestreaming.util.x;
import com.squareup.a.af;
import com.squareup.a.ah;
import com.squareup.a.w;
import java.util.ArrayList;
import java.util.List;

public class CleanableLayout extends ConstraintLayout {
    private boolean A;
    private boolean B;
    private String C;

    /* renamed from: g  reason: collision with root package name */
    protected AutoDismissLayout f29119g;
    protected View h;
    protected AutoDismissLayout i;
    protected View j;
    final af k;
    private List<View> l;
    /* access modifiers changed from: private */
    public float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private long r;
    private boolean s;
    private boolean t;
    private boolean u;
    private ValueAnimator v;
    private long w;
    private b x;
    private RobotoTextView y;
    private RobotoTextView z;

    public interface b {
        void a();
    }

    public CleanableLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CleanableLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CleanableLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = new af() {
            public void a(Drawable drawable) {
            }

            public void a(Bitmap bitmap, w.d dVar) {
                CleanableLayout.this.setBackground(new BitmapDrawable(bitmap));
            }

            public void b(Drawable drawable) {
                CleanableLayout.this.setBackgroundResource(c.d.live_streaming_land_background);
            }
        };
        this.l = new ArrayList();
    }

    public void a(Context context) {
        this.f29119g = (AutoDismissLayout) LayoutInflater.from(context).inflate(c.f.live_streaming_layout_clean_mode_user_guide, (ViewGroup) null);
        this.f29119g.setId(c.e.user_guide_layout);
        addView(this.f29119g);
        g();
        this.f29119g.setVisibility(8);
        this.y = (RobotoTextView) findViewById(c.e.tv_clean_notify);
        this.y.setText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_slide_clean_mode_tips));
        f.a().a(new Runnable() {
            public void run() {
                int f2 = x.f();
                if (!com.shopee.live.livestreaming.b.b().a().ifSetUserGuideCleanModeNotify(Integer.valueOf(f2))) {
                    com.shopee.live.livestreaming.b.b().a().setUserGuideCleanModeNotify(Integer.valueOf(f2));
                    CleanableLayout.this.f29119g.b();
                }
            }
        });
        this.h = LayoutInflater.from(context).inflate(c.f.live_streaming_layout_clean_mode_resume_button, (ViewGroup) null);
        this.h.setId(c.e.resume_layout);
        addView(this.h, getChildCount() - 2);
        this.i = (AutoDismissLayout) findViewById(c.e.rl_user_guide);
        this.j = findViewById(c.e.iv_resume_btn);
        this.h.setVisibility(8);
        this.h.setAlpha(BitmapDescriptorFactory.HUE_RED);
        this.z = (RobotoTextView) findViewById(c.e.tv_user_guide);
        this.z.setText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_regular_mode_tips));
        this.z.setLineSpacing(BitmapDescriptorFactory.HUE_RED, x.d() ? 1.5f : 1.2f);
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.a((ConstraintLayout) this);
        cVar.a(this.h.getId(), 4, getId(), 4, 0);
        cVar.b((ConstraintLayout) this);
        this.j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                com.shopee.live.livestreaming.ui.audience.c.c();
                CleanableLayout.this.b();
            }
        });
    }

    public void setPageSize(float f2) {
        this.m = f2;
    }

    public void b(View view) {
        this.l.add(view);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.w = System.currentTimeMillis();
            this.u = false;
            if (f()) {
                ValueAnimator valueAnimator = this.v;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    this.n = motionEvent.getRawX();
                    this.o = motionEvent.getRawY();
                    this.p = getCleableViewsTransX();
                    this.r = System.currentTimeMillis();
                    this.q = BitmapDescriptorFactory.HUE_RED;
                    this.t = true;
                }
            }
        } else if (action == 2) {
            if (f() && this.t && !this.u && Math.abs(motionEvent.getRawX() - this.n) > 50.0f && Math.abs(motionEvent.getRawY() - this.o) < 50.0f) {
                this.u = true;
            }
            if (this.t && this.u) {
                float rawX = motionEvent.getRawX() - this.n;
                float f2 = this.p;
                float f3 = rawX + f2;
                this.s = f3 > f2;
                float max = Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(f3, this.m));
                setCleableViewsTransX(max);
                this.q = Math.abs(max - this.p) / ((float) (System.currentTimeMillis() - this.r));
            }
        } else if (action == 1 || action == 3) {
            if (this.t) {
                e();
                this.t = false;
            }
            if (!this.u && System.currentTimeMillis() - this.w <= 200) {
                b bVar = this.x;
                if (bVar != null) {
                    bVar.a();
                }
            }
            this.u = false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (action == 0 || onTouchEvent) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r6 = this;
            boolean r0 = r6.f()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            float r0 = r6.getCleableViewsTransX()
            float r1 = r6.p
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0019
            return
        L_0x0019:
            float r1 = r6.m
            r3 = 1086324736(0x40c00000, float:6.0)
            float r1 = r1 / r3
            float r3 = r6.p
            float r3 = r0 - r3
            float r3 = java.lang.Math.abs(r3)
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x003d
            float r1 = r6.q
            r3 = 1061997773(0x3f4ccccd, float:0.8)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0034
            goto L_0x003d
        L_0x0034:
            boolean r1 = r6.s
            if (r1 == 0) goto L_0x003a
        L_0x0038:
            r1 = 0
            goto L_0x0043
        L_0x003a:
            float r1 = r6.m
            goto L_0x0043
        L_0x003d:
            boolean r1 = r6.s
            if (r1 == 0) goto L_0x0038
            float r1 = r6.m
        L_0x0043:
            boolean r3 = r6.s
            if (r3 == 0) goto L_0x004d
            com.shopee.live.livestreaming.ui.view.AutoDismissLayout r3 = r6.f29119g
            r3.d()
            goto L_0x0052
        L_0x004d:
            com.shopee.live.livestreaming.ui.view.AutoDismissLayout r3 = r6.i
            r3.d()
        L_0x0052:
            boolean r3 = r6.s
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x006c
            boolean r3 = r6.u
            if (r3 == 0) goto L_0x006c
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0066
            r6.A = r5
            com.shopee.live.livestreaming.ui.audience.c.c(r5, r5)
            goto L_0x0079
        L_0x0066:
            r6.A = r4
            com.shopee.live.livestreaming.ui.audience.c.c(r5, r4)
            goto L_0x0079
        L_0x006c:
            boolean r3 = r6.u
            if (r3 == 0) goto L_0x0079
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0077
            r6.A = r5
            goto L_0x0079
        L_0x0077:
            r6.A = r4
        L_0x0079:
            android.animation.ValueAnimator r0 = r6.a((float) r0, (float) r1)
            r6.v = r0
            android.animation.ValueAnimator r0 = r6.v
            r0.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.live.livestreaming.ui.view.CleanableLayout.e():void");
    }

    public void b() {
        this.A = false;
        if (f()) {
            this.i.d();
            ValueAnimator valueAnimator = this.v;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.v.cancel();
            }
            this.v = a(getCleableViewsTransX(), (float) BitmapDescriptorFactory.HUE_RED);
            this.v.start();
        }
    }

    public void c() {
        a(true);
    }

    public void a(boolean z2) {
        this.A = true;
        com.shopee.live.livestreaming.ui.audience.c.c(false, true);
        if (f()) {
            this.f29119g.d();
            ValueAnimator valueAnimator = this.v;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.v.cancel();
            }
            if (z2) {
                this.v = a(getCleableViewsTransX(), this.m);
                this.v.start();
                return;
            }
            this.h.setVisibility(0);
            post(new Runnable() {
                public void run() {
                    CleanableLayout cleanableLayout = CleanableLayout.this;
                    cleanableLayout.setCleableViewsTransX(cleanableLayout.m);
                }
            });
        }
    }

    private ValueAnimator a(final float f2, final float f3) {
        this.v = ValueAnimator.ofFloat(new float[]{f2, f3});
        this.v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CleanableLayout.this.setCleableViewsTransX(floatValue);
                CleanableLayout.this.a(f2, f3, floatValue);
            }
        });
        long min = Math.min(500, Math.max(200, ((this.q > BitmapDescriptorFactory.HUE_RED ? (long) (Math.abs(f2 - f3) / this.q) : 200) * 2) / 3));
        this.v.setInterpolator(new DecelerateInterpolator());
        return this.v.setDuration(min);
    }

    /* access modifiers changed from: private */
    public void a(float f2, float f3, float f4) {
        if (f3 > f2) {
            float min = Math.min(300.0f, Math.abs(f3 - f4)) / 300.0f;
            this.h.setVisibility(0);
            this.h.setAlpha(1.0f - min);
            if (min == BitmapDescriptorFactory.HUE_RED) {
                int f5 = x.f();
                if (!com.shopee.live.livestreaming.b.b().a().ifSetUserGuideResumeButton(Integer.valueOf(f5))) {
                    com.shopee.live.livestreaming.b.b().a().setUserGuideResumeButton(Integer.valueOf(f5));
                    this.i.b();
                    return;
                }
                return;
            }
            return;
        }
        float min2 = Math.min(300.0f, Math.abs(f2 - f4)) / 300.0f;
        this.h.setAlpha(min2);
        if (min2 == BitmapDescriptorFactory.HUE_RED) {
            this.h.setVisibility(8);
        }
    }

    public void setTouchListener(b bVar) {
        this.x = bVar;
    }

    private boolean f() {
        return !this.l.isEmpty();
    }

    /* access modifiers changed from: private */
    public void setCleableViewsTransX(float f2) {
        for (View translationX : this.l) {
            translationX.setTranslationX(f2);
        }
    }

    private float getCleableViewsTransX() {
        return f() ? this.l.get(0).getTranslationX() : BitmapDescriptorFactory.HUE_RED;
    }

    public void setNeedBackground(boolean z2) {
        this.B = z2;
    }

    public void setLandBackground(String str) {
        this.C = str;
        d();
    }

    public void d() {
        if (!this.B) {
            return;
        }
        if (this.C == null || Build.VERSION.SDK_INT < 18) {
            setBackgroundResource(c.d.live_streaming_land_background);
        } else {
            w.a(getContext()).a(p.a(this.C)).a((ah) new a(getContext().getApplicationContext())).a(this.k);
        }
    }

    public static class a implements ah {

        /* renamed from: a  reason: collision with root package name */
        RenderScript f29127a;

        public String a() {
            return "blur";
        }

        public a(Context context) {
            try {
                this.f29127a = RenderScript.create(context);
            } catch (RSDriverException e2) {
                com.shopee.e.a.a.a(e2, "create renderscript err", new Object[0]);
            }
        }

        public Bitmap a(Bitmap bitmap) {
            if (this.f29127a == null) {
                return bitmap;
            }
            try {
                Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                Allocation createFromBitmap = Allocation.createFromBitmap(this.f29127a, copy, Allocation.MipmapControl.MIPMAP_FULL, 128);
                Allocation createTyped = Allocation.createTyped(this.f29127a, createFromBitmap.getType());
                ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(this.f29127a, Element.U8_4(this.f29127a));
                create.setInput(createFromBitmap);
                create.setRadius(25.0f);
                create.forEach(createTyped);
                createTyped.copyTo(copy);
                bitmap.recycle();
                return copy;
            } catch (RSIllegalArgumentException e2) {
                com.shopee.e.a.a.a(e2, "blur transform error", new Object[0]);
                return bitmap;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setPageSize((float) com.shopee.live.livestreaming.util.w.a(getContext().getApplicationContext()));
        View view = this.h;
        if (view != null) {
            view.setVisibility(8);
        }
        g();
        if (this.A) {
            a(false);
        } else {
            b();
        }
    }

    private void g() {
        if (this.f29119g != null) {
            boolean z2 = true;
            if (d.a(getContext()) != 1) {
                z2 = false;
            }
            int min = Math.min(com.shopee.live.livestreaming.util.w.a(getContext()), com.shopee.live.livestreaming.util.w.b(getContext()));
            androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
            cVar.a((ConstraintLayout) this);
            cVar.a(this.f29119g.getId(), getId());
            cVar.d(this.f29119g.getId(), min - (com.garena.android.appkit.tools.b.d(c.C0439c.live_streaming_user_guide_margin_horizontal) * 2));
            if (z2) {
                cVar.c(this.f29119g.getId(), (int) com.shopee.live.livestreaming.util.w.a(getContext(), 140.0f));
                androidx.constraintlayout.widget.c cVar2 = cVar;
                cVar2.a(this.f29119g.getId(), 3, getId(), 3, 0);
                cVar2.a(this.f29119g.getId(), 4, getId(), 4, 0);
            } else {
                cVar.a(this.f29119g.getId(), 3, getId(), 3, com.garena.android.appkit.tools.b.d(c.C0439c.live_streaming_user_guide_margin_top));
            }
            cVar.b((ConstraintLayout) this);
        }
    }
}
