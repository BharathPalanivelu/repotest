package com.shopee.app.ui.home.me.v3.feature.b;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {

    /* renamed from: f  reason: collision with root package name */
    private boolean f22603f = false;

    /* renamed from: g  reason: collision with root package name */
    private final c f22604g = new c();

    public g(Context context) {
        super(context);
        a();
    }

    public static f a(Context context) {
        g gVar = new g(context);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.f22603f) {
            this.f22603f = true;
            inflate(getContext(), R.layout.me_my_sale_view, this);
            this.f22604g.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f22604g);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22598a = (OptionRow) aVar.internalFindViewById(R.id.btnMySale);
        this.f22599b = (OptionBox) aVar.internalFindViewById(R.id.btnToShip);
        this.f22600c = (OptionBox) aVar.internalFindViewById(R.id.btnToCancelled);
        this.f22601d = (OptionBox) aVar.internalFindViewById(R.id.btnToRefund);
        this.f22602e = (OptionBox) aVar.internalFindViewById(R.id.btnOnMore);
    }
}
