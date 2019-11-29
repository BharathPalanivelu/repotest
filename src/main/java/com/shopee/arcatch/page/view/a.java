package com.shopee.arcatch.page.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.arcatch.b.c.b;
import java.util.ArrayList;
import java.util.List;

public class a extends View {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<C0420a> f27040a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private com.shopee.arcatch.c.h.a f27041b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Paint f27042c;

    public a(Context context) {
        super(context);
        b();
    }

    public void setProcess(com.shopee.arcatch.c.h.a aVar) {
        this.f27041b = aVar;
    }

    public void setCry(String str) {
        com.shopee.arcatch.c.h.a aVar = this.f27041b;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    private void b() {
        this.f27042c = new Paint();
        Typeface createFromAsset = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Bold.ttf");
        if (createFromAsset != null) {
            this.f27042c.setTypeface(createFromAsset);
        }
        this.f27042c.setColor(Color.parseColor("#FFFCEC1F"));
        this.f27042c.setTextSize((float) b.c(getContext(), 40.0f));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.f27040a.size(); i++) {
            this.f27040a.get(i).a(canvas);
        }
        if (this.f27040a.size() > 0) {
            invalidate();
        }
    }

    public void a() {
        if (this.f27040a != null) {
            for (int i = 0; i < this.f27040a.size(); i++) {
                this.f27040a.get(i).a();
            }
        }
    }

    public void a(float f2, float f3, float f4, String str) {
        setCry(str);
        this.f27040a.add(new C0420a(f2, f3, com.shopee.arcatch.c.d.a.a().c(str), f4));
        invalidate();
    }

    /* renamed from: com.shopee.arcatch.page.view.a$a  reason: collision with other inner class name */
    class C0420a implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        private float f27044b;

        /* renamed from: c  reason: collision with root package name */
        private float f27045c;

        /* renamed from: d  reason: collision with root package name */
        private float f27046d;

        /* renamed from: e  reason: collision with root package name */
        private ValueAnimator f27047e = ValueAnimator.ofFloat(new float[]{BitmapDescriptorFactory.HUE_RED, 255.0f});

        /* renamed from: f  reason: collision with root package name */
        private Bitmap f27048f;

        /* renamed from: g  reason: collision with root package name */
        private Paint f27049g = new Paint();
        private float h;

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationStart(Animator animator, boolean z) {
        }

        public C0420a(float f2, float f3, Bitmap bitmap, float f4) {
            this.f27044b = f2;
            this.f27045c = f3;
            this.h = f4;
            this.f27048f = bitmap;
            this.f27047e.addUpdateListener(this);
            this.f27047e.addListener(this);
            this.f27047e.setDuration(1000);
            this.f27047e.setRepeatCount(0);
            this.f27047e.start();
        }

        /* access modifiers changed from: protected */
        public void a() {
            ValueAnimator valueAnimator = this.f27047e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }

        public void a(Canvas canvas) {
            Bitmap bitmap = this.f27048f;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, this.f27044b, this.f27045c, this.f27049g);
                canvas.drawText("-" + b.a(-this.h), this.f27044b, this.f27045c, a.this.f27042c);
            }
        }

        public void onAnimationEnd(Animator animator, boolean z) {
            a.this.f27040a.remove(this);
        }

        public void onAnimationEnd(Animator animator) {
            a.this.f27040a.remove(this);
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f27046d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f27049g.setAlpha((int) this.f27046d);
        }
    }
}
