package com.shopee.app.ui.customer.list;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {

    /* renamed from: d  reason: collision with root package name */
    private boolean f21399d = false;

    /* renamed from: e  reason: collision with root package name */
    private final org.a.a.b.c f21400e = new org.a.a.b.c();

    public c(Context context) {
        super(context);
        a();
    }

    public static b a(Context context) {
        c cVar = new c(context);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.f21399d) {
            this.f21399d = true;
            inflate(getContext(), R.layout.my_customer_item_layout, this);
            this.f21400e.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.f21400e);
        org.a.a.b.c.a((b) this);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21396a = (TextView) aVar.internalFindViewById(R.id.username);
        this.f21397b = (TextView) aVar.internalFindViewById(R.id.nickname);
        this.f21398c = (AvatarView) aVar.internalFindViewById(R.id.avatar);
    }
}
