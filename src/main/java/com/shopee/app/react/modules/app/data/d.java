package com.shopee.app.react.modules.app.data;

import com.google.a.l;
import com.google.a.o;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.setting.SettingConfig;
import com.shopee.app.web.WebRegister;
import java.lang.reflect.Type;

public class d implements h {

    /* renamed from: a  reason: collision with root package name */
    private final SettingConfigStore f18747a;

    /* renamed from: b  reason: collision with root package name */
    private o f18748b;

    /* renamed from: c  reason: collision with root package name */
    private SettingConfig f18749c;

    public d(SettingConfigStore settingConfigStore) {
        this.f18747a = settingConfigStore;
    }

    public boolean a(String str) {
        return "ccmsConfig".equals(str);
    }

    public String b(String str) {
        String c2 = ((o) WebRegister.GSON.a(str, o.class)).c("field").c();
        if (this.f18747a.getConfig() != this.f18749c) {
            this.f18749c = this.f18747a.getConfig();
            this.f18748b = WebRegister.GSON.a((Object) this.f18749c, (Type) SettingConfig.class).m();
        }
        o e2 = this.f18748b.e(c2);
        l lVar = null;
        if (e2 != null) {
            if (e2.b("ID")) {
                lVar = e2.c("ID");
            } else if (e2.b("default")) {
                lVar = e2.c("default");
            }
        }
        o oVar = new o();
        if (lVar != null) {
            oVar.a(AppMeasurementSdk.ConditionalUserProperty.VALUE, lVar);
        }
        return oVar.toString();
    }
}
