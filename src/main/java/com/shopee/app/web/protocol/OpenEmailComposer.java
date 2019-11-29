package com.shopee.app.web.protocol;

import android.text.TextUtils;

public class OpenEmailComposer {
    String body;
    String imageFilename;
    String imageUrl;
    String subject;

    public String getSubject() {
        return this.subject;
    }

    public String getBody() {
        return this.body;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageFilename() {
        return this.imageFilename;
    }

    public boolean hasImage() {
        return !TextUtils.isEmpty(this.imageUrl) && !TextUtils.isEmpty(this.imageFilename);
    }
}
