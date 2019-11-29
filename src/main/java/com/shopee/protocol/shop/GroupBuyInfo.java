package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GroupBuyInfo extends Message {
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Long DEFAULT_GROUP_BUY_PRICE = 0L;
    public static final Integer DEFAULT_GROUP_SIZE = 0;
    public static final Integer DEFAULT_PAYMENT_DURATION = 0;
    public static final Integer DEFAULT_PURCHASE_LIMIT = 0;
    public static final Long DEFAULT_REBATE_AMOUNT = 0L;
    public static final Integer DEFAULT_START_TIME = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long group_buy_price;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer group_size;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer payment_duration;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer purchase_limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long rebate_amount;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer start_time;

    public GroupBuyInfo(Long l, Long l2, Long l3, Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.campaignid = l;
        this.group_buy_price = l2;
        this.rebate_amount = l3;
        this.start_time = num;
        this.end_time = num2;
        this.group_size = num3;
        this.purchase_limit = num4;
        this.payment_duration = num5;
    }

    private GroupBuyInfo(Builder builder) {
        this(builder.campaignid, builder.group_buy_price, builder.rebate_amount, builder.start_time, builder.end_time, builder.group_size, builder.purchase_limit, builder.payment_duration);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupBuyInfo)) {
            return false;
        }
        GroupBuyInfo groupBuyInfo = (GroupBuyInfo) obj;
        if (!equals((Object) this.campaignid, (Object) groupBuyInfo.campaignid) || !equals((Object) this.group_buy_price, (Object) groupBuyInfo.group_buy_price) || !equals((Object) this.rebate_amount, (Object) groupBuyInfo.rebate_amount) || !equals((Object) this.start_time, (Object) groupBuyInfo.start_time) || !equals((Object) this.end_time, (Object) groupBuyInfo.end_time) || !equals((Object) this.group_size, (Object) groupBuyInfo.group_size) || !equals((Object) this.purchase_limit, (Object) groupBuyInfo.purchase_limit) || !equals((Object) this.payment_duration, (Object) groupBuyInfo.payment_duration)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.campaignid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.group_buy_price;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.rebate_amount;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.start_time;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.end_time;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.group_size;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.purchase_limit;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.payment_duration;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GroupBuyInfo> {
        public Long campaignid;
        public Integer end_time;
        public Long group_buy_price;
        public Integer group_size;
        public Integer payment_duration;
        public Integer purchase_limit;
        public Long rebate_amount;
        public Integer start_time;

        public Builder() {
        }

        public Builder(GroupBuyInfo groupBuyInfo) {
            super(groupBuyInfo);
            if (groupBuyInfo != null) {
                this.campaignid = groupBuyInfo.campaignid;
                this.group_buy_price = groupBuyInfo.group_buy_price;
                this.rebate_amount = groupBuyInfo.rebate_amount;
                this.start_time = groupBuyInfo.start_time;
                this.end_time = groupBuyInfo.end_time;
                this.group_size = groupBuyInfo.group_size;
                this.purchase_limit = groupBuyInfo.purchase_limit;
                this.payment_duration = groupBuyInfo.payment_duration;
            }
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder group_buy_price(Long l) {
            this.group_buy_price = l;
            return this;
        }

        public Builder rebate_amount(Long l) {
            this.rebate_amount = l;
            return this;
        }

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder group_size(Integer num) {
            this.group_size = num;
            return this;
        }

        public Builder purchase_limit(Integer num) {
            this.purchase_limit = num;
            return this;
        }

        public Builder payment_duration(Integer num) {
            this.payment_duration = num;
            return this;
        }

        public GroupBuyInfo build() {
            return new GroupBuyInfo(this);
        }
    }
}
