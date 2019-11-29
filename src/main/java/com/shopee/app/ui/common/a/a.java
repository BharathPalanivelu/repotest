package com.shopee.app.ui.common.a;

import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.as;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.network.d.ax;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.dialog.g;
import com.shopee.app.util.af;
import com.shopee.app.util.au;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.app.web.protocol.WholesaleTier;
import com.shopee.id.R;
import java.util.List;

public class a extends q<c> implements g.b {

    /* renamed from: a  reason: collision with root package name */
    private AddCartMessage f21058a;

    /* renamed from: c  reason: collision with root package name */
    private final as f21059c;

    /* renamed from: d  reason: collision with root package name */
    private final i f21060d = b.a(this);

    public a(as asVar) {
        this.f21059c = asVar;
    }

    public void a(AddCartMessage addCartMessage) {
        this.f21058a = addCartMessage;
    }

    public void a() {
        this.f21060d.a();
    }

    public void d() {
        super.d();
        this.f21060d.d();
    }

    public void b() {
        this.f21060d.b();
    }

    public void c() {
        super.c();
        this.f21060d.c();
    }

    /* access modifiers changed from: package-private */
    public void a(ItemDetail itemDetail) {
        ((c) this.f19220b).a(itemDetail);
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        String str;
        if (i != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        ((c) this.f19220b).a(str);
    }

    public void a(long j, int i) {
        this.f21059c.a(j);
        new ax(i, j).g();
    }

    public void b(int i) {
        AddCartMessage addCartMessage = this.f21058a;
        if (addCartMessage != null && addCartMessage.isCanUseWholesale() && !af.a(this.f21058a.getWholesaleTiers())) {
            long c2 = c(i);
            ((c) this.f19220b).setPrice(au.b(c2));
            if (c2 != this.f21058a.price) {
                ((c) this.f19220b).f();
            } else {
                ((c) this.f19220b).g();
            }
        }
    }

    private long c(int i) {
        List<WholesaleTier> wholesaleTiers = this.f21058a.getWholesaleTiers();
        for (int size = wholesaleTiers.size() - 1; size >= 0; size--) {
            WholesaleTier wholesaleTier = wholesaleTiers.get(size);
            if (i >= wholesaleTier.min) {
                return wholesaleTier.price;
            }
        }
        return this.f21058a.price;
    }
}
