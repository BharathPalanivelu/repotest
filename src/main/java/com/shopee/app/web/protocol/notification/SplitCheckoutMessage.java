package com.shopee.app.web.protocol.notification;

import java.util.List;

public class SplitCheckoutMessage {
    private long checkoutID;
    private List<Long> splitCheckoutIDs;

    public List<Long> getSplitCheckoutIDs() {
        return this.splitCheckoutIDs;
    }

    public long getCheckoutID() {
        return this.checkoutID;
    }
}
