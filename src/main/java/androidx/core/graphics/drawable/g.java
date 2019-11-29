package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

class g extends Drawable implements Drawable.Callback, e, f {

    /* renamed from: a  reason: collision with root package name */
    static final PorterDuff.Mode f1846a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    i f1847b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f1848c;

    /* renamed from: d  reason: collision with root package name */
    private int f1849d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f1850e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1851f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1852g;

    /* access modifiers changed from: protected */
    public boolean b() {
        return true;
    }

    g(i iVar, Resources resources) {
        this.f1847b = iVar;
        a(resources);
    }

    g(Drawable drawable) {
        this.f1847b = c();
        a(drawable);
    }

    private void a(Resources resources) {
        i iVar = this.f1847b;
        if (iVar != null && iVar.f1855b != null) {
            a(this.f1847b.f1855b.newDrawable(resources));
        }
    }

    public void jumpToCurrentState() {
        this.f1848c.jumpToCurrentState();
    }

    public void draw(Canvas canvas) {
        this.f1848c.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1848c;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.f1848c.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        i iVar = this.f1847b;
        return changingConfigurations | (iVar != null ? iVar.getChangingConfigurations() : 0) | this.f1848c.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f1848c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1848c.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f1848c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1848c.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        if (b()) {
            i iVar = this.f1847b;
            if (iVar != null) {
                colorStateList = iVar.f1856c;
                return (colorStateList == null && colorStateList.isStateful()) || this.f1848c.isStateful();
            }
        }
        colorStateList = null;
        if (colorStateList == null) {
        }
    }

    public boolean setState(int[] iArr) {
        return a(iArr) || this.f1848c.setState(iArr);
    }

    public int[] getState() {
        return this.f1848c.getState();
    }

    public Drawable getCurrent() {
        return this.f1848c.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1848c.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f1848c.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f1848c.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f1848c.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f1848c.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f1848c.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f1848c.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f1848c.getPadding(rect);
    }

    public void setAutoMirrored(boolean z) {
        this.f1848c.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.f1848c.isAutoMirrored();
    }

    public Drawable.ConstantState getConstantState() {
        i iVar = this.f1847b;
        if (iVar == null || !iVar.a()) {
            return null;
        }
        this.f1847b.f1854a = getChangingConfigurations();
        return this.f1847b;
    }

    public Drawable mutate() {
        if (!this.f1852g && super.mutate() == this) {
            this.f1847b = c();
            Drawable drawable = this.f1848c;
            if (drawable != null) {
                drawable.mutate();
            }
            i iVar = this.f1847b;
            if (iVar != null) {
                Drawable drawable2 = this.f1848c;
                iVar.f1855b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f1852g = true;
        }
        return this;
    }

    private i c() {
        return new i(this.f1847b);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f1848c.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1847b.f1856c = colorStateList;
        a(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f1847b.f1857d = mode;
        a(getState());
    }

    private boolean a(int[] iArr) {
        if (!b()) {
            return false;
        }
        ColorStateList colorStateList = this.f1847b.f1856c;
        PorterDuff.Mode mode = this.f1847b.f1857d;
        if (colorStateList == null || mode == null) {
            this.f1851f = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f1851f && colorForState == this.f1849d && mode == this.f1850e)) {
                setColorFilter(colorForState, mode);
                this.f1849d = colorForState;
                this.f1850e = mode;
                this.f1851f = true;
                return true;
            }
        }
        return false;
    }

    public final Drawable a() {
        return this.f1848c;
    }

    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f1848c;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1848c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            i iVar = this.f1847b;
            if (iVar != null) {
                iVar.f1855b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
