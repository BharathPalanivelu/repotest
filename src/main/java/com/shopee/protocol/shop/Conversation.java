package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Conversation extends Message {
    public static final Integer DEFAULT_ACCEPT_BUY_COUNT = 0;
    public static final Long DEFAULT_ACCEPT_PRICE = 0L;
    public static final Integer DEFAULT_ARCHIVE = 0;
    public static final Integer DEFAULT_BUYER_CLEAR_TIME = 0;
    public static final Long DEFAULT_BUYER_LAST_READ = 0L;
    public static final Integer DEFAULT_BUYER_USERID = 0;
    public static final Integer DEFAULT_BUY_COUNT = 0;
    public static final Long DEFAULT_CHATID = 0L;
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_LAST_MSGID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_OFFER_PRICE = 0L;
    public static final Integer DEFAULT_OFFER_STATUS = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Long DEFAULT_PCHATID = 0L;
    public static final Integer DEFAULT_SELLER_CLEAR_TIME = 0;
    public static final Long DEFAULT_SELLER_LAST_READ = 0L;
    public static final Integer DEFAULT_SELLER_USERID = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer accept_buy_count;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long accept_price;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer archive;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer buy_count;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer buyer_clear_time;
    @ProtoField(tag = 19, type = Message.Datatype.INT64)
    public final Long buyer_last_read;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer buyer_userid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long chatid;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 21, type = Message.Datatype.INT64)
    public final Long last_msgid;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long offer_price;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer offer_status;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long pchatid;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer seller_clear_time;
    @ProtoField(tag = 20, type = Message.Datatype.INT64)
    public final Long seller_last_read;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer seller_userid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer shopid;

    public Conversation(Long l, Integer num, Integer num2, Integer num3, Long l2, Integer num4, Long l3, Long l4, Integer num5, Integer num6, Integer num7, Long l5, Integer num8, Long l6, Long l7, Integer num9, Integer num10, Integer num11, Long l8, Long l9, Long l10) {
        this.chatid = l;
        this.buyer_userid = num;
        this.seller_userid = num2;
        this.shopid = num3;
        this.itemid = l2;
        this.buy_count = num4;
        this.offer_price = l3;
        this.accept_price = l4;
        this.offer_status = num5;
        this.ctime = num6;
        this.mtime = num7;
        this.orderid = l5;
        this.archive = num8;
        this.modelid = l6;
        this.pchatid = l7;
        this.accept_buy_count = num9;
        this.buyer_clear_time = num10;
        this.seller_clear_time = num11;
        this.buyer_last_read = l8;
        this.seller_last_read = l9;
        this.last_msgid = l10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Conversation(com.shopee.protocol.shop.Conversation.Builder r25) {
        /*
            r24 = this;
            r0 = r25
            r1 = r24
            java.lang.Long r2 = r0.chatid
            java.lang.Integer r3 = r0.buyer_userid
            java.lang.Integer r4 = r0.seller_userid
            java.lang.Integer r5 = r0.shopid
            java.lang.Long r6 = r0.itemid
            java.lang.Integer r7 = r0.buy_count
            java.lang.Long r8 = r0.offer_price
            java.lang.Long r9 = r0.accept_price
            java.lang.Integer r10 = r0.offer_status
            java.lang.Integer r11 = r0.ctime
            java.lang.Integer r12 = r0.mtime
            java.lang.Long r13 = r0.orderid
            java.lang.Integer r14 = r0.archive
            java.lang.Long r15 = r0.modelid
            r23 = r1
            java.lang.Long r1 = r0.pchatid
            r16 = r1
            java.lang.Integer r1 = r0.accept_buy_count
            r17 = r1
            java.lang.Integer r1 = r0.buyer_clear_time
            r18 = r1
            java.lang.Integer r1 = r0.seller_clear_time
            r19 = r1
            java.lang.Long r1 = r0.buyer_last_read
            r20 = r1
            java.lang.Long r1 = r0.seller_last_read
            r21 = r1
            java.lang.Long r1 = r0.last_msgid
            r22 = r1
            r1 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r24.setBuilder(r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.Conversation.<init>(com.shopee.protocol.shop.Conversation$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Conversation)) {
            return false;
        }
        Conversation conversation = (Conversation) obj;
        if (!equals((Object) this.chatid, (Object) conversation.chatid) || !equals((Object) this.buyer_userid, (Object) conversation.buyer_userid) || !equals((Object) this.seller_userid, (Object) conversation.seller_userid) || !equals((Object) this.shopid, (Object) conversation.shopid) || !equals((Object) this.itemid, (Object) conversation.itemid) || !equals((Object) this.buy_count, (Object) conversation.buy_count) || !equals((Object) this.offer_price, (Object) conversation.offer_price) || !equals((Object) this.accept_price, (Object) conversation.accept_price) || !equals((Object) this.offer_status, (Object) conversation.offer_status) || !equals((Object) this.ctime, (Object) conversation.ctime) || !equals((Object) this.mtime, (Object) conversation.mtime) || !equals((Object) this.orderid, (Object) conversation.orderid) || !equals((Object) this.archive, (Object) conversation.archive) || !equals((Object) this.modelid, (Object) conversation.modelid) || !equals((Object) this.pchatid, (Object) conversation.pchatid) || !equals((Object) this.accept_buy_count, (Object) conversation.accept_buy_count) || !equals((Object) this.buyer_clear_time, (Object) conversation.buyer_clear_time) || !equals((Object) this.seller_clear_time, (Object) conversation.seller_clear_time) || !equals((Object) this.buyer_last_read, (Object) conversation.buyer_last_read) || !equals((Object) this.seller_last_read, (Object) conversation.seller_last_read) || !equals((Object) this.last_msgid, (Object) conversation.last_msgid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.chatid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.buyer_userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.seller_userid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num4 = this.buy_count;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l3 = this.offer_price;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.accept_price;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num5 = this.offer_status;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.mtime;
        int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l5 = this.orderid;
        int hashCode12 = (hashCode11 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num8 = this.archive;
        int hashCode13 = (hashCode12 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Long l6 = this.modelid;
        int hashCode14 = (hashCode13 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.pchatid;
        int hashCode15 = (hashCode14 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Integer num9 = this.accept_buy_count;
        int hashCode16 = (hashCode15 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.buyer_clear_time;
        int hashCode17 = (hashCode16 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.seller_clear_time;
        int hashCode18 = (hashCode17 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Long l8 = this.buyer_last_read;
        int hashCode19 = (hashCode18 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.seller_last_read;
        int hashCode20 = (hashCode19 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Long l10 = this.last_msgid;
        if (l10 != null) {
            i2 = l10.hashCode();
        }
        int i3 = hashCode20 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Conversation> {
        public Integer accept_buy_count;
        public Long accept_price;
        public Integer archive;
        public Integer buy_count;
        public Integer buyer_clear_time;
        public Long buyer_last_read;
        public Integer buyer_userid;
        public Long chatid;
        public Integer ctime;
        public Long itemid;
        public Long last_msgid;
        public Long modelid;
        public Integer mtime;
        public Long offer_price;
        public Integer offer_status;
        public Long orderid;
        public Long pchatid;
        public Integer seller_clear_time;
        public Long seller_last_read;
        public Integer seller_userid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(Conversation conversation) {
            super(conversation);
            if (conversation != null) {
                this.chatid = conversation.chatid;
                this.buyer_userid = conversation.buyer_userid;
                this.seller_userid = conversation.seller_userid;
                this.shopid = conversation.shopid;
                this.itemid = conversation.itemid;
                this.buy_count = conversation.buy_count;
                this.offer_price = conversation.offer_price;
                this.accept_price = conversation.accept_price;
                this.offer_status = conversation.offer_status;
                this.ctime = conversation.ctime;
                this.mtime = conversation.mtime;
                this.orderid = conversation.orderid;
                this.archive = conversation.archive;
                this.modelid = conversation.modelid;
                this.pchatid = conversation.pchatid;
                this.accept_buy_count = conversation.accept_buy_count;
                this.buyer_clear_time = conversation.buyer_clear_time;
                this.seller_clear_time = conversation.seller_clear_time;
                this.buyer_last_read = conversation.buyer_last_read;
                this.seller_last_read = conversation.seller_last_read;
                this.last_msgid = conversation.last_msgid;
            }
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

        public Builder buy_count(Integer num) {
            this.buy_count = num;
            return this;
        }

        public Builder offer_price(Long l) {
            this.offer_price = l;
            return this;
        }

        public Builder accept_price(Long l) {
            this.accept_price = l;
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

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder archive(Integer num) {
            this.archive = num;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder pchatid(Long l) {
            this.pchatid = l;
            return this;
        }

        public Builder accept_buy_count(Integer num) {
            this.accept_buy_count = num;
            return this;
        }

        public Builder buyer_clear_time(Integer num) {
            this.buyer_clear_time = num;
            return this;
        }

        public Builder seller_clear_time(Integer num) {
            this.seller_clear_time = num;
            return this;
        }

        public Builder buyer_last_read(Long l) {
            this.buyer_last_read = l;
            return this;
        }

        public Builder seller_last_read(Long l) {
            this.seller_last_read = l;
            return this;
        }

        public Builder last_msgid(Long l) {
            this.last_msgid = l;
            return this;
        }

        public Conversation build() {
            return new Conversation(this);
        }
    }
}
