package com.shopee.app.ui.home.chat;

import android.content.Context;
import android.widget.FrameLayout;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.tracking.trackingv3.model.ViewCommon;
import com.shopee.app.ui.a.a;
import com.shopee.app.ui.actionbox2.f;
import com.shopee.app.ui.actionbox2.g;
import com.shopee.app.ui.home.e;
import com.shopee.app.util.x;

public class ChatTab extends a {

    /* renamed from: a  reason: collision with root package name */
    FrameLayout f22141a;

    /* renamed from: b  reason: collision with root package name */
    com.shopee.app.tracking.a f22142b;

    /* renamed from: c  reason: collision with root package name */
    b f22143c;

    /* renamed from: d  reason: collision with root package name */
    private String f22144d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22145e;

    /* renamed from: f  reason: collision with root package name */
    private f f22146f;

    public ChatTab(Context context) {
        super(context);
        ((e) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f22146f = g.a(getContext(), 4);
        this.f22141a.addView(this.f22146f);
        this.f22144d = String.valueOf(System.currentTimeMillis());
        this.f22145e = true;
    }

    public void a() {
        super.a();
        this.f22146f.m();
        this.f22142b.a(this.f22144d, getClass().getSimpleName(), this.f22145e, "");
        b bVar = this.f22143c;
        boolean z = this.f22145e;
        bVar.a("notifications", new ViewCommon(z, !z, this.f22144d), b.f19172a);
        if (this.f22145e) {
            this.f22145e = false;
        }
    }

    public void b() {
        super.b();
        this.f22146f.n();
    }
}
