package com.shopee.app.ui.product.search;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.ui.a.n;
import com.shopee.id.R;

public class f extends RelativeLayout implements n<SearchProductItem> {

    /* renamed from: a  reason: collision with root package name */
    TextView f24830a;

    public f(Context context) {
        super(context);
        setBackgroundResource(R.drawable.bg_color_background_highlight);
    }

    public void a(SearchProductItem searchProductItem) {
        this.f24830a.setText(searchProductItem.getKeyword());
    }
}
