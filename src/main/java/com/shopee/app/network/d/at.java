package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.util.af;
import com.shopee.protocol.action.GetUserBrief;
import java.util.List;

public class at extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<Integer> f18125a;

    /* renamed from: b  reason: collision with root package name */
    private List<Integer> f18126b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18127c;

    public void a(List<Integer> list, List<Integer> list2) {
        a(list, list2, true);
    }

    public void a(List<Integer> list) {
        a(list, (List<Integer>) null, true);
    }

    public void a(List<Integer> list, List<Integer> list2, boolean z) {
        this.f18125a = list;
        this.f18126b = list2;
        this.f18127c = z;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetUserBrief.Builder builder = new GetUserBrief.Builder();
        builder.requestid(i().a());
        if (!af.a(this.f18125a)) {
            builder.userid(this.f18125a);
        }
        if (!af.a(this.f18126b)) {
            builder.shopid(this.f18126b);
        }
        builder.need_deleted(Boolean.valueOf(this.f18127c));
        return new f(39, builder.build().toByteArray());
    }
}
