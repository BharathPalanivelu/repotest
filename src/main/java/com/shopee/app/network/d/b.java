package com.shopee.app.network.d;

import com.shopee.app.network.g;
import com.shopee.protocol.action.AddItem;
import com.shopee.protocol.action.AdditionalDetail;
import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemModel;
import com.squareup.wire.Message;
import java.util.List;

public class b extends az implements com.shopee.app.network.a.b {

    /* renamed from: a  reason: collision with root package name */
    private Item f18139a;

    /* renamed from: b  reason: collision with root package name */
    private List<ItemModel> f18140b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18141c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18142d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18143e = false;

    public int b() {
        return 1;
    }

    public b(Item item, List<ItemModel> list, boolean z, boolean z2, boolean z3) {
        this.f18139a = item;
        this.f18140b = list;
        this.f18141c = z;
        this.f18142d = z2;
        this.f18143e = z3;
    }

    public b(g gVar, Item item, List<ItemModel> list, boolean z, boolean z2) {
        super(gVar);
        this.f18139a = item;
        this.f18140b = list;
        this.f18142d = z;
        this.f18143e = z2;
    }

    public boolean c() {
        return this.f18141c;
    }

    public Message q_() {
        AdditionalDetail build = new AdditionalDetail.Builder().app_version("2.46.06").source("Android").build();
        AddItem.Builder builder = new AddItem.Builder();
        builder.requestid(i().a()).item(this.f18139a).item_level_shipping(Boolean.valueOf(this.f18142d)).unlist_item(Boolean.valueOf(this.f18143e)).model(this.f18140b).additional_detail(build);
        if (this.f18141c) {
            builder.only_check(true);
        }
        return builder.build();
    }
}
