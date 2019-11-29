package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GroupBuyCampaignItem extends Message {
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Long DEFAULT_GROUP_BUY_PRICE = 0L;
    public static final Integer DEFAULT_GROUP_SIZE = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_PAYMENT_DURATION = 0;
    public static final Integer DEFAULT_PURCHASE_LIMIT = 0;
    public static final Long DEFAULT_REBATE_AMOUNT = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long group_buy_price;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer group_size;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer payment_duration;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer purchase_limit;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long rebate_amount;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer status;

    public GroupBuyCampaignItem(Long l, Integer num, Long l2, Long l3, Long l4, Long l5, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Long l6) {
        this.campaignid = l;
        this.shopid = num;
        this.itemid = l2;
        this.modelid = l3;
        this.group_buy_price = l4;
        this.rebate_amount = l5;
        this.group_size = num2;
        this.purchase_limit = num3;
        this.payment_duration = num4;
        this.start_time = num5;
        this.end_time = num6;
        this.status = num7;
        this.id = l6;
    }

    private GroupBuyCampaignItem(Builder builder) {
        this(builder.campaignid, builder.shopid, builder.itemid, builder.modelid, builder.group_buy_price, builder.rebate_amount, builder.group_size, builder.purchase_limit, builder.payment_duration, builder.start_time, builder.end_time, builder.status, builder.id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupBuyCampaignItem)) {
            return false;
        }
        GroupBuyCampaignItem groupBuyCampaignItem = (GroupBuyCampaignItem) obj;
        if (!equals((Object) this.campaignid, (Object) groupBuyCampaignItem.campaignid) || !equals((Object) this.shopid, (Object) groupBuyCampaignItem.shopid) || !equals((Object) this.itemid, (Object) groupBuyCampaignItem.itemid) || !equals((Object) this.modelid, (Object) groupBuyCampaignItem.modelid) || !equals((Object) this.group_buy_price, (Object) groupBuyCampaignItem.group_buy_price) || !equals((Object) this.rebate_amount, (Object) groupBuyCampaignItem.rebate_amount) || !equals((Object) this.group_size, (Object) groupBuyCampaignItem.group_size) || !equals((Object) this.purchase_limit, (Object) groupBuyCampaignItem.purchase_limit) || !equals((Object) this.payment_duration, (Object) groupBuyCampaignItem.payment_duration) || !equals((Object) this.start_time, (Object) groupBuyCampaignItem.start_time) || !equals((Object) this.end_time, (Object) groupBuyCampaignItem.end_time) || !equals((Object) this.status, (Object) groupBuyCampaignItem.status) || !equals((Object) this.id, (Object) groupBuyCampaignItem.id)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.modelid;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.group_buy_price;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.rebate_amount;
        int hashCode6 = (hashCode5 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num2 = this.group_size;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.purchase_limit;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.payment_duration;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.start_time;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.end_time;
        int hashCode11 = (hashCode10 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.status;
        int hashCode12 = (hashCode11 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l6 = this.id;
        if (l6 != null) {
            i2 = l6.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GroupBuyCampaignItem> {
        public Long campaignid;
        public Integer end_time;
        public Long group_buy_price;
        public Integer group_size;
        public Long id;
        public Long itemid;
        public Long modelid;
        public Integer payment_duration;
        public Integer purchase_limit;
        public Long rebate_amount;
        public Integer shopid;
        public Integer start_time;
        public Integer status;

        public Builder() {
        }

        public Builder(GroupBuyCampaignItem groupBuyCampaignItem) {
            super(groupBuyCampaignItem);
            if (groupBuyCampaignItem != null) {
                this.campaignid = groupBuyCampaignItem.campaignid;
                this.shopid = groupBuyCampaignItem.shopid;
                this.itemid = groupBuyCampaignItem.itemid;
                this.modelid = groupBuyCampaignItem.modelid;
                this.group_buy_price = groupBuyCampaignItem.group_buy_price;
                this.rebate_amount = groupBuyCampaignItem.rebate_amount;
                this.group_size = groupBuyCampaignItem.group_size;
                this.purchase_limit = groupBuyCampaignItem.purchase_limit;
                this.payment_duration = groupBuyCampaignItem.payment_duration;
                this.start_time = groupBuyCampaignItem.start_time;
                this.end_time = groupBuyCampaignItem.end_time;
                this.status = groupBuyCampaignItem.status;
                this.id = groupBuyCampaignItem.id;
            }
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
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

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public GroupBuyCampaignItem build() {
            return new GroupBuyCampaignItem(this);
        }
    }
}
