package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PromotionInfo extends Message {
    public static final List<Integer> DEFAULT_BANKS = Collections.emptyList();
    public static final List<Integer> DEFAULT_CARRIERS = Collections.emptyList();
    public static final List<Integer> DEFAULT_CATEGORIES = Collections.emptyList();
    public static final Long DEFAULT_COIN_EARN = 0L;
    public static final List<String> DEFAULT_CREDIT_CARD_BINS = Collections.emptyList();
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Long DEFAULT_FIX_VALUE = 0L;
    public static final Boolean DEFAULT_IS_SELLER_ABSORBED = false;
    public static final List<PromotionItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_PERCENTAGE = 0;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final List<Integer> DEFAULT_SHOPIDS = Collections.emptyList();
    public static final String DEFAULT_SUCCESS_SHOW_MESSAGE = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final String DEFAULT_URL = "";
    public static final Long DEFAULT_USED_PRICE = 0L;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 10, type = Message.Datatype.INT32)
    public final List<Integer> banks;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.INT32)
    public final List<Integer> carriers;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> categories;
    @ProtoField(tag = 16, type = Message.Datatype.INT64)
    public final Long coin_earn;
    @ProtoField(label = Message.Label.REPEATED, tag = 15, type = Message.Datatype.STRING)
    public final List<String> credit_card_bins;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long fix_value;
    @ProtoField(tag = 14, type = Message.Datatype.BOOL)
    public final Boolean is_seller_absorbed;
    @ProtoField(label = Message.Label.REPEATED, messageType = PromotionItem.class, tag = 5)
    public final List<PromotionItem> items;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer percentage;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> shopids;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String success_show_message;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String url;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long used_price;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String voucher_code;

    public PromotionInfo(String str, String str2, List<Integer> list, List<Integer> list2, List<PromotionItem> list3, String str3, Long l, Long l2, List<Integer> list4, List<Integer> list5, Integer num, Long l3, String str4, Boolean bool, List<String> list6, Long l4, Integer num2) {
        this.url = str;
        this.description = str2;
        this.categories = immutableCopyOf(list);
        this.shopids = immutableCopyOf(list2);
        this.items = immutableCopyOf(list3);
        this.voucher_code = str3;
        this.promotionid = l;
        this.used_price = l2;
        this.carriers = immutableCopyOf(list4);
        this.banks = immutableCopyOf(list5);
        this.percentage = num;
        this.fix_value = l3;
        this.success_show_message = str4;
        this.is_seller_absorbed = bool;
        this.credit_card_bins = immutableCopyOf(list6);
        this.coin_earn = l4;
        this.type = num2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private PromotionInfo(com.shopee.protocol.shop.PromotionInfo.Builder r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            java.lang.String r2 = r0.url
            java.lang.String r3 = r0.description
            java.util.List<java.lang.Integer> r4 = r0.categories
            java.util.List<java.lang.Integer> r5 = r0.shopids
            java.util.List<com.shopee.protocol.shop.PromotionItem> r6 = r0.items
            java.lang.String r7 = r0.voucher_code
            java.lang.Long r8 = r0.promotionid
            java.lang.Long r9 = r0.used_price
            java.util.List<java.lang.Integer> r10 = r0.carriers
            java.util.List<java.lang.Integer> r11 = r0.banks
            java.lang.Integer r12 = r0.percentage
            java.lang.Long r13 = r0.fix_value
            java.lang.String r14 = r0.success_show_message
            java.lang.Boolean r15 = r0.is_seller_absorbed
            r19 = r1
            java.util.List<java.lang.String> r1 = r0.credit_card_bins
            r16 = r1
            java.lang.Long r1 = r0.coin_earn
            r17 = r1
            java.lang.Integer r1 = r0.type
            r18 = r1
            r1 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r20.setBuilder(r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.PromotionInfo.<init>(com.shopee.protocol.shop.PromotionInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PromotionInfo)) {
            return false;
        }
        PromotionInfo promotionInfo = (PromotionInfo) obj;
        if (!equals((Object) this.url, (Object) promotionInfo.url) || !equals((Object) this.description, (Object) promotionInfo.description) || !equals((List<?>) this.categories, (List<?>) promotionInfo.categories) || !equals((List<?>) this.shopids, (List<?>) promotionInfo.shopids) || !equals((List<?>) this.items, (List<?>) promotionInfo.items) || !equals((Object) this.voucher_code, (Object) promotionInfo.voucher_code) || !equals((Object) this.promotionid, (Object) promotionInfo.promotionid) || !equals((Object) this.used_price, (Object) promotionInfo.used_price) || !equals((List<?>) this.carriers, (List<?>) promotionInfo.carriers) || !equals((List<?>) this.banks, (List<?>) promotionInfo.banks) || !equals((Object) this.percentage, (Object) promotionInfo.percentage) || !equals((Object) this.fix_value, (Object) promotionInfo.fix_value) || !equals((Object) this.success_show_message, (Object) promotionInfo.success_show_message) || !equals((Object) this.is_seller_absorbed, (Object) promotionInfo.is_seller_absorbed) || !equals((List<?>) this.credit_card_bins, (List<?>) promotionInfo.credit_card_bins) || !equals((Object) this.coin_earn, (Object) promotionInfo.coin_earn) || !equals((Object) this.type, (Object) promotionInfo.type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.url;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<Integer> list = this.categories;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<Integer> list2 = this.shopids;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<PromotionItem> list3 = this.items;
        int hashCode5 = (hashCode4 + (list3 != null ? list3.hashCode() : 1)) * 37;
        String str3 = this.voucher_code;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.promotionid;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.used_price;
        int hashCode8 = (hashCode7 + (l2 != null ? l2.hashCode() : 0)) * 37;
        List<Integer> list4 = this.carriers;
        int hashCode9 = (hashCode8 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<Integer> list5 = this.banks;
        int hashCode10 = (hashCode9 + (list5 != null ? list5.hashCode() : 1)) * 37;
        Integer num = this.percentage;
        int hashCode11 = (hashCode10 + (num != null ? num.hashCode() : 0)) * 37;
        Long l3 = this.fix_value;
        int hashCode12 = (hashCode11 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str4 = this.success_show_message;
        int hashCode13 = (hashCode12 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Boolean bool = this.is_seller_absorbed;
        int hashCode14 = (hashCode13 + (bool != null ? bool.hashCode() : 0)) * 37;
        List<String> list6 = this.credit_card_bins;
        if (list6 != null) {
            i3 = list6.hashCode();
        }
        int i4 = (hashCode14 + i3) * 37;
        Long l4 = this.coin_earn;
        int hashCode15 = (i4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num2 = this.type;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i5 = hashCode15 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<PromotionInfo> {
        public List<Integer> banks;
        public List<Integer> carriers;
        public List<Integer> categories;
        public Long coin_earn;
        public List<String> credit_card_bins;
        public String description;
        public Long fix_value;
        public Boolean is_seller_absorbed;
        public List<PromotionItem> items;
        public Integer percentage;
        public Long promotionid;
        public List<Integer> shopids;
        public String success_show_message;
        public Integer type;
        public String url;
        public Long used_price;
        public String voucher_code;

        public Builder() {
        }

        public Builder(PromotionInfo promotionInfo) {
            super(promotionInfo);
            if (promotionInfo != null) {
                this.url = promotionInfo.url;
                this.description = promotionInfo.description;
                this.categories = PromotionInfo.copyOf(promotionInfo.categories);
                this.shopids = PromotionInfo.copyOf(promotionInfo.shopids);
                this.items = PromotionInfo.copyOf(promotionInfo.items);
                this.voucher_code = promotionInfo.voucher_code;
                this.promotionid = promotionInfo.promotionid;
                this.used_price = promotionInfo.used_price;
                this.carriers = PromotionInfo.copyOf(promotionInfo.carriers);
                this.banks = PromotionInfo.copyOf(promotionInfo.banks);
                this.percentage = promotionInfo.percentage;
                this.fix_value = promotionInfo.fix_value;
                this.success_show_message = promotionInfo.success_show_message;
                this.is_seller_absorbed = promotionInfo.is_seller_absorbed;
                this.credit_card_bins = PromotionInfo.copyOf(promotionInfo.credit_card_bins);
                this.coin_earn = promotionInfo.coin_earn;
                this.type = promotionInfo.type;
            }
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder categories(List<Integer> list) {
            this.categories = checkForNulls(list);
            return this;
        }

        public Builder shopids(List<Integer> list) {
            this.shopids = checkForNulls(list);
            return this;
        }

        public Builder items(List<PromotionItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder used_price(Long l) {
            this.used_price = l;
            return this;
        }

        public Builder carriers(List<Integer> list) {
            this.carriers = checkForNulls(list);
            return this;
        }

        public Builder banks(List<Integer> list) {
            this.banks = checkForNulls(list);
            return this;
        }

        public Builder percentage(Integer num) {
            this.percentage = num;
            return this;
        }

        public Builder fix_value(Long l) {
            this.fix_value = l;
            return this;
        }

        public Builder success_show_message(String str) {
            this.success_show_message = str;
            return this;
        }

        public Builder is_seller_absorbed(Boolean bool) {
            this.is_seller_absorbed = bool;
            return this;
        }

        public Builder credit_card_bins(List<String> list) {
            this.credit_card_bins = checkForNulls(list);
            return this;
        }

        public Builder coin_earn(Long l) {
            this.coin_earn = l;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public PromotionInfo build() {
            return new PromotionInfo(this);
        }
    }
}
