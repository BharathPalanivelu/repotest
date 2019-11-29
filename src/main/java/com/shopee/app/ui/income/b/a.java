package com.shopee.app.ui.income.b;

import android.content.Context;
import android.widget.RelativeLayout;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.income.ShopBalance;

public abstract class a extends RelativeLayout {
    public abstract void a(ShopDetail shopDetail);

    public abstract void a(ShopBalance shopBalance);

    public void b() {
    }

    public abstract void b(ShopBalance shopBalance);

    public void g() {
    }

    public abstract void setAmount(Long l);

    public a(Context context) {
        super(context);
    }
}
