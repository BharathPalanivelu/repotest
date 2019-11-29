package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShuffleInfo extends Message {
    public static final Integer DEFAULT_COUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer count;

    public ShuffleInfo(Integer num) {
        this.count = num;
    }

    private ShuffleInfo(Builder builder) {
        this(builder.count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShuffleInfo)) {
            return false;
        }
        return equals((Object) this.count, (Object) ((ShuffleInfo) obj).count);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.count;
            i = num != null ? num.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ShuffleInfo> {
        public Integer count;

        public Builder() {
        }

        public Builder(ShuffleInfo shuffleInfo) {
            super(shuffleInfo);
            if (shuffleInfo != null) {
                this.count = shuffleInfo.count;
            }
        }

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public ShuffleInfo build() {
            return new ShuffleInfo(this);
        }
    }
}
