package com.salesforce.android.chat.ui.internal.filetransfer.model;

import android.net.Uri;
import com.salesforce.android.service.common.utilities.spatial.Orientation;
import java.util.Locale;

public class ImageMeta {
    private final Uri mContentUri;
    private final String mMimeType;
    private final Orientation mOrientation;

    public ImageMeta(Uri uri, String str, Orientation orientation) {
        this.mContentUri = uri;
        this.mMimeType = str;
        this.mOrientation = orientation;
    }

    public Uri getContentUri() {
        return this.mContentUri;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public Orientation getOrientation() {
        return this.mOrientation;
    }

    public String toString() {
        return String.format(Locale.US, "%s[uri=%s, mimetype=%s, orientation=%s]", new Object[]{getClass().getSimpleName(), this.mContentUri, this.mMimeType, this.mOrientation});
    }
}
