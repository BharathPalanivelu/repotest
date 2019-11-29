package com.shopee.protocol.action;

import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemModel;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseItem extends Message {
    public static final Integer DEFAULT_CAT_ERR = 0;
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<String> DEFAULT_HASHTAG_LIST = Collections.emptyList();
    public static final Boolean DEFAULT_LIKED = false;
    public static final List<ItemModel> DEFAULT_MODELS = Collections.emptyList();
    public static final String DEFAULT_REASON = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_SNAPSHOTID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer cat_err;
    @ProtoField(tag = 8)
    public final CoinItemInfo coin_info;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.STRING)
    public final List<String> hashtag_list;
    @ProtoField(tag = 3)
    public final Item item;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean liked;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModel.class, tag = 4)
    public final List<ItemModel> models;
    @ProtoField(tag = 10)
    public final ItemPriceInfo price_info;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String reason;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long snapshotid;

    public ResponseItem(String str, Integer num, Item item2, List<ItemModel> list, Boolean bool, Long l, List<String> list2, CoinItemInfo coinItemInfo, String str2, ItemPriceInfo itemPriceInfo, String str3, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.item = item2;
        this.models = immutableCopyOf(list);
        this.liked = bool;
        this.snapshotid = l;
        this.hashtag_list = immutableCopyOf(list2);
        this.coin_info = coinItemInfo;
        this.debug_msg = str2;
        this.price_info = itemPriceInfo;
        this.reason = str3;
        this.cat_err = num2;
    }

    private ResponseItem(Builder builder) {
        this(builder.requestid, builder.errcode, builder.item, builder.models, builder.liked, builder.snapshotid, builder.hashtag_list, builder.coin_info, builder.debug_msg, builder.price_info, builder.reason, builder.cat_err);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseItem)) {
            return false;
        }
        ResponseItem responseItem = (ResponseItem) obj;
        if (!equals((Object) this.requestid, (Object) responseItem.requestid) || !equals((Object) this.errcode, (Object) responseItem.errcode) || !equals((Object) this.item, (Object) responseItem.item) || !equals((List<?>) this.models, (List<?>) responseItem.models) || !equals((Object) this.liked, (Object) responseItem.liked) || !equals((Object) this.snapshotid, (Object) responseItem.snapshotid) || !equals((List<?>) this.hashtag_list, (List<?>) responseItem.hashtag_list) || !equals((Object) this.coin_info, (Object) responseItem.coin_info) || !equals((Object) this.debug_msg, (Object) responseItem.debug_msg) || !equals((Object) this.price_info, (Object) responseItem.price_info) || !equals((Object) this.reason, (Object) responseItem.reason) || !equals((Object) this.cat_err, (Object) responseItem.cat_err)) {
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
        Item item2 = this.item;
        int hashCode3 = (hashCode2 + (item2 != null ? item2.hashCode() : 0)) * 37;
        List<ItemModel> list = this.models;
        int i3 = 1;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.liked;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l = this.snapshotid;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        List<String> list2 = this.hashtag_list;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode6 + i3) * 37;
        CoinItemInfo coinItemInfo = this.coin_info;
        int hashCode7 = (i4 + (coinItemInfo != null ? coinItemInfo.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        ItemPriceInfo itemPriceInfo = this.price_info;
        int hashCode9 = (hashCode8 + (itemPriceInfo != null ? itemPriceInfo.hashCode() : 0)) * 37;
        String str3 = this.reason;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.cat_err;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i5 = hashCode10 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseItem> {
        public Integer cat_err;
        public CoinItemInfo coin_info;
        public String debug_msg;
        public Integer errcode;
        public List<String> hashtag_list;
        public Item item;
        public Boolean liked;
        public List<ItemModel> models;
        public ItemPriceInfo price_info;
        public String reason;
        public String requestid;
        public Long snapshotid;

        public Builder() {
        }

        public Builder(ResponseItem responseItem) {
            super(responseItem);
            if (responseItem != null) {
                this.requestid = responseItem.requestid;
                this.errcode = responseItem.errcode;
                this.item = responseItem.item;
                this.models = ResponseItem.copyOf(responseItem.models);
                this.liked = responseItem.liked;
                this.snapshotid = responseItem.snapshotid;
                this.hashtag_list = ResponseItem.copyOf(responseItem.hashtag_list);
                this.coin_info = responseItem.coin_info;
                this.debug_msg = responseItem.debug_msg;
                this.price_info = responseItem.price_info;
                this.reason = responseItem.reason;
                this.cat_err = responseItem.cat_err;
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

        public Builder item(Item item2) {
            this.item = item2;
            return this;
        }

        public Builder models(List<ItemModel> list) {
            this.models = checkForNulls(list);
            return this;
        }

        public Builder liked(Boolean bool) {
            this.liked = bool;
            return this;
        }

        public Builder snapshotid(Long l) {
            this.snapshotid = l;
            return this;
        }

        public Builder hashtag_list(List<String> list) {
            this.hashtag_list = checkForNulls(list);
            return this;
        }

        public Builder coin_info(CoinItemInfo coinItemInfo) {
            this.coin_info = coinItemInfo;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder price_info(ItemPriceInfo itemPriceInfo) {
            this.price_info = itemPriceInfo;
            return this;
        }

        public Builder reason(String str) {
            this.reason = str;
            return this;
        }

        public Builder cat_err(Integer num) {
            this.cat_err = num;
            return this;
        }

        public ResponseItem build() {
            checkRequiredFields();
            return new ResponseItem(this);
        }
    }
}
