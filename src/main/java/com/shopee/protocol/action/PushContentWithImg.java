package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PushContentWithImg extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_IMGID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String imgid;

    public PushContentWithImg(String str, String str2) {
        this.content = str;
        this.imgid = str2;
    }

    private PushContentWithImg(Builder builder) {
        this(builder.content, builder.imgid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushContentWithImg)) {
            return false;
        }
        PushContentWithImg pushContentWithImg = (PushContentWithImg) obj;
        if (!equals((Object) this.content, (Object) pushContentWithImg.content) || !equals((Object) this.imgid, (Object) pushContentWithImg.imgid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.content;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.imgid;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PushContentWithImg> {
        public String content;
        public String imgid;

        public Builder() {
        }

        public Builder(PushContentWithImg pushContentWithImg) {
            super(pushContentWithImg);
            if (pushContentWithImg != null) {
                this.content = pushContentWithImg.content;
                this.imgid = pushContentWithImg.imgid;
            }
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public Builder imgid(String str) {
            this.imgid = str;
            return this;
        }

        public PushContentWithImg build() {
            return new PushContentWithImg(this);
        }
    }
}
