package com.shopee.app.network.http.data.datapoint;

public class SMSCursor {
    String item_id;
    int sms_timestamp;

    public int getSMSTimestamp() {
        return this.sms_timestamp;
    }

    public String getItemId() {
        return this.item_id;
    }

    public static SMSCursor emptyCursor() {
        return new SMSCursor();
    }
}
