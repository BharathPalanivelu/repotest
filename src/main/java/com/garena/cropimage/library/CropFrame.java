package com.garena.cropimage.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class CropFrame extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f7841a = 1;

    /* renamed from: b  reason: collision with root package name */
    private int f7842b = 1;

    /* renamed from: c  reason: collision with root package name */
    private Paint f7843c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7844d = false;

    public CropFrame(Context context) {
        super(context);
        a(context);
    }

    public CropFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CropFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.f7843c = new Paint();
        this.f7843c.setColor(-1);
        setWillNotDraw(false);
    }

    public void a(int i, int i2) {
        this.f7841a = i;
        this.f7842b = i2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), (this.f7842b * size) / this.f7841a), 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f7844d) {
            int measuredWidth = getMeasuredWidth() / 3;
            int measuredHeight = getMeasuredHeight() / 3;
            float f2 = (float) measuredHeight;
            canvas.drawLine(BitmapDescriptorFactory.HUE_RED, f2, (float) getMeasuredWidth(), f2, this.f7843c);
            float f3 = (float) (measuredHeight * 2);
            canvas.drawLine(BitmapDescriptorFactory.HUE_RED, f3, (float) getMeasuredWidth(), f3, this.f7843c);
            float f4 = (float) measuredWidth;
            Canvas canvas2 = canvas;
            canvas2.drawLine(f4, BitmapDescriptorFactory.HUE_RED, f4, (float) getMeasuredHeight(), this.f7843c);
            float f5 = (float) (measuredWidth * 2);
            canvas2.drawLine(f5, BitmapDescriptorFactory.HUE_RED, f5, (float) getMeasuredHeight(), this.f7843c);
        }
    }

    public void a(boolean z) {
        this.f7844d = z;
    }
}
