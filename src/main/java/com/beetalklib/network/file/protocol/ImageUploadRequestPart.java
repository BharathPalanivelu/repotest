package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ImageUploadRequestPart extends Message {
    public static final f DEFAULT_CONTENT = f.f32736b;
    public static final Integer DEFAULT_PARTID = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.BYTES)
    public final f Content;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer PartId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String RequestId;

    public ImageUploadRequestPart(String str, Integer num, f fVar) {
        this.RequestId = str;
        this.PartId = num;
        this.Content = fVar;
    }

    private ImageUploadRequestPart(Builder builder) {
        this(builder.RequestId, builder.PartId, builder.Content);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageUploadRequestPart)) {
            return false;
        }
        ImageUploadRequestPart imageUploadRequestPart = (ImageUploadRequestPart) obj;
        if (!equals((Object) this.RequestId, (Object) imageUploadRequestPart.RequestId) || !equals((Object) this.PartId, (Object) imageUploadRequestPart.PartId) || !equals((Object) this.Content, (Object) imageUploadRequestPart.Content)) {
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
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        f fVar = this.Content;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ImageUploadRequestPart> {
        public f Content;
        public Integer PartId;
        public String RequestId;

        public Builder() {
        }

        public Builder(ImageUploadRequestPart imageUploadRequestPart) {
            super(imageUploadRequestPart);
            if (imageUploadRequestPart != null) {
                this.RequestId = imageUploadRequestPart.RequestId;
                this.PartId = imageUploadRequestPart.PartId;
                this.Content = imageUploadRequestPart.Content;
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

        public Builder Content(f fVar) {
            this.Content = fVar;
            return this;
        }

        public ImageUploadRequestPart build() {
            checkRequiredFields();
            return new ImageUploadRequestPart(this);
        }
    }
}
