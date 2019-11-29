package com.shopee.app.ui.product.search;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.ui.a.n;
import com.shopee.id.R;

public class r extends RelativeLayout implements n<SearchProductItem> {

    /* renamed from: a  reason: collision with root package name */
    TextView f24874a;

    /* renamed from: b  reason: collision with root package name */
    TextView f24875b;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public r(Context context) {
        super(context);
    }

    public void a(SearchProductItem searchProductItem) {
        this.f24874a.setText(b.e(R.string.sp_label_shops));
        if (searchProductItem.getExtra() != null) {
            this.f24875b.setVisibility(((Boolean) searchProductItem.getExtra()).booleanValue() ? 0 : 8);
        }
    }
}
