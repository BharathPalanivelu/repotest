package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSetSellerPromotionItem extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<SellerPromotionItemFailed> DEFAULT_ITEM_PROMOTIONS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = SellerPromotionItemFailed.class, tag = 3)
    public final List<SellerPromotionItemFailed> item_promotions;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSetSellerPromotionItem(String str, Integer num, List<SellerPromotionItemFailed> list) {
        this.requestid = str;
        this.errcode = num;
        this.item_promotions = immutableCopyOf(list);
    }

    private ResponseSetSellerPromotionItem(Builder builder) {
        this(builder.requestid, builder.errcode, builder.item_promotions);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSetSellerPromotionItem)) {
            return false;
        }
        ResponseSetSellerPromotionItem responseSetSellerPromotionItem = (ResponseSetSellerPromotionItem) obj;
        if (!equals((Object) this.requestid, (Object) responseSetSellerPromotionItem.requestid) || !equals((Object) this.errcode, (Object) responseSetSellerPromotionItem.errcode) || !equals((List<?>) this.item_promotions, (List<?>) responseSetSellerPromotionItem.item_promotions)) {
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
        List<SellerPromotionItemFailed> list = this.item_promotions;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseSetSellerPromotionItem> {
        public Integer errcode;
        public List<SellerPromotionItemFailed> item_promotions;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSetSellerPromotionItem responseSetSellerPromotionItem) {
            super(responseSetSellerPromotionItem);
            if (responseSetSellerPromotionItem != null) {
                this.requestid = responseSetSellerPromotionItem.requestid;
                this.errcode = responseSetSellerPromotionItem.errcode;
                this.item_promotions = ResponseSetSellerPromotionItem.copyOf(responseSetSellerPromotionItem.item_promotions);
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

        public Builder item_promotions(List<SellerPromotionItemFailed> list) {
            this.item_promotions = checkForNulls(list);
            return this;
        }

        public ResponseSetSellerPromotionItem build() {
            return new ResponseSetSellerPromotionItem(this);
        }
    }
}
