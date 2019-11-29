package com.shopee.live.livestreaming.ui.view.d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

public class a extends ReplacementSpan {

    /* renamed from: a  reason: collision with root package name */
    private int f29308a;

    /* renamed from: b  reason: collision with root package name */
    private int f29309b;

    /* renamed from: c  reason: collision with root package name */
    private int f29310c;

    /* renamed from: d  reason: collision with root package name */
    private int f29311d;

    /* renamed from: e  reason: collision with root package name */
    private int f29312e;

    public a(int i, int i2, int i3, int i4) {
        this.f29309b = i;
        this.f29310c = i3;
        this.f29311d = i2;
        this.f29312e = i4;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        this.f29308a = (int) (paint.measureText(charSequence, i, i2) + ((float) (this.f29310c * 2)));
        return this.f29308a;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        float f3 = f2;
        Paint paint2 = paint;
        paint2.setColor(this.f29309b);
        paint2.setAntiAlias(true);
        float descent = ((float) this.f29312e) - (paint.descent() - paint.ascent());
        float f4 = (float) i4;
        RectF rectF = new RectF(f2, ((paint.ascent() + f4) - descent) + 2.0f, ((float) this.f29308a) + f3, (paint.descent() + f4) - 2.0f);
        int i6 = this.f29310c;
        Canvas canvas2 = canvas;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint2);
        paint2.setColor(this.f29311d);
        canvas.drawText(charSequence, i, i2, f3 + ((float) this.f29310c), f4 - (descent / 2.0f), paint2);
    }
}
