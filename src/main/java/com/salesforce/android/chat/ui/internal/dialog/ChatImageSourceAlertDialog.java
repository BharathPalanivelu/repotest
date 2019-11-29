package com.salesforce.android.chat.ui.internal.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import com.salesforce.android.chat.ui.Mockable;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.dialog.ChatImageSourceViewHolder;
import d.d.a.a;
import d.d.b.j;
import d.p;

@Mockable
public class ChatImageSourceAlertDialog {
    private final ChatImageSourceAdapter adapter;
    private a<p> onOpenGallery;
    private a<p> onTakePhoto;
    private a<p> onUseLastPhoto;

    public ChatImageSourceAlertDialog(Context context, ChatImageSourceAdapter chatImageSourceAdapter) {
        j.b(context, "context");
        j.b(chatImageSourceAdapter, "adapter");
        this.adapter = chatImageSourceAdapter;
        this.onTakePhoto = ChatImageSourceAlertDialog$onTakePhoto$1.INSTANCE;
        this.onUseLastPhoto = ChatImageSourceAlertDialog$onUseLastPhoto$1.INSTANCE;
        this.onOpenGallery = ChatImageSourceAlertDialog$onOpenGallery$1.INSTANCE;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatImageSourceAlertDialog(Context context, ChatImageSourceAdapter chatImageSourceAdapter, int i, g gVar) {
        this(context, (i & 2) != 0 ? new ChatImageSourceAdapter(context, (LayoutInflater) null, (ChatImageSourceViewHolder.Factory) null, 6, (g) null) : chatImageSourceAdapter);
    }

    public ChatImageSourceAdapter getAdapter() {
        return this.adapter;
    }

    public a<p> getOnTakePhoto() {
        return this.onTakePhoto;
    }

    public void setOnTakePhoto(a<p> aVar) {
        j.b(aVar, "<set-?>");
        this.onTakePhoto = aVar;
    }

    public a<p> getOnUseLastPhoto() {
        return this.onUseLastPhoto;
    }

    public void setOnUseLastPhoto(a<p> aVar) {
        j.b(aVar, "<set-?>");
        this.onUseLastPhoto = aVar;
    }

    public a<p> getOnOpenGallery() {
        return this.onOpenGallery;
    }

    public void setOnOpenGallery(a<p> aVar) {
        j.b(aVar, "<set-?>");
        this.onOpenGallery = aVar;
    }

    public void show(Context context) {
        j.b(context, "context");
        new AlertDialog.Builder(context, R.style.Widget_ServiceChat_Dialog).setAdapter(getAdapter(), new ChatImageSourceAlertDialog$show$1(this)).setCancelable(true).show();
    }
}
