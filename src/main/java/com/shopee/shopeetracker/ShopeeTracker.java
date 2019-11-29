package com.shopee.shopeetracker;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.google.a.l;
import com.google.a.o;
import com.shopee.a.b;
import com.shopee.shopeetracker.bimodel.TrackingCookie;
import com.shopee.shopeetracker.bimodel.TrackingMeta;
import com.shopee.shopeetracker.callbacks.TrackerLifecycleCallbacks;
import com.shopee.shopeetracker.data.SQLiteHelper;
import com.shopee.shopeetracker.manager.SessionManager;
import com.shopee.shopeetracker.manager.TrackerStrategyManager;
import com.shopee.shopeetracker.model.Config;
import com.shopee.shopeetracker.model.UserAction;
import com.shopee.shopeetracker.utils.ExceptionHandler;
import com.shopee.shopeetracker.utils.GsonUtils;
import com.shopee.shopeetracker.utils.Logger;
import com.shopee.shopeetracker.utils.TrackLogger;
import com.shopee.shopeetracker.worker.TrackerTaskRunnable;
import d.d.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Interceptor;

public class ShopeeTracker {
    public static final int ACTION_DATA_LIMIT = 20;
    public static final int EVENT_TYPE_APP = 0;
    public static final int EVENT_TYPE_PERFORMANCE = 3;
    public static final int EVENT_TYPE_RN = 1;
    public static final int EVENT_TYPE_V2 = 2;
    public static final long PERIOD_FOREGROUND_IN_SECS = 60;
    public static final long PERIOD_IN_SECS = 3600;
    private static final String TAG = "ShopeeTracker";
    private static ShopeeTracker instance;
    private String baseUrl;
    private TrackerLifecycleCallbacks callbacks;
    private Config config;
    private Context context;
    private String endPoint;
    private EventSendScheduler eventSendScheduler;
    private Map<String, String> extras;
    private IntentFilter intentFilter;
    private List<Interceptor> interceptors;
    private ExceptionHandler mHandler;
    private boolean mIsEnabled;
    private boolean mIsForeground;
    private boolean mMonitorEnabled;
    private ExecutorService mService;
    private TrackLogger mTrackLogger;
    private a<TrackingMeta> mTrackingMetaFunction;
    private com.shopee.d.a.b.a networkChangeReceiver;
    private String remoteConfigUrl;
    private EventRepository repository;
    private String rnEndPoint;
    private String trackingUrlV2;

    private ShopeeTracker(Context context2, EventRepository eventRepository, String str, String str2, String str3, Map<String, String> map, String str4, String str5, boolean z, boolean z2, ExceptionHandler exceptionHandler) {
        this.mIsForeground = false;
        this.mService = Executors.newSingleThreadExecutor();
        this.context = context2.getApplicationContext();
        this.repository = eventRepository;
        this.remoteConfigUrl = str3;
        TrackerStrategyManager.createManager(context2.getApplicationContext());
        this.config = TrackerStrategyManager.getInstance().parseConfig();
        final String str6 = this.remoteConfigUrl;
        this.mService.execute(new Runnable() {
            public void run() {
                TrackerStrategyManager.getInstance().asyncRequestTrackerConfig(str6);
            }
        });
        this.extras = map;
        this.rnEndPoint = str4;
        this.mHandler = exceptionHandler;
        this.interceptors = new ArrayList();
        this.baseUrl = str;
        this.endPoint = str2;
        this.trackingUrlV2 = str5;
        this.mIsEnabled = z;
        this.mMonitorEnabled = z2;
        Context context3 = this.context;
        if (context3 instanceof Application) {
            Application application = (Application) context2;
            this.callbacks = new TrackerLifecycleCallbacks(context3);
            application.registerActivityLifecycleCallbacks(this.callbacks);
            application.registerActivityLifecycleCallbacks(new com.shopee.a.a.a());
        }
        this.eventSendScheduler = new EventSendScheduler(this.mHandler);
        if (!this.mIsEnabled) {
            cancelSchedule();
        }
    }

    public static void initialize(Builder builder) {
        instance = builder.build();
    }

    public static boolean isInitialized() {
        ShopeeTracker shopeeTracker = instance;
        return (shopeeTracker == null || shopeeTracker.mTrackingMetaFunction == null) ? false : true;
    }

    public void schedule(boolean z) {
        if (this.mIsForeground != z) {
            this.mIsForeground = z;
            this.eventSendScheduler.schedule(z);
        }
    }

    public void cancelSchedule() {
        this.eventSendScheduler.cancelSchedule();
    }

    /* access modifiers changed from: package-private */
    public String getBaseUrl() {
        return this.baseUrl;
    }

    /* access modifiers changed from: package-private */
    public String getEndPoint() {
        return this.endPoint;
    }

    /* access modifiers changed from: package-private */
    public String getRnEndPoint() {
        return this.rnEndPoint;
    }

    /* access modifiers changed from: package-private */
    public String getTracingUrlV2() {
        return this.trackingUrlV2;
    }

    public TrackingMeta getTrackingMeta() {
        return this.mTrackingMetaFunction.invoke();
    }

    public void setTrackingMetaFunction(a<TrackingMeta> aVar) {
        this.mTrackingMetaFunction = aVar;
    }

    public ShopeeTracker addNetworkInterceptor(Interceptor interceptor) {
        this.interceptors.add(interceptor);
        return this;
    }

    public List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public static synchronized ShopeeTracker getInstance() {
        ShopeeTracker shopeeTracker;
        synchronized (ShopeeTracker.class) {
            if (instance != null) {
                shopeeTracker = instance;
            } else {
                throw new IllegalStateException("you must call initialize first");
            }
        }
        return shopeeTracker;
    }

    public void logAction(final UserAction userAction) {
        this.mService.execute(new Runnable() {
            public void run() {
                ShopeeTracker.this.logActionInternal(userAction);
            }
        });
    }

    public void addRunnable(Runnable runnable) {
        this.mService.execute(runnable);
    }

    public void notifyToUpLoad() {
        this.eventSendScheduler.addTask(new TrackerTaskRunnable());
    }

    /* access modifiers changed from: private */
    public void logActionInternal(UserAction userAction) {
        if (userAction == null || TextUtils.isEmpty(userAction.getActionData())) {
            Logger.debug(TAG, "useraction or action data null,will not log action");
            return;
        }
        o fromString = GsonUtils.fromString(userAction.getActionData());
        if (fromString != null) {
            try {
                l c2 = fromString.c("type");
                if (c2 == null || !TextUtils.equals("v3", c2.c())) {
                    this.repository.add(userAction);
                    return;
                }
                String sessionId = SessionManager.getInstance().getSessionId();
                Long sequenceId = SessionManager.getInstance().getSequenceId();
                Logger.debug(TAG, "sequenceId = " + sequenceId + "sessionId =" + sessionId);
                fromString.a(EventSender.TRACKING_DATA_SESSION_ID, sessionId);
                fromString.a(EventSender.TRACKING_DATA_SEQUENCE_ID, (Number) sequenceId);
                l c3 = fromString.c("civ_id");
                if (c3 == null || TextUtils.isEmpty(c3.c())) {
                    fromString.a("civ_id", b.a().b());
                }
                o e2 = fromString.e("info");
                if (e2 != null) {
                    l c4 = e2.c("operation");
                    if (c4 != null && TextUtils.equals(c4.c(), "view")) {
                        b.a().d(e2.c("page_type").c());
                    }
                    if (e2.c(EventSender.TRACKING_DATA_USAGE_ID) == null) {
                        e2.a(EventSender.TRACKING_DATA_USAGE_ID, (Number) 0);
                    }
                }
                this.repository.add(UserAction.from(userAction.getId(), userAction.getType(), fromString.toString()));
            } catch (Exception e3) {
                Logger.debug(TAG, e3.getMessage());
            }
        }
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public Config getConfig() {
        return this.config;
    }

    public Context getContext() {
        return this.context;
    }

    public ExceptionHandler getHandler() {
        return this.mHandler;
    }

    public void addConfig(String str, String str2) {
        this.extras.put(str, str2);
    }

    public void updateSPCCookie(String str, String str2) {
        final TrackingMeta trackingMeta = getTrackingMeta();
        if (trackingMeta != null) {
            TrackingCookie trackingCookie = new TrackingCookie();
            trackingCookie.SPC_T_IV = str;
            trackingCookie.SPC_T_ID = str2;
            trackingCookie.SPC_F = trackingMeta.finger_print;
            trackingCookie.SPC_U = String.valueOf(trackingMeta.userid);
            trackingMeta.cookies = trackingCookie;
            this.mTrackingMetaFunction = new a<TrackingMeta>() {
                public TrackingMeta invoke() {
                    return trackingMeta;
                }
            };
        }
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public void setEnabled(boolean z) {
        this.mIsEnabled = z;
    }

    public boolean isMonitorEnabled() {
        return this.mMonitorEnabled;
    }

    public void setSessionIntervalTime(long j) {
        TrackerLifecycleCallbacks trackerLifecycleCallbacks = this.callbacks;
        if (trackerLifecycleCallbacks != null) {
            trackerLifecycleCallbacks.setSessionIntervalTime(j);
        }
    }

    public TrackLogger getTrackLogger() {
        return this.mTrackLogger;
    }

    public void setTrackLogger(TrackLogger trackLogger) {
        this.mTrackLogger = trackLogger;
    }

    public static class Builder {
        private String baseUrl;
        private String configUrl;
        private Context context;
        private boolean enabled;
        private String endPoint;
        private Map<String, String> extras = new androidx.b.a();
        private ExceptionHandler mHandler;
        private boolean monitorEnabled;
        private String rnEndPoint;
        private String trackingUrlV2;

        public Builder(Context context2, String str, String str2, String str3) {
            this.context = context2;
            this.baseUrl = str;
            this.endPoint = str2;
            this.rnEndPoint = str3;
        }

        public Builder setHandler(ExceptionHandler exceptionHandler) {
            this.mHandler = exceptionHandler;
            return this;
        }

        public Builder setConfigUrl(String str) {
            this.configUrl = str;
            return this;
        }

        public Builder addConfig(String str, String str2) {
            this.extras.put(str, str2);
            return this;
        }

        public Builder setTrackingUrlV2(String str) {
            this.trackingUrlV2 = str;
            return this;
        }

        public Builder setEnabled(boolean z) {
            this.enabled = z;
            return this;
        }

        public Builder setMonitorEnabled(boolean z) {
            this.monitorEnabled = z;
            return this;
        }

        /* access modifiers changed from: package-private */
        public ShopeeTracker build() {
            return new ShopeeTracker(this.context, new EventRepository(new SQLiteHelper(this.context)), this.baseUrl, this.endPoint, this.configUrl, this.extras, this.rnEndPoint, this.trackingUrlV2, this.enabled, this.monitorEnabled, this.mHandler);
        }
    }
}
