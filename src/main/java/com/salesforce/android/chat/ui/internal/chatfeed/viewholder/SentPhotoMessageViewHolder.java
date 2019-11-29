package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.graphics.drawable.b;
import androidx.core.graphics.drawable.d;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.SentPhotoMessage;
import com.salesforce.android.service.common.ui.internal.messaging.GroupableView;
import com.salesforce.android.service.common.ui.views.SalesforceProgressSpinner;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class SentPhotoMessageViewHolder extends RecyclerView.w implements DataBinder, GroupableView {
    private final int mCornerRadius;
    private Space mFooterSpace;
    private View mOverlay;
    private ImageView mPhoto;
    private SalesforceProgressSpinner mProgressSpinner;
    private final Resources mResources;
    private TextView mTimestamp;

    private SentPhotoMessageViewHolder(View view) {
        super(view);
        this.mResources = view.getResources();
        this.mCornerRadius = this.mResources.getDimensionPixelSize(R.dimen.salesforce_message_bubble_corner_radius);
        this.mPhoto = (ImageView) view.findViewById(R.id.salesforce_sent_photo);
        this.mTimestamp = (TextView) view.findViewById(R.id.salesforce_sent_message_timestamp);
        this.mProgressSpinner = (SalesforceProgressSpinner) view.findViewById(R.id.salesforce_sent_photo_progress);
        this.mOverlay = view.findViewById(R.id.salesforce_sent_photo_overlay);
        this.mFooterSpace = (Space) view.findViewById(R.id.salesforce_sent_message_footer_space);
        this.mTimestamp.setVisibility(8);
        this.mFooterSpace.setVisibility(0);
    }

    public void setData(Object obj) {
        if (obj instanceof SentPhotoMessage) {
            SentPhotoMessage sentPhotoMessage = (SentPhotoMessage) obj;
            b a2 = d.a(this.mResources, sentPhotoMessage.getImageThumbnail().getBitmap());
            a2.a((float) this.mCornerRadius);
            this.mPhoto.setImageDrawable(a2);
            int i = sentPhotoMessage.isSending() ? 0 : 4;
            this.mProgressSpinner.setVisibility(i);
            this.mOverlay.setVisibility(i);
        }
    }

    public void onGroupView() {
        this.mFooterSpace.setVisibility(8);
    }

    public void onUngroupView() {
        this.mFooterSpace.setVisibility(0);
    }

    public static class Builder implements ViewHolderBuilder<SentPhotoMessageViewHolder> {
        private View mItemView;

        public int getKey() {
            return 5;
        }

        public int getLayoutResource() {
            return R.layout.salesforce_message_sent_photo;
        }

        public Builder itemView(View view) {
            this.mItemView = view;
            return this;
        }

        public SentPhotoMessageViewHolder build() {
            Arguments.checkNotNull(this.mItemView);
            SentPhotoMessageViewHolder sentPhotoMessageViewHolder = new SentPhotoMessageViewHolder(this.mItemView);
            this.mItemView = null;
            return sentPhotoMessageViewHolder;
        }
    }
}
