package com.garena.cropimage.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Scroller;
import com.garena.cropimage.library.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CropTouchImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public static float f7871a = 0.95f;

    /* renamed from: b  reason: collision with root package name */
    public static float f7872b = 0.52f;
    private boolean A;
    /* access modifiers changed from: private */
    public float B = BitmapDescriptorFactory.HUE_RED;
    /* access modifiers changed from: private */
    public float C = BitmapDescriptorFactory.HUE_RED;
    /* access modifiers changed from: private */
    public float D = BitmapDescriptorFactory.HUE_RED;
    /* access modifiers changed from: private */
    public float E = BitmapDescriptorFactory.HUE_RED;
    private int F = 1;
    private int G = 1;
    /* access modifiers changed from: private */
    public ScaleGestureDetector H;
    /* access modifiers changed from: private */
    public GestureDetector I;
    private boolean J;
    private boolean K;
    private int L;
    private Rect M = new Rect();
    private BitmapRegionDecoder N;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public float f7873c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Matrix f7874d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f7875e;

    /* renamed from: f  reason: collision with root package name */
    private Bundle f7876f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Runnable f7877g;
    private a.C0129a h;
    /* access modifiers changed from: private */
    public e i;
    /* access modifiers changed from: private */
    public float j;
    /* access modifiers changed from: private */
    public float k;
    private float l;
    private float m;
    /* access modifiers changed from: private */
    public float[] n;
    /* access modifiers changed from: private */
    public Context o;
    /* access modifiers changed from: private */
    public b p;
    private boolean q = false;
    /* access modifiers changed from: private */
    public int r;
    /* access modifiers changed from: private */
    public int s;
    private int t;
    private int u;
    private float v;
    private float w;
    private float x;
    private float y;
    private boolean z;

    public enum e {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM
    }

    /* access modifiers changed from: private */
    public float a(float f2, float f3, float f4) {
        return f2;
    }

    private Bitmap a(Bitmap bitmap) {
        return bitmap;
    }

    public void setIsAllowingSpacing(boolean z2) {
        this.q = z2;
    }

    public void setZoomMode(a.C0129a aVar) {
        this.h = aVar;
    }

    public CropTouchImageView(Context context) {
        super(context);
        a(context);
    }

    public CropTouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CropTouchImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        super.setClickable(true);
        this.o = context;
        this.H = new ScaleGestureDetector(context, new d(this, (AnonymousClass1) null));
        this.I = new GestureDetector(context, new c(this, (AnonymousClass1) null));
        this.f7874d = new Matrix();
        this.f7875e = new Matrix();
        this.n = new float[9];
        this.f7873c = 1.0f;
        this.j = 1.0f;
        this.k = 6.0f;
        this.l = this.j * 0.5f;
        this.m = this.k * 3.0f;
        this.z = true;
        setImageMatrix(this.f7874d);
        setScaleType(ImageView.ScaleType.MATRIX);
        setState(e.NONE);
        setOnTouchListener(new f(this, (AnonymousClass1) null));
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        f();
        g();
        j();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(a(bitmap));
        f();
        g();
        j();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        f();
        g();
        j();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        f();
        g();
        j();
    }

    public void a() {
        this.f7876f = c();
        super.setImageDrawable((Drawable) null);
    }

    public void b() {
        this.f7876f = null;
    }

    public Bundle getState() {
        return this.f7876f;
    }

    public void a(int i2, int i3, float f2, float f3) {
        this.B = f2;
        this.C = f3;
        if (i3 != 0 && i2 != 0) {
            this.F = i2;
            this.G = i3;
            if (this.r > 0 && this.s > 0) {
                e();
            }
        }
    }

    private void e() {
        int i2 = this.r;
        if (i2 != 0) {
            this.D = (float) i2;
            this.E = Math.min((float) this.s, (this.D * ((float) this.G)) / ((float) this.F));
            new FrameLayout.LayoutParams((int) this.D, (int) this.E);
        }
    }

    private void setupRegionDecoder(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            this.N = BitmapRegionDecoder.newInstance(byteArray, 0, byteArray.length, true);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3) {
        if (this.K || this.J) {
            b(i2, i3);
            super.setImageBitmap(this.N.decodeRegion(this.M, (BitmapFactory.Options) null));
        }
    }

    private void b(int i2, int i3) {
        if (this.K) {
            a(i2);
        } else if (this.J) {
            b(i3);
        }
    }

    private void a(int i2) {
        int i3 = (int) (((float) i2) / this.f7873c);
        int i4 = this.M.top;
        int i5 = this.M.bottom;
        int max = Math.max(this.M.left - i3, 0);
        int min = Math.min(this.M.right - i3, this.L);
        if (max == 0) {
            min = this.M.right - this.M.left;
        } else {
            int i6 = this.L;
            if (min == i6) {
                max = this.M.left + (i6 - this.M.right);
            }
        }
        this.M.set(max, i4, min, i5);
    }

    private void b(int i2) {
        int i3 = (int) (((float) i2) / this.f7873c);
        int max = Math.max(this.M.top - i3, 0);
        int min = Math.min(this.M.bottom - i3, this.L);
        if (max == 0) {
            min = this.M.bottom - this.M.top;
        } else {
            int i4 = this.L;
            if (min == i4) {
                max = this.M.top + (i4 - this.M.bottom);
            }
        }
        this.M.set(this.M.left, max, this.M.right, min);
    }

    private void f() {
        if (!this.z) {
            this.A = true;
        }
    }

    private void g() {
        Matrix matrix = this.f7874d;
        if (matrix != null) {
            matrix.getValues(this.n);
            this.f7875e.setValues(this.n);
            this.y = this.w;
            this.x = this.v;
            this.u = this.s;
            this.t = this.r;
        }
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.f7873c);
        bundle.putFloat("matchViewHeight", this.w);
        bundle.putFloat("matchViewWidth", this.v);
        bundle.putInt("viewWidth", this.r);
        bundle.putInt("viewHeight", this.s);
        this.f7874d.getValues(this.n);
        bundle.putFloatArray("matrix", this.n);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f7873c = bundle.getFloat("saveScale");
            this.n = bundle.getFloatArray("matrix");
            this.f7875e.setValues(this.n);
            this.y = bundle.getFloat("matchViewHeight");
            this.x = bundle.getFloat("matchViewWidth");
            this.u = bundle.getInt("viewHeight");
            this.t = bundle.getInt("viewWidth");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.f7873c);
        bundle.putFloat("matchViewHeight", this.w);
        bundle.putFloat("matchViewWidth", this.v);
        bundle.putInt("viewWidth", this.r);
        bundle.putInt("viewHeight", this.s);
        if (getDrawable() != null) {
            bundle.putInt("drawableWidth", getDrawable().getIntrinsicWidth());
            bundle.putInt("drawableHeight", getDrawable().getIntrinsicHeight());
        }
        this.f7874d.getValues(this.n);
        bundle.putFloatArray("matrix", this.n);
        return bundle;
    }

    public void a(Bundle bundle) {
        this.f7873c = bundle.getFloat("saveScale");
        this.n = bundle.getFloatArray("matrix");
        this.f7874d.setValues(this.n);
        this.w = bundle.getFloat("matchViewHeight");
        this.v = bundle.getFloat("matchViewWidth");
        this.s = bundle.getInt("viewHeight");
        this.r = bundle.getInt("viewWidth");
        setImageMatrix(this.f7874d);
    }

    public float getMaxZoom() {
        return this.k;
    }

    public void setMaxZoom(float f2) {
        this.k = f2;
        this.m = this.k * 3.0f;
    }

    public float getMinZoom() {
        return this.j;
    }

    public float getCurrentZoom() {
        return this.f7873c;
    }

    public void setMinZoom(float f2) {
        this.j = f2;
        this.l = this.j * 0.5f;
    }

    /* access modifiers changed from: private */
    public void h() {
        this.f7874d.getValues(this.n);
        float[] fArr = this.n;
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = 1.0f;
        float f5 = getImageWidth() > getImageHeight() ? this.j : 1.0f;
        if (getImageWidth() < getImageHeight()) {
            f4 = this.j;
        }
        float a2 = a(f2, (float) this.r, getImageWidth(), f5);
        float b2 = b(f3, (float) this.s, getImageHeight(), f4);
        if (a2 != BitmapDescriptorFactory.HUE_RED || b2 != BitmapDescriptorFactory.HUE_RED) {
            this.f7874d.postTranslate(a2, b2);
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        h();
    }

    private float a(float f2, float f3, float f4, float f5) {
        float f6 = this.B;
        float f7 = (this.D + f6) - f4;
        if (this.f7873c < f5) {
            float max = Math.max(BitmapDescriptorFactory.HUE_RED, this.v - getImageWidth()) / 2.0f;
            f7 -= max;
            f6 += max;
        }
        if (f2 < f7) {
            return (-f2) + f7;
        }
        if (f2 > f6) {
            return (-f2) + f6;
        }
        return BitmapDescriptorFactory.HUE_RED;
    }

    private float b(float f2, float f3, float f4, float f5) {
        float f6 = this.C;
        float f7 = (this.E + f6) - f4;
        if (this.f7873c < f5) {
            float max = Math.max(BitmapDescriptorFactory.HUE_RED, this.w - getImageHeight()) / 2.0f;
            f7 -= max;
            f6 += max;
        }
        if (f2 < f7) {
            return (-f2) + f7;
        }
        if (f2 > f6) {
            return (-f2) + f6;
        }
        return BitmapDescriptorFactory.HUE_RED;
    }

    /* access modifiers changed from: private */
    public float getImageWidth() {
        return this.v * this.f7873c;
    }

    /* access modifiers changed from: private */
    public float getImageHeight() {
        return this.w * this.f7873c;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        this.r = a(mode, size, intrinsicWidth);
        this.s = a(mode2, size2, intrinsicHeight);
        e();
        setMeasuredDimension(this.r, this.s);
        j();
    }

    private void j() {
        Bundle bundle = this.f7876f;
        if (bundle != null) {
            a(bundle);
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0 && this.f7874d != null && this.f7875e != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            float f2 = (float) intrinsicWidth;
            float f3 = (float) intrinsicHeight;
            float max = Math.max(this.D / f2, this.E / f3);
            int i2 = this.s;
            float f4 = max * f3;
            int i3 = this.r;
            float f5 = max * f2;
            this.v = ((float) i3) - (((float) i3) - f5);
            this.w = ((float) i2) - (((float) i2) - f4);
            float f6 = (this.C + (this.E / 2.0f)) - (f4 / 2.0f);
            this.f7874d.setScale(max, max);
            this.f7874d.postTranslate((this.B + (this.D / 2.0f)) - (f5 / 2.0f), f6);
            this.f7873c = 1.0f;
            this.A = false;
            setImageMatrix(this.f7874d);
            if (this.q || this.h != a.C0129a.NONE) {
                this.j = intrinsicHeight > intrinsicWidth ? f2 / f3 : f3 / f2;
                if (!this.q && intrinsicHeight > intrinsicWidth) {
                    this.j = Math.max(this.j, f7871a);
                } else if (!this.q && intrinsicWidth > intrinsicHeight) {
                    this.j = Math.max(this.j, f7872b);
                }
            }
            if (AnonymousClass1.f7878a[this.h.ordinal()] == 1) {
                a(this.j, (float) (this.r / 2), (float) (this.s / 2), true);
                setImageMatrix(this.f7874d);
            }
        }
    }

    /* renamed from: com.garena.cropimage.library.CropTouchImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7878a = new int[a.C0129a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.garena.cropimage.library.a$a[] r0 = com.garena.cropimage.library.a.C0129a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7878a = r0
                int[] r0 = f7878a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.garena.cropimage.library.a$a r1 = com.garena.cropimage.library.a.C0129a.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f7878a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.garena.cropimage.library.a$a r1 = com.garena.cropimage.library.a.C0129a.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.garena.cropimage.library.CropTouchImageView.AnonymousClass1.<clinit>():void");
        }
    }

    public void a(a.C0129a aVar) {
        int i2 = AnonymousClass1.f7878a[aVar.ordinal()];
        if (i2 == 1) {
            a((Runnable) new a(this.j, (float) (this.r / 2), (float) (this.s / 2), false));
        } else if (i2 == 2) {
            a((Runnable) new a(1.0f, (float) (this.r / 2), (float) (this.s / 2), false));
        }
    }

    private int a(int i2, int i3, int i4) {
        if (i2 != Integer.MIN_VALUE) {
            return i2 != 0 ? i3 : i4;
        }
        return Math.min(i4, i3);
    }

    /* access modifiers changed from: private */
    public void setState(e eVar) {
        this.i = eVar;
    }

    public boolean canScrollHorizontally(int i2) {
        if (this.K) {
            if (i2 < 0 && this.M.right < this.L) {
                return true;
            }
            if (i2 > 0 && this.M.left > 0) {
                return true;
            }
        }
        this.f7874d.getValues(this.n);
        float f2 = this.n[2];
        if (getImageWidth() <= ((float) this.r)) {
            return false;
        }
        if (f2 >= -1.0f && i2 > 0) {
            return false;
        }
        if (Math.abs(f2) + ((float) this.r) + 1.0f < getImageWidth() || i2 >= 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        float f2 = this.j;
        float f3 = this.f7873c;
        return f2 < f3 + 1.0E-5f && f3 < this.k + 1.0E-5f;
    }

    private class c extends GestureDetector.SimpleOnGestureListener {
        private c() {
        }

        /* synthetic */ c(CropTouchImageView cropTouchImageView, AnonymousClass1 r2) {
            this();
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return CropTouchImageView.this.performClick();
        }

        public void onLongPress(MotionEvent motionEvent) {
            CropTouchImageView.this.performLongClick();
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (CropTouchImageView.this.d()) {
                if (CropTouchImageView.this.p != null) {
                    CropTouchImageView.this.p.a();
                }
                CropTouchImageView cropTouchImageView = CropTouchImageView.this;
                b unused = cropTouchImageView.p = new b((int) f2, (int) f3);
                CropTouchImageView cropTouchImageView2 = CropTouchImageView.this;
                cropTouchImageView2.a((Runnable) cropTouchImageView2.p);
            }
            return super.onFling(motionEvent, motionEvent2, f2, f3);
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (CropTouchImageView.this.i != e.NONE) {
                return false;
            }
            CropTouchImageView.this.a((Runnable) new a(CropTouchImageView.this.f7873c == CropTouchImageView.this.j ? CropTouchImageView.this.k : CropTouchImageView.this.j, motionEvent.getX(), motionEvent.getY(), false));
            return true;
        }
    }

    private class f implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        private PointF f7894b;

        private f() {
            this.f7894b = new PointF();
        }

        /* synthetic */ f(CropTouchImageView cropTouchImageView, AnonymousClass1 r2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0052, code lost:
            if (r8 != 6) goto L_0x00d4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
            /*
                r6 = this;
                android.graphics.PointF r7 = new android.graphics.PointF
                float r0 = r8.getX()
                float r1 = r8.getY()
                r7.<init>(r0, r1)
                com.garena.cropimage.library.CropTouchImageView r0 = com.garena.cropimage.library.CropTouchImageView.this
                android.view.ScaleGestureDetector r0 = r0.H
                r0.onTouchEvent(r8)
                com.garena.cropimage.library.CropTouchImageView r0 = com.garena.cropimage.library.CropTouchImageView.this
                android.view.GestureDetector r0 = r0.I
                r0.onTouchEvent(r8)
                com.garena.cropimage.library.CropTouchImageView r0 = com.garena.cropimage.library.CropTouchImageView.this
                boolean r0 = r0.d()
                r1 = 1
                if (r0 == 0) goto L_0x00d4
                com.garena.cropimage.library.CropTouchImageView r0 = com.garena.cropimage.library.CropTouchImageView.this
                com.garena.cropimage.library.CropTouchImageView$e r0 = r0.i
                com.garena.cropimage.library.CropTouchImageView$e r2 = com.garena.cropimage.library.CropTouchImageView.e.NONE
                if (r0 == r2) goto L_0x0046
                com.garena.cropimage.library.CropTouchImageView r0 = com.garena.cropimage.library.CropTouchImageView.this
                com.garena.cropimage.library.CropTouchImageView$e r0 = r0.i
                com.garena.cropimage.library.CropTouchImageView$e r2 = com.garena.cropimage.library.CropTouchImageView.e.DRAG
                if (r0 == r2) goto L_0x0046
                com.garena.cropimage.library.CropTouchImageView r0 = com.garena.cropimage.library.CropTouchImageView.this
                com.garena.cropimage.library.CropTouchImageView$e r0 = r0.i
                com.garena.cropimage.library.CropTouchImageView$e r2 = com.garena.cropimage.library.CropTouchImageView.e.FLING
                if (r0 != r2) goto L_0x00d4
            L_0x0046:
                int r8 = r8.getAction()
                if (r8 == 0) goto L_0x00b7
                if (r8 == r1) goto L_0x00af
                r0 = 2
                if (r8 == r0) goto L_0x0056
                r7 = 6
                if (r8 == r7) goto L_0x00af
                goto L_0x00d4
            L_0x0056:
                com.garena.cropimage.library.CropTouchImageView r8 = com.garena.cropimage.library.CropTouchImageView.this
                com.garena.cropimage.library.CropTouchImageView$e r8 = r8.i
                com.garena.cropimage.library.CropTouchImageView$e r0 = com.garena.cropimage.library.CropTouchImageView.e.DRAG
                if (r8 != r0) goto L_0x00d4
                float r8 = r7.x
                android.graphics.PointF r0 = r6.f7894b
                float r0 = r0.x
                float r8 = r8 - r0
                float r0 = r7.y
                android.graphics.PointF r2 = r6.f7894b
                float r2 = r2.y
                float r0 = r0 - r2
                com.garena.cropimage.library.CropTouchImageView r2 = com.garena.cropimage.library.CropTouchImageView.this
                int r3 = r2.r
                float r3 = (float) r3
                com.garena.cropimage.library.CropTouchImageView r4 = com.garena.cropimage.library.CropTouchImageView.this
                float r4 = r4.getImageWidth()
                float r2 = r2.a((float) r8, (float) r3, (float) r4)
                com.garena.cropimage.library.CropTouchImageView r3 = com.garena.cropimage.library.CropTouchImageView.this
                int r4 = r3.s
                float r4 = (float) r4
                com.garena.cropimage.library.CropTouchImageView r5 = com.garena.cropimage.library.CropTouchImageView.this
                float r5 = r5.getImageHeight()
                float r3 = r3.a((float) r0, (float) r4, (float) r5)
                com.garena.cropimage.library.CropTouchImageView r4 = com.garena.cropimage.library.CropTouchImageView.this
                android.graphics.Matrix r4 = r4.f7874d
                r4.postTranslate(r2, r3)
                com.garena.cropimage.library.CropTouchImageView r2 = com.garena.cropimage.library.CropTouchImageView.this
                r2.h()
                com.garena.cropimage.library.CropTouchImageView r2 = com.garena.cropimage.library.CropTouchImageView.this
                int r8 = (int) r8
                int r0 = (int) r0
                r2.a((int) r8, (int) r0)
                android.graphics.PointF r8 = r6.f7894b
                float r0 = r7.x
                float r7 = r7.y
                r8.set(r0, r7)
                goto L_0x00d4
            L_0x00af:
                com.garena.cropimage.library.CropTouchImageView r7 = com.garena.cropimage.library.CropTouchImageView.this
                com.garena.cropimage.library.CropTouchImageView$e r8 = com.garena.cropimage.library.CropTouchImageView.e.NONE
                r7.setState(r8)
                goto L_0x00d4
            L_0x00b7:
                android.graphics.PointF r8 = r6.f7894b
                r8.set(r7)
                com.garena.cropimage.library.CropTouchImageView r7 = com.garena.cropimage.library.CropTouchImageView.this
                com.garena.cropimage.library.CropTouchImageView$b r7 = r7.p
                if (r7 == 0) goto L_0x00cd
                com.garena.cropimage.library.CropTouchImageView r7 = com.garena.cropimage.library.CropTouchImageView.this
                com.garena.cropimage.library.CropTouchImageView$b r7 = r7.p
                r7.a()
            L_0x00cd:
                com.garena.cropimage.library.CropTouchImageView r7 = com.garena.cropimage.library.CropTouchImageView.this
                com.garena.cropimage.library.CropTouchImageView$e r8 = com.garena.cropimage.library.CropTouchImageView.e.DRAG
                r7.setState(r8)
            L_0x00d4:
                com.garena.cropimage.library.CropTouchImageView r7 = com.garena.cropimage.library.CropTouchImageView.this
                android.graphics.Matrix r8 = r7.f7874d
                r7.setImageMatrix(r8)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.garena.cropimage.library.CropTouchImageView.f.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    private class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private d() {
        }

        /* synthetic */ d(CropTouchImageView cropTouchImageView, AnonymousClass1 r2) {
            this();
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            CropTouchImageView.this.setState(e.ZOOM);
            return true;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            CropTouchImageView.this.a(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            super.onScaleEnd(scaleGestureDetector);
            CropTouchImageView.this.setState(e.NONE);
            float c2 = CropTouchImageView.this.f7873c;
            boolean z = true;
            if (CropTouchImageView.this.f7873c > CropTouchImageView.this.k) {
                c2 = CropTouchImageView.this.k;
            } else if (CropTouchImageView.this.f7873c < CropTouchImageView.this.j) {
                c2 = CropTouchImageView.this.j;
            } else {
                z = false;
            }
            float f2 = c2;
            if (z) {
                CropTouchImageView cropTouchImageView = CropTouchImageView.this;
                CropTouchImageView.this.a((Runnable) new a(f2, (float) (cropTouchImageView.r / 2), (float) (CropTouchImageView.this.s / 2), true));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(float f2, float f3, float f4, boolean z2) {
        float f5;
        float f6;
        if (z2) {
            f5 = this.l;
            f6 = this.m;
        } else {
            f5 = this.j;
            f6 = this.k;
        }
        float f7 = this.f7873c;
        this.f7873c = f7 * f2;
        float f8 = this.f7873c;
        if (f8 > f6) {
            this.f7873c = f6;
            f2 = f6 / f7;
        } else if (f8 < f5) {
            this.f7873c = f5;
            f2 = f5 / f7;
        }
        this.f7874d.postScale(f2, f2, f3, f4);
        i();
    }

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private long f7880b;

        /* renamed from: c  reason: collision with root package name */
        private float f7881c;

        /* renamed from: d  reason: collision with root package name */
        private float f7882d;

        /* renamed from: e  reason: collision with root package name */
        private float f7883e;

        /* renamed from: f  reason: collision with root package name */
        private float f7884f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f7885g;
        private AccelerateDecelerateInterpolator h = new AccelerateDecelerateInterpolator();
        private PointF i;
        private PointF j;

        a(float f2, float f3, float f4, boolean z) {
            CropTouchImageView.this.setState(e.ANIMATE_ZOOM);
            this.f7880b = System.currentTimeMillis();
            this.f7881c = CropTouchImageView.this.f7873c;
            this.f7882d = f2;
            this.f7885g = z;
            PointF a2 = CropTouchImageView.this.a(f3, f4, false);
            this.f7883e = a2.x;
            this.f7884f = a2.y;
            this.i = CropTouchImageView.this.a(this.f7883e, this.f7884f);
            this.j = new PointF((float) (CropTouchImageView.this.r / 2), (float) (CropTouchImageView.this.s / 2));
        }

        public void run() {
            float a2 = a();
            CropTouchImageView.this.a(b(a2), this.f7883e, this.f7884f, this.f7885g);
            a(a2);
            CropTouchImageView.this.i();
            CropTouchImageView cropTouchImageView = CropTouchImageView.this;
            cropTouchImageView.setImageMatrix(cropTouchImageView.f7874d);
            if (a2 < 1.0f) {
                CropTouchImageView.this.a((Runnable) this);
                return;
            }
            CropTouchImageView.this.setState(e.NONE);
            if (CropTouchImageView.this.f7877g != null) {
                CropTouchImageView.this.post(new Runnable() {
                    public void run() {
                        CropTouchImageView.this.f7877g.run();
                        Runnable unused = CropTouchImageView.this.f7877g = null;
                    }
                });
            }
        }

        private void a(float f2) {
            float f3 = this.i.x + ((this.j.x - this.i.x) * f2);
            float f4 = this.i.y + (f2 * (this.j.y - this.i.y));
            PointF a2 = CropTouchImageView.this.a(this.f7883e, this.f7884f);
            CropTouchImageView.this.f7874d.postTranslate(f3 - a2.x, f4 - a2.y);
        }

        private float a() {
            return this.h.getInterpolation(Math.min(1.0f, ((float) (System.currentTimeMillis() - this.f7880b)) / 300.0f));
        }

        private float b(float f2) {
            float f3 = this.f7881c;
            return (f3 + (f2 * (this.f7882d - f3))) / CropTouchImageView.this.f7873c;
        }
    }

    /* access modifiers changed from: private */
    public PointF a(float f2, float f3, boolean z2) {
        this.f7874d.getValues(this.n);
        float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
        float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
        float[] fArr = this.n;
        float f4 = fArr[2];
        float f5 = fArr[5];
        float imageWidth = ((f2 - f4) * intrinsicWidth) / getImageWidth();
        float imageHeight = ((f3 - f5) * intrinsicHeight) / getImageHeight();
        if (z2) {
            imageWidth = Math.min(Math.max(f2, BitmapDescriptorFactory.HUE_RED), intrinsicWidth);
            imageHeight = Math.min(Math.max(f3, BitmapDescriptorFactory.HUE_RED), intrinsicHeight);
        }
        return new PointF(imageWidth, imageHeight);
    }

    /* access modifiers changed from: private */
    public PointF a(float f2, float f3) {
        this.f7874d.getValues(this.n);
        return new PointF(this.n[2] + (getImageWidth() * (f2 / ((float) getDrawable().getIntrinsicWidth()))), this.n[5] + (getImageHeight() * (f3 / ((float) getDrawable().getIntrinsicHeight()))));
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        Scroller f7887a;

        /* renamed from: b  reason: collision with root package name */
        int f7888b;

        /* renamed from: c  reason: collision with root package name */
        int f7889c;

        b(int i, int i2) {
            CropTouchImageView.this.setState(e.FLING);
            this.f7887a = new Scroller(CropTouchImageView.this.o);
            CropTouchImageView.this.f7874d.getValues(CropTouchImageView.this.n);
            int i3 = (int) CropTouchImageView.this.n[2];
            int i4 = (int) CropTouchImageView.this.n[5];
            int floor = (int) Math.floor((double) CropTouchImageView.this.B);
            int ceil = (int) Math.ceil((double) ((CropTouchImageView.this.B + CropTouchImageView.this.D) - CropTouchImageView.this.getImageWidth()));
            int floor2 = (int) Math.floor((double) CropTouchImageView.this.C);
            this.f7887a.fling(i3, i4, i, i2, ceil, floor, (int) Math.ceil((double) ((CropTouchImageView.this.C + CropTouchImageView.this.E) - CropTouchImageView.this.getImageHeight())), floor2);
            this.f7888b = i3;
            this.f7889c = i4;
        }

        public void a() {
            if (this.f7887a != null) {
                CropTouchImageView.this.setState(e.NONE);
                this.f7887a.forceFinished(true);
            }
        }

        public void run() {
            if (this.f7887a.isFinished()) {
                this.f7887a = null;
            } else if (this.f7887a.computeScrollOffset()) {
                int currX = this.f7887a.getCurrX();
                int currY = this.f7887a.getCurrY();
                int i = currX - this.f7888b;
                int i2 = currY - this.f7889c;
                this.f7888b = currX;
                this.f7889c = currY;
                CropTouchImageView.this.f7874d.postTranslate((float) i, (float) i2);
                CropTouchImageView.this.h();
                CropTouchImageView cropTouchImageView = CropTouchImageView.this;
                cropTouchImageView.setImageMatrix(cropTouchImageView.f7874d);
                CropTouchImageView.this.a((Runnable) this);
            }
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(16)
    public void a(Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimation(runnable);
        } else {
            postDelayed(runnable, 16);
        }
    }
}
