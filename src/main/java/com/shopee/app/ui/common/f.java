package com.shopee.app.ui.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.id.R;

public class f extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    int f21260a;

    /* renamed from: b  reason: collision with root package name */
    int f21261b;

    /* renamed from: c  reason: collision with root package name */
    int f21262c;

    /* renamed from: e  reason: collision with root package name */
    int f21263e;

    /* renamed from: f  reason: collision with root package name */
    int f21264f;

    /* renamed from: g  reason: collision with root package name */
    int f21265g;
    PorterDuffXfermode h = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
    private int i = 99;
    private Drawable j;
    private boolean k;
    private boolean l;
    private Paint m = new Paint();
    private boolean n = false;
    private int o;
    private Paint p = new Paint();
    private Rect q = new Rect();
    private RectF r = new RectF();

    public f(Context context) {
        super(context);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public f(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i2 = this.f21261b;
        int i3 = this.f21263e;
        setPadding(i2, i3, i2, i3);
        setTextSize(10.0f);
        setTypeface(Typeface.DEFAULT_BOLD);
        setGravity(17);
        setVisibility(4);
        this.m.setColor(this.f21264f);
        this.m.setAntiAlias(true);
        this.m.setDither(false);
    }

    public void setNumber(Integer num) {
        if (num == null) {
            num = 0;
        }
        this.k = false;
        int intValue = num.intValue();
        int i2 = this.i;
        if (intValue > i2) {
            setText(b.a(R.string.notification_max_plus, Integer.valueOf(i2)));
            setVisibility(0);
        } else {
            setText(Integer.toString(num.intValue()));
            setVisibility(0);
        }
        if (num.intValue() <= 0) {
            setVisibility(4);
        }
    }

    public void setNumberDot(int i2) {
        if (!this.l) {
            this.k = true;
            this.n = false;
            setText("");
            if (i2 > this.i) {
                setVisibility(0);
            } else {
                setVisibility(0);
            }
            if (i2 <= 0) {
                setVisibility(4);
            }
            setBackgroundResource(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.k) {
            super.onDraw(canvas);
            if (this.n) {
                this.p.setAntiAlias(true);
                this.p.setStyle(Paint.Style.STROKE);
                this.p.setStrokeWidth(BitmapDescriptorFactory.HUE_RED);
                this.p.setColor(this.o);
                this.p.setXfermode(this.h);
                this.q.set(0, 0, getWidth(), getHeight());
                this.r.set(this.q);
                RectF rectF = this.r;
                int i2 = this.f21262c;
                canvas.drawRoundRect(rectF, (float) i2, (float) i2, this.p);
                return;
            }
            return;
        }
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) b.a.f7693d, this.m);
    }

    public void setMaxNumber(int i2) {
        this.i = i2;
    }

    public void b() {
        float f2 = (float) this.f21262c;
        setTextColor(-1);
        a(this.f21264f, new float[]{f2, f2, f2, f2, f2, f2, 0.0f, 0.0f});
        this.o = -1;
        this.n = false;
    }

    public void c() {
        setTextColor(-1);
        setBackground(this.f21264f);
        this.o = -1;
        this.n = true;
    }

    public void d() {
        setTextColor(this.f21264f);
        setBackground(-1);
        this.o = this.f21264f;
        this.n = true;
    }

    public void e() {
        setTextColor(-1);
        setBackground(this.f21265g);
        this.o = -1;
        this.n = true;
    }

    public void setBadgeType(int i2) {
        if (i2 == 0) {
            c();
        } else if (i2 == 1) {
            d();
        }
    }

    private void setBackground(int i2) {
        float f2 = (float) this.f21262c;
        a(i2, new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
    }

    private void a(int i2, float[] fArr) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setShader(new RadialGradient(37.5f, 12.5f, 50.0f, i2, i2, Shader.TileMode.CLAMP));
        this.j = shapeDrawable;
        setBackground(this.j);
    }

    public boolean f() {
        return this.k;
    }

    public void a(boolean z) {
        this.l = z;
        if (this.l) {
            this.k = false;
            b();
            setText(R.string.sp_new);
            setVisibility(0);
            return;
        }
        setVisibility(4);
        c();
    }
}
