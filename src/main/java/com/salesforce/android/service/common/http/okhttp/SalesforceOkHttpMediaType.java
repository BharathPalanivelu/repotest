package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpMediaType;
import java.nio.charset.Charset;
import okhttp3.MediaType;

public class SalesforceOkHttpMediaType implements HttpMediaType {
    private final MediaType mMediaType;

    public static SalesforceOkHttpMediaType wrap(MediaType mediaType) {
        if (mediaType == null) {
            return null;
        }
        return new SalesforceOkHttpMediaType(mediaType);
    }

    public static SalesforceOkHttpMediaType parse(String str) {
        return wrap(MediaType.parse(str));
    }

    private SalesforceOkHttpMediaType(MediaType mediaType) {
        this.mMediaType = mediaType;
    }

    public String type() {
        return this.mMediaType.type();
    }

    public String subtype() {
        return this.mMediaType.subtype();
    }

    public Charset charset() {
        return this.mMediaType.charset();
    }

    public Charset charset(Charset charset) {
        return this.mMediaType.charset(charset);
    }

    public MediaType toOkHttpMediaType() {
        return this.mMediaType;
    }

    public String toString() {
        return this.mMediaType.toString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpMediaType) && this.mMediaType.equals(((HttpMediaType) obj).toOkHttpMediaType());
    }

    public int hashCode() {
        return this.mMediaType.hashCode();
    }
}
