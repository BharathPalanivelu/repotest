package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.a;
import androidx.core.widget.e;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f1223a;

    /* renamed from: b  reason: collision with root package name */
    private ap f1224b;

    /* renamed from: c  reason: collision with root package name */
    private ap f1225c;

    /* renamed from: d  reason: collision with root package name */
    private ap f1226d;

    public m(ImageView imageView) {
        this.f1223a = imageView;
    }

    public void a(AttributeSet attributeSet, int i) {
        ar a2 = ar.a(this.f1223a.getContext(), attributeSet, a.j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f1223a.getDrawable();
            if (drawable == null) {
                int g2 = a2.g(a.j.AppCompatImageView_srcCompat, -1);
                if (g2 != -1) {
                    drawable = androidx.appcompat.a.a.a.b(this.f1223a.getContext(), g2);
                    if (drawable != null) {
                        this.f1223a.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                z.b(drawable);
            }
            if (a2.g(a.j.AppCompatImageView_tint)) {
                e.a(this.f1223a, a2.e(a.j.AppCompatImageView_tint));
            }
            if (a2.g(a.j.AppCompatImageView_tintMode)) {
                e.a(this.f1223a, z.a(a2.a(a.j.AppCompatImageView_tintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.a();
        }
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b2 = androidx.appcompat.a.a.a.b(this.f1223a.getContext(), i);
            if (b2 != null) {
                z.b(b2);
            }
            this.f1223a.setImageDrawable(b2);
        } else {
            this.f1223a.setImageDrawable((Drawable) null);
        }
        d();
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1223a.getBackground() instanceof RippleDrawable);
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.f1225c == null) {
            this.f1225c = new ap();
        }
        ap apVar = this.f1225c;
        apVar.f1144a = colorStateList;
        apVar.f1147d = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        ap apVar = this.f1225c;
        if (apVar != null) {
            return apVar.f1144a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f1225c == null) {
            this.f1225c = new ap();
        }
        ap apVar = this.f1225c;
        apVar.f1145b = mode;
        apVar.f1146c = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        ap apVar = this.f1225c;
        if (apVar != null) {
            return apVar.f1145b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Drawable drawable = this.f1223a.getDrawable();
        if (drawable != null) {
            z.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!e() || !a(drawable)) {
            ap apVar = this.f1225c;
            if (apVar != null) {
                j.a(drawable, apVar, this.f1223a.getDrawableState());
                return;
            }
            ap apVar2 = this.f1224b;
            if (apVar2 != null) {
                j.a(drawable, apVar2, this.f1223a.getDrawableState());
            }
        }
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 21) {
            return i == 21;
        }
        if (this.f1224b != null) {
            return true;
        }
        return false;
    }

    private boolean a(Drawable drawable) {
        if (this.f1226d == null) {
            this.f1226d = new ap();
        }
        ap apVar = this.f1226d;
        apVar.a();
        ColorStateList a2 = e.a(this.f1223a);
        if (a2 != null) {
            apVar.f1147d = true;
            apVar.f1144a = a2;
        }
        PorterDuff.Mode b2 = e.b(this.f1223a);
        if (b2 != null) {
            apVar.f1146c = true;
            apVar.f1145b = b2;
        }
        if (!apVar.f1147d && !apVar.f1146c) {
            return false;
        }
        j.a(drawable, apVar, this.f1223a.getDrawableState());
        return true;
    }
}
