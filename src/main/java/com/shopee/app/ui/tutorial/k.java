package com.shopee.app.ui.tutorial;

import android.content.Context;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class k extends j implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f25728c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f25729d = new c();

    public k(Context context, boolean z) {
        super(context, z);
        b();
    }

    public static j a(Context context, boolean z) {
        k kVar = new k(context, z);
        kVar.onFinishInflate();
        return kVar;
    }

    public void onFinishInflate() {
        if (!this.f25728c) {
            this.f25728c = true;
            inflate(getContext(), R.layout.tutorial_view_layout, this);
            this.f25729d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f25729d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25722b = (ViewPager) aVar.internalFindViewById(R.id.viewPager);
        a();
    }
}
