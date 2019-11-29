package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class MakeOffer extends Message {
    public static final Integer DEFAULT_BUY_COUNT = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Boolean DEFAULT_NOTIFY_SELF = false;
    public static final Long DEFAULT_OFFERID = 0L;
    public static final Long DEFAULT_OFFER_PRICE = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TO_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.INT32)
    public final Integer buy_count;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7)
    public final ChatMsg msg;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean notify_self;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.INT64)
    public final Long offer_price;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long offerid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer to_userid;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String token;

    public MakeOffer(String str, Integer num, Long l, Integer num2, Integer num3, Long l2, ChatMsg chatMsg, Long l3, Long l4, String str2, Boolean bool) {
        this.requestid = str;
        this.shopid = num;
        this.itemid = l;
        this.to_userid = num2;
        this.buy_count = num3;
        this.offer_price = l2;
        this.msg = chatMsg;
        this.modelid = l3;
        this.offerid = l4;
        this.token = str2;
        this.notify_self = bool;
    }

    private MakeOffer(Builder builder) {
        this(builder.requestid, builder.shopid, builder.itemid, builder.to_userid, builder.buy_count, builder.offer_price, builder.msg, builder.modelid, builder.offerid, builder.token, builder.notify_self);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MakeOffer)) {
            return false;
        }
        MakeOffer makeOffer = (MakeOffer) obj;
        if (!equals((Object) this.requestid, (Object) makeOffer.requestid) || !equals((Object) this.shopid, (Object) makeOffer.shopid) || !equals((Object) this.itemid, (Object) makeOffer.itemid) || !equals((Object) this.to_userid, (Object) makeOffer.to_userid) || !equals((Object) this.buy_count, (Object) makeOffer.buy_count) || !equals((Object) this.offer_price, (Object) makeOffer.offer_price) || !equals((Object) this.msg, (Object) makeOffer.msg) || !equals((Object) this.modelid, (Object) makeOffer.modelid) || !equals((Object) this.offerid, (Object) makeOffer.offerid) || !equals((Object) this.token, (Object) makeOffer.token) || !equals((Object) this.notify_self, (Object) makeOffer.notify_self)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.to_userid;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.buy_count;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l2 = this.offer_price;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        ChatMsg chatMsg = this.msg;
        int hashCode7 = (hashCode6 + (chatMsg != null ? chatMsg.hashCode() : 0)) * 37;
        Long l3 = this.modelid;
        int hashCode8 = (hashCode7 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.offerid;
        int hashCode9 = (hashCode8 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.notify_self;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MakeOffer> {
        public Integer buy_count;
        public Long itemid;
        public Long modelid;
        public ChatMsg msg;
        public Boolean notify_self;
        public Long offer_price;
        public Long offerid;
        public String requestid;
        public Integer shopid;
        public Integer to_userid;
        public String token;

        public Builder() {
        }

        public Builder(MakeOffer makeOffer) {
            super(makeOffer);
            if (makeOffer != null) {
                this.requestid = makeOffer.requestid;
                this.shopid = makeOffer.shopid;
                this.itemid = makeOffer.itemid;
                this.to_userid = makeOffer.to_userid;
                this.buy_count = makeOffer.buy_count;
                this.offer_price = makeOffer.offer_price;
                this.msg = makeOffer.msg;
                this.modelid = makeOffer.modelid;
                this.offerid = makeOffer.offerid;
                this.token = makeOffer.token;
                this.notify_self = makeOffer.notify_self;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
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

        public Builder to_userid(Integer num) {
            this.to_userid = num;
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

        public Builder msg(ChatMsg chatMsg) {
            this.msg = chatMsg;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder offerid(Long l) {
            this.offerid = l;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder notify_self(Boolean bool) {
            this.notify_self = bool;
            return this;
        }

        public MakeOffer build() {
            checkRequiredFields();
            return new MakeOffer(this);
        }
    }
}
