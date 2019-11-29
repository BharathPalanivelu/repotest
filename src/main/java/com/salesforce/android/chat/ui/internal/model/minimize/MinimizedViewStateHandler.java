package com.salesforce.android.chat.ui.internal.model.minimize;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.facebook.internal.ServerProtocol;
import com.salesforce.android.chat.core.ChatBotListener;
import com.salesforce.android.chat.core.ChatClient;
import com.salesforce.android.chat.core.SessionStateListener;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.core.model.ChatMessage;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.chat.core.model.ChatWindowMenu;
import com.salesforce.android.chat.core.model.FileTransferStatus;
import com.salesforce.android.chat.ui.ChatUIConfiguration;
import com.salesforce.android.chat.ui.Mockable;
import com.salesforce.android.chat.ui.internal.chatfeed.ChatFeedActivity;
import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.chat.ui.internal.dialog.ChatEndSessionAlertDialog;
import com.salesforce.android.chat.ui.internal.filetransfer.FileTransferStatusListener;
import com.salesforce.android.chat.ui.internal.messaging.AgentInformationListener;
import com.salesforce.android.chat.ui.internal.messaging.AgentMessageListener;
import com.salesforce.android.chat.ui.internal.messaging.AgentStatusListener;
import com.salesforce.android.chat.ui.internal.messaging.MessageReceiver;
import com.salesforce.android.chat.ui.internal.minimize.presenter.MinimizePresenter;
import com.salesforce.android.chat.ui.internal.minimize.viewbinder.MinimizeViewBinder;
import com.salesforce.android.chat.ui.internal.model.ViewStateHandler;
import com.salesforce.android.chat.ui.internal.presenter.Presenter;
import com.salesforce.android.chat.ui.internal.presenter.PresenterManager;
import com.salesforce.android.chat.ui.internal.view.ViewBinder;
import com.salesforce.android.chat.ui.internal.view.ViewFactory;
import com.salesforce.android.service.common.ui.internal.minimize.MinimizeListener;
import com.salesforce.android.service.common.ui.internal.minimize.Minimizer;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;
import d.d.b.j;
import d.m;
import java.lang.ref.WeakReference;

@Mockable
public class MinimizedViewStateHandler implements ChatBotListener, SessionStateListener, FileTransferStatusListener, AgentInformationListener, AgentMessageListener, AgentStatusListener, ViewStateHandler, MinimizeListener {
    private final ActivityTracker activityTracker;
    private final ChatEndSessionAlertDialog endSessionAlertDialog;
    private ChatClient mChatClient;
    /* access modifiers changed from: private */
    public final InternalChatUIClient mChatUIClient;
    private final ChatUIConfiguration mChatUIConfiguration;
    private int mCurrentPresenter;
    private ChatSessionState mCurrentState;
    private WeakReference<MinimizeViewBinder> mCurrentViewBinder;
    private int mMessageCount;
    private final Minimizer mMinimizer;
    private final PresenterManager mPresenterManager;
    private final ViewFactory mViewFactory;
    private MinimizePresenter minimizePresenter;

    private static /* synthetic */ void mCurrentPresenter$annotations() {
    }

    public void onAgentJoinedConference(String str) {
    }

    public void onAgentLeftConference(String str) {
    }

    public void onChatButtonMenuReceived(ChatWindowButtonMenu chatWindowButtonMenu) {
        j.b(chatWindowButtonMenu, "chatWindowButtonMenu");
    }

    public void onChatFooterMenuReceived(ChatFooterMenu chatFooterMenu) {
        j.b(chatFooterMenu, "chatFooterMenu");
    }

    public void onDropped(Coordinate coordinate) {
        j.b(coordinate, "coordinate");
    }

    public void onTransferToButtonInitiated() {
    }

    public MinimizedViewStateHandler(ChatUIConfiguration chatUIConfiguration, Minimizer.Builder builder, ActivityTracker activityTracker2, PresenterManager presenterManager, ViewFactory viewFactory, InternalChatUIClient internalChatUIClient, ChatSessionState chatSessionState, ChatEndSessionAlertDialog chatEndSessionAlertDialog) {
        j.b(chatUIConfiguration, "mChatUIConfiguration");
        j.b(builder, "minimizerBuilder");
        j.b(activityTracker2, "activityTracker");
        j.b(presenterManager, "mPresenterManager");
        j.b(viewFactory, "mViewFactory");
        j.b(internalChatUIClient, "mChatUIClient");
        j.b(chatSessionState, "mChatSessionState");
        j.b(chatEndSessionAlertDialog, "endSessionAlertDialog");
        this.mChatUIConfiguration = chatUIConfiguration;
        this.activityTracker = activityTracker2;
        this.mPresenterManager = presenterManager;
        this.mViewFactory = viewFactory;
        this.mChatUIClient = internalChatUIClient;
        this.endSessionAlertDialog = chatEndSessionAlertDialog;
        this.mCurrentState = ChatSessionState.Ready;
        this.mCurrentPresenter = -1;
        this.mCurrentViewBinder = new WeakReference<>((Object) null);
        Minimizer build = builder.activityTracker(getActivityTracker()).listener(this).addIgnoredActivity(ChatFeedActivity.class).build();
        j.a((Object) build, "minimizerBuilder\n      .…lass.java)\n      .build()");
        this.mMinimizer = build;
        addListeners();
        this.mCurrentState = chatSessionState;
    }

    public ActivityTracker getActivityTracker() {
        return this.activityTracker;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MinimizedViewStateHandler(ChatUIConfiguration chatUIConfiguration, Minimizer.Builder builder, ActivityTracker activityTracker2, PresenterManager presenterManager, ViewFactory viewFactory, InternalChatUIClient internalChatUIClient, ChatSessionState chatSessionState, ChatEndSessionAlertDialog chatEndSessionAlertDialog, int i, g gVar) {
        this(chatUIConfiguration, builder, activityTracker2, presenterManager, viewFactory, internalChatUIClient, chatSessionState, (i & 128) != 0 ? new ChatEndSessionAlertDialog() : chatEndSessionAlertDialog);
    }

    public void setMinimizePresenter(MinimizePresenter minimizePresenter2) {
        this.minimizePresenter = minimizePresenter2;
    }

    public MinimizePresenter getMinimizePresenter() {
        int i = this.mCurrentPresenter;
        if (i == -1 || !(this.mPresenterManager.getPresenter(i) instanceof MinimizePresenter)) {
            return null;
        }
        Presenter presenter = this.mPresenterManager.getPresenter(this.mCurrentPresenter);
        if (presenter != null) {
            return (MinimizePresenter) presenter;
        }
        throw new m("null cannot be cast to non-null type com.salesforce.android.chat.ui.internal.minimize.presenter.MinimizePresenter");
    }

    public void show() {
        this.mMinimizer.show();
    }

    public void onCreate(ViewGroup viewGroup, Context context) {
        j.b(viewGroup, "container");
        j.b(context, "context");
        int i = 2;
        switch (this.mCurrentState) {
            case Verification:
            case Initializing:
            case Connecting:
                break;
            case InQueue:
                if (!this.mChatUIConfiguration.isQueuePositionHidden()) {
                    i = 3;
                    break;
                }
                break;
            case Ready:
            case Connected:
                i = 4;
                break;
            case Ending:
            case Disconnected:
                i = 5;
                break;
            default:
                i = -1;
                break;
        }
        int i2 = this.mCurrentPresenter;
        if (i2 != i) {
            this.mPresenterManager.destroyPresenter(i2);
            MinimizeViewBinder minimizeViewBinder = (MinimizeViewBinder) this.mCurrentViewBinder.get();
            if (minimizeViewBinder != null) {
                minimizeViewBinder.onDestroyView();
            }
        }
        ViewBinder createViewBinder = this.mViewFactory.createViewBinder(i, this.mPresenterManager.getPresenter(i));
        if (createViewBinder != null) {
            MinimizeViewBinder minimizeViewBinder2 = (MinimizeViewBinder) createViewBinder;
            minimizeViewBinder2.onCreateView(((Activity) context).getLayoutInflater(), viewGroup);
            this.mCurrentPresenter = i;
            this.mCurrentViewBinder = new WeakReference<>(minimizeViewBinder2);
            setUnreadMessageCount(this.mMessageCount);
            return;
        }
        throw new m("null cannot be cast to non-null type com.salesforce.android.chat.ui.internal.minimize.viewbinder.MinimizeViewBinder");
    }

    public void onMinimizePressed() {
        addListeners();
        this.mMessageCount = 0;
        setUnreadMessageCount(this.mMessageCount);
        this.mMinimizer.minimize();
    }

    public void attachTo(Activity activity) {
        j.b(activity, "activity");
        this.mMinimizer.attachTo(activity);
    }

    public void teardown() {
        if (this.mChatClient != null) {
            this.mChatClient = null;
        }
        MinimizeViewBinder minimizeViewBinder = (MinimizeViewBinder) this.mCurrentViewBinder.get();
        if (minimizeViewBinder != null) {
            minimizeViewBinder.onDestroyView();
            this.mCurrentViewBinder.clear();
        }
        this.mMinimizer.destroy();
        this.mPresenterManager.destroyPresenter(this.mCurrentPresenter);
        this.mCurrentPresenter = -1;
        removeListeners();
    }

    public int getCurrentPresenter() {
        return this.mCurrentPresenter;
    }

    public ChatSessionState getCurrentState() {
        return this.mCurrentState;
    }

    public ChatClient getChatClient() {
        return this.mChatClient;
    }

    public void setChatClient(ChatClient chatClient) {
        this.mChatClient = chatClient;
    }

    public void onMinimize() {
        addListeners();
    }

    public void onMaximize(Context context) {
        j.b(context, "context");
        if (((MinimizeViewBinder) this.mCurrentViewBinder.get()) != null && shouldMaximize()) {
            this.mChatUIClient.launchChatFeedUI();
        }
        this.mMessageCount = 0;
    }

    public void onCloseClicked() {
        if (this.mCurrentState.isPostSession()) {
            teardown();
        } else if (getActivityTracker().getForegroundActivity() != null) {
            this.endSessionAlertDialog.accept(new MinimizedViewStateHandler$onCloseClicked$1(this));
            ChatEndSessionAlertDialog chatEndSessionAlertDialog = this.endSessionAlertDialog;
            Activity foregroundActivity = getActivityTracker().getForegroundActivity();
            if (foregroundActivity == null) {
                j.a();
            }
            j.a((Object) foregroundActivity, "activityTracker.foregroundActivity!!");
            chatEndSessionAlertDialog.show(foregroundActivity);
        }
    }

    public void setUnreadMessageCount(int i) {
        MinimizePresenter minimizePresenter2 = getMinimizePresenter();
        if (minimizePresenter2 != null) {
            minimizePresenter2.setUnreadMessageCount(i);
        }
    }

    private void incrementAndUpdateUnreadMessageCount() {
        this.mMessageCount++;
        setUnreadMessageCount(this.mMessageCount);
    }

    public void onSessionStateChange(ChatSessionState chatSessionState) {
        j.b(chatSessionState, ServerProtocol.DIALOG_PARAM_STATE);
        this.mCurrentState = chatSessionState;
        switch (chatSessionState) {
            case Verification:
            case Initializing:
            case Connecting:
            case Connected:
            case InQueue:
                this.mMinimizer.show();
                if (this.mMinimizer.isMinimized()) {
                    this.mMinimizer.show();
                    return;
                }
                return;
            case Ending:
            case Disconnected:
                if (this.mMinimizer.isMinimized()) {
                    this.mMinimizer.show();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onSessionEnded(ChatEndReason chatEndReason) {
        j.b(chatEndReason, "endReason");
        switch (chatEndReason) {
            case EndedByClient:
            case NoAgentsAvailable:
            case NetworkError:
            case VerificationError:
            case Unknown:
                incrementAndUpdateUnreadMessageCount();
                teardown();
                this.mMinimizer.destroy();
                return;
            case EndedByAgent:
                if (this.mMinimizer.isMinimized()) {
                    this.mMinimizer.show();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onChatMenuReceived(ChatWindowMenu chatWindowMenu) {
        j.b(chatWindowMenu, "chatWindowMenu");
        incrementAndUpdateUnreadMessageCount();
    }

    public void onAgentJoined(AgentInformation agentInformation) {
        j.b(agentInformation, "agentInformation");
        incrementAndUpdateUnreadMessageCount();
        MinimizePresenter minimizePresenter2 = getMinimizePresenter();
        if (minimizePresenter2 != null) {
            minimizePresenter2.setAgentInformation(agentInformation);
        }
    }

    public void onChatMessageReceived(ChatMessage chatMessage) {
        j.b(chatMessage, "chatMessage");
        incrementAndUpdateUnreadMessageCount();
    }

    public void onAgentIsTyping(boolean z) {
        MinimizePresenter minimizePresenter2 = getMinimizePresenter();
        if (minimizePresenter2 != null) {
            minimizePresenter2.setAgentIsTyping(z);
        }
    }

    public void onFileTransferStatusChanged(FileTransferStatus fileTransferStatus) {
        j.b(fileTransferStatus, "fileTransferStatus");
        incrementAndUpdateUnreadMessageCount();
    }

    public void maximize(Context context) {
        j.b(context, "context");
        this.mMinimizer.maximize(context);
    }

    private void addListeners() {
        MessageReceiver messageReceiver = this.mChatUIClient.getMessageReceiver();
        messageReceiver.addAgentInformationListener(this);
        messageReceiver.addAgentStatusListener(this);
        messageReceiver.addAgentMessageListener(this);
        messageReceiver.addChatBotListener(this);
        this.mChatUIClient.addSessionStateListener(this);
        this.mChatUIClient.getFileTransferManager().addStatusListener(this);
    }

    private void removeListeners() {
        MessageReceiver messageReceiver = this.mChatUIClient.getMessageReceiver();
        messageReceiver.removeAgentInformationListener(this);
        messageReceiver.removeAgentStatusListener(this);
        messageReceiver.removeAgentMessageListener(this);
        messageReceiver.removeChatBotListener(this);
        this.mChatUIClient.removeSessionStateListener(this);
        this.mChatUIClient.getFileTransferManager().removeStatusListener(this);
    }

    private boolean shouldMaximize() {
        return (getCurrentState() == ChatSessionState.Initializing || getCurrentState() == ChatSessionState.Connecting || getCurrentState() == ChatSessionState.InQueue) ? false : true;
    }
}
