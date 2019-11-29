package com.shopee.app.d.c;

import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.b.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.af;
import com.shopee.app.data.store.ba;
import com.shopee.app.data.store.m;
import com.shopee.app.network.d.b;
import com.shopee.app.network.d.o;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemModel;
import java.util.List;

public class el extends dd {
    /* access modifiers changed from: protected */
    public String d() {
        return "ValidateProductInteractor";
    }

    protected el(n nVar, m mVar, ba baVar, af afVar, SettingConfigStore settingConfigStore, UserInfo userInfo, a aVar) {
        super(nVar, baVar, mVar, afVar, settingConfigStore, userInfo, aVar);
    }

    /* access modifiers changed from: protected */
    public void a(Item item, MediaData mediaData, List<ItemModel> list, ba baVar, boolean z) {
        if (item.itemid.longValue() > 0) {
            o a2 = o.a(item, list, this.f16786c.showProductWeight(), z);
            a2.h();
            a2.g();
            return;
        }
        b bVar = new b(item, list, true, this.f16786c.showProductWeight(), z);
        bVar.h();
        bVar.g();
    }
}
