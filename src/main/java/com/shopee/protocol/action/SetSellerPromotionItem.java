package com.shopee.protocol.action;

import com.shopee.protocol.shop.SellerPromotionItem;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetSellerPromotionItem extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final List<SellerPromotionItem> DEFAULT_ITEM_PROMOTIONS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REPEATED, messageType = SellerPromotionItem.class, tag = 2)
    public final List<SellerPromotionItem> item_promotions;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public SetSellerPromotionItem(String str, List<SellerPromotionItem> list, String str2, String str3) {
        this.requestid = str;
        this.item_promotions = immutableCopyOf(list);
        this.token = str2;
        this.country = str3;
    }

    private SetSellerPromotionItem(Builder builder) {
        this(builder.requestid, builder.item_promotions, builder.token, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetSellerPromotionItem)) {
            return false;
        }
        SetSellerPromotionItem setSellerPromotionItem = (SetSellerPromotionItem) obj;
        if (!equals((Object) this.requestid, (Object) setSellerPromotionItem.requestid) || !equals((List<?>) this.item_promotions, (List<?>) setSellerPromotionItem.item_promotions) || !equals((Object) this.token, (Object) setSellerPromotionItem.token) || !equals((Object) this.country, (Object) setSellerPromotionItem.country)) {
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
        List<SellerPromotionItem> list = this.item_promotions;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.token;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.country;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetSellerPromotionItem> {
        public String country;
        public List<SellerPromotionItem> item_promotions;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(SetSellerPromotionItem setSellerPromotionItem) {
            super(setSellerPromotionItem);
            if (setSellerPromotionItem != null) {
                this.requestid = setSellerPromotionItem.requestid;
                this.item_promotions = SetSellerPromotionItem.copyOf(setSellerPromotionItem.item_promotions);
                this.token = setSellerPromotionItem.token;
                this.country = setSellerPromotionItem.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder item_promotions(List<SellerPromotionItem> list) {
            this.item_promotions = checkForNulls(list);
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public SetSellerPromotionItem build() {
            return new SetSellerPromotionItem(this);
        }
    }
}
