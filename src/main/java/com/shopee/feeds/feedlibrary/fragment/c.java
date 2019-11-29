package com.shopee.feeds.feedlibrary.fragment;

import android.os.Bundle;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.c;

public class c extends BaseProductFragment {
    public String c() {
        return "kol_like_product";
    }

    public static c a(int i, int i2) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", i);
        bundle.putInt("select_type", i2);
        cVar.setArguments(bundle);
        return cVar;
    }

    public void d() {
        this.mTvNoData.setText(b.e(c.g.feeds_my_favorite_products_no_data_tips));
    }
}
