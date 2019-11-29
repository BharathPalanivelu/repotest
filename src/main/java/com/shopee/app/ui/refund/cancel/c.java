package com.shopee.app.ui.refund.cancel;

import android.content.Context;
import android.widget.FrameLayout;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.ui.refund.b;
import com.shopee.app.ui.refund.detail.RefundDetailActivity_;
import com.shopee.app.ui.setting.cell.a;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;

public class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    a f24948a;

    /* renamed from: b  reason: collision with root package name */
    a f24949b;

    /* renamed from: c  reason: collision with root package name */
    b f24950c;

    /* renamed from: d  reason: collision with root package name */
    bc f24951d;

    /* renamed from: e  reason: collision with root package name */
    private final long f24952e;

    /* renamed from: f  reason: collision with root package name */
    private final int f24953f;

    public void a(OrderDetail orderDetail) {
    }

    public c(Context context, long j, int i) {
        super(context);
        this.f24952e = j;
        this.f24953f = i;
        ((b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24951d.a(this.f24950c);
        this.f24950c.a(this);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        RefundDetailActivity_.a(getContext()).a();
    }
}
