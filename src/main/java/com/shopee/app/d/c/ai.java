package com.shopee.app.d.c;

import android.util.Pair;
import com.shopee.app.d.b.b;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.bb;
import com.shopee.app.data.store.c;
import com.shopee.app.data.viewmodel.ActionContentInfo;
import com.shopee.app.database.orm.bean.DBActionContent;
import com.shopee.app.database.orm.bean.DBActionGroup;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ai extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final com.shopee.app.data.store.a f16458d;

    /* renamed from: e  reason: collision with root package name */
    private final c f16459e;

    /* renamed from: f  reason: collision with root package name */
    private final bb f16460f;

    public ai(n nVar, c cVar, bb bbVar, com.shopee.app.data.store.a aVar) {
        super(nVar);
        this.f16459e = cVar;
        this.f16458d = aVar;
        this.f16460f = bbVar;
    }

    public void a(long j) {
        b(new a(j));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        ArrayList arrayList = new ArrayList();
        List<DBActionGroup> b2 = this.f16458d.b(Collections.singletonList(Long.valueOf(aVar.f16462a)));
        if (!af.a(b2)) {
            List<Long> list = (List) WebRegister.GSON.a(b2.get(0).a(), new com.google.a.c.a<List<Long>>() {
            }.getType());
            List<DBActionContent> b3 = this.f16459e.b(list);
            HashMap hashMap = new HashMap();
            for (DBActionContent next : b3) {
                hashMap.put(Long.valueOf(next.b()), next);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Long l : list) {
                if (hashMap.containsKey(l)) {
                    ActionContentInfo actionContentInfo = new ActionContentInfo();
                    b.a((DBActionContent) hashMap.get(l), actionContentInfo, this.f16460f);
                    if (!arrayList2.contains(l)) {
                        actionContentInfo.setHasParent(true);
                        arrayList.add(actionContentInfo);
                        arrayList2.add(l);
                    }
                }
            }
        }
        this.f16405a.a("CHILD_ACTION_CONTENT_LOAD", new com.garena.android.appkit.b.a(new Pair(arrayList, Long.valueOf(aVar.f16462a))));
    }

    static class a extends a.C0253a {

        /* renamed from: a  reason: collision with root package name */
        final long f16462a;

        a(long j) {
            super("GetActionRequiredInteractor" + j, "use_case2", 400, true);
            this.f16462a = j;
        }
    }
}
