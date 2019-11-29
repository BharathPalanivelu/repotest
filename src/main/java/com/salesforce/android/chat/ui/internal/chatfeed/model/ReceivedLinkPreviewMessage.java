package com.salesforce.android.chat.ui.internal.chatfeed.model;

import android.graphics.Bitmap;
import com.salesforce.android.service.common.ui.internal.messaging.MultiActorMessage;
import java.util.Date;

public class ReceivedLinkPreviewMessage implements MultiActorMessage {
    private String mAgentId;
    private String mArticleIdOrTitle;
    private boolean mAsyncComplete = false;
    private String mDomain;
    private Bitmap mFaviconImage;
    private String mOGDescription;
    private Bitmap mOGImage;
    private String mOGImageUrl;
    private String mOGTitle;
    private String mOGUrl;
    private String mOriginalUrl;
    private Date mTimestamp;
    private PreviewMessageType mType;

    public enum PreviewMessageType {
        DEFAULT,
        KB
    }

    public ReceivedLinkPreviewMessage(String str, Date date, String str2) {
        this.mAgentId = str;
        this.mTimestamp = date;
        this.mOriginalUrl = str2;
        this.mType = PreviewMessageType.DEFAULT;
    }

    public boolean isAsyncComplete() {
        return this.mAsyncComplete;
    }

    public void setAsyncComplete() {
        this.mAsyncComplete = true;
    }

    public String getHost() {
        return this.mDomain;
    }

    public void setHost(String str) {
        this.mDomain = str;
    }

    public String getOriginalUrl() {
        return this.mOriginalUrl;
    }

    public void setOGDescription(String str) {
        this.mOGDescription = str;
    }

    public String getOGDescription() {
        return this.mOGDescription;
    }

    public void setOGTitle(String str) {
        this.mOGTitle = str;
    }

    public String getOGTitle() {
        return this.mOGTitle;
    }

    public void setOGUrl(String str) {
        this.mOGUrl = str;
    }

    public String getOGUrl() {
        return this.mOGUrl;
    }

    public void setOGImage(Bitmap bitmap) {
        this.mOGImage = bitmap;
    }

    public Bitmap getOGImage() {
        return this.mOGImage;
    }

    public void setFaviconImage(Bitmap bitmap) {
        this.mFaviconImage = bitmap;
    }

    public Bitmap getFaviconImage() {
        return this.mFaviconImage;
    }

    public void setOGImageUrl(String str) {
        this.mOGImageUrl = str;
    }

    public String getOGImageUrl() {
        return this.mOGImageUrl;
    }

    public String getId() {
        return this.mAgentId;
    }

    public String getMessageText() {
        return this.mOGDescription;
    }

    public Date getTimestamp() {
        return this.mTimestamp;
    }

    public PreviewMessageType getType() {
        return this.mType;
    }

    public void setType(PreviewMessageType previewMessageType) {
        this.mType = previewMessageType;
    }

    public String getArticleIdOrTitle() {
        return this.mArticleIdOrTitle;
    }

    public void setArticleIdOrTitle(String str) {
        this.mArticleIdOrTitle = str;
    }
}
