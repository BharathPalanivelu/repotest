package com.shopee.app.ui.actionbar;

import android.app.Activity;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.setting.SettingActivity_;
import com.shopee.id.R;
import d.d.b.j;

public final class m extends a.b {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f19328a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(Activity activity) {
        super("ACTION_BAR_SETTING", (int) R.drawable.ic_me_settings);
        j.b(activity, "activity");
        this.f19328a = activity;
    }

    public void a() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        SettingConfigStore settingConfigStore = f2.e().settingConfigStore();
        if (settingConfigStore != null) {
            SettingActivity_.a(this.f19328a).a(settingConfigStore.showUpgrade()).a();
        }
    }
}
