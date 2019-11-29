package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PushParamWithImg extends Message {
    public static final String DEFAULT_IMGID = "";
    public static final String DEFAULT_PSTR = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String imgid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String pstr;

    public PushParamWithImg(String str, String str2) {
        this.pstr = str;
        this.imgid = str2;
    }

    private PushParamWithImg(Builder builder) {
        this(builder.pstr, builder.imgid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushParamWithImg)) {
            return false;
        }
        PushParamWithImg pushParamWithImg = (PushParamWithImg) obj;
        if (!equals((Object) this.pstr, (Object) pushParamWithImg.pstr) || !equals((Object) this.imgid, (Object) pushParamWithImg.imgid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.pstr;
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

    public static final class Builder extends Message.Builder<PushParamWithImg> {
        public String imgid;
        public String pstr;

        public Builder() {
        }

        public Builder(PushParamWithImg pushParamWithImg) {
            super(pushParamWithImg);
            if (pushParamWithImg != null) {
                this.pstr = pushParamWithImg.pstr;
                this.imgid = pushParamWithImg.imgid;
            }
        }

        public Builder pstr(String str) {
            this.pstr = str;
            return this;
        }

        public Builder imgid(String str) {
            this.imgid = str;
            return this;
        }

        public PushParamWithImg build() {
            return new PushParamWithImg(this);
        }
    }
}
