package com.shopee.app.ui.home.me.v3.feature;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.home.me.v3.NotificationRow;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f22617g = false;
    private final org.a.a.b.c h = new org.a.a.b.c();

    public c(Context context) {
        super(context);
        e();
    }

    public static b a(Context context) {
        c cVar = new c(context);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.f22617g) {
            this.f22617g = true;
            inflate(getContext(), R.layout.me_tab_buyer_view_4, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.h);
        org.a.a.b.c.a((b) this);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22582a = (NotificationRow) aVar.internalFindViewById(R.id.notification_row);
        this.f22583b = (MeFeatureRecyclerView) aVar.internalFindViewById(R.id.recycler_view);
        a();
    }
}
