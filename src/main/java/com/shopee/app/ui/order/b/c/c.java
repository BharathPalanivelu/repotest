package com.shopee.app.ui.order.b.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f23540e = false;

    /* renamed from: f  reason: collision with root package name */
    private final org.a.a.b.c f23541f = new org.a.a.b.c();

    public c(Context context, String str) {
        super(context, str);
        e();
    }

    public static b a(Context context, String str) {
        c cVar = new c(context, str);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.f23540e) {
            this.f23540e = true;
            inflate(getContext(), R.layout.return_list_filter_layout, this);
            this.f23541f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.f23541f);
        org.a.a.b.c.a((b) this);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23534c = (TabLayout) aVar.internalFindViewById(R.id.tab);
        this.f23535d = (ViewGroup) aVar.internalFindViewById(R.id.tabView);
        d();
    }
}
