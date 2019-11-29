package com.shopee.feeds.feedlibrary.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.util.l;

public class StarRatingBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f28707a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f28708b;

    /* renamed from: c  reason: collision with root package name */
    private int f28709c;

    /* renamed from: d  reason: collision with root package name */
    private int f28710d;

    /* renamed from: e  reason: collision with root package name */
    private int f28711e;

    /* renamed from: f  reason: collision with root package name */
    private float f28712f;

    /* renamed from: g  reason: collision with root package name */
    private int f28713g;
    private int h;
    private float i;
    private boolean j;
    private Paint k;

    public StarRatingBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public StarRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.i.StarRatingBar);
        this.f28707a = obtainStyledAttributes.getDrawable(c.i.StarRatingBar_defaultStar);
        this.f28708b = obtainStyledAttributes.getDrawable(c.i.StarRatingBar_star);
        this.f28709c = obtainStyledAttributes.getColor(c.i.StarRatingBar_defaultStarColor, Color.parseColor("#FCAD23"));
        this.f28710d = obtainStyledAttributes.getColor(c.i.StarRatingBar_starColor, Color.parseColor("#FCAD23"));
        this.f28711e = obtainStyledAttributes.getInteger(c.i.StarRatingBar_starNum, 5);
        this.f28712f = obtainStyledAttributes.getFloat(c.i.StarRatingBar_starStep, 1.0f);
        this.f28713g = obtainStyledAttributes.getDimensionPixelOffset(c.i.StarRatingBar_starGap, l.a(3, getContext()));
        this.h = obtainStyledAttributes.getDimensionPixelOffset(c.i.StarRatingBar_starSize, l.a(12, getContext()));
        this.i = obtainStyledAttributes.getFloat(c.i.StarRatingBar_rating, 1.5f);
        this.j = obtainStyledAttributes.getBoolean(c.i.StarRatingBar_isIndicator, true);
        obtainStyledAttributes.recycle();
        this.k = new Paint();
        this.k.setAntiAlias(true);
    }

    public void setRatings(int i2) {
        this.i = (float) i2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i2 = this.h / 2;
        float f2 = (float) i2;
        canvas.translate(f2, f2);
        if (this.f28707a != null) {
            a(canvas, this.f28707a, this.f28711e);
        } else {
            this.k.setColor(this.f28709c);
            int i3 = 0;
            for (int i4 = 0; i4 < this.f28711e; i4++) {
                a(canvas, this.k, (this.h * i4) + i3, i2);
                i3 += this.f28713g;
            }
        }
        int round = Math.round(this.i);
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float f4 = (float) round;
        if (f4 > this.i) {
            f3 = ((float) ((int) (((this.i - f4) + 1.0f) / this.f28712f))) * this.f28712f;
        }
        int i5 = -i2;
        canvas.clipRect(i5, i5, (int) ((((float) (((int) this.i) * (this.h + this.f28713g))) + (f3 * ((float) this.h))) - f2), this.h - i2);
        if (this.f28708b != null) {
            a(canvas, this.f28708b, round);
        } else {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(this.f28710d);
            int i6 = 0;
            for (int i7 = 0; i7 < round; i7++) {
                a(canvas, paint, (this.h * i7) + i6, i2);
                i6 += this.f28713g;
            }
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i2) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        int i3 = this.h / 2;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = this.h;
            i4++;
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(((i4 * i6) - i3) + i5, -i3, ((i4 * i6) - i3) + i5, i6 - i3), this.k);
            i5 += this.f28713g;
        }
    }

    private void a(Canvas canvas, Paint paint, int i2, int i3) {
        Point[] pointArr = new Point[5];
        for (int i4 = 0; i4 < 5; i4++) {
            pointArr[i4] = new Point();
            Point point = pointArr[i4];
            double d2 = (double) i3;
            double d3 = (double) ((i4 * 72) - 18);
            double cos = Math.cos(Math.toRadians(d3));
            Double.isNaN(d2);
            point.x = ((int) (cos * d2)) + i2;
            Point point2 = pointArr[i4];
            double sin = Math.sin(Math.toRadians(d3));
            Double.isNaN(d2);
            point2.y = (int) (d2 * sin);
        }
        Path path = new Path();
        path.moveTo((float) pointArr[0].x, (float) pointArr[0].y);
        int i5 = 2;
        while (i5 != 5) {
            if (i5 >= 5) {
                i5 %= 5;
            }
            path.lineTo((float) pointArr[i5].x, (float) pointArr[i5].y);
            i5 += 2;
        }
        path.close();
        canvas.drawPath(path, paint);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.j) {
            return super.onTouchEvent(motionEvent);
        }
        this.i = motionEvent.getX() / ((float) (this.h + this.f28713g));
        invalidate();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            size = getPaddingLeft() + getPaddingRight();
            int i4 = this.f28711e;
            if (i4 > 0) {
                size += (this.h * i4) + ((i4 - 1) * this.f28713g);
            }
        } else if (mode == 0) {
            size = getSuggestedMinimumWidth();
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = getPaddingTop() + getPaddingBottom() + this.h;
        } else if (mode2 == 0) {
            size2 = getSuggestedMinimumHeight();
        }
        setMeasuredDimension(size, size2);
    }
}
