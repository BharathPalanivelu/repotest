package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ImageUploadResult extends Message {
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String Name;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String RequestId;

    public ImageUploadResult(String str, String str2) {
        this.Name = str;
        this.RequestId = str2;
    }

    private ImageUploadResult(Builder builder) {
        this(builder.Name, builder.RequestId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageUploadResult)) {
            return false;
        }
        ImageUploadResult imageUploadResult = (ImageUploadResult) obj;
        if (!equals((Object) this.Name, (Object) imageUploadResult.Name) || !equals((Object) this.RequestId, (Object) imageUploadResult.RequestId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.Name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.RequestId;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ImageUploadResult> {
        public String Name;
        public String RequestId;

        public Builder() {
        }

        public Builder(ImageUploadResult imageUploadResult) {
            super(imageUploadResult);
            if (imageUploadResult != null) {
                this.Name = imageUploadResult.Name;
                this.RequestId = imageUploadResult.RequestId;
            }
        }

        public Builder Name(String str) {
            this.Name = str;
            return this;
        }

        public Builder RequestId(String str) {
            this.RequestId = str;
            return this;
        }

        public ImageUploadResult build() {
            checkRequiredFields();
            return new ImageUploadResult(this);
        }
    }
}
