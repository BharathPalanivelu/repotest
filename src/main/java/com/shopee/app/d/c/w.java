package com.shopee.app.d.c;

import android.util.Pair;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.g.b;
import com.shopee.app.util.n;
import java.util.List;

public class w extends a<b.a> {

    /* renamed from: d  reason: collision with root package name */
    private final n f17133d;

    /* renamed from: e  reason: collision with root package name */
    private b f17134e;

    public w(n nVar, b bVar) {
        super(nVar);
        this.f17133d = nVar;
        this.f17134e = bVar;
    }

    public void a(int i) {
        b(b.a.a(i));
    }

    public void a() {
        b(b.a.a());
    }

    /* access modifiers changed from: protected */
    public void a(b.a aVar) {
        List<ActivityItemInfo> a2 = this.f17134e.a(aVar);
        this.f17133d.a("ACTIVITY_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(new Pair(Integer.valueOf(aVar.f17474a), a2)));
        if (aVar.f17475b) {
            this.f17133d.a("ACTIVITY_LIST_LOCAL_PROBE", new com.garena.android.appkit.b.a(a2));
        }
    }
}
