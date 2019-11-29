package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

final class i extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f1854a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f1855b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f1856c = null;

    /* renamed from: d  reason: collision with root package name */
    PorterDuff.Mode f1857d = g.f1846a;

    i(i iVar) {
        if (iVar != null) {
            this.f1854a = iVar.f1854a;
            this.f1855b = iVar.f1855b;
            this.f1856c = iVar.f1856c;
            this.f1857d = iVar.f1857d;
        }
    }

    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new h(this, resources);
        }
        return new g(this, resources);
    }

    public int getChangingConfigurations() {
        int i = this.f1854a;
        Drawable.ConstantState constantState = this.f1855b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f1855b != null;
    }
}
