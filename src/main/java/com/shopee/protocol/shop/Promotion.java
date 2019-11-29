package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Promotion extends Message {
    public static final String DEFAULT_ACTION_CONTENT = "";
    public static final String DEFAULT_ACTION_TITLE = "";
    public static final Boolean DEFAULT_ACTION_TRIGGER = false;
    public static final Integer DEFAULT_ALLOW_SELLER_PROMOTION = 0;
    public static final String DEFAULT_BANNER = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_CTIME = 0L;
    public static final Integer DEFAULT_CURRENT_USAGE = 0;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Integer DEFAULT_DISCOUNT = 0;
    public static final Integer DEFAULT_DISTRIBUTED_COUNT = 0;
    public static final Long DEFAULT_END_TIME = 0L;
    public static final Integer DEFAULT_LENGTH = 0;
    public static final Long DEFAULT_MAX_VALUE = 0L;
    public static final Long DEFAULT_MIN_PRICE = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_NOTICE_END_TIME = 0L;
    public static final Long DEFAULT_NOTICE_START_TIME = 0L;
    public static final String DEFAULT_PREFIX = "";
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_PUSH_CONTENT = "";
    public static final f DEFAULT_RULE = f.f32736b;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_START_TIME = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Long DEFAULT_STOP_DISPATCH_TIME = 0L;
    public static final Integer DEFAULT_TOTAL_COUNT = 0;
    public static final Integer DEFAULT_TOTAL_USAGE = 0;
    public static final String DEFAULT_URL = "";
    public static final Integer DEFAULT_USAGE_LIMIT = 0;
    public static final Integer DEFAULT_USE_TYPE = 0;
    public static final Long DEFAULT_VALUE = 0L;
    public static final Integer DEFAULT_VOUCHER_MARKET_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 27, type = Message.Datatype.STRING)
    public final String action_content;
    @ProtoField(tag = 29, type = Message.Datatype.STRING)
    public final String action_title;
    @ProtoField(tag = 26, type = Message.Datatype.BOOL)
    public final Boolean action_trigger;
    @ProtoField(tag = 32, type = Message.Datatype.INT32)
    public final Integer allow_seller_promotion;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String banner;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 23, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer current_usage;
    @ProtoField(tag = 25, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer discount;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer distributed_count;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long end_time;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer length;
    @ProtoField(tag = 31, type = Message.Datatype.INT64)
    public final Long max_value;
    @ProtoField(tag = 17, type = Message.Datatype.INT64)
    public final Long min_price;
    @ProtoField(tag = 24, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long notice_end_time;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long notice_start_time;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String prefix;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 30, type = Message.Datatype.STRING)
    public final String push_content;
    @ProtoField(tag = 11, type = Message.Datatype.BYTES)
    public final f rule;
    @ProtoField(tag = 33, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long start_time;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 28, type = Message.Datatype.INT64)
    public final Long stop_dispatch_time;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer total_count;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer total_usage;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String url;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer usage_limit;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer use_type;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long value;
    @ProtoField(tag = 34, type = Message.Datatype.INT32)
    public final Integer voucher_market_type;

    public Promotion(Long l, String str, String str2, Long l2, Long l3, Long l4, Long l5, Integer num, Long l6, String str3, f fVar, String str4, Integer num2, Integer num3, Integer num4, String str5, Long l7, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Long l8, Long l9, String str6, Boolean bool, String str7, Long l10, String str8, String str9, Long l11, Integer num10, Integer num11, Integer num12) {
        this.promotionid = l;
        this.name = str;
        this.url = str2;
        this.start_time = l2;
        this.end_time = l3;
        this.notice_start_time = l4;
        this.notice_end_time = l5;
        this.discount = num;
        this.value = l6;
        this.banner = str3;
        this.rule = fVar;
        this.prefix = str4;
        this.length = num2;
        this.usage_limit = num3;
        this.total_count = num4;
        this.country = str5;
        this.min_price = l7;
        this.status = num5;
        this.distributed_count = num6;
        this.use_type = num7;
        this.total_usage = num8;
        this.current_usage = num9;
        this.ctime = l8;
        this.mtime = l9;
        this.description = str6;
        this.action_trigger = bool;
        this.action_content = str7;
        this.stop_dispatch_time = l10;
        this.action_title = str8;
        this.push_content = str9;
        this.max_value = l11;
        this.allow_seller_promotion = num10;
        this.shopid = num11;
        this.voucher_market_type = num12;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Promotion(com.shopee.protocol.shop.Promotion.Builder r38) {
        /*
            r37 = this;
            r0 = r38
            r1 = r37
            java.lang.Long r2 = r0.promotionid
            java.lang.String r3 = r0.name
            java.lang.String r4 = r0.url
            java.lang.Long r5 = r0.start_time
            java.lang.Long r6 = r0.end_time
            java.lang.Long r7 = r0.notice_start_time
            java.lang.Long r8 = r0.notice_end_time
            java.lang.Integer r9 = r0.discount
            java.lang.Long r10 = r0.value
            java.lang.String r11 = r0.banner
            e.f r12 = r0.rule
            java.lang.String r13 = r0.prefix
            java.lang.Integer r14 = r0.length
            java.lang.Integer r15 = r0.usage_limit
            r36 = r1
            java.lang.Integer r1 = r0.total_count
            r16 = r1
            java.lang.String r1 = r0.country
            r17 = r1
            java.lang.Long r1 = r0.min_price
            r18 = r1
            java.lang.Integer r1 = r0.status
            r19 = r1
            java.lang.Integer r1 = r0.distributed_count
            r20 = r1
            java.lang.Integer r1 = r0.use_type
            r21 = r1
            java.lang.Integer r1 = r0.total_usage
            r22 = r1
            java.lang.Integer r1 = r0.current_usage
            r23 = r1
            java.lang.Long r1 = r0.ctime
            r24 = r1
            java.lang.Long r1 = r0.mtime
            r25 = r1
            java.lang.String r1 = r0.description
            r26 = r1
            java.lang.Boolean r1 = r0.action_trigger
            r27 = r1
            java.lang.String r1 = r0.action_content
            r28 = r1
            java.lang.Long r1 = r0.stop_dispatch_time
            r29 = r1
            java.lang.String r1 = r0.action_title
            r30 = r1
            java.lang.String r1 = r0.push_content
            r31 = r1
            java.lang.Long r1 = r0.max_value
            r32 = r1
            java.lang.Integer r1 = r0.allow_seller_promotion
            r33 = r1
            java.lang.Integer r1 = r0.shopid
            r34 = r1
            java.lang.Integer r1 = r0.voucher_market_type
            r35 = r1
            r1 = r36
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            r37.setBuilder(r38)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.Promotion.<init>(com.shopee.protocol.shop.Promotion$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Promotion)) {
            return false;
        }
        Promotion promotion = (Promotion) obj;
        if (!equals((Object) this.promotionid, (Object) promotion.promotionid) || !equals((Object) this.name, (Object) promotion.name) || !equals((Object) this.url, (Object) promotion.url) || !equals((Object) this.start_time, (Object) promotion.start_time) || !equals((Object) this.end_time, (Object) promotion.end_time) || !equals((Object) this.notice_start_time, (Object) promotion.notice_start_time) || !equals((Object) this.notice_end_time, (Object) promotion.notice_end_time) || !equals((Object) this.discount, (Object) promotion.discount) || !equals((Object) this.value, (Object) promotion.value) || !equals((Object) this.banner, (Object) promotion.banner) || !equals((Object) this.rule, (Object) promotion.rule) || !equals((Object) this.prefix, (Object) promotion.prefix) || !equals((Object) this.length, (Object) promotion.length) || !equals((Object) this.usage_limit, (Object) promotion.usage_limit) || !equals((Object) this.total_count, (Object) promotion.total_count) || !equals((Object) this.country, (Object) promotion.country) || !equals((Object) this.min_price, (Object) promotion.min_price) || !equals((Object) this.status, (Object) promotion.status) || !equals((Object) this.distributed_count, (Object) promotion.distributed_count) || !equals((Object) this.use_type, (Object) promotion.use_type) || !equals((Object) this.total_usage, (Object) promotion.total_usage) || !equals((Object) this.current_usage, (Object) promotion.current_usage) || !equals((Object) this.ctime, (Object) promotion.ctime) || !equals((Object) this.mtime, (Object) promotion.mtime) || !equals((Object) this.description, (Object) promotion.description) || !equals((Object) this.action_trigger, (Object) promotion.action_trigger) || !equals((Object) this.action_content, (Object) promotion.action_content) || !equals((Object) this.stop_dispatch_time, (Object) promotion.stop_dispatch_time) || !equals((Object) this.action_title, (Object) promotion.action_title) || !equals((Object) this.push_content, (Object) promotion.push_content) || !equals((Object) this.max_value, (Object) promotion.max_value) || !equals((Object) this.allow_seller_promotion, (Object) promotion.allow_seller_promotion) || !equals((Object) this.shopid, (Object) promotion.shopid) || !equals((Object) this.voucher_market_type, (Object) promotion.voucher_market_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.promotionid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.url;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.start_time;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.end_time;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.notice_start_time;
        int hashCode6 = (hashCode5 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.notice_end_time;
        int hashCode7 = (hashCode6 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num = this.discount;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        Long l6 = this.value;
        int hashCode9 = (hashCode8 + (l6 != null ? l6.hashCode() : 0)) * 37;
        String str3 = this.banner;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 37;
        f fVar = this.rule;
        int hashCode11 = (hashCode10 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str4 = this.prefix;
        int hashCode12 = (hashCode11 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num2 = this.length;
        int hashCode13 = (hashCode12 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.usage_limit;
        int hashCode14 = (hashCode13 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.total_count;
        int hashCode15 = (hashCode14 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str5 = this.country;
        int hashCode16 = (hashCode15 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l7 = this.min_price;
        int hashCode17 = (hashCode16 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode18 = (hashCode17 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.distributed_count;
        int hashCode19 = (hashCode18 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.use_type;
        int hashCode20 = (hashCode19 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.total_usage;
        int hashCode21 = (hashCode20 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.current_usage;
        int hashCode22 = (hashCode21 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Long l8 = this.ctime;
        int hashCode23 = (hashCode22 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.mtime;
        int hashCode24 = (hashCode23 + (l9 != null ? l9.hashCode() : 0)) * 37;
        String str6 = this.description;
        int hashCode25 = (hashCode24 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Boolean bool = this.action_trigger;
        int hashCode26 = (hashCode25 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str7 = this.action_content;
        int hashCode27 = (hashCode26 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Long l10 = this.stop_dispatch_time;
        int hashCode28 = (hashCode27 + (l10 != null ? l10.hashCode() : 0)) * 37;
        String str8 = this.action_title;
        int hashCode29 = (hashCode28 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.push_content;
        int hashCode30 = (hashCode29 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Long l11 = this.max_value;
        int hashCode31 = (hashCode30 + (l11 != null ? l11.hashCode() : 0)) * 37;
        Integer num10 = this.allow_seller_promotion;
        int hashCode32 = (hashCode31 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.shopid;
        int hashCode33 = (hashCode32 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.voucher_market_type;
        if (num12 != null) {
            i2 = num12.hashCode();
        }
        int i3 = hashCode33 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Promotion> {
        public String action_content;
        public String action_title;
        public Boolean action_trigger;
        public Integer allow_seller_promotion;
        public String banner;
        public String country;
        public Long ctime;
        public Integer current_usage;
        public String description;
        public Integer discount;
        public Integer distributed_count;
        public Long end_time;
        public Integer length;
        public Long max_value;
        public Long min_price;
        public Long mtime;
        public String name;
        public Long notice_end_time;
        public Long notice_start_time;
        public String prefix;
        public Long promotionid;
        public String push_content;
        public f rule;
        public Integer shopid;
        public Long start_time;
        public Integer status;
        public Long stop_dispatch_time;
        public Integer total_count;
        public Integer total_usage;
        public String url;
        public Integer usage_limit;
        public Integer use_type;
        public Long value;
        public Integer voucher_market_type;

        public Builder() {
        }

        public Builder(Promotion promotion) {
            super(promotion);
            if (promotion != null) {
                this.promotionid = promotion.promotionid;
                this.name = promotion.name;
                this.url = promotion.url;
                this.start_time = promotion.start_time;
                this.end_time = promotion.end_time;
                this.notice_start_time = promotion.notice_start_time;
                this.notice_end_time = promotion.notice_end_time;
                this.discount = promotion.discount;
                this.value = promotion.value;
                this.banner = promotion.banner;
                this.rule = promotion.rule;
                this.prefix = promotion.prefix;
                this.length = promotion.length;
                this.usage_limit = promotion.usage_limit;
                this.total_count = promotion.total_count;
                this.country = promotion.country;
                this.min_price = promotion.min_price;
                this.status = promotion.status;
                this.distributed_count = promotion.distributed_count;
                this.use_type = promotion.use_type;
                this.total_usage = promotion.total_usage;
                this.current_usage = promotion.current_usage;
                this.ctime = promotion.ctime;
                this.mtime = promotion.mtime;
                this.description = promotion.description;
                this.action_trigger = promotion.action_trigger;
                this.action_content = promotion.action_content;
                this.stop_dispatch_time = promotion.stop_dispatch_time;
                this.action_title = promotion.action_title;
                this.push_content = promotion.push_content;
                this.max_value = promotion.max_value;
                this.allow_seller_promotion = promotion.allow_seller_promotion;
                this.shopid = promotion.shopid;
                this.voucher_market_type = promotion.voucher_market_type;
            }
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
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

        public Builder notice_start_time(Long l) {
            this.notice_start_time = l;
            return this;
        }

        public Builder notice_end_time(Long l) {
            this.notice_end_time = l;
            return this;
        }

        public Builder discount(Integer num) {
            this.discount = num;
            return this;
        }

        public Builder value(Long l) {
            this.value = l;
            return this;
        }

        public Builder banner(String str) {
            this.banner = str;
            return this;
        }

        public Builder rule(f fVar) {
            this.rule = fVar;
            return this;
        }

        public Builder prefix(String str) {
            this.prefix = str;
            return this;
        }

        public Builder length(Integer num) {
            this.length = num;
            return this;
        }

        public Builder usage_limit(Integer num) {
            this.usage_limit = num;
            return this;
        }

        public Builder total_count(Integer num) {
            this.total_count = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder min_price(Long l) {
            this.min_price = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder distributed_count(Integer num) {
            this.distributed_count = num;
            return this;
        }

        public Builder use_type(Integer num) {
            this.use_type = num;
            return this;
        }

        public Builder total_usage(Integer num) {
            this.total_usage = num;
            return this;
        }

        public Builder current_usage(Integer num) {
            this.current_usage = num;
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

        public Builder action_trigger(Boolean bool) {
            this.action_trigger = bool;
            return this;
        }

        public Builder action_content(String str) {
            this.action_content = str;
            return this;
        }

        public Builder stop_dispatch_time(Long l) {
            this.stop_dispatch_time = l;
            return this;
        }

        public Builder action_title(String str) {
            this.action_title = str;
            return this;
        }

        public Builder push_content(String str) {
            this.push_content = str;
            return this;
        }

        public Builder max_value(Long l) {
            this.max_value = l;
            return this;
        }

        public Builder allow_seller_promotion(Integer num) {
            this.allow_seller_promotion = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder voucher_market_type(Integer num) {
            this.voucher_market_type = num;
            return this;
        }

        public Promotion build() {
            return new Promotion(this);
        }
    }
}
