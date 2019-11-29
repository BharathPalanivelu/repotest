package com.salesforce.android.chat.ui.internal.chatfeed;

import android.content.Context;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.ui.Mockable;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatBotTransferWaitingIndicator;
import com.salesforce.android.chat.ui.internal.chatfeed.model.HorizontalRule;
import com.salesforce.android.chat.ui.internal.chatfeed.model.MessageModelFactory;
import com.salesforce.android.chat.ui.internal.dialog.ChatEndSessionAlertDialog;
import com.salesforce.android.service.common.ui.internal.messaging.MessageFeedAdapter;
import d.d.a.a;
import d.d.b.j;
import d.p;
import java.lang.ref.WeakReference;

@Mockable
public class ChatFeedTransferUIManager {
    /* access modifiers changed from: private */
    public WeakReference<Context> activityContext;
    private AgentInformation agentInformation;
    private final Context context;
    private Object element;
    /* access modifiers changed from: private */
    public final ChatEndSessionAlertDialog endSessionAlertDialog;
    private final MessageFeedAdapter messageFeedAdapter;
    private final MessageModelFactory messageModelFactory;
    private a<p> onEndSessionConfirmation;
    private final String transferMessage;

    public ChatFeedTransferUIManager(Context context2, MessageModelFactory messageModelFactory2, MessageFeedAdapter messageFeedAdapter2, ChatEndSessionAlertDialog chatEndSessionAlertDialog) {
        j.b(context2, "context");
        j.b(messageModelFactory2, "messageModelFactory");
        j.b(messageFeedAdapter2, "messageFeedAdapter");
        j.b(chatEndSessionAlertDialog, "endSessionAlertDialog");
        this.context = context2;
        this.messageModelFactory = messageModelFactory2;
        this.messageFeedAdapter = messageFeedAdapter2;
        this.endSessionAlertDialog = chatEndSessionAlertDialog;
        String string = getContext().getString(R.string.chat_session_button_transfer_initiated);
        j.a((Object) string, "context.getString(R.stri…utton_transfer_initiated)");
        this.transferMessage = string;
        this.onEndSessionConfirmation = ChatFeedTransferUIManager$onEndSessionConfirmation$1.INSTANCE;
        this.activityContext = new WeakReference<>((Object) null);
    }

    public Context getContext() {
        return this.context;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatFeedTransferUIManager(Context context2, MessageModelFactory messageModelFactory2, MessageFeedAdapter messageFeedAdapter2, ChatEndSessionAlertDialog chatEndSessionAlertDialog, int i, g gVar) {
        this(context2, messageModelFactory2, messageFeedAdapter2, (i & 8) != 0 ? new ChatEndSessionAlertDialog() : chatEndSessionAlertDialog);
    }

    public a<p> getOnEndSessionConfirmation() {
        return this.onEndSessionConfirmation;
    }

    public void setOnEndSessionConfirmation(a<p> aVar) {
        j.b(aVar, "<set-?>");
        this.onEndSessionConfirmation = aVar;
    }

    public AgentInformation getAgentInformation() {
        return this.agentInformation;
    }

    public void setAgentInformation(AgentInformation agentInformation2) {
        this.agentInformation = agentInformation2;
    }

    public void attach(Context context2) {
        j.b(context2, "context");
        this.activityContext = new WeakReference<>(context2);
    }

    public void showChatTransferUI() {
        Object obj;
        if (getAgentInformation() != null) {
            AgentInformation agentInformation2 = getAgentInformation();
            if (agentInformation2 == null || !agentInformation2.isChatBot()) {
                obj = provideTransferText$chat_ui_release();
            } else {
                obj = provideWaitingIndicator$chat_ui_release();
            }
            this.element = obj;
            Object obj2 = this.element;
            if (obj2 != null) {
                this.messageFeedAdapter.add(obj2);
            }
        }
    }

    public void hideChatTransferUI() {
        Object obj = this.element;
        if (obj != null && (obj instanceof ChatBotTransferWaitingIndicator)) {
            this.messageFeedAdapter.remove(obj);
            this.element = null;
        }
    }

    public ChatBotTransferWaitingIndicator provideWaitingIndicator$chat_ui_release() {
        ChatBotTransferWaitingIndicator newChatFeedTransferWaitingIndicator = this.messageModelFactory.newChatFeedTransferWaitingIndicator();
        if (newChatFeedTransferWaitingIndicator != null) {
            newChatFeedTransferWaitingIndicator.setCancelButtonListener(new ChatFeedTransferUIManager$provideWaitingIndicator$$inlined$let$lambda$1(this));
        }
        j.a((Object) newChatFeedTransferWaitingIndicator, "waitingIndicator");
        return newChatFeedTransferWaitingIndicator;
    }

    public HorizontalRule provideTransferText$chat_ui_release() {
        HorizontalRule newHorizontalRule = this.messageModelFactory.newHorizontalRule(this.transferMessage);
        j.a((Object) newHorizontalRule, "messageModelFactory.newH…ntalRule(transferMessage)");
        return newHorizontalRule;
    }
}
