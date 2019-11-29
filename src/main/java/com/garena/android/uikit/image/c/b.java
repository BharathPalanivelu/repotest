package com.garena.android.uikit.image.c;

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
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Scroller;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class b extends ImageView {
    private Rect A = new Rect();
    private BitmapRegionDecoder B;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public float f7776a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Matrix f7777b;

    /* renamed from: c  reason: collision with root package name */
    private Matrix f7778c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public e f7779d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public float f7780e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f7781f;

    /* renamed from: g  reason: collision with root package name */
    private float f7782g;
    private float h;
    /* access modifiers changed from: private */
    public float[] i;
    /* access modifiers changed from: private */
    public Context j;
    /* access modifiers changed from: private */
    public C0128b k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public int m;
    private int n;
    private int o;
    private float p;
    private float q;
    private float r;
    private float s;
    private boolean t;
    private boolean u;
    /* access modifiers changed from: private */
    public ScaleGestureDetector v;
    /* access modifiers changed from: private */
    public GestureDetector w;
    private boolean x;
    private boolean y;
    private int z;

    public enum e {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM
    }

    private float a(float f2, float f3, float f4) {
        float f5;
        float f6;
        if (f4 <= f3) {
            f5 = f3 - f4;
            f6 = BitmapDescriptorFactory.HUE_RED;
        } else {
            f6 = f3 - f4;
            f5 = BitmapDescriptorFactory.HUE_RED;
        }
        return f2 < f6 ? (-f2) + f6 : f2 > f5 ? (-f2) + f5 : BitmapDescriptorFactory.HUE_RED;
    }

    public static boolean a(int i2, int i3) {
        float f2 = (float) i3;
        float f3 = (float) i2;
        return f2 > f3 * 3.5f || f3 > f2 * 3.5f;
    }

    /* access modifiers changed from: private */
    public float b(float f2, float f3, float f4) {
        return f4 <= f3 ? BitmapDescriptorFactory.HUE_RED : f2;
    }

    public void a() {
        a(1.0f / this.f7776a, (float) (this.l / 2), (float) (this.m / 2), true);
        e();
        setImageMatrix(this.f7777b);
    }

    public b(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        super.setClickable(true);
        this.j = context;
        this.v = new ScaleGestureDetector(context, new d());
        this.w = new GestureDetector(context, new c());
        this.f7777b = new Matrix();
        this.f7778c = new Matrix();
        this.i = new float[9];
        this.f7776a = 1.0f;
        this.f7780e = 1.0f;
        this.f7781f = 3.0f;
        this.f7782g = this.f7780e * 0.85f;
        this.h = this.f7781f * 1.25f;
        this.t = true;
        setImageMatrix(this.f7777b);
        setScaleType(ImageView.ScaleType.MATRIX);
        setState(e.NONE);
        setOnTouchListener(new f());
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        b();
        c();
        f();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(a(bitmap));
        b();
        c();
        f();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        b();
        c();
        f();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        b();
        c();
        f();
    }

    private Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        b(bitmap.getWidth(), bitmap.getHeight());
        if (!this.y && !this.x) {
            return bitmap;
        }
        setupRegionDecoder(bitmap);
        return this.B.decodeRegion(this.A, (BitmapFactory.Options) null);
    }

    private void b(int i2, int i3) {
        float f2 = (float) i3;
        float f3 = (float) i2;
        boolean z2 = true;
        this.x = f2 > f3 * 3.5f;
        if (f3 <= f2 * 3.5f) {
            z2 = false;
        }
        this.y = z2;
        if (this.y) {
            this.z = i2;
            Rect rect = this.A;
            double d2 = (double) i3;
            Double.isNaN(d2);
            rect.set(0, 0, (int) (d2 * 1.7d), i3);
        } else if (this.x) {
            this.z = i3;
            Rect rect2 = this.A;
            double d3 = (double) i2;
            Double.isNaN(d3);
            rect2.set(0, 0, i2, (int) (d3 * 1.7d));
        }
    }

    private void setupRegionDecoder(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            this.B = BitmapRegionDecoder.newInstance(byteArray, 0, byteArray.length, true);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void c(int i2, int i3) {
        if (this.y || this.x) {
            d(i2, i3);
            super.setImageBitmap(this.B.decodeRegion(this.A, (BitmapFactory.Options) null));
        }
    }

    private void d(int i2, int i3) {
        if (this.y) {
            a(i2);
        } else if (this.x) {
            b(i3);
        }
    }

    private void a(int i2) {
        int i3 = (int) (((float) i2) / this.f7776a);
        int i4 = this.A.top;
        int i5 = this.A.bottom;
        int max = Math.max(this.A.left - i3, 0);
        int min = Math.min(this.A.right - i3, this.z);
        if (max == 0) {
            min = this.A.right - this.A.left;
        } else {
            int i6 = this.z;
            if (min == i6) {
                max = this.A.left + (i6 - this.A.right);
            }
        }
        this.A.set(max, i4, min, i5);
    }

    private void b(int i2) {
        int i3 = (int) (((float) i2) / this.f7776a);
        int max = Math.max(this.A.top - i3, 0);
        int min = Math.min(this.A.bottom - i3, this.z);
        if (max == 0) {
            min = this.A.bottom - this.A.top;
        } else {
            int i4 = this.z;
            if (min == i4) {
                max = this.A.top + (i4 - this.A.bottom);
            }
        }
        this.A.set(this.A.left, max, this.A.right, min);
    }

    private void b() {
        if (!this.t) {
            this.u = true;
        }
    }

    private void c() {
        Matrix matrix = this.f7777b;
        if (matrix != null) {
            matrix.getValues(this.i);
            this.f7778c.setValues(this.i);
            this.s = this.q;
            this.r = this.p;
            this.o = this.m;
            this.n = this.l;
        }
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.f7776a);
        bundle.putFloat("matchViewHeight", this.q);
        bundle.putFloat("matchViewWidth", this.p);
        bundle.putInt("viewWidth", this.l);
        bundle.putInt("viewHeight", this.m);
        this.f7777b.getValues(this.i);
        bundle.putFloatArray("matrix", this.i);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f7776a = bundle.getFloat("saveScale");
            this.i = bundle.getFloatArray("matrix");
            this.f7778c.setValues(this.i);
            this.s = bundle.getFloat("matchViewHeight");
            this.r = bundle.getFloat("matchViewWidth");
            this.o = bundle.getInt("viewHeight");
            this.n = bundle.getInt("viewWidth");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public float getMaxZoom() {
        return this.f7781f;
    }

    public void setMaxZoom(float f2) {
        this.f7781f = f2;
        this.h = this.f7781f * 1.25f;
    }

    public float getMinZoom() {
        return this.f7780e;
    }

    public float getCurrentZoom() {
        return this.f7776a;
    }

    public void setMinZoom(float f2) {
        this.f7780e = f2;
        this.f7782g = this.f7780e * 0.85f;
    }

    /* access modifiers changed from: private */
    public void d() {
        this.f7777b.getValues(this.i);
        float[] fArr = this.i;
        float f2 = fArr[2];
        float f3 = fArr[5];
        float a2 = a(f2, (float) this.l, getImageWidth());
        float a3 = a(f3, (float) this.m, getImageHeight());
        if (a2 != BitmapDescriptorFactory.HUE_RED || a3 != BitmapDescriptorFactory.HUE_RED) {
            this.f7777b.postTranslate(a2, a3);
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        d();
        this.f7777b.getValues(this.i);
        float imageWidth = getImageWidth();
        int i2 = this.l;
        if (imageWidth < ((float) i2)) {
            this.i[2] = (((float) i2) - getImageWidth()) / 2.0f;
        }
        float imageHeight = getImageHeight();
        int i3 = this.m;
        if (imageHeight < ((float) i3)) {
            this.i[5] = (((float) i3) - getImageHeight()) / 2.0f;
        }
        this.f7777b.setValues(this.i);
    }

    /* access modifiers changed from: private */
    public float getImageWidth() {
        return this.p * this.f7776a;
    }

    /* access modifiers changed from: private */
    public float getImageHeight() {
        return this.q * this.f7776a;
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
        this.l = a(mode, size, intrinsicWidth);
        this.m = a(mode2, size2, intrinsicHeight);
        setMeasuredDimension(this.l, this.m);
        f();
    }

    private void f() {
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0 && this.f7777b != null && this.f7778c != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            float f2 = (float) intrinsicWidth;
            float f3 = (float) intrinsicHeight;
            float min = Math.min(((float) this.l) / f2, ((float) this.m) / f3);
            int i2 = this.m;
            float f4 = ((float) i2) - (min * f3);
            int i3 = this.l;
            float f5 = ((float) i3) - (min * f2);
            this.p = ((float) i3) - f5;
            this.q = ((float) i2) - f4;
            if (this.f7776a == 1.0f || this.u) {
                this.f7777b.setScale(min, min);
                this.f7777b.postTranslate(f5 / 2.0f, f4 / 2.0f);
                this.f7776a = 1.0f;
                this.u = false;
            } else {
                this.f7778c.getValues(this.i);
                float[] fArr = this.i;
                float f6 = this.p / f2;
                float f7 = this.f7776a;
                fArr[0] = f6 * f7;
                fArr[4] = (this.q / f3) * f7;
                float f8 = fArr[2];
                float f9 = fArr[5];
                a(2, f8, this.r * f7, getImageWidth(), this.n, this.l, intrinsicWidth);
                a(5, f9, this.s * this.f7776a, getImageHeight(), this.o, this.m, intrinsicHeight);
                this.f7777b.setValues(this.i);
            }
            setImageMatrix(this.f7777b);
        }
    }

    private int a(int i2, int i3, int i4) {
        if (i2 != Integer.MIN_VALUE) {
            return i2 != 0 ? i3 : i4;
        }
        return Math.min(i4, i3);
    }

    private void a(int i2, float f2, float f3, float f4, int i3, int i4, int i5) {
        float f5 = (float) i4;
        if (f4 < f5) {
            float[] fArr = this.i;
            fArr[i2] = (f5 - (((float) i5) * fArr[0])) * 0.5f;
        } else if (f2 > BitmapDescriptorFactory.HUE_RED) {
            this.i[i2] = -((f4 - f5) * 0.5f);
        } else {
            this.i[i2] = -((((Math.abs(f2) + (((float) i3) * 0.5f)) / f3) * f4) - (f5 * 0.5f));
        }
    }

    /* access modifiers changed from: private */
    public void setState(e eVar) {
        this.f7779d = eVar;
    }

    public boolean canScrollHorizontally(int i2) {
        if (this.y) {
            if (i2 < 0 && this.A.right < this.z) {
                return true;
            }
            if (i2 > 0 && this.A.left > 0) {
                return true;
            }
        }
        this.f7777b.getValues(this.i);
        float f2 = this.i[2];
        if (getImageWidth() <= ((float) this.l)) {
            return false;
        }
        if (f2 >= -1.0f && i2 > 0) {
            return false;
        }
        if (Math.abs(f2) + ((float) this.l) + 1.0f < getImageWidth() || i2 >= 0) {
            return true;
        }
        return false;
    }

    private class c extends GestureDetector.SimpleOnGestureListener {
        private c() {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return b.this.performClick();
        }

        public void onLongPress(MotionEvent motionEvent) {
            b.this.performLongClick();
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (b.this.k != null) {
                b.this.k.a();
            }
            b bVar = b.this;
            C0128b unused = bVar.k = new C0128b((int) f2, (int) f3);
            b bVar2 = b.this;
            bVar2.a((Runnable) bVar2.k);
            return super.onFling(motionEvent, motionEvent2, f2, f3);
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (b.this.f7779d != e.NONE) {
                return false;
            }
            b.this.a((Runnable) new a(b.this.f7776a == b.this.f7780e ? b.this.f7781f : b.this.f7780e, motionEvent.getX(), motionEvent.getY(), false));
            return true;
        }
    }

    private class f implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        private PointF f7797b;

        private f() {
            this.f7797b = new PointF();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
            if (r8 != 6) goto L_0x00cc;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
            /*
                r6 = this;
                com.garena.android.uikit.image.c.b r7 = com.garena.android.uikit.image.c.b.this
                android.view.ScaleGestureDetector r7 = r7.v
                r7.onTouchEvent(r8)
                com.garena.android.uikit.image.c.b r7 = com.garena.android.uikit.image.c.b.this
                android.view.GestureDetector r7 = r7.w
                r7.onTouchEvent(r8)
                android.graphics.PointF r7 = new android.graphics.PointF
                float r0 = r8.getX()
                float r1 = r8.getY()
                r7.<init>(r0, r1)
                com.garena.android.uikit.image.c.b r0 = com.garena.android.uikit.image.c.b.this
                com.garena.android.uikit.image.c.b$e r0 = r0.f7779d
                com.garena.android.uikit.image.c.b$e r1 = com.garena.android.uikit.image.c.b.e.NONE
                r2 = 1
                if (r0 == r1) goto L_0x003e
                com.garena.android.uikit.image.c.b r0 = com.garena.android.uikit.image.c.b.this
                com.garena.android.uikit.image.c.b$e r0 = r0.f7779d
                com.garena.android.uikit.image.c.b$e r1 = com.garena.android.uikit.image.c.b.e.DRAG
                if (r0 == r1) goto L_0x003e
                com.garena.android.uikit.image.c.b r0 = com.garena.android.uikit.image.c.b.this
                com.garena.android.uikit.image.c.b$e r0 = r0.f7779d
                com.garena.android.uikit.image.c.b$e r1 = com.garena.android.uikit.image.c.b.e.FLING
                if (r0 != r1) goto L_0x00cc
            L_0x003e:
                int r8 = r8.getAction()
                if (r8 == 0) goto L_0x00af
                if (r8 == r2) goto L_0x00a7
                r0 = 2
                if (r8 == r0) goto L_0x004e
                r7 = 6
                if (r8 == r7) goto L_0x00a7
                goto L_0x00cc
            L_0x004e:
                com.garena.android.uikit.image.c.b r8 = com.garena.android.uikit.image.c.b.this
                com.garena.android.uikit.image.c.b$e r8 = r8.f7779d
                com.garena.android.uikit.image.c.b$e r0 = com.garena.android.uikit.image.c.b.e.DRAG
                if (r8 != r0) goto L_0x00cc
                float r8 = r7.x
                android.graphics.PointF r0 = r6.f7797b
                float r0 = r0.x
                float r8 = r8 - r0
                float r0 = r7.y
                android.graphics.PointF r1 = r6.f7797b
                float r1 = r1.y
                float r0 = r0 - r1
                com.garena.android.uikit.image.c.b r1 = com.garena.android.uikit.image.c.b.this
                int r3 = r1.l
                float r3 = (float) r3
                com.garena.android.uikit.image.c.b r4 = com.garena.android.uikit.image.c.b.this
                float r4 = r4.getImageWidth()
                float r1 = r1.b(r8, r3, r4)
                com.garena.android.uikit.image.c.b r3 = com.garena.android.uikit.image.c.b.this
                int r4 = r3.m
                float r4 = (float) r4
                com.garena.android.uikit.image.c.b r5 = com.garena.android.uikit.image.c.b.this
                float r5 = r5.getImageHeight()
                float r3 = r3.b(r0, r4, r5)
                com.garena.android.uikit.image.c.b r4 = com.garena.android.uikit.image.c.b.this
                android.graphics.Matrix r4 = r4.f7777b
                r4.postTranslate(r1, r3)
                com.garena.android.uikit.image.c.b r1 = com.garena.android.uikit.image.c.b.this
                r1.d()
                com.garena.android.uikit.image.c.b r1 = com.garena.android.uikit.image.c.b.this
                int r8 = (int) r8
                int r0 = (int) r0
                r1.c(r8, r0)
                android.graphics.PointF r8 = r6.f7797b
                float r0 = r7.x
                float r7 = r7.y
                r8.set(r0, r7)
                goto L_0x00cc
            L_0x00a7:
                com.garena.android.uikit.image.c.b r7 = com.garena.android.uikit.image.c.b.this
                com.garena.android.uikit.image.c.b$e r8 = com.garena.android.uikit.image.c.b.e.NONE
                r7.setState(r8)
                goto L_0x00cc
            L_0x00af:
                android.graphics.PointF r8 = r6.f7797b
                r8.set(r7)
                com.garena.android.uikit.image.c.b r7 = com.garena.android.uikit.image.c.b.this
                com.garena.android.uikit.image.c.b$b r7 = r7.k
                if (r7 == 0) goto L_0x00c5
                com.garena.android.uikit.image.c.b r7 = com.garena.android.uikit.image.c.b.this
                com.garena.android.uikit.image.c.b$b r7 = r7.k
                r7.a()
            L_0x00c5:
                com.garena.android.uikit.image.c.b r7 = com.garena.android.uikit.image.c.b.this
                com.garena.android.uikit.image.c.b$e r8 = com.garena.android.uikit.image.c.b.e.DRAG
                r7.setState(r8)
            L_0x00cc:
                com.garena.android.uikit.image.c.b r7 = com.garena.android.uikit.image.c.b.this
                android.graphics.Matrix r8 = r7.f7777b
                r7.setImageMatrix(r8)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.garena.android.uikit.image.c.b.f.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    private class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private d() {
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            b.this.setState(e.ZOOM);
            return true;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            b.this.a(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            super.onScaleEnd(scaleGestureDetector);
            b.this.setState(e.NONE);
            float c2 = b.this.f7776a;
            boolean z = true;
            if (b.this.f7776a > b.this.f7781f) {
                c2 = b.this.f7781f;
            } else if (b.this.f7776a < b.this.f7780e) {
                c2 = b.this.f7780e;
            } else {
                z = false;
            }
            float f2 = c2;
            if (z) {
                b bVar = b.this;
                b.this.a((Runnable) new a(f2, (float) (bVar.l / 2), (float) (b.this.m / 2), true));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(float f2, float f3, float f4, boolean z2) {
        float f5;
        float f6;
        if (z2) {
            f5 = this.f7782g;
            f6 = this.h;
        } else {
            f5 = this.f7780e;
            f6 = this.f7781f;
        }
        float f7 = this.f7776a;
        this.f7776a = f7 * f2;
        float f8 = this.f7776a;
        if (f8 > f6) {
            this.f7776a = f6;
            f2 = f6 / f7;
        } else if (f8 < f5) {
            this.f7776a = f5;
            f2 = f5 / f7;
        }
        this.f7777b.postScale(f2, f2, f3, f4);
        e();
    }

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private long f7784b;

        /* renamed from: c  reason: collision with root package name */
        private float f7785c;

        /* renamed from: d  reason: collision with root package name */
        private float f7786d;

        /* renamed from: e  reason: collision with root package name */
        private float f7787e;

        /* renamed from: f  reason: collision with root package name */
        private float f7788f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f7789g;
        private AccelerateDecelerateInterpolator h = new AccelerateDecelerateInterpolator();
        private PointF i;
        private PointF j;

        a(float f2, float f3, float f4, boolean z) {
            b.this.setState(e.ANIMATE_ZOOM);
            this.f7784b = System.currentTimeMillis();
            this.f7785c = b.this.f7776a;
            this.f7786d = f2;
            this.f7789g = z;
            PointF a2 = b.this.a(f3, f4, false);
            this.f7787e = a2.x;
            this.f7788f = a2.y;
            this.i = b.this.a(this.f7787e, this.f7788f);
            this.j = new PointF((float) (b.this.l / 2), (float) (b.this.m / 2));
        }

        public void run() {
            float a2 = a();
            b.this.a(b(a2), this.f7787e, this.f7788f, this.f7789g);
            a(a2);
            b.this.e();
            b bVar = b.this;
            bVar.setImageMatrix(bVar.f7777b);
            if (a2 < 1.0f) {
                b.this.a((Runnable) this);
            } else {
                b.this.setState(e.NONE);
            }
        }

        private void a(float f2) {
            float f3 = this.i.x + ((this.j.x - this.i.x) * f2);
            float f4 = this.i.y + (f2 * (this.j.y - this.i.y));
            PointF a2 = b.this.a(this.f7787e, this.f7788f);
            b.this.f7777b.postTranslate(f3 - a2.x, f4 - a2.y);
        }

        private float a() {
            return this.h.getInterpolation(Math.min(1.0f, ((float) (System.currentTimeMillis() - this.f7784b)) / 200.0f));
        }

        private float b(float f2) {
            float f3 = this.f7785c;
            return (f3 + (f2 * (this.f7786d - f3))) / b.this.f7776a;
        }
    }

    /* access modifiers changed from: private */
    public PointF a(float f2, float f3, boolean z2) {
        this.f7777b.getValues(this.i);
        float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
        float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
        float[] fArr = this.i;
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
        this.f7777b.getValues(this.i);
        return new PointF(this.i[2] + (getImageWidth() * (f2 / ((float) getDrawable().getIntrinsicWidth()))), this.i[5] + (getImageHeight() * (f3 / ((float) getDrawable().getIntrinsicHeight()))));
    }

    /* renamed from: com.garena.android.uikit.image.c.b$b  reason: collision with other inner class name */
    private class C0128b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        Scroller f7790a;

        /* renamed from: b  reason: collision with root package name */
        int f7791b;

        /* renamed from: c  reason: collision with root package name */
        int f7792c;

        C0128b(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            b.this.setState(e.FLING);
            this.f7790a = new Scroller(b.this.j);
            b.this.f7777b.getValues(b.this.i);
            int i7 = (int) b.this.i[2];
            int i8 = (int) b.this.i[5];
            if (b.this.getImageWidth() > ((float) b.this.l)) {
                i4 = b.this.l - ((int) b.this.getImageWidth());
                i3 = 0;
            } else {
                i4 = i7;
                i3 = i4;
            }
            if (b.this.getImageHeight() > ((float) b.this.m)) {
                i6 = b.this.m - ((int) b.this.getImageHeight());
                i5 = 0;
            } else {
                i6 = i8;
                i5 = i6;
            }
            this.f7790a.fling(i7, i8, i, i2, i4, i3, i6, i5);
            this.f7791b = i7;
            this.f7792c = i8;
        }

        public void a() {
            if (this.f7790a != null) {
                b.this.setState(e.NONE);
                this.f7790a.forceFinished(true);
            }
        }

        public void run() {
            if (this.f7790a.isFinished()) {
                this.f7790a = null;
            } else if (this.f7790a.computeScrollOffset()) {
                int currX = this.f7790a.getCurrX();
                int currY = this.f7790a.getCurrY();
                int i = currX - this.f7791b;
                int i2 = currY - this.f7792c;
                this.f7791b = currX;
                this.f7792c = currY;
                b.this.f7777b.postTranslate((float) i, (float) i2);
                b.this.d();
                b bVar = b.this;
                bVar.setImageMatrix(bVar.f7777b);
                b.this.a((Runnable) this);
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
