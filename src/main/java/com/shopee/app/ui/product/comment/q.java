package com.shopee.app.ui.product.comment;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class q extends p implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f24574e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f24575f = new c();

    public q(Context context, int i, long j, int i2) {
        super(context, i, j, i2);
        b();
    }

    public static p a(Context context, int i, long j, int i2) {
        q qVar = new q(context, i, j, i2);
        qVar.onFinishInflate();
        return qVar;
    }

    public void onFinishInflate() {
        if (!this.f24574e) {
            this.f24574e = true;
            inflate(getContext(), R.layout.material_tab_layout, this);
            this.f24575f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f24575f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24563a = (MaterialTabView) aVar.internalFindViewById(R.id.tabView);
        a();
    }
}
