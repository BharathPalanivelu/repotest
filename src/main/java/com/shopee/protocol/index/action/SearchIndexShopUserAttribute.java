package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class SearchIndexShopUserAttribute extends Message {
    public static final f DEFAULT_BUYER_ADDRESS = f.f32736b;
    public static final Integer DEFAULT_CB_OPTION = 0;
    public static final Integer DEFAULT_IS_SHIP_FROM_OVERSEA = 0;
    public static final Integer DEFAULT_ITEM_COUNT = 0;
    public static final List<Long> DEFAULT_LABEL_IDS = Collections.emptyList();
    public static final Double DEFAULT_LATITUDE;
    public static final Double DEFAULT_LONGITUDE;
    public static final Boolean DEFAULT_OFFICIAL_SHOP = false;
    public static final Integer DEFAULT_SHOPEE_VERIFIED_FLAG = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_SHOPNAME = "";
    public static final f DEFAULT_SHOP_LOGISTIC_INFO = f.f32736b;
    public static final String DEFAULT_USERNAME = "";
    public static final Integer DEFAULT_VISIBILITY = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f buyer_address;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer cb_option;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer is_ship_from_oversea;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer item_count;
    @ProtoField(label = Message.Label.REPEATED, tag = 14, type = Message.Datatype.INT64)
    public final List<Long> label_ids;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double latitude;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double longitude;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean official_shop;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f shop_logistic_info;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer shopee_verified_flag;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String shopname;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String username;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer visibility;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LATITUDE = valueOf;
        DEFAULT_LONGITUDE = valueOf;
    }

    public SearchIndexShopUserAttribute(Integer num, Integer num2, Double d2, Double d3, String str, String str2, f fVar, f fVar2, Boolean bool, Integer num3, Integer num4, Integer num5, List<Long> list, Integer num6) {
        this.shopid = num;
        this.visibility = num2;
        this.latitude = d2;
        this.longitude = d3;
        this.username = str;
        this.shopname = str2;
        this.buyer_address = fVar;
        this.shop_logistic_info = fVar2;
        this.official_shop = bool;
        this.shopee_verified_flag = num3;
        this.cb_option = num4;
        this.item_count = num5;
        this.label_ids = immutableCopyOf(list);
        this.is_ship_from_oversea = num6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SearchIndexShopUserAttribute(com.shopee.protocol.index.action.SearchIndexShopUserAttribute.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Integer r2 = r0.shopid
            java.lang.Integer r3 = r0.visibility
            java.lang.Double r4 = r0.latitude
            java.lang.Double r5 = r0.longitude
            java.lang.String r6 = r0.username
            java.lang.String r7 = r0.shopname
            e.f r8 = r0.buyer_address
            e.f r9 = r0.shop_logistic_info
            java.lang.Boolean r10 = r0.official_shop
            java.lang.Integer r11 = r0.shopee_verified_flag
            java.lang.Integer r12 = r0.cb_option
            java.lang.Integer r13 = r0.item_count
            java.util.List<java.lang.Long> r14 = r0.label_ids
            java.lang.Integer r15 = r0.is_ship_from_oversea
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.index.action.SearchIndexShopUserAttribute.<init>(com.shopee.protocol.index.action.SearchIndexShopUserAttribute$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndexShopUserAttribute)) {
            return false;
        }
        SearchIndexShopUserAttribute searchIndexShopUserAttribute = (SearchIndexShopUserAttribute) obj;
        if (!equals((Object) this.shopid, (Object) searchIndexShopUserAttribute.shopid) || !equals((Object) this.visibility, (Object) searchIndexShopUserAttribute.visibility) || !equals((Object) this.latitude, (Object) searchIndexShopUserAttribute.latitude) || !equals((Object) this.longitude, (Object) searchIndexShopUserAttribute.longitude) || !equals((Object) this.username, (Object) searchIndexShopUserAttribute.username) || !equals((Object) this.shopname, (Object) searchIndexShopUserAttribute.shopname) || !equals((Object) this.buyer_address, (Object) searchIndexShopUserAttribute.buyer_address) || !equals((Object) this.shop_logistic_info, (Object) searchIndexShopUserAttribute.shop_logistic_info) || !equals((Object) this.official_shop, (Object) searchIndexShopUserAttribute.official_shop) || !equals((Object) this.shopee_verified_flag, (Object) searchIndexShopUserAttribute.shopee_verified_flag) || !equals((Object) this.cb_option, (Object) searchIndexShopUserAttribute.cb_option) || !equals((Object) this.item_count, (Object) searchIndexShopUserAttribute.item_count) || !equals((List<?>) this.label_ids, (List<?>) searchIndexShopUserAttribute.label_ids) || !equals((Object) this.is_ship_from_oversea, (Object) searchIndexShopUserAttribute.is_ship_from_oversea)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.visibility;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Double d2 = this.latitude;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.longitude;
        int hashCode4 = (hashCode3 + (d3 != null ? d3.hashCode() : 0)) * 37;
        String str = this.username;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.shopname;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.buyer_address;
        int hashCode7 = (hashCode6 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.shop_logistic_info;
        int hashCode8 = (hashCode7 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Boolean bool = this.official_shop;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num3 = this.shopee_verified_flag;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.cb_option;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.item_count;
        int hashCode12 = (hashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37;
        List<Long> list = this.label_ids;
        int hashCode13 = (hashCode12 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num6 = this.is_ship_from_oversea;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndexShopUserAttribute> {
        public f buyer_address;
        public Integer cb_option;
        public Integer is_ship_from_oversea;
        public Integer item_count;
        public List<Long> label_ids;
        public Double latitude;
        public Double longitude;
        public Boolean official_shop;
        public f shop_logistic_info;
        public Integer shopee_verified_flag;
        public Integer shopid;
        public String shopname;
        public String username;
        public Integer visibility;

        public Builder() {
        }

        public Builder(SearchIndexShopUserAttribute searchIndexShopUserAttribute) {
            super(searchIndexShopUserAttribute);
            if (searchIndexShopUserAttribute != null) {
                this.shopid = searchIndexShopUserAttribute.shopid;
                this.visibility = searchIndexShopUserAttribute.visibility;
                this.latitude = searchIndexShopUserAttribute.latitude;
                this.longitude = searchIndexShopUserAttribute.longitude;
                this.username = searchIndexShopUserAttribute.username;
                this.shopname = searchIndexShopUserAttribute.shopname;
                this.buyer_address = searchIndexShopUserAttribute.buyer_address;
                this.shop_logistic_info = searchIndexShopUserAttribute.shop_logistic_info;
                this.official_shop = searchIndexShopUserAttribute.official_shop;
                this.shopee_verified_flag = searchIndexShopUserAttribute.shopee_verified_flag;
                this.cb_option = searchIndexShopUserAttribute.cb_option;
                this.item_count = searchIndexShopUserAttribute.item_count;
                this.label_ids = SearchIndexShopUserAttribute.copyOf(searchIndexShopUserAttribute.label_ids);
                this.is_ship_from_oversea = searchIndexShopUserAttribute.is_ship_from_oversea;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder visibility(Integer num) {
            this.visibility = num;
            return this;
        }

        public Builder latitude(Double d2) {
            this.latitude = d2;
            return this;
        }

        public Builder longitude(Double d2) {
            this.longitude = d2;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public Builder shopname(String str) {
            this.shopname = str;
            return this;
        }

        public Builder buyer_address(f fVar) {
            this.buyer_address = fVar;
            return this;
        }

        public Builder shop_logistic_info(f fVar) {
            this.shop_logistic_info = fVar;
            return this;
        }

        public Builder official_shop(Boolean bool) {
            this.official_shop = bool;
            return this;
        }

        public Builder shopee_verified_flag(Integer num) {
            this.shopee_verified_flag = num;
            return this;
        }

        public Builder cb_option(Integer num) {
            this.cb_option = num;
            return this;
        }

        public Builder item_count(Integer num) {
            this.item_count = num;
            return this;
        }

        public Builder label_ids(List<Long> list) {
            this.label_ids = checkForNulls(list);
            return this;
        }

        public Builder is_ship_from_oversea(Integer num) {
            this.is_ship_from_oversea = num;
            return this;
        }

        public SearchIndexShopUserAttribute build() {
            return new SearchIndexShopUserAttribute(this);
        }
    }
}
