package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CancelOffer extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Boolean DEFAULT_NOTIFY_SELF = false;
    public static final Long DEFAULT_OFFERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5)
    public final ChatMsg msg;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean notify_self;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long offerid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer userid;

    public CancelOffer(String str, Integer num, Long l, Integer num2, ChatMsg chatMsg, Long l2, Long l3, String str2, Boolean bool) {
        this.requestid = str;
        this.shopid = num;
        this.itemid = l;
        this.userid = num2;
        this.msg = chatMsg;
        this.modelid = l2;
        this.offerid = l3;
        this.token = str2;
        this.notify_self = bool;
    }

    private CancelOffer(Builder builder) {
        this(builder.requestid, builder.shopid, builder.itemid, builder.userid, builder.msg, builder.modelid, builder.offerid, builder.token, builder.notify_self);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CancelOffer)) {
            return false;
        }
        CancelOffer cancelOffer = (CancelOffer) obj;
        if (!equals((Object) this.requestid, (Object) cancelOffer.requestid) || !equals((Object) this.shopid, (Object) cancelOffer.shopid) || !equals((Object) this.itemid, (Object) cancelOffer.itemid) || !equals((Object) this.userid, (Object) cancelOffer.userid) || !equals((Object) this.msg, (Object) cancelOffer.msg) || !equals((Object) this.modelid, (Object) cancelOffer.modelid) || !equals((Object) this.offerid, (Object) cancelOffer.offerid) || !equals((Object) this.token, (Object) cancelOffer.token) || !equals((Object) this.notify_self, (Object) cancelOffer.notify_self)) {
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
        Integer num2 = this.userid;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        ChatMsg chatMsg = this.msg;
        int hashCode5 = (hashCode4 + (chatMsg != null ? chatMsg.hashCode() : 0)) * 37;
        Long l2 = this.modelid;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.offerid;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.notify_self;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CancelOffer> {
        public Long itemid;
        public Long modelid;
        public ChatMsg msg;
        public Boolean notify_self;
        public Long offerid;
        public String requestid;
        public Integer shopid;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(CancelOffer cancelOffer) {
            super(cancelOffer);
            if (cancelOffer != null) {
                this.requestid = cancelOffer.requestid;
                this.shopid = cancelOffer.shopid;
                this.itemid = cancelOffer.itemid;
                this.userid = cancelOffer.userid;
                this.msg = cancelOffer.msg;
                this.modelid = cancelOffer.modelid;
                this.offerid = cancelOffer.offerid;
                this.token = cancelOffer.token;
                this.notify_self = cancelOffer.notify_self;
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

        public Builder userid(Integer num) {
            this.userid = num;
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

        public CancelOffer build() {
            checkRequiredFields();
            return new CancelOffer(this);
        }
    }
}
