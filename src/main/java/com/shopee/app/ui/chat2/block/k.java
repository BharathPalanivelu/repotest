package com.shopee.app.ui.chat2.block;

import android.content.Context;
import android.view.View;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.ui.a.s;

public class k implements s<UserBriefInfo> {
    public int a() {
        return 2;
    }

    public int a(UserBriefInfo userBriefInfo, int i) {
        if (userBriefInfo.getUserId() == -1) {
            return -2;
        }
        return userBriefInfo.getUserId();
    }

    public View a(Context context, int i) {
        if (i != -2) {
            return g.a(context);
        }
        return b.a(context);
    }
}
