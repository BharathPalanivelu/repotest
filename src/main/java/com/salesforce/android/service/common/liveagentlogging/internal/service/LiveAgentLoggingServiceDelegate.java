package com.salesforce.android.service.common.liveagentlogging.internal.service;

import android.content.Intent;
import android.os.IBinder;
import androidx.b.b;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.internal.InternalLiveAgentLoggingSession;
import com.salesforce.android.service.common.liveagentlogging.internal.PodConnectionManager;
import com.salesforce.android.service.common.liveagentlogging.internal.service.LiveAgentLoggingServiceBinder;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Set;

class LiveAgentLoggingServiceDelegate {
    protected static final ServiceLogger log = ServiceLogging.getLogger(LiveAgentLoggingService.class);
    private final LiveAgentLoggingServiceBinder.Builder mLiveAgentLoggingServiceBinderBuilder;
    private final InternalLiveAgentLoggingSession.Builder mLiveAgentLoggingSessionBuilder;
    protected Set<InternalLiveAgentLoggingSession> mLiveAgentLoggingSessions;
    private final PodConnectionManager.Builder mPodConnectionManagerBuilder;
    protected Set<PodConnectionManager> mPodConnectionManagers;
    private final LiveAgentLoggingService mService;

    LiveAgentLoggingServiceDelegate(LiveAgentLoggingService liveAgentLoggingService) {
        this(liveAgentLoggingService, new LiveAgentLoggingServiceBinder.Builder(), new PodConnectionManager.Builder(), new InternalLiveAgentLoggingSession.Builder());
    }

    LiveAgentLoggingServiceDelegate(LiveAgentLoggingService liveAgentLoggingService, LiveAgentLoggingServiceBinder.Builder builder, PodConnectionManager.Builder builder2, InternalLiveAgentLoggingSession.Builder builder3) {
        this.mPodConnectionManagers = new b();
        this.mLiveAgentLoggingSessions = new b();
        this.mService = liveAgentLoggingService;
        this.mLiveAgentLoggingServiceBinderBuilder = builder;
        this.mPodConnectionManagerBuilder = builder2;
        this.mLiveAgentLoggingSessionBuilder = builder3;
    }

    private void stopConnectivityTracking() {
        for (PodConnectionManager stopConnectivityTracking : this.mPodConnectionManagers) {
            stopConnectivityTracking.stopConnectivityTracking();
        }
    }

    public IBinder onBind(Intent intent) {
        log.debug("LiveAgentLoggingService is starting");
        LiveAgentLoggingConfiguration liveAgentLoggingConfiguration = (LiveAgentLoggingConfiguration) intent.getSerializableExtra(LiveAgentLoggingConfiguration.EXTRA_ID);
        Arguments.checkNotNull(liveAgentLoggingConfiguration);
        PodConnectionManager build = this.mPodConnectionManagerBuilder.with(this.mService).configuration(liveAgentLoggingConfiguration).build();
        InternalLiveAgentLoggingSession build2 = this.mLiveAgentLoggingSessionBuilder.with(this.mService).configuration(liveAgentLoggingConfiguration).podConnectionManager(build).build();
        this.mPodConnectionManagers.add(build);
        this.mLiveAgentLoggingSessions.add(build2);
        return this.mLiveAgentLoggingServiceBinderBuilder.liveAgentLoggingSession(build2).build();
    }

    public void onDestroy() {
        stopConnectivityTracking();
        for (final InternalLiveAgentLoggingSession next : this.mLiveAgentLoggingSessions) {
            next.flush().onComplete(new Async.CompletionHandler() {
                public void handleComplete(Async<?> async) {
                    next.teardown();
                }
            }).onError(new Async.ErrorHandler() {
                public void handleError(Async<?> async, Throwable th) {
                    LiveAgentLoggingServiceDelegate.log.error("Error encountered while sending final logging events. {}", th.getMessage());
                    next.teardown();
                }
            });
        }
        log.debug("LiveAgentLoggingService has been destroyed");
    }
}
