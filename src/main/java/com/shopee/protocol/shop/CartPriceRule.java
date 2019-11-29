package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CartPriceRule extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_CTIME = 0L;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Long DEFAULT_END_TIME = 0L;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_MIN_PRICE = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_PERCENTAGE = 0;
    public static final Long DEFAULT_PERCENTAGE_MAX_VALUE = 0L;
    public static final Integer DEFAULT_RULEID = 0;
    public static final Long DEFAULT_START_TIME = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TITLE = "";
    public static final Long DEFAULT_VALUE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long end_time;
    @ProtoField(tag = 14, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long min_price;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer percentage;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long percentage_max_value;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer ruleid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long start_time;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long value;

    public CartPriceRule(Integer num, Long l, String str, Long l2, Long l3, Long l4, Integer num2, Long l5, String str2, Integer num3, Long l6, Long l7, String str3, f fVar, String str4) {
        this.ruleid = num;
        this.min_price = l;
        this.name = str;
        this.start_time = l2;
        this.end_time = l3;
        this.value = l4;
        this.percentage = num2;
        this.percentage_max_value = l5;
        this.country = str2;
        this.status = num3;
        this.ctime = l6;
        this.mtime = l7;
        this.description = str3;
        this.extinfo = fVar;
        this.title = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CartPriceRule(com.shopee.protocol.shop.CartPriceRule.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.Integer r2 = r0.ruleid
            java.lang.Long r3 = r0.min_price
            java.lang.String r4 = r0.name
            java.lang.Long r5 = r0.start_time
            java.lang.Long r6 = r0.end_time
            java.lang.Long r7 = r0.value
            java.lang.Integer r8 = r0.percentage
            java.lang.Long r9 = r0.percentage_max_value
            java.lang.String r10 = r0.country
            java.lang.Integer r11 = r0.status
            java.lang.Long r12 = r0.ctime
            java.lang.Long r13 = r0.mtime
            java.lang.String r14 = r0.description
            e.f r15 = r0.extinfo
            java.lang.String r1 = r0.title
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.CartPriceRule.<init>(com.shopee.protocol.shop.CartPriceRule$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartPriceRule)) {
            return false;
        }
        CartPriceRule cartPriceRule = (CartPriceRule) obj;
        if (!equals((Object) this.ruleid, (Object) cartPriceRule.ruleid) || !equals((Object) this.min_price, (Object) cartPriceRule.min_price) || !equals((Object) this.name, (Object) cartPriceRule.name) || !equals((Object) this.start_time, (Object) cartPriceRule.start_time) || !equals((Object) this.end_time, (Object) cartPriceRule.end_time) || !equals((Object) this.value, (Object) cartPriceRule.value) || !equals((Object) this.percentage, (Object) cartPriceRule.percentage) || !equals((Object) this.percentage_max_value, (Object) cartPriceRule.percentage_max_value) || !equals((Object) this.country, (Object) cartPriceRule.country) || !equals((Object) this.status, (Object) cartPriceRule.status) || !equals((Object) this.ctime, (Object) cartPriceRule.ctime) || !equals((Object) this.mtime, (Object) cartPriceRule.mtime) || !equals((Object) this.description, (Object) cartPriceRule.description) || !equals((Object) this.extinfo, (Object) cartPriceRule.extinfo) || !equals((Object) this.title, (Object) cartPriceRule.title)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.ruleid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.min_price;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l2 = this.start_time;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.end_time;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.value;
        int hashCode6 = (hashCode5 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num2 = this.percentage;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l5 = this.percentage_max_value;
        int hashCode8 = (hashCode7 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l6 = this.ctime;
        int hashCode11 = (hashCode10 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.mtime;
        int hashCode12 = (hashCode11 + (l7 != null ? l7.hashCode() : 0)) * 37;
        String str3 = this.description;
        int hashCode13 = (hashCode12 + (str3 != null ? str3.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode14 = (hashCode13 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str4 = this.title;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode14 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartPriceRule> {
        public String country;
        public Long ctime;
        public String description;
        public Long end_time;
        public f extinfo;
        public Long min_price;
        public Long mtime;
        public String name;
        public Integer percentage;
        public Long percentage_max_value;
        public Integer ruleid;
        public Long start_time;
        public Integer status;
        public String title;
        public Long value;

        public Builder() {
        }

        public Builder(CartPriceRule cartPriceRule) {
            super(cartPriceRule);
            if (cartPriceRule != null) {
                this.ruleid = cartPriceRule.ruleid;
                this.min_price = cartPriceRule.min_price;
                this.name = cartPriceRule.name;
                this.start_time = cartPriceRule.start_time;
                this.end_time = cartPriceRule.end_time;
                this.value = cartPriceRule.value;
                this.percentage = cartPriceRule.percentage;
                this.percentage_max_value = cartPriceRule.percentage_max_value;
                this.country = cartPriceRule.country;
                this.status = cartPriceRule.status;
                this.ctime = cartPriceRule.ctime;
                this.mtime = cartPriceRule.mtime;
                this.description = cartPriceRule.description;
                this.extinfo = cartPriceRule.extinfo;
                this.title = cartPriceRule.title;
            }
        }

        public Builder ruleid(Integer num) {
            this.ruleid = num;
            return this;
        }

        public Builder min_price(Long l) {
            this.min_price = l;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder start_time(Long l) {
            this.start_time = l;
            return this;
        }

        public Builder end_time(Long l) {
            this.end_time = l;
            return this;
        }

        public Builder value(Long l) {
            this.value = l;
            return this;
        }

        public Builder percentage(Integer num) {
            this.percentage = num;
            return this;
        }

        public Builder percentage_max_value(Long l) {
            this.percentage_max_value = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public CartPriceRule build() {
            return new CartPriceRule(this);
        }
    }
}
