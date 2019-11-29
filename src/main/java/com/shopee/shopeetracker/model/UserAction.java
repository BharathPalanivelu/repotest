package com.shopee.shopeetracker.model;

import android.text.TextUtils;
import com.shopee.shopeetracker.ShopeeTracker;
import com.shopee.shopeetracker.utils.GsonUtils;

public abstract class UserAction {
    private long id;

    public abstract String getActionData();

    public abstract int getType();

    public UserAction(long j) {
        this.id = j;
    }

    public long getId() {
        return this.id;
    }

    public static UserAction from(long j, int i, String str) {
        if (i == 0) {
            return new AppUserAction(j, GsonUtils.fromString(str));
        }
        if (i == 1) {
            return new RNUserAction(j, str);
        }
        if (i != 2) {
            return new RNUserAction(j, str);
        }
        return new UserActionV2(j, str);
    }

    public void log() {
        if (!TextUtils.isEmpty(getActionData()) && ShopeeTracker.isInitialized()) {
            ShopeeTracker.getInstance().logAction(this);
        }
    }
}
