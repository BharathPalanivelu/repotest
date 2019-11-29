package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetChatid extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SELLER_USERID = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer seller_userid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public GetChatid(String str, Integer num, Integer num2, Long l) {
        this.requestid = str;
        this.shopid = num;
        this.seller_userid = num2;
        this.itemid = l;
    }

    private GetChatid(Builder builder) {
        this(builder.requestid, builder.shopid, builder.seller_userid, builder.itemid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetChatid)) {
            return false;
        }
        GetChatid getChatid = (GetChatid) obj;
        if (!equals((Object) this.requestid, (Object) getChatid.requestid) || !equals((Object) this.shopid, (Object) getChatid.shopid) || !equals((Object) this.seller_userid, (Object) getChatid.seller_userid) || !equals((Object) this.itemid, (Object) getChatid.itemid)) {
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
        Integer num2 = this.seller_userid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.itemid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetChatid> {
        public Long itemid;
        public String requestid;
        public Integer seller_userid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(GetChatid getChatid) {
            super(getChatid);
            if (getChatid != null) {
                this.requestid = getChatid.requestid;
                this.shopid = getChatid.shopid;
                this.seller_userid = getChatid.seller_userid;
                this.itemid = getChatid.itemid;
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

        public Builder seller_userid(Integer num) {
            this.seller_userid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public GetChatid build() {
            return new GetChatid(this);
        }
    }
}
