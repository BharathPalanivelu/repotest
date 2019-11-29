package com.garena.cropimage.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.appsflyer.share.Constants;
import com.garena.cropimage.library.a;
import com.garena.cropimage.library.d;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class CropImageView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static float f7845a = 1.0E-6f;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f7846b;

    /* renamed from: c  reason: collision with root package name */
    private c f7847c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public f f7848d;

    /* renamed from: e  reason: collision with root package name */
    private a f7849e;

    /* renamed from: f  reason: collision with root package name */
    private b f7850f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f7851g;
    private FrameLayout h;
    /* access modifiers changed from: private */
    public CropFrame i;
    /* access modifiers changed from: private */
    public CropTouchImageView j;
    /* access modifiers changed from: private */
    public a k;
    private ViewTreeObserver.OnGlobalLayoutListener l = null;

    public interface a {
        Bitmap a(int i, int i2);

        boolean a();

        Bitmap b();
    }

    public interface c {
        void a(g gVar);
    }

    public interface f {
        void a();

        void a(Bitmap bitmap);
    }

    public enum g {
        SUCCESS,
        FILE_INPUT_NOT_FOUND,
        OUTPUT_DIRECTORY_NOT_EXISTS,
        EXEPTION,
        CANNOT_LOAD_IMAGE
    }

    public CropImageView(Context context) {
        super(context);
        c();
        d();
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        a(context, attributeSet, 0, 0);
        d();
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
        a(context, attributeSet, i2, 0);
        d();
    }

    private void c() {
        addView(inflate(getContext(), d.b.crop_image_layout, (ViewGroup) null));
        this.j = (CropTouchImageView) findViewById(d.a.origin_image);
        this.i = (CropFrame) findViewById(d.a.crop_frame);
        this.f7851g = (FrameLayout) findViewById(d.a.top_frame);
        this.h = (FrameLayout) findViewById(d.a.bottom_frame);
        this.k = new a();
        this.f7846b = false;
    }

    public void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.c.CropView, i2, i3);
        try {
            this.k.a(obtainStyledAttributes.getString(d.c.CropView_garena_cropimage_src));
            this.k.b(obtainStyledAttributes.getString(d.c.CropView_garena_cropimage_outputPath));
            this.k.a(obtainStyledAttributes.getInt(d.c.CropView_garena_cropimage_maxSizeWidth, 0), obtainStyledAttributes.getInt(d.c.CropView_garena_cropimage_maxSizeHeight, 0));
            this.k.a(obtainStyledAttributes.getInt(d.c.CropView_garena_cropimage_ratioWidth, 1), obtainStyledAttributes.getInt(d.c.CropView_garena_cropimage_ratioHeight, 1), obtainStyledAttributes.getInt(d.c.CropView_garena_cropimage_topLeftY, -1));
            this.k.a(obtainStyledAttributes.getColor(d.c.CropView_garena_cropimage_frameColor, 0));
            this.k.a(obtainStyledAttributes.getBoolean(d.c.CropView_garena_cropimage_isSetExplicitOutputSize, false));
            this.k.c(obtainStyledAttributes.getInt(d.c.CropView_garena_cropimage_compressValue, 100));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void d() {
        this.j.setZoomMode(this.k.g() != null ? this.k.g() : a.C0129a.NONE);
        e();
        if (this.k.j() > 0 && this.k.k() > 0) {
            if (this.k.l() == -1) {
                a(this.k.j(), this.k.k());
            } else {
                a(this.k.j(), this.k.k(), this.k.l());
            }
        }
        setFrameColor(this.k.f());
        if (this.k.d()) {
            this.j.setBackgroundColor(this.k.e());
            this.j.setIsAllowingSpacing(true);
        }
    }

    public void setImageLoadCallback(f fVar) {
        this.f7848d = fVar;
    }

    public void setParams(a aVar) {
        this.k = aVar;
        d();
    }

    public a getParams() {
        return this.k;
    }

    private void e() {
        if (this.f7849e != null) {
            b bVar = this.f7850f;
            if (bVar != null) {
                bVar.cancel(false);
            }
            this.f7850f = new b(this.f7849e, new f() {
                public void a(Bitmap bitmap) {
                    CropImageView.this.j.setImageBitmap(bitmap);
                    if (CropImageView.this.f7848d != null) {
                        CropImageView.this.f7848d.a(bitmap);
                    }
                }

                public void a() {
                    if (CropImageView.this.f7848d != null) {
                        CropImageView.this.f7848d.a();
                    }
                }
            });
            this.f7850f.execute(new Integer[0]);
        }
    }

    public void setBitmapLoader(a aVar) {
        this.f7849e = aVar;
        e();
    }

    private void setFrameColor(int i2) {
        this.f7851g.setBackgroundColor(i2);
        this.h.setBackgroundColor(i2);
    }

    private void a(int i2, int i3, int i4) {
        this.i.a(i2, i3);
        this.f7851g.setLayoutParams(new RelativeLayout.LayoutParams(-1, i4));
        this.j.a(i2, i3, (float) BitmapDescriptorFactory.HUE_RED, (float) i4);
    }

    private void a(int i2, int i3) {
        this.i.a(i2, i3);
        if (this.l == null) {
            this.l = new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (CropImageView.this.getMeasuredHeight() != 0 && !CropImageView.this.f7846b) {
                        int measuredHeight = (CropImageView.this.getMeasuredHeight() - CropImageView.this.i.getMeasuredHeight()) / 2;
                        CropImageView.this.f7851g.setLayoutParams(new RelativeLayout.LayoutParams(-1, measuredHeight));
                        CropImageView.this.j.a(CropImageView.this.k.j(), CropImageView.this.k.k(), (float) BitmapDescriptorFactory.HUE_RED, (float) measuredHeight);
                        boolean unused = CropImageView.this.f7846b = true;
                    }
                }
            };
            getViewTreeObserver().addOnGlobalLayoutListener(this.l);
        }
    }

    public void setCropImageCallback(c cVar) {
        this.f7847c = cVar;
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (view == this && this.f7846b) {
            if (i2 == 0) {
                e();
            } else {
                this.j.a();
            }
        }
    }

    public int[] a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public void a() {
        e eVar = new e();
        eVar.f7864a = this.i.getWidth();
        eVar.f7865b = this.i.getHeight();
        eVar.f7866c = this.j.getDrawable().getIntrinsicHeight();
        eVar.f7867d = this.j.getDrawable().getIntrinsicWidth();
        eVar.h = this.j.getImageMatrix();
        eVar.f7868e = a((View) this.i);
        eVar.f7869f = a((View) this.j);
        eVar.f7870g = this.f7847c;
        new d(getContext(), this.k, eVar).execute(new Void[0]);
    }

    public void b() {
        Bundle state = this.j.getState();
        if (state != null) {
            e eVar = new e();
            eVar.f7864a = this.i.getWidth();
            eVar.f7865b = this.i.getHeight();
            eVar.f7866c = state.getInt("drawableHeight");
            eVar.f7867d = state.getInt("drawableWidth");
            eVar.h = new Matrix();
            eVar.h.setValues(state.getFloatArray("matrix"));
            eVar.f7868e = a((View) this.i);
            eVar.f7869f = a((View) this.j);
            eVar.f7870g = this.f7847c;
            new d(getContext(), this.k, eVar).execute(new Void[0]);
            return;
        }
        a();
    }

    public CropTouchImageView getImageView() {
        return this.j;
    }

    public CropFrame getCropFrame() {
        return this.i;
    }

    private static class d extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private Context f7857a;

        /* renamed from: b  reason: collision with root package name */
        private g f7858b;

        /* renamed from: c  reason: collision with root package name */
        private float f7859c;

        /* renamed from: d  reason: collision with root package name */
        private float f7860d;

        /* renamed from: e  reason: collision with root package name */
        private float f7861e;

        /* renamed from: f  reason: collision with root package name */
        private a f7862f;

        /* renamed from: g  reason: collision with root package name */
        private e f7863g;

        public d(Context context, a aVar, e eVar) {
            this.f7862f = aVar;
            this.f7857a = context;
            this.f7863g = eVar;
        }

        public String a(String str) {
            if (str != null && str.length() > 0) {
                int lastIndexOf = str.lastIndexOf(Constants.URL_PATH_DELIMITER);
                if (lastIndexOf != -1) {
                    return str.substring(0, lastIndexOf);
                }
            }
            return "";
        }

        private int a(int i, int i2, boolean z) {
            if (i == 0) {
                return i2;
            }
            return z ? i : Math.min(i, i2);
        }

        private int a(int i, int i2, int i3, int i4) {
            float max = Math.max(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
            int i5 = 1;
            while (((float) i5) < max - CropImageView.f7845a) {
                i5 *= 2;
            }
            return i5;
        }

        public Bitmap a(Bitmap bitmap, int i, int i2) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float min = Math.min(((float) i) / ((float) width), ((float) i2) / ((float) height));
            if (Math.abs(min - 1.0f) < CropImageView.f7845a) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(min, min);
            matrix.postRotate(90.0f);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x01f3 A[Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0212 A[Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x021b A[Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0227 A[Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Void... r19) {
            /*
                r18 = this;
                r0 = r18
                com.garena.cropimage.library.a r1 = r0.f7862f
                java.lang.String r1 = r1.a()
                int r1 = com.garena.cropimage.library.b.a((java.lang.String) r1)
                int r1 = com.garena.cropimage.library.b.a((int) r1)
                int r2 = r1 + 360
                com.garena.cropimage.library.a r3 = r0.f7862f
                int r3 = r3.p()
                int r2 = r2 + r3
                int r2 = r2 % 360
                android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options
                r3.<init>()
                r4 = 1
                r3.inJustDecodeBounds = r4
                com.garena.cropimage.library.a r5 = r0.f7862f
                java.lang.String r5 = r5.a()
                android.graphics.BitmapFactory.decodeFile(r5, r3)
                com.garena.cropimage.library.a r5 = r0.f7862f
                int r6 = r3.outWidth
                int r3 = r3.outHeight
                r5.c(r6, r3)
                com.garena.cropimage.library.a r3 = r0.f7862f
                java.lang.String r3 = r3.b()
                com.garena.cropimage.library.a r5 = r0.f7862f
                java.lang.String r5 = r5.a()
                java.lang.String r6 = r0.a((java.lang.String) r3)
                com.garena.cropimage.library.a r7 = r0.f7862f
                java.lang.String r7 = r7.b()
                if (r7 == 0) goto L_0x0058
                java.io.File r7 = new java.io.File
                r7.<init>(r6)
                boolean r6 = r7.isDirectory()
                if (r6 != 0) goto L_0x005c
            L_0x0058:
                com.garena.cropimage.library.CropImageView$g r6 = com.garena.cropimage.library.CropImageView.g.OUTPUT_DIRECTORY_NOT_EXISTS
                r0.f7858b = r6
            L_0x005c:
                if (r5 == 0) goto L_0x0069
                java.io.File r6 = new java.io.File
                r6.<init>(r5)
                boolean r6 = r6.exists()
                if (r6 != 0) goto L_0x006d
            L_0x0069:
                com.garena.cropimage.library.CropImageView$g r6 = com.garena.cropimage.library.CropImageView.g.FILE_INPUT_NOT_FOUND
                r0.f7858b = r6
            L_0x006d:
                com.garena.cropimage.library.CropImageView$g r6 = r0.f7858b
                com.garena.cropimage.library.CropImageView$g r7 = com.garena.cropimage.library.CropImageView.g.SUCCESS
                r8 = 0
                if (r6 == r7) goto L_0x0075
                return r8
            L_0x0075:
                com.garena.cropimage.library.a r6 = r0.f7862f
                int r6 = r6.h()
                com.garena.cropimage.library.a r7 = r0.f7862f
                int r7 = r7.m()
                com.garena.cropimage.library.a r9 = r0.f7862f
                boolean r9 = r9.o()
                int r6 = r0.a((int) r6, (int) r7, (boolean) r9)
                com.garena.cropimage.library.a r7 = r0.f7862f
                int r7 = r7.i()
                com.garena.cropimage.library.a r9 = r0.f7862f
                int r9 = r9.n()
                com.garena.cropimage.library.a r10 = r0.f7862f
                boolean r10 = r10.o()
                int r7 = r0.a((int) r7, (int) r9, (boolean) r10)
                com.garena.cropimage.library.a r9 = r0.f7862f     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r9 = r9.m()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                com.garena.cropimage.library.a r10 = r0.f7862f     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r10 = r10.n()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.PointF r11 = new android.graphics.PointF     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r11.<init>()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                com.garena.cropimage.library.CropImageView$e r12 = r0.f7863g     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int[] r12 = r12.f7868e     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r13 = 0
                r12 = r12[r13]     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                com.garena.cropimage.library.CropImageView$e r14 = r0.f7863g     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int[] r14 = r14.f7869f     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r14 = r14[r13]     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r12 = r12 - r14
                float r12 = (float) r12     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r14 = r0.f7860d     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r12 = r12 - r14
                r11.x = r12     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                com.garena.cropimage.library.CropImageView$e r12 = r0.f7863g     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int[] r12 = r12.f7868e     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r12 = r12[r4]     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                com.garena.cropimage.library.CropImageView$e r14 = r0.f7863g     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int[] r14 = r14.f7869f     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r4 = r14[r4]     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r12 = r12 - r4
                float r4 = (float) r12     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r12 = r0.f7861e     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r4 = r4 - r12
                r11.y = r4     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                com.garena.cropimage.library.CropImageView$e r4 = r0.f7863g     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r4 = r4.f7864a     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r4 = (float) r4     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                com.garena.cropimage.library.CropImageView$e r12 = r0.f7863g     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r12 = r12.f7865b     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r12 = (float) r12     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                com.garena.cropimage.library.CropImageView$e r14 = r0.f7863g     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r14 = r14.f7866c     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r14 = (float) r14     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                com.garena.cropimage.library.CropImageView$e r15 = r0.f7863g     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r15 = r15.f7867d     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r15 = (float) r15     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r16 = r15
                r15 = r4
                r4 = 0
            L_0x00f1:
                int r8 = 360 - r2
                if (r4 >= r8) goto L_0x0118
                android.graphics.PointF r8 = new android.graphics.PointF     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r13 = r0.f7859c     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r13 = r13 * r14
                float r13 = r13 - r12
                r17 = r2
                float r2 = r11.y     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r13 = r13 - r2
                float r2 = r11.x     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r11 = 0
                float r2 = r2 + r11
                r8.<init>(r13, r2)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r2 = r12 + r11
                float r11 = r11 + r14
                int r4 = r4 + 90
                r12 = r15
                r14 = r16
                r13 = 0
                r15 = r2
                r16 = r11
                r2 = r17
                r11 = r8
                goto L_0x00f1
            L_0x0118:
                float r2 = r0.f7859c     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r4 = (float) r10     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r14 = r14 / r4
                float r2 = r2 * r14
                r0.f7859c = r2     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r2 = r11.x     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r4 = r0.f7859c     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r2 = r2 / r4
                r11.x = r2     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r2 = r11.y     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r4 = r0.f7859c     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r2 = r2 / r4
                r11.y = r2     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r2 = r0.f7859c     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r15 = r15 / r2
                float r2 = r0.f7859c     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r12 = r12 / r2
                float r2 = r11.x     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r2 = java.lang.Math.round(r2)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r4 = 0
                int r2 = java.lang.Math.max(r4, r2)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r2 = java.lang.Math.min(r9, r2)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r8 = r11.y     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r8 = java.lang.Math.round(r8)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r8 = java.lang.Math.max(r4, r8)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r4 = java.lang.Math.min(r10, r8)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r8 = r9 - r2
                int r11 = java.lang.Math.round(r15)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r8 = java.lang.Math.min(r8, r11)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r11 = r10 - r4
                int r12 = java.lang.Math.round(r12)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r11 = java.lang.Math.min(r11, r12)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Rect r12 = new android.graphics.Rect     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r13 = r2 + r8
                int r14 = r4 + r11
                r12.<init>(r2, r4, r13, r14)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r2 = 90
                if (r1 == r2) goto L_0x01aa
                r2 = 270(0x10e, float:3.78E-43)
                if (r1 != r2) goto L_0x0177
                goto L_0x01aa
            L_0x0177:
                com.garena.cropimage.library.a r2 = r0.f7862f     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                boolean r2 = r2.r()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                if (r2 == 0) goto L_0x0190
                android.graphics.Rect r2 = new android.graphics.Rect     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r4 = r12.right     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r4 = r9 - r4
                int r13 = r12.top     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r14 = r12.left     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r9 = r9 - r14
                int r12 = r12.bottom     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r2.<init>(r4, r13, r9, r12)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                goto L_0x0191
            L_0x0190:
                r2 = r12
            L_0x0191:
                com.garena.cropimage.library.a r4 = r0.f7862f     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                boolean r4 = r4.q()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                if (r4 == 0) goto L_0x01dd
                android.graphics.Rect r4 = new android.graphics.Rect     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r9 = r2.left     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r12 = r2.bottom     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r12 = r10 - r12
                int r13 = r2.right     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r2 = r2.top     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r10 = r10 - r2
                r4.<init>(r9, r12, r13, r10)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                goto L_0x01dc
            L_0x01aa:
                com.garena.cropimage.library.a r2 = r0.f7862f     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                boolean r2 = r2.r()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                if (r2 == 0) goto L_0x01c3
                android.graphics.Rect r2 = new android.graphics.Rect     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r4 = r12.left     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r13 = r12.bottom     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r13 = r10 - r13
                int r14 = r12.right     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r12 = r12.top     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r10 = r10 - r12
                r2.<init>(r4, r13, r14, r10)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                goto L_0x01c4
            L_0x01c3:
                r2 = r12
            L_0x01c4:
                com.garena.cropimage.library.a r4 = r0.f7862f     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                boolean r4 = r4.q()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                if (r4 == 0) goto L_0x01dd
                android.graphics.Rect r4 = new android.graphics.Rect     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r10 = r2.right     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r10 = r9 - r10
                int r12 = r2.top     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r13 = r2.left     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r9 = r9 - r13
                int r2 = r2.bottom     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r4.<init>(r10, r12, r9, r2)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
            L_0x01dc:
                r2 = r4
            L_0x01dd:
                android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r4.<init>()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r8 = r0.a(r6, r7, r8, r11)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r4.inSampleSize = r8     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r8 = 0
                android.graphics.BitmapRegionDecoder r5 = android.graphics.BitmapRegionDecoder.newInstance(r5, r8)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Bitmap r2 = r5.decodeRegion(r2, r4)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                if (r1 == 0) goto L_0x0212
                android.graphics.Matrix r14 = new android.graphics.Matrix     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r14.<init>()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                float r1 = (float) r1     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r14.postRotate(r1)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r10 = 0
                r11 = 0
                int r12 = r2.getWidth()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r13 = r2.getHeight()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r15 = 1
                r9 = r2
                android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                if (r1 == r2) goto L_0x0213
                r2.recycle()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                goto L_0x0213
            L_0x0212:
                r1 = r2
            L_0x0213:
                com.garena.cropimage.library.a r2 = r0.f7862f     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                boolean r2 = r2.o()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                if (r2 == 0) goto L_0x021f
                android.graphics.Bitmap r1 = r0.a((android.graphics.Bitmap) r1, (int) r6, (int) r7)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
            L_0x021f:
                com.garena.cropimage.library.a r2 = r0.f7862f     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                boolean r2 = r2.d()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                if (r2 == 0) goto L_0x0308
                int r2 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r4 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r5 = -1
                if (r2 <= r4) goto L_0x0298
                int r2 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r4 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r2, r4, r6)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Canvas r4 = new android.graphics.Canvas     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r4.<init>(r2)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r6 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r7 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r6 = r6 - r7
                android.graphics.Rect r7 = new android.graphics.Rect     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r8 = r6 / 2
                int r9 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r10 = 0
                r7.<init>(r10, r10, r8, r9)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Rect r8 = new android.graphics.Rect     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r9 = r6 / 2
                int r10 = r6 / 2
                int r11 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r10 = r10 + r11
                int r11 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r12 = 0
                r8.<init>(r9, r12, r10, r11)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Rect r9 = new android.graphics.Rect     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r6 = r6 / 2
                int r10 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r6 = r6 + r10
                int r10 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r11 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r12 = 0
                r9.<init>(r6, r12, r10, r11)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Paint r6 = new android.graphics.Paint     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r6.<init>()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r6.setColor(r5)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r4.drawRect(r7, r6)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r5 = 0
                r4.drawBitmap(r1, r5, r8, r5)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r4.drawRect(r9, r6)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r1.recycle()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                goto L_0x0309
            L_0x0298:
                int r2 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r4 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                if (r2 >= r4) goto L_0x0308
                int r2 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r4 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r2, r4, r6)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Canvas r4 = new android.graphics.Canvas     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r4.<init>(r2)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r6 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r7 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r6 = r6 - r7
                android.graphics.Rect r7 = new android.graphics.Rect     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r8 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r9 = r6 / 2
                r10 = 0
                r7.<init>(r10, r10, r8, r9)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Rect r8 = new android.graphics.Rect     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r9 = r6 / 2
                int r10 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r11 = r6 / 2
                int r12 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r11 = r11 + r12
                r12 = 0
                r8.<init>(r12, r9, r10, r11)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Rect r9 = new android.graphics.Rect     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r6 = r6 / 2
                int r10 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r6 = r6 + r10
                int r10 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                int r11 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r12 = 0
                r9.<init>(r12, r6, r10, r11)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Paint r6 = new android.graphics.Paint     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r6.<init>()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r6.setColor(r5)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r4.drawRect(r7, r6)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r5 = 0
                r4.drawBitmap(r1, r5, r8, r5)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r4.drawRect(r9, r6)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r1.recycle()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                goto L_0x0309
            L_0x0308:
                r2 = r1
            L_0x0309:
                java.io.File r1 = new java.io.File     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r1.<init>(r3)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r3.<init>(r1)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r4 = 100
                r2.compress(r1, r4, r3)     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                r3.close()     // Catch:{ OutOfMemoryError -> 0x0323, Exception -> 0x031e }
                goto L_0x0327
            L_0x031e:
                com.garena.cropimage.library.CropImageView$g r1 = com.garena.cropimage.library.CropImageView.g.EXEPTION
                r0.f7858b = r1
                goto L_0x0327
            L_0x0323:
                com.garena.cropimage.library.CropImageView$g r1 = com.garena.cropimage.library.CropImageView.g.CANNOT_LOAD_IMAGE
                r0.f7858b = r1
            L_0x0327:
                r1 = 0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.garena.cropimage.library.CropImageView.d.doInBackground(java.lang.Void[]):java.lang.Void");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            if (this.f7863g.f7870g != null) {
                this.f7863g.f7870g.a(this.f7858b);
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.f7858b = g.SUCCESS;
            float[] fArr = new float[9];
            this.f7863g.h.getValues(fArr);
            this.f7859c = fArr[0];
            this.f7860d = fArr[2];
            this.f7861e = fArr[5];
        }
    }

    private static class e {

        /* renamed from: a  reason: collision with root package name */
        int f7864a;

        /* renamed from: b  reason: collision with root package name */
        int f7865b;

        /* renamed from: c  reason: collision with root package name */
        int f7866c;

        /* renamed from: d  reason: collision with root package name */
        int f7867d;

        /* renamed from: e  reason: collision with root package name */
        int[] f7868e;

        /* renamed from: f  reason: collision with root package name */
        int[] f7869f;

        /* renamed from: g  reason: collision with root package name */
        c f7870g;
        Matrix h;

        private e() {
        }
    }

    public class b extends AsyncTask<Integer, Void, Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        private final a f7855b;

        /* renamed from: c  reason: collision with root package name */
        private final f f7856c;

        public b(a aVar, f fVar) {
            this.f7855b = aVar;
            this.f7856c = fVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bitmap doInBackground(Integer... numArr) {
            if (!isCancelled() && !this.f7855b.a()) {
                try {
                    if (numArr.length < 2) {
                        return this.f7855b.b();
                    }
                    return this.f7855b.a(numArr[0].intValue(), numArr[1].intValue());
                } catch (OutOfMemoryError unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            if (!this.f7855b.a()) {
                f fVar = this.f7856c;
                if (fVar == null) {
                    return;
                }
                if (bitmap == null) {
                    fVar.a();
                } else {
                    fVar.a(bitmap);
                }
            }
        }
    }
}
