package com.shopee.app.ui.order.b.a;

import android.content.Context;
import com.shopee.app.ui.a.m;
import com.shopee.app.ui.actionbox.actionrequired.RatingShopeePanel_;
import com.shopee.app.ui.actionbox.actionrequired.c;

public class e extends m<c, a> {

    public interface a {
        int a();
    }

    public int b() {
        return 7;
    }

    public c a(Context context, a aVar, int i) {
        return RatingShopeePanel_.a(context);
    }

    public void a(c cVar, a aVar) {
        cVar.a(aVar.a(), false);
    }
}
