package com.shopee.app.upload.data;

import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.upload.data.UploadModelList;
import com.shopee.id.R;

public class UploadGroup {
    private String errorMessage;
    private boolean isEdit;
    private boolean isShareToFB;
    private boolean isShareToTwitter;
    private UploadItem item;
    private UploadModelList modelList;
    private String requestId;
    private boolean showProductWeight;
    private int status;
    private int timestamp;
    private boolean unListItem;
    private UploadVideo video;

    private UploadGroup(Builder builder) {
        this.errorMessage = b.e(R.string.sp_label_product_upload_failed);
        this.requestId = builder.requestId;
        setItem(builder.item);
        this.modelList = builder.modelList;
        setStatus(builder.status);
        setTimestamp(builder.timestamp);
        this.isShareToFB = builder.isShareToFB;
        this.isShareToTwitter = builder.isShareToTwitter;
        this.video = builder.video;
        this.isEdit = builder.isEdit;
        this.showProductWeight = builder.showProductWeight;
        this.unListItem = builder.unListItem;
        setErrorMessage(builder.errorMessage);
    }

    public String getRequestId() {
        return this.requestId;
    }

    public UploadItem getItem() {
        return this.item;
    }

    public UploadModelList getModelList() {
        return this.modelList;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public boolean isShareToFB() {
        return this.isShareToFB;
    }

    public boolean isShareToTwitter() {
        return this.isShareToTwitter;
    }

    public UploadVideo getVideo() {
        return this.video;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setItem(UploadItem uploadItem) {
        this.item = uploadItem;
    }

    public boolean isEdit() {
        return this.isEdit;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public boolean isNew() {
        return this.status == 0;
    }

    public boolean isInProgress() {
        return this.status == 1;
    }

    public boolean hasFailed() {
        return this.status == 2;
    }

    public boolean canAutoRetry() {
        return a.a() - this.timestamp < 120;
    }

    public void setTimestamp(int i) {
        this.timestamp = i;
    }

    public boolean showProductWeight() {
        return this.showProductWeight;
    }

    public boolean isUnListItem() {
        return this.unListItem;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String errorMessage;
        /* access modifiers changed from: private */
        public boolean isEdit;
        /* access modifiers changed from: private */
        public boolean isShareToFB;
        /* access modifiers changed from: private */
        public boolean isShareToTwitter;
        /* access modifiers changed from: private */
        public UploadItem item;
        /* access modifiers changed from: private */
        public UploadModelList modelList = new UploadModelList.Builder().build();
        /* access modifiers changed from: private */
        public String requestId;
        /* access modifiers changed from: private */
        public boolean showProductWeight;
        private boolean skipVideo;
        /* access modifiers changed from: private */
        public int status;
        /* access modifiers changed from: private */
        public int timestamp;
        /* access modifiers changed from: private */
        public boolean unListItem;
        /* access modifiers changed from: private */
        public UploadVideo video;

        public Builder requestId(String str) {
            this.requestId = str;
            return this;
        }

        public Builder item(UploadItem uploadItem) {
            this.item = uploadItem;
            return this;
        }

        public Builder modelList(UploadModelList uploadModelList) {
            this.modelList = uploadModelList;
            return this;
        }

        public Builder status(int i) {
            this.status = i;
            return this;
        }

        public Builder timestamp(int i) {
            this.timestamp = i;
            return this;
        }

        public Builder isShareToFB(boolean z) {
            this.isShareToFB = z;
            return this;
        }

        public Builder isShareToTwitter(boolean z) {
            this.isShareToTwitter = z;
            return this;
        }

        public Builder video(UploadVideo uploadVideo) {
            this.video = uploadVideo;
            return this;
        }

        public Builder isEdit(boolean z) {
            this.isEdit = z;
            return this;
        }

        public Builder errorMessage(String str) {
            this.errorMessage = str;
            return this;
        }

        public Builder showProductWeight(boolean z) {
            this.showProductWeight = z;
            return this;
        }

        public Builder unListItem(boolean z) {
            this.unListItem = z;
            return this;
        }

        public UploadGroup build() {
            return new UploadGroup(this);
        }
    }
}
