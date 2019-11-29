package com.salesforce.android.chat.ui.internal.dialog;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.dialog.ChatImageSourceViewHolder;
import d.d.b.j;

public final class ChatImageSourceAdapter implements ListAdapter {
    private final Context context;
    private final LayoutInflater inflater;
    private final ChatImageSourceViewHolder.Factory viewHolderFactory;

    public boolean areAllItemsEnabled() {
        return true;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        return true;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public ChatImageSourceAdapter(Context context2, LayoutInflater layoutInflater, ChatImageSourceViewHolder.Factory factory) {
        j.b(context2, "context");
        j.b(layoutInflater, "inflater");
        j.b(factory, "viewHolderFactory");
        this.context = context2;
        this.inflater = layoutInflater;
        this.viewHolderFactory = factory;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChatImageSourceAdapter(android.content.Context r1, android.view.LayoutInflater r2, com.salesforce.android.chat.ui.internal.dialog.ChatImageSourceViewHolder.Factory r3, int r4, d.d.b.g r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000d
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r1)
            java.lang.String r5 = "LayoutInflater.from(context)"
            d.d.b.j.a((java.lang.Object) r2, (java.lang.String) r5)
        L_0x000d:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0016
            com.salesforce.android.chat.ui.internal.dialog.ChatImageSourceViewHolder$Factory r3 = new com.salesforce.android.chat.ui.internal.dialog.ChatImageSourceViewHolder$Factory
            r3.<init>()
        L_0x0016:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.ui.internal.dialog.ChatImageSourceAdapter.<init>(android.content.Context, android.view.LayoutInflater, com.salesforce.android.chat.ui.internal.dialog.ChatImageSourceViewHolder$Factory, int, d.d.b.g):void");
    }

    public enum Source {
        TakePhoto(R.drawable.salesforce_ic_camera, R.string.chat_dialog_select_image_source_camera),
        UseLastPhoto(R.drawable.chat_ic_last_photo, R.string.chat_dialog_select_image_source_last_photo),
        Gallery(R.drawable.chat_ic_photo_gallery, R.string.chat_dialog_select_image_source_choose);
        
        private final int image;
        private final int label;

        protected Source(int i, int i2) {
            this.image = i;
            this.label = i2;
        }

        public final int getImage() {
            return this.image;
        }

        public final int getLabel() {
            return this.label;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.inflater.inflate(R.layout.chat_dialog_select_image_source, viewGroup, false);
        }
        ChatImageSourceViewHolder.Factory factory = this.viewHolderFactory;
        j.a((Object) view, "view");
        factory.create(view).bind(Source.values()[i]);
        return view;
    }

    public Object getItem(int i) {
        return Source.values()[i];
    }

    public long getItemId(int i) {
        return (long) Source.values()[i].ordinal();
    }

    public int getCount() {
        return Source.values().length;
    }

    public boolean isEmpty() {
        return Source.values().length == 0;
    }

    public boolean isEnabled(int i) {
        return i < getCount();
    }
}
