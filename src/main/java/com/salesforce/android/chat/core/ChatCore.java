package com.salesforce.android.chat.core;

import android.content.Context;
import com.salesforce.android.chat.core.internal.availability.AgentAvailability;
import com.salesforce.android.chat.core.internal.service.ChatServiceConnection;
import com.salesforce.android.service.common.utilities.control.Async;

public class ChatCore {
    final ChatConfiguration mChatConfiguration;
    final ChatServiceConnection mChatServiceConnection;

    public static ChatCore configure(ChatConfiguration chatConfiguration) {
        return configure(chatConfiguration, new ChatServiceConnection.Builder().build());
    }

    static ChatCore configure(ChatConfiguration chatConfiguration, ChatServiceConnection chatServiceConnection) {
        return new ChatCore(chatConfiguration, chatServiceConnection);
    }

    public static AgentAvailabilityClient configureAgentAvailability(ChatConfiguration chatConfiguration) {
        return new AgentAvailability.Builder().chatConfiguration(chatConfiguration).build();
    }

    private ChatCore(ChatConfiguration chatConfiguration, ChatServiceConnection chatServiceConnection) {
        this.mChatConfiguration = chatConfiguration;
        this.mChatServiceConnection = chatServiceConnection;
    }

    public Async<ChatClient> createClient(Context context) {
        return this.mChatServiceConnection.bindService(context, this.mChatServiceConnection.createServiceIntent(context, this.mChatConfiguration)).onResult(new Async.ResultHandler<ChatClient>() {
            public void handleResult(Async<?> async, ChatClient chatClient) {
                ChatAnalyticsEmit.responseInitializedClient();
            }
        }).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                ChatAnalyticsEmit.responseError(th);
            }
        });
    }

    public static Boolean isActive() {
        return ChatServiceConnection.isBound();
    }
}
