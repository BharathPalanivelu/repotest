package com.shopee.app.network.c.e.b;

import android.util.Pair;
import com.shopee.app.network.d.d.a.a;
import com.shopee.app.util.n;
import com.shopee.protocol.search.action.ResponseSearchItem;
import com.shopee.protocol.search.action.ResultItem;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final n f17901a;

    public b(n nVar) {
        this.f17901a = nVar;
    }

    public void a(a aVar, ResponseSearchItem responseSearchItem) {
        List<ResultItem> arrayList = responseSearchItem.item != null ? responseSearchItem.item : new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (ResultItem resultItem : arrayList) {
            arrayList2.add(new Pair(Integer.valueOf(com.shopee.app.d.b.b.a(resultItem.shopid)), Long.valueOf(com.shopee.app.d.b.b.a(resultItem.itemid))));
        }
        this.f17901a.a().R.a(new Pair(aVar, arrayList2)).a();
    }
}
