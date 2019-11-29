package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CardPromotionUsage extends Message {
    public static final String DEFAULT_CARD_ID = "";
    public static final Integer DEFAULT_CARD_PROMOTION_ID = 0;
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String card_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer card_promotion_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;

    public CardPromotionUsage(Long l, Integer num, Integer num2, Integer num3, String str) {
        this.checkoutid = l;
        this.card_promotion_id = num;
        this.userid = num2;
        this.ctime = num3;
        this.card_id = str;
    }

    private CardPromotionUsage(Builder builder) {
        this(builder.checkoutid, builder.card_promotion_id, builder.userid, builder.ctime, builder.card_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CardPromotionUsage)) {
            return false;
        }
        CardPromotionUsage cardPromotionUsage = (CardPromotionUsage) obj;
        if (!equals((Object) this.checkoutid, (Object) cardPromotionUsage.checkoutid) || !equals((Object) this.card_promotion_id, (Object) cardPromotionUsage.card_promotion_id) || !equals((Object) this.userid, (Object) cardPromotionUsage.userid) || !equals((Object) this.ctime, (Object) cardPromotionUsage.ctime) || !equals((Object) this.card_id, (Object) cardPromotionUsage.card_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.checkoutid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.card_promotion_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.userid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.card_id;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CardPromotionUsage> {
        public String card_id;
        public Integer card_promotion_id;
        public Long checkoutid;
        public Integer ctime;
        public Integer userid;

        public Builder() {
        }

        public Builder(CardPromotionUsage cardPromotionUsage) {
            super(cardPromotionUsage);
            if (cardPromotionUsage != null) {
                this.checkoutid = cardPromotionUsage.checkoutid;
                this.card_promotion_id = cardPromotionUsage.card_promotion_id;
                this.userid = cardPromotionUsage.userid;
                this.ctime = cardPromotionUsage.ctime;
                this.card_id = cardPromotionUsage.card_id;
            }
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder card_promotion_id(Integer num) {
            this.card_promotion_id = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder card_id(String str) {
            this.card_id = str;
            return this;
        }

        public CardPromotionUsage build() {
            return new CardPromotionUsage(this);
        }
    }
}
