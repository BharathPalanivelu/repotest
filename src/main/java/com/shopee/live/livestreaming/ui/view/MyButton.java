package com.shopee.live.livestreaming.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.g.i;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;

public class MyButton extends View {
    private int A;
    private int B;
    private boolean C;
    private int D;
    private ViewConfiguration E;
    private View.OnLongClickListener F;
    private int G;
    private int H;
    private Handler I;
    /* access modifiers changed from: private */
    public boolean J;

    /* renamed from: a  reason: collision with root package name */
    int f29157a;

    /* renamed from: b  reason: collision with root package name */
    private int f29158b;

    /* renamed from: c  reason: collision with root package name */
    private String f29159c;

    /* renamed from: d  reason: collision with root package name */
    private int f29160d;

    /* renamed from: e  reason: collision with root package name */
    private int f29161e;

    /* renamed from: f  reason: collision with root package name */
    private int f29162f;

    /* renamed from: g  reason: collision with root package name */
    private int f29163g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private String n;
    private int o;
    private int p;
    private Paint q;
    private TextPaint r;
    private RectF s;
    private RectF t;
    private int u;
    private int v;
    private Rect w;
    private Rect x;
    private View.OnClickListener y;
    private int z;

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.F = onLongClickListener;
        setLongClickable(true);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.y = onClickListener;
        setClickable(true);
    }

    public void setTextSize(int i2) {
        this.o = (int) (((float) i2) * getResources().getDisplayMetrics().scaledDensity);
        requestLayout();
    }

    public MyButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public MyButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = 1;
        this.w = new Rect();
        this.x = new Rect();
        this.z = 16;
        this.A = 16;
        this.B = 800;
        this.I = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    MyButton myButton = MyButton.this;
                    boolean unused = myButton.J = myButton.b();
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.i.MyButton);
        this.f29158b = obtainStyledAttributes.getColor(c.i.MyButton_mybutton_second_text_color, 0);
        this.f29159c = obtainStyledAttributes.getString(c.i.MyButton_mybutton_second_text);
        this.f29160d = obtainStyledAttributes.getDimensionPixelOffset(c.i.MyButton_mybutton_second_text_size, 12);
        this.f29161e = obtainStyledAttributes.getColor(c.i.MyButton_disabledTextColor, 0);
        this.f29162f = obtainStyledAttributes.getColor(c.i.MyButton_disabledBackgroundColor, 0);
        this.f29163g = obtainStyledAttributes.getDimensionPixelOffset(c.i.MyButton_radius, 0);
        this.j = obtainStyledAttributes.getColor(c.i.MyButton_layersColor, 0);
        this.k = obtainStyledAttributes.getColor(c.i.MyButton_disableLayersColor, 0);
        this.l = obtainStyledAttributes.getColor(c.i.MyButton_normalTextColor, 0);
        this.i = obtainStyledAttributes.getColor(c.i.MyButton_mybutton_border_color, 0);
        this.m = obtainStyledAttributes.getColor(c.i.MyButton_normalBackgroundColor, 0);
        this.n = obtainStyledAttributes.getString(c.i.MyButton_btn_text);
        if (this.n == null) {
            this.n = "";
        }
        this.o = obtainStyledAttributes.getDimensionPixelOffset(c.i.MyButton_textSize, 16);
        setEnabled(obtainStyledAttributes.getBoolean(c.i.MyButton_isEnabled, true));
        this.z = obtainStyledAttributes.getDimensionPixelOffset(c.i.MyButton_hor_padding, 32);
        this.A = obtainStyledAttributes.getDimensionPixelOffset(c.i.MyButton_ver_padding, 16);
        this.h = obtainStyledAttributes.getDimensionPixelOffset(c.i.MyButton_mybutton_border_width, 0);
        obtainStyledAttributes.recycle();
        this.s = new RectF();
        this.t = new RectF();
        this.q = new Paint();
        this.q.setAntiAlias(true);
        this.q.setDither(true);
        this.r = new TextPaint();
        this.r.setDither(true);
        this.r.setAntiAlias(true);
        this.E = ViewConfiguration.get(context);
        this.D = this.E.getScaledTouchSlop();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int a2 = i.a(motionEvent);
        if (a2 == 0) {
            this.J = false;
            this.C = false;
            if (isLongClickable()) {
                this.I.sendEmptyMessageDelayed(0, (long) this.B);
            }
            c();
        } else if (a2 == 1) {
            this.I.removeCallbacksAndMessages((Object) null);
            if (!this.J) {
                a();
            }
            this.J = false;
            d();
        } else if (a2 != 2) {
            if (a2 == 3 || a2 == 4) {
                d();
                this.J = false;
                this.C = false;
            }
        } else if (this.C) {
            int rawY = (int) motionEvent.getRawY();
            int rawX = (int) motionEvent.getRawX();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (rawX < iArr[0] || rawX > iArr[0] + getWidth() || rawY < iArr[1] || rawY > iArr[1] + getHeight()) {
                d();
            } else {
                c();
            }
        } else {
            if (Math.abs(x2 - this.G) > this.D || Math.abs(y2 - this.H) > this.D) {
                this.C = true;
                this.I.removeCallbacksAndMessages((Object) null);
            }
            return true;
        }
        this.G = x2;
        this.H = y2;
        return true;
    }

    private void a() {
        if (isClickable()) {
            View.OnClickListener onClickListener = this.y;
            if (onClickListener != null && this.p == 0) {
                onClickListener.onClick(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean b() {
        View.OnLongClickListener onLongClickListener = this.F;
        return onLongClickListener != null && this.p == 0 && onLongClickListener.onLongClick(this);
    }

    private void c() {
        if (this.p != 0) {
            this.p = 0;
            invalidate();
        }
    }

    private void d() {
        if (this.p != 1) {
            this.p = 1;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        this.r.setTextSize((float) this.o);
        TextPaint textPaint = this.r;
        String str = this.n;
        textPaint.getTextBounds(str, 0, str.length(), this.w);
        if (!TextUtils.isEmpty(this.f29159c)) {
            this.r.setTextSize((float) this.f29160d);
            TextPaint textPaint2 = this.r;
            String str2 = this.f29159c;
            textPaint2.getTextBounds(str2, 0, str2.length(), this.x);
        }
        if (1073741824 != mode) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.max(this.w.width() + this.z, this.x.width()), 1073741824);
        }
        if (1073741824 != mode2) {
            i3 = View.MeasureSpec.makeMeasureSpec((int) (((float) (this.w.height() + this.x.height())) + (((float) this.A) * getResources().getDisplayMetrics().density)), 1073741824);
        } else {
            if (this.w.height() + this.x.height() > View.MeasureSpec.getSize(i3)) {
                i3 = View.MeasureSpec.makeMeasureSpec((int) (((float) (this.w.height() + this.x.height())) + TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics())), 1073741824);
            }
        }
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.s.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) getWidth(), (float) getHeight());
        if (this.f29163g > getWidth() / 2 || this.f29163g > getHeight() / 2) {
            this.f29163g = Math.min(getWidth() / 2, getHeight() / 2);
        }
        if (!isEnabled()) {
            this.v = this.f29162f;
            this.u = this.f29161e;
        } else {
            int i2 = this.p;
            if (i2 == 0 || i2 == 1) {
                this.v = this.m;
                this.u = this.l;
            }
        }
        this.q.setColor(this.v);
        RectF rectF = this.s;
        int i3 = this.f29163g;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, this.q);
        int i4 = this.h;
        if (i4 != 0) {
            this.t.set((float) (i4 / 2), (float) (i4 / 2), (float) (getWidth() - (this.h / 2)), (float) (getHeight() - (this.h / 2)));
            this.q.setStyle(Paint.Style.STROKE);
            this.q.setStrokeWidth((float) this.h);
            this.q.setStrokeJoin(Paint.Join.ROUND);
            this.q.setColor(this.i);
            RectF rectF2 = this.t;
            int i5 = this.f29163g;
            canvas.drawRoundRect(rectF2, (float) i5, (float) i5, this.q);
            this.q.setStyle(Paint.Style.FILL);
        }
        if (TextUtils.isEmpty(this.f29159c)) {
            this.r.setColor(this.u);
            this.r.setTextSize((float) this.o);
            Paint.FontMetrics fontMetrics = this.r.getFontMetrics();
            this.f29157a = (int) this.r.measureText(this.n);
            canvas.drawText(this.n, (float) ((getWidth() - this.f29157a) >> 1), (float) (((int) ((((float) getHeight()) - fontMetrics.ascent) - fontMetrics.descent)) >> 1), this.r);
        } else {
            this.r.setColor(this.u);
            this.r.setTextSize((float) this.o);
            Paint.FontMetrics fontMetrics2 = this.r.getFontMetrics();
            this.r.setColor(this.f29158b);
            this.r.setTextSize((float) this.f29160d);
            Paint.FontMetrics fontMetrics3 = this.r.getFontMetrics();
            int height = ((int) ((((float) getHeight()) - (fontMetrics2.bottom - fontMetrics2.top)) - (fontMetrics3.bottom - fontMetrics3.top))) >> 1;
            this.r.setColor(this.u);
            this.r.setTextSize((float) this.o);
            this.f29157a = (int) this.r.measureText(this.n);
            canvas.drawText(this.n, (float) ((getWidth() - this.f29157a) >> 1), ((float) height) - fontMetrics2.top, this.r);
            this.r.setColor(this.f29158b);
            this.r.setTextSize((float) this.f29160d);
            this.f29157a = (int) this.r.measureText(this.f29159c);
            canvas.drawText(this.f29159c, (float) ((getWidth() - this.f29157a) >> 1), ((float) (getHeight() - height)) - fontMetrics3.bottom, this.r);
        }
        if (this.p == 0) {
            this.q.setColor(this.j);
            RectF rectF3 = this.s;
            int i6 = this.f29163g;
            canvas.drawRoundRect(rectF3, (float) i6, (float) i6, this.q);
        }
        if (!isEnabled()) {
            this.q.setColor(this.k);
            RectF rectF4 = this.s;
            int i7 = this.f29163g;
            canvas.drawRoundRect(rectF4, (float) i7, (float) i7, this.q);
        }
    }

    public void a(String str, int i2, int i3) {
        if (str != null) {
            this.n = str;
        }
        if (i2 >= 0) {
            this.o = i2;
        }
        if (i3 != 0) {
            this.l = i3;
        }
        requestLayout();
        invalidate();
    }

    public String getText() {
        String str = this.n;
        return str == null ? "" : str;
    }
}
