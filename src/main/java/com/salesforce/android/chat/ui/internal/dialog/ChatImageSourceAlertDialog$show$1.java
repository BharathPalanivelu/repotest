package com.salesforce.android.chat.ui.internal.dialog;

import android.content.DialogInterface;
import com.salesforce.android.chat.ui.internal.dialog.ChatImageSourceAdapter;

final class ChatImageSourceAlertDialog$show$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ ChatImageSourceAlertDialog this$0;

    ChatImageSourceAlertDialog$show$1(ChatImageSourceAlertDialog chatImageSourceAlertDialog) {
        this.this$0 = chatImageSourceAlertDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == ChatImageSourceAdapter.Source.TakePhoto.ordinal()) {
            this.this$0.getOnTakePhoto().invoke();
        } else if (i == ChatImageSourceAdapter.Source.UseLastPhoto.ordinal()) {
            this.this$0.getOnUseLastPhoto().invoke();
        } else if (i == ChatImageSourceAdapter.Source.Gallery.ordinal()) {
            this.this$0.getOnOpenGallery().invoke();
        }
    }
}
