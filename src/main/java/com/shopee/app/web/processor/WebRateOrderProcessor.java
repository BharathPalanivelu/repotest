package com.shopee.app.web.processor;

import com.garena.android.appkit.tools.a.a;
import com.google.a.l;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.bb;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.RateOrderMessage;

public class WebRateOrderProcessor extends WebProcessor {
    public void onProcess(l lVar) {
        RateOrderMessage rateOrderMessage = (RateOrderMessage) WebRegister.GSON.a(lVar, RateOrderMessage.class);
        bb ratingShopeeStore = ar.f().e().ratingShopeeStore();
        if (rateOrderMessage.getHasGoodRate() != 1) {
            return;
        }
        if (ratingShopeeStore.h()) {
            ratingShopeeStore.c(a.a());
            ratingShopeeStore.b(rateOrderMessage.getOrderID());
            ratingShopeeStore.b(0);
        } else if (ratingShopeeStore.j()) {
            ratingShopeeStore.c(a.a());
            ratingShopeeStore.b(rateOrderMessage.getOrderID());
            ratingShopeeStore.b(0);
        }
    }
}
