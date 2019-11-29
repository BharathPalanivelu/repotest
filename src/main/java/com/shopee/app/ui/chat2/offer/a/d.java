package com.shopee.app.ui.chat2.offer.a;

import android.content.Context;
import android.view.View;
import com.shopee.app.data.viewmodel.chatP2P.VMOfferHistory;
import com.shopee.app.ui.a.s;
import com.shopee.app.ui.chat2.product.b;

public class d implements s<VMOfferHistory> {
    public int a() {
        return 2;
    }

    public int a(VMOfferHistory vMOfferHistory, int i) {
        return vMOfferHistory.getType();
    }

    public View a(Context context, int i) {
        if (i != -2) {
            return b.a(context);
        }
        return b.a(context);
    }
}
