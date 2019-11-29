package com.shopee.app.data.store;

import android.content.SharedPreferences;
import com.beetalklib.a.a.b;
import com.google.a.c.a;
import com.shopee.app.h.a.e;
import com.shopee.app.util.ad;
import com.shopee.app.util.l;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;
import org.json.JSONException;
import org.json.JSONObject;

public class RegionConfigStore extends ay {
    private b downloadCallback = new e() {
        /* access modifiers changed from: protected */
        public void onJSonObject(JSONObject jSONObject) throws JSONException {
            RegionConfigStore.this.updateSettingConfig((RegionConfig) WebRegister.GSON.a(jSONObject.toString(), new a<RegionConfig>() {
            }.getType()));
            RegionConfigStore.this.setTimestamp(com.garena.android.appkit.tools.a.a.a());
        }
    };
    private ad<RegionConfig> mRegionConfig;
    private c.a.a.a.b mTimestamp;

    public RegionConfigStore(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.mRegionConfig = new ad<>(sharedPreferences, "region_config", com.garena.android.appkit.tools.b.i(R.raw.config), new a<RegionConfig>() {
        });
        this.mTimestamp = new c.a.a.a.b(sharedPreferences, "timestamp", 0);
        checkDownload();
    }

    private void checkDownload() {
        int a2 = com.garena.android.appkit.tools.a.a.a() - getTimestamp();
        if (a2 > 3600 || a2 < 0) {
            fetchEditConfig();
        }
    }

    private void fetchEditConfig() {
        com.shopee.app.h.a.a.a().a(l.r, "RegionConfigStore", this.downloadCallback);
    }

    /* access modifiers changed from: private */
    public void setTimestamp(int i) {
        this.mTimestamp.a(i);
    }

    private int getTimestamp() {
        return this.mTimestamp.a();
    }

    /* access modifiers changed from: private */
    public void updateSettingConfig(RegionConfig regionConfig) {
        this.mRegionConfig.a(regionConfig);
    }

    public RegionConfig getRegionConfig() {
        return this.mRegionConfig.a();
    }
}
