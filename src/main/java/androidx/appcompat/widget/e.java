package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.a;
import androidx.core.g.w;

class e {

    /* renamed from: a  reason: collision with root package name */
    private final View f1200a;

    /* renamed from: b  reason: collision with root package name */
    private final j f1201b;

    /* renamed from: c  reason: collision with root package name */
    private int f1202c = -1;

    /* renamed from: d  reason: collision with root package name */
    private ap f1203d;

    /* renamed from: e  reason: collision with root package name */
    private ap f1204e;

    /* renamed from: f  reason: collision with root package name */
    private ap f1205f;

    e(View view) {
        this.f1200a = view;
        this.f1201b = j.b();
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        ar a2 = ar.a(this.f1200a.getContext(), attributeSet, a.j.ViewBackgroundHelper, i, 0);
        try {
            if (a2.g(a.j.ViewBackgroundHelper_android_background)) {
                this.f1202c = a2.g(a.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b2 = this.f1201b.b(this.f1200a.getContext(), this.f1202c);
                if (b2 != null) {
                    b(b2);
                }
            }
            if (a2.g(a.j.ViewBackgroundHelper_backgroundTint)) {
                w.a(this.f1200a, a2.e(a.j.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(a.j.ViewBackgroundHelper_backgroundTintMode)) {
                w.a(this.f1200a, z.a(a2.a(a.j.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.f1202c = i;
        j jVar = this.f1201b;
        b(jVar != null ? jVar.b(this.f1200a.getContext(), i) : null);
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.f1202c = -1;
        b((ColorStateList) null);
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.f1204e == null) {
            this.f1204e = new ap();
        }
        ap apVar = this.f1204e;
        apVar.f1144a = colorStateList;
        apVar.f1147d = true;
        c();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList a() {
        ap apVar = this.f1204e;
        if (apVar != null) {
            return apVar.f1144a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f1204e == null) {
            this.f1204e = new ap();
        }
        ap apVar = this.f1204e;
        apVar.f1145b = mode;
        apVar.f1146c = true;
        c();
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode b() {
        ap apVar = this.f1204e;
        if (apVar != null) {
            return apVar.f1145b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Drawable background = this.f1200a.getBackground();
        if (background == null) {
            return;
        }
        if (!d() || !b(background)) {
            ap apVar = this.f1204e;
            if (apVar != null) {
                j.a(background, apVar, this.f1200a.getDrawableState());
                return;
            }
            ap apVar2 = this.f1203d;
            if (apVar2 != null) {
                j.a(background, apVar2, this.f1200a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1203d == null) {
                this.f1203d = new ap();
            }
            ap apVar = this.f1203d;
            apVar.f1144a = colorStateList;
            apVar.f1147d = true;
        } else {
            this.f1203d = null;
        }
        c();
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 21) {
            return i == 21;
        }
        if (this.f1203d != null) {
            return true;
        }
        return false;
    }

    private boolean b(Drawable drawable) {
        if (this.f1205f == null) {
            this.f1205f = new ap();
        }
        ap apVar = this.f1205f;
        apVar.a();
        ColorStateList w = w.w(this.f1200a);
        if (w != null) {
            apVar.f1147d = true;
            apVar.f1144a = w;
        }
        PorterDuff.Mode x = w.x(this.f1200a);
        if (x != null) {
            apVar.f1146c = true;
            apVar.f1145b = x;
        }
        if (!apVar.f1147d && !apVar.f1146c) {
            return false;
        }
        j.a(drawable, apVar, this.f1200a.getDrawableState());
        return true;
    }
}
