package com.shopee.protocol.action;

import com.shopee.protocol.shop.ItemCmt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RateOrder extends Message {
    public static final List<ItemCmt> DEFAULT_COMMENT = Collections.emptyList();
    public static final List<Boolean> DEFAULT_DELETE_ALL_IMAGES = Collections.emptyList();
    public static final Boolean DEFAULT_IS_RATING_REPLY = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemCmt.class, tag = 4)
    public final List<ItemCmt> comment;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.BOOL)
    public final List<Boolean> delete_all_images;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_rating_reply;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;

    public RateOrder(String str, Integer num, Long l, List<ItemCmt> list, String str2, Boolean bool, List<Boolean> list2) {
        this.requestid = str;
        this.shopid = num;
        this.orderid = l;
        this.comment = immutableCopyOf(list);
        this.token = str2;
        this.is_rating_reply = bool;
        this.delete_all_images = immutableCopyOf(list2);
    }

    private RateOrder(Builder builder) {
        this(builder.requestid, builder.shopid, builder.orderid, builder.comment, builder.token, builder.is_rating_reply, builder.delete_all_images);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RateOrder)) {
            return false;
        }
        RateOrder rateOrder = (RateOrder) obj;
        if (!equals((Object) this.requestid, (Object) rateOrder.requestid) || !equals((Object) this.shopid, (Object) rateOrder.shopid) || !equals((Object) this.orderid, (Object) rateOrder.orderid) || !equals((List<?>) this.comment, (List<?>) rateOrder.comment) || !equals((Object) this.token, (Object) rateOrder.token) || !equals((Object) this.is_rating_reply, (Object) rateOrder.is_rating_reply) || !equals((List<?>) this.delete_all_images, (List<?>) rateOrder.delete_all_images)) {
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
        Long l = this.orderid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        List<ItemCmt> list = this.comment;
        int i3 = 1;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.token;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.is_rating_reply;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i4 = (hashCode5 + i2) * 37;
        List<Boolean> list2 = this.delete_all_images;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<RateOrder> {
        public List<ItemCmt> comment;
        public List<Boolean> delete_all_images;
        public Boolean is_rating_reply;
        public Long orderid;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(RateOrder rateOrder) {
            super(rateOrder);
            if (rateOrder != null) {
                this.requestid = rateOrder.requestid;
                this.shopid = rateOrder.shopid;
                this.orderid = rateOrder.orderid;
                this.comment = RateOrder.copyOf(rateOrder.comment);
                this.token = rateOrder.token;
                this.is_rating_reply = rateOrder.is_rating_reply;
                this.delete_all_images = RateOrder.copyOf(rateOrder.delete_all_images);
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

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder comment(List<ItemCmt> list) {
            this.comment = checkForNulls(list);
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder is_rating_reply(Boolean bool) {
            this.is_rating_reply = bool;
            return this;
        }

        public Builder delete_all_images(List<Boolean> list) {
            this.delete_all_images = checkForNulls(list);
            return this;
        }

        public RateOrder build() {
            return new RateOrder(this);
        }
    }
}
