package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TrackingItem extends Message {
    public static final String DEFAULT_ABTEST_SIGN = "";
    public static final Integer DEFAULT_ADD_CART_AMOUNT = 0;
    public static final Long DEFAULT_ADD_CART_PRICE = 0L;
    public static final Long DEFAULT_ADSID = 0L;
    public static final String DEFAULT_ADS_KEYWORD = "";
    public static final String DEFAULT_ALGORITHM = "";
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final String DEFAULT_COMPAIGNID = "";
    public static final String DEFAULT_DEDUCTION_INFO = "";
    public static final Integer DEFAULT_DISCOUNT = 0;
    public static final Boolean DEFAULT_FREE_SHIPPING = false;
    public static final Boolean DEFAULT_IS_PREFERED = false;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_ITEM_MODELID = 0L;
    public static final String DEFAULT_JSON_DATA = "";
    public static final String DEFAULT_LIST_TYPE = "";
    public static final Integer DEFAULT_LOCATION = 0;
    public static final Integer DEFAULT_LOCATION_IN_ADS = 0;
    public static final Integer DEFAULT_MATCH_TYPE = 0;
    public static final Long DEFAULT_MODELID = 0L;
    public static final List<String> DEFAULT_REFER_URLS = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String abtest_sign;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer add_cart_amount;
    @ProtoField(tag = 21, type = Message.Datatype.INT64)
    public final Long add_cart_price;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String ads_keyword;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long adsid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String algorithm;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String compaignid;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String deduction_info;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer discount;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean free_shipping;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_prefered;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long item_modelid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String json_data;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String list_type;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer location;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer location_in_ads;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer match_type;
    @ProtoField(tag = 22, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 9)
    public final TrackingQuery query;
    @ProtoField(label = Message.Label.REPEATED, tag = 10, type = Message.Datatype.STRING)
    public final List<String> refer_urls;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public TrackingItem(Long l, Integer num, Integer num2, Boolean bool, Boolean bool2, String str, String str2, Integer num3, TrackingQuery trackingQuery, List<String> list, Long l2, String str3, Long l3, Integer num4, Long l4, String str4, Integer num5, String str5, String str6, Integer num6, Long l5, Long l6, String str7) {
        this.itemid = l;
        this.shopid = num;
        this.discount = num2;
        this.free_shipping = bool;
        this.is_prefered = bool2;
        this.algorithm = str;
        this.compaignid = str2;
        this.location = num3;
        this.query = trackingQuery;
        this.refer_urls = immutableCopyOf(list);
        this.item_modelid = l2;
        this.list_type = str3;
        this.adsid = l3;
        this.location_in_ads = num4;
        this.campaignid = l4;
        this.ads_keyword = str4;
        this.match_type = num5;
        this.deduction_info = str5;
        this.abtest_sign = str6;
        this.add_cart_amount = num6;
        this.add_cart_price = l5;
        this.modelid = l6;
        this.json_data = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TrackingItem(com.shopee.protocol.ads.action.TrackingItem.Builder r27) {
        /*
            r26 = this;
            r0 = r27
            r1 = r26
            java.lang.Long r2 = r0.itemid
            java.lang.Integer r3 = r0.shopid
            java.lang.Integer r4 = r0.discount
            java.lang.Boolean r5 = r0.free_shipping
            java.lang.Boolean r6 = r0.is_prefered
            java.lang.String r7 = r0.algorithm
            java.lang.String r8 = r0.compaignid
            java.lang.Integer r9 = r0.location
            com.shopee.protocol.ads.action.TrackingQuery r10 = r0.query
            java.util.List<java.lang.String> r11 = r0.refer_urls
            java.lang.Long r12 = r0.item_modelid
            java.lang.String r13 = r0.list_type
            java.lang.Long r14 = r0.adsid
            java.lang.Integer r15 = r0.location_in_ads
            r25 = r1
            java.lang.Long r1 = r0.campaignid
            r16 = r1
            java.lang.String r1 = r0.ads_keyword
            r17 = r1
            java.lang.Integer r1 = r0.match_type
            r18 = r1
            java.lang.String r1 = r0.deduction_info
            r19 = r1
            java.lang.String r1 = r0.abtest_sign
            r20 = r1
            java.lang.Integer r1 = r0.add_cart_amount
            r21 = r1
            java.lang.Long r1 = r0.add_cart_price
            r22 = r1
            java.lang.Long r1 = r0.modelid
            r23 = r1
            java.lang.String r1 = r0.json_data
            r24 = r1
            r1 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r26.setBuilder(r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.ads.action.TrackingItem.<init>(com.shopee.protocol.ads.action.TrackingItem$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingItem)) {
            return false;
        }
        TrackingItem trackingItem = (TrackingItem) obj;
        if (!equals((Object) this.itemid, (Object) trackingItem.itemid) || !equals((Object) this.shopid, (Object) trackingItem.shopid) || !equals((Object) this.discount, (Object) trackingItem.discount) || !equals((Object) this.free_shipping, (Object) trackingItem.free_shipping) || !equals((Object) this.is_prefered, (Object) trackingItem.is_prefered) || !equals((Object) this.algorithm, (Object) trackingItem.algorithm) || !equals((Object) this.compaignid, (Object) trackingItem.compaignid) || !equals((Object) this.location, (Object) trackingItem.location) || !equals((Object) this.query, (Object) trackingItem.query) || !equals((List<?>) this.refer_urls, (List<?>) trackingItem.refer_urls) || !equals((Object) this.item_modelid, (Object) trackingItem.item_modelid) || !equals((Object) this.list_type, (Object) trackingItem.list_type) || !equals((Object) this.adsid, (Object) trackingItem.adsid) || !equals((Object) this.location_in_ads, (Object) trackingItem.location_in_ads) || !equals((Object) this.campaignid, (Object) trackingItem.campaignid) || !equals((Object) this.ads_keyword, (Object) trackingItem.ads_keyword) || !equals((Object) this.match_type, (Object) trackingItem.match_type) || !equals((Object) this.deduction_info, (Object) trackingItem.deduction_info) || !equals((Object) this.abtest_sign, (Object) trackingItem.abtest_sign) || !equals((Object) this.add_cart_amount, (Object) trackingItem.add_cart_amount) || !equals((Object) this.add_cart_price, (Object) trackingItem.add_cart_price) || !equals((Object) this.modelid, (Object) trackingItem.modelid) || !equals((Object) this.json_data, (Object) trackingItem.json_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.discount;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.free_shipping;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_prefered;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str = this.algorithm;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.compaignid;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.location;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        TrackingQuery trackingQuery = this.query;
        int hashCode9 = (hashCode8 + (trackingQuery != null ? trackingQuery.hashCode() : 0)) * 37;
        List<String> list = this.refer_urls;
        int hashCode10 = (hashCode9 + (list != null ? list.hashCode() : 1)) * 37;
        Long l2 = this.item_modelid;
        int hashCode11 = (hashCode10 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str3 = this.list_type;
        int hashCode12 = (hashCode11 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l3 = this.adsid;
        int hashCode13 = (hashCode12 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num4 = this.location_in_ads;
        int hashCode14 = (hashCode13 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l4 = this.campaignid;
        int hashCode15 = (hashCode14 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str4 = this.ads_keyword;
        int hashCode16 = (hashCode15 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num5 = this.match_type;
        int hashCode17 = (hashCode16 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str5 = this.deduction_info;
        int hashCode18 = (hashCode17 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.abtest_sign;
        int hashCode19 = (hashCode18 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num6 = this.add_cart_amount;
        int hashCode20 = (hashCode19 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l5 = this.add_cart_price;
        int hashCode21 = (hashCode20 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.modelid;
        int hashCode22 = (hashCode21 + (l6 != null ? l6.hashCode() : 0)) * 37;
        String str7 = this.json_data;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        int i3 = hashCode22 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingItem> {
        public String abtest_sign;
        public Integer add_cart_amount;
        public Long add_cart_price;
        public String ads_keyword;
        public Long adsid;
        public String algorithm;
        public Long campaignid;
        public String compaignid;
        public String deduction_info;
        public Integer discount;
        public Boolean free_shipping;
        public Boolean is_prefered;
        public Long item_modelid;
        public Long itemid;
        public String json_data;
        public String list_type;
        public Integer location;
        public Integer location_in_ads;
        public Integer match_type;
        public Long modelid;
        public TrackingQuery query;
        public List<String> refer_urls;
        public Integer shopid;

        public Builder() {
        }

        public Builder(TrackingItem trackingItem) {
            super(trackingItem);
            if (trackingItem != null) {
                this.itemid = trackingItem.itemid;
                this.shopid = trackingItem.shopid;
                this.discount = trackingItem.discount;
                this.free_shipping = trackingItem.free_shipping;
                this.is_prefered = trackingItem.is_prefered;
                this.algorithm = trackingItem.algorithm;
                this.compaignid = trackingItem.compaignid;
                this.location = trackingItem.location;
                this.query = trackingItem.query;
                this.refer_urls = TrackingItem.copyOf(trackingItem.refer_urls);
                this.item_modelid = trackingItem.item_modelid;
                this.list_type = trackingItem.list_type;
                this.adsid = trackingItem.adsid;
                this.location_in_ads = trackingItem.location_in_ads;
                this.campaignid = trackingItem.campaignid;
                this.ads_keyword = trackingItem.ads_keyword;
                this.match_type = trackingItem.match_type;
                this.deduction_info = trackingItem.deduction_info;
                this.abtest_sign = trackingItem.abtest_sign;
                this.add_cart_amount = trackingItem.add_cart_amount;
                this.add_cart_price = trackingItem.add_cart_price;
                this.modelid = trackingItem.modelid;
                this.json_data = trackingItem.json_data;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder discount(Integer num) {
            this.discount = num;
            return this;
        }

        public Builder free_shipping(Boolean bool) {
            this.free_shipping = bool;
            return this;
        }

        public Builder is_prefered(Boolean bool) {
            this.is_prefered = bool;
            return this;
        }

        public Builder algorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public Builder compaignid(String str) {
            this.compaignid = str;
            return this;
        }

        public Builder location(Integer num) {
            this.location = num;
            return this;
        }

        public Builder query(TrackingQuery trackingQuery) {
            this.query = trackingQuery;
            return this;
        }

        public Builder refer_urls(List<String> list) {
            this.refer_urls = checkForNulls(list);
            return this;
        }

        public Builder item_modelid(Long l) {
            this.item_modelid = l;
            return this;
        }

        public Builder list_type(String str) {
            this.list_type = str;
            return this;
        }

        public Builder adsid(Long l) {
            this.adsid = l;
            return this;
        }

        public Builder location_in_ads(Integer num) {
            this.location_in_ads = num;
            return this;
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder ads_keyword(String str) {
            this.ads_keyword = str;
            return this;
        }

        public Builder match_type(Integer num) {
            this.match_type = num;
            return this;
        }

        public Builder deduction_info(String str) {
            this.deduction_info = str;
            return this;
        }

        public Builder abtest_sign(String str) {
            this.abtest_sign = str;
            return this;
        }

        public Builder add_cart_amount(Integer num) {
            this.add_cart_amount = num;
            return this;
        }

        public Builder add_cart_price(Long l) {
            this.add_cart_price = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder json_data(String str) {
            this.json_data = str;
            return this;
        }

        public TrackingItem build() {
            return new TrackingItem(this);
        }
    }
}
