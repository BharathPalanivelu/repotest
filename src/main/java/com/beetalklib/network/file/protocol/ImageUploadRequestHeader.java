package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ImageUploadRequestHeader extends Message {
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_RESTAG = "";
    public static final Boolean DEFAULT_THUMB = false;
    public static final Integer DEFAULT_TIMEOUT = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TOTALBLOCK = 0;
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String Name;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.STRING)
    public final String RequestId;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String ResTag;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean Thumb;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer Timeout;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String Token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 9, type = Message.Datatype.INT32)
    public final Integer TotalBlock;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String Type;

    public ImageUploadRequestHeader(String str, String str2, Boolean bool, String str3, Integer num, String str4, String str5, Integer num2) {
        this.Token = str;
        this.Name = str2;
        this.Thumb = bool;
        this.Type = str3;
        this.Timeout = num;
        this.RequestId = str4;
        this.ResTag = str5;
        this.TotalBlock = num2;
    }

    private ImageUploadRequestHeader(Builder builder) {
        this(builder.Token, builder.Name, builder.Thumb, builder.Type, builder.Timeout, builder.RequestId, builder.ResTag, builder.TotalBlock);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageUploadRequestHeader)) {
            return false;
        }
        ImageUploadRequestHeader imageUploadRequestHeader = (ImageUploadRequestHeader) obj;
        if (!equals((Object) this.Token, (Object) imageUploadRequestHeader.Token) || !equals((Object) this.Name, (Object) imageUploadRequestHeader.Name) || !equals((Object) this.Thumb, (Object) imageUploadRequestHeader.Thumb) || !equals((Object) this.Type, (Object) imageUploadRequestHeader.Type) || !equals((Object) this.Timeout, (Object) imageUploadRequestHeader.Timeout) || !equals((Object) this.RequestId, (Object) imageUploadRequestHeader.RequestId) || !equals((Object) this.ResTag, (Object) imageUploadRequestHeader.ResTag) || !equals((Object) this.TotalBlock, (Object) imageUploadRequestHeader.TotalBlock)) {
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
        String str3 = this.Type;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.Timeout;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        String str4 = this.RequestId;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.ResTag;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num2 = this.TotalBlock;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ImageUploadRequestHeader> {
        public String Name;
        public String RequestId;
        public String ResTag;
        public Boolean Thumb;
        public Integer Timeout;
        public String Token;
        public Integer TotalBlock;
        public String Type;

        public Builder() {
        }

        public Builder(ImageUploadRequestHeader imageUploadRequestHeader) {
            super(imageUploadRequestHeader);
            if (imageUploadRequestHeader != null) {
                this.Token = imageUploadRequestHeader.Token;
                this.Name = imageUploadRequestHeader.Name;
                this.Thumb = imageUploadRequestHeader.Thumb;
                this.Type = imageUploadRequestHeader.Type;
                this.Timeout = imageUploadRequestHeader.Timeout;
                this.RequestId = imageUploadRequestHeader.RequestId;
                this.ResTag = imageUploadRequestHeader.ResTag;
                this.TotalBlock = imageUploadRequestHeader.TotalBlock;
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

        public Builder TotalBlock(Integer num) {
            this.TotalBlock = num;
            return this;
        }

        public ImageUploadRequestHeader build() {
            checkRequiredFields();
            return new ImageUploadRequestHeader(this);
        }
    }
}
