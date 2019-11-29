package com.shopee.app.ui.order.search;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class k extends j implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f23827e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f23828f = new c();

    public k(Context context) {
        super(context);
        a();
    }

    public static j a(Context context) {
        k kVar = new k(context);
        kVar.onFinishInflate();
        return kVar;
    }

    public void onFinishInflate() {
        if (!this.f23827e) {
            this.f23827e = true;
            inflate(getContext(), R.layout.search_orders_item_user_view, this);
            this.f23828f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f23828f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23823a = (TextView) aVar.internalFindViewById(R.id.username);
        this.f23824b = (TextView) aVar.internalFindViewById(R.id.usernameUp);
        this.f23825c = (ImageView) aVar.internalFindViewById(R.id.avatar);
        this.f23826d = (TextView) aVar.internalFindViewById(R.id.nickname);
    }
}
