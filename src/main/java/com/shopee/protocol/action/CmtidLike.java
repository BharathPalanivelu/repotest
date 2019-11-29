package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CmtidLike extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final Boolean DEFAULT_LIKED = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean liked;

    public CmtidLike(Long l, Boolean bool) {
        this.cmtid = l;
        this.liked = bool;
    }

    private CmtidLike(Builder builder) {
        this(builder.cmtid, builder.liked);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CmtidLike)) {
            return false;
        }
        CmtidLike cmtidLike = (CmtidLike) obj;
        if (!equals((Object) this.cmtid, (Object) cmtidLike.cmtid) || !equals((Object) this.liked, (Object) cmtidLike.liked)) {
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
        Boolean bool = this.liked;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CmtidLike> {
        public Long cmtid;
        public Boolean liked;

        public Builder() {
        }

        public Builder(CmtidLike cmtidLike) {
            super(cmtidLike);
            if (cmtidLike != null) {
                this.cmtid = cmtidLike.cmtid;
                this.liked = cmtidLike.liked;
            }
        }

        public Builder cmtid(Long l) {
            this.cmtid = l;
            return this;
        }

        public Builder liked(Boolean bool) {
            this.liked = bool;
            return this;
        }

        public CmtidLike build() {
            return new CmtidLike(this);
        }
    }
}
