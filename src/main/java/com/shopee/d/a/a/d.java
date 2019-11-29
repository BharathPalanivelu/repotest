package com.shopee.d.a.a;

import com.shopee.shopeetracker.ShopeeTracker;
import com.shopee.shopeetracker.bimodel.TrackingMeta;
import com.shopee.shopeetracker.model.UserAction;
import com.shopee.shopeetracker.utils.GsonUtils;
import com.shopee.shopeetracker.utils.NetworkUtils;

public class d extends UserAction {

    /* renamed from: a  reason: collision with root package name */
    private String f27122a;

    public int getType() {
        return 3;
    }

    public d(c cVar) {
        super(0);
        TrackingMeta trackingMeta = ShopeeTracker.getInstance().getTrackingMeta();
        b bVar = new b();
        bVar.f27115a = "v1";
        bVar.f27118d = trackingMeta.userid;
        bVar.f27119e = trackingMeta.finger_print;
        bVar.f27120f = trackingMeta.locale;
        bVar.f27121g = trackingMeta.platform;
        bVar.h = Integer.valueOf(NetworkUtils.getNetWorkStatus(ShopeeTracker.getInstance().getContext()));
        bVar.i = trackingMeta.os;
        bVar.j = trackingMeta.os_version;
        bVar.k = trackingMeta.brand;
        bVar.l = trackingMeta.model;
        bVar.m = trackingMeta.app_version;
        bVar.n = Integer.valueOf(trackingMeta.appId);
        bVar.o = Integer.valueOf(cVar.a());
        bVar.p = cVar;
        this.f27122a = GsonUtils.toJson(bVar, false);
    }

    public String getActionData() {
        return this.f27122a;
    }
}
