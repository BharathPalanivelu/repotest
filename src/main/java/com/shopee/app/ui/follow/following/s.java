package com.shopee.app.ui.follow.following;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.common.h;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class s extends r implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f21727b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f21728c = new c();

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
        if (!this.f21727b) {
            this.f21727b = true;
            inflate(getContext(), R.layout.activity_promotion_layout, this);
            this.f21728c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f21728c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21666a = (h) aVar.internalFindViewById(R.id.banner);
        a();
    }
}
