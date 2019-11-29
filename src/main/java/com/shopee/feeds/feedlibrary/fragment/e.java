package com.shopee.feeds.feedlibrary.fragment;

import android.os.Bundle;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import java.util.ArrayList;

public class e extends BaseTagProductFragment {
    public String b() {
        return "kol_like_product";
    }

    public static e a(int i, int i2, ArrayList<ProductEntity.ProductItem> arrayList) {
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", i);
        bundle.putInt("select_type", i2);
        bundle.putSerializable("list", arrayList);
        eVar.setArguments(bundle);
        return eVar;
    }

    public void c() {
        this.tvNoData.setText(b.e(c.g.feeds_my_favorite_products_no_data_tips));
    }
}
