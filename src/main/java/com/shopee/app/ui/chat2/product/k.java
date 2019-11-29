package com.shopee.app.ui.chat2.product;

import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.au;
import com.shopee.app.d.c.be;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.ae;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class k extends q<h> implements ae.a {

    /* renamed from: a  reason: collision with root package name */
    private final i f20810a = b.a(this);

    /* renamed from: c  reason: collision with root package name */
    private final n f20811c;

    /* renamed from: d  reason: collision with root package name */
    private int f20812d;

    /* renamed from: e  reason: collision with root package name */
    private final int f20813e;

    /* renamed from: f  reason: collision with root package name */
    private int f20814f;

    /* renamed from: g  reason: collision with root package name */
    private final au f20815g;
    private final be h;

    public void d(int i) {
    }

    public k(n nVar, UserInfo userInfo, be beVar, au auVar) {
        this.f20811c = nVar;
        this.f20813e = userInfo.getShopId();
        this.f20815g = auVar;
        this.h = beVar;
    }

    public void a() {
        this.f20810a.a();
    }

    public void b() {
        this.f20810a.b();
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<Integer, List<ItemDetail>> pair) {
        if (((Integer) pair.first).equals(1) && this.f20814f == 0) {
            ((h) this.f19220b).a((List) pair.second);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Pair<Integer, List<ItemDetail>> pair) {
        if (((Integer) pair.first).intValue() == this.f20812d && this.f20814f == 1) {
            ArrayList<ItemDetail> arrayList = new ArrayList<>((Collection) pair.second);
            ArrayList arrayList2 = new ArrayList();
            for (ItemDetail itemDetail : arrayList) {
                if (itemDetail.getShopId() > 0) {
                    arrayList2.add(itemDetail);
                }
                if (arrayList2.size() > 5) {
                    break;
                }
            }
            ((h) this.f19220b).a(arrayList2);
        }
    }
}
