package com.garena.imageeditor.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class ImageMaskView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private RadialGradient f8120a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f8121b;

    /* renamed from: c  reason: collision with root package name */
    private Matrix f8122c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public c f8123d = c.NONE;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ScaleGestureDetector f8124e;

    /* renamed from: f  reason: collision with root package name */
    private float f8125f;

    /* renamed from: g  reason: collision with root package name */
    private int f8126g;
    private int h;
    private Paint i;
    private Paint j;

    private enum c {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM
    }

    public ImageMaskView(Context context) {
        super(context);
        a();
    }

    public ImageMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ImageMaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        setWillNotDraw(false);
        setLayerType(2, (Paint) null);
        this.j = new Paint();
        this.j.setAntiAlias(true);
        this.j.setFilterBitmap(false);
        this.j.setDither(true);
        this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f8120a = new RadialGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, new int[]{-16777216, -16777216, 0}, new float[]{BitmapDescriptorFactory.HUE_RED, 0.7f, 1.0f}, Shader.TileMode.CLAMP);
        this.j.setShader(this.f8120a);
        this.f8122c = new Matrix();
        this.f8120a.setLocalMatrix(this.f8122c);
        this.i = new Paint();
        this.i.setAntiAlias(true);
        this.i.setFilterBitmap(false);
        this.i.setDither(true);
        this.i.setColor(Color.parseColor("#ccffffff"));
        this.f8121b = new Rect();
        setOnTouchListener(new a());
        this.f8124e = new ScaleGestureDetector(getContext(), new b());
        this.f8126g = 140;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.h = (getWidth() * 3) / 4;
        if (this.f8121b.isEmpty() && this.f8125f != BitmapDescriptorFactory.HUE_RED) {
            canvas.getClipBounds(this.f8121b);
            this.f8122c.reset();
            this.f8122c.postTranslate((float) this.f8121b.centerX(), (float) this.f8121b.centerY());
            this.f8122c.postScale((float) (this.f8121b.width() / 4), (float) (this.f8121b.width() / 4), (float) this.f8121b.centerX(), (float) this.f8121b.centerY());
        }
        this.f8120a.setLocalMatrix(this.f8122c);
        this.j.setShader(this.f8120a);
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) canvas.getWidth(), (float) canvas.getHeight(), this.i);
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) canvas.getWidth(), (float) canvas.getHeight(), this.j);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f8125f != BitmapDescriptorFactory.HUE_RED) {
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            float f2 = (float) size;
            float f3 = this.f8125f;
            float f4 = (float) size2;
            if (f2 / f3 < f4) {
                size2 = Math.round(f2 / f3);
            } else {
                size = Math.round(f4 * f3);
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setRatio(float f2) {
        this.f8125f = f2;
    }

    public float getSelectionRadius() {
        float[] fArr = new float[9];
        this.f8122c.getValues(fArr);
        return fArr[0] / ((float) getWidth());
    }

    public PointF getSelectionCenter() {
        float[] fArr = new float[9];
        this.f8122c.getValues(fArr);
        return new PointF(fArr[2] / ((float) getWidth()), fArr[5] / ((float) getHeight()));
    }

    public float getRatio() {
        return this.f8125f;
    }

    private class a implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        private PointF f8128b;

        private a() {
            this.f8128b = new PointF();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
            if (r5 != 6) goto L_0x007f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
            /*
                r3 = this;
                com.garena.imageeditor.view.ImageMaskView r4 = com.garena.imageeditor.view.ImageMaskView.this
                android.view.ScaleGestureDetector r4 = r4.f8124e
                r4.onTouchEvent(r5)
                android.graphics.PointF r4 = new android.graphics.PointF
                float r0 = r5.getX()
                float r1 = r5.getY()
                r4.<init>(r0, r1)
                com.garena.imageeditor.view.ImageMaskView r0 = com.garena.imageeditor.view.ImageMaskView.this
                com.garena.imageeditor.view.ImageMaskView$c r0 = r0.f8123d
                com.garena.imageeditor.view.ImageMaskView$c r1 = com.garena.imageeditor.view.ImageMaskView.c.NONE
                r2 = 1
                if (r0 == r1) goto L_0x0035
                com.garena.imageeditor.view.ImageMaskView r0 = com.garena.imageeditor.view.ImageMaskView.this
                com.garena.imageeditor.view.ImageMaskView$c r0 = r0.f8123d
                com.garena.imageeditor.view.ImageMaskView$c r1 = com.garena.imageeditor.view.ImageMaskView.c.DRAG
                if (r0 == r1) goto L_0x0035
                com.garena.imageeditor.view.ImageMaskView r0 = com.garena.imageeditor.view.ImageMaskView.this
                com.garena.imageeditor.view.ImageMaskView$c r0 = r0.f8123d
                com.garena.imageeditor.view.ImageMaskView$c r1 = com.garena.imageeditor.view.ImageMaskView.c.FLING
                if (r0 != r1) goto L_0x007f
            L_0x0035:
                int r5 = r5.getAction()
                if (r5 == 0) goto L_0x0073
                if (r5 == r2) goto L_0x006b
                r0 = 2
                if (r5 == r0) goto L_0x0044
                r4 = 6
                if (r5 == r4) goto L_0x006b
                goto L_0x007f
            L_0x0044:
                com.garena.imageeditor.view.ImageMaskView r5 = com.garena.imageeditor.view.ImageMaskView.this
                com.garena.imageeditor.view.ImageMaskView$c r5 = r5.f8123d
                com.garena.imageeditor.view.ImageMaskView$c r0 = com.garena.imageeditor.view.ImageMaskView.c.DRAG
                if (r5 != r0) goto L_0x007f
                float r5 = r4.x
                android.graphics.PointF r0 = r3.f8128b
                float r0 = r0.x
                float r5 = r5 - r0
                float r0 = r4.y
                android.graphics.PointF r1 = r3.f8128b
                float r1 = r1.y
                float r0 = r0 - r1
                com.garena.imageeditor.view.ImageMaskView r1 = com.garena.imageeditor.view.ImageMaskView.this
                r1.a((float) r5, (float) r0)
                android.graphics.PointF r5 = r3.f8128b
                float r0 = r4.x
                float r4 = r4.y
                r5.set(r0, r4)
                goto L_0x007f
            L_0x006b:
                com.garena.imageeditor.view.ImageMaskView r4 = com.garena.imageeditor.view.ImageMaskView.this
                com.garena.imageeditor.view.ImageMaskView$c r5 = com.garena.imageeditor.view.ImageMaskView.c.NONE
                r4.setState(r5)
                goto L_0x007f
            L_0x0073:
                android.graphics.PointF r5 = r3.f8128b
                r5.set(r4)
                com.garena.imageeditor.view.ImageMaskView r4 = com.garena.imageeditor.view.ImageMaskView.this
                com.garena.imageeditor.view.ImageMaskView$c r5 = com.garena.imageeditor.view.ImageMaskView.c.DRAG
                r4.setState(r5)
            L_0x007f:
                com.garena.imageeditor.view.ImageMaskView r4 = com.garena.imageeditor.view.ImageMaskView.this
                r4.invalidate()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.garena.imageeditor.view.ImageMaskView.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* access modifiers changed from: private */
    public void a(float f2, float f3) {
        float[] fArr = new float[9];
        this.f8122c.getValues(fArr);
        float f4 = fArr[0] / 2.0f;
        float f5 = -f4;
        if (new RectF(f5, f5, ((float) getWidth()) + f4, ((float) getHeight()) + f4).contains(fArr[2] + f2, fArr[5] + f3)) {
            this.f8122c.postTranslate(f2, f3);
        }
    }

    /* access modifiers changed from: private */
    public void a(float f2, float f3, float f4) {
        float[] fArr = new float[9];
        this.f8122c.getValues(fArr);
        float f5 = fArr[0] * f2;
        if (((float) this.f8126g) <= f5 && f5 <= ((float) this.h)) {
            this.f8122c.postScale(f2, f2, f3, f4);
        }
    }

    private class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private b() {
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            ImageMaskView.this.setState(c.DRAG);
            return true;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            ImageMaskView.this.a(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            super.onScaleEnd(scaleGestureDetector);
        }
    }

    /* access modifiers changed from: private */
    public void setState(c cVar) {
        this.f8123d = cVar;
    }
}
