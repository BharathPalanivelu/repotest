package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetItemDetail extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Boolean DEFAULT_NEED_COIN_EARN_INFO = false;
    public static final Boolean DEFAULT_NEED_DELETED_ITEMS = false;
    public static final Boolean DEFAULT_NEED_VALIDATE_CAT = false;
    public static final Boolean DEFAULT_NO_NEED_ITEM_INFO = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_RETURN_HASHTAG_LIST = false;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Boolean DEFAULT_SORT_HASHTAG_LIST = false;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean need_coin_earn_info;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean need_deleted_items;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean need_validate_cat;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean no_need_item_info;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean return_hashtag_list;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean sort_hashtag_list;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public GetItemDetail(String str, Long l, Integer num, String str2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6) {
        this.requestid = str;
        this.itemid = l;
        this.shopid = num;
        this.token = str2;
        this.need_deleted_items = bool;
        this.return_hashtag_list = bool2;
        this.sort_hashtag_list = bool3;
        this.need_coin_earn_info = bool4;
        this.no_need_item_info = bool5;
        this.need_validate_cat = bool6;
    }

    private GetItemDetail(Builder builder) {
        this(builder.requestid, builder.itemid, builder.shopid, builder.token, builder.need_deleted_items, builder.return_hashtag_list, builder.sort_hashtag_list, builder.need_coin_earn_info, builder.no_need_item_info, builder.need_validate_cat);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetItemDetail)) {
            return false;
        }
        GetItemDetail getItemDetail = (GetItemDetail) obj;
        if (!equals((Object) this.requestid, (Object) getItemDetail.requestid) || !equals((Object) this.itemid, (Object) getItemDetail.itemid) || !equals((Object) this.shopid, (Object) getItemDetail.shopid) || !equals((Object) this.token, (Object) getItemDetail.token) || !equals((Object) this.need_deleted_items, (Object) getItemDetail.need_deleted_items) || !equals((Object) this.return_hashtag_list, (Object) getItemDetail.return_hashtag_list) || !equals((Object) this.sort_hashtag_list, (Object) getItemDetail.sort_hashtag_list) || !equals((Object) this.need_coin_earn_info, (Object) getItemDetail.need_coin_earn_info) || !equals((Object) this.no_need_item_info, (Object) getItemDetail.no_need_item_info) || !equals((Object) this.need_validate_cat, (Object) getItemDetail.need_validate_cat)) {
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
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.need_deleted_items;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.return_hashtag_list;
        int hashCode6 = (hashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.sort_hashtag_list;
        int hashCode7 = (hashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.need_coin_earn_info;
        int hashCode8 = (hashCode7 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.no_need_item_info;
        int hashCode9 = (hashCode8 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Boolean bool6 = this.need_validate_cat;
        if (bool6 != null) {
            i2 = bool6.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetItemDetail> {
        public Long itemid;
        public Boolean need_coin_earn_info;
        public Boolean need_deleted_items;
        public Boolean need_validate_cat;
        public Boolean no_need_item_info;
        public String requestid;
        public Boolean return_hashtag_list;
        public Integer shopid;
        public Boolean sort_hashtag_list;
        public String token;

        public Builder() {
        }

        public Builder(GetItemDetail getItemDetail) {
            super(getItemDetail);
            if (getItemDetail != null) {
                this.requestid = getItemDetail.requestid;
                this.itemid = getItemDetail.itemid;
                this.shopid = getItemDetail.shopid;
                this.token = getItemDetail.token;
                this.need_deleted_items = getItemDetail.need_deleted_items;
                this.return_hashtag_list = getItemDetail.return_hashtag_list;
                this.sort_hashtag_list = getItemDetail.sort_hashtag_list;
                this.need_coin_earn_info = getItemDetail.need_coin_earn_info;
                this.no_need_item_info = getItemDetail.no_need_item_info;
                this.need_validate_cat = getItemDetail.need_validate_cat;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder need_deleted_items(Boolean bool) {
            this.need_deleted_items = bool;
            return this;
        }

        public Builder return_hashtag_list(Boolean bool) {
            this.return_hashtag_list = bool;
            return this;
        }

        public Builder sort_hashtag_list(Boolean bool) {
            this.sort_hashtag_list = bool;
            return this;
        }

        public Builder need_coin_earn_info(Boolean bool) {
            this.need_coin_earn_info = bool;
            return this;
        }

        public Builder no_need_item_info(Boolean bool) {
            this.no_need_item_info = bool;
            return this;
        }

        public Builder need_validate_cat(Boolean bool) {
            this.need_validate_cat = bool;
            return this;
        }

        public GetItemDetail build() {
            checkRequiredFields();
            return new GetItemDetail(this);
        }
    }
}
