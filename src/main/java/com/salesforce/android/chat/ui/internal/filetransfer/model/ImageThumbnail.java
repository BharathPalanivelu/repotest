package com.salesforce.android.chat.ui.internal.filetransfer.model;

import android.graphics.Bitmap;
import java.util.UUID;

public class ImageThumbnail {
    private final Bitmap mBitmap;
    private final String mId;
    private final ImageMeta mMeta;

    public ImageThumbnail(ImageMeta imageMeta, Bitmap bitmap) {
        this(UUID.randomUUID().toString(), imageMeta, bitmap);
    }

    public ImageThumbnail(String str, ImageMeta imageMeta, Bitmap bitmap) {
        this.mId = str;
        this.mMeta = imageMeta;
        this.mBitmap = bitmap;
    }

    public String getId() {
        return this.mId;
    }

    public ImageMeta getMeta() {
        return this.mMeta;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }
}
