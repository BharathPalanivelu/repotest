package com.shopee.app.ui.home.a;

import android.content.Context;
import android.widget.RelativeLayout;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.ui.a.n;

public class h extends RelativeLayout implements n<ActivityItemInfo> {

    /* renamed from: a  reason: collision with root package name */
    com.shopee.app.ui.common.h f22048a;

    public h(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f22048a.setAutoRotate(true);
    }

    public void a(ActivityItemInfo activityItemInfo) {
        this.f22048a.setBannerData(activityItemInfo.getBanners());
    }
}
