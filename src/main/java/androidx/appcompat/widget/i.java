package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.c;

class i {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f1208a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1209b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1210c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1211d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1212e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1213f;

    i(CompoundButton compoundButton) {
        this.f1208a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[SYNTHETIC, Splitter:B:12:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b A[Catch:{ all -> 0x0080 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.util.AttributeSet r4, int r5) {
        /*
            r3 = this;
            android.widget.CompoundButton r0 = r3.f1208a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.a.j.CompoundButton
            r2 = 0
            android.content.res.TypedArray r4 = r0.obtainStyledAttributes(r4, r1, r5, r2)
            int r5 = androidx.appcompat.a.j.CompoundButton_buttonCompat     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x002e
            int r5 = androidx.appcompat.a.j.CompoundButton_buttonCompat     // Catch:{ all -> 0x0080 }
            int r5 = r4.getResourceId(r5, r2)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x002e
            android.widget.CompoundButton r0 = r3.f1208a     // Catch:{ NotFoundException -> 0x002e }
            android.widget.CompoundButton r1 = r3.f1208a     // Catch:{ NotFoundException -> 0x002e }
            android.content.Context r1 = r1.getContext()     // Catch:{ NotFoundException -> 0x002e }
            android.graphics.drawable.Drawable r5 = androidx.appcompat.a.a.a.b(r1, r5)     // Catch:{ NotFoundException -> 0x002e }
            r0.setButtonDrawable(r5)     // Catch:{ NotFoundException -> 0x002e }
            r5 = 1
            goto L_0x002f
        L_0x002e:
            r5 = 0
        L_0x002f:
            if (r5 != 0) goto L_0x0050
            int r5 = androidx.appcompat.a.j.CompoundButton_android_button     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x0050
            int r5 = androidx.appcompat.a.j.CompoundButton_android_button     // Catch:{ all -> 0x0080 }
            int r5 = r4.getResourceId(r5, r2)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x0050
            android.widget.CompoundButton r0 = r3.f1208a     // Catch:{ all -> 0x0080 }
            android.widget.CompoundButton r1 = r3.f1208a     // Catch:{ all -> 0x0080 }
            android.content.Context r1 = r1.getContext()     // Catch:{ all -> 0x0080 }
            android.graphics.drawable.Drawable r5 = androidx.appcompat.a.a.a.b(r1, r5)     // Catch:{ all -> 0x0080 }
            r0.setButtonDrawable(r5)     // Catch:{ all -> 0x0080 }
        L_0x0050:
            int r5 = androidx.appcompat.a.j.CompoundButton_buttonTint     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x0063
            android.widget.CompoundButton r5 = r3.f1208a     // Catch:{ all -> 0x0080 }
            int r0 = androidx.appcompat.a.j.CompoundButton_buttonTint     // Catch:{ all -> 0x0080 }
            android.content.res.ColorStateList r0 = r4.getColorStateList(r0)     // Catch:{ all -> 0x0080 }
            androidx.core.widget.c.a((android.widget.CompoundButton) r5, (android.content.res.ColorStateList) r0)     // Catch:{ all -> 0x0080 }
        L_0x0063:
            int r5 = androidx.appcompat.a.j.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x007c
            android.widget.CompoundButton r5 = r3.f1208a     // Catch:{ all -> 0x0080 }
            int r0 = androidx.appcompat.a.j.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0080 }
            r1 = -1
            int r0 = r4.getInt(r0, r1)     // Catch:{ all -> 0x0080 }
            r1 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.z.a(r0, r1)     // Catch:{ all -> 0x0080 }
            androidx.core.widget.c.a((android.widget.CompoundButton) r5, (android.graphics.PorterDuff.Mode) r0)     // Catch:{ all -> 0x0080 }
        L_0x007c:
            r4.recycle()
            return
        L_0x0080:
            r5 = move-exception
            r4.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i.a(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        this.f1209b = colorStateList;
        this.f1211d = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList a() {
        return this.f1209b;
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        this.f1210c = mode;
        this.f1212e = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode b() {
        return this.f1210c;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f1213f) {
            this.f1213f = false;
            return;
        }
        this.f1213f = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Drawable a2 = c.a(this.f1208a);
        if (a2 == null) {
            return;
        }
        if (this.f1211d || this.f1212e) {
            Drawable mutate = a.g(a2).mutate();
            if (this.f1211d) {
                a.a(mutate, this.f1209b);
            }
            if (this.f1212e) {
                a.a(mutate, this.f1210c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1208a.getDrawableState());
            }
            this.f1208a.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a2 = c.a(this.f1208a);
        return a2 != null ? i + a2.getIntrinsicWidth() : i;
    }
}
