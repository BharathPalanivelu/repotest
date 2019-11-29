package com.shopee.app.ui.home.a;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.common.h;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class i extends h implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f22049b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f22050c = new c();

    public i(Context context) {
        super(context);
        b();
    }

    public static h a(Context context) {
        i iVar = new i(context);
        iVar.onFinishInflate();
        return iVar;
    }

    public void onFinishInflate() {
        if (!this.f22049b) {
            this.f22049b = true;
            inflate(getContext(), R.layout.activity_promotion_layout, this);
            this.f22050c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f22050c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22048a = (h) aVar.internalFindViewById(R.id.banner);
        a();
    }
}
