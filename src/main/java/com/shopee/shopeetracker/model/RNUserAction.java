package com.shopee.shopeetracker.model;

public class RNUserAction extends UserAction {
    private final String action;

    public int getType() {
        return 1;
    }

    public static RNUserAction create(String str) {
        return new RNUserAction(0, str);
    }

    RNUserAction(long j, String str) {
        super(j);
        this.action = str;
    }

    public String getActionData() {
        return this.action;
    }
}
