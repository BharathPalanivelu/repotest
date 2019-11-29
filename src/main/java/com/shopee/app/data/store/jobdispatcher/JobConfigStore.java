package com.shopee.app.data.store.jobdispatcher;

import android.content.SharedPreferences;
import b.a;
import com.firebase.jobdispatcher.s;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ay;
import com.shopee.app.data.store.jobdispatcher.JobConfig;
import com.shopee.app.util.ad;

public abstract class JobConfigStore extends ay {
    private final a<SettingConfigStore> mConfig;
    private final ad<JobConfig> mJobConfig;

    /* access modifiers changed from: protected */
    public abstract JobConfig getDefault();

    /* access modifiers changed from: protected */
    public abstract Class<? extends s> getJobService();

    /* access modifiers changed from: protected */
    public abstract String getJobTag();

    /* access modifiers changed from: protected */
    public abstract JobConfig getRemote(SettingConfigStore settingConfigStore);

    protected JobConfigStore(SharedPreferences sharedPreferences, a<SettingConfigStore> aVar) {
        super(sharedPreferences);
        this.mConfig = aVar;
        this.mJobConfig = new ad<>(sharedPreferences, "job_config_v1", ServiceLogger.PLACEHOLDER, new com.google.a.c.a<JobConfig>() {
        });
    }

    public JobConfig getLocalConfig() {
        JobConfig a2 = this.mJobConfig.a();
        if (a2.isEmpty()) {
            a2 = getDefault();
        }
        return new JobConfig.Builder().needCharger(a2.isNeedCharger()).periodInMins(a2.getPeriod()).service(getJobService()).tag(getJobTag()).appVersion(a2.getAppVersion()).build();
    }

    public JobConfig getRemoteConfig() {
        SettingConfigStore settingConfigStore = this.mConfig.get();
        JobConfig remote = settingConfigStore != null ? getRemote(settingConfigStore) : null;
        if (remote == null || remote.isEmpty()) {
            remote = getDefault();
        }
        return new JobConfig.Builder().needCharger(remote.isNeedCharger()).periodInMins(remote.getPeriod()).service(getJobService()).tag(getJobTag()).appVersion(com.shopee.app.react.modules.app.appmanager.a.c()).build();
    }

    public void updateLocalConfig(JobConfig jobConfig) {
        this.mJobConfig.a(jobConfig);
    }
}
