package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ImageDownloadRequest extends Message {
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_THUMB = false;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String Name;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String RequestId;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean Thumb;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String Token;

    public ImageDownloadRequest(String str, String str2, Boolean bool, String str3) {
        this.Token = str;
        this.Name = str2;
        this.Thumb = bool;
        this.RequestId = str3;
    }

    private ImageDownloadRequest(Builder builder) {
        this(builder.Token, builder.Name, builder.Thumb, builder.RequestId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageDownloadRequest)) {
            return false;
        }
        ImageDownloadRequest imageDownloadRequest = (ImageDownloadRequest) obj;
        if (!equals((Object) this.Token, (Object) imageDownloadRequest.Token) || !equals((Object) this.Name, (Object) imageDownloadRequest.Name) || !equals((Object) this.Thumb, (Object) imageDownloadRequest.Thumb) || !equals((Object) this.RequestId, (Object) imageDownloadRequest.RequestId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.Token;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.Name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.Thumb;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str3 = this.RequestId;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ImageDownloadRequest> {
        public String Name;
        public String RequestId;
        public Boolean Thumb;
        public String Token;

        public Builder() {
        }

        public Builder(ImageDownloadRequest imageDownloadRequest) {
            super(imageDownloadRequest);
            if (imageDownloadRequest != null) {
                this.Token = imageDownloadRequest.Token;
                this.Name = imageDownloadRequest.Name;
                this.Thumb = imageDownloadRequest.Thumb;
                this.RequestId = imageDownloadRequest.RequestId;
            }
        }

        public Builder Token(String str) {
            this.Token = str;
            return this;
        }

        public Builder Name(String str) {
            this.Name = str;
            return this;
        }

        public Builder Thumb(Boolean bool) {
            this.Thumb = bool;
            return this;
        }

        public Builder RequestId(String str) {
            this.RequestId = str;
            return this;
        }

        public ImageDownloadRequest build() {
            checkRequiredFields();
            return new ImageDownloadRequest(this);
        }
    }
}
