package com.shopee.app.react.protocol;

import java.util.List;

public class UnreadPurchasesResponse {
    private List<Long> ids;

    public UnreadPurchasesResponse(List<Long> list) {
        this.ids = list;
    }
}
