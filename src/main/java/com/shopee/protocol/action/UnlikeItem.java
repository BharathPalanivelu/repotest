package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UnlikeItem extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public UnlikeItem(String str, String str2, Integer num, Long l) {
        this.requestid = str;
        this.token = str2;
        this.shopid = num;
        this.itemid = l;
    }

    private UnlikeItem(Builder builder) {
        this(builder.requestid, builder.token, builder.shopid, builder.itemid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnlikeItem)) {
            return false;
        }
        UnlikeItem unlikeItem = (UnlikeItem) obj;
        if (!equals((Object) this.requestid, (Object) unlikeItem.requestid) || !equals((Object) this.token, (Object) unlikeItem.token) || !equals((Object) this.shopid, (Object) unlikeItem.shopid) || !equals((Object) this.itemid, (Object) unlikeItem.itemid)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.itemid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UnlikeItem> {
        public Long itemid;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(UnlikeItem unlikeItem) {
            super(unlikeItem);
            if (unlikeItem != null) {
                this.requestid = unlikeItem.requestid;
                this.token = unlikeItem.token;
                this.shopid = unlikeItem.shopid;
                this.itemid = unlikeItem.itemid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
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

        public UnlikeItem build() {
            checkRequiredFields();
            return new UnlikeItem(this);
        }
    }
}
