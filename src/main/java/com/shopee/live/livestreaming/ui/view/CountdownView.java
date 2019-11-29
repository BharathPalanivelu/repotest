package com.shopee.live.livestreaming.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import cn.tongdun.android.shell.settings.Constants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class CountdownView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f29128a;

    /* renamed from: b  reason: collision with root package name */
    private int f29129b;

    /* renamed from: c  reason: collision with root package name */
    private int f29130c;

    /* renamed from: d  reason: collision with root package name */
    private int f29131d;

    /* renamed from: e  reason: collision with root package name */
    private int f29132e;

    /* renamed from: f  reason: collision with root package name */
    private float f29133f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f29134g;
    private CharSequence h;
    private float i;
    private float j;
    private float k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public int m;
    /* access modifiers changed from: private */
    public int n;
    private int o;
    private int p;
    private Paint q;
    private TextPaint r;
    private Rect s;
    private RectF t;
    private Handler u;
    /* access modifiers changed from: private */
    public a v;

    public interface a {
        void a();
    }

    static /* synthetic */ int b(CountdownView countdownView) {
        int i2 = countdownView.o;
        countdownView.o = i2 + 1;
        return i2;
    }

    public CountdownView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CountdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29134g = 0;
        a(context, attributeSet);
    }

    public CountdownView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29134g = 0;
        a(context, attributeSet);
    }

    /* JADX INFO: finally extract failed */
    public void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, c.i.CountdownView, 0, 0);
        try {
            int parseColor = Color.parseColor("grey");
            this.h = obtainStyledAttributes.getText(c.i.CountdownView_view_text);
            this.f29131d = obtainStyledAttributes.getColor(c.i.CountdownView_view_text_color, -16777216);
            this.i = obtainStyledAttributes.getDimension(c.i.CountdownView_view_text_start_size, 15.0f);
            this.j = obtainStyledAttributes.getDimension(c.i.CountdownView_view_text_end_size, 15.0f);
            this.m = obtainStyledAttributes.getInteger(c.i.CountdownView_update_time, 1000);
            this.l = obtainStyledAttributes.getInteger(c.i.CountdownView_total_time, 1000);
            this.f29132e = obtainStyledAttributes.getColor(c.i.CountdownView_progress_color, -65536);
            this.f29133f = obtainStyledAttributes.getDimension(c.i.CountdownView_progress_width, BitmapDescriptorFactory.HUE_RED);
            this.f29128a = obtainStyledAttributes.getColor(c.i.CountdownView_progress_hint_color, parseColor);
            this.f29129b = obtainStyledAttributes.getColor(c.i.CountdownView_bg_color, -1);
            this.k = this.i;
            obtainStyledAttributes.recycle();
            this.q = new Paint(1);
            this.r = new TextPaint(1);
            this.s = new Rect();
            this.t = new RectF();
            this.u = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (message.what == 10) {
                        CountdownView.b(CountdownView.this);
                        CountdownView countdownView = CountdownView.this;
                        int unused = countdownView.f29134g = countdownView.f29134g + (100 / CountdownView.this.n);
                        CountdownView countdownView2 = CountdownView.this;
                        int unused2 = countdownView2.l = countdownView2.l - CountdownView.this.m;
                        CountdownView countdownView3 = CountdownView.this;
                        countdownView3.a(countdownView3.l);
                        CountdownView.this.postInvalidate();
                        if (CountdownView.this.f29134g < 100) {
                            sendEmptyMessageDelayed(10, (long) CountdownView.this.m);
                        } else if (CountdownView.this.v != null) {
                            CountdownView.this.v.a();
                        }
                    }
                }
            };
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            this.f29130c = 100;
        } else {
            this.f29130c = Math.min(measuredWidth, measuredHeight) / 2;
        }
        int i4 = this.f29130c;
        setMeasuredDimension(i4 * 2, i4 * 2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getDrawingRect(this.s);
        int centerX = this.s.centerX();
        int centerY = this.s.centerY();
        this.q.setStyle(Paint.Style.FILL);
        this.q.setColor(this.f29129b);
        float f2 = (float) centerX;
        float f3 = (float) centerY;
        canvas.drawCircle(f2, f3, (float) this.f29130c, this.q);
        if (this.f29133f > BitmapDescriptorFactory.HUE_RED) {
            this.q.setStyle(Paint.Style.STROKE);
            this.q.setStrokeWidth(this.f29133f);
            this.q.setColor(this.f29128a);
            canvas.drawCircle(f2, f3, ((float) this.f29130c) - this.f29133f, this.q);
        }
        this.r.setTextSize(this.k);
        this.r.setColor(this.f29131d);
        this.r.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(this.h.toString(), f2, f3 - ((this.r.descent() + this.r.ascent()) / 2.0f), this.r);
        float f4 = this.f29133f;
        if (f4 > BitmapDescriptorFactory.HUE_RED) {
            this.q.setStrokeWidth(f4);
            this.q.setColor(this.f29132e);
            this.q.setStrokeCap(Paint.Cap.ROUND);
            this.t.set(((float) this.s.left) + this.f29133f, ((float) this.s.top) + this.f29133f, ((float) this.s.right) - this.f29133f, ((float) this.s.bottom) - this.f29133f);
            canvas.drawArc(this.t, -90.0f, (float) (this.o * this.p), false, this.q);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        String valueOf = String.valueOf((i2 / 1000) + 1);
        if (!valueOf.equals(this.h)) {
            this.k = this.i;
        } else {
            float f2 = this.j;
            this.k = f2 + ((this.i - f2) * a(i2 % 1000, 1000));
        }
        this.h = valueOf;
    }

    private float a(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return Float.valueOf(decimalFormat.format((double) (((float) i2) / ((float) i3)))).floatValue();
    }

    public void setText(String str) {
        this.h = str;
    }

    public void a() {
        this.l = Constants.DEFAULT_WAIT_TIME;
    }

    public void setTotalTime(int i2) {
        this.l = i2;
    }

    public void setUpdateTime(int i2) {
        this.m = i2;
    }

    public int getTotalTime() {
        return this.l;
    }

    public void setProgressColor(int i2) {
        this.f29132e = i2;
    }

    public void setCircleBackgroundColor(int i2) {
        this.f29129b = i2;
    }

    public void setTextColor(int i2) {
        this.f29131d = i2;
    }

    public void b() {
        int i2 = this.l;
        int i3 = this.m;
        this.n = i2 / i3;
        this.p = 360 / this.n;
        this.u.sendEmptyMessageDelayed(10, (long) i3);
    }

    public void setOnFinishAction(a aVar) {
        this.v = aVar;
    }

    public void c() {
        Handler handler = this.u;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }
}
