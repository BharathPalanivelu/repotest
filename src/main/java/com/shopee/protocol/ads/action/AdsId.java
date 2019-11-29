package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AdsId extends Message {
    public static final Long DEFAULT_ADSID = 0L;
    public static final Integer DEFAULT_ERRCODE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer errcode;

    public AdsId(Integer num, Long l) {
        this.errcode = num;
        this.adsid = l;
    }

    private AdsId(Builder builder) {
        this(builder.errcode, builder.adsid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsId)) {
            return false;
        }
        AdsId adsId = (AdsId) obj;
        if (!equals((Object) this.errcode, (Object) adsId.errcode) || !equals((Object) this.adsid, (Object) adsId.adsid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.errcode;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.adsid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdsId> {
        public Long adsid;
        public Integer errcode;

        public Builder() {
        }

        public Builder(AdsId adsId) {
            super(adsId);
            if (adsId != null) {
                this.errcode = adsId.errcode;
                this.adsid = adsId.adsid;
            }
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public AdsId build() {
            return new AdsId(this);
        }
    }
}
