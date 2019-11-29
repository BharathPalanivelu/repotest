package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SlashPriceItemModelResponse extends Message {
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_NUM_ACTIVE_ACTIVITY = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer num_active_activity;

    public SlashPriceItemModelResponse(Long l, Integer num) {
        this.modelid = l;
        this.num_active_activity = num;
    }

    private SlashPriceItemModelResponse(Builder builder) {
        this(builder.modelid, builder.num_active_activity);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceItemModelResponse)) {
            return false;
        }
        SlashPriceItemModelResponse slashPriceItemModelResponse = (SlashPriceItemModelResponse) obj;
        if (!equals((Object) this.modelid, (Object) slashPriceItemModelResponse.modelid) || !equals((Object) this.num_active_activity, (Object) slashPriceItemModelResponse.num_active_activity)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.modelid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.num_active_activity;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceItemModelResponse> {
        public Long modelid;
        public Integer num_active_activity;

        public Builder() {
        }

        public Builder(SlashPriceItemModelResponse slashPriceItemModelResponse) {
            super(slashPriceItemModelResponse);
            if (slashPriceItemModelResponse != null) {
                this.modelid = slashPriceItemModelResponse.modelid;
                this.num_active_activity = slashPriceItemModelResponse.num_active_activity;
            }
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder num_active_activity(Integer num) {
            this.num_active_activity = num;
            return this;
        }

        public SlashPriceItemModelResponse build() {
            return new SlashPriceItemModelResponse(this);
        }
    }
}
