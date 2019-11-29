package com.shopee.app.d.c;

import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.b;
import com.shopee.app.data.store.c;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.database.orm.bean.DBActionContent;
import com.shopee.app.g.b;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import java.util.List;

public class bv extends a<a.C0253a> {

    /* renamed from: d  reason: collision with root package name */
    private c f16634d;

    /* renamed from: e  reason: collision with root package name */
    private b f16635e;

    /* renamed from: f  reason: collision with root package name */
    private com.shopee.app.g.b f16636f;

    protected bv(n nVar, c cVar, b bVar, com.shopee.app.g.b bVar2) {
        super(nVar);
        this.f16634d = cVar;
        this.f16635e = bVar;
        this.f16636f = bVar2;
    }

    public void a() {
        b(new a.C0253a("GetShopUpdatesInteractor", "use_case", 500, true));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0253a aVar) {
        long a2 = this.f16635e.a(2);
        DBActionContent a3 = a2 != -1 ? this.f16634d.a(a2) : null;
        List<ActivityItemInfo> a4 = this.f16636f.a(b.a.a());
        if (a3 != null && !af.a(a4)) {
            ActivityItemInfo activityItemInfo = a4.get(0);
            if (a3.f() > activityItemInfo.getCreateTime()) {
                a(new String(a3.c()));
            } else {
                a(activityItemInfo.wrapMsg());
            }
        } else if (a3 != null) {
            a(new String(a3.c()));
        } else if (!af.a(a4)) {
            a(a4.get(0).wrapMsg());
        }
    }

    private void a(String str) {
        this.f16405a.a("GET_SHOP_UPDATES_NOTIFICATION_INFO", new com.garena.android.appkit.b.a(str));
    }
}
