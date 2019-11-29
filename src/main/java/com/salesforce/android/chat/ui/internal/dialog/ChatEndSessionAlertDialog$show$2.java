package com.salesforce.android.chat.ui.internal.dialog;

import android.content.DialogInterface;

final class ChatEndSessionAlertDialog$show$2 implements DialogInterface.OnClickListener {
    public static final ChatEndSessionAlertDialog$show$2 INSTANCE = new ChatEndSessionAlertDialog$show$2();

    ChatEndSessionAlertDialog$show$2() {
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
