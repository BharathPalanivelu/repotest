package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SearchCondition extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_FILTER_ADULT = 0;
    public static final String DEFAULT_FILTER_ATTRIBUTE = "";
    public static final Integer DEFAULT_FILTER_COD = 0;
    public static final Integer DEFAULT_FILTER_CREDITCARD = 0;
    public static final Integer DEFAULT_FILTER_INCLUDE_SF = 0;
    public static final Integer DEFAULT_FILTER_INSTALLMENT = 0;
    public static final List<Integer> DEFAULT_FILTER_ITEM_CONDITION = Collections.emptyList();
    public static final Integer DEFAULT_FILTER_LPG = 0;
    public static final Integer DEFAULT_FILTER_OFFICIALSHOP = 0;
    public static final String DEFAULT_FILTER_PAYMENT = "";
    public static final Integer DEFAULT_FILTER_PREORDER = 0;
    public static final Long DEFAULT_FILTER_PRICE_MAX = 0L;
    public static final Long DEFAULT_FILTER_PRICE_MIN = 0L;
    public static final Integer DEFAULT_FILTER_SBS = 0;
    public static final String DEFAULT_FILTER_SHIPMENT = "";
    public static final Integer DEFAULT_FILTER_SOLDOUT = 0;
    public static final Boolean DEFAULT_FILTER_USER_VERIFIED = false;
    public static final Integer DEFAULT_FILTER_VIDEO = 0;
    public static final Integer DEFAULT_FILTER_WHOLESALE = 0;
    public static final Integer DEFAULT_FILTER_WITH_DISCOUNT = 0;
    public static final Integer DEFAULT_INCLUDE_BANNED = 0;
    public static final Boolean DEFAULT_IS_ADS = false;
    public static final Boolean DEFAULT_IS_OWNER = false;
    public static final Double DEFAULT_LATITUDE;
    public static final Double DEFAULT_LONGITUDE;
    public static final List<MatchType> DEFAULT_MATCHES = Collections.emptyList();
    public static final Boolean DEFAULT_SKIP_ADS = false;
    public static final Boolean DEFAULT_SKIP_AUTOCORRECT = false;
    public static final Boolean DEFAULT_SKIP_PRICE_ADJUST = false;
    public static final Boolean DEFAULT_SKIP_SHOP_CENSORSHIP = false;
    public static final Boolean DEFAULT_SKIP_SHUFFLE = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer filter_adult;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String filter_attribute;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer filter_cod;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer filter_creditcard;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer filter_include_sf;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer filter_installment;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.INT32)
    public final List<Integer> filter_item_condition;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer filter_lpg;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer filter_officialshop;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String filter_payment;
    @ProtoField(tag = 29, type = Message.Datatype.INT32)
    public final Integer filter_preorder;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long filter_price_max;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long filter_price_min;
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
    public final Integer filter_sbs;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String filter_shipment;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer filter_soldout;
    @ProtoField(tag = 15, type = Message.Datatype.BOOL)
    public final Boolean filter_user_verified;
    @ProtoField(tag = 30, type = Message.Datatype.INT32)
    public final Integer filter_video;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer filter_wholesale;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer filter_with_discount;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer include_banned;
    @ProtoField(tag = 18, type = Message.Datatype.BOOL)
    public final Boolean is_ads;
    @ProtoField(tag = 14, type = Message.Datatype.BOOL)
    public final Boolean is_owner;
    @ProtoField(tag = 1, type = Message.Datatype.DOUBLE)
    public final Double latitude;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double longitude;
    @ProtoField(label = Message.Label.REPEATED, messageType = MatchType.class, tag = 8)
    public final List<MatchType> matches;
    @ProtoField(tag = 28, type = Message.Datatype.BOOL)
    public final Boolean skip_ads;
    @ProtoField(tag = 31, type = Message.Datatype.BOOL)
    public final Boolean skip_autocorrect;
    @ProtoField(tag = 19, type = Message.Datatype.BOOL)
    public final Boolean skip_price_adjust;
    @ProtoField(tag = 32, type = Message.Datatype.BOOL)
    public final Boolean skip_shop_censorship;
    @ProtoField(tag = 25, type = Message.Datatype.BOOL)
    public final Boolean skip_shuffle;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LATITUDE = valueOf;
        DEFAULT_LONGITUDE = valueOf;
    }

    public SearchCondition(Double d2, Double d3, Long l, Long l2, String str, String str2, List<Integer> list, List<MatchType> list2, String str3, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Boolean bool2, Integer num5, String str4, Boolean bool3, Boolean bool4, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Boolean bool5, Integer num11, Integer num12, Boolean bool6, Integer num13, Integer num14, Boolean bool7, Boolean bool8) {
        this.latitude = d2;
        this.longitude = d3;
        this.filter_price_min = l;
        this.filter_price_max = l2;
        this.filter_shipment = str;
        this.filter_payment = str2;
        this.filter_item_condition = immutableCopyOf(list);
        this.matches = immutableCopyOf(list2);
        this.country = str3;
        this.filter_with_discount = num;
        this.filter_include_sf = num2;
        this.filter_soldout = num3;
        this.include_banned = num4;
        this.is_owner = bool;
        this.filter_user_verified = bool2;
        this.filter_adult = num5;
        this.filter_attribute = str4;
        this.is_ads = bool3;
        this.skip_price_adjust = bool4;
        this.filter_wholesale = num6;
        this.filter_officialshop = num7;
        this.filter_cod = num8;
        this.filter_creditcard = num9;
        this.filter_installment = num10;
        this.skip_shuffle = bool5;
        this.filter_lpg = num11;
        this.filter_sbs = num12;
        this.skip_ads = bool6;
        this.filter_preorder = num13;
        this.filter_video = num14;
        this.skip_autocorrect = bool7;
        this.skip_shop_censorship = bool8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SearchCondition(com.shopee.protocol.search.action.SearchCondition.Builder r36) {
        /*
            r35 = this;
            r0 = r36
            r1 = r35
            java.lang.Double r2 = r0.latitude
            java.lang.Double r3 = r0.longitude
            java.lang.Long r4 = r0.filter_price_min
            java.lang.Long r5 = r0.filter_price_max
            java.lang.String r6 = r0.filter_shipment
            java.lang.String r7 = r0.filter_payment
            java.util.List<java.lang.Integer> r8 = r0.filter_item_condition
            java.util.List<com.shopee.protocol.search.action.MatchType> r9 = r0.matches
            java.lang.String r10 = r0.country
            java.lang.Integer r11 = r0.filter_with_discount
            java.lang.Integer r12 = r0.filter_include_sf
            java.lang.Integer r13 = r0.filter_soldout
            java.lang.Integer r14 = r0.include_banned
            java.lang.Boolean r15 = r0.is_owner
            r34 = r1
            java.lang.Boolean r1 = r0.filter_user_verified
            r16 = r1
            java.lang.Integer r1 = r0.filter_adult
            r17 = r1
            java.lang.String r1 = r0.filter_attribute
            r18 = r1
            java.lang.Boolean r1 = r0.is_ads
            r19 = r1
            java.lang.Boolean r1 = r0.skip_price_adjust
            r20 = r1
            java.lang.Integer r1 = r0.filter_wholesale
            r21 = r1
            java.lang.Integer r1 = r0.filter_officialshop
            r22 = r1
            java.lang.Integer r1 = r0.filter_cod
            r23 = r1
            java.lang.Integer r1 = r0.filter_creditcard
            r24 = r1
            java.lang.Integer r1 = r0.filter_installment
            r25 = r1
            java.lang.Boolean r1 = r0.skip_shuffle
            r26 = r1
            java.lang.Integer r1 = r0.filter_lpg
            r27 = r1
            java.lang.Integer r1 = r0.filter_sbs
            r28 = r1
            java.lang.Boolean r1 = r0.skip_ads
            r29 = r1
            java.lang.Integer r1 = r0.filter_preorder
            r30 = r1
            java.lang.Integer r1 = r0.filter_video
            r31 = r1
            java.lang.Boolean r1 = r0.skip_autocorrect
            r32 = r1
            java.lang.Boolean r1 = r0.skip_shop_censorship
            r33 = r1
            r1 = r34
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            r35.setBuilder(r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.search.action.SearchCondition.<init>(com.shopee.protocol.search.action.SearchCondition$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchCondition)) {
            return false;
        }
        SearchCondition searchCondition = (SearchCondition) obj;
        if (!equals((Object) this.latitude, (Object) searchCondition.latitude) || !equals((Object) this.longitude, (Object) searchCondition.longitude) || !equals((Object) this.filter_price_min, (Object) searchCondition.filter_price_min) || !equals((Object) this.filter_price_max, (Object) searchCondition.filter_price_max) || !equals((Object) this.filter_shipment, (Object) searchCondition.filter_shipment) || !equals((Object) this.filter_payment, (Object) searchCondition.filter_payment) || !equals((List<?>) this.filter_item_condition, (List<?>) searchCondition.filter_item_condition) || !equals((List<?>) this.matches, (List<?>) searchCondition.matches) || !equals((Object) this.country, (Object) searchCondition.country) || !equals((Object) this.filter_with_discount, (Object) searchCondition.filter_with_discount) || !equals((Object) this.filter_include_sf, (Object) searchCondition.filter_include_sf) || !equals((Object) this.filter_soldout, (Object) searchCondition.filter_soldout) || !equals((Object) this.include_banned, (Object) searchCondition.include_banned) || !equals((Object) this.is_owner, (Object) searchCondition.is_owner) || !equals((Object) this.filter_user_verified, (Object) searchCondition.filter_user_verified) || !equals((Object) this.filter_adult, (Object) searchCondition.filter_adult) || !equals((Object) this.filter_attribute, (Object) searchCondition.filter_attribute) || !equals((Object) this.is_ads, (Object) searchCondition.is_ads) || !equals((Object) this.skip_price_adjust, (Object) searchCondition.skip_price_adjust) || !equals((Object) this.filter_wholesale, (Object) searchCondition.filter_wholesale) || !equals((Object) this.filter_officialshop, (Object) searchCondition.filter_officialshop) || !equals((Object) this.filter_cod, (Object) searchCondition.filter_cod) || !equals((Object) this.filter_creditcard, (Object) searchCondition.filter_creditcard) || !equals((Object) this.filter_installment, (Object) searchCondition.filter_installment) || !equals((Object) this.skip_shuffle, (Object) searchCondition.skip_shuffle) || !equals((Object) this.filter_lpg, (Object) searchCondition.filter_lpg) || !equals((Object) this.filter_sbs, (Object) searchCondition.filter_sbs) || !equals((Object) this.skip_ads, (Object) searchCondition.skip_ads) || !equals((Object) this.filter_preorder, (Object) searchCondition.filter_preorder) || !equals((Object) this.filter_video, (Object) searchCondition.filter_video) || !equals((Object) this.skip_autocorrect, (Object) searchCondition.skip_autocorrect) || !equals((Object) this.skip_shop_censorship, (Object) searchCondition.skip_shop_censorship)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d2 = this.latitude;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 37;
        Double d3 = this.longitude;
        int hashCode2 = (hashCode + (d3 != null ? d3.hashCode() : 0)) * 37;
        Long l = this.filter_price_min;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.filter_price_max;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.filter_shipment;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.filter_payment;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<Integer> list = this.filter_item_condition;
        int i3 = 1;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 1)) * 37;
        List<MatchType> list2 = this.matches;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode7 + i3) * 37;
        String str3 = this.country;
        int hashCode8 = (i4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.filter_with_discount;
        int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.filter_include_sf;
        int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.filter_soldout;
        int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.include_banned;
        int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool = this.is_owner;
        int hashCode13 = (hashCode12 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.filter_user_verified;
        int hashCode14 = (hashCode13 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num5 = this.filter_adult;
        int hashCode15 = (hashCode14 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str4 = this.filter_attribute;
        int hashCode16 = (hashCode15 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_ads;
        int hashCode17 = (hashCode16 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.skip_price_adjust;
        int hashCode18 = (hashCode17 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Integer num6 = this.filter_wholesale;
        int hashCode19 = (hashCode18 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.filter_officialshop;
        int hashCode20 = (hashCode19 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.filter_cod;
        int hashCode21 = (hashCode20 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.filter_creditcard;
        int hashCode22 = (hashCode21 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.filter_installment;
        int hashCode23 = (hashCode22 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Boolean bool5 = this.skip_shuffle;
        int hashCode24 = (hashCode23 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Integer num11 = this.filter_lpg;
        int hashCode25 = (hashCode24 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.filter_sbs;
        int hashCode26 = (hashCode25 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Boolean bool6 = this.skip_ads;
        int hashCode27 = (hashCode26 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Integer num13 = this.filter_preorder;
        int hashCode28 = (hashCode27 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.filter_video;
        int hashCode29 = (hashCode28 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Boolean bool7 = this.skip_autocorrect;
        int hashCode30 = (hashCode29 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        Boolean bool8 = this.skip_shop_censorship;
        if (bool8 != null) {
            i2 = bool8.hashCode();
        }
        int i5 = hashCode30 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<SearchCondition> {
        public String country;
        public Integer filter_adult;
        public String filter_attribute;
        public Integer filter_cod;
        public Integer filter_creditcard;
        public Integer filter_include_sf;
        public Integer filter_installment;
        public List<Integer> filter_item_condition;
        public Integer filter_lpg;
        public Integer filter_officialshop;
        public String filter_payment;
        public Integer filter_preorder;
        public Long filter_price_max;
        public Long filter_price_min;
        public Integer filter_sbs;
        public String filter_shipment;
        public Integer filter_soldout;
        public Boolean filter_user_verified;
        public Integer filter_video;
        public Integer filter_wholesale;
        public Integer filter_with_discount;
        public Integer include_banned;
        public Boolean is_ads;
        public Boolean is_owner;
        public Double latitude;
        public Double longitude;
        public List<MatchType> matches;
        public Boolean skip_ads;
        public Boolean skip_autocorrect;
        public Boolean skip_price_adjust;
        public Boolean skip_shop_censorship;
        public Boolean skip_shuffle;

        public Builder() {
        }

        public Builder(SearchCondition searchCondition) {
            super(searchCondition);
            if (searchCondition != null) {
                this.latitude = searchCondition.latitude;
                this.longitude = searchCondition.longitude;
                this.filter_price_min = searchCondition.filter_price_min;
                this.filter_price_max = searchCondition.filter_price_max;
                this.filter_shipment = searchCondition.filter_shipment;
                this.filter_payment = searchCondition.filter_payment;
                this.filter_item_condition = SearchCondition.copyOf(searchCondition.filter_item_condition);
                this.matches = SearchCondition.copyOf(searchCondition.matches);
                this.country = searchCondition.country;
                this.filter_with_discount = searchCondition.filter_with_discount;
                this.filter_include_sf = searchCondition.filter_include_sf;
                this.filter_soldout = searchCondition.filter_soldout;
                this.include_banned = searchCondition.include_banned;
                this.is_owner = searchCondition.is_owner;
                this.filter_user_verified = searchCondition.filter_user_verified;
                this.filter_adult = searchCondition.filter_adult;
                this.filter_attribute = searchCondition.filter_attribute;
                this.is_ads = searchCondition.is_ads;
                this.skip_price_adjust = searchCondition.skip_price_adjust;
                this.filter_wholesale = searchCondition.filter_wholesale;
                this.filter_officialshop = searchCondition.filter_officialshop;
                this.filter_cod = searchCondition.filter_cod;
                this.filter_creditcard = searchCondition.filter_creditcard;
                this.filter_installment = searchCondition.filter_installment;
                this.skip_shuffle = searchCondition.skip_shuffle;
                this.filter_lpg = searchCondition.filter_lpg;
                this.filter_sbs = searchCondition.filter_sbs;
                this.skip_ads = searchCondition.skip_ads;
                this.filter_preorder = searchCondition.filter_preorder;
                this.filter_video = searchCondition.filter_video;
                this.skip_autocorrect = searchCondition.skip_autocorrect;
                this.skip_shop_censorship = searchCondition.skip_shop_censorship;
            }
        }

        public Builder latitude(Double d2) {
            this.latitude = d2;
            return this;
        }

        public Builder longitude(Double d2) {
            this.longitude = d2;
            return this;
        }

        public Builder filter_price_min(Long l) {
            this.filter_price_min = l;
            return this;
        }

        public Builder filter_price_max(Long l) {
            this.filter_price_max = l;
            return this;
        }

        public Builder filter_shipment(String str) {
            this.filter_shipment = str;
            return this;
        }

        public Builder filter_payment(String str) {
            this.filter_payment = str;
            return this;
        }

        public Builder filter_item_condition(List<Integer> list) {
            this.filter_item_condition = checkForNulls(list);
            return this;
        }

        public Builder matches(List<MatchType> list) {
            this.matches = checkForNulls(list);
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder filter_with_discount(Integer num) {
            this.filter_with_discount = num;
            return this;
        }

        public Builder filter_include_sf(Integer num) {
            this.filter_include_sf = num;
            return this;
        }

        public Builder filter_soldout(Integer num) {
            this.filter_soldout = num;
            return this;
        }

        public Builder include_banned(Integer num) {
            this.include_banned = num;
            return this;
        }

        public Builder is_owner(Boolean bool) {
            this.is_owner = bool;
            return this;
        }

        public Builder filter_user_verified(Boolean bool) {
            this.filter_user_verified = bool;
            return this;
        }

        public Builder filter_adult(Integer num) {
            this.filter_adult = num;
            return this;
        }

        public Builder filter_attribute(String str) {
            this.filter_attribute = str;
            return this;
        }

        public Builder is_ads(Boolean bool) {
            this.is_ads = bool;
            return this;
        }

        public Builder skip_price_adjust(Boolean bool) {
            this.skip_price_adjust = bool;
            return this;
        }

        public Builder filter_wholesale(Integer num) {
            this.filter_wholesale = num;
            return this;
        }

        public Builder filter_officialshop(Integer num) {
            this.filter_officialshop = num;
            return this;
        }

        public Builder filter_cod(Integer num) {
            this.filter_cod = num;
            return this;
        }

        public Builder filter_creditcard(Integer num) {
            this.filter_creditcard = num;
            return this;
        }

        public Builder filter_installment(Integer num) {
            this.filter_installment = num;
            return this;
        }

        public Builder skip_shuffle(Boolean bool) {
            this.skip_shuffle = bool;
            return this;
        }

        public Builder filter_lpg(Integer num) {
            this.filter_lpg = num;
            return this;
        }

        public Builder filter_sbs(Integer num) {
            this.filter_sbs = num;
            return this;
        }

        public Builder skip_ads(Boolean bool) {
            this.skip_ads = bool;
            return this;
        }

        public Builder filter_preorder(Integer num) {
            this.filter_preorder = num;
            return this;
        }

        public Builder filter_video(Integer num) {
            this.filter_video = num;
            return this;
        }

        public Builder skip_autocorrect(Boolean bool) {
            this.skip_autocorrect = bool;
            return this;
        }

        public Builder skip_shop_censorship(Boolean bool) {
            this.skip_shop_censorship = bool;
            return this;
        }

        public SearchCondition build() {
            return new SearchCondition(this);
        }
    }
}
