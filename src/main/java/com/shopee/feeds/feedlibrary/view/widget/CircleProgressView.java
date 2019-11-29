package com.shopee.feeds.feedlibrary.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.feeds.feedlibrary.util.l;

public class CircleProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final String f28700a = "CircleProgressView";

    /* renamed from: b  reason: collision with root package name */
    private int f28701b = 100;

    /* renamed from: c  reason: collision with root package name */
    private int f28702c = 5;

    /* renamed from: d  reason: collision with root package name */
    private final int f28703d = 3;

    /* renamed from: e  reason: collision with root package name */
    private int f28704e = 3;

    /* renamed from: f  reason: collision with root package name */
    private RectF f28705f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f28706g;
    private Context h;

    public CircleProgressView(Context context) {
        super(context);
        this.h = context;
        this.f28704e = l.a(3, context);
        this.f28705f = new RectF();
        this.f28706g = new Paint();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = context;
        this.f28704e = l.a(3, context);
        this.f28705f = new RectF();
        this.f28706g = new Paint();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (width != height) {
            width = Math.min(width, height);
            height = width;
        }
        this.f28706g.setAntiAlias(true);
        this.f28706g.setColor(Color.parseColor("#73868686"));
        this.f28706g.setStrokeWidth((float) this.f28704e);
        this.f28706g.setStyle(Paint.Style.STROKE);
        RectF rectF = this.f28705f;
        int i = this.f28704e;
        rectF.left = (float) (i / 2);
        rectF.top = (float) (i / 2);
        rectF.right = (float) (width - (i / 2));
        rectF.bottom = (float) (height - (i / 2));
        canvas.drawArc(rectF, -90.0f, 360.0f, false, this.f28706g);
        this.f28706g.setColor(-1);
        canvas.drawArc(this.f28705f, -90.0f, (((float) this.f28702c) / ((float) this.f28701b)) * 360.0f, false, this.f28706g);
    }

    public void setProgressNotInUiThread(int i) {
        this.f28702c = i;
        postInvalidate();
    }

    public void setProgress(int i) {
        this.f28702c = i;
        invalidate();
    }
}
