package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.facebook.imageutils.JfifUtil;
import com.shopee.protocol.action.CheckUserBlocked;
import java.util.List;

public class k extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<Integer> f18428a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18429b;

    public void a(List<Integer> list, boolean z) {
        this.f18428a = list;
        this.f18429b = z;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        CheckUserBlocked.Builder builder = new CheckUserBlocked.Builder();
        builder.requestid(i().a()).userid(this.f18428a).reverse(Boolean.valueOf(this.f18429b)).build();
        return new f(JfifUtil.MARKER_RST0, builder.build().toByteArray());
    }
}
