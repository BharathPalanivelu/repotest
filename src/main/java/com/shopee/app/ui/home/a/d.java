package com.shopee.app.ui.home.a;

import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.ui.a.y;

public class d extends y<ActivityItemInfo> {
    public d(j jVar) {
        super(jVar);
    }

    public long c(int i) {
        return (long) ((ActivityItemInfo) b(i)).getActivityId();
    }

    public void d(int i) {
        for (ActivityItemInfo activityItemInfo : d()) {
            if (activityItemInfo.getShopId() == i) {
                activityItemInfo.onUserChangeFollowingStatus(2);
            }
        }
    }

    public void e(int i) {
        for (ActivityItemInfo activityItemInfo : d()) {
            if (activityItemInfo.getShopId() == i) {
                activityItemInfo.onUserChangeFollowingStatus(1);
            }
        }
    }
}
