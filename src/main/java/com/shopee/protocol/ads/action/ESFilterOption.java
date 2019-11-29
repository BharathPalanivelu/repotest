package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ESFilterOption extends Message {
    public static final Long DEFAULT_ADS_ID = 0L;
    public static final Long DEFAULT_END_TIME = 0L;
    public static final Long DEFAULT_ITEM_ID = 0L;
    public static final Long DEFAULT_SHOP_ID = 0L;
    public static final Long DEFAULT_START_TIME = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long ads_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long end_time;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long item_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long shop_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long start_time;

    public ESFilterOption(Long l, Long l2, Long l3, Long l4, Long l5) {
        this.start_time = l;
        this.end_time = l2;
        this.shop_id = l3;
        this.ads_id = l4;
        this.item_id = l5;
    }

    private ESFilterOption(Builder builder) {
        this(builder.start_time, builder.end_time, builder.shop_id, builder.ads_id, builder.item_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ESFilterOption)) {
            return false;
        }
        ESFilterOption eSFilterOption = (ESFilterOption) obj;
        if (!equals((Object) this.start_time, (Object) eSFilterOption.start_time) || !equals((Object) this.end_time, (Object) eSFilterOption.end_time) || !equals((Object) this.shop_id, (Object) eSFilterOption.shop_id) || !equals((Object) this.ads_id, (Object) eSFilterOption.ads_id) || !equals((Object) this.item_id, (Object) eSFilterOption.item_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.start_time;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.end_time;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.shop_id;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.ads_id;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.item_id;
        if (l5 != null) {
            i2 = l5.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ESFilterOption> {
        public Long ads_id;
        public Long end_time;
        public Long item_id;
        public Long shop_id;
        public Long start_time;

        public Builder() {
        }

        public Builder(ESFilterOption eSFilterOption) {
            super(eSFilterOption);
            if (eSFilterOption != null) {
                this.start_time = eSFilterOption.start_time;
                this.end_time = eSFilterOption.end_time;
                this.shop_id = eSFilterOption.shop_id;
                this.ads_id = eSFilterOption.ads_id;
                this.item_id = eSFilterOption.item_id;
            }
        }

        public Builder start_time(Long l) {
            this.start_time = l;
            return this;
        }

        public Builder end_time(Long l) {
            this.end_time = l;
            return this;
        }

        public Builder shop_id(Long l) {
            this.shop_id = l;
            return this;
        }

        public Builder ads_id(Long l) {
            this.ads_id = l;
            return this;
        }

        public Builder item_id(Long l) {
            this.item_id = l;
            return this;
        }

        public ESFilterOption build() {
            return new ESFilterOption(this);
        }
    }
}
