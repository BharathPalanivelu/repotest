package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingSort extends Message {
    public static final Integer DEFAULT_SORTMETHOD = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer sortMethod;

    public TrackingSort(Integer num) {
        this.sortMethod = num;
    }

    private TrackingSort(Builder builder) {
        this(builder.sortMethod);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingSort)) {
            return false;
        }
        return equals((Object) this.sortMethod, (Object) ((TrackingSort) obj).sortMethod);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.sortMethod;
            i = num != null ? num.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<TrackingSort> {
        public Integer sortMethod;

        public Builder() {
        }

        public Builder(TrackingSort trackingSort) {
            super(trackingSort);
            if (trackingSort != null) {
                this.sortMethod = trackingSort.sortMethod;
            }
        }

        public Builder sortMethod(Integer num) {
            this.sortMethod = num;
            return this;
        }

        public TrackingSort build() {
            return new TrackingSort(this);
        }
    }
}
