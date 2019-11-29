package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ImageUploadRequestHeaderAck extends Message {
    public static final Boolean DEFAULT_EXISTS = false;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.BOOL)
    public final Boolean Exists;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String Name;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String RequestId;

    public ImageUploadRequestHeaderAck(String str, String str2, Boolean bool) {
        this.RequestId = str;
        this.Name = str2;
        this.Exists = bool;
    }

    private ImageUploadRequestHeaderAck(Builder builder) {
        this(builder.RequestId, builder.Name, builder.Exists);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageUploadRequestHeaderAck)) {
            return false;
        }
        ImageUploadRequestHeaderAck imageUploadRequestHeaderAck = (ImageUploadRequestHeaderAck) obj;
        if (!equals((Object) this.RequestId, (Object) imageUploadRequestHeaderAck.RequestId) || !equals((Object) this.Name, (Object) imageUploadRequestHeaderAck.Name) || !equals((Object) this.Exists, (Object) imageUploadRequestHeaderAck.Exists)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.RequestId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.Name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.Exists;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ImageUploadRequestHeaderAck> {
        public Boolean Exists;
        public String Name;
        public String RequestId;

        public Builder() {
        }

        public Builder(ImageUploadRequestHeaderAck imageUploadRequestHeaderAck) {
            super(imageUploadRequestHeaderAck);
            if (imageUploadRequestHeaderAck != null) {
                this.RequestId = imageUploadRequestHeaderAck.RequestId;
                this.Name = imageUploadRequestHeaderAck.Name;
                this.Exists = imageUploadRequestHeaderAck.Exists;
            }
        }

        public Builder RequestId(String str) {
            this.RequestId = str;
            return this;
        }

        public Builder Name(String str) {
            this.Name = str;
            return this;
        }

        public Builder Exists(Boolean bool) {
            this.Exists = bool;
            return this;
        }

        public ImageUploadRequestHeaderAck build() {
            checkRequiredFields();
            return new ImageUploadRequestHeaderAck(this);
        }
    }
}
