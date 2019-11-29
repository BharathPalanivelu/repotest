package com.salesforce.android.chat.core.internal.availability;

import com.google.a.g;
import com.salesforce.android.chat.core.AgentAvailabilityClient;
import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.internal.availability.response.AvailabilityResponse;
import com.salesforce.android.chat.core.internal.availability.response.AvailabilityResponseDeserializer;
import com.salesforce.android.chat.core.internal.liveagent.request.AgentAvailabilityRequest;
import com.salesforce.android.chat.core.internal.liveagent.request.ChatRequestFactory;
import com.salesforce.android.chat.core.model.AvailabilityState;
import com.salesforce.android.service.common.liveagentclient.LiveAgentClient;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.lang.reflect.Type;

public class AgentAvailability implements AgentAvailabilityClient {
    private final AgentAvailabilityRequest mAgentAvailabilityRequest;
    private final ChatConfiguration mChatConfiguration;
    private final LiveAgentClient.Builder mClientBuilder;

    private AgentAvailability(Builder builder) {
        this.mClientBuilder = builder.mLiveAgentClientBuilder;
        this.mChatConfiguration = builder.mChatConfiguration;
        this.mAgentAvailabilityRequest = builder.mAgentAvailabilityRequest;
    }

    public Async<AvailabilityState> check() {
        BasicAsync create = BasicAsync.create();
        try {
            LiveAgentClient build = this.mClientBuilder.build();
            sendWithHandler(build, new SwitchServerResponseHandler(this.mChatConfiguration, create, this.mAgentAvailabilityRequest, build));
            return create;
        } catch (Exception unused) {
            return createErrorAsync();
        }
    }

    public Async<AvailabilityState> verifyLiveAgentPod() {
        BasicAsync create = BasicAsync.create();
        try {
            sendWithHandler(this.mClientBuilder.build(), new AvailabilityResponseHandler(this.mChatConfiguration, create));
            return create;
        } catch (Exception unused) {
            return createErrorAsync();
        }
    }

    private void sendWithHandler(LiveAgentClient liveAgentClient, AvailabilityResponseHandler availabilityResponseHandler) {
        liveAgentClient.send(this.mAgentAvailabilityRequest, AvailabilityResponse.class).addHandler(availabilityResponseHandler);
    }

    private BasicAsync<AvailabilityState> createErrorAsync() {
        return BasicAsync.immediate(new AvailabilityResponse(AvailabilityState.Status.Unknown, this.mChatConfiguration.getLiveAgentPod()));
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public AgentAvailabilityRequest mAgentAvailabilityRequest;
        /* access modifiers changed from: private */
        public ChatConfiguration mChatConfiguration;
        private ChatRequestFactory mChatRequestFactory;
        /* access modifiers changed from: private */
        public LiveAgentClient.Builder mLiveAgentClientBuilder;

        public Builder chatConfiguration(ChatConfiguration chatConfiguration) {
            this.mChatConfiguration = chatConfiguration;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder liveAgentClientBuilder(LiveAgentClient.Builder builder) {
            this.mLiveAgentClientBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder agentAvailabilityRequest(AgentAvailabilityRequest agentAvailabilityRequest) {
            this.mAgentAvailabilityRequest = agentAvailabilityRequest;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder chatRequestFactory(ChatRequestFactory chatRequestFactory) {
            this.mChatRequestFactory = chatRequestFactory;
            return this;
        }

        public AgentAvailability build() {
            Arguments.checkNotNull(this.mChatConfiguration);
            if (this.mLiveAgentClientBuilder == null) {
                this.mLiveAgentClientBuilder = new LiveAgentClient.Builder().gsonBuilder(new g().a((Type) AvailabilityResponse.class, (Object) new AvailabilityResponseDeserializer(this.mChatConfiguration.getLiveAgentPod()))).liveAgentPod(this.mChatConfiguration.getLiveAgentPod());
            }
            if (this.mChatRequestFactory == null) {
                this.mChatRequestFactory = new ChatRequestFactory();
            }
            if (this.mAgentAvailabilityRequest == null) {
                this.mAgentAvailabilityRequest = this.mChatRequestFactory.createAgentAvailabilityRequest(this.mChatConfiguration.getOrganizationId(), this.mChatConfiguration.getDeploymentId(), this.mChatConfiguration.getButtonId());
            }
            return new AgentAvailability(this);
        }
    }
}
