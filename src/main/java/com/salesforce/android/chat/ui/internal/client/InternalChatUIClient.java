package com.salesforce.android.chat.ui.internal.client;

import android.app.Activity;
import android.content.Context;
import com.salesforce.android.chat.core.ChatClient;
import com.salesforce.android.chat.core.ChatCore;
import com.salesforce.android.chat.core.SessionStateListener;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.ui.ChatEventListener;
import com.salesforce.android.chat.ui.ChatKnowledgeArticlePreviewClickListener;
import com.salesforce.android.chat.ui.ChatKnowledgeArticlePreviewDataProvider;
import com.salesforce.android.chat.ui.ChatUIClient;
import com.salesforce.android.chat.ui.ChatUIConfiguration;
import com.salesforce.android.chat.ui.PreChatUIListener;
import com.salesforce.android.chat.ui.internal.chatfeed.ChatFeedActivity;
import com.salesforce.android.chat.ui.internal.chatfeed.ChatFeedActivityDelegate;
import com.salesforce.android.chat.ui.internal.filetransfer.FileTransferManager;
import com.salesforce.android.chat.ui.internal.linkpreview.KnowledgeArticleClickListenerWrapper;
import com.salesforce.android.chat.ui.internal.linkpreview.KnowledgeArticleDataProviderWrapper;
import com.salesforce.android.chat.ui.internal.messaging.MessageReceiver;
import com.salesforce.android.chat.ui.internal.messaging.MessageSender;
import com.salesforce.android.chat.ui.internal.minimize.ViewStateTracker;
import com.salesforce.android.chat.ui.internal.notification.ChatNotificationManager;
import com.salesforce.android.chat.ui.internal.prechat.PreChatTracker;
import com.salesforce.android.chat.ui.internal.presenter.PresenterManager;
import com.salesforce.android.chat.ui.internal.state.AvatarCache;
import com.salesforce.android.chat.ui.internal.state.StateTracker;
import com.salesforce.android.chat.ui.internal.view.ViewFactory;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import com.salesforce.android.service.common.utilities.functional.OptionalReference;
import com.salesforce.android.service.common.utilities.internal.android.BackgroundTracker;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.lang.ref.WeakReference;

public class InternalChatUIClient implements ChatUIClient, ActivityTracker.OnCreateListener, ActivityTracker.OnDestroyListener {
    private static WeakReference<InternalChatUIClient> mCurrentChatUIClient;
    private ActivityTracker mActivityTracker;
    /* access modifiers changed from: private */
    public final Context mApplicationContext;
    private AvatarCache mAvatarCache;
    private BackgroundTracker mBackgroundTracker;
    private OptionalReference<ChatFeedActivityDelegate> mChatActivityDelegateReference;
    /* access modifiers changed from: private */
    public final ChatCore mChatCore;
    /* access modifiers changed from: private */
    public ChatClient mChatCoreClient;
    private final ChatUIConfiguration mChatUIConfiguration;
    /* access modifiers changed from: private */
    public FileTransferManager mFileTransferManager;
    private final IntentFactory mIntentFactory;
    private ChatKnowledgeArticlePreviewClickListener mKnowledgeArticlePreviewClickListener;
    private ChatKnowledgeArticlePreviewDataProvider mKnowledgeArticlePreviewDataProvider;
    /* access modifiers changed from: private */
    public MessageReceiver mMessageReceiver;
    /* access modifiers changed from: private */
    public MessageSender mMessageSender;
    private PreChatTracker mPreChatTracker;
    private PresenterManager mPresenterManager;
    /* access modifiers changed from: private */
    public StateTracker mStateTracker;
    private ViewFactory.Builder mViewFactoryBuilder;
    /* access modifiers changed from: private */
    public ViewStateTracker mViewStateTracker;

    private InternalChatUIClient(Builder builder) {
        this.mChatActivityDelegateReference = new OptionalReference<>(null);
        this.mApplicationContext = builder.mContext.getApplicationContext();
        this.mChatCore = builder.mChatCore;
        this.mChatUIConfiguration = builder.mChatUIConfiguration;
        this.mIntentFactory = builder.mIntentFactory;
        this.mMessageReceiver = builder.mMessageReceiver;
        this.mMessageSender = builder.mMessageSender;
        this.mViewFactoryBuilder = builder.mViewFactoryBuilder;
        this.mActivityTracker = builder.mActivityTracker;
        this.mFileTransferManager = builder.mFileTransferManager;
        this.mBackgroundTracker = builder.mBackgroundTracker;
        this.mKnowledgeArticlePreviewDataProvider = builder.mKnowledgeArticlePreviewDataProvider;
        this.mKnowledgeArticlePreviewClickListener = builder.mKnowledgeArticlePreviewClickListener;
        ChatEventListener chatEventListener = builder.mChatUIConfiguration.getChatEventListener();
        this.mMessageSender.addChatEventListener(chatEventListener);
        this.mMessageReceiver.addChatEventListener(chatEventListener);
        this.mPresenterManager = builder.mPresenterManagerBuilder.internalChatUIClient(this).build();
        this.mStateTracker = builder.mStateTracker;
        this.mAvatarCache = builder.mAvatarCache;
        this.mPreChatTracker = builder.mPreChatTrackerBuilder.chatUserData(this.mChatUIConfiguration.getChatCoreConfiguration().getChatUserData()).applicationContext(this.mApplicationContext).intentFactory(this.mIntentFactory).activityTracker(this.mActivityTracker).presenterManager(this.mPresenterManager).build();
    }

    private boolean isPreChatDisabled() {
        return this.mChatUIConfiguration.isPreChatDisabled() || this.mChatUIConfiguration.getChatCoreConfiguration().getChatUserData().isEmpty();
    }

    public Async<Boolean> startChatSession(Activity activity) {
        Async async;
        if (ChatCore.isActive().booleanValue()) {
            return BasicAsync.error(new IllegalStateException("Only one Chat instance may exist at a time."));
        }
        InternalChatUIClient internalChatUIClient = null;
        WeakReference<InternalChatUIClient> weakReference = mCurrentChatUIClient;
        if (weakReference != null) {
            internalChatUIClient = (InternalChatUIClient) weakReference.get();
        }
        if (internalChatUIClient != null) {
            internalChatUIClient.mViewStateTracker.closeView();
        }
        mCurrentChatUIClient = new WeakReference<>(this);
        initializeDependencies();
        this.mActivityTracker.setForegroundActivity(activity);
        this.mViewStateTracker.attachTo(activity);
        this.mPresenterManager.getPresenter(1);
        if (Boolean.valueOf(isPreChatDisabled()).booleanValue()) {
            async = BasicAsync.immediate(true);
        } else {
            async = this.mPreChatTracker.showPreChatView();
        }
        final BasicAsync basicAsync = new BasicAsync();
        async.onResult(new Async.ResultHandler<Boolean>() {
            public void handleResult(Async<?> async, Boolean bool) {
                if (!bool.booleanValue()) {
                    basicAsync.setResult(false).complete();
                    InternalChatUIClient.this.endChatSession();
                    return;
                }
                InternalChatUIClient.this.mChatCore.createClient(InternalChatUIClient.this.mApplicationContext).onResult(new Async.ResultHandler<ChatClient>() {
                    public void handleResult(Async<?> async, ChatClient chatClient) {
                        ChatClient unused = InternalChatUIClient.this.mChatCoreClient = chatClient;
                        InternalChatUIClient.this.mStateTracker.setChatClient(InternalChatUIClient.this.mChatCoreClient);
                        InternalChatUIClient.this.mViewStateTracker.setChatClient(InternalChatUIClient.this.mChatCoreClient);
                        InternalChatUIClient.this.mMessageReceiver.setChatClient(InternalChatUIClient.this.mChatCoreClient);
                        InternalChatUIClient.this.mMessageSender.setChatClient(InternalChatUIClient.this.mChatCoreClient);
                        InternalChatUIClient.this.mChatCoreClient.addFileTransferRequestListener(InternalChatUIClient.this.mFileTransferManager);
                        basicAsync.setResult(true).complete();
                    }
                }).onError(new Async.ErrorHandler() {
                    public void handleError(Async<?> async, Throwable th) {
                        basicAsync.setError(th);
                    }
                });
            }
        });
        return basicAsync;
    }

    public void endChatSession() {
        ChatClient chatClient = this.mChatCoreClient;
        if (chatClient != null) {
            chatClient.endChatSession();
        }
        closeChatFeedUI();
        this.mBackgroundTracker.stop();
        this.mMessageReceiver.clearChatEventListener();
        this.mMessageSender.clearChatEventListener();
    }

    public ChatSessionState getCurrentSessionState() {
        return this.mStateTracker.getCurrentChatSessionState();
    }

    public void onActivityCreate(Activity activity) {
        if (activity instanceof ChatFeedActivity) {
            ChatFeedActivityDelegate activityDelegate = ((ChatFeedActivity) activity).getActivityDelegate();
            activityDelegate.setPresenterManager(this.mPresenterManager);
            this.mChatActivityDelegateReference = new OptionalReference<>(activityDelegate);
        }
    }

    public void onActivityDestroy(Activity activity) {
        if (activity instanceof ChatFeedActivity) {
            this.mChatActivityDelegateReference.clearIfSame(((ChatFeedActivity) activity).getActivityDelegate());
        }
    }

    public ChatUIClient addSessionStateListener(SessionStateListener sessionStateListener) {
        this.mStateTracker.addSessionStateListener(sessionStateListener);
        return this;
    }

    public ChatUIClient removeSessionStateListener(SessionStateListener sessionStateListener) {
        this.mStateTracker.removeSessionStateListener(sessionStateListener);
        return this;
    }

    public ChatUIClient addPreChatUIListener(PreChatUIListener preChatUIListener) {
        this.mPreChatTracker.addPreChatListener(preChatUIListener);
        return this;
    }

    public ChatUIClient removePreChatUIListener(PreChatUIListener preChatUIListener) {
        this.mPreChatTracker.removePreChatListener(preChatUIListener);
        return this;
    }

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public boolean isChatBotBannerEnabled() {
        return this.mChatUIConfiguration.isChatBotBannerEnabled();
    }

    public boolean isHyperlinkPreviewEnabled() {
        return this.mChatUIConfiguration.isHyperlinkPreviewEnabled();
    }

    public String getKnowledgeCommunityUrl() {
        return this.mChatUIConfiguration.getKnowledgeCommunityUrl();
    }

    public ChatKnowledgeArticlePreviewDataProvider getKnowledgeArticlePreviewDataProvider() {
        ChatKnowledgeArticlePreviewDataProvider create = KnowledgeArticleDataProviderWrapper.create(this.mChatUIConfiguration.getKnowledgeArticlePreviewDataProvider());
        this.mKnowledgeArticlePreviewDataProvider = create;
        return create;
    }

    public ChatKnowledgeArticlePreviewClickListener getKnowledgeArticlePreviewClickListener() {
        KnowledgeArticleClickListenerWrapper create = KnowledgeArticleClickListenerWrapper.create(this.mChatUIConfiguration.getKnowledgeArticlePreviewClickListener());
        this.mKnowledgeArticlePreviewClickListener = create;
        return create;
    }

    public int getChatBotBannerLayoutId() {
        return this.mChatUIConfiguration.getChatBotBannerLayoutId();
    }

    public int getChatBotAvatarDrawableId() {
        return this.mChatUIConfiguration.getChatBotAvatarDrawableId();
    }

    public void closeChatFeedUI() {
        this.mChatActivityDelegateReference.ifPresent(new Consumer<ChatFeedActivityDelegate>() {
            public void consume(ChatFeedActivityDelegate chatFeedActivityDelegate) {
                chatFeedActivityDelegate.finish();
                InternalChatUIClient.this.mViewStateTracker.onMinimizePressed();
            }
        });
    }

    public void closeMinimizedView() {
        this.mViewStateTracker.closeView();
    }

    public void launchChatFeedUI() {
        this.mApplicationContext.startActivity(ChatFeedActivityDelegate.createStartIntent(this.mApplicationContext, this.mIntentFactory));
    }

    private void initializeDependencies() {
        this.mBackgroundTracker.start();
        this.mActivityTracker.onCreate(this).onDestroy(this);
        this.mActivityTracker.register(this.mApplicationContext);
        this.mViewStateTracker = new ViewStateTracker.Builder().internalChatUIClient(this).chatUIConfiguration(this.mChatUIConfiguration).activityTracker(this.mActivityTracker).viewFactory(this.mViewFactoryBuilder.avatarCache(this.mAvatarCache).build()).presenterManager(this.mPresenterManager).defaultToMinimized(this.mChatUIConfiguration.isDefaultToMinimized()).build();
    }

    public StateTracker getStateTracker() {
        return this.mStateTracker;
    }

    public ViewStateTracker getViewStateTracker() {
        return this.mViewStateTracker;
    }

    public MessageReceiver getMessageReceiver() {
        return this.mMessageReceiver;
    }

    public MessageSender getMessageSender() {
        return this.mMessageSender;
    }

    public FileTransferManager getFileTransferManager() {
        return this.mFileTransferManager;
    }

    public BackgroundTracker getBackgroundTracker() {
        return this.mBackgroundTracker;
    }

    public AvatarCache getAvatarCache() {
        return this.mAvatarCache;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ActivityTracker mActivityTracker;
        /* access modifiers changed from: private */
        public AvatarCache mAvatarCache;
        /* access modifiers changed from: private */
        public BackgroundTracker mBackgroundTracker;
        /* access modifiers changed from: private */
        public ChatCore mChatCore;
        private ChatNotificationManager mChatNotificationManager;
        /* access modifiers changed from: private */
        public ChatUIConfiguration mChatUIConfiguration;
        /* access modifiers changed from: private */
        public Context mContext;
        /* access modifiers changed from: private */
        public FileTransferManager mFileTransferManager;
        /* access modifiers changed from: private */
        public IntentFactory mIntentFactory;
        /* access modifiers changed from: private */
        public ChatKnowledgeArticlePreviewClickListener mKnowledgeArticlePreviewClickListener;
        /* access modifiers changed from: private */
        public ChatKnowledgeArticlePreviewDataProvider mKnowledgeArticlePreviewDataProvider;
        /* access modifiers changed from: private */
        public MessageReceiver mMessageReceiver;
        /* access modifiers changed from: private */
        public MessageSender mMessageSender;
        /* access modifiers changed from: private */
        public PreChatTracker.Builder mPreChatTrackerBuilder;
        /* access modifiers changed from: private */
        public PresenterManager.Builder mPresenterManagerBuilder;
        /* access modifiers changed from: private */
        public StateTracker mStateTracker;
        /* access modifiers changed from: private */
        public ViewFactory.Builder mViewFactoryBuilder;
        private ViewStateTracker.Builder mViewStateTrackerBuilder;

        public Builder context(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder chatUIConfiguration(ChatUIConfiguration chatUIConfiguration) {
            this.mChatUIConfiguration = chatUIConfiguration;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder intentFactory(IntentFactory intentFactory) {
            this.mIntentFactory = intentFactory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder chatCore(ChatCore chatCore) {
            this.mChatCore = chatCore;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder stateTracker(StateTracker stateTracker) {
            this.mStateTracker = stateTracker;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder avatarCache(AvatarCache avatarCache) {
            this.mAvatarCache = avatarCache;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder messageReceiver(MessageReceiver messageReceiver) {
            this.mMessageReceiver = messageReceiver;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder messageSender(MessageSender messageSender) {
            this.mMessageSender = messageSender;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder presenterManagerBuilder(PresenterManager.Builder builder) {
            this.mPresenterManagerBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder viewFactoryBuilder(ViewFactory.Builder builder) {
            this.mViewFactoryBuilder = builder;
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
        public Builder preChatTrackerBuilder(PreChatTracker.Builder builder) {
            this.mPreChatTrackerBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder chatNotificationManager(ChatNotificationManager chatNotificationManager) {
            this.mChatNotificationManager = chatNotificationManager;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder fileTransferManager(FileTransferManager fileTransferManager) {
            this.mFileTransferManager = fileTransferManager;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder knowledgeArticlePreviewDataProvider(ChatKnowledgeArticlePreviewDataProvider chatKnowledgeArticlePreviewDataProvider) {
            this.mKnowledgeArticlePreviewDataProvider = KnowledgeArticleDataProviderWrapper.create(chatKnowledgeArticlePreviewDataProvider);
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder mKnowledgeArticlePreviewClickListener(ChatKnowledgeArticlePreviewClickListener chatKnowledgeArticlePreviewClickListener) {
            this.mKnowledgeArticlePreviewClickListener = KnowledgeArticleClickListenerWrapper.create(chatKnowledgeArticlePreviewClickListener);
            return this;
        }

        public InternalChatUIClient build() {
            Arguments.checkNotNull(this.mContext);
            Arguments.checkNotNull(this.mChatUIConfiguration);
            if (this.mIntentFactory == null) {
                this.mIntentFactory = new IntentFactory();
            }
            if (this.mChatCore == null) {
                this.mChatCore = ChatCore.configure(this.mChatUIConfiguration.getChatCoreConfiguration());
            }
            if (this.mStateTracker == null) {
                this.mStateTracker = new StateTracker();
            }
            if (this.mAvatarCache == null) {
                this.mAvatarCache = new AvatarCache(this.mContext);
            }
            if (this.mMessageReceiver == null) {
                this.mMessageReceiver = new MessageReceiver();
            }
            if (this.mMessageSender == null) {
                this.mMessageSender = new MessageSender.Builder().messageReceiver(this.mMessageReceiver).build();
            }
            if (this.mPresenterManagerBuilder == null) {
                this.mPresenterManagerBuilder = new PresenterManager.Builder();
            }
            if (this.mViewFactoryBuilder == null) {
                this.mViewFactoryBuilder = new ViewFactory.Builder();
            }
            if (this.mActivityTracker == null) {
                this.mActivityTracker = new ActivityTracker();
            }
            if (this.mViewStateTrackerBuilder == null) {
                this.mViewStateTrackerBuilder = new ViewStateTracker.Builder();
            }
            if (this.mPreChatTrackerBuilder == null) {
                this.mPreChatTrackerBuilder = new PreChatTracker.Builder();
            }
            if (this.mBackgroundTracker == null) {
                this.mBackgroundTracker = BackgroundTracker.create(this.mActivityTracker);
            }
            if (this.mChatNotificationManager == null) {
                this.mChatNotificationManager = new ChatNotificationManager.Builder().messageReceiver(this.mMessageReceiver).activityTracker(this.mActivityTracker).with(this.mContext).build();
            }
            if (this.mFileTransferManager == null) {
                this.mFileTransferManager = new FileTransferManager.Builder().with(this.mContext).photoDirectoryName(this.mChatUIConfiguration.getPhotoDirectoryName()).build();
            }
            if (this.mKnowledgeArticlePreviewDataProvider == null) {
                this.mKnowledgeArticlePreviewDataProvider = KnowledgeArticleDataProviderWrapper.create(this.mChatUIConfiguration.getKnowledgeArticlePreviewDataProvider());
            }
            if (this.mKnowledgeArticlePreviewClickListener == null) {
                this.mKnowledgeArticlePreviewClickListener = KnowledgeArticleClickListenerWrapper.create(this.mChatUIConfiguration.getKnowledgeArticlePreviewClickListener());
            }
            return new InternalChatUIClient(this);
        }
    }
}
