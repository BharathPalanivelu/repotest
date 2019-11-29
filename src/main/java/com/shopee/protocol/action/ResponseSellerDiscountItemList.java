package com.shopee.protocol.action;

import com.shopee.protocol.shop.SellerPromotionItem;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSellerDiscountItemList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<SellerPromotionItem> DEFAULT_PROMO_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = SellerPromotionItem.class, tag = 3)
    public final List<SellerPromotionItem> promo_items;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSellerDiscountItemList(String str, Integer num, List<SellerPromotionItem> list) {
        this.requestid = str;
        this.errcode = num;
        this.promo_items = immutableCopyOf(list);
    }

    private ResponseSellerDiscountItemList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.promo_items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSellerDiscountItemList)) {
            return false;
        }
        ResponseSellerDiscountItemList responseSellerDiscountItemList = (ResponseSellerDiscountItemList) obj;
        if (!equals((Object) this.requestid, (Object) responseSellerDiscountItemList.requestid) || !equals((Object) this.errcode, (Object) responseSellerDiscountItemList.errcode) || !equals((List<?>) this.promo_items, (List<?>) responseSellerDiscountItemList.promo_items)) {
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
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<SellerPromotionItem> list = this.promo_items;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseSellerDiscountItemList> {
        public Integer errcode;
        public List<SellerPromotionItem> promo_items;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSellerDiscountItemList responseSellerDiscountItemList) {
            super(responseSellerDiscountItemList);
            if (responseSellerDiscountItemList != null) {
                this.requestid = responseSellerDiscountItemList.requestid;
                this.errcode = responseSellerDiscountItemList.errcode;
                this.promo_items = ResponseSellerDiscountItemList.copyOf(responseSellerDiscountItemList.promo_items);
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

        public Builder promo_items(List<SellerPromotionItem> list) {
            this.promo_items = checkForNulls(list);
            return this;
        }

        public ResponseSellerDiscountItemList build() {
            return new ResponseSellerDiscountItemList(this);
        }
    }
}
