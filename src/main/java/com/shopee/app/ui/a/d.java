package com.shopee.app.ui.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.k;
import java.lang.ref.WeakReference;

public abstract class d extends h {

    /* renamed from: e  reason: collision with root package name */
    private static final int f19179e = ((int) (((float) b.b()) * 0.75f));

    /* renamed from: a  reason: collision with root package name */
    a f19180a;

    /* renamed from: b  reason: collision with root package name */
    i f19181b = new i(getContext());

    /* renamed from: c  reason: collision with root package name */
    View f19182c;

    /* renamed from: d  reason: collision with root package name */
    WeakReference<r> f19183d;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f19184f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f19185g;
    private DrawerLayout h;

    /* access modifiers changed from: protected */
    public abstract void a(a.C0296a aVar);

    /* access modifiers changed from: protected */
    public abstract boolean a();

    public d(Context context) {
        super(context);
        this.f19184f = new LinearLayout(context);
        this.f19184f.setOrientation(1);
        this.f19180a = a(context);
    }

    /* access modifiers changed from: protected */
    public a a(Context context) {
        a.C0296a aVar = new a.C0296a();
        a(aVar);
        return aVar.a(context);
    }

    public void setContentView(View view) {
        this.f19182c = view;
        View view2 = this.f19182c;
        if (view2 instanceof r) {
            this.f19183d = new WeakReference<>((r) view2);
        } else {
            this.f19183d = new WeakReference<>((Object) null);
        }
        f();
    }

    private void f() {
        if (this.f19180a.e()) {
            this.f19181b.addView(this.f19180a, new FrameLayout.LayoutParams(-1, b.a.r));
        } else {
            this.f19184f.addView(this.f19180a, new LinearLayout.LayoutParams(-1, b.a.r));
        }
        this.f19181b.addView(this.f19182c, new FrameLayout.LayoutParams(-1, -1));
        this.f19184f.addView(this.f19181b, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        if (!a()) {
            addView(this.f19184f, new LinearLayout.LayoutParams(-1, -1));
            return;
        }
        this.h = new k(getContext());
        this.h.addView(this.f19184f, new DrawerLayout.d(-1, -1));
        DrawerLayout.d dVar = new DrawerLayout.d(f19179e, -1);
        dVar.f1992a = 8388613;
        this.f19185g = new FrameLayout(getContext());
        this.f19185g.setLayoutParams(dVar);
        this.h.addView(this.f19185g);
        this.h.setDrawerLockMode(1);
        addView(this.h);
    }

    public a getActionBar() {
        return this.f19180a;
    }

    public i getShadowContainer() {
        return this.f19181b;
    }

    public DrawerLayout getDrawer() {
        return this.h;
    }

    public void setDrawerContent(View view) {
        FrameLayout frameLayout = this.f19185g;
        if (frameLayout != null) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void b(a.C0296a aVar) {
        if (this.f19180a.e()) {
            this.f19181b.removeView(this.f19180a);
        } else {
            this.f19184f.removeView(this.f19180a);
        }
        if (aVar.a()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, b.a.r);
            layoutParams.gravity = 48;
            this.f19181b.addView(this.f19180a, layoutParams);
        } else {
            this.f19184f.addView(this.f19180a, 0, new FrameLayout.LayoutParams(-1, b.a.r));
        }
        this.f19180a.setBuilder(aVar);
        this.f19180a.f();
    }

    public void e() {
        if (this.f19180a.e()) {
            this.f19181b.removeView(this.f19180a);
        } else {
            this.f19184f.removeView(this.f19180a);
        }
    }

    public void b() {
        r rVar = (r) this.f19183d.get();
        if (rVar != null) {
            rVar.b();
        }
    }

    public void c() {
        r rVar = (r) this.f19183d.get();
        if (rVar != null) {
            rVar.c();
        }
    }

    public void d() {
        r rVar = (r) this.f19183d.get();
        if (rVar != null) {
            rVar.d();
        }
    }
}
