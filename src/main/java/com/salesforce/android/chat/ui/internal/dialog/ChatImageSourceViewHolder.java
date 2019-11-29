package com.salesforce.android.chat.ui.internal.dialog;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.b;
import com.facebook.share.internal.ShareConstants;
import com.salesforce.android.chat.ui.Mockable;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.dialog.ChatImageSourceAdapter;
import com.salesforce.android.service.common.ui.views.SalesforceTextView;
import d.d.b.j;

@Mockable
public class ChatImageSourceViewHolder {
    private final View view;

    public ChatImageSourceViewHolder(View view2) {
        j.b(view2, "view");
        this.view = view2;
    }

    public View getView() {
        return this.view;
    }

    @Mockable
    public static class Factory {
        public ChatImageSourceViewHolder create(View view) {
            j.b(view, "view");
            return new ChatImageSourceViewHolder(view);
        }
    }

    public void bind(ChatImageSourceAdapter.Source source) {
        j.b(source, ShareConstants.FEED_SOURCE_PARAM);
        Drawable a2 = b.a(getView().getContext(), source.getImage());
        int c2 = b.c(getView().getContext(), R.color.salesforce_contrast_secondary);
        String string = getView().getContext().getString(source.getLabel());
        ((AppCompatImageView) getView().findViewById(R.id.chat_image_source_icon)).setImageDrawable(a2);
        AppCompatImageView appCompatImageView = (AppCompatImageView) getView().findViewById(R.id.chat_image_source_icon);
        j.a((Object) appCompatImageView, "view.chat_image_source_icon");
        appCompatImageView.setImageTintList(ColorStateList.valueOf(c2));
        SalesforceTextView salesforceTextView = (SalesforceTextView) getView().findViewById(R.id.chat_image_source_label);
        j.a((Object) salesforceTextView, "view.chat_image_source_label");
        salesforceTextView.setText(string);
    }
}
