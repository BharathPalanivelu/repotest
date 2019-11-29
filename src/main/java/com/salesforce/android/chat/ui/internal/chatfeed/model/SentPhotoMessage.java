package com.salesforce.android.chat.ui.internal.chatfeed.model;

import com.salesforce.android.chat.ui.internal.filetransfer.model.ImageThumbnail;
import com.salesforce.android.service.common.ui.internal.messaging.MultiActorMessage;
import java.util.Date;

public class SentPhotoMessage implements MultiActorMessage {
    private final ImageThumbnail mImageThumbnail;
    private boolean mIsSending = true;
    private final Date mTimestamp;
    private final String mVisitorId;

    public SentPhotoMessage(String str, ImageThumbnail imageThumbnail, Date date) {
        this.mVisitorId = str;
        this.mImageThumbnail = imageThumbnail;
        this.mTimestamp = date;
    }

    public String getId() {
        return this.mVisitorId;
    }

    public Date getTimestamp() {
        return this.mTimestamp;
    }

    public ImageThumbnail getImageThumbnail() {
        return this.mImageThumbnail;
    }

    public boolean isSending() {
        return this.mIsSending;
    }

    public void setSending(boolean z) {
        this.mIsSending = z;
    }
}
