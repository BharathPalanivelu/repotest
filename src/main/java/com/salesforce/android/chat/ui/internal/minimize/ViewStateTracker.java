package com.salesforce.android.chat.ui.internal.minimize;

import android.app.Activity;
import com.salesforce.android.chat.core.ChatClient;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.ui.ChatUIConfiguration;
import com.salesforce.android.chat.ui.internal.chatfeed.ChatFeedActivity;
import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.chat.ui.internal.dialog.ChatEndSessionAlertDialog;
import com.salesforce.android.chat.ui.internal.model.ViewStateHandler;
import com.salesforce.android.chat.ui.internal.model.fullscreen.FullscreenViewStateHandler;
import com.salesforce.android.chat.ui.internal.model.minimize.MinimizedViewStateHandler;
import com.salesforce.android.chat.ui.internal.prechat.PreChatActivity;
import com.salesforce.android.chat.ui.internal.presenter.PresenterManager;
import com.salesforce.android.chat.ui.internal.view.ViewFactory;
import com.salesforce.android.service.common.ui.internal.minimize.Minimizer;
import com.salesforce.android.service.common.utilities.activity.ActivityReference;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ViewStateTracker implements ActivityTracker.OnCreateListener {
    private ActivityReference<Activity> mActivity;
    private final Builder mBuilder;
    private ViewStateHandler mViewStateHandler;

    private ViewStateTracker(Builder builder) {
        this.mActivity = ActivityReference.none();
        this.mBuilder = builder;
        this.mBuilder.mActivityTracker.onCreate(this);
        if (builder.mDefaultToMinimized) {
            createMinimizedViewStateHandler();
        } else {
            this.mViewStateHandler = new FullscreenViewStateHandler(builder.mInternalChatUIClient, builder.mActivityTracker, builder.mChatUIConfiguration.isQueuePositionHidden());
        }
    }

    public void attachTo(Activity activity) {
        this.mActivity = ActivityReference.create(activity);
        this.mViewStateHandler.attachTo(activity);
    }

    public void closeView() {
        this.mViewStateHandler.teardown();
        this.mActivity = null;
    }

    public void onMinimizePressed() {
        this.mViewStateHandler.onMinimizePressed();
        if (this.mViewStateHandler instanceof FullscreenViewStateHandler) {
            createMinimizedViewStateHandler();
            if (this.mActivity.isPresent()) {
                attachTo(this.mActivity.get());
            }
        }
    }

    public void setChatClient(ChatClient chatClient) {
        this.mViewStateHandler.setChatClient(chatClient);
    }

    private void createMinimizedViewStateHandler() {
        ChatSessionState chatSessionState;
        ViewStateHandler viewStateHandler = this.mViewStateHandler;
        if (viewStateHandler != null) {
            chatSessionState = viewStateHandler.getCurrentState();
        } else {
            chatSessionState = ChatSessionState.Ready;
        }
        this.mViewStateHandler = new MinimizedViewStateHandler(this.mBuilder.mChatUIConfiguration, this.mBuilder.mMinimizerBuilder, this.mBuilder.mActivityTracker, this.mBuilder.mPresenterManager, this.mBuilder.mViewFactory, this.mBuilder.mInternalChatUIClient, chatSessionState, new ChatEndSessionAlertDialog());
    }

    public void onActivityCreate(Activity activity) {
        if ((this.mViewStateHandler instanceof FullscreenViewStateHandler) && !(activity instanceof ChatFeedActivity) && !(activity instanceof PreChatActivity)) {
            createMinimizedViewStateHandler();
            this.mViewStateHandler.attachTo(activity);
            this.mViewStateHandler.show();
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ActivityTracker mActivityTracker;
        /* access modifiers changed from: private */
        public ChatUIConfiguration mChatUIConfiguration;
        /* access modifiers changed from: private */
        public boolean mDefaultToMinimized;
        /* access modifiers changed from: private */
        public InternalChatUIClient mInternalChatUIClient;
        /* access modifiers changed from: private */
        public Minimizer.Builder mMinimizerBuilder;
        /* access modifiers changed from: private */
        public PresenterManager mPresenterManager;
        /* access modifiers changed from: private */
        public ViewFactory mViewFactory;

        public Builder internalChatUIClient(InternalChatUIClient internalChatUIClient) {
            this.mInternalChatUIClient = internalChatUIClient;
            return this;
        }

        public Builder chatUIConfiguration(ChatUIConfiguration chatUIConfiguration) {
            this.mChatUIConfiguration = chatUIConfiguration;
            return this;
        }

        public Builder activityTracker(ActivityTracker activityTracker) {
            this.mActivityTracker = activityTracker;
            return this;
        }

        public Builder minimizer(Minimizer.Builder builder) {
            this.mMinimizerBuilder = builder;
            return this;
        }

        public Builder viewFactory(ViewFactory viewFactory) {
            this.mViewFactory = viewFactory;
            return this;
        }

        public Builder presenterManager(PresenterManager presenterManager) {
            this.mPresenterManager = presenterManager;
            return this;
        }

        public Builder defaultToMinimized(boolean z) {
            this.mDefaultToMinimized = z;
            return this;
        }

        public ViewStateTracker build() {
            Arguments.checkNotNull(this.mInternalChatUIClient);
            Arguments.checkNotNull(this.mChatUIConfiguration);
            Arguments.checkNotNull(this.mActivityTracker);
            Arguments.checkNotNull(this.mViewFactory);
            Arguments.checkNotNull(this.mPresenterManager);
            if (this.mMinimizerBuilder == null) {
                this.mMinimizerBuilder = new Minimizer.Builder();
            }
            return new ViewStateTracker(this);
        }
    }
}
