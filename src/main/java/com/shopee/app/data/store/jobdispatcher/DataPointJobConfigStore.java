package com.shopee.app.data.store.jobdispatcher;

import android.content.SharedPreferences;
import b.a;
import com.firebase.jobdispatcher.s;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.jobdispatcher.JobConfig;
import com.shopee.app.util.datapoint.DataPointService;

public class DataPointJobConfigStore extends JobConfigStore {
    private static final int DEFAULT_PERIOD = 60;

    /* access modifiers changed from: protected */
    public String getJobTag() {
        return "DataPointService";
    }

    public DataPointJobConfigStore(SharedPreferences sharedPreferences, a<SettingConfigStore> aVar) {
        super(sharedPreferences, aVar);
    }

    /* access modifiers changed from: protected */
    public Class<? extends s> getJobService() {
        return DataPointService.class;
    }

    /* access modifiers changed from: protected */
    public JobConfig getDefault() {
        return new JobConfig.Builder().periodInMins(60).needCharger(true).tag(getJobTag()).service(getJobService()).appVersion(com.shopee.app.react.modules.app.appmanager.a.c()).build();
    }

    /* access modifiers changed from: protected */
    public JobConfig getRemote(SettingConfigStore settingConfigStore) {
        return new JobConfig.Builder().periodInMins(settingConfigStore.dataPointPeriod()).needCharger(true).tag(getJobTag()).service(getJobService()).appVersion(com.shopee.app.react.modules.app.appmanager.a.c()).build();
    }
}
