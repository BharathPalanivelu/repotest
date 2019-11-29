package com.shopee.app.ui.follow.following;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.common.ac;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class q extends p implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f21664b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f21665c = new c();

    public q(Context context) {
        super(context);
        a();
    }

    public static p a(Context context) {
        q qVar = new q(context);
        qVar.onFinishInflate();
        return qVar;
    }

    public void onFinishInflate() {
        if (!this.f21664b) {
            this.f21664b = true;
            inflate(getContext(), R.layout.activity_promotion_item_view, this);
            this.f21665c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f21665c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21663a = (ac) aVar.internalFindViewById(R.id.banner);
    }
}
