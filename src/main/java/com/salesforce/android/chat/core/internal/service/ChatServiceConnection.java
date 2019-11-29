package com.salesforce.android.chat.core.internal.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.salesforce.android.chat.core.ChatClient;
import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.internal.client.InternalChatClient;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ChatServiceConnection implements ServiceConnection {
    private static boolean sIsBound = false;
    private BasicAsync<ChatClient> mBinderAsync;
    private final InternalChatClient.Builder mChatClientBuilder;
    private final ChatConfigurationSerializer mChatConfigurationSerializer;
    private final IntentFactory mIntentFactory;
    private OnDisconnectedListener mOnDisconnectedListener;

    public interface OnDisconnectedListener {
        void onServiceDisconnected();
    }

    private ChatServiceConnection(InternalChatClient.Builder builder, IntentFactory intentFactory, ChatConfigurationSerializer chatConfigurationSerializer) {
        this.mChatClientBuilder = builder;
        this.mIntentFactory = intentFactory;
        this.mChatConfigurationSerializer = chatConfigurationSerializer;
    }

    public Intent createServiceIntent(Context context, ChatConfiguration chatConfiguration) {
        Arguments.checkNotNull(chatConfiguration);
        Intent createIntent = this.mIntentFactory.createIntent(context, ChatService.class);
        this.mChatConfigurationSerializer.addToIntent(createIntent, chatConfiguration);
        return createIntent;
    }

    public Async<ChatClient> bindService(Context context, Intent intent) {
        if (sIsBound) {
            return BasicAsync.error(new IllegalStateException("Only one Chat instance may exist at a time."));
        }
        sIsBound = context.getApplicationContext().bindService(intent, this, 1);
        if (!sIsBound) {
            return BasicAsync.error(new Exception("Unable to bind to ChatService."));
        }
        this.mBinderAsync = BasicAsync.create();
        return this.mBinderAsync;
    }

    public void stopService(Context context) {
        if (sIsBound) {
            sIsBound = false;
            context.getApplicationContext().unbindService(this);
            context.stopService(this.mIntentFactory.createIntent(context, ChatService.class));
        }
    }

    public void setOnDisconnectedListener(OnDisconnectedListener onDisconnectedListener) {
        this.mOnDisconnectedListener = onDisconnectedListener;
    }

    public static Boolean isBound() {
        return Boolean.valueOf(sIsBound);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if ((iBinder instanceof ChatServiceBinder) && this.mBinderAsync != null) {
            ChatServiceController chatServiceController = ((ChatServiceBinder) iBinder).getChatServiceController();
            this.mBinderAsync.setResult(this.mChatClientBuilder.build(this, chatServiceController));
            this.mBinderAsync.complete();
            this.mBinderAsync = null;
            chatServiceController.createChatSession();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        OnDisconnectedListener onDisconnectedListener = this.mOnDisconnectedListener;
        if (onDisconnectedListener != null) {
            onDisconnectedListener.onServiceDisconnected();
        }
    }

    public static class Builder {
        private InternalChatClient.Builder mChatClientBuilder;
        private ChatConfigurationSerializer mChatConfigurationSerializer;
        private IntentFactory mIntentFactory;

        /* access modifiers changed from: package-private */
        public Builder chatClientBuilder(InternalChatClient.Builder builder) {
            this.mChatClientBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder intentFactory(IntentFactory intentFactory) {
            this.mIntentFactory = intentFactory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder chatConfigurationHandler(ChatConfigurationSerializer chatConfigurationSerializer) {
            this.mChatConfigurationSerializer = chatConfigurationSerializer;
            return this;
        }

        public ChatServiceConnection build() {
            if (this.mChatClientBuilder == null) {
                this.mChatClientBuilder = new InternalChatClient.Builder();
            }
            if (this.mIntentFactory == null) {
                this.mIntentFactory = new IntentFactory();
            }
            if (this.mChatConfigurationSerializer == null) {
                this.mChatConfigurationSerializer = new ChatConfigurationSerializer();
            }
            return new ChatServiceConnection(this.mChatClientBuilder, this.mIntentFactory, this.mChatConfigurationSerializer);
        }
    }
}
