package com.shopee.shopeetracker.model;

import com.google.a.a.c;

public class ViewCommon {
    @c(a = "history_id")
    private final String historyId;
    @c(a = "is_back")
    private final boolean isBack;
    @c(a = "is_initial")
    private final boolean isInitial;

    public ViewCommon(boolean z, boolean z2, String str) {
        this.isInitial = z;
        this.isBack = z2;
        this.historyId = str;
    }
}
