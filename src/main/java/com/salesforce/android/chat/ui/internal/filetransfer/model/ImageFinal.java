package com.salesforce.android.chat.ui.internal.filetransfer.model;

public class ImageFinal {
    private final byte[] mImageBytes;
    private final String mMimeType;

    public ImageFinal(byte[] bArr, String str) {
        this.mImageBytes = bArr;
        this.mMimeType = str;
    }

    public byte[] getImageBytes() {
        return this.mImageBytes;
    }

    public String getMimeType() {
        return this.mMimeType;
    }
}
