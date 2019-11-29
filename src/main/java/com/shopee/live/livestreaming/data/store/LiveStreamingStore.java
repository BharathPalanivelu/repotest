package com.shopee.live.livestreaming.data.store;

import android.content.SharedPreferences;
import c.a.a.a.a;
import com.shopee.live.livestreaming.data.entity.CICCountDownData;
import com.shopee.live.livestreaming.data.entity.LiveStreamingData;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSetting;
import com.shopee.sdk.e.a.d;
import com.shopee.sdk.e.b;

public class LiveStreamingStore extends b {
    private static final String CIC_COUNT_DOWN_DATA = "cic_count_down_data";
    private static final String CLEAN_MODE_CLEAN_BTN = "clean_mode_clean_btn";
    private static final String CLEAN_MODE_NOTIFY = "clean_mode_notify";
    private static final String CLEAN_MODE_RESUME_BTN = "clean_mode_resume_btn";
    private static final String FEED_LIST = "feed_list";
    private static final String FEED_SETTING = "feed_setting";
    private static final String FEED_STATUS = "feed_status";
    private static final String FEED_USER_TYPE = "user_type";
    public static final int SHOWED_TIP = 1;
    private static final String SHOW_STATUS = "show_status";
    private static final String TX_LICENSE_KEY = "tx_license_key";
    private static final String TX_LICENSE_URL = "tx_license_url";
    private static final String TX_LOG_ENABLE = "tx_log_enable";
    public static final int UNSHOW_TIP = 0;
    private d<CICCountDownData> mCICCountDownData;
    private com.shopee.sdk.e.a.b<LiveStreamingData> mLiveStreamingList;
    private d<LiveStreamingSetting> mLiveStreamingSetting;
    private c.a.a.a.b mLiveStreamingShowStatus;
    private c.a.a.a.b mLiveStreamingStatus;
    private c.a.a.a.b mLiveStreamingUserType;
    private a mTXLogEnable;
    private c.a.a.a.d mTxLicenseKey;
    private c.a.a.a.d mTxLicenseUrl;
    private com.shopee.sdk.e.a.b<Integer> mUserGuideCleanModeButton;
    private com.shopee.sdk.e.a.b<Integer> mUserGuideCleanModeNotifyPopup;
    private com.shopee.sdk.e.a.b<Integer> mUserGuideResumeButton;

    public LiveStreamingStore(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.mLiveStreamingSetting = new d<>(sharedPreferences, FEED_SETTING, com.shopee.sdk.f.a.f30358b, LiveStreamingSetting.class);
        this.mLiveStreamingStatus = new c.a.a.a.b(sharedPreferences, FEED_STATUS, 0);
        this.mLiveStreamingUserType = new c.a.a.a.b(sharedPreferences, FEED_USER_TYPE, 0);
        this.mLiveStreamingShowStatus = new c.a.a.a.b(sharedPreferences, SHOW_STATUS, 0);
        this.mLiveStreamingList = new com.shopee.sdk.e.a.b<>(sharedPreferences, FEED_LIST, LiveStreamingData.class);
        this.mTXLogEnable = new a(sharedPreferences, TX_LOG_ENABLE, false);
        this.mTxLicenseKey = new c.a.a.a.d(sharedPreferences, TX_LICENSE_KEY);
        this.mTxLicenseUrl = new c.a.a.a.d(sharedPreferences, TX_LICENSE_URL);
        this.mUserGuideCleanModeNotifyPopup = new com.shopee.sdk.e.a.b<>(sharedPreferences, CLEAN_MODE_NOTIFY, Integer.class);
        this.mUserGuideResumeButton = new com.shopee.sdk.e.a.b<>(sharedPreferences, CLEAN_MODE_RESUME_BTN, Integer.class);
        this.mUserGuideCleanModeButton = new com.shopee.sdk.e.a.b<>(sharedPreferences, CLEAN_MODE_CLEAN_BTN, Integer.class);
        this.mCICCountDownData = new d<>(sharedPreferences, CIC_COUNT_DOWN_DATA, com.shopee.sdk.f.a.f30358b, CICCountDownData.class);
    }

    public LiveStreamingSetting getSetting() {
        return this.mLiveStreamingSetting.c();
    }

    public void saveSetting(LiveStreamingSetting liveStreamingSetting) {
        this.mLiveStreamingSetting.b(liveStreamingSetting);
    }

    public boolean isReady() {
        return this.mLiveStreamingStatus.a() == 1;
    }

    public void updateStutus(int i) {
        this.mLiveStreamingStatus.a(i);
    }

    public void setFeedUserType(int i) {
        this.mLiveStreamingUserType.a(i);
    }

    public void setShowStatus(int i) {
        this.mLiveStreamingShowStatus.a(i);
    }

    public boolean hasShow() {
        return this.mLiveStreamingShowStatus.a() == 1;
    }

    public String getTxLicenseKey() {
        return this.mTxLicenseKey.a();
    }

    public void putTxLicenseKey(String str) {
        if (!com.shopee.live.livestreaming.util.d.a(str)) {
            this.mTxLicenseKey.a(str);
        }
    }

    public String getTxLicenseUrl() {
        return this.mTxLicenseUrl.a();
    }

    public void putTxLicenseUrl(String str) {
        if (!com.shopee.live.livestreaming.util.d.a(str)) {
            this.mTxLicenseUrl.a(str);
        }
    }

    public com.shopee.sdk.e.a.b<LiveStreamingData> getFeedList() {
        return this.mLiveStreamingList;
    }

    public boolean ifTXLogEnable() {
        return this.mTXLogEnable.a();
    }

    public void setTXLogEnable(boolean z) {
        this.mTXLogEnable.a(z);
    }

    public void setUserGuideCleanModeNotify(Integer num) {
        this.mUserGuideCleanModeNotifyPopup.a(num);
    }

    public boolean ifSetUserGuideCleanModeNotify(Integer num) {
        return foundInListIntegerPref(this.mUserGuideCleanModeNotifyPopup, num);
    }

    public void setUserGuideResumeButton(Integer num) {
        this.mUserGuideResumeButton.a(num);
    }

    public boolean ifSetUserGuideResumeButton(Integer num) {
        return foundInListIntegerPref(this.mUserGuideResumeButton, num);
    }

    public void setUserGuideCleanButton(Integer num) {
        this.mUserGuideCleanModeButton.a(num);
    }

    public boolean ifSetUserGuideCleanButton(Integer num) {
        return foundInListIntegerPref(this.mUserGuideCleanModeButton, num);
    }

    public CICCountDownData getCICCountDownData() {
        return this.mCICCountDownData.c();
    }

    public void setCICCountDownData(CICCountDownData cICCountDownData) {
        if (cICCountDownData != null) {
            cICCountDownData.setSaveTimestamp(System.currentTimeMillis());
            this.mCICCountDownData.b(cICCountDownData);
        }
    }

    private boolean foundInListIntegerPref(com.shopee.sdk.e.a.b<Integer> bVar, Integer num) {
        if (bVar.a() <= 0) {
            return false;
        }
        for (int i = 0; i < bVar.a(); i++) {
            if (bVar.a(i).intValue() == num.intValue()) {
                return true;
            }
        }
        return false;
    }
}
