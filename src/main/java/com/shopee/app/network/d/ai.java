package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetOfferCount;
import com.tencent.qalsdk.im_open.http;
import java.util.List;

public class ai extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18098a;

    /* renamed from: b  reason: collision with root package name */
    private List<Integer> f18099b;

    public void a(int i, List<Integer> list) {
        this.f18098a = i;
        this.f18099b = list;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetOfferCount.Builder builder = new GetOfferCount.Builder();
        builder.requestid(i().a()).offer_status(Integer.valueOf(this.f18098a)).userid(this.f18099b).build();
        return new f(http.No_Content, builder.build().toByteArray());
    }
}
