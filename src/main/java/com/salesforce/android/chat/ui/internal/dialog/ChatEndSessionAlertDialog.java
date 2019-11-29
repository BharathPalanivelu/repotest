package com.salesforce.android.chat.ui.internal.dialog;

import android.app.AlertDialog;
import android.content.Context;
import com.salesforce.android.chat.ui.Mockable;
import com.salesforce.android.chat.ui.R;
import d.d.a.a;
import d.d.b.j;
import d.p;

@Mockable
public class ChatEndSessionAlertDialog {
    /* access modifiers changed from: private */
    public a<p> accept = ChatEndSessionAlertDialog$accept$1.INSTANCE;

    public void accept(a<p> aVar) {
        j.b(aVar, "accept");
        this.accept = aVar;
    }

    public void show(Context context) {
        j.b(context, "context");
        new AlertDialog.Builder(context, R.style.Widget_ServiceChat_Dialog).setTitle(R.string.chat_dialog_end_session_title).setMessage(R.string.chat_dialog_end_session_message).setPositiveButton(R.string.chat_dialog_end_session_positive, new ChatEndSessionAlertDialog$show$1(this)).setNegativeButton(R.string.chat_dialog_negative, ChatEndSessionAlertDialog$show$2.INSTANCE).setCancelable(true).show();
    }
}
