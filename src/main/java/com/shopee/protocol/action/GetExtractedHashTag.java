package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetExtractedHashTag extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String text;

    public GetExtractedHashTag(String str, String str2) {
        this.requestid = str;
        this.text = str2;
    }

    private GetExtractedHashTag(Builder builder) {
        this(builder.requestid, builder.text);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetExtractedHashTag)) {
            return false;
        }
        GetExtractedHashTag getExtractedHashTag = (GetExtractedHashTag) obj;
        if (!equals((Object) this.requestid, (Object) getExtractedHashTag.requestid) || !equals((Object) this.text, (Object) getExtractedHashTag.text)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.text;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetExtractedHashTag> {
        public String requestid;
        public String text;

        public Builder() {
        }

        public Builder(GetExtractedHashTag getExtractedHashTag) {
            super(getExtractedHashTag);
            if (getExtractedHashTag != null) {
                this.requestid = getExtractedHashTag.requestid;
                this.text = getExtractedHashTag.text;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public GetExtractedHashTag build() {
            return new GetExtractedHashTag(this);
        }
    }
}
