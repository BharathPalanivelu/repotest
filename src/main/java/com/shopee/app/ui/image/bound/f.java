package com.shopee.app.ui.image.bound;

import android.graphics.drawable.Drawable;
import com.shopee.app.ui.image.bound.b;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private int f22779a;

    /* renamed from: b  reason: collision with root package name */
    private b.a f22780b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f22781c;

    public f() {
        this(0, 1, (g) null);
    }

    public f(int i) {
        this.f22779a = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i, int i2, g gVar) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final b.a a() {
        return this.f22780b;
    }

    public final void a(b.a aVar) {
        this.f22780b = aVar;
    }

    public final void a(Drawable drawable) {
        this.f22781c = drawable;
    }

    public final Drawable b() {
        return this.f22781c;
    }
}
