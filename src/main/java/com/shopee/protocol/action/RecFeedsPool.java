package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RecFeedsPool extends Message {
    public static final List<RecFeeds> DEFAULT_POOL = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = RecFeeds.class, tag = 1)
    public final List<RecFeeds> pool;

    public RecFeedsPool(List<RecFeeds> list) {
        this.pool = immutableCopyOf(list);
    }

    private RecFeedsPool(Builder builder) {
        this(builder.pool);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RecFeedsPool)) {
            return false;
        }
        return equals((List<?>) this.pool, (List<?>) ((RecFeedsPool) obj).pool);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<RecFeeds> list = this.pool;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<RecFeedsPool> {
        public List<RecFeeds> pool;

        public Builder() {
        }

        public Builder(RecFeedsPool recFeedsPool) {
            super(recFeedsPool);
            if (recFeedsPool != null) {
                this.pool = RecFeedsPool.copyOf(recFeedsPool.pool);
            }
        }

        public Builder pool(List<RecFeeds> list) {
            this.pool = checkForNulls(list);
            return this;
        }

        public RecFeedsPool build() {
            return new RecFeedsPool(this);
        }
    }
}
