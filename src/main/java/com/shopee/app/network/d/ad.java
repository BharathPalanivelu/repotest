package com.shopee.app.network.d;

import android.util.Pair;
import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetItemBatch;
import com.shopee.protocol.action.ResponseRecUsers;
import com.shopee.protocol.action.ShopItemId;
import java.util.ArrayList;
import java.util.List;

public class ad extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<ShopItemId> f18083a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private ResponseRecUsers f18084b;

    public void a(List<Pair<Integer, Long>> list) {
        for (Pair next : list) {
            this.f18083a.add(new ShopItemId.Builder().shopid((Integer) next.first).itemid((Long) next.second).build());
        }
        g();
    }

    public void a(List<ShopItemId> list, ResponseRecUsers responseRecUsers) {
        this.f18083a = list;
        this.f18084b = responseRecUsers;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetItemBatch.Builder builder = new GetItemBatch.Builder();
        builder.requestid(i().a()).need_deleted_items(true).idlist(this.f18083a).need_deleted_items(true);
        return new f(94, builder.build().toByteArray());
    }

    public ResponseRecUsers b() {
        return this.f18084b;
    }
}
