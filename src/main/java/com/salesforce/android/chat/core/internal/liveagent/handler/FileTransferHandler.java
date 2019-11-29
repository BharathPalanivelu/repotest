package com.salesforce.android.chat.core.internal.liveagent.handler;

import com.salesforce.android.chat.core.ChatAnalyticsEmit;
import com.salesforce.android.chat.core.internal.filetransfer.InternalFileTransferAssistant;
import com.salesforce.android.chat.core.internal.liveagent.ChatListenerNotifier;
import com.salesforce.android.chat.core.model.FileTransferStatus;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.security.GeneralSecurityException;
import java.util.concurrent.Executors;

public class FileTransferHandler implements SessionListener {
    private static final ServiceLogger log = ServiceLogging.getLogger(FileTransferHandler.class);
    private final ChatListenerNotifier mChatListenerNotifier;
    private InternalFileTransferAssistant mFileTransferAssistant;
    private final InternalFileTransferAssistant.Factory mFileTransferAssistantFactory;
    private final JobQueue mJobQueue;
    private final String mOrganizationId;
    private SessionInfo mSessionInfo;

    public void onError(Throwable th) {
    }

    private FileTransferHandler(Builder builder) {
        this.mOrganizationId = builder.mOrganizationId;
        builder.mLiveAgentSession.addSessionListener(this);
        this.mChatListenerNotifier = builder.mChatListenerNotifier;
        this.mFileTransferAssistantFactory = builder.mFileTransferAssistantFactory;
        this.mJobQueue = builder.mJobQueue;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleFileTransferMessage(com.salesforce.android.chat.core.internal.liveagent.response.message.FileTransferMessage r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getEventType()
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -1597065394: goto L_0x002d;
                case -202516509: goto L_0x0023;
                case -58529607: goto L_0x0019;
                case 578079082: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0037
        L_0x000f:
            java.lang.String r1 = "Failure"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0037
            r0 = 3
            goto L_0x0038
        L_0x0019:
            java.lang.String r1 = "Canceled"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0037
            r0 = 2
            goto L_0x0038
        L_0x0023:
            java.lang.String r1 = "Success"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0037
            r0 = 1
            goto L_0x0038
        L_0x002d:
            java.lang.String r1 = "Requested"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0037
            r0 = 0
            goto L_0x0038
        L_0x0037:
            r0 = -1
        L_0x0038:
            if (r0 == 0) goto L_0x004d
            if (r0 == r4) goto L_0x0049
            if (r0 == r3) goto L_0x0045
            if (r0 == r2) goto L_0x0041
            goto L_0x0058
        L_0x0041:
            r5.onFailed()
            goto L_0x0058
        L_0x0045:
            r5.onCancelled()
            goto L_0x0058
        L_0x0049:
            r5.onSuccess()
            goto L_0x0058
        L_0x004d:
            java.lang.String r0 = r6.getUploadUrl()
            java.lang.String r6 = r6.getFileToken()
            r5.onRequest(r0, r6)
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.core.internal.liveagent.handler.FileTransferHandler.handleFileTransferMessage(com.salesforce.android.chat.core.internal.liveagent.response.message.FileTransferMessage):void");
    }

    private void onRequest(String str, String str2) {
        if (this.mFileTransferAssistant != null) {
            log.warn("The current file transfer must be completed before another is initiated.");
        } else if (this.mSessionInfo == null) {
            log.error("Unable to request a file transfer - Session Info is unknown.");
            this.mChatListenerNotifier.onFileTransferStatusChanged(FileTransferStatus.LocalError);
            ChatAnalyticsEmit.responseFileTransferFailed(FileTransferStatus.LocalError);
        } else {
            log.debug("File Transfer has been requested. Creating a FileTransferAssistant...");
            ChatAnalyticsEmit.responseAgentRequestFileTransfer();
            try {
                this.mFileTransferAssistant = this.mFileTransferAssistantFactory.createBuilder().organizationId(this.mOrganizationId).sessionInfo(this.mSessionInfo).uploadUrl(str).fileToken(str2).jobQueue(this.mJobQueue).build();
                this.mChatListenerNotifier.onFileTransferStatusChanged(FileTransferStatus.Requested);
                this.mChatListenerNotifier.onFileTransferRequest(this.mFileTransferAssistant);
            } catch (GeneralSecurityException e2) {
                log.error("Unable to initiate File Transfer request. {}", e2);
                this.mChatListenerNotifier.onFileTransferStatusChanged(FileTransferStatus.LocalError);
                ChatAnalyticsEmit.responseFileTransferFailed(FileTransferStatus.LocalError);
            }
        }
    }

    private void onSuccess() {
        if (this.mFileTransferAssistant != null) {
            this.mFileTransferAssistant = null;
            this.mChatListenerNotifier.onFileTransferStatusChanged(FileTransferStatus.Completed);
            ChatAnalyticsEmit.responseFileTransferComplete(FileTransferStatus.Completed);
        }
    }

    private void onCancelled() {
        InternalFileTransferAssistant internalFileTransferAssistant = this.mFileTransferAssistant;
        if (internalFileTransferAssistant != null) {
            internalFileTransferAssistant.cancel();
            this.mFileTransferAssistant = null;
            this.mChatListenerNotifier.onFileTransferStatusChanged(FileTransferStatus.Canceled);
            ChatAnalyticsEmit.responseAgentCancelFileTransfer(FileTransferStatus.Canceled);
        }
    }

    private void onFailed() {
        InternalFileTransferAssistant internalFileTransferAssistant = this.mFileTransferAssistant;
        if (internalFileTransferAssistant != null) {
            internalFileTransferAssistant.cancel();
            this.mFileTransferAssistant = null;
            this.mChatListenerNotifier.onFileTransferStatusChanged(FileTransferStatus.Failed);
            ChatAnalyticsEmit.responseFileTransferFailed(FileTransferStatus.Failed);
        }
    }

    public void onSessionCreated(SessionInfo sessionInfo) {
        this.mSessionInfo = sessionInfo;
    }

    public void onSessionStateChanged(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        if (liveAgentState == LiveAgentState.Deleting) {
            this.mSessionInfo = null;
            onCancelled();
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ChatListenerNotifier mChatListenerNotifier;
        /* access modifiers changed from: private */
        public InternalFileTransferAssistant.Factory mFileTransferAssistantFactory;
        /* access modifiers changed from: private */
        public JobQueue mJobQueue;
        /* access modifiers changed from: private */
        public LiveAgentSession mLiveAgentSession;
        /* access modifiers changed from: private */
        public String mOrganizationId;

        public Builder organizationId(String str) {
            this.mOrganizationId = str;
            return this;
        }

        public Builder liveAgentSession(LiveAgentSession liveAgentSession) {
            this.mLiveAgentSession = liveAgentSession;
            return this;
        }

        public Builder chatListenerNotifier(ChatListenerNotifier chatListenerNotifier) {
            this.mChatListenerNotifier = chatListenerNotifier;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder fileTransferAssistantFactory(InternalFileTransferAssistant.Factory factory) {
            this.mFileTransferAssistantFactory = factory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder jobQueue(JobQueue jobQueue) {
            this.mJobQueue = jobQueue;
            return this;
        }

        public FileTransferHandler build() {
            Arguments.checkValidSalesforceId(this.mOrganizationId, "Invalid Organization ID");
            Arguments.checkNotNull(this.mLiveAgentSession);
            Arguments.checkNotNull(this.mChatListenerNotifier);
            if (this.mFileTransferAssistantFactory == null) {
                this.mFileTransferAssistantFactory = new InternalFileTransferAssistant.Factory();
            }
            if (this.mJobQueue == null) {
                this.mJobQueue = new JobQueue(Executors.newCachedThreadPool(PriorityThreadFactory.background()));
            }
            return new FileTransferHandler(this);
        }
    }
}
