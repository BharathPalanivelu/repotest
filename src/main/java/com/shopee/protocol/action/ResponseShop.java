package com.shopee.protocol.action;

import com.shopee.protocol.shop.Account;
import com.shopee.protocol.shop.Shop;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseShop extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Boolean DEFAULT_FOLLOWED = false;
    public static final Integer DEFAULT_ITEM_COUNT_FOR_LIMIT = 0;
    public static final Integer DEFAULT_ITEM_LIMIT = 0;
    public static final Integer DEFAULT_MAX_IMAGE_COUNT = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SCORE = 0;
    public static final Integer DEFAULT_TOTAL_ITEM_COUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean followed;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer item_count_for_limit;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer item_limit;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer max_image_count;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer score;
    @ProtoField(tag = 3)
    public final Shop shop;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer total_item_count;
    @ProtoField(tag = 4)
    public final Account user;

    public ResponseShop(String str, Integer num, Shop shop2, Account account, Boolean bool, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.requestid = str;
        this.errcode = num;
        this.shop = shop2;
        this.user = account;
        this.followed = bool;
        this.score = num2;
        this.total_item_count = num3;
        this.item_limit = num4;
        this.item_count_for_limit = num5;
        this.max_image_count = num6;
    }

    private ResponseShop(Builder builder) {
        this(builder.requestid, builder.errcode, builder.shop, builder.user, builder.followed, builder.score, builder.total_item_count, builder.item_limit, builder.item_count_for_limit, builder.max_image_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseShop)) {
            return false;
        }
        ResponseShop responseShop = (ResponseShop) obj;
        if (!equals((Object) this.requestid, (Object) responseShop.requestid) || !equals((Object) this.errcode, (Object) responseShop.errcode) || !equals((Object) this.shop, (Object) responseShop.shop) || !equals((Object) this.user, (Object) responseShop.user) || !equals((Object) this.followed, (Object) responseShop.followed) || !equals((Object) this.score, (Object) responseShop.score) || !equals((Object) this.total_item_count, (Object) responseShop.total_item_count) || !equals((Object) this.item_limit, (Object) responseShop.item_limit) || !equals((Object) this.item_count_for_limit, (Object) responseShop.item_count_for_limit) || !equals((Object) this.max_image_count, (Object) responseShop.max_image_count)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Shop shop2 = this.shop;
        int hashCode3 = (hashCode2 + (shop2 != null ? shop2.hashCode() : 0)) * 37;
        Account account = this.user;
        int hashCode4 = (hashCode3 + (account != null ? account.hashCode() : 0)) * 37;
        Boolean bool = this.followed;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num2 = this.score;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.total_item_count;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.item_limit;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.item_count_for_limit;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.max_image_count;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseShop> {
        public Integer errcode;
        public Boolean followed;
        public Integer item_count_for_limit;
        public Integer item_limit;
        public Integer max_image_count;
        public String requestid;
        public Integer score;
        public Shop shop;
        public Integer total_item_count;
        public Account user;

        public Builder() {
        }

        public Builder(ResponseShop responseShop) {
            super(responseShop);
            if (responseShop != null) {
                this.requestid = responseShop.requestid;
                this.errcode = responseShop.errcode;
                this.shop = responseShop.shop;
                this.user = responseShop.user;
                this.followed = responseShop.followed;
                this.score = responseShop.score;
                this.total_item_count = responseShop.total_item_count;
                this.item_limit = responseShop.item_limit;
                this.item_count_for_limit = responseShop.item_count_for_limit;
                this.max_image_count = responseShop.max_image_count;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder shop(Shop shop2) {
            this.shop = shop2;
            return this;
        }

        public Builder user(Account account) {
            this.user = account;
            return this;
        }

        public Builder followed(Boolean bool) {
            this.followed = bool;
            return this;
        }

        public Builder score(Integer num) {
            this.score = num;
            return this;
        }

        public Builder total_item_count(Integer num) {
            this.total_item_count = num;
            return this;
        }

        public Builder item_limit(Integer num) {
            this.item_limit = num;
            return this;
        }

        public Builder item_count_for_limit(Integer num) {
            this.item_count_for_limit = num;
            return this;
        }

        public Builder max_image_count(Integer num) {
            this.max_image_count = num;
            return this;
        }

        public ResponseShop build() {
            checkRequiredFields();
            return new ResponseShop(this);
        }
    }
}
