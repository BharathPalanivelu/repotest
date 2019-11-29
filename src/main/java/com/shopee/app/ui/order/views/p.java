package com.shopee.app.ui.order.views;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.util.ae;
import com.shopee.id.R;
import java.util.List;

public class p extends RelativeLayout implements ae.b {

    /* renamed from: a  reason: collision with root package name */
    TextView f23916a;

    /* renamed from: b  reason: collision with root package name */
    private List<Long> f23917b;

    public p(Context context) {
        super(context);
    }

    public void setViewMoreCount(int i) {
        String str;
        if (i == 1) {
            str = b.e(R.string.sp_order_view_1_more_product);
        } else {
            str = b.a(R.string.sp_order_view_n_more_products, Integer.valueOf(i));
        }
        this.f23916a.setText(str);
    }

    public void setIds(List<Long> list) {
        this.f23917b = list;
    }

    public long getIdentifier() {
        return this.f23917b.get(0).longValue();
    }

    public boolean a(long j) {
        return this.f23917b.contains(Long.valueOf(j));
    }
}
