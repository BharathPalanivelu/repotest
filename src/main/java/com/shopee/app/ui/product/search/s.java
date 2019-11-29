package com.shopee.app.ui.product.search;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class s extends r implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f24876c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f24877d = new c();

    public s(Context context) {
        super(context);
        b();
    }

    public static r a(Context context) {
        s sVar = new s(context);
        sVar.onFinishInflate();
        return sVar;
    }

    public void onFinishInflate() {
        if (!this.f24876c) {
            this.f24876c = true;
            inflate(getContext(), R.layout.search_user_instead_item_layout, this);
            this.f24877d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f24877d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24874a = (TextView) aVar.internalFindViewById(R.id.label);
        this.f24875b = (TextView) aVar.internalFindViewById(R.id.view_more);
        a();
    }
}
