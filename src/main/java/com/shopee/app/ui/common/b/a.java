package com.shopee.app.ui.common.b;

import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.Cdo;
import com.shopee.app.d.c.as;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.network.d.ax;
import com.shopee.app.ui.a.q;
import com.shopee.id.R;

public class a extends q<c> {

    /* renamed from: a  reason: collision with root package name */
    private final as f21227a;

    /* renamed from: c  reason: collision with root package name */
    private final Cdo f21228c;

    /* renamed from: d  reason: collision with root package name */
    private final i f21229d = b.a(this);

    public a(as asVar, Cdo doVar) {
        this.f21227a = asVar;
        this.f21228c = doVar;
    }

    public void a() {
        this.f21229d.a();
    }

    public void d() {
        super.d();
        this.f21229d.d();
    }

    public void b() {
        this.f21229d.b();
    }

    public void c() {
        super.c();
        this.f21229d.c();
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

    public void a(ItemDetail itemDetail, int i, long j, long j2, int i2) {
        this.f21228c.a(0, itemDetail.getId(), j2, itemDetail.getShopId(), i2, j, i, 1, 0, itemDetail);
    }

    public void a(long j, int i) {
        this.f21227a.a(j);
        new ax(i, j).g();
    }
}
