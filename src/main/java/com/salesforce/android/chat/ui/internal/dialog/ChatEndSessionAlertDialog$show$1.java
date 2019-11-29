package com.salesforce.android.chat.ui.internal.dialog;

import android.content.DialogInterface;

final class ChatEndSessionAlertDialog$show$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ ChatEndSessionAlertDialog this$0;

    ChatEndSessionAlertDialog$show$1(ChatEndSessionAlertDialog chatEndSessionAlertDialog) {
        this.this$0 = chatEndSessionAlertDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.this$0.accept.invoke();
    }
}
