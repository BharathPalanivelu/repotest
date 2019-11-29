package com.garena.android.appkit.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.g.x;
import androidx.viewpager.widget.ViewPager;
import com.garena.android.appkit.c;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class BBCirclePageIndicator extends View implements a {

    /* renamed from: a  reason: collision with root package name */
    private float f7703a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f7704b = new Paint(1);

    /* renamed from: c  reason: collision with root package name */
    private final Paint f7705c = new Paint(1);

    /* renamed from: d  reason: collision with root package name */
    private final Paint f7706d = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    private ViewPager f7707e;

    /* renamed from: f  reason: collision with root package name */
    private ViewPager.f f7708f;

    /* renamed from: g  reason: collision with root package name */
    private int f7709g;
    private int h;
    private float i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private float o = -1.0f;
    private int p = -1;
    private int q = -1;

    public BBCirclePageIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (!isInEditMode()) {
            int a2 = b.a(c.C0125c.default_circle_indicator_page_color);
            int a3 = b.a(c.C0125c.default_circle_indicator_fill_color);
            int g2 = b.g(c.g.default_circle_indicator_orientation);
            int a4 = b.a(c.C0125c.default_circle_indicator_stroke_color);
            float c2 = b.c(c.d.default_circle_indicator_stroke_width);
            float c3 = b.c(c.d.default_circle_indicator_radius);
            boolean b2 = b.b(c.b.default_circle_indicator_centered);
            boolean b3 = b.b(c.b.default_circle_indicator_snap);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.j.CirclePageIndicator, i2, 0);
            this.l = obtainStyledAttributes.getBoolean(c.j.CirclePageIndicator_centered, b2);
            this.k = obtainStyledAttributes.getInt(c.j.CirclePageIndicator_android_orientation, g2);
            this.f7704b.setStyle(Paint.Style.FILL);
            this.f7704b.setColor(obtainStyledAttributes.getColor(c.j.CirclePageIndicator_pageColor, a2));
            this.f7705c.setStyle(Paint.Style.STROKE);
            this.f7705c.setColor(obtainStyledAttributes.getColor(c.j.CirclePageIndicator_strokeColor, a4));
            this.f7705c.setStrokeWidth(obtainStyledAttributes.getDimension(c.j.CirclePageIndicator_strokeWidth, c2));
            this.f7706d.setStyle(Paint.Style.FILL);
            this.f7706d.setColor(obtainStyledAttributes.getColor(c.j.CirclePageIndicator_fillColor, a3));
            this.f7703a = obtainStyledAttributes.getDimension(c.j.CirclePageIndicator_radius, c3);
            this.m = obtainStyledAttributes.getBoolean(c.j.CirclePageIndicator_snap, b3);
            Drawable drawable = obtainStyledAttributes.getDrawable(c.j.CirclePageIndicator_android_background);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.n = x.a(ViewConfiguration.get(context));
        }
    }

    public void setCentered(boolean z) {
        this.l = z;
        invalidate();
    }

    public void setPageColor(int i2) {
        this.f7704b.setColor(i2);
        invalidate();
    }

    public int getPageColor() {
        return this.f7704b.getColor();
    }

    public void setFillColor(int i2) {
        this.f7706d.setColor(i2);
        invalidate();
    }

    public int getFillColor() {
        return this.f7706d.getColor();
    }

    public void setOrientation(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.k = i2;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
    }

    public int getOrientation() {
        return this.k;
    }

    public void setStrokeColor(int i2) {
        this.f7705c.setColor(i2);
        invalidate();
    }

    public int getStrokeColor() {
        return this.f7705c.getColor();
    }

    public void setStrokeWidth(float f2) {
        this.f7705c.setStrokeWidth(f2);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.f7705c.getStrokeWidth();
    }

    public void setRadius(float f2) {
        this.f7703a = f2;
        invalidate();
    }

    public float getRadius() {
        return this.f7703a;
    }

    public void setSnap(boolean z) {
        this.m = z;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        float f2;
        float f3;
        super.onDraw(canvas);
        ViewPager viewPager = this.f7707e;
        if (viewPager != null) {
            int i6 = this.q;
            if (i6 == -1) {
                i6 = viewPager.getAdapter().getCount();
            }
            if (i6 != 0) {
                if (this.k == 0) {
                    i5 = getWidth();
                    i4 = getPaddingLeft();
                    i3 = getPaddingRight();
                    i2 = getPaddingTop();
                } else {
                    i5 = getHeight();
                    i4 = getPaddingTop();
                    i3 = getPaddingBottom();
                    i2 = getPaddingLeft();
                }
                float f4 = this.f7703a;
                float f5 = 4.0f * f4;
                float f6 = ((float) i2) + f4;
                float f7 = ((float) i4) + f4;
                if (this.l) {
                    f7 += (((float) ((i5 - i4) - i3)) / 2.0f) - ((((float) i6) * f5) / 2.0f);
                }
                float f8 = this.f7703a;
                if (this.f7705c.getStrokeWidth() > BitmapDescriptorFactory.HUE_RED) {
                    f8 -= this.f7705c.getStrokeWidth() / 2.0f;
                }
                for (int i7 = 0; i7 < i6; i7++) {
                    float f9 = (((float) i7) * f5) + f7;
                    if (this.k == 0) {
                        f3 = f6;
                    } else {
                        f3 = f9;
                        f9 = f6;
                    }
                    if (this.f7704b.getAlpha() > 0) {
                        canvas.drawCircle(f9, f3, f8, this.f7704b);
                    }
                    float f10 = this.f7703a;
                    if (f8 != f10) {
                        canvas.drawCircle(f9, f3, f10, this.f7705c);
                    }
                }
                int i8 = this.q;
                float f11 = ((float) (i8 == -1 ? this.f7709g : this.f7709g % i8)) * f5;
                if (!this.m) {
                    f11 += this.i * f5;
                }
                if (this.k == 0) {
                    f2 = f11 + f7;
                } else {
                    float f12 = f6;
                    f6 = f11 + f7;
                    f2 = f12;
                }
                canvas.drawCircle(f2, f6, this.f7703a, this.f7706d);
            }
        }
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f7707e;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener((ViewPager.f) null);
            }
            if (viewPager.getAdapter() != null) {
                this.f7707e = viewPager;
                this.f7707e.setOnPageChangeListener(this);
                invalidate();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }

    public void a(ViewPager viewPager, int i2) {
        setViewPager(viewPager);
        setCurrentItem(i2);
    }

    public void setCurrentItem(int i2) {
        ViewPager viewPager = this.f7707e;
        if (viewPager != null) {
            viewPager.setCurrentItem(i2);
            this.f7709g = i2;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void onPageScrollStateChanged(int i2) {
        this.j = i2;
        ViewPager.f fVar = this.f7708f;
        if (fVar != null) {
            fVar.onPageScrollStateChanged(i2);
        }
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        this.f7709g = i2;
        this.i = f2;
        invalidate();
        ViewPager.f fVar = this.f7708f;
        if (fVar != null) {
            fVar.onPageScrolled(i2, f2, i3);
        }
    }

    public void onPageSelected(int i2) {
        if (this.m || this.j == 0) {
            this.f7709g = i2;
            this.h = i2;
            invalidate();
        }
        ViewPager.f fVar = this.f7708f;
        if (fVar != null) {
            fVar.onPageSelected(i2);
        }
    }

    public void setOnPageChangeListener(ViewPager.f fVar) {
        this.f7708f = fVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.k == 0) {
            setMeasuredDimension(a(i2), b(i3));
        } else {
            setMeasuredDimension(b(i2), a(i3));
        }
    }

    private int a(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        ViewPager viewPager = this.f7707e;
        if (viewPager == null) {
            return size;
        }
        int i3 = this.q;
        if (i3 == -1) {
            i3 = viewPager.getAdapter().getCount();
        }
        float f2 = this.f7703a;
        int paddingLeft = (int) (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (i3 * 2)) * f2) + (((float) (i3 - 1)) * f2) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    private int b(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.f7703a * 2.0f) + ((float) getPaddingTop()) + ((float) getPaddingBottom()) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f7709g = savedState.f7710a;
        this.h = savedState.f7710a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7710a = this.f7709g;
        return savedState;
    }

    public void setPageCount(int i2) {
        this.q = i2;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f7710a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f7710a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7710a);
        }
    }
}
