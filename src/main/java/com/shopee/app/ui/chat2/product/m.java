package com.shopee.app.ui.chat2.product;

import android.content.Context;
import android.view.View;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.ui.a.s;

public class m implements s<ItemDetail> {
    public int a() {
        return 2;
    }

    public int a(ItemDetail itemDetail, int i) {
        return itemDetail.getShopId();
    }

    public View a(Context context, int i) {
        if (i != -2) {
            return r.a(context, true);
        }
        return b.a(context);
    }
}
