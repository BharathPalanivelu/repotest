package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ImageDownloadResult extends Message {
    public static final f DEFAULT_CONTENT = f.f32736b;
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_THUMB = false;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.BYTES)
    public final f Content;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String RequestId;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean Thumb;

    public ImageDownloadResult(f fVar, Boolean bool, String str) {
        this.Content = fVar;
        this.Thumb = bool;
        this.RequestId = str;
    }

    private ImageDownloadResult(Builder builder) {
        this(builder.Content, builder.Thumb, builder.RequestId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageDownloadResult)) {
            return false;
        }
        ImageDownloadResult imageDownloadResult = (ImageDownloadResult) obj;
        if (!equals((Object) this.Content, (Object) imageDownloadResult.Content) || !equals((Object) this.Thumb, (Object) imageDownloadResult.Thumb) || !equals((Object) this.RequestId, (Object) imageDownloadResult.RequestId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        f fVar = this.Content;
        int i2 = 0;
        int hashCode = (fVar != null ? fVar.hashCode() : 0) * 37;
        Boolean bool = this.Thumb;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.RequestId;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ImageDownloadResult> {
        public f Content;
        public String RequestId;
        public Boolean Thumb;

        public Builder() {
        }

        public Builder(ImageDownloadResult imageDownloadResult) {
            super(imageDownloadResult);
            if (imageDownloadResult != null) {
                this.Content = imageDownloadResult.Content;
                this.Thumb = imageDownloadResult.Thumb;
                this.RequestId = imageDownloadResult.RequestId;
            }
        }

        public Builder Content(f fVar) {
            this.Content = fVar;
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

        public ImageDownloadResult build() {
            checkRequiredFields();
            return new ImageDownloadResult(this);
        }
    }
}
