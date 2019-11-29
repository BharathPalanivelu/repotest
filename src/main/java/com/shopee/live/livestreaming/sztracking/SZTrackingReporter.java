package com.shopee.live.livestreaming.sztracking;

import a.k;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.shopee.e.a.a;
import com.shopee.live.livestreaming.sztracking.SZTrackingLoopManager;
import com.shopee.live.livestreaming.sztracking.base.SZTrackingManager;
import com.shopee.live.livestreaming.sztracking.base.setting.SZTrackingSettings;
import com.shopee.live.livestreaming.sztracking.config.SZTrackingConfigEntity;
import com.shopee.live.livestreaming.sztracking.config.SZTrackingConfigHelper;
import com.shopee.live.livestreaming.sztracking.creator.SZTrackingEventBuildInterface;
import com.shopee.live.livestreaming.sztracking.creator.SZTrackingLagEventCreator;
import com.shopee.live.livestreaming.sztracking.creator.SZTrackingStreamContentDelayEventCreator;
import com.shopee.live.livestreaming.sztracking.creator.SZTrackingStreamExceptionEventCreator;
import com.shopee.live.livestreaming.sztracking.creator.SZTrackingStreamFirstFrameEventCreator;
import com.shopee.live.livestreaming.sztracking.creator.SZTrackingStreamGeneralEventCreator;
import com.shopee.live.livestreaming.sztracking.creator.SZTrackingStreamHeartbeatEventCreator;
import com.shopee.live.livestreaming.sztracking.creator.SZTrackingStreamStartEventCreator;
import com.shopee.live.livestreaming.sztracking.proto.GeneralAction;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.v;
import com.tencent.rtmp.TXLiveConstants;
import java.util.concurrent.Callable;

public class SZTrackingReporter implements SZTrackingLoopManager.SZTrackingLoopListener {
    private static final String INVALID_SESSION_ID = "0";
    private static final int ON_NET_STATUS_INTERVAL = 2;
    private static SZTrackingReporter sInstance;
    private SimpleCacheQueue<SZTrackingStreamExceptionEventCreator.BundleRecord> mAudienceStreamBundleCache = new SimpleCacheQueue<>();
    private String mAudioBitRate = "";
    private SZTrackingConfigEntity mConfigEntity = new SZTrackingConfigEntity();
    private String mDownSpeed = "";
    /* access modifiers changed from: private */
    public boolean mEnterRoomFlag;
    private long mFirstTimeConnectTick;
    private long mLagEndTime = 0;
    private long mLagStartTime = 0;
    private String mLastFps = "";
    private long mLocalTime = 0;
    private long mLowFpsTick;
    private long mReconnectTick;
    private SZTrackingManager mReportManager;
    private SZTrackingCacheEventHelper mSZTrackingCacheEventHelper;
    private SZTrackingLoopManager mSZTrackingLoopManager;
    private SZTrackingStreamHeartbeatEventCreator mSZTrackingStreamHeartbeatEventCreator = new SZTrackingStreamHeartbeatEventCreator(this.mSettings);
    /* access modifiers changed from: private */
    public String mServerIp = "";
    /* access modifiers changed from: private */
    public SZTrackingSettings mSettings = new SZTrackingSettings.Builder().useDefaultData().build();
    private long mStartPlayTime;
    /* access modifiers changed from: private */
    public boolean mStartStreamFlag;
    /* access modifiers changed from: private */
    public boolean mStartStreamFlag2;
    private long mTimeStamp;
    private String mVideoBitRate = "";

    public static SZTrackingReporter getInstance() {
        if (sInstance == null) {
            synchronized (SZTrackingReporter.class) {
                if (sInstance == null) {
                    sInstance = new SZTrackingReporter();
                }
            }
        }
        return sInstance;
    }

    public static boolean hasInstance() {
        return sInstance != null;
    }

    private SZTrackingReporter() {
    }

    public void init(Context context) {
        this.mReportManager = new SZTrackingManager(context);
        this.mReportManager.start();
        this.mSZTrackingLoopManager = new SZTrackingLoopManager(this);
        this.mSZTrackingLoopManager.start();
        this.mSZTrackingCacheEventHelper = new SZTrackingCacheEventHelper(this.mReportManager);
        SZTrackingConfigHelper.getConfig(new SZTrackingConfigHelper.GetConfigCallback() {
            public final void onResolve(SZTrackingConfigEntity sZTrackingConfigEntity) {
                SZTrackingReporter.this.lambda$init$0$SZTrackingReporter(sZTrackingConfigEntity);
            }
        });
    }

    /* renamed from: updateSettings */
    public void lambda$init$0$SZTrackingReporter(SZTrackingConfigEntity sZTrackingConfigEntity) {
        if (sZTrackingConfigEntity != null && sZTrackingConfigEntity.isAvailable()) {
            this.mConfigEntity = sZTrackingConfigEntity;
            this.mReportManager.updateSettings(sZTrackingConfigEntity.getDb_event_table_max_records(), sZTrackingConfigEntity.getDb_event_table_remain_records(), sZTrackingConfigEntity.getNetwork_request_timeout(), sZTrackingConfigEntity.getSend_interval(), sZTrackingConfigEntity.getSend_limit_size());
        }
    }

    public void updateUid(int i) {
        SZTrackingSettings sZTrackingSettings = this.mSettings;
        if (sZTrackingSettings != null) {
            sZTrackingSettings.setUid((long) i);
        }
    }

    public void ifMultiCdn(boolean z) {
        this.mSettings.setMultiCdn(z);
    }

    public void setVideoUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mServerIp = "";
            this.mSettings.setVideoUrl(str);
        }
    }

    private boolean inited() {
        SZTrackingManager sZTrackingManager = this.mReportManager;
        return sZTrackingManager != null && sZTrackingManager.started();
    }

    private void reportPushEvent(String str) {
        if (!TextUtils.isEmpty(str)) {
            a.a((Object) "SZTrackingReporter: " + str);
            handleEventReportWithCheckParams(new SZTrackingStreamExceptionEventCreator(this.mSettings, str, 2));
        }
    }

    private void reportPlayExceptionEvent(String str) {
        if (!TextUtils.isEmpty(str)) {
            a.a((Object) "SZTrackingReporter: " + str);
            handleEventReportWithCheckParams(new SZTrackingStreamExceptionEventCreator(this.mSettings, str, this.mAudienceStreamBundleCache.get(), 3));
        }
    }

    private void handleEventReportWithNotCheckParams(SZTrackingEventBuildInterface sZTrackingEventBuildInterface) {
        k.a(new Callable(sZTrackingEventBuildInterface) {
            private final /* synthetic */ SZTrackingEventBuildInterface f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return SZTrackingReporter.this.lambda$handleEventReportWithNotCheckParams$1$SZTrackingReporter(this.f$1);
            }
        });
    }

    public /* synthetic */ Object lambda$handleEventReportWithNotCheckParams$1$SZTrackingReporter(SZTrackingEventBuildInterface sZTrackingEventBuildInterface) throws Exception {
        if (!inited() && sZTrackingEventBuildInterface == null && this.mSettings == null) {
            return null;
        }
        this.mReportManager.eventReport(sZTrackingEventBuildInterface.buildCreator().buildEvent());
        return null;
    }

    /* access modifiers changed from: private */
    public void handleEventReportWithCheckParams(SZTrackingEventBuildInterface sZTrackingEventBuildInterface) {
        k.a(new Callable(sZTrackingEventBuildInterface) {
            private final /* synthetic */ SZTrackingEventBuildInterface f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return SZTrackingReporter.this.lambda$handleEventReportWithCheckParams$2$SZTrackingReporter(this.f$1);
            }
        });
    }

    public /* synthetic */ Object lambda$handleEventReportWithCheckParams$2$SZTrackingReporter(SZTrackingEventBuildInterface sZTrackingEventBuildInterface) throws Exception {
        if ((!inited() && sZTrackingEventBuildInterface == null && this.mSettings == null) || "0".equals(Integer.valueOf(f.a().f()))) {
            return null;
        }
        if (sZTrackingEventBuildInterface.beforeBuildCheckSuccessFully()) {
            this.mReportManager.eventReport(sZTrackingEventBuildInterface.buildCreator().buildEvent());
        } else {
            this.mSZTrackingCacheEventHelper.addEventToCache(sZTrackingEventBuildInterface.buildCreator());
        }
        return null;
    }

    private void checkFps(Bundle bundle) {
        long j = this.mLowFpsTick;
        if (j > 0) {
            this.mLowFpsTick = j + 1;
            if (this.mLowFpsTick > ((long) (this.mConfigEntity.getLow_fps_report_interval() / 2))) {
                this.mLowFpsTick = 0;
            }
        }
        if (bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS) <= this.mConfigEntity.getLow_fps() && this.mLowFpsTick == 0) {
            this.mLowFpsTick = 1;
            reportCustomEvent("PLAY_CUSTOM_LOW_FPS");
        }
    }

    private void checkLag(Bundle bundle) {
        int i = bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS);
        int i2 = bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE);
        if (i > this.mConfigEntity.getLow_fps() || (i2 <= 5 && i >= 7 && i <= 13)) {
            reportLagEvent();
            return;
        }
        this.mLagEndTime = System.currentTimeMillis();
        if (this.mLagStartTime == 0) {
            this.mLagStartTime = this.mLagEndTime - 2000;
        }
    }

    private long byteArrayTimeToLong(byte[] bArr) {
        byte[] bArr2 = bArr;
        byte[] bArr3 = new byte[8];
        int length = bArr3.length - 1;
        int length2 = bArr2.length - 1;
        while (length >= 0) {
            if (length2 >= 0) {
                bArr3[length] = bArr2[length2];
            } else {
                bArr3[length] = 0;
            }
            length--;
            length2--;
        }
        return (((long) (bArr3[0] & 255)) << 56) + (((long) (bArr3[1] & 255)) << 48) + (((long) (bArr3[2] & 255)) << 40) + (((long) (bArr3[3] & 255)) << 32) + (((long) (bArr3[4] & 255)) << 24) + (((long) (bArr3[5] & 255)) << 16) + (((long) (bArr3[6] & 255)) << 8) + ((long) (bArr3[7] & 255));
    }

    private void onNetStatusTick(Bundle bundle) {
        long j = this.mFirstTimeConnectTick;
        if (j > 0) {
            this.mFirstTimeConnectTick = j + 1;
            if (this.mFirstTimeConnectTick > ((long) (this.mConfigEntity.getBlack_screen_detect_time_for_first_time_connect() / 2))) {
                reportCustomEvent("PLAY_CUSTOM_BLACK_SCREEN_FOR_FIRST_TIME_CONNECT");
                this.mFirstTimeConnectTick = 0;
            }
        }
        long j2 = this.mReconnectTick;
        if (j2 > 0) {
            this.mReconnectTick = j2 + 1;
            if (this.mReconnectTick > ((long) (this.mConfigEntity.getBlack_screen_detect_time_for_reconnect() / 2))) {
                reportCustomEvent("PLAY_CUSTOM_BLACK_SCREEN_FOR_RECONNECT");
                this.mReconnectTick = 0;
            }
        }
        checkFps(bundle);
        checkLag(bundle);
    }

    public void reportPushEvent(int i) {
        String eventName = StreamEventMaps.getInstance().getEventName(i);
        if (!TextUtils.isEmpty(eventName)) {
            reportPushEvent(eventName);
        }
    }

    public void reportPushActionLiveDetails(Bundle bundle) {
        handleEventReportWithCheckParams(new SZTrackingStreamExceptionEventCreator(this.mSettings, bundle, 1));
    }

    public void reportPlayExceptionEvent(int i) {
        reportPlayExceptionEvent(StreamEventMaps.getInstance().getEventName(i));
    }

    public void onNetStatus(Bundle bundle) {
        if (bundle != null) {
            this.mServerIp = bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP) + "";
            this.mLastFps = bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS) + "";
            this.mVideoBitRate = bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "";
            this.mAudioBitRate = bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE) + "";
            this.mDownSpeed = bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED) + "";
            k.a(new Callable(bundle, System.currentTimeMillis()) {
                private final /* synthetic */ Bundle f$1;
                private final /* synthetic */ long f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final Object call() {
                    return SZTrackingReporter.this.lambda$onNetStatus$3$SZTrackingReporter(this.f$1, this.f$2);
                }
            });
            this.mSZTrackingCacheEventHelper.saveCacheToDB(this.mServerIp);
            this.mSZTrackingStreamHeartbeatEventCreator.setServerIp(this.mServerIp).setFps(this.mLastFps).setVideoRate(this.mVideoBitRate).setAudioRate(this.mAudioBitRate).setDownSpeed(this.mDownSpeed);
            onNetStatusTick(bundle);
        }
    }

    public /* synthetic */ Void lambda$onNetStatus$3$SZTrackingReporter(Bundle bundle, long j) throws Exception {
        this.mAudienceStreamBundleCache.put(new SZTrackingStreamExceptionEventCreator.BundleRecord(bundle, j, String.valueOf(f.a().c())));
        return null;
    }

    public void notifyFirstConnectStart() {
        this.mFirstTimeConnectTick = 1;
    }

    public void notifyReconnectStart() {
        this.mReconnectTick = 1;
    }

    public void notifyConnectSucceed() {
        this.mFirstTimeConnectTick = 0;
        this.mReconnectTick = 0;
    }

    public SZTrackingConfigEntity getConfigEntity() {
        return this.mConfigEntity;
    }

    public void checkWeakNetwork() {
        v.a(this.mServerIp, (v.a) new v.a() {
            public void resolve() {
            }

            public void reject() {
                SZTrackingReporter.this.reportCustomEvent("PLAY_CUSTOM_WEAK_NETWORK");
            }
        });
    }

    public void saveCacheToDB() {
        this.mSZTrackingCacheEventHelper.saveCacheToDB(this.mServerIp);
    }

    public void reportLagEvent() {
        long j = this.mLagEndTime - this.mLagStartTime;
        a.a((Object) "lagDuration" + j);
        if (j > 0 && this.mLagEndTime > 0) {
            reportLagEvent(j);
        }
        this.mLagStartTime = System.currentTimeMillis();
    }

    public void dealContentDelayEvent(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLocalTime > 1000) {
            byte[] byteArray = bundle.getByteArray(TXLiveConstants.EVT_GET_MSG);
            if (byteArray != null) {
                this.mTimeStamp = byteArrayTimeToLong(byteArray);
                reportContentDelayEvent(this.mLastFps, this.mAudioBitRate, this.mVideoBitRate, this.mTimeStamp, this.mServerIp);
            }
            this.mLocalTime = currentTimeMillis;
        }
    }

    /* access modifiers changed from: private */
    public void reportCustomEvent(String str) {
        reportPlayExceptionEvent(str);
    }

    public void reportStartPlayEvent() {
        handleEventReportWithCheckParams(new SZTrackingStreamStartEventCreator(this.mSettings, System.currentTimeMillis(), this.mServerIp));
    }

    private void reportLagEvent(long j) {
        handleEventReportWithCheckParams(new SZTrackingLagEventCreator(this.mSettings, j, this.mServerIp));
    }

    private void reportContentDelayEvent(String str, String str2, String str3, long j, String str4) {
        handleEventReportWithCheckParams(new SZTrackingStreamContentDelayEventCreator(this.mSettings, str4, str, str2, str3, j));
    }

    public void reportFirstFrameEvent() {
        long j = this.mStartPlayTime;
        if (j != 0) {
            this.mStartPlayTime = 0;
            handleEventReportWithCheckParams(new SZTrackingStreamFirstFrameEventCreator(this.mSettings, this.mServerIp, j, System.currentTimeMillis()));
        }
    }

    public void reportGeneralEvent(final int i, final boolean z) {
        k.a(new Callable<Void>() {
            public Void call() throws Exception {
                if (i == GeneralAction.ACTION_ENTER_ROOM.getValue()) {
                    boolean unused = SZTrackingReporter.this.mEnterRoomFlag = true;
                } else if (i == GeneralAction.ACTION_START_STREAM.getValue()) {
                    boolean unused2 = SZTrackingReporter.this.mStartStreamFlag = true;
                    boolean unused3 = SZTrackingReporter.this.mStartStreamFlag2 = true;
                } else if (i == GeneralAction.ACTION_CONNECTED_STREAM.getValue()) {
                    if (!SZTrackingReporter.this.mStartStreamFlag2) {
                        return null;
                    }
                    boolean unused4 = SZTrackingReporter.this.mStartStreamFlag2 = false;
                } else if (i == GeneralAction.ACTION_DISCONNECTED_ACTIVE.getValue()) {
                    if (!SZTrackingReporter.this.mStartStreamFlag) {
                        return null;
                    }
                    boolean unused5 = SZTrackingReporter.this.mStartStreamFlag = false;
                } else if (i == GeneralAction.ACTION_DISCONNECTED_PASSIVE.getValue()) {
                    if (!SZTrackingReporter.this.mStartStreamFlag) {
                        return null;
                    }
                    boolean unused6 = SZTrackingReporter.this.mStartStreamFlag = false;
                } else if (i == GeneralAction.ACTION_LEAVE_ROOM.getValue() && !SZTrackingReporter.this.mEnterRoomFlag) {
                    return null;
                }
                SZTrackingReporter sZTrackingReporter = SZTrackingReporter.this;
                sZTrackingReporter.handleEventReportWithCheckParams(new SZTrackingStreamGeneralEventCreator(sZTrackingReporter.mSettings, SZTrackingReporter.this.mServerIp, i, f.a().l(), z));
                return null;
            }
        });
    }

    public void reportHeaderBeatEvent() {
        this.mSZTrackingLoopManager.start();
        this.mSZTrackingLoopManager.executeLoop(1, (long) this.mConfigEntity.getSz_viewer_heartbeat_interval());
    }

    public void stopLoop() {
        this.mSZTrackingLoopManager.stop();
    }

    public void loopCallback(int i) {
        if (i == 1) {
            handleEventReportWithNotCheckParams(this.mSZTrackingStreamHeartbeatEventCreator);
        }
    }
}
