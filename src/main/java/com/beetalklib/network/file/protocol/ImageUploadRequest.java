package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ImageUploadRequest extends Message {
    public static final f DEFAULT_CONTENT = f.f32736b;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_RESTAG = "";
    public static final Boolean DEFAULT_THUMB = false;
    public static final Integer DEFAULT_TIMEOUT = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.BYTES)
    public final f Content;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String Name;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String RequestId;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String ResTag;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.BOOL)
    public final Boolean Thumb;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer Timeout;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String Token;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String Type;

    public ImageUploadRequest(String str, String str2, f fVar, Boolean bool, String str3, Integer num, String str4, String str5) {
        this.Token = str;
        this.Name = str2;
        this.Content = fVar;
        this.Thumb = bool;
        this.Type = str3;
        this.Timeout = num;
        this.RequestId = str4;
        this.ResTag = str5;
    }

    private ImageUploadRequest(Builder builder) {
        this(builder.Token, builder.Name, builder.Content, builder.Thumb, builder.Type, builder.Timeout, builder.RequestId, builder.ResTag);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageUploadRequest)) {
            return false;
        }
        ImageUploadRequest imageUploadRequest = (ImageUploadRequest) obj;
        if (!equals((Object) this.Token, (Object) imageUploadRequest.Token) || !equals((Object) this.Name, (Object) imageUploadRequest.Name) || !equals((Object) this.Content, (Object) imageUploadRequest.Content) || !equals((Object) this.Thumb, (Object) imageUploadRequest.Thumb) || !equals((Object) this.Type, (Object) imageUploadRequest.Type) || !equals((Object) this.Timeout, (Object) imageUploadRequest.Timeout) || !equals((Object) this.RequestId, (Object) imageUploadRequest.RequestId) || !equals((Object) this.ResTag, (Object) imageUploadRequest.ResTag)) {
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
        f fVar = this.Content;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Boolean bool = this.Thumb;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str3 = this.Type;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.Timeout;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        String str4 = this.RequestId;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.ResTag;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ImageUploadRequest> {
        public f Content;
        public String Name;
        public String RequestId;
        public String ResTag;
        public Boolean Thumb;
        public Integer Timeout;
        public String Token;
        public String Type;

        public Builder() {
        }

        public Builder(ImageUploadRequest imageUploadRequest) {
            super(imageUploadRequest);
            if (imageUploadRequest != null) {
                this.Token = imageUploadRequest.Token;
                this.Name = imageUploadRequest.Name;
                this.Content = imageUploadRequest.Content;
                this.Thumb = imageUploadRequest.Thumb;
                this.Type = imageUploadRequest.Type;
                this.Timeout = imageUploadRequest.Timeout;
                this.RequestId = imageUploadRequest.RequestId;
                this.ResTag = imageUploadRequest.ResTag;
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

        public Builder Content(f fVar) {
            this.Content = fVar;
            return this;
        }

        public Builder Thumb(Boolean bool) {
            this.Thumb = bool;
            return this;
        }

        public Builder Type(String str) {
            this.Type = str;
            return this;
        }

        public Builder Timeout(Integer num) {
            this.Timeout = num;
            return this;
        }

        public Builder RequestId(String str) {
            this.RequestId = str;
            return this;
        }

        public Builder ResTag(String str) {
            this.ResTag = str;
            return this;
        }

        public ImageUploadRequest build() {
            checkRequiredFields();
            return new ImageUploadRequest(this);
        }
    }
}
