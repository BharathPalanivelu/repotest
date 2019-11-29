package com.salesforce.android.chat.core.internal.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.salesforce.android.chat.core.ChatAnalyticsEmit;
import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.internal.logging.LiveAgentChatLogger;
import com.salesforce.android.chat.core.internal.service.ChatServiceBinder;
import com.salesforce.android.chat.core.internal.service.ChatServiceController;
import com.salesforce.android.service.common.analytics.ServiceAnalytics;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.security.GeneralSecurityException;

public class ChatService extends Service {
    private static final ServiceLogger log = ServiceLogging.getLogger(ChatService.class);
    private final ChatConfigurationSerializer mChatConfigurationSerializer;
    private final ChatServiceBinder.Builder mChatServiceBinderBuilder;
    private ChatServiceController mChatServiceController;
    private final ChatServiceController.Builder mChatServiceControllerBuilder;
    private LiveAgentChatLogger mLiveAgentChatLogger;
    private final LiveAgentChatLogger.Builder mLiveAgentChatLoggerBuilder;

    public ChatService() {
        this(new ChatServiceController.Builder(), new ChatServiceBinder.Builder(), new ChatConfigurationSerializer(), new LiveAgentChatLogger.Builder());
    }

    public ChatService(ChatServiceController.Builder builder, ChatServiceBinder.Builder builder2, ChatConfigurationSerializer chatConfigurationSerializer, LiveAgentChatLogger.Builder builder3) {
        this.mChatServiceControllerBuilder = builder;
        this.mChatServiceBinderBuilder = builder2;
        this.mChatConfigurationSerializer = chatConfigurationSerializer;
        this.mLiveAgentChatLoggerBuilder = builder3;
    }

    public IBinder onBind(Intent intent) {
        log.debug("ChatService is starting");
        ChatConfiguration parseFromIntent = this.mChatConfigurationSerializer.parseFromIntent(intent);
        this.mLiveAgentChatLogger = this.mLiveAgentChatLoggerBuilder.with(this).configuration(parseFromIntent).build();
        ServiceAnalytics.addListener(this.mLiveAgentChatLogger);
        ChatAnalyticsEmit.userInitializeClient(parseFromIntent.getLiveAgentPod(), parseFromIntent.getOrganizationId(), parseFromIntent.getButtonId(), parseFromIntent.getDeploymentId());
        try {
            this.mChatServiceController = this.mChatServiceControllerBuilder.build(this, parseFromIntent);
            return this.mChatServiceBinderBuilder.build(this.mChatServiceController);
        } catch (GeneralSecurityException e2) {
            log.error("Unable to connect to the LiveAgent Server. Chat session cannot begin.", e2);
            return null;
        }
    }

    public void onDestroy() {
        LiveAgentChatLogger liveAgentChatLogger = this.mLiveAgentChatLogger;
        if (liveAgentChatLogger != null) {
            ServiceAnalytics.removeListener(liveAgentChatLogger);
            this.mLiveAgentChatLogger.teardown();
        }
        log.debug("ChatService has been destroyed");
    }
}
