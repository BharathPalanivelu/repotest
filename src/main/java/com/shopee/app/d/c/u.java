package com.shopee.app.d.c;

import android.util.Pair;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.b;
import com.shopee.app.data.store.bb;
import com.shopee.app.data.store.c;
import com.shopee.app.data.viewmodel.ActionContentInfo;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.database.orm.bean.DBActionContent;
import com.shopee.app.ui.actionbox2.d;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class u extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final c f17122d;

    /* renamed from: e  reason: collision with root package name */
    private final ActionRequiredCounter f17123e;

    /* renamed from: f  reason: collision with root package name */
    private final bb f17124f;

    /* renamed from: g  reason: collision with root package name */
    private final b f17125g;

    protected u(n nVar, c cVar, b bVar, ActionRequiredCounter actionRequiredCounter, bb bbVar) {
        super(nVar);
        this.f17122d = cVar;
        this.f17125g = bVar;
        this.f17123e = actionRequiredCounter;
        this.f17124f = bbVar;
    }

    public void a(int i, HashMap<Long, d.a> hashMap) {
        b(new a(i, hashMap));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        List<Long> c2 = this.f17125g.c(aVar.f17126a);
        List<DBActionContent> b2 = this.f17122d.b(c2);
        Set<Pair<Long, Integer>> ids = this.f17123e.getIds();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (DBActionContent next : b2) {
            hashMap.put(Long.valueOf(next.b()), next);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Long next2 : c2) {
            if (hashMap.containsKey(next2)) {
                ActionContentInfo actionContentInfo = new ActionContentInfo();
                com.shopee.app.d.b.b.a((DBActionContent) hashMap.get(next2), actionContentInfo, this.f17124f);
                boolean z = false;
                if (ids.contains(new Pair(Long.valueOf(actionContentInfo.getUnreadId()), Integer.valueOf(aVar.f17126a)))) {
                    actionContentInfo.setUnread(true);
                } else {
                    actionContentInfo.setUnread(false);
                }
                if (!arrayList2.contains(next2)) {
                    if (actionContentInfo.getGroupedCount() > 1) {
                        z = true;
                    }
                    actionContentInfo.setHasChild(z);
                    arrayList.add(actionContentInfo);
                    arrayList2.add(next2);
                }
                long groupId = actionContentInfo.getGroupId();
                if (aVar.f17127b.containsKey(Long.valueOf(groupId))) {
                    d.a aVar2 = aVar.f17127b.get(Long.valueOf(groupId));
                    List arrayList3 = aVar2.f19386a == null ? new ArrayList() : aVar2.f19386a;
                    arrayList3.remove(actionContentInfo);
                    actionContentInfo.setChildActions(arrayList3);
                    actionContentInfo.setExpanded(aVar2.f19387b);
                }
            }
        }
        this.f16405a.a().bX.a(new Pair(arrayList, aVar)).a();
    }

    public static class a extends a.C0253a {

        /* renamed from: a  reason: collision with root package name */
        public final int f17126a;

        /* renamed from: b  reason: collision with root package name */
        public final HashMap<Long, d.a> f17127b;

        public a(int i, HashMap<Long, d.a> hashMap) {
            super("GetActionRequiredInteractor" + i, "use_case2", 400, true);
            this.f17126a = i;
            this.f17127b = hashMap;
        }
    }
}
