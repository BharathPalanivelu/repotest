package com.shopee.shopeetracker.model;

import com.google.a.a.c;
import com.shopee.shopeetracker.ShopeeTracker;
import java.util.ArrayList;
import java.util.List;

public class Config {
    private int batchSize;
    private boolean httpMetricsEnable = false;
    private boolean needCharger;
    private long period;
    private long periodBelowAndroidM;
    private long periodForeground;
    private boolean pingMetricsEnable = false;
    @c(a = "pinglist_url")
    private List<String> pingUrlList = new ArrayList();
    private double samplingRate;
    @c(a = "whitelist_url")
    private List<String> whiteUrlList = new ArrayList();

    public Config(boolean z, long j, int i, long j2) {
        this.needCharger = z;
        this.period = j;
        this.batchSize = i;
        this.periodForeground = j2;
        this.periodBelowAndroidM = j;
    }

    public boolean isNeedCharger() {
        return this.needCharger;
    }

    public long getPeriod() {
        long j = this.period;
        return j > 0 ? j : ShopeeTracker.PERIOD_IN_SECS;
    }

    public int getBatchSize() {
        int i = this.batchSize;
        if (i > 0) {
            return i;
        }
        return 20;
    }

    public long getPeriodForeground() {
        long j = this.periodForeground;
        if (j > 0) {
            return j;
        }
        return 60;
    }

    public long getPeriodBelowAndroidM() {
        long j = this.periodBelowAndroidM;
        return j > 0 ? j : ShopeeTracker.PERIOD_IN_SECS;
    }

    public List<String> getWhiteUrlList() {
        return this.whiteUrlList;
    }

    public void setWhitelistUrl(List<String> list) {
        this.whiteUrlList = list;
    }

    public boolean isPingMetricsEnable() {
        return this.pingMetricsEnable;
    }

    public void setPingMetricsEnable(boolean z) {
        this.pingMetricsEnable = z;
    }

    public boolean isHttpMetricsEnable() {
        return this.httpMetricsEnable;
    }

    public void setHttpMetricsEnable(boolean z) {
        this.httpMetricsEnable = z;
    }

    public double getSamplingRate() {
        return this.samplingRate;
    }

    public void setSamplingRate(double d2) {
        this.samplingRate = d2;
    }

    public List<String> getPingUrlList() {
        return this.pingUrlList;
    }

    public void setPingUrlList(List<String> list) {
        this.pingUrlList = list;
    }
}
