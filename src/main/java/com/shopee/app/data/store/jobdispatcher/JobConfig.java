package com.shopee.app.data.store.jobdispatcher;

import android.text.TextUtils;
import com.firebase.jobdispatcher.s;

public class JobConfig {
    private String appVersion;
    private boolean needCharger;
    private int period;
    private transient Class<? extends s> service;
    private String tag;

    private JobConfig(Builder builder) {
        this.needCharger = builder.needCharger;
        this.period = builder.period;
        this.tag = builder.tag;
        this.appVersion = builder.appVersion;
        this.service = builder.service;
    }

    public boolean isNeedCharger() {
        return this.needCharger;
    }

    public int getPeriod() {
        return this.period;
    }

    public String getTag() {
        return this.tag;
    }

    public Class<? extends s> getService() {
        return this.service;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public boolean isEmpty() {
        return this.period <= 0 || TextUtils.isEmpty(this.appVersion);
    }

    public boolean hasConfigChanged(JobConfig jobConfig) {
        return this.needCharger != jobConfig.needCharger || this.period != jobConfig.period || TextUtils.isEmpty(this.appVersion) || !this.appVersion.equals(jobConfig.appVersion);
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String appVersion;
        /* access modifiers changed from: private */
        public boolean needCharger;
        /* access modifiers changed from: private */
        public int period;
        /* access modifiers changed from: private */
        public Class<? extends s> service;
        /* access modifiers changed from: private */
        public String tag;

        public Builder needCharger(boolean z) {
            this.needCharger = z;
            return this;
        }

        public Builder periodInMins(int i) {
            this.period = i;
            return this;
        }

        public Builder tag(String str) {
            this.tag = str;
            return this;
        }

        public Builder appVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder service(Class<? extends s> cls) {
            this.service = cls;
            return this;
        }

        public JobConfig build() {
            return new JobConfig(this);
        }
    }
}
