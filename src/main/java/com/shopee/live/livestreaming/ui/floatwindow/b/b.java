package com.shopee.live.livestreaming.ui.floatwindow.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.d.a.b;
import androidx.d.a.d;
import androidx.d.a.e;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.ui.view.CleanableLayout;
import com.shopee.live.livestreaming.ui.view.TXVideoLayout;
import com.shopee.live.livestreaming.util.p;
import com.squareup.a.af;
import com.squareup.a.ah;
import com.squareup.a.w;
import java.lang.ref.WeakReference;

public class b extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    FrameLayout f29065a;

    /* renamed from: b  reason: collision with root package name */
    d f29066b;

    /* renamed from: c  reason: collision with root package name */
    d f29067c;

    /* renamed from: d  reason: collision with root package name */
    int f29068d;

    /* renamed from: e  reason: collision with root package name */
    int f29069e;

    /* renamed from: f  reason: collision with root package name */
    int f29070f;

    /* renamed from: g  reason: collision with root package name */
    int f29071g;
    private RelativeLayout h;
    private TXVideoLayout i;
    private final WindowManager j;
    private WindowManager.LayoutParams k;
    private float l;
    private float m;
    private float n;
    private float o;
    private boolean p;
    private int q;
    private WeakReference<com.shopee.live.livestreaming.ui.floatwindow.service.b> r;

    public b(Context context) {
        this(context, (AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View inflate = LayoutInflater.from(context).inflate(c.f.live_streaming_layout_audience_small_window, this, true);
        this.h = (RelativeLayout) inflate.findViewById(c.e.rl_float_window);
        this.i = (TXVideoLayout) inflate.findViewById(c.e.small_video_view);
        inflate.findViewById(c.e.small_video_cover).setOnClickListener(this);
        ((ImageView) inflate.findViewById(c.e.small_iv_close)).setOnClickListener(this);
        this.f29065a = (FrameLayout) inflate.findViewById(c.e.fl_video);
        this.j = (WindowManager) context.getSystemService("window");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.q = context.getResources().getDimensionPixelSize(identifier);
        }
        this.f29066b = a(this.f29065a, d.i, Float.valueOf(this.f29065a.getX()));
        this.f29067c = a(this.f29065a, d.j, Float.valueOf(this.f29065a.getY()));
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f29068d = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.f29069e = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
        this.f29070f = context.getResources().getDimensionPixelOffset(c.C0439c.live_streaming_float_window_width);
        this.f29071g = context.getResources().getDimensionPixelOffset(c.C0439c.live_streaming_float_window_height);
    }

    public void a(boolean z, float f2) {
        int i2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.h.getLayoutParams();
        float d2 = (float) com.garena.android.appkit.tools.b.d(c.C0439c.live_streaming_float_window_padding);
        if (z) {
            layoutParams.height = com.garena.android.appkit.tools.b.d(c.C0439c.live_streaming_float_window_width);
            if (f2 >= 1.0f) {
                float f3 = d2 * 2.0f;
                i2 = (int) (((((float) layoutParams.height) - f3) * f2) + f3);
            } else {
                i2 = com.garena.android.appkit.tools.b.d(c.C0439c.live_streaming_float_window_height);
            }
            layoutParams.width = i2;
            this.f29070f = layoutParams.width;
            this.f29071g = layoutParams.height;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.i.getLayoutParams();
            float f4 = d2 * 2.0f;
            layoutParams2.width = (int) (((float) this.f29070f) - f4);
            layoutParams2.height = (int) (f2 >= 1.0f ? ((float) layoutParams2.width) / f2 : ((float) this.f29071g) - f4);
            this.i.setLayoutParams(layoutParams2);
        } else {
            layoutParams.width = com.garena.android.appkit.tools.b.d(c.C0439c.live_streaming_float_window_width);
            layoutParams.height = com.garena.android.appkit.tools.b.d(c.C0439c.live_streaming_float_window_height);
            this.f29070f = layoutParams.width;
            this.f29071g = layoutParams.height;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.i.getLayoutParams();
            float f5 = d2 * 2.0f;
            layoutParams3.width = (int) (((float) this.f29070f) - f5);
            layoutParams3.height = (int) (f2 >= 1.0f ? ((float) layoutParams3.width) / f2 : ((float) this.f29071g) - f5);
            this.i.setLayoutParams(layoutParams3);
        }
        this.h.setLayoutParams(layoutParams);
        post(new Runnable() {
            public void run() {
                b bVar = b.this;
                bVar.f29066b = bVar.a(bVar.f29065a, d.i, Float.valueOf(b.this.f29065a.getX()));
                b bVar2 = b.this;
                bVar2.f29067c = bVar2.a(bVar2.f29065a, d.j, Float.valueOf(b.this.f29065a.getY()));
            }
        });
    }

    public void setBackground(String str) {
        if (str == null || Build.VERSION.SDK_INT < 17) {
            this.f29065a.setBackgroundResource(c.d.live_streaming_land_background);
        } else {
            w.a(getContext()).a(p.a(str)).a((ah) new CleanableLayout.a(getContext().getApplicationContext())).a((af) new af() {
                public void a(Drawable drawable) {
                }

                public void a(Bitmap bitmap, w.d dVar) {
                    b.this.f29065a.setBackground(new BitmapDrawable(bitmap));
                }

                public void b(Drawable drawable) {
                    b.this.f29065a.setBackgroundResource(c.d.live_streaming_land_background);
                }
            });
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == c.e.small_iv_close) {
            WeakReference<com.shopee.live.livestreaming.ui.floatwindow.service.b> weakReference = this.r;
            if (weakReference != null && weakReference.get() != null) {
                ((com.shopee.live.livestreaming.ui.floatwindow.service.b) this.r.get()).b();
                com.shopee.live.livestreaming.ui.audience.c.p();
            }
        } else if (id == c.e.small_video_cover) {
            WeakReference<com.shopee.live.livestreaming.ui.floatwindow.service.b> weakReference2 = this.r;
            if (weakReference2 != null && weakReference2.get() != null) {
                ((com.shopee.live.livestreaming.ui.floatwindow.service.b) this.r.get()).a();
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = ((int) motionEvent.getRawY()) - this.q;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.l = motionEvent.getX();
            this.m = motionEvent.getY();
            this.n = motionEvent.getRawX();
            this.o = motionEvent.getRawY();
            this.p = false;
            this.f29066b.b();
            this.f29067c.b();
        } else if (action == 1) {
            float rawX2 = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            if (Math.sqrt(Math.pow((double) Math.abs(rawX2 - this.n), 2.0d) + Math.pow((double) Math.abs(rawY2 - this.o), 2.0d)) < ((double) ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                this.p = false;
            } else {
                this.p = true;
            }
            int i2 = this.f29068d;
            if (rawX <= i2 / 2) {
                i2 = 0;
            }
            WindowManager.LayoutParams layoutParams = this.k;
            layoutParams.x = i2 - this.f29070f;
            this.j.updateViewLayout(this, layoutParams);
            this.f29066b.a();
            this.f29067c.a();
        } else if (action == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (!(this.l == x && this.m == y)) {
                WindowManager.LayoutParams layoutParams2 = this.k;
                layoutParams2.x = (int) (((float) rawX) - this.l);
                layoutParams2.y = (int) (((float) rawY) - this.m);
                this.j.updateViewLayout(this, layoutParams2);
                if (this.k.x < 0) {
                    this.f29065a.animate().x((float) this.k.x).setDuration(0).start();
                } else if (this.k.x > this.f29068d - this.f29070f) {
                    this.f29065a.animate().x((float) (this.k.x - (this.f29068d - this.f29070f))).setDuration(0).start();
                }
                if (this.k.y < 0) {
                    this.f29065a.animate().y((float) this.k.y).setDuration(0).start();
                } else if (this.k.y > this.f29069e - this.f29071g) {
                    this.f29065a.animate().y((float) (this.k.y - (this.f29069e - this.f29071g))).setDuration(0).start();
                }
                return false;
            }
        }
        if (this.p || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setParams(WindowManager.LayoutParams layoutParams) {
        this.k = layoutParams;
    }

    public TXVideoLayout getVideoLayout() {
        return this.i;
    }

    public void setFloatWindow(com.shopee.live.livestreaming.ui.floatwindow.service.b bVar) {
        this.r = new WeakReference<>(bVar);
    }

    /* access modifiers changed from: private */
    public d a(View view, b.d dVar, Float f2) {
        d dVar2 = new d(view, dVar);
        e eVar = new e(f2.floatValue());
        eVar.a(1500.0f);
        eVar.b(0.75f);
        dVar2.a(eVar);
        return dVar2;
    }
}
