package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ActionRedirctType implements ProtoEnum {
    REDIRECT_NONE(0),
    REDIRECT_ORDERS_DETAIL(1),
    REDIRECT_MY_PRODUCTS(2),
    REDIRECT_MY_INCOME(3),
    REDIRECT_ORDERS_RETURNREFUND(4),
    REDIRECT_ORDERS_CANCEL(5),
    REDIRECT_OUTOF_STOCK(6),
    REDIRECT_PURE_REFUND(8),
    REDIRECT_NEW_WEB_PAGE(10),
    REDIRECT_UPLOAD_RECEIPT_PAGE(11),
    REDIRECT_SHOPING_CART(12),
    REDIRECT_BUNCH_ORDERS_DETAIL(13),
    REDIRECT_ORDER_CHAT_PAGE(16),
    REDIRECT_RELATED_PRODUCT_PAGE(18),
    REDIRECT_CREDIT_CARD_PAYMENT_PAGE(19),
    REDIRECT_MY_WALLET(20),
    REDIRECT_EDIT_SHOP_PROFILE(21),
    REDIRECT_APP_PATH(22),
    REDIRECT_MY_ACCOUNT(23),
    REDIRECT_APP_ROUTE(24),
    REDIRECT_REACTNATIVE_PATH(25),
    REDIRECT_EXTERNAL_WEBPAGE(26);
    
    private final int value;

    private ActionRedirctType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
