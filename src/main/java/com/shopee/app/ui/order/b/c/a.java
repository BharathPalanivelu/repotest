package com.shopee.app.ui.order.b.c;

import com.shopee.id.R;
import com.shopee.protocol.action.ReturnSubListType;

public enum a {
    ALL(ReturnSubListType.RETURN_SUB_LIST_ALL.getValue(), "all", R.string.return_list_all_requests),
    UNPROCESSED(ReturnSubListType.RETURN_SUB_LIST_UNPROCESSED.getValue(), "unprocessed", R.string.return_list_unprocessed),
    PROCESSED(ReturnSubListType.RETURN_SUB_LIST_PROCESSED.getValue(), "processed", R.string.return_list_processed);
    
    private final String mName;
    private final int mNameResId;
    private final int mValue;

    public static a fromValue(int i) {
        for (a aVar : values()) {
            if (aVar.mValue == i) {
                return aVar;
            }
        }
        return null;
    }

    public static a fromName(String str) {
        for (a aVar : values()) {
            if (aVar.getName().equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private a(int i, String str, int i2) {
        this.mValue = i;
        this.mName = str;
        this.mNameResId = i2;
    }

    public int getValue() {
        return this.mValue;
    }

    public String getName() {
        return this.mName;
    }

    public int getNameResId() {
        return this.mNameResId;
    }
}
