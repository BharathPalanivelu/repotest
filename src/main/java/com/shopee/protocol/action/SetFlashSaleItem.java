package com.shopee.protocol.action;

import com.shopee.protocol.shop.SellerPromotionItem;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetFlashSaleItem extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Boolean DEFAULT_NEED_UPDATE_STOCK = false;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final List<SellerPromotionItem> DEFAULT_PROMOTION_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean need_update_stock;
    @ProtoField(label = Message.Label.REPEATED, messageType = SellerPromotionItem.class, tag = 3)
    public final List<SellerPromotionItem> promotion_items;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetFlashSaleItem(String str, Long l, List<SellerPromotionItem> list, Boolean bool, String str2) {
        this.requestid = str;
        this.promotionid = l;
        this.promotion_items = immutableCopyOf(list);
        this.need_update_stock = bool;
        this.country = str2;
    }

    private SetFlashSaleItem(Builder builder) {
        this(builder.requestid, builder.promotionid, builder.promotion_items, builder.need_update_stock, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetFlashSaleItem)) {
            return false;
        }
        SetFlashSaleItem setFlashSaleItem = (SetFlashSaleItem) obj;
        if (!equals((Object) this.requestid, (Object) setFlashSaleItem.requestid) || !equals((Object) this.promotionid, (Object) setFlashSaleItem.promotionid) || !equals((List<?>) this.promotion_items, (List<?>) setFlashSaleItem.promotion_items) || !equals((Object) this.need_update_stock, (Object) setFlashSaleItem.need_update_stock) || !equals((Object) this.country, (Object) setFlashSaleItem.country)) {
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
        Long l = this.promotionid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        List<SellerPromotionItem> list = this.promotion_items;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.need_update_stock;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetFlashSaleItem> {
        public String country;
        public Boolean need_update_stock;
        public List<SellerPromotionItem> promotion_items;
        public Long promotionid;
        public String requestid;

        public Builder() {
        }

        public Builder(SetFlashSaleItem setFlashSaleItem) {
            super(setFlashSaleItem);
            if (setFlashSaleItem != null) {
                this.requestid = setFlashSaleItem.requestid;
                this.promotionid = setFlashSaleItem.promotionid;
                this.promotion_items = SetFlashSaleItem.copyOf(setFlashSaleItem.promotion_items);
                this.need_update_stock = setFlashSaleItem.need_update_stock;
                this.country = setFlashSaleItem.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder promotion_items(List<SellerPromotionItem> list) {
            this.promotion_items = checkForNulls(list);
            return this;
        }

        public Builder need_update_stock(Boolean bool) {
            this.need_update_stock = bool;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public SetFlashSaleItem build() {
            return new SetFlashSaleItem(this);
        }
    }
}
