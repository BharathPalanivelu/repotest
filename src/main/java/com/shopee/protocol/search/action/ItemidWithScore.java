package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemidWithScore extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_MONTH_CLICK = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_SOLD_COUNT = 0L;
    public static final Integer DEFAULT_SOLD_SCORE = 0;
    public static final Long DEFAULT_VIEW_COUNT = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer month_click;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long sold_count;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer sold_score;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long view_count;

    public ItemidWithScore(Long l, Integer num, Integer num2, Long l2, Long l3, Integer num3) {
        this.itemid = l;
        this.shopid = num;
        this.sold_score = num2;
        this.view_count = l2;
        this.sold_count = l3;
        this.month_click = num3;
    }

    private ItemidWithScore(Builder builder) {
        this(builder.itemid, builder.shopid, builder.sold_score, builder.view_count, builder.sold_count, builder.month_click);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemidWithScore)) {
            return false;
        }
        ItemidWithScore itemidWithScore = (ItemidWithScore) obj;
        if (!equals((Object) this.itemid, (Object) itemidWithScore.itemid) || !equals((Object) this.shopid, (Object) itemidWithScore.shopid) || !equals((Object) this.sold_score, (Object) itemidWithScore.sold_score) || !equals((Object) this.view_count, (Object) itemidWithScore.view_count) || !equals((Object) this.sold_count, (Object) itemidWithScore.sold_count) || !equals((Object) this.month_click, (Object) itemidWithScore.month_click)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.sold_score;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.view_count;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.sold_count;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num3 = this.month_click;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemidWithScore> {
        public Long itemid;
        public Integer month_click;
        public Integer shopid;
        public Long sold_count;
        public Integer sold_score;
        public Long view_count;

        public Builder() {
        }

        public Builder(ItemidWithScore itemidWithScore) {
            super(itemidWithScore);
            if (itemidWithScore != null) {
                this.itemid = itemidWithScore.itemid;
                this.shopid = itemidWithScore.shopid;
                this.sold_score = itemidWithScore.sold_score;
                this.view_count = itemidWithScore.view_count;
                this.sold_count = itemidWithScore.sold_count;
                this.month_click = itemidWithScore.month_click;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder sold_score(Integer num) {
            this.sold_score = num;
            return this;
        }

        public Builder view_count(Long l) {
            this.view_count = l;
            return this;
        }

        public Builder sold_count(Long l) {
            this.sold_count = l;
            return this;
        }

        public Builder month_click(Integer num) {
            this.month_click = num;
            return this;
        }

        public ItemidWithScore build() {
            return new ItemidWithScore(this);
        }
    }
}
