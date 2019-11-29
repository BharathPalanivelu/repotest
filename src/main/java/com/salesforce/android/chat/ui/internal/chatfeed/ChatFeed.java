package com.salesforce.android.chat.ui.internal.chatfeed;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.salesforce.android.chat.core.ChatBotListener;
import com.salesforce.android.chat.core.SessionInfoListener;
import com.salesforce.android.chat.core.SessionStateListener;
import com.salesforce.android.chat.core.exception.EmptyChatMessageException;
import com.salesforce.android.chat.core.exception.SessionDoesNotExistException;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.core.model.ChatMessage;
import com.salesforce.android.chat.core.model.ChatSentMessageReceipt;
import com.salesforce.android.chat.core.model.ChatSessionInfo;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.chat.core.model.ChatWindowMenu;
import com.salesforce.android.chat.core.model.FileTransferStatus;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.AgentIsTypingMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatBanner;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatButtonMenuMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatMenuMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.HorizontalRule;
import com.salesforce.android.chat.ui.internal.chatfeed.model.MessageModelFactory;
import com.salesforce.android.chat.ui.internal.chatfeed.model.MessageSpacer;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.SentMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.SentPhotoMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.ChatViewHolderFactory;
import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.chat.ui.internal.dialog.ChatEndSessionAlertDialog;
import com.salesforce.android.chat.ui.internal.filetransfer.FileTransferManager;
import com.salesforce.android.chat.ui.internal.filetransfer.FileTransferStatusListener;
import com.salesforce.android.chat.ui.internal.filetransfer.FileTransferThumbnailListener;
import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageThumbnail;
import com.salesforce.android.chat.ui.internal.linkpreview.MessageAugmentorFactory;
import com.salesforce.android.chat.ui.internal.linkpreview.MessageAugmentorManager;
import com.salesforce.android.chat.ui.internal.messaging.AgentInformationListener;
import com.salesforce.android.chat.ui.internal.messaging.AgentMessageListener;
import com.salesforce.android.chat.ui.internal.messaging.AgentStatusListener;
import com.salesforce.android.chat.ui.internal.messaging.MessageReceiver;
import com.salesforce.android.chat.ui.internal.messaging.MessageSender;
import com.salesforce.android.chat.ui.internal.presenter.PresenterBuilder;
import com.salesforce.android.chat.ui.internal.state.AvatarCache;
import com.salesforce.android.chat.ui.internal.state.StateTracker;
import com.salesforce.android.service.common.ui.internal.android.LayoutInflaterFactory;
import com.salesforce.android.service.common.ui.internal.messaging.MessageFeedAdapter;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import com.salesforce.android.service.common.utilities.functional.Optional;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectionInfo;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityState;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import d.d.a.a;
import d.p;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChatFeed implements ChatBotListener, SessionInfoListener, SessionStateListener, ChatFeedPresenter, FileTransferStatusListener, FileTransferThumbnailListener, AgentInformationListener, AgentMessageListener, AgentStatusListener {
    private static final int USER_TYPING_TIMEOUT_MS = 5000;
    private static final ServiceLogger log = ServiceLogging.getLogger(ChatFeedPresenter.class);
    AgentInformation mAgentInformation;
    AgentIsTypingMessage mAgentIsTypingMessage;
    private Map<String, String> mAgents;
    private final MessageAugmentorManager mAugmenterManager;
    private final AvatarCache mAvatarCache;
    private String mCachedMessage;
    private ChatBanner mChatBanner;
    private final ChatBotFooterMenuAdapter mChatBotFooterMenuAdapter;
    private final ChatFeedTransferUIManager mChatFeedTransferUIManager;
    /* access modifiers changed from: private */
    public ChatFeedView mChatFeedView;
    private ChatSessionInfo mChatSessionInfo;
    private final InternalChatUIClient mChatUIClient;
    /* access modifiers changed from: private */
    public boolean mConnected;
    private ConnectivityTracker mConnectivityTracker;
    private SentPhotoMessage mCurrentSendingPhoto;
    /* access modifiers changed from: private */
    public final FileTransferManager mFileTransferManager;
    private final Handler mHandler;
    private ChatButtonMenuMessage mLastReceivedChatButtonMenuMessage;
    private ChatMenuMessage mLastReceivedChatMenuMessage;
    /* access modifiers changed from: private */
    public final MessageFeedAdapter mMessageFeedAdapter;
    private final MessageModelFactory mMessageModelFactory;
    private final MessageReceiver mMessageReceiver;
    private final MessageSender mMessageSender;
    /* access modifiers changed from: private */
    public Optional<Uri> mNewImageContentUri;
    private final StateTracker mStateTracker;

    private ChatFeed(Builder builder) {
        this.mNewImageContentUri = Optional.empty();
        this.mCachedMessage = "";
        this.mConnected = true;
        this.mAgents = new HashMap();
        this.mChatUIClient = builder.mChatUIClient;
        this.mMessageFeedAdapter = builder.mMessageFeedAdapter;
        this.mChatBotFooterMenuAdapter = builder.mChatBotFooterMenuAdapter;
        this.mMessageModelFactory = builder.mMessageModelFactory;
        this.mMessageReceiver = builder.mMessageReceiver;
        this.mMessageSender = builder.mMessageSender;
        this.mStateTracker = builder.mStateTracker;
        this.mAvatarCache = builder.mAvatarCache;
        this.mFileTransferManager = builder.mFileTransferManager;
        this.mHandler = builder.mHandler;
        this.mAugmenterManager = builder.mAugmentorManager;
        this.mChatFeedTransferUIManager = builder.mChatFeedTransferUIManager;
        this.mChatFeedTransferUIManager.setOnEndSessionConfirmation(endSessionHandler());
        this.mConnectivityTracker = builder.mConnectivityTrackerBuilder.build(getApplicationContext(), new ConnectivityTracker.Listener() {
            public void onConnectivityChanged(ConnectionInfo connectionInfo, ConnectivityState connectivityState, ConnectivityState connectivityState2) {
                boolean unused = ChatFeed.this.mConnected = connectionInfo.isConnected();
                if (ChatFeed.this.mChatFeedView != null) {
                    ChatFeed.this.mChatFeedView.toggleConnectionBanner(connectionInfo.isConnected() && connectivityState.equals(ConnectivityState.CONNECTED));
                }
            }
        });
    }

    public void sendMessage(String str) {
        ChatSessionInfo chatSessionInfo = this.mChatSessionInfo;
        if (chatSessionInfo == null) {
            log.warn("Unable to send message - Chat session information not available.");
            return;
        }
        final SentMessage newSentMessage = this.mMessageModelFactory.newSentMessage(chatSessionInfo.getVisitorId(), str, new Date());
        disableLastChatMenu();
        removeLastChatButtonMenuIfPresent();
        this.mMessageFeedAdapter.add(newSentMessage);
        this.mMessageSender.send(str).onResult(new Async.ResultHandler<ChatSentMessageReceipt>() {
            public void handleResult(Async<?> async, ChatSentMessageReceipt chatSentMessageReceipt) {
                if (chatSentMessageReceipt.isScrubbed()) {
                    newSentMessage.setDeliveryState(3);
                } else {
                    newSentMessage.setDeliveryState(1);
                }
                newSentMessage.setMessageText(chatSentMessageReceipt.getScrubbedText());
            }
        }).onComplete(new Async.CompletionHandler() {
            public void handleComplete(Async<?> async) {
                ChatFeed.this.mMessageFeedAdapter.notifyItemChanged(newSentMessage);
            }
        }).onError(new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                if (!(th instanceof EmptyChatMessageException) || ((EmptyChatMessageException) th).getTriggeredSensitiveDataRules().length <= 0) {
                    newSentMessage.setDeliveryState(2);
                } else {
                    newSentMessage.setDeliveryState(4);
                }
                ChatFeed.this.mMessageFeedAdapter.notifyItemChanged(newSentMessage);
            }
        });
        scrollToBottom();
        handleAgentIsTyping(this.mMessageReceiver.isAgentTyping());
    }

    public void sendSneakPeekMessage(String str) {
        this.mMessageSender.sendSneakPeek(str);
    }

    public void setIsUserTyping(boolean z) {
        this.mMessageSender.setIsUserTyping(z);
        this.mHandler.removeCallbacksAndMessages((Object) null);
        if (z) {
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    ChatFeed.this.setIsUserTyping(false);
                }
            }, 5000);
        }
    }

    public void setCachedMessageInput(String str) {
        this.mCachedMessage = str;
    }

    public String getCachedMessageInput() {
        return this.mCachedMessage;
    }

    public void endSession() {
        this.mMessageSender.setIsUserTyping(false);
        this.mChatUIClient.endChatSession();
    }

    public void onMinimizePressed() {
        this.mChatUIClient.getViewStateTracker().onMinimizePressed();
        this.mChatUIClient.closeChatFeedUI();
    }

    public ChatSessionState getCurrentSessionState() {
        return this.mStateTracker.getCurrentChatSessionState();
    }

    public Uri getLastPhotoTaken() throws FileNotFoundException {
        return this.mFileTransferManager.getLastPhotoTaken();
    }

    public void transferImage(final Uri uri) {
        this.mFileTransferManager.getStatus().ifPresent(new Consumer<FileTransferStatus>() {
            public void consume(FileTransferStatus fileTransferStatus) {
                if (fileTransferStatus == FileTransferStatus.Requested) {
                    ChatFeed.this.mFileTransferManager.transferImage(uri);
                }
            }
        });
    }

    public Uri createNewImageContent() {
        Uri createNewImage = this.mFileTransferManager.createNewImage();
        this.mNewImageContentUri = Optional.of(createNewImage);
        return createNewImage;
    }

    public void transferNewImageContent() {
        this.mNewImageContentUri.ifPresent(new Consumer<Uri>() {
            public void consume(Uri uri) {
                ChatFeed.this.mFileTransferManager.transferImage(uri);
                Optional unused = ChatFeed.this.mNewImageContentUri = Optional.empty();
            }
        });
    }

    public void onCreate() {
        this.mMessageReceiver.addAgentMessageListener(this);
        this.mMessageReceiver.addAgentInformationListener(this);
        this.mMessageReceiver.addAgentStatusListener(this);
        this.mMessageReceiver.addChatBotListener(this);
        this.mStateTracker.addSessionStateListener(this);
        this.mStateTracker.addSessionInfoListener(this);
        this.mFileTransferManager.addThumbnailListener(this);
        this.mFileTransferManager.addStatusListener(this);
        this.mAgentInformation = this.mMessageReceiver.getAgentInformation();
        handleAgentIsTyping(this.mMessageReceiver.isAgentTyping());
    }

    public void onViewCreated(ChatFeedView chatFeedView) {
        this.mChatFeedView = chatFeedView;
        this.mChatFeedView.setMessageFeedAdapter(this.mMessageFeedAdapter);
        this.mChatFeedTransferUIManager.attach(chatFeedView.getContext());
        this.mFileTransferManager.getStatus().ifPresent(new Consumer<FileTransferStatus>() {
            public void consume(FileTransferStatus fileTransferStatus) {
                ChatFeed.this.mChatFeedView.setPhotoSelectionEnabled(fileTransferStatus == FileTransferStatus.Requested || fileTransferStatus == FileTransferStatus.LocalError);
            }
        });
        AgentInformation agentInformation = this.mAgentInformation;
        if (agentInformation != null) {
            this.mChatFeedView.setAgentInformation(agentInformation);
            this.mChatFeedTransferUIManager.setAgentInformation(this.mAgentInformation);
            if (isChatBot(this.mAgentInformation)) {
                this.mChatFeedView.setFooterMenuAdapter(this.mChatBotFooterMenuAdapter);
                this.mChatFeedView.enableFooterMenu();
            }
        }
        if (this.mStateTracker.getCurrentChatSessionState() == ChatSessionState.Disconnected) {
            this.mChatFeedView.disableInputs();
        }
        if (!this.mConnected) {
            this.mChatFeedView.toggleConnectionBanner(false);
        }
    }

    public void onViewDestroyed(ChatFeedView chatFeedView) {
        if (this.mChatFeedView == chatFeedView) {
            this.mMessageSender.setIsUserTyping(false);
            this.mChatFeedView = null;
        }
    }

    public void onDestroy() {
        this.mMessageReceiver.removeAgentMessageListener(this);
        this.mMessageReceiver.removeAgentInformationListener(this);
        this.mMessageReceiver.removeAgentStatusListener(this);
        this.mMessageReceiver.removeChatBotListener(this);
        this.mFileTransferManager.removeThumbnailListener(this);
        this.mFileTransferManager.removeStatusListener(this);
        this.mStateTracker.removeSessionStateListener(this);
        this.mStateTracker.removeSessionInfoListener(this);
        ConnectivityTracker connectivityTracker = this.mConnectivityTracker;
        if (connectivityTracker != null) {
            connectivityTracker.teardown();
        }
    }

    public Context getApplicationContext() {
        return this.mChatUIClient.getApplicationContext();
    }

    public void onChatMessageReceived(ChatMessage chatMessage) {
        if (this.mAgentInformation == null) {
            log.warn("Unable to display agent message - Agent information is not available");
            return;
        }
        if (this.mAgents.containsKey(chatMessage.getAgentName()) && !isChatBot(this.mAgentInformation)) {
            this.mAgents.put(chatMessage.getAgentName(), chatMessage.getAgentId());
        }
        ReceivedMessage newReceivedMessage = this.mMessageModelFactory.newReceivedMessage(chatMessage.getAgentId(), chatMessage.getAgentName(), chatMessage.getText(), chatMessage.getTimestamp());
        this.mMessageFeedAdapter.add(newReceivedMessage);
        notifyAugmentors(newReceivedMessage);
        scrollToBottom();
    }

    public void onAgentJoined(AgentInformation agentInformation) {
        boolean isChatBotBannerEnabled = this.mChatUIClient.isChatBotBannerEnabled();
        if (!isChatBot(agentInformation)) {
            this.mAgents.clear();
            this.mAgents.put(agentInformation.getAgentName(), agentInformation.getAgentId());
        }
        if (isChatBot(agentInformation)) {
            this.mAvatarCache.addAvatar(agentInformation.getAgentId(), this.mChatUIClient.getChatBotAvatarDrawableId());
            if (isChatBotBannerEnabled) {
                this.mChatBanner = new ChatBanner(this.mChatUIClient.getChatBotBannerLayoutId());
            }
        }
        showChatBanner();
        handleAgentIsTyping(false);
        this.mAgentInformation = agentInformation;
        this.mAgentIsTypingMessage = this.mMessageModelFactory.newAgentIsTypingMessage(this.mAgentInformation.getAgentId(), this.mAgentInformation.getAgentName(), new Date());
        this.mChatFeedTransferUIManager.hideChatTransferUI();
        this.mChatFeedTransferUIManager.setAgentInformation(this.mAgentInformation);
        this.mMessageFeedAdapter.add(this.mMessageModelFactory.newHorizontalRule(String.format(getApplicationContext().getString(R.string.chat_session_transferred_to_agent), new Object[]{this.mAgentInformation.getAgentName()})));
        ChatFeedView chatFeedView = this.mChatFeedView;
        if (chatFeedView != null) {
            chatFeedView.setAgentInformation(this.mAgentInformation);
            if (isChatBot(agentInformation)) {
                this.mChatFeedView.setFooterMenuAdapter(this.mChatBotFooterMenuAdapter);
                this.mChatFeedView.enableFooterMenu();
            }
        }
    }

    public void onTransferToButtonInitiated() {
        this.mAgentInformation = null;
        this.mChatFeedTransferUIManager.showChatTransferUI();
        ChatFeedView chatFeedView = this.mChatFeedView;
        if (chatFeedView != null) {
            chatFeedView.disableFooterMenu();
            this.mChatFeedView.onTransferringToAgent();
            scrollToBottom();
        }
        disableLastChatMenu();
    }

    public void onAgentJoinedConference(String str) {
        handleAgentIsTyping(false);
        this.mAgents.put(str, "unknown");
        this.mAvatarCache.addInitialAvatar(str);
        this.mMessageFeedAdapter.add(this.mMessageModelFactory.newAgentHasJoinedConferenceMessage(str));
        scrollToBottom();
    }

    public void onAgentLeftConference(String str) {
        this.mAgents.remove(str);
        this.mAvatarCache.removeInitialAvatar(str);
        updateAgentIsTypingAvatar();
        this.mMessageFeedAdapter.add(this.mMessageModelFactory.newAgentHasLeftConferenceMessage(str));
        scrollToBottom();
    }

    private void updateAgentIsTypingAvatar() {
        if (this.mAgents.size() == 1) {
            AgentIsTypingMessage agentIsTypingMessage = this.mAgentIsTypingMessage;
            if (agentIsTypingMessage != null) {
                agentIsTypingMessage.setAgentName(this.mAgents.keySet().iterator().next());
                this.mAgentIsTypingMessage.setAgentId(this.mAgents.values().iterator().next());
            }
        }
    }

    public void onAgentIsTyping(boolean z) {
        if (this.mAgents.size() == 1) {
            handleAgentIsTyping(z);
        }
    }

    public void onSessionStateChange(ChatSessionState chatSessionState) {
        if (chatSessionState.isPostSession()) {
            ChatFeedView chatFeedView = this.mChatFeedView;
            if (chatFeedView != null) {
                chatFeedView.disableInputs();
            }
        }
    }

    public void onSessionEnded(ChatEndReason chatEndReason) {
        if (chatEndReason == ChatEndReason.EndedByAgent) {
            handleSessionEndedByAgent();
        }
        if (chatEndReason == ChatEndReason.NoAgentsAvailable) {
            this.mChatFeedTransferUIManager.hideChatTransferUI();
            this.mMessageFeedAdapter.add(this.mMessageModelFactory.newChatBotTransferNoAgentsAvailableMessage());
        }
    }

    public void onSessionInfoReceived(ChatSessionInfo chatSessionInfo) {
        this.mChatSessionInfo = chatSessionInfo;
    }

    public void onThumbnailCached(ImageThumbnail imageThumbnail) {
        ChatSessionInfo chatSessionInfo = this.mChatSessionInfo;
        if (chatSessionInfo == null) {
            log.warn("Unable to show image thumbnail - Chat session information not available.");
            return;
        }
        this.mCurrentSendingPhoto = this.mMessageModelFactory.newSentPhotoMessage(chatSessionInfo.getVisitorId(), imageThumbnail, new Date());
        this.mMessageFeedAdapter.add(this.mCurrentSendingPhoto);
        ChatFeedView chatFeedView = this.mChatFeedView;
        if (chatFeedView != null) {
            chatFeedView.setPhotoSelectionEnabled(false);
            scrollToBottom();
        }
    }

    /* renamed from: com.salesforce.android.chat.ui.internal.chatfeed.ChatFeed$18  reason: invalid class name */
    static /* synthetic */ class AnonymousClass18 {
        static final /* synthetic */ int[] $SwitchMap$com$salesforce$android$chat$core$model$FileTransferStatus = new int[FileTransferStatus.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.salesforce.android.chat.core.model.FileTransferStatus[] r0 = com.salesforce.android.chat.core.model.FileTransferStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$salesforce$android$chat$core$model$FileTransferStatus = r0
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$FileTransferStatus     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.salesforce.android.chat.core.model.FileTransferStatus r1 = com.salesforce.android.chat.core.model.FileTransferStatus.Completed     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$FileTransferStatus     // Catch:{ NoSuchFieldError -> 0x001f }
                com.salesforce.android.chat.core.model.FileTransferStatus r1 = com.salesforce.android.chat.core.model.FileTransferStatus.Requested     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$FileTransferStatus     // Catch:{ NoSuchFieldError -> 0x002a }
                com.salesforce.android.chat.core.model.FileTransferStatus r1 = com.salesforce.android.chat.core.model.FileTransferStatus.Canceled     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$salesforce$android$chat$core$model$FileTransferStatus     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.salesforce.android.chat.core.model.FileTransferStatus r1 = com.salesforce.android.chat.core.model.FileTransferStatus.Failed     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.ui.internal.chatfeed.ChatFeed.AnonymousClass18.<clinit>():void");
        }
    }

    public void onFileTransferStatusChanged(FileTransferStatus fileTransferStatus) {
        int i;
        int i2 = AnonymousClass18.$SwitchMap$com$salesforce$android$chat$core$model$FileTransferStatus[fileTransferStatus.ordinal()];
        boolean z = true;
        if (i2 != 1) {
            if (i2 == 2) {
                i = R.string.chat_file_transfer_requested;
            } else if (i2 != 3) {
                i = R.string.chat_file_transfer_failed;
                resetCurrentSendingPhoto();
            } else {
                i = R.string.chat_file_transfer_canceled;
                resetCurrentSendingPhoto();
            }
            this.mMessageFeedAdapter.add(this.mMessageModelFactory.newNotice(i));
            ChatFeedView chatFeedView = this.mChatFeedView;
            if (chatFeedView != null) {
                if (!(fileTransferStatus == FileTransferStatus.Requested || fileTransferStatus == FileTransferStatus.LocalError)) {
                    z = false;
                }
                chatFeedView.setPhotoSelectionEnabled(z);
                scrollToBottom();
                return;
            }
            return;
        }
        resetCurrentSendingPhoto();
    }

    public void onChatMenuReceived(ChatWindowMenu chatWindowMenu) {
        if (!isAgentInformationNull()) {
            disableLastChatMenu();
            ChatMenuMessage newChatMenu = this.mMessageModelFactory.newChatMenu(this.mAgentInformation.getAgentId(), chatWindowMenu.getHeaderText(), chatWindowMenu.getTimestamp(), chatWindowMenu.getMenuItems());
            newChatMenu.setOnMenuItemSelectedListener(new ChatMenuMessage.OnMenuItemSelectedListener() {
                public void onMenuItemSelected(ChatMenuMessage chatMenuMessage, ChatWindowMenu.MenuItem menuItem) {
                    ChatFeed.this.mMessageFeedAdapter.notifyItemChanged(chatMenuMessage);
                    ChatFeed.this.onChatMenuItemSelected(chatMenuMessage, menuItem);
                }
            });
            this.mMessageFeedAdapter.add(newChatMenu);
            this.mLastReceivedChatMenuMessage = newChatMenu;
            scrollToBottom();
        }
    }

    public void onChatFooterMenuReceived(ChatFooterMenu chatFooterMenu) {
        this.mChatBotFooterMenuAdapter.setMenuItems(chatFooterMenu);
        ChatFeedView chatFeedView = this.mChatFeedView;
        if (chatFeedView != null) {
            chatFeedView.setFooterMenuAdapter(this.mChatBotFooterMenuAdapter);
        }
    }

    public void onChatButtonMenuReceived(ChatWindowButtonMenu chatWindowButtonMenu) {
        if (!isAgentInformationNull()) {
            final ChatButtonMenuMessage newChatButtonMenu = this.mMessageModelFactory.newChatButtonMenu(new Date(), chatWindowButtonMenu.getButtons());
            newChatButtonMenu.setOnChatButtonSelectedListener(new ChatButtonMenuMessage.OnChatButtonSelectedListener() {
                public void onChatButtonSelected(ChatButtonMenuMessage chatButtonMenuMessage, ChatWindowButtonMenu.Button button) {
                    ChatFeed.this.onChatMenuButtonSelected(newChatButtonMenu, button);
                }
            });
            removeLastChatButtonMenuIfPresent();
            this.mMessageFeedAdapter.add(newChatButtonMenu);
            this.mLastReceivedChatButtonMenuMessage = newChatButtonMenu;
            scrollToBottom();
        }
    }

    /* access modifiers changed from: package-private */
    public void onChatMenuButtonSelected(ChatButtonMenuMessage chatButtonMenuMessage, ChatWindowButtonMenu.Button button) {
        ChatSessionInfo chatSessionInfo = this.mChatSessionInfo;
        if (chatSessionInfo != null) {
            final SentMessage newSentMessage = this.mMessageModelFactory.newSentMessage(chatSessionInfo.getVisitorId(), button.getLabel(), new Date());
            this.mMessageFeedAdapter.add(newSentMessage);
            this.mMessageFeedAdapter.remove(chatButtonMenuMessage);
            removeLastChatButtonMenuIfPresent();
            this.mMessageSender.sendButtonSelection(button).onComplete(new Async.CompletionHandler() {
                public void handleComplete(Async<?> async) {
                    ChatFeed.this.handleSend(newSentMessage, 1);
                    ChatFeed.this.scrollToBottom();
                }
            }).onError(new Async.ErrorHandler() {
                public void handleError(Async<?> async, Throwable th) {
                    ChatFeed.this.handleSend(newSentMessage, 2);
                }
            });
        }
    }

    public void sendFooterMenuSelection(ChatFooterMenu.MenuItem menuItem) {
        ChatSessionInfo chatSessionInfo = this.mChatSessionInfo;
        if (chatSessionInfo != null) {
            final SentMessage newSentMessage = this.mMessageModelFactory.newSentMessage(chatSessionInfo.getVisitorId(), menuItem.getText(), new Date());
            this.mMessageFeedAdapter.add(newSentMessage);
            disableLastChatMenu();
            removeLastChatButtonMenuIfPresent();
            this.mMessageSender.sendFooterMenuSelection(menuItem).onComplete(new Async.CompletionHandler() {
                public void handleComplete(Async<?> async) {
                    ChatFeed.this.handleSend(newSentMessage, 1);
                    ChatFeed.this.scrollToBottom();
                }
            }).onError(new Async.ErrorHandler() {
                public void handleError(Async<?> async, Throwable th) {
                    ChatFeed.this.handleSend(newSentMessage, 2);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void onChatMenuItemSelected(final ChatMenuMessage chatMenuMessage, ChatWindowMenu.MenuItem menuItem) {
        ChatSessionInfo chatSessionInfo = this.mChatSessionInfo;
        if (chatSessionInfo != null) {
            final SentMessage newSentMessage = this.mMessageModelFactory.newSentMessage(chatSessionInfo.getVisitorId(), menuItem.getLabel(), new Date());
            this.mMessageFeedAdapter.add(newSentMessage);
            this.mMessageSender.sendMenuSelection(menuItem).onComplete(new Async.CompletionHandler() {
                public void handleComplete(Async<?> async) {
                    ChatFeed.this.handleSend(newSentMessage, 1);
                    ChatFeed.this.scrollToBottom();
                }
            }).onError(new Async.ErrorHandler() {
                public void handleError(Async<?> async, Throwable th) {
                    if (!(th instanceof IOException) && !(th instanceof SessionDoesNotExistException)) {
                        chatMenuMessage.setEnabled(true);
                        ChatFeed.this.handleSend(newSentMessage, 2);
                        ChatFeed.this.mMessageFeedAdapter.notifyItemChanged(chatMenuMessage);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void handleSend(SentMessage sentMessage, int i) {
        sentMessage.setDeliveryState(i);
        this.mMessageFeedAdapter.notifyItemChanged(sentMessage);
    }

    private boolean isAgentInformationNull() {
        boolean z = this.mAgentInformation == null;
        if (z) {
            log.warn("Unable to display agent message - Agent information is not available");
        }
        return z;
    }

    private void handleAgentIsTyping(boolean z) {
        AgentIsTypingMessage agentIsTypingMessage = this.mAgentIsTypingMessage;
        if (agentIsTypingMessage != null) {
            if (z) {
                this.mMessageFeedAdapter.moveItemToHead(agentIsTypingMessage);
            } else {
                this.mMessageFeedAdapter.remove(agentIsTypingMessage);
            }
            if (this.mMessageFeedAdapter.isAtBottomPosition()) {
                scrollToBottom();
            }
        }
    }

    private void handleSessionEndedByAgent() {
        HorizontalRule newHorizontalRule = this.mMessageModelFactory.newHorizontalRule(getApplicationContext().getString(R.string.chat_session_ended_by_agent));
        MessageSpacer newMessageSpacer = this.mMessageModelFactory.newMessageSpacer();
        this.mMessageFeedAdapter.add(newHorizontalRule);
        this.mMessageFeedAdapter.add(newMessageSpacer);
        scrollToBottom();
    }

    /* access modifiers changed from: package-private */
    public void resetCurrentSendingPhoto() {
        SentPhotoMessage sentPhotoMessage = this.mCurrentSendingPhoto;
        if (sentPhotoMessage != null) {
            sentPhotoMessage.setSending(false);
            this.mMessageFeedAdapter.notifyItemChanged(this.mCurrentSendingPhoto);
            this.mCurrentSendingPhoto = null;
        }
    }

    /* access modifiers changed from: private */
    public void scrollToBottom() {
        ChatFeedView chatFeedView = this.mChatFeedView;
        if (chatFeedView != null) {
            chatFeedView.scrollToBottom();
        }
    }

    private void disableLastChatMenu() {
        ChatMenuMessage chatMenuMessage = this.mLastReceivedChatMenuMessage;
        if (chatMenuMessage != null) {
            chatMenuMessage.setEnabled(false);
            this.mMessageFeedAdapter.notifyItemChanged(this.mLastReceivedChatMenuMessage);
        }
    }

    private void removeLastChatButtonMenuIfPresent() {
        ChatButtonMenuMessage chatButtonMenuMessage = this.mLastReceivedChatButtonMenuMessage;
        if (chatButtonMenuMessage != null) {
            this.mMessageFeedAdapter.remove(chatButtonMenuMessage);
            this.mLastReceivedChatButtonMenuMessage = null;
        }
    }

    public void hideChatBanner() {
        ChatBanner chatBanner = this.mChatBanner;
        if (chatBanner != null) {
            this.mMessageFeedAdapter.remove(chatBanner);
        }
    }

    public void showChatBanner() {
        ChatBanner chatBanner = this.mChatBanner;
        if (chatBanner != null) {
            this.mMessageFeedAdapter.addToTop(chatBanner);
        }
    }

    private boolean isChatBot(AgentInformation agentInformation) {
        return agentInformation != null && agentInformation.isChatBot();
    }

    private void notifyAugmentors(ReceivedMessage receivedMessage) {
        this.mAugmenterManager.onMessageAdded(receivedMessage);
    }

    private a<p> endSessionHandler() {
        return new a<p>() {
            public p invoke() {
                ChatFeed.this.endSession();
                return null;
            }
        };
    }

    public static class Builder implements PresenterBuilder<ChatFeedPresenter> {
        private MessageAugmentorFactory mAugmenterFactory;
        /* access modifiers changed from: private */
        public MessageAugmentorManager mAugmentorManager;
        /* access modifiers changed from: private */
        public AvatarCache mAvatarCache;
        /* access modifiers changed from: private */
        public ChatBotFooterMenuAdapter mChatBotFooterMenuAdapter;
        /* access modifiers changed from: private */
        public ChatFeedTransferUIManager mChatFeedTransferUIManager;
        /* access modifiers changed from: private */
        public InternalChatUIClient mChatUIClient;
        /* access modifiers changed from: private */
        public ConnectivityTracker.Builder mConnectivityTrackerBuilder;
        /* access modifiers changed from: private */
        public FileTransferManager mFileTransferManager;
        /* access modifiers changed from: private */
        public Handler mHandler;
        /* access modifiers changed from: private */
        public MessageFeedAdapter mMessageFeedAdapter;
        /* access modifiers changed from: private */
        public MessageModelFactory mMessageModelFactory;
        /* access modifiers changed from: private */
        public MessageReceiver mMessageReceiver;
        /* access modifiers changed from: private */
        public MessageSender mMessageSender;
        /* access modifiers changed from: private */
        public StateTracker mStateTracker;

        public int getKey() {
            return 1;
        }

        public Builder internalChatUIClient(InternalChatUIClient internalChatUIClient) {
            this.mChatUIClient = internalChatUIClient;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder messageFeedAdapter(MessageFeedAdapter messageFeedAdapter) {
            this.mMessageFeedAdapter = messageFeedAdapter;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder chatbotFooterMenuAdapter(ChatBotFooterMenuAdapter chatBotFooterMenuAdapter) {
            this.mChatBotFooterMenuAdapter = chatBotFooterMenuAdapter;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder messageModelFactory(MessageModelFactory messageModelFactory) {
            this.mMessageModelFactory = messageModelFactory;
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
        public Builder fileTransferManager(FileTransferManager fileTransferManager) {
            this.mFileTransferManager = fileTransferManager;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder handler(Handler handler) {
            this.mHandler = handler;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder connectivityTrackerBuilder(ConnectivityTracker.Builder builder) {
            this.mConnectivityTrackerBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder chatFeedAugmentorFactory(MessageAugmentorFactory messageAugmentorFactory) {
            this.mAugmenterFactory = messageAugmentorFactory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder transferManager(ChatFeedTransferUIManager chatFeedTransferUIManager) {
            this.mChatFeedTransferUIManager = chatFeedTransferUIManager;
            return this;
        }

        public ChatFeedPresenter build() {
            Arguments.checkNotNull(this.mChatUIClient);
            if (this.mChatBotFooterMenuAdapter == null) {
                this.mChatBotFooterMenuAdapter = new ChatBotFooterMenuAdapter();
            }
            if (this.mMessageModelFactory == null) {
                this.mMessageModelFactory = new MessageModelFactory();
            }
            if (this.mMessageReceiver == null) {
                this.mMessageReceiver = this.mChatUIClient.getMessageReceiver();
            }
            if (this.mMessageSender == null) {
                this.mMessageSender = this.mChatUIClient.getMessageSender();
            }
            if (this.mStateTracker == null) {
                this.mStateTracker = this.mChatUIClient.getStateTracker();
            }
            if (this.mAvatarCache == null) {
                this.mAvatarCache = this.mChatUIClient.getAvatarCache();
            }
            if (this.mFileTransferManager == null) {
                this.mFileTransferManager = this.mChatUIClient.getFileTransferManager();
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
            if (this.mConnectivityTrackerBuilder == null) {
                this.mConnectivityTrackerBuilder = new ConnectivityTracker.Builder();
            }
            if (this.mMessageFeedAdapter == null) {
                this.mMessageFeedAdapter = new MessageFeedAdapter.Builder().layoutInflaterFactory(new LayoutInflaterFactory()).viewHolderFactory(new ChatViewHolderFactory.Builder().avatarCache(this.mAvatarCache).clickListener(this.mChatUIClient.getKnowledgeArticlePreviewClickListener()).build()).build();
            }
            if (this.mChatFeedTransferUIManager == null) {
                this.mChatFeedTransferUIManager = new ChatFeedTransferUIManager(this.mChatUIClient.getApplicationContext(), this.mMessageModelFactory, this.mMessageFeedAdapter, new ChatEndSessionAlertDialog());
            }
            if (this.mAugmenterFactory == null) {
                this.mAugmenterFactory = MessageAugmentorFactory.createChatFeedAugmentorFactory(this.mChatUIClient, this.mMessageFeedAdapter);
            }
            this.mAugmentorManager = this.mAugmenterFactory.createManagerWithAugmentors();
            return new ChatFeed(this);
        }
    }
}
