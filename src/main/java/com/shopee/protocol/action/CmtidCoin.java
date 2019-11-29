package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CmtidCoin extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final Long DEFAULT_COIN = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long coin;

    public CmtidCoin(Long l, Long l2) {
        this.cmtid = l;
        this.coin = l2;
    }

    private CmtidCoin(Builder builder) {
        this(builder.cmtid, builder.coin);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CmtidCoin)) {
            return false;
        }
        CmtidCoin cmtidCoin = (CmtidCoin) obj;
        if (!equals((Object) this.cmtid, (Object) cmtidCoin.cmtid) || !equals((Object) this.coin, (Object) cmtidCoin.coin)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.cmtid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.coin;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CmtidCoin> {
        public Long cmtid;
        public Long coin;

        public Builder() {
        }

        public Builder(CmtidCoin cmtidCoin) {
            super(cmtidCoin);
            if (cmtidCoin != null) {
                this.cmtid = cmtidCoin.cmtid;
                this.coin = cmtidCoin.coin;
            }
        }

        public Builder cmtid(Long l) {
            this.cmtid = l;
            return this;
        }

        public Builder coin(Long l) {
            this.coin = l;
            return this;
        }

        public CmtidCoin build() {
            return new CmtidCoin(this);
        }
    }
}
