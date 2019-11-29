package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class CardView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f1337e = {16842801};

    /* renamed from: f  reason: collision with root package name */
    private static final e f1338f;

    /* renamed from: a  reason: collision with root package name */
    int f1339a;

    /* renamed from: b  reason: collision with root package name */
    int f1340b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f1341c;

    /* renamed from: d  reason: collision with root package name */
    final Rect f1342d;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1343g;
    private boolean h;
    private final d i;

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1338f = new b();
        } else if (Build.VERSION.SDK_INT >= 17) {
            f1338f = new a();
        } else {
            f1338f = new c();
        }
        f1338f.a();
    }

    public CardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0025a.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        ColorStateList valueOf;
        this.f1341c = new Rect();
        this.f1342d = new Rect();
        this.i = new d() {

            /* renamed from: b  reason: collision with root package name */
            private Drawable f1345b;

            public void a(Drawable drawable) {
                this.f1345b = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            public boolean a() {
                return CardView.this.getUseCompatPadding();
            }

            public boolean b() {
                return CardView.this.getPreventCornerOverlap();
            }

            public void a(int i, int i2, int i3, int i4) {
                CardView.this.f1342d.set(i, i2, i3, i4);
                CardView cardView = CardView.this;
                CardView.super.setPadding(i + cardView.f1341c.left, i2 + CardView.this.f1341c.top, i3 + CardView.this.f1341c.right, i4 + CardView.this.f1341c.bottom);
            }

            public void a(int i, int i2) {
                if (i > CardView.this.f1339a) {
                    CardView.super.setMinimumWidth(i);
                }
                if (i2 > CardView.this.f1340b) {
                    CardView.super.setMinimumHeight(i2);
                }
            }

            public Drawable c() {
                return this.f1345b;
            }

            public View d() {
                return CardView.this;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.e.CardView, i2, a.d.CardView);
        if (obtainStyledAttributes.hasValue(a.e.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(a.e.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1337e);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i3 = getResources().getColor(a.b.cardview_light_background);
            } else {
                i3 = getResources().getColor(a.b.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(i3);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(a.e.CardView_cardCornerRadius, BitmapDescriptorFactory.HUE_RED);
        float dimension2 = obtainStyledAttributes.getDimension(a.e.CardView_cardElevation, BitmapDescriptorFactory.HUE_RED);
        float dimension3 = obtainStyledAttributes.getDimension(a.e.CardView_cardMaxElevation, BitmapDescriptorFactory.HUE_RED);
        this.f1343g = obtainStyledAttributes.getBoolean(a.e.CardView_cardUseCompatPadding, false);
        this.h = obtainStyledAttributes.getBoolean(a.e.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_contentPadding, 0);
        this.f1341c.left = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f1341c.top = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_contentPaddingTop, dimensionPixelSize);
        this.f1341c.right = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_contentPaddingRight, dimensionPixelSize);
        this.f1341c.bottom = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_contentPaddingBottom, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1339a = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_android_minWidth, 0);
        this.f1340b = obtainStyledAttributes.getDimensionPixelSize(a.e.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f1338f.a(this.i, context, colorStateList, dimension, dimension2, f2);
    }

    public boolean getUseCompatPadding() {
        return this.f1343g;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f1343g != z) {
            this.f1343g = z;
            f1338f.g(this.i);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!(f1338f instanceof b)) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1338f.b(this.i)), View.MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1338f.c(this.i)), View.MeasureSpec.getSize(i3)), mode2);
            }
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setMinimumWidth(int i2) {
        this.f1339a = i2;
        super.setMinimumWidth(i2);
    }

    public void setMinimumHeight(int i2) {
        this.f1340b = i2;
        super.setMinimumHeight(i2);
    }

    public void setCardBackgroundColor(int i2) {
        f1338f.a(this.i, ColorStateList.valueOf(i2));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f1338f.a(this.i, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return f1338f.i(this.i);
    }

    public int getContentPaddingLeft() {
        return this.f1341c.left;
    }

    public int getContentPaddingRight() {
        return this.f1341c.right;
    }

    public int getContentPaddingTop() {
        return this.f1341c.top;
    }

    public int getContentPaddingBottom() {
        return this.f1341c.bottom;
    }

    public void setRadius(float f2) {
        f1338f.a(this.i, f2);
    }

    public float getRadius() {
        return f1338f.d(this.i);
    }

    public void setCardElevation(float f2) {
        f1338f.c(this.i, f2);
    }

    public float getCardElevation() {
        return f1338f.e(this.i);
    }

    public void setMaxCardElevation(float f2) {
        f1338f.b(this.i, f2);
    }

    public float getMaxCardElevation() {
        return f1338f.a(this.i);
    }

    public boolean getPreventCornerOverlap() {
        return this.h;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.h) {
            this.h = z;
            f1338f.h(this.i);
        }
    }
}
