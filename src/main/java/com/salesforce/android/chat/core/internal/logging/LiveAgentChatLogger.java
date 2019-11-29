package com.salesforce.android.chat.core.internal.logging;

import android.content.Context;
import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.internal.logging.event.InternalLoggingEventFactory;
import com.salesforce.android.chat.core.internal.logging.event.LoggingEventFactory;
import com.salesforce.android.service.common.analytics.ServiceAnalyticsListener;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLogger;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BatteryEvent;
import com.salesforce.android.service.common.liveagentlogging.event.ConnectivityEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.response.BatchedEventsResponse;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.internal.android.BackgroundTracker;
import com.salesforce.android.service.common.utilities.internal.android.UUIDProvider;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectionInfo;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityState;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker;
import com.salesforce.android.service.common.utilities.internal.device.BatteryLevelTracker;
import com.salesforce.android.service.common.utilities.internal.device.DeviceInfoLoader;
import com.salesforce.android.service.common.utilities.internal.device.OrientationTracker;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.spatial.Orientation;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.Collection;

public class LiveAgentChatLogger implements ServiceAnalyticsListener, LiveAgentLoggingSession.Listener, BackgroundTracker.Listener, ConnectivityTracker.Listener, OrientationTracker.Listener {
    /* access modifiers changed from: private */
    public static final ServiceLogger log = ServiceLogging.getLogger(LiveAgentChatLogger.class);
    private final ActivityTracker mActivityTracker;
    private final BackgroundTracker mBackgroundTracker;
    private final BatteryLevelTracker mBatteryLevelTracker;
    private final ConnectivityTracker mConnectivityTracker;
    private final Context mContext;
    private final String mCorrelationId;
    private final DeviceInfoLoader mDeviceInfoLoader;
    ArrayList<BaseEvent> mInitialEventQueue;
    private final LiveAgentLogger mLiveAgentLogger;
    private final LoggingEventFactory mLoggingEventFactory;
    /* access modifiers changed from: private */
    public LiveAgentLoggingSession mLoggingSession;
    private final String mOrganizationId;
    private final OrientationTracker mOrientationTracker;
    private String mSessionId;

    private LiveAgentChatLogger(Builder builder) {
        this.mInitialEventQueue = new ArrayList<>();
        this.mContext = builder.mContext;
        this.mCorrelationId = builder.mCorrelationId;
        this.mLiveAgentLogger = builder.mLiveAgentLogger;
        this.mLoggingEventFactory = builder.mLoggingEventFactory;
        this.mDeviceInfoLoader = builder.mDeviceInfoLoader;
        this.mBatteryLevelTracker = builder.mBatteryLevelTracker;
        this.mActivityTracker = builder.mActivityTracker;
        this.mBackgroundTracker = builder.mBackgroundTracker;
        this.mConnectivityTracker = builder.mConnectivityTrackerBuilder.build(this.mContext, this);
        this.mOrientationTracker = builder.mOrientationTrackerBuilder.listener(this).build();
        this.mOrganizationId = builder.mChatConfiguration.getOrganizationId();
        this.mSessionId = null;
        this.mBackgroundTracker.addListener(this);
        this.mBackgroundTracker.start();
        queueInitialEvents();
        connect();
    }

    public void teardown() {
        queueFinalEvents();
        this.mConnectivityTracker.teardown();
        this.mOrientationTracker.teardown();
        this.mActivityTracker.unregister();
        this.mBackgroundTracker.removeListener(this);
        this.mBackgroundTracker.stop();
        if (this.mLoggingSession != null) {
            this.mLiveAgentLogger.unbind();
        }
    }

    /* access modifiers changed from: package-private */
    public void queue(BaseEvent baseEvent) {
        baseEvent.setUniqueId(this.mSessionId);
        baseEvent.setOrganizationId(this.mOrganizationId);
        LiveAgentLoggingSession liveAgentLoggingSession = this.mLoggingSession;
        if (liveAgentLoggingSession == null) {
            this.mInitialEventQueue.add(baseEvent);
        } else {
            liveAgentLoggingSession.queue(baseEvent);
        }
    }

    private void queueInitialEvents() {
        queue(this.mLoggingEventFactory.createDeviceEvent(this.mCorrelationId, "3.3.0", this.mDeviceInfoLoader.getDeviceInfo(), this.mDeviceInfoLoader.getAppName(), this.mDeviceInfoLoader.getAppVersion(), this.mDeviceInfoLoader.getDeviceOsVersion()));
        queue(this.mLoggingEventFactory.createOrientationEvent(this.mCorrelationId, this.mOrientationTracker.getOrientation()));
        queue(createBatteryEvent());
        queue(createConnectivityEvent());
    }

    private void queueFinalEvents() {
        queue(createBatteryEvent());
        queue(createConnectivityEvent());
    }

    private void connect() {
        this.mLiveAgentLogger.bind(this.mContext).onResult(new Async.ResultHandler<LiveAgentLoggingSession>() {
            public void handleResult(Async<?> async, LiveAgentLoggingSession liveAgentLoggingSession) {
                LiveAgentLoggingSession unused = LiveAgentChatLogger.this.mLoggingSession = liveAgentLoggingSession;
                LiveAgentChatLogger.this.mLoggingSession.addLoggingSessionListener(LiveAgentChatLogger.this);
                LiveAgentChatLogger.this.mLoggingSession.queue((Collection<? extends BaseEvent>) LiveAgentChatLogger.this.mInitialEventQueue);
                LiveAgentChatLogger.this.mInitialEventQueue.clear();
            }
        });
    }

    private BatteryEvent createBatteryEvent() {
        return this.mLoggingEventFactory.createBatteryEvent(this.mCorrelationId, this.mBatteryLevelTracker.getBatteryLevelPercent());
    }

    private ConnectivityEvent createConnectivityEvent() {
        ConnectionInfo connectionInfo = this.mConnectivityTracker.getConnectionInfo();
        return this.mLoggingEventFactory.createConnectivityEvent(this.mCorrelationId, connectionInfo.getTechnology().name(), connectionInfo.getRadioType().getRadioName());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onServiceAnalyticsEvent(java.lang.String r4, java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 2
            switch(r0) {
                case -1958400405: goto L_0x008a;
                case -1948134431: goto L_0x007f;
                case -1923812134: goto L_0x0075;
                case -1788042928: goto L_0x006b;
                case -1038609359: goto L_0x0061;
                case -522936697: goto L_0x0057;
                case -469973787: goto L_0x004c;
                case 386413379: goto L_0x0041;
                case 687774984: goto L_0x0036;
                case 905817274: goto L_0x002c;
                case 1321522268: goto L_0x0021;
                case 1724797697: goto L_0x0015;
                case 2036975917: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0094
        L_0x000a:
            java.lang.String r0 = "CHAT_RESPONSE_AGENT_REQUEST_FILE_TRANSFER"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0094
            r4 = 5
            goto L_0x0095
        L_0x0015:
            java.lang.String r0 = "CHAT_RESPONSE_AGENT_JOINED_CONFERENCE"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0094
            r4 = 11
            goto L_0x0095
        L_0x0021:
            java.lang.String r0 = "CHAT_RESPONSE_LIFECYCLE_CHANGE"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0094
            r4 = 2
            goto L_0x0095
        L_0x002c:
            java.lang.String r0 = "CHAT_RESPONSE_AGENT_CANCEL_FILE_TRANSFER"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0094
            r4 = 6
            goto L_0x0095
        L_0x0036:
            java.lang.String r0 = "CHAT_RESPONSE_SESSION_CREATED"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0094
            r4 = 10
            goto L_0x0095
        L_0x0041:
            java.lang.String r0 = "CHAT_RESPONSE_AGENT_LEFT_CONFERENCE"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0094
            r4 = 12
            goto L_0x0095
        L_0x004c:
            java.lang.String r0 = "CHAT_RESPONSE_FILE_TRANSFER_FAILED"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0094
            r4 = 9
            goto L_0x0095
        L_0x0057:
            java.lang.String r0 = "CHAT_RESPONSE_MESSAGE_SENT"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0094
            r4 = 0
            goto L_0x0095
        L_0x0061:
            java.lang.String r0 = "CHAT_RESPONSE_ERROR"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0094
            r4 = 4
            goto L_0x0095
        L_0x006b:
            java.lang.String r0 = "CHAT_RESPONSE_MESSAGE_RECEIVED"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0094
            r4 = 1
            goto L_0x0095
        L_0x0075:
            java.lang.String r0 = "CHAT_RESPONSE_SESSION_ENDED"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0094
            r4 = 3
            goto L_0x0095
        L_0x007f:
            java.lang.String r0 = "CHAT_RESPONSE_FILE_TRANSFER_COMPLETE"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0094
            r4 = 8
            goto L_0x0095
        L_0x008a:
            java.lang.String r0 = "CHAT_USER_FILE_TRANSFER_UPLOAD_INITIATED"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0094
            r4 = 7
            goto L_0x0095
        L_0x0094:
            r4 = -1
        L_0x0095:
            java.lang.String r0 = "CHAT_DATA_CURRENT_LIFECYCLE_STATE"
            r2 = 0
            switch(r4) {
                case 0: goto L_0x0180;
                case 1: goto L_0x0175;
                case 2: goto L_0x014e;
                case 3: goto L_0x0135;
                case 4: goto L_0x0118;
                case 5: goto L_0x010d;
                case 6: goto L_0x0101;
                case 7: goto L_0x00ed;
                case 8: goto L_0x00e1;
                case 9: goto L_0x00d5;
                case 10: goto L_0x00c9;
                case 11: goto L_0x00b3;
                case 12: goto L_0x009d;
                default: goto L_0x009b;
            }
        L_0x009b:
            goto L_0x018a
        L_0x009d:
            com.salesforce.android.chat.core.internal.logging.event.LoggingEventFactory r4 = r3.mLoggingEventFactory
            java.lang.String r1 = r3.mCorrelationId
            java.lang.Object r5 = r5.get(r0)
            com.salesforce.android.chat.core.model.ChatSessionState r5 = (com.salesforce.android.chat.core.model.ChatSessionState) r5
            java.lang.String r5 = com.salesforce.android.chat.core.internal.logging.LifecycleEventUtil.convert((com.salesforce.android.chat.core.model.ChatSessionState) r5)
            java.lang.String r0 = "AgentLeftGroupConference"
            com.salesforce.android.chat.core.internal.logging.event.AgentGroupConferenceEvent r2 = r4.createAgentGroupConferenceEvent(r1, r0, r5)
            goto L_0x018a
        L_0x00b3:
            com.salesforce.android.chat.core.internal.logging.event.LoggingEventFactory r4 = r3.mLoggingEventFactory
            java.lang.String r1 = r3.mCorrelationId
            java.lang.Object r5 = r5.get(r0)
            com.salesforce.android.chat.core.model.ChatSessionState r5 = (com.salesforce.android.chat.core.model.ChatSessionState) r5
            java.lang.String r5 = com.salesforce.android.chat.core.internal.logging.LifecycleEventUtil.convert((com.salesforce.android.chat.core.model.ChatSessionState) r5)
            java.lang.String r0 = "AgentJoinedGroupConference"
            com.salesforce.android.chat.core.internal.logging.event.AgentGroupConferenceEvent r2 = r4.createAgentGroupConferenceEvent(r1, r0, r5)
            goto L_0x018a
        L_0x00c9:
            java.lang.String r4 = "CHAT_DATA_LIVE_AGENT_SESSION_ID"
            java.lang.Object r4 = r5.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r3.mSessionId = r4
            goto L_0x018a
        L_0x00d5:
            com.salesforce.android.chat.core.internal.logging.event.LoggingEventFactory r4 = r3.mLoggingEventFactory
            java.lang.String r5 = r3.mCorrelationId
            java.lang.String r0 = "failed"
            com.salesforce.android.chat.core.internal.logging.event.ChatFileTransferEvent r2 = r4.createChatFileTransferEvent(r5, r0, r2)
            goto L_0x018a
        L_0x00e1:
            com.salesforce.android.chat.core.internal.logging.event.LoggingEventFactory r4 = r3.mLoggingEventFactory
            java.lang.String r5 = r3.mCorrelationId
            java.lang.String r0 = "completed"
            com.salesforce.android.chat.core.internal.logging.event.ChatFileTransferEvent r2 = r4.createChatFileTransferEvent(r5, r0, r2)
            goto L_0x018a
        L_0x00ed:
            java.lang.String r4 = "CHAT_FILE_TRANSFER_TYPE"
            java.lang.Object r4 = r5.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            com.salesforce.android.chat.core.internal.logging.event.LoggingEventFactory r5 = r3.mLoggingEventFactory
            java.lang.String r0 = r3.mCorrelationId
            java.lang.String r1 = "initialized"
            com.salesforce.android.chat.core.internal.logging.event.ChatFileTransferEvent r2 = r5.createChatFileTransferEvent(r0, r1, r4)
            goto L_0x018a
        L_0x0101:
            com.salesforce.android.chat.core.internal.logging.event.LoggingEventFactory r4 = r3.mLoggingEventFactory
            java.lang.String r5 = r3.mCorrelationId
            java.lang.String r0 = "cancelled"
            com.salesforce.android.chat.core.internal.logging.event.ChatFileTransferEvent r2 = r4.createChatFileTransferEvent(r5, r0, r2)
            goto L_0x018a
        L_0x010d:
            com.salesforce.android.chat.core.internal.logging.event.LoggingEventFactory r4 = r3.mLoggingEventFactory
            java.lang.String r5 = r3.mCorrelationId
            java.lang.String r0 = "requested"
            com.salesforce.android.chat.core.internal.logging.event.ChatFileTransferEvent r2 = r4.createChatFileTransferEvent(r5, r0, r2)
            goto L_0x018a
        L_0x0118:
            java.lang.String r4 = "CHAT_DATA_ERROR"
            java.lang.Object r4 = r5.get(r4)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            com.salesforce.android.chat.core.internal.logging.event.LoggingEventFactory r5 = r3.mLoggingEventFactory
            java.lang.String r0 = r3.mCorrelationId
            java.lang.String r2 = r4.getMessage()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r4 = com.salesforce.android.chat.core.internal.logging.ErrorEventUtil.parseStackTrace(r4)
            com.salesforce.android.service.common.liveagentlogging.event.ErrorEvent r2 = r5.createErrorEvent(r0, r2, r1, r4)
            goto L_0x018a
        L_0x0135:
            java.lang.String r4 = "CHAT_DATA_END_REASON"
            java.lang.Object r4 = r5.get(r4)
            com.salesforce.android.chat.core.model.ChatEndReason r4 = (com.salesforce.android.chat.core.model.ChatEndReason) r4
            com.salesforce.android.chat.core.internal.logging.event.LoggingEventFactory r5 = r3.mLoggingEventFactory
            java.lang.String r0 = r3.mCorrelationId
            java.lang.String r4 = com.salesforce.android.chat.core.internal.logging.LifecycleEventUtil.convert((com.salesforce.android.chat.core.model.ChatEndReason) r4)
            java.lang.String r1 = "Ended"
            java.lang.String r2 = "Session Cleanup"
            com.salesforce.android.service.common.liveagentlogging.event.LifecycleEvent r2 = r5.createLifecycleEvent(r0, r1, r2, r4)
            goto L_0x018a
        L_0x014e:
            java.lang.Object r4 = r5.get(r0)
            com.salesforce.android.chat.core.model.ChatSessionState r4 = (com.salesforce.android.chat.core.model.ChatSessionState) r4
            java.lang.String r0 = "CHAT_DATA_PREVIOUS_LIFECYCLE_STATE"
            java.lang.Object r5 = r5.get(r0)
            com.salesforce.android.chat.core.model.ChatSessionState r5 = (com.salesforce.android.chat.core.model.ChatSessionState) r5
            com.salesforce.android.chat.core.model.ChatSessionState r0 = com.salesforce.android.chat.core.model.ChatSessionState.Disconnected
            if (r4 != r0) goto L_0x0164
            com.salesforce.android.chat.core.model.ChatSessionState r0 = com.salesforce.android.chat.core.model.ChatSessionState.Ending
            if (r5 == r0) goto L_0x018a
        L_0x0164:
            com.salesforce.android.chat.core.internal.logging.event.LoggingEventFactory r0 = r3.mLoggingEventFactory
            java.lang.String r1 = r3.mCorrelationId
            java.lang.String r4 = com.salesforce.android.chat.core.internal.logging.LifecycleEventUtil.convert((com.salesforce.android.chat.core.model.ChatSessionState) r4)
            java.lang.String r5 = com.salesforce.android.chat.core.internal.logging.LifecycleEventUtil.convert((com.salesforce.android.chat.core.model.ChatSessionState) r5)
            com.salesforce.android.service.common.liveagentlogging.event.LifecycleEvent r2 = r0.createLifecycleEvent(r1, r4, r5)
            goto L_0x018a
        L_0x0175:
            com.salesforce.android.chat.core.internal.logging.event.LoggingEventFactory r4 = r3.mLoggingEventFactory
            java.lang.String r5 = r3.mCorrelationId
            java.lang.String r0 = "agent"
            com.salesforce.android.chat.core.internal.logging.event.ChatMessageEvent r2 = r4.createChatMessageEvent(r5, r0)
            goto L_0x018a
        L_0x0180:
            com.salesforce.android.chat.core.internal.logging.event.LoggingEventFactory r4 = r3.mLoggingEventFactory
            java.lang.String r5 = r3.mCorrelationId
            java.lang.String r0 = "customer"
            com.salesforce.android.chat.core.internal.logging.event.ChatMessageEvent r2 = r4.createChatMessageEvent(r5, r0)
        L_0x018a:
            if (r2 == 0) goto L_0x018f
            r3.queue(r2)
        L_0x018f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.core.internal.logging.LiveAgentChatLogger.onServiceAnalyticsEvent(java.lang.String, java.util.Map):void");
    }

    public void onConnected() {
        LiveAgentLoggingSession liveAgentLoggingSession = this.mLoggingSession;
        if (liveAgentLoggingSession == null) {
            log.warn("Logging session does not exist onConnected. Unable to send events.");
        } else {
            liveAgentLoggingSession.flush();
        }
    }

    public void onFlush(Async<BatchedEventsResponse> async) {
        async.onResult(new Async.ResultHandler<BatchedEventsResponse>() {
            public void handleResult(Async<?> async, BatchedEventsResponse batchedEventsResponse) {
                LiveAgentChatLogger.log.info("Received LA Response: {}", batchedEventsResponse.toString());
            }
        }).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                LiveAgentChatLogger.log.error("Log flush ERROR: {}", th.getMessage());
            }
        });
    }

    public void onEnded() {
        log.info("Chat logging session ended");
    }

    public void onBackgroundChange(boolean z) {
        queue(this.mLoggingEventFactory.createBackgroundedEvent(this.mCorrelationId, z));
    }

    public void onConnectivityChanged(ConnectionInfo connectionInfo, ConnectivityState connectivityState, ConnectivityState connectivityState2) {
        queue(this.mLoggingEventFactory.createConnectivityEvent(this.mCorrelationId, connectionInfo.getTechnology().name(), connectionInfo.getRadioType().getRadioName()));
    }

    public void onOrientationChange(Orientation orientation) {
        queue(this.mLoggingEventFactory.createOrientationEvent(this.mCorrelationId, orientation));
    }

    public static class Builder {
        ActivityTracker mActivityTracker;
        BackgroundTracker mBackgroundTracker;
        BatteryLevelTracker mBatteryLevelTracker;
        ChatConfiguration mChatConfiguration;
        ConnectivityTracker.Builder mConnectivityTrackerBuilder;
        Context mContext;
        String mCorrelationId;
        DeviceInfoLoader mDeviceInfoLoader;
        LiveAgentLogger mLiveAgentLogger;
        LoggingEventFactory mLoggingEventFactory;
        OrientationTracker.Builder mOrientationTrackerBuilder;

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder configuration(ChatConfiguration chatConfiguration) {
            this.mChatConfiguration = chatConfiguration;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder correlationId(String str) {
            this.mCorrelationId = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder liveAgentLogger(LiveAgentLogger liveAgentLogger) {
            this.mLiveAgentLogger = liveAgentLogger;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder loggingEventFactory(LoggingEventFactory loggingEventFactory) {
            this.mLoggingEventFactory = loggingEventFactory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder deviceInfoLoader(DeviceInfoLoader deviceInfoLoader) {
            this.mDeviceInfoLoader = deviceInfoLoader;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder batteryLevelTracker(BatteryLevelTracker batteryLevelTracker) {
            this.mBatteryLevelTracker = batteryLevelTracker;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder activityTracker(ActivityTracker activityTracker) {
            this.mActivityTracker = activityTracker;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder backgroundTracker(BackgroundTracker backgroundTracker) {
            this.mBackgroundTracker = backgroundTracker;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder connectivityTrackerBuilder(ConnectivityTracker.Builder builder) {
            this.mConnectivityTrackerBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder orientationTrackerBuilder(OrientationTracker.Builder builder) {
            this.mOrientationTrackerBuilder = builder;
            return this;
        }

        public LiveAgentChatLogger build() {
            Arguments.checkNotNull(this.mContext);
            Arguments.checkNotNull(this.mChatConfiguration);
            if (this.mCorrelationId == null) {
                this.mCorrelationId = new UUIDProvider().randomUUID().toString();
            }
            if (this.mLoggingEventFactory == null) {
                this.mLoggingEventFactory = new InternalLoggingEventFactory();
            }
            if (this.mDeviceInfoLoader == null) {
                this.mDeviceInfoLoader = new DeviceInfoLoader.Builder().with(this.mContext).build();
            }
            if (this.mBatteryLevelTracker == null) {
                this.mBatteryLevelTracker = new BatteryLevelTracker.Builder().with(this.mContext).build();
            }
            if (this.mActivityTracker == null) {
                this.mActivityTracker = new ActivityTracker();
                this.mActivityTracker.register(this.mContext);
            }
            if (this.mBackgroundTracker == null) {
                this.mBackgroundTracker = BackgroundTracker.create(this.mActivityTracker);
            }
            if (this.mConnectivityTrackerBuilder == null) {
                this.mConnectivityTrackerBuilder = new ConnectivityTracker.Builder();
            }
            if (this.mOrientationTrackerBuilder == null) {
                this.mOrientationTrackerBuilder = new OrientationTracker.Builder().with(this.mContext);
            }
            if (this.mLiveAgentLogger == null) {
                this.mLiveAgentLogger = new LiveAgentLogger.Builder().configuration(new LiveAgentLoggingConfiguration.Builder().build()).build();
            }
            return new LiveAgentChatLogger(this);
        }
    }
}
