package com.shopee.feeds.feedlibrary.fragment;

import android.os.Bundle;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.c;

public class d extends BaseProductFragment {
    public String c() {
        return "seller_product";
    }

    public static d a(int i, int i2) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", i);
        bundle.putInt("select_type", i2);
        dVar.setArguments(bundle);
        return dVar;
    }

    public void d() {
        this.mTvNoData.setText(b.e(c.g.feeds_my_products_no_data_tips));
    }
}
