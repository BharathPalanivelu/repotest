package com.salesforce.android.chat.ui.internal.chatfeed;

import android.content.Context;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatBotTransferWaitingIndicator;
import com.salesforce.android.chat.ui.internal.dialog.ChatEndSessionAlertDialog;
import d.d.a.a;
import d.d.b.j;
import d.p;

final class ChatFeedTransferUIManager$provideWaitingIndicator$$inlined$let$lambda$1 implements ChatBotTransferWaitingIndicator.OnCancelListener {
    final /* synthetic */ ChatFeedTransferUIManager this$0;

    ChatFeedTransferUIManager$provideWaitingIndicator$$inlined$let$lambda$1(ChatFeedTransferUIManager chatFeedTransferUIManager) {
        this.this$0 = chatFeedTransferUIManager;
    }

    public final void onChatBotTransferCancelButtonSelected() {
        this.this$0.endSessionAlertDialog.accept(new a<p>(this) {
            final /* synthetic */ ChatFeedTransferUIManager$provideWaitingIndicator$$inlined$let$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.this$0.getOnEndSessionConfirmation().invoke();
            }
        });
        Context context = (Context) this.this$0.activityContext.get();
        if (context != null) {
            ChatEndSessionAlertDialog access$getEndSessionAlertDialog$p = this.this$0.endSessionAlertDialog;
            j.a((Object) context, "it");
            access$getEndSessionAlertDialog$p.show(context);
        }
    }
}
