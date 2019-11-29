package com.salesforce.android.chat.core;

import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.core.model.FileTransferStatus;
import com.salesforce.android.service.common.analytics.internal.InternalServiceAnalytics;
import java.util.Date;

public final class ChatAnalyticsEmit {
    private ChatAnalyticsEmit() {
    }

    public static void responseAgentCancelFileTransfer(FileTransferStatus fileTransferStatus) {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_AGENT_CANCEL_FILE_TRANSFER, ChatAnalytics.FILE_TRANSFER_STATUS, fileTransferStatus);
    }

    public static void responseAgentHasFinishedTyping() {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_AGENT_HAS_FINISHED_TYPING, new Object[0]);
    }

    public static void responseAgentIsTyping() {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_AGENT_IS_TYPING, new Object[0]);
    }

    public static void responseAgentJoined(String str, String str2) {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_AGENT_JOINED, ChatAnalytics.DATA_AGENT_NAME, str, ChatAnalytics.DATA_AGENT_ID, str2);
    }

    public static void responseAgentJoinedConference(ChatSessionState chatSessionState) {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_AGENT_JOINED_CONFERENCE, ChatAnalytics.DATA_CURRENT_LIFECYCLE_STATE, chatSessionState);
    }

    public static void responseAgentLeftConference(ChatSessionState chatSessionState) {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_AGENT_LEFT_CONFERENCE, ChatAnalytics.DATA_CURRENT_LIFECYCLE_STATE, chatSessionState);
    }

    public static void responseAgentRequestFileTransfer() {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_AGENT_REQUEST_FILE_TRANSFER, new Object[0]);
    }

    public static void responseError(Throwable th) {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_ERROR, ChatAnalytics.DATA_ERROR, th);
    }

    public static void responseFileTransferComplete(FileTransferStatus fileTransferStatus) {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_FILE_TRANSFER_COMPLETE, ChatAnalytics.FILE_TRANSFER_STATUS, fileTransferStatus);
    }

    public static void responseFileTransferFailed(FileTransferStatus fileTransferStatus) {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_FILE_TRANSFER_FAILED, ChatAnalytics.FILE_TRANSFER_STATUS, fileTransferStatus);
    }

    public static void responseInitializedClient() {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_INITIALIZED_CLIENT, new Object[0]);
    }

    public static void responseLifecycleChange(ChatSessionState chatSessionState, ChatSessionState chatSessionState2) {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_LIFECYCLE_CHANGE, ChatAnalytics.DATA_CURRENT_LIFECYCLE_STATE, chatSessionState, ChatAnalytics.DATA_PREVIOUS_LIFECYCLE_STATE, chatSessionState2);
    }

    public static void responseMessageReceived(Date date) {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_MESSAGE_RECEIVED, ChatAnalytics.DATA_TIMESTAMP, date);
    }

    public static void responseMessageSent() {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_MESSAGE_SENT, new Object[0]);
    }

    public static void responseSessionCreated(String str) {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_SESSION_CREATED, ChatAnalytics.DATA_LIVE_AGENT_SESSION_ID, str);
    }

    public static void responseSessionEnded(ChatEndReason chatEndReason) {
        InternalServiceAnalytics.emit(ChatAnalytics.RESPONSE_SESSION_ENDED, ChatAnalytics.DATA_END_REASON, chatEndReason);
    }

    public static void userEndSession() {
        InternalServiceAnalytics.emit(ChatAnalytics.USER_END_SESSION, new Object[0]);
    }

    public static void userFileTransferUploadInitiated(String str, Integer num) {
        InternalServiceAnalytics.emit(ChatAnalytics.USER_FILE_TRANSFER_UPLOAD_INITIATED, ChatAnalytics.FILE_TRANSFER_TYPE, str, ChatAnalytics.FILE_TRANSFER_BYTES, num);
    }

    public static void userHasFinishedTyping() {
        InternalServiceAnalytics.emit(ChatAnalytics.USER_HAS_FINISHED_TYPING, new Object[0]);
    }

    public static void userInitializeClient(String str, String str2, String str3, String str4) {
        InternalServiceAnalytics.emit(ChatAnalytics.USER_INITIALIZE_CLIENT, ChatAnalytics.DATA_LIVE_AGENT_POD, str, ChatAnalytics.DATA_ORGANIZATION_ID, str2, ChatAnalytics.DATA_BUTTON_ID, str3, ChatAnalytics.DATA_DEPLOYMENT_ID, str4);
    }

    public static void userIsTyping() {
        InternalServiceAnalytics.emit(ChatAnalytics.USER_IS_TYPING, new Object[0]);
    }

    public static void userSendMessage() {
        InternalServiceAnalytics.emit(ChatAnalytics.USER_SEND_MESSAGE, new Object[0]);
    }
}
