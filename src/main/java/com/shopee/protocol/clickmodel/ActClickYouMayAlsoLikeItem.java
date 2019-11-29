package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActClickYouMayAlsoLikeItem extends Message {
    public static final String DEFAULT_FROM = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String from;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long userid;

    public ActClickYouMayAlsoLikeItem(Long l, Long l2, Integer num, String str) {
        this.itemid = l;
        this.userid = l2;
        this.shopid = num;
        this.from = str;
    }

    private ActClickYouMayAlsoLikeItem(Builder builder) {
        this(builder.itemid, builder.userid, builder.shopid, builder.from);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActClickYouMayAlsoLikeItem)) {
            return false;
        }
        ActClickYouMayAlsoLikeItem actClickYouMayAlsoLikeItem = (ActClickYouMayAlsoLikeItem) obj;
        if (!equals((Object) this.itemid, (Object) actClickYouMayAlsoLikeItem.itemid) || !equals((Object) this.userid, (Object) actClickYouMayAlsoLikeItem.userid) || !equals((Object) this.shopid, (Object) actClickYouMayAlsoLikeItem.shopid) || !equals((Object) this.from, (Object) actClickYouMayAlsoLikeItem.from)) {
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
        Long l2 = this.userid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.from;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActClickYouMayAlsoLikeItem> {
        public String from;
        public Long itemid;
        public Integer shopid;
        public Long userid;

        public Builder() {
        }

        public Builder(ActClickYouMayAlsoLikeItem actClickYouMayAlsoLikeItem) {
            super(actClickYouMayAlsoLikeItem);
            if (actClickYouMayAlsoLikeItem != null) {
                this.itemid = actClickYouMayAlsoLikeItem.itemid;
                this.userid = actClickYouMayAlsoLikeItem.userid;
                this.shopid = actClickYouMayAlsoLikeItem.shopid;
                this.from = actClickYouMayAlsoLikeItem.from;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder userid(Long l) {
            this.userid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder from(String str) {
            this.from = str;
            return this;
        }

        public ActClickYouMayAlsoLikeItem build() {
            return new ActClickYouMayAlsoLikeItem(this);
        }
    }
}
