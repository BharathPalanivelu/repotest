package com.shopee.app.data.store.jobdispatcher;

import android.content.SharedPreferences;
import android.os.Build;
import b.a;
import com.firebase.jobdispatcher.s;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.jobdispatcher.JobConfig;
import com.shopee.app.react.sync.BundleSyncService;

public class ReactJobConfigStore extends JobConfigStore {
    private static final int DEFAULT_PERIOD = 60;

    /* access modifiers changed from: protected */
    public String getJobTag() {
        return "BundleSyncService";
    }

    public ReactJobConfigStore(SharedPreferences sharedPreferences, a<SettingConfigStore> aVar) {
        super(sharedPreferences, aVar);
    }

    /* access modifiers changed from: protected */
    public Class<? extends s> getJobService() {
        return BundleSyncService.class;
    }

    /* access modifiers changed from: protected */
    public JobConfig getDefault() {
        return new JobConfig.Builder().periodInMins(60).needCharger(false).tag(getJobTag()).service(getJobService()).appVersion(com.shopee.app.react.modules.app.appmanager.a.c()).build();
    }

    /* access modifiers changed from: protected */
    public JobConfig getRemote(SettingConfigStore settingConfigStore) {
        int i;
        if (Build.VERSION.SDK_INT < 23) {
            i = settingConfigStore.bundleSyncPeriodBelowAndroidM();
        } else {
            i = settingConfigStore.bundleSyncPeriod();
        }
        return new JobConfig.Builder().periodInMins(i).needCharger(false).tag(getJobTag()).service(getJobService()).appVersion(com.shopee.app.react.modules.app.appmanager.a.c()).build();
    }
}
