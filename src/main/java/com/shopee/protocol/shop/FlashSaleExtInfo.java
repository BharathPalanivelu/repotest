package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class FlashSaleExtInfo extends Message {
    public static final String DEFAULT_BANNER = "";
    public static final String DEFAULT_BANNER_URL = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final List<BrandSaleGroup> DEFAULT_GROUPS = Collections.emptyList();
    public static final Boolean DEFAULT_HIDE_PRICE = false;
    public static final List<FlashSaleItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_MAX_DTS = 0;
    public static final Integer DEFAULT_MAX_PERCENT = 0;
    public static final Long DEFAULT_MAX_PRICE = 0L;
    public static final Integer DEFAULT_MIN_PERCENT = 0;
    public static final Long DEFAULT_MIN_PRICE = 0L;
    public static final Integer DEFAULT_MIN_STOCK = 0;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PC_BANNER = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String banner;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String banner_url;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(label = Message.Label.REPEATED, messageType = BrandSaleGroup.class, tag = 14)
    public final List<BrandSaleGroup> groups;
    @ProtoField(tag = 12, type = Message.Datatype.BOOL)
    public final Boolean hide_price;
    @ProtoField(label = Message.Label.REPEATED, messageType = FlashSaleItem.class, tag = 1)
    public final List<FlashSaleItem> items;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer max_DTS;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer max_percent;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long max_price;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer min_percent;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long min_price;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer min_stock;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String pc_banner;

    public FlashSaleExtInfo(List<FlashSaleItem> list, String str, String str2, String str3, Long l, Long l2, Integer num, Integer num2, Integer num3, String str4, String str5, Boolean bool, Integer num4, List<BrandSaleGroup> list2) {
        this.items = immutableCopyOf(list);
        this.name = str;
        this.description = str2;
        this.banner = str3;
        this.min_price = l;
        this.max_price = l2;
        this.min_percent = num;
        this.max_percent = num2;
        this.min_stock = num3;
        this.banner_url = str4;
        this.pc_banner = str5;
        this.hide_price = bool;
        this.max_DTS = num4;
        this.groups = immutableCopyOf(list2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private FlashSaleExtInfo(com.shopee.protocol.shop.FlashSaleExtInfo.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.util.List<com.shopee.protocol.shop.FlashSaleItem> r2 = r0.items
            java.lang.String r3 = r0.name
            java.lang.String r4 = r0.description
            java.lang.String r5 = r0.banner
            java.lang.Long r6 = r0.min_price
            java.lang.Long r7 = r0.max_price
            java.lang.Integer r8 = r0.min_percent
            java.lang.Integer r9 = r0.max_percent
            java.lang.Integer r10 = r0.min_stock
            java.lang.String r11 = r0.banner_url
            java.lang.String r12 = r0.pc_banner
            java.lang.Boolean r13 = r0.hide_price
            java.lang.Integer r14 = r0.max_DTS
            java.util.List<com.shopee.protocol.shop.BrandSaleGroup> r15 = r0.groups
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.FlashSaleExtInfo.<init>(com.shopee.protocol.shop.FlashSaleExtInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlashSaleExtInfo)) {
            return false;
        }
        FlashSaleExtInfo flashSaleExtInfo = (FlashSaleExtInfo) obj;
        if (!equals((List<?>) this.items, (List<?>) flashSaleExtInfo.items) || !equals((Object) this.name, (Object) flashSaleExtInfo.name) || !equals((Object) this.description, (Object) flashSaleExtInfo.description) || !equals((Object) this.banner, (Object) flashSaleExtInfo.banner) || !equals((Object) this.min_price, (Object) flashSaleExtInfo.min_price) || !equals((Object) this.max_price, (Object) flashSaleExtInfo.max_price) || !equals((Object) this.min_percent, (Object) flashSaleExtInfo.min_percent) || !equals((Object) this.max_percent, (Object) flashSaleExtInfo.max_percent) || !equals((Object) this.min_stock, (Object) flashSaleExtInfo.min_stock) || !equals((Object) this.banner_url, (Object) flashSaleExtInfo.banner_url) || !equals((Object) this.pc_banner, (Object) flashSaleExtInfo.pc_banner) || !equals((Object) this.hide_price, (Object) flashSaleExtInfo.hide_price) || !equals((Object) this.max_DTS, (Object) flashSaleExtInfo.max_DTS) || !equals((List<?>) this.groups, (List<?>) flashSaleExtInfo.groups)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<FlashSaleItem> list = this.items;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        String str = this.name;
        int i3 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.banner;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.min_price;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.max_price;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.min_percent;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.max_percent;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.min_stock;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str4 = this.banner_url;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.pc_banner;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Boolean bool = this.hide_price;
        int hashCode12 = (hashCode11 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num4 = this.max_DTS;
        if (num4 != null) {
            i3 = num4.hashCode();
        }
        int i4 = (hashCode12 + i3) * 37;
        List<BrandSaleGroup> list2 = this.groups;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<FlashSaleExtInfo> {
        public String banner;
        public String banner_url;
        public String description;
        public List<BrandSaleGroup> groups;
        public Boolean hide_price;
        public List<FlashSaleItem> items;
        public Integer max_DTS;
        public Integer max_percent;
        public Long max_price;
        public Integer min_percent;
        public Long min_price;
        public Integer min_stock;
        public String name;
        public String pc_banner;

        public Builder() {
        }

        public Builder(FlashSaleExtInfo flashSaleExtInfo) {
            super(flashSaleExtInfo);
            if (flashSaleExtInfo != null) {
                this.items = FlashSaleExtInfo.copyOf(flashSaleExtInfo.items);
                this.name = flashSaleExtInfo.name;
                this.description = flashSaleExtInfo.description;
                this.banner = flashSaleExtInfo.banner;
                this.min_price = flashSaleExtInfo.min_price;
                this.max_price = flashSaleExtInfo.max_price;
                this.min_percent = flashSaleExtInfo.min_percent;
                this.max_percent = flashSaleExtInfo.max_percent;
                this.min_stock = flashSaleExtInfo.min_stock;
                this.banner_url = flashSaleExtInfo.banner_url;
                this.pc_banner = flashSaleExtInfo.pc_banner;
                this.hide_price = flashSaleExtInfo.hide_price;
                this.max_DTS = flashSaleExtInfo.max_DTS;
                this.groups = FlashSaleExtInfo.copyOf(flashSaleExtInfo.groups);
            }
        }

        public Builder items(List<FlashSaleItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder banner(String str) {
            this.banner = str;
            return this;
        }

        public Builder min_price(Long l) {
            this.min_price = l;
            return this;
        }

        public Builder max_price(Long l) {
            this.max_price = l;
            return this;
        }

        public Builder min_percent(Integer num) {
            this.min_percent = num;
            return this;
        }

        public Builder max_percent(Integer num) {
            this.max_percent = num;
            return this;
        }

        public Builder min_stock(Integer num) {
            this.min_stock = num;
            return this;
        }

        public Builder banner_url(String str) {
            this.banner_url = str;
            return this;
        }

        public Builder pc_banner(String str) {
            this.pc_banner = str;
            return this;
        }

        public Builder hide_price(Boolean bool) {
            this.hide_price = bool;
            return this;
        }

        public Builder max_DTS(Integer num) {
            this.max_DTS = num;
            return this;
        }

        public Builder groups(List<BrandSaleGroup> list) {
            this.groups = checkForNulls(list);
            return this;
        }

        public FlashSaleExtInfo build() {
            return new FlashSaleExtInfo(this);
        }
    }
}
