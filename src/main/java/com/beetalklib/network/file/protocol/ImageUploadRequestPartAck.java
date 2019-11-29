package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ImageUploadRequestPartAck extends Message {
    public static final Integer DEFAULT_PARTID = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer PartId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String RequestId;

    public ImageUploadRequestPartAck(String str, Integer num) {
        this.RequestId = str;
        this.PartId = num;
    }

    private ImageUploadRequestPartAck(Builder builder) {
        this(builder.RequestId, builder.PartId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageUploadRequestPartAck)) {
            return false;
        }
        ImageUploadRequestPartAck imageUploadRequestPartAck = (ImageUploadRequestPartAck) obj;
        if (!equals((Object) this.RequestId, (Object) imageUploadRequestPartAck.RequestId) || !equals((Object) this.PartId, (Object) imageUploadRequestPartAck.PartId)) {
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
        Integer num = this.PartId;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ImageUploadRequestPartAck> {
        public Integer PartId;
        public String RequestId;

        public Builder() {
        }

        public Builder(ImageUploadRequestPartAck imageUploadRequestPartAck) {
            super(imageUploadRequestPartAck);
            if (imageUploadRequestPartAck != null) {
                this.RequestId = imageUploadRequestPartAck.RequestId;
                this.PartId = imageUploadRequestPartAck.PartId;
            }
        }

        public Builder RequestId(String str) {
            this.RequestId = str;
            return this;
        }

        public Builder PartId(Integer num) {
            this.PartId = num;
            return this;
        }

        public ImageUploadRequestPartAck build() {
            checkRequiredFields();
            return new ImageUploadRequestPartAck(this);
        }
    }
}
