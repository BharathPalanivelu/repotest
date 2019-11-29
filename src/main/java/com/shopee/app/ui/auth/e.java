package com.shopee.app.ui.auth;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f19523e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f19524f = new c();

    public e(Context context, String str, String str2) {
        super(context, str, str2);
        f();
    }

    public static d a(Context context, String str, String str2) {
        e eVar = new e(context, str, str2);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.f19523e) {
            this.f19523e = true;
            inflate(getContext(), R.layout.auth_tab_layout, this);
            this.f19524f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void f() {
        c a2 = c.a(this.f19524f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19516a = (MaterialTabView) aVar.internalFindViewById(R.id.tab_view);
        a();
    }
}
