package com.shopee.protocol.action;

import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemModel;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseItemList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<ShopItemId> DEFAULT_IDLIST = Collections.emptyList();
    public static final List<Item> DEFAULT_ITEM = Collections.emptyList();
    public static final List<ItemHashTagInfo> DEFAULT_ITEM_HASHTAG_INFOS = Collections.emptyList();
    public static final List<ItemResponseExtraInfo> DEFAULT_ITEM_RESPONSE_EXTRA_INFOS = Collections.emptyList();
    public static final List<ItemModel> DEFAULT_MODELS = Collections.emptyList();
    public static final Integer DEFAULT_NOMORE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopItemId.class, tag = 6)
    public final List<ShopItemId> idlist;
    @ProtoField(label = Message.Label.REPEATED, messageType = Item.class, tag = 3)
    public final List<Item> item;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemHashTagInfo.class, tag = 4)
    public final List<ItemHashTagInfo> item_hashtag_infos;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemResponseExtraInfo.class, tag = 8)
    public final List<ItemResponseExtraInfo> item_response_extra_infos;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModel.class, tag = 5)
    public final List<ItemModel> models;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer nomore;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseItemList(String str, Integer num, List<Item> list, List<ItemHashTagInfo> list2, List<ItemModel> list3, List<ShopItemId> list4, Integer num2, List<ItemResponseExtraInfo> list5) {
        this.requestid = str;
        this.errcode = num;
        this.item = immutableCopyOf(list);
        this.item_hashtag_infos = immutableCopyOf(list2);
        this.models = immutableCopyOf(list3);
        this.idlist = immutableCopyOf(list4);
        this.nomore = num2;
        this.item_response_extra_infos = immutableCopyOf(list5);
    }

    private ResponseItemList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.item, builder.item_hashtag_infos, builder.models, builder.idlist, builder.nomore, builder.item_response_extra_infos);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseItemList)) {
            return false;
        }
        ResponseItemList responseItemList = (ResponseItemList) obj;
        if (!equals((Object) this.requestid, (Object) responseItemList.requestid) || !equals((Object) this.errcode, (Object) responseItemList.errcode) || !equals((List<?>) this.item, (List<?>) responseItemList.item) || !equals((List<?>) this.item_hashtag_infos, (List<?>) responseItemList.item_hashtag_infos) || !equals((List<?>) this.models, (List<?>) responseItemList.models) || !equals((List<?>) this.idlist, (List<?>) responseItemList.idlist) || !equals((Object) this.nomore, (Object) responseItemList.nomore) || !equals((List<?>) this.item_response_extra_infos, (List<?>) responseItemList.item_response_extra_infos)) {
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
        List<Item> list = this.item;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<ItemHashTagInfo> list2 = this.item_hashtag_infos;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<ItemModel> list3 = this.models;
        int hashCode5 = (hashCode4 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<ShopItemId> list4 = this.idlist;
        int hashCode6 = (hashCode5 + (list4 != null ? list4.hashCode() : 1)) * 37;
        Integer num2 = this.nomore;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i4 = (hashCode6 + i2) * 37;
        List<ItemResponseExtraInfo> list5 = this.item_response_extra_infos;
        if (list5 != null) {
            i3 = list5.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseItemList> {
        public Integer errcode;
        public List<ShopItemId> idlist;
        public List<Item> item;
        public List<ItemHashTagInfo> item_hashtag_infos;
        public List<ItemResponseExtraInfo> item_response_extra_infos;
        public List<ItemModel> models;
        public Integer nomore;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseItemList responseItemList) {
            super(responseItemList);
            if (responseItemList != null) {
                this.requestid = responseItemList.requestid;
                this.errcode = responseItemList.errcode;
                this.item = ResponseItemList.copyOf(responseItemList.item);
                this.item_hashtag_infos = ResponseItemList.copyOf(responseItemList.item_hashtag_infos);
                this.models = ResponseItemList.copyOf(responseItemList.models);
                this.idlist = ResponseItemList.copyOf(responseItemList.idlist);
                this.nomore = responseItemList.nomore;
                this.item_response_extra_infos = ResponseItemList.copyOf(responseItemList.item_response_extra_infos);
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

        public Builder item(List<Item> list) {
            this.item = checkForNulls(list);
            return this;
        }

        public Builder item_hashtag_infos(List<ItemHashTagInfo> list) {
            this.item_hashtag_infos = checkForNulls(list);
            return this;
        }

        public Builder models(List<ItemModel> list) {
            this.models = checkForNulls(list);
            return this;
        }

        public Builder idlist(List<ShopItemId> list) {
            this.idlist = checkForNulls(list);
            return this;
        }

        public Builder nomore(Integer num) {
            this.nomore = num;
            return this;
        }

        public Builder item_response_extra_infos(List<ItemResponseExtraInfo> list) {
            this.item_response_extra_infos = checkForNulls(list);
            return this;
        }

        public ResponseItemList build() {
            checkRequiredFields();
            return new ResponseItemList(this);
        }
    }
}
