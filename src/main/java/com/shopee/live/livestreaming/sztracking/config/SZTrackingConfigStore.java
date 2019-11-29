package com.shopee.live.livestreaming.sztracking.config;

import android.content.SharedPreferences;
import com.shopee.sdk.e.a.d;
import com.shopee.sdk.e.b;
import com.shopee.sdk.f.a;

public class SZTrackingConfigStore extends b {
    private static final String SZ_TRACKING_CONFIG = "sz_tracking_settings";
    private d<SZTrackingConfigEntity> mConfigPr;

    public SZTrackingConfigStore(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.mConfigPr = new d<>(sharedPreferences, SZ_TRACKING_CONFIG, a.f30358b, SZTrackingConfigEntity.class);
    }

    public void put(SZTrackingConfigEntity sZTrackingConfigEntity) {
        if (sZTrackingConfigEntity != null) {
            this.mConfigPr.b(sZTrackingConfigEntity);
        }
    }

    public SZTrackingConfigEntity get() {
        return this.mConfigPr.c();
    }
}
