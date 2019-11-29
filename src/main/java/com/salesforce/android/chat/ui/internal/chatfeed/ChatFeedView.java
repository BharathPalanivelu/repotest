package com.salesforce.android.chat.ui.internal.chatfeed;

import android.content.Context;
import android.net.Uri;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.ui.internal.view.ToolbarViewBinder;
import com.salesforce.android.chat.ui.internal.view.ViewBinder;
import com.salesforce.android.service.common.ui.internal.messaging.MessageFeedAdapter;

interface ChatFeedView extends ToolbarViewBinder, ViewBinder {
    void disableFooterMenu();

    void disableInputs();

    void enableFooterMenu();

    Context getContext();

    void onCameraPermitted();

    void onGalleryPermitted();

    void onGetLastPhotoPermitted();

    void onImageSelected(Uri uri);

    void onImageSelectionFailed();

    void onPermissionsNotGranted();

    void onPhotoTaken();

    void onTransferringToAgent();

    void scrollToBottom();

    void setAgentInformation(AgentInformation agentInformation);

    void setFooterMenuAdapter(ChatBotFooterMenuAdapter chatBotFooterMenuAdapter);

    void setMessageFeedAdapter(MessageFeedAdapter messageFeedAdapter);

    void setPhotoSelectionEnabled(boolean z);

    void toggleConnectionBanner(boolean z);
}
