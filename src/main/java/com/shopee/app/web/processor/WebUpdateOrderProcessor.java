package com.shopee.app.web.processor;

import com.google.a.l;
import com.shopee.app.network.d.h.i;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.UpdateOrderMessage;

public class WebUpdateOrderProcessor extends WebProcessor {
    public void onProcess(l lVar) {
        UpdateOrderMessage updateOrderMessage = (UpdateOrderMessage) WebRegister.GSON.a(lVar, UpdateOrderMessage.class);
        new i().a(updateOrderMessage.getOrderID(), updateOrderMessage.getShopID());
    }
}
