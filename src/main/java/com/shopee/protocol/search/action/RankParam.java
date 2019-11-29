package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RankParam extends Message {
    public static final Integer DEFAULT_PLATFORM = 0;
    public static final Integer DEFAULT_SORTTYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer Platform;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer Sorttype;

    public RankParam(Integer num, Integer num2) {
        this.Sorttype = num;
        this.Platform = num2;
    }

    private RankParam(Builder builder) {
        this(builder.Sorttype, builder.Platform);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RankParam)) {
            return false;
        }
        RankParam rankParam = (RankParam) obj;
        if (!equals((Object) this.Sorttype, (Object) rankParam.Sorttype) || !equals((Object) this.Platform, (Object) rankParam.Platform)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.Sorttype;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.Platform;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RankParam> {
        public Integer Platform;
        public Integer Sorttype;

        public Builder() {
        }

        public Builder(RankParam rankParam) {
            super(rankParam);
            if (rankParam != null) {
                this.Sorttype = rankParam.Sorttype;
                this.Platform = rankParam.Platform;
            }
        }

        public Builder Sorttype(Integer num) {
            this.Sorttype = num;
            return this;
        }

        public Builder Platform(Integer num) {
            this.Platform = num;
            return this;
        }

        public RankParam build() {
            return new RankParam(this);
        }
    }
}
