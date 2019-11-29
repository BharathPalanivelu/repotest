package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class HotHashTagBoostInfo extends Message {
    public static final Double DEFAULT_BOOST = Double.valueOf(0.0d);
    public static final String DEFAULT_HASHTAG = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double boost;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String hashtag;

    public HotHashTagBoostInfo(String str, Double d2) {
        this.hashtag = str;
        this.boost = d2;
    }

    private HotHashTagBoostInfo(Builder builder) {
        this(builder.hashtag, builder.boost);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HotHashTagBoostInfo)) {
            return false;
        }
        HotHashTagBoostInfo hotHashTagBoostInfo = (HotHashTagBoostInfo) obj;
        if (!equals((Object) this.hashtag, (Object) hotHashTagBoostInfo.hashtag) || !equals((Object) this.boost, (Object) hotHashTagBoostInfo.boost)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.hashtag;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Double d2 = this.boost;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<HotHashTagBoostInfo> {
        public Double boost;
        public String hashtag;

        public Builder() {
        }

        public Builder(HotHashTagBoostInfo hotHashTagBoostInfo) {
            super(hotHashTagBoostInfo);
            if (hotHashTagBoostInfo != null) {
                this.hashtag = hotHashTagBoostInfo.hashtag;
                this.boost = hotHashTagBoostInfo.boost;
            }
        }

        public Builder hashtag(String str) {
            this.hashtag = str;
            return this;
        }

        public Builder boost(Double d2) {
            this.boost = d2;
            return this;
        }

        public HotHashTagBoostInfo build() {
            return new HotHashTagBoostInfo(this);
        }
    }
}
