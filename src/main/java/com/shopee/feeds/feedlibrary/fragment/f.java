package com.shopee.feeds.feedlibrary.fragment;

import android.os.Bundle;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import java.util.ArrayList;

public class f extends BaseTagProductFragment {
    public String b() {
        return "seller_product";
    }

    public static f a(int i, int i2, ArrayList<ProductEntity.ProductItem> arrayList) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", i);
        bundle.putInt("select_type", i2);
        bundle.putSerializable("list", arrayList);
        fVar.setArguments(bundle);
        return fVar;
    }

    public void c() {
        this.tvNoData.setText(b.e(c.g.feeds_my_products_no_data_tips));
    }
}
