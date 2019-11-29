package com.otaliastudios.cameraview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class w extends View {

    /* renamed from: a  reason: collision with root package name */
    ak<Integer> f15681a;

    /* renamed from: b  reason: collision with root package name */
    private v f15682b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f15683c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f15684d;

    /* renamed from: e  reason: collision with root package name */
    private final float f15685e;

    public w(Context context) {
        this(context, (AttributeSet) null);
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15681a = new ak<>();
        this.f15683c = new ColorDrawable(-1);
        this.f15683c.setAlpha(160);
        this.f15684d = new ColorDrawable(-1);
        this.f15684d.setAlpha(160);
        this.f15685e = TypedValue.applyDimension(1, 0.9f, context.getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f15683c.setBounds(i, 0, i3, (int) this.f15685e);
        this.f15684d.setBounds(0, i2, (int) this.f15685e, i4);
    }

    public v a() {
        return this.f15682b;
    }

    public void a(v vVar) {
        this.f15682b = vVar;
        postInvalidate();
    }

    /* renamed from: com.otaliastudios.cameraview.w$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15686a = new int[v.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.otaliastudios.cameraview.v[] r0 = com.otaliastudios.cameraview.v.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15686a = r0
                int[] r0 = f15686a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.otaliastudios.cameraview.v r1 = com.otaliastudios.cameraview.v.OFF     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f15686a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.otaliastudios.cameraview.v r1 = com.otaliastudios.cameraview.v.DRAW_3X3     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f15686a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.otaliastudios.cameraview.v r1 = com.otaliastudios.cameraview.v.DRAW_PHI     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f15686a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.otaliastudios.cameraview.v r1 = com.otaliastudios.cameraview.v.DRAW_4X4     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.w.AnonymousClass1.<clinit>():void");
        }
    }

    private int b() {
        int i = AnonymousClass1.f15686a[this.f15682b.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 0 : 3;
    }

    private float a(int i) {
        int b2 = b();
        if (this.f15682b == v.DRAW_PHI) {
            return i == 1 ? 0.38196602f : 0.618034f;
        }
        return (1.0f / ((float) (b2 + 1))) * (((float) i) + 1.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f15681a.a();
        int b2 = b();
        for (int i = 0; i < b2; i++) {
            float a2 = a(i);
            canvas.translate(BitmapDescriptorFactory.HUE_RED, ((float) getHeight()) * a2);
            this.f15683c.draw(canvas);
            float f2 = -a2;
            canvas.translate(BitmapDescriptorFactory.HUE_RED, ((float) getHeight()) * f2);
            canvas.translate(a2 * ((float) getWidth()), BitmapDescriptorFactory.HUE_RED);
            this.f15684d.draw(canvas);
            canvas.translate(f2 * ((float) getWidth()), BitmapDescriptorFactory.HUE_RED);
        }
        this.f15681a.a(Integer.valueOf(b2));
    }
}
