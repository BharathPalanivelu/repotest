package com.shopee.app.ui.home.a;

import android.content.Context;
import android.view.View;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.ui.a.s;

public class j implements s<ActivityItemInfo> {
    public int a() {
        return 3;
    }

    public int a(ActivityItemInfo activityItemInfo, int i) {
        return activityItemInfo.getActivityItemType();
    }

    public View a(Context context, int i) {
        if (i == 0) {
            return i.a(context);
        }
        if (i == 1) {
            return f.a(context);
        }
        if (i != 2) {
            return null;
        }
        return b.a(context);
    }
}
