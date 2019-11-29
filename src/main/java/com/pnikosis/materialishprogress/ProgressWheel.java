package com.pnikosis.materialishprogress;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.pnikosis.materialishprogress.a;

public class ProgressWheel extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15697a = "ProgressWheel";

    /* renamed from: b  reason: collision with root package name */
    private final int f15698b = 16;

    /* renamed from: c  reason: collision with root package name */
    private final int f15699c = 270;

    /* renamed from: d  reason: collision with root package name */
    private final long f15700d = 200;

    /* renamed from: e  reason: collision with root package name */
    private int f15701e = 28;

    /* renamed from: f  reason: collision with root package name */
    private int f15702f = 4;

    /* renamed from: g  reason: collision with root package name */
    private int f15703g = 4;
    private boolean h = false;
    private double i = 0.0d;
    private double j = 460.0d;
    private float k = BitmapDescriptorFactory.HUE_RED;
    private boolean l = true;
    private long m = 0;
    private int n = -1442840576;
    private int o = 16777215;
    private Paint p = new Paint();
    private Paint q = new Paint();
    private RectF r = new RectF();
    private float s = 230.0f;
    private long t = 0;
    private boolean u;
    private float v = BitmapDescriptorFactory.HUE_RED;
    private float w = BitmapDescriptorFactory.HUE_RED;
    private boolean x = false;
    private a y;
    private boolean z;

    public interface a {
        void a(float f2);
    }

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context.obtainStyledAttributes(attributeSet, a.C0248a.ProgressWheel));
        c();
    }

    public ProgressWheel(Context context) {
        super(context);
        c();
    }

    @TargetApi(17)
    private void c() {
        float f2;
        if (Build.VERSION.SDK_INT >= 17) {
            f2 = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        } else {
            f2 = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        }
        this.z = f2 != BitmapDescriptorFactory.HUE_RED;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int paddingLeft = this.f15701e + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.f15701e + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            paddingLeft = size;
        } else if (mode == Integer.MIN_VALUE) {
            paddingLeft = Math.min(paddingLeft, size);
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a(i2, i3);
        d();
        invalidate();
    }

    private void d() {
        this.p.setColor(this.n);
        this.p.setAntiAlias(true);
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setStrokeWidth((float) this.f15702f);
        this.q.setColor(this.o);
        this.q.setAntiAlias(true);
        this.q.setStyle(Paint.Style.STROKE);
        this.q.setStrokeWidth((float) this.f15703g);
    }

    private void a(int i2, int i3) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (!this.h) {
            int i4 = (i2 - paddingLeft) - paddingRight;
            int min = Math.min(Math.min(i4, (i3 - paddingBottom) - paddingTop), (this.f15701e * 2) - (this.f15702f * 2));
            int i5 = ((i4 - min) / 2) + paddingLeft;
            int i6 = ((((i3 - paddingTop) - paddingBottom) - min) / 2) + paddingTop;
            int i7 = this.f15702f;
            this.r = new RectF((float) (i5 + i7), (float) (i6 + i7), (float) ((i5 + min) - i7), (float) ((i6 + min) - i7));
            return;
        }
        int i8 = this.f15702f;
        this.r = new RectF((float) (paddingLeft + i8), (float) (paddingTop + i8), (float) ((i2 - paddingRight) - i8), (float) ((i3 - paddingBottom) - i8));
    }

    private void a(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f15702f = (int) TypedValue.applyDimension(1, (float) this.f15702f, displayMetrics);
        this.f15703g = (int) TypedValue.applyDimension(1, (float) this.f15703g, displayMetrics);
        this.f15701e = (int) TypedValue.applyDimension(1, (float) this.f15701e, displayMetrics);
        this.f15701e = (int) typedArray.getDimension(a.C0248a.ProgressWheel_matProg_circleRadius, (float) this.f15701e);
        this.h = typedArray.getBoolean(a.C0248a.ProgressWheel_matProg_fillRadius, false);
        this.f15702f = (int) typedArray.getDimension(a.C0248a.ProgressWheel_matProg_barWidth, (float) this.f15702f);
        this.f15703g = (int) typedArray.getDimension(a.C0248a.ProgressWheel_matProg_rimWidth, (float) this.f15703g);
        this.s = typedArray.getFloat(a.C0248a.ProgressWheel_matProg_spinSpeed, this.s / 360.0f) * 360.0f;
        this.j = (double) typedArray.getInt(a.C0248a.ProgressWheel_matProg_barSpinCycleTime, (int) this.j);
        this.n = typedArray.getColor(a.C0248a.ProgressWheel_matProg_barColor, this.n);
        this.o = typedArray.getColor(a.C0248a.ProgressWheel_matProg_rimColor, this.o);
        this.u = typedArray.getBoolean(a.C0248a.ProgressWheel_matProg_linearProgress, false);
        if (typedArray.getBoolean(a.C0248a.ProgressWheel_matProg_progressIndeterminate, false)) {
            b();
        }
        typedArray.recycle();
    }

    public void setCallback(a aVar) {
        this.y = aVar;
        if (!this.x) {
            e();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        float f5;
        super.onDraw(canvas);
        canvas.drawArc(this.r, 360.0f, 360.0f, false, this.q);
        if (this.z) {
            boolean z2 = true;
            if (this.x) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.t;
                a(uptimeMillis);
                this.v += (((float) uptimeMillis) * this.s) / 1000.0f;
                float f6 = this.v;
                if (f6 > 360.0f) {
                    this.v = f6 - 360.0f;
                    a(-1.0f);
                }
                this.t = SystemClock.uptimeMillis();
                float f7 = this.v - 90.0f;
                float f8 = this.k + 16.0f;
                if (isInEditMode()) {
                    f5 = BitmapDescriptorFactory.HUE_RED;
                    f4 = 135.0f;
                } else {
                    f5 = f7;
                    f4 = f8;
                }
                canvas.drawArc(this.r, f5, f4, false, this.p);
            } else {
                float f9 = this.v;
                if (f9 != this.w) {
                    this.v = Math.min(this.v + ((((float) (SystemClock.uptimeMillis() - this.t)) / 1000.0f) * this.s), this.w);
                    this.t = SystemClock.uptimeMillis();
                } else {
                    z2 = false;
                }
                if (f9 != this.v) {
                    e();
                }
                float f10 = this.v;
                if (!this.u) {
                    f3 = ((float) (1.0d - Math.pow((double) (1.0f - (f10 / 360.0f)), (double) 4.0f))) * 360.0f;
                    f2 = ((float) (1.0d - Math.pow((double) (1.0f - (this.v / 360.0f)), (double) 2.0f))) * 360.0f;
                } else {
                    f2 = f10;
                    f3 = BitmapDescriptorFactory.HUE_RED;
                }
                canvas.drawArc(this.r, f3 - 90.0f, isInEditMode() ? 360.0f : f2, false, this.p);
            }
            if (z2) {
                invalidate();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            this.t = SystemClock.uptimeMillis();
        }
    }

    private void a(long j2) {
        long j3 = this.m;
        if (j3 >= 200) {
            double d2 = this.i;
            double d3 = (double) j2;
            Double.isNaN(d3);
            this.i = d2 + d3;
            double d4 = this.i;
            double d5 = this.j;
            if (d4 > d5) {
                this.i = d4 - d5;
                this.m = 0;
                this.l = !this.l;
            }
            float cos = (((float) Math.cos(((this.i / this.j) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (this.l) {
                this.k = cos * 254.0f;
                return;
            }
            float f2 = (1.0f - cos) * 254.0f;
            this.v += this.k - f2;
            this.k = f2;
            return;
        }
        this.m = j3 + j2;
    }

    public void a() {
        this.x = false;
        this.v = BitmapDescriptorFactory.HUE_RED;
        this.w = BitmapDescriptorFactory.HUE_RED;
        invalidate();
    }

    public void b() {
        this.t = SystemClock.uptimeMillis();
        this.x = true;
        invalidate();
    }

    private void a(float f2) {
        a aVar = this.y;
        if (aVar != null) {
            aVar.a(f2);
        }
    }

    private void e() {
        if (this.y != null) {
            this.y.a(((float) Math.round((this.v * 100.0f) / 360.0f)) / 100.0f);
        }
    }

    public void setInstantProgress(float f2) {
        if (this.x) {
            this.v = BitmapDescriptorFactory.HUE_RED;
            this.x = false;
        }
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        } else if (f2 < BitmapDescriptorFactory.HUE_RED) {
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        if (f2 != this.w) {
            this.w = Math.min(f2 * 360.0f, 360.0f);
            this.v = this.w;
            this.t = SystemClock.uptimeMillis();
            invalidate();
        }
    }

    public Parcelable onSaveInstanceState() {
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.f15704a = this.v;
        wheelSavedState.f15705b = this.w;
        wheelSavedState.f15706c = this.x;
        wheelSavedState.f15707d = this.s;
        wheelSavedState.f15708e = this.f15702f;
        wheelSavedState.f15709f = this.n;
        wheelSavedState.f15710g = this.f15703g;
        wheelSavedState.h = this.o;
        wheelSavedState.i = this.f15701e;
        wheelSavedState.j = this.u;
        wheelSavedState.k = this.h;
        return wheelSavedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WheelSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
        super.onRestoreInstanceState(wheelSavedState.getSuperState());
        this.v = wheelSavedState.f15704a;
        this.w = wheelSavedState.f15705b;
        this.x = wheelSavedState.f15706c;
        this.s = wheelSavedState.f15707d;
        this.f15702f = wheelSavedState.f15708e;
        this.n = wheelSavedState.f15709f;
        this.f15703g = wheelSavedState.f15710g;
        this.o = wheelSavedState.h;
        this.f15701e = wheelSavedState.i;
        this.u = wheelSavedState.j;
        this.h = wheelSavedState.k;
        this.t = SystemClock.uptimeMillis();
    }

    public float getProgress() {
        if (this.x) {
            return -1.0f;
        }
        return this.v / 360.0f;
    }

    public void setProgress(float f2) {
        if (this.x) {
            this.v = BitmapDescriptorFactory.HUE_RED;
            this.x = false;
            e();
        }
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        } else if (f2 < BitmapDescriptorFactory.HUE_RED) {
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        float f3 = this.w;
        if (f2 != f3) {
            if (this.v == f3) {
                this.t = SystemClock.uptimeMillis();
            }
            this.w = Math.min(f2 * 360.0f, 360.0f);
            invalidate();
        }
    }

    public void setLinearProgress(boolean z2) {
        this.u = z2;
        if (!this.x) {
            invalidate();
        }
    }

    public int getCircleRadius() {
        return this.f15701e;
    }

    public void setCircleRadius(int i2) {
        this.f15701e = i2;
        if (!this.x) {
            invalidate();
        }
    }

    public int getBarWidth() {
        return this.f15702f;
    }

    public void setBarWidth(int i2) {
        this.f15702f = i2;
        if (!this.x) {
            invalidate();
        }
    }

    public int getBarColor() {
        return this.n;
    }

    public void setBarColor(int i2) {
        this.n = i2;
        d();
        if (!this.x) {
            invalidate();
        }
    }

    public int getRimColor() {
        return this.o;
    }

    public void setRimColor(int i2) {
        this.o = i2;
        d();
        if (!this.x) {
            invalidate();
        }
    }

    public float getSpinSpeed() {
        return this.s / 360.0f;
    }

    public void setSpinSpeed(float f2) {
        this.s = f2 * 360.0f;
    }

    public int getRimWidth() {
        return this.f15703g;
    }

    public void setRimWidth(int i2) {
        this.f15703g = i2;
        if (!this.x) {
            invalidate();
        }
    }

    static class WheelSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new Parcelable.Creator<WheelSavedState>() {
            /* renamed from: a */
            public WheelSavedState createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            /* renamed from: a */
            public WheelSavedState[] newArray(int i) {
                return new WheelSavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        float f15704a;

        /* renamed from: b  reason: collision with root package name */
        float f15705b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15706c;

        /* renamed from: d  reason: collision with root package name */
        float f15707d;

        /* renamed from: e  reason: collision with root package name */
        int f15708e;

        /* renamed from: f  reason: collision with root package name */
        int f15709f;

        /* renamed from: g  reason: collision with root package name */
        int f15710g;
        int h;
        int i;
        boolean j;
        boolean k;

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private WheelSavedState(Parcel parcel) {
            super(parcel);
            this.f15704a = parcel.readFloat();
            this.f15705b = parcel.readFloat();
            boolean z = true;
            this.f15706c = parcel.readByte() != 0;
            this.f15707d = parcel.readFloat();
            this.f15708e = parcel.readInt();
            this.f15709f = parcel.readInt();
            this.f15710g = parcel.readInt();
            this.h = parcel.readInt();
            this.i = parcel.readInt();
            this.j = parcel.readByte() != 0;
            this.k = parcel.readByte() == 0 ? false : z;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.f15704a);
            parcel.writeFloat(this.f15705b);
            parcel.writeByte(this.f15706c ? (byte) 1 : 0);
            parcel.writeFloat(this.f15707d);
            parcel.writeInt(this.f15708e);
            parcel.writeInt(this.f15709f);
            parcel.writeInt(this.f15710g);
            parcel.writeInt(this.h);
            parcel.writeInt(this.i);
            parcel.writeByte(this.j ? (byte) 1 : 0);
            parcel.writeByte(this.k ? (byte) 1 : 0);
        }
    }
}
