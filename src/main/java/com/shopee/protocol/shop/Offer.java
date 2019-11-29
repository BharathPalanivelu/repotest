package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Offer extends Message {
    public static final Integer DEFAULT_BUYER_USERID = 0;
    public static final Integer DEFAULT_BUY_COUNT = 0;
    public static final Long DEFAULT_CHATID = 0L;
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_OFFERID = 0L;
    public static final Long DEFAULT_OFFER_PRICE = 0L;
    public static final Integer DEFAULT_OFFER_STATUS = 0;
    public static final Long DEFAULT_PCHATID = 0L;
    public static final Integer DEFAULT_SELLER_USERID = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_SNAPSHOTID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer buy_count;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer buyer_userid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long chatid;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long offer_price;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer offer_status;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long offerid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long pchatid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer seller_userid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long snapshotid;

    public Offer(Long l, Long l2, Long l3, Integer num, Integer num2, Integer num3, Long l4, Long l5, Integer num4, Long l6, Integer num5, Integer num6, Integer num7, Long l7) {
        this.offerid = l;
        this.pchatid = l2;
        this.chatid = l3;
        this.buyer_userid = num;
        this.seller_userid = num2;
        this.shopid = num3;
        this.itemid = l4;
        this.modelid = l5;
        this.buy_count = num4;
        this.offer_price = l6;
        this.offer_status = num5;
        this.ctime = num6;
        this.mtime = num7;
        this.snapshotid = l7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Offer(com.shopee.protocol.shop.Offer.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Long r2 = r0.offerid
            java.lang.Long r3 = r0.pchatid
            java.lang.Long r4 = r0.chatid
            java.lang.Integer r5 = r0.buyer_userid
            java.lang.Integer r6 = r0.seller_userid
            java.lang.Integer r7 = r0.shopid
            java.lang.Long r8 = r0.itemid
            java.lang.Long r9 = r0.modelid
            java.lang.Integer r10 = r0.buy_count
            java.lang.Long r11 = r0.offer_price
            java.lang.Integer r12 = r0.offer_status
            java.lang.Integer r13 = r0.ctime
            java.lang.Integer r14 = r0.mtime
            java.lang.Long r15 = r0.snapshotid
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.Offer.<init>(com.shopee.protocol.shop.Offer$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Offer)) {
            return false;
        }
        Offer offer = (Offer) obj;
        if (!equals((Object) this.offerid, (Object) offer.offerid) || !equals((Object) this.pchatid, (Object) offer.pchatid) || !equals((Object) this.chatid, (Object) offer.chatid) || !equals((Object) this.buyer_userid, (Object) offer.buyer_userid) || !equals((Object) this.seller_userid, (Object) offer.seller_userid) || !equals((Object) this.shopid, (Object) offer.shopid) || !equals((Object) this.itemid, (Object) offer.itemid) || !equals((Object) this.modelid, (Object) offer.modelid) || !equals((Object) this.buy_count, (Object) offer.buy_count) || !equals((Object) this.offer_price, (Object) offer.offer_price) || !equals((Object) this.offer_status, (Object) offer.offer_status) || !equals((Object) this.ctime, (Object) offer.ctime) || !equals((Object) this.mtime, (Object) offer.mtime) || !equals((Object) this.snapshotid, (Object) offer.snapshotid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.offerid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.pchatid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.chatid;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.buyer_userid;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.seller_userid;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l4 = this.itemid;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.modelid;
        int hashCode8 = (hashCode7 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num4 = this.buy_count;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l6 = this.offer_price;
        int hashCode10 = (hashCode9 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Integer num5 = this.offer_status;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode12 = (hashCode11 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.mtime;
        int hashCode13 = (hashCode12 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l7 = this.snapshotid;
        if (l7 != null) {
            i2 = l7.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Offer> {
        public Integer buy_count;
        public Integer buyer_userid;
        public Long chatid;
        public Integer ctime;
        public Long itemid;
        public Long modelid;
        public Integer mtime;
        public Long offer_price;
        public Integer offer_status;
        public Long offerid;
        public Long pchatid;
        public Integer seller_userid;
        public Integer shopid;
        public Long snapshotid;

        public Builder() {
        }

        public Builder(Offer offer) {
            super(offer);
            if (offer != null) {
                this.offerid = offer.offerid;
                this.pchatid = offer.pchatid;
                this.chatid = offer.chatid;
                this.buyer_userid = offer.buyer_userid;
                this.seller_userid = offer.seller_userid;
                this.shopid = offer.shopid;
                this.itemid = offer.itemid;
                this.modelid = offer.modelid;
                this.buy_count = offer.buy_count;
                this.offer_price = offer.offer_price;
                this.offer_status = offer.offer_status;
                this.ctime = offer.ctime;
                this.mtime = offer.mtime;
                this.snapshotid = offer.snapshotid;
            }
        }

        public Builder offerid(Long l) {
            this.offerid = l;
            return this;
        }

        public Builder pchatid(Long l) {
            this.pchatid = l;
            return this;
        }

        public Builder chatid(Long l) {
            this.chatid = l;
            return this;
        }

        public Builder buyer_userid(Integer num) {
            this.buyer_userid = num;
            return this;
        }

        public Builder seller_userid(Integer num) {
            this.seller_userid = num;
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

        public Builder buy_count(Integer num) {
            this.buy_count = num;
            return this;
        }

        public Builder offer_price(Long l) {
            this.offer_price = l;
            return this;
        }

        public Builder offer_status(Integer num) {
            this.offer_status = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder snapshotid(Long l) {
            this.snapshotid = l;
            return this;
        }

        public Offer build() {
            return new Offer(this);
        }
    }
}
