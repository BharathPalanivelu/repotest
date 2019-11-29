package com.airpay.paysdk.base.bean;

public class TicketPin {
    public final String label;
    public final String pinCode;

    public TicketPin(String str, String str2) {
        this.label = str;
        this.pinCode = str2;
    }
}
