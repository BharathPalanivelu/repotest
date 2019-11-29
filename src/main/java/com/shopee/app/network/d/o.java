package com.shopee.app.network.d;

import com.garena.android.appkit.d.a;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.network.a.b;
import com.shopee.app.util.af;
import com.shopee.protocol.action.AdditionalDetail;
import com.shopee.protocol.action.EditItem;
import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemExtInfo;
import com.shopee.protocol.shop.ItemModel;
import com.squareup.wire.Message;
import e.f;
import java.util.ArrayList;
import java.util.List;

public class o extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private Item f18435a;

    /* renamed from: b  reason: collision with root package name */
    private int f18436b;

    /* renamed from: c  reason: collision with root package name */
    private List<ItemModel> f18437c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f18438d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18439e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18440f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18441g = false;
    private boolean h = false;

    public int b() {
        return 2;
    }

    public static o a(ItemDetail itemDetail) {
        return new o(itemDetail, false);
    }

    public static o b(ItemDetail itemDetail) {
        return new o(itemDetail, true);
    }

    public static o a(Item item, List<ItemModel> list, boolean z, boolean z2) {
        return new o(item, list, z, z2, true);
    }

    private o(Item item, List<ItemModel> list, boolean z, boolean z2, boolean z3) {
        this.f18435a = item;
        this.f18437c = list;
        this.f18439e = z;
        this.f18438d = true;
        this.f18440f = z2;
        this.h = z3;
    }

    private o(ItemDetail itemDetail, boolean z) {
        this.f18435a = new Item.Builder().itemid(Long.valueOf(itemDetail.getId())).shopid(Integer.valueOf(itemDetail.getShopId())).extinfo(f.a(itemDetail.getExtendedInfo())).build();
        this.f18440f = z;
        this.f18441g = true;
        this.f18439e = true;
    }

    public o(Item item, int i, boolean z) {
        this.f18435a = item;
        this.f18436b = i;
        this.f18439e = z;
        this.f18438d = false;
    }

    public o(Item item, List<ItemModel> list, boolean z, boolean z2) {
        this.f18435a = item;
        this.f18437c = list;
        this.f18439e = z;
        this.f18438d = true;
        this.f18440f = z2;
    }

    public o(Item item, List<ItemModel> list, int i, boolean z) {
        this.f18435a = item;
        this.f18437c = list;
        this.f18436b = i;
        this.f18439e = z;
        this.f18438d = true;
    }

    public Item c() {
        return this.f18435a;
    }

    public int d() {
        return this.f18436b;
    }

    public Message q_() {
        AdditionalDetail build = new AdditionalDetail.Builder().app_version("2.46.06").source("Android").build();
        EditItem.Builder builder = new EditItem.Builder();
        builder.requestid(i().a()).unlist_item(Boolean.valueOf(this.f18440f)).item_level_shipping(Boolean.valueOf(this.f18439e)).only_check(Boolean.valueOf(this.h)).item(this.f18435a).additional_detail(build);
        if (!this.f18441g) {
            boolean z = false;
            try {
                z = af.a(((ItemExtInfo) com.shopee.app.network.f.f18486a.parseFrom(this.f18435a.extinfo.i(), ItemExtInfo.class)).video_info_list);
            } catch (Exception e2) {
                a.a(e2);
            }
            builder.update_wholesale(true).update_tier(true).remove_videos(Boolean.valueOf(z)).update_model(Boolean.valueOf(this.f18438d));
        }
        if (!af.a(this.f18437c)) {
            builder.model(this.f18437c);
        }
        return builder.build();
    }

    public boolean e() {
        return this.h;
    }
}
