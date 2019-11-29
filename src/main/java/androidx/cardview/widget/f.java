package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class f extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f1349a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f1350b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f1351c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f1352d;

    /* renamed from: e  reason: collision with root package name */
    private float f1353e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1354f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1355g = true;
    private ColorStateList h;
    private PorterDuffColorFilter i;
    private ColorStateList j;
    private PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    public int getOpacity() {
        return -3;
    }

    f(ColorStateList colorStateList, float f2) {
        this.f1349a = f2;
        this.f1350b = new Paint(5);
        b(colorStateList);
        this.f1351c = new RectF();
        this.f1352d = new Rect();
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.h = colorStateList;
        this.f1350b.setColor(this.h.getColorForState(getState(), this.h.getDefaultColor()));
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, boolean z, boolean z2) {
        if (f2 != this.f1353e || this.f1354f != z || this.f1355g != z2) {
            this.f1353e = f2;
            this.f1354f = z;
            this.f1355g = z2;
            a((Rect) null);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.f1353e;
    }

    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f1350b;
        if (this.i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.i);
            z = true;
        }
        RectF rectF = this.f1351c;
        float f2 = this.f1349a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    private void a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1351c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f1352d.set(rect);
        if (this.f1354f) {
            float a2 = g.a(this.f1353e, this.f1349a, this.f1355g);
            this.f1352d.inset((int) Math.ceil((double) g.b(this.f1353e, this.f1349a, this.f1355g)), (int) Math.ceil((double) a2));
            this.f1351c.set(this.f1352d);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1352d, this.f1349a);
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        if (f2 != this.f1349a) {
            this.f1349a = f2;
            a((Rect) null);
            invalidateSelf();
        }
    }

    public void setAlpha(int i2) {
        this.f1350b.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1350b.setColorFilter(colorFilter);
    }

    public float b() {
        return this.f1349a;
    }

    public void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    public ColorStateList c() {
        return this.h;
    }

    public void setTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.i = a(this.j, this.k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.i = a(this.j, this.k);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f1350b.getColor();
        if (z) {
            this.f1350b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.j;
        if (colorStateList2 != null) {
            PorterDuff.Mode mode = this.k;
            if (mode != null) {
                this.i = a(colorStateList2, mode);
                return true;
            }
        }
        return z;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.j;
        if (colorStateList == null || !colorStateList.isStateful()) {
            ColorStateList colorStateList2 = this.h;
            if ((colorStateList2 == null || !colorStateList2.isStateful()) && !super.isStateful()) {
                return false;
            }
        }
        return true;
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
