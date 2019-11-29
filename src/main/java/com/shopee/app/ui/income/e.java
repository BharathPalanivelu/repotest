package com.shopee.app.ui.income;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f23178c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f23179d = new c();

    public e(Context context, int i) {
        super(context, i);
        b();
    }

    public static d a(Context context, int i) {
        e eVar = new e(context, i);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.f23178c) {
            this.f23178c = true;
            inflate(getContext(), R.layout.my_income_layout, this);
            this.f23179d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f23179d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23170a = (MaterialTabView) aVar.internalFindViewById(R.id.tabView);
        a();
    }
}
