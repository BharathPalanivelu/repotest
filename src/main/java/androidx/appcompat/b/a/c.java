package androidx.appcompat.b.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

public class c extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f726a;

    public c(Drawable drawable) {
        a(drawable);
    }

    public void draw(Canvas canvas) {
        this.f726a.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f726a.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f726a.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f726a.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f726a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f726a.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f726a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f726a.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.f726a.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.f726a.setState(iArr);
    }

    public int[] getState() {
        return this.f726a.getState();
    }

    public void jumpToCurrentState() {
        a.a(this.f726a);
    }

    public Drawable getCurrent() {
        return this.f726a.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f726a.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f726a.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f726a.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f726a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f726a.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f726a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f726a.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f726a.getPadding(rect);
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
        return this.f726a.setLevel(i);
    }

    public void setAutoMirrored(boolean z) {
        a.a(this.f726a, z);
    }

    public boolean isAutoMirrored() {
        return a.b(this.f726a);
    }

    public void setTint(int i) {
        a.a(this.f726a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        a.a(this.f726a, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        a.a(this.f726a, mode);
    }

    public void setHotspot(float f2, float f3) {
        a.a(this.f726a, f2, f3);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        a.a(this.f726a, i, i2, i3, i4);
    }

    public Drawable a() {
        return this.f726a;
    }

    public void a(Drawable drawable) {
        Drawable drawable2 = this.f726a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f726a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
