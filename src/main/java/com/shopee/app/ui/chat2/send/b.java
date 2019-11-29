package com.shopee.app.ui.chat2.send;

import android.content.Context;
import android.view.View;
import com.garena.android.uikit.grid.GGridView;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f20926e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f20927f = new c();

    public b(Context context, ShopDetail shopDetail, boolean z) {
        super(context, shopDetail, z);
        b();
    }

    public static a a(Context context, ShopDetail shopDetail, boolean z) {
        b bVar = new b(context, shopDetail, z);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.f20926e) {
            this.f20926e = true;
            inflate(getContext(), R.layout.chat_send_option_view, this);
            this.f20927f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f20927f);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20916a = (GGridView) aVar.internalFindViewById(R.id.gridView);
        a();
    }
}
