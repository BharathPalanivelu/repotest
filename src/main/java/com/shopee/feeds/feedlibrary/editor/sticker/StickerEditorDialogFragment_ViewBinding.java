package com.shopee.feeds.feedlibrary.editor.sticker;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;

public class StickerEditorDialogFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private StickerEditorDialogFragment f28003b;

    public StickerEditorDialogFragment_ViewBinding(StickerEditorDialogFragment stickerEditorDialogFragment, View view) {
        this.f28003b = stickerEditorDialogFragment;
        stickerEditorDialogFragment.outBoundView = b.a(view, c.e.v_outbound, "field 'outBoundView'");
        stickerEditorDialogFragment.stickerListView = (RecyclerView) b.a(view, c.e.list_stickers, "field 'stickerListView'", RecyclerView.class);
    }
}
