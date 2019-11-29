package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SlashPriceActivityResponse extends Message {
    public static final Long DEFAULT_ACTIVITY_ID = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_CURRENT_PRICE = 0L;
    public static final Boolean DEFAULT_DAILY_LIMIT_REACHED = false;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Integer DEFAULT_EXPIRY_TIME = 0;
    public static final Boolean DEFAULT_HAS_SLASHED = false;
    public static final List<String> DEFAULT_IMAGES = Collections.emptyList();
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_LOWEST_PRICE = 0L;
    public static final Integer DEFAULT_MIN_REMAINING_SLASH = 0;
    public static final Long DEFAULT_MODELID = 0L;
    public static final String DEFAULT_MODEL_NAME = "";
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_NUM_ACTIVE_ACTIVITY = 0;
    public static final Integer DEFAULT_NUM_TOTAL_ACTIVITY = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Long DEFAULT_ORIGINAL_PRICE = 0L;
    public static final Integer DEFAULT_REMAINING_SLASH = 0;
    public static final Integer DEFAULT_SENDER_USERID = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_SLASHED_VALUE = 0L;
    public static final Integer DEFAULT_START_TIME = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long activity_id;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long current_price;
    @ProtoField(tag = 19, type = Message.Datatype.BOOL)
    public final Boolean daily_limit_reached;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer expiry_time;
    @ProtoField(tag = 17, type = Message.Datatype.BOOL)
    public final Boolean has_slashed;
    @ProtoField(label = Message.Label.REPEATED, tag = 15, type = Message.Datatype.STRING)
    public final List<String> images;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long lowest_price;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer min_remaining_slash;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String model_name;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer num_active_activity;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer num_total_activity;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long original_price;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer remaining_slash;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer sender_userid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 18, type = Message.Datatype.INT64)
    public final Long slashed_value;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer start_time;

    public SlashPriceActivityResponse(Long l, Integer num, Long l2, Long l3, Integer num2, Long l4, Long l5, Long l6, Long l7, String str, Integer num3, Integer num4, Integer num5, String str2, List<String> list, Integer num6, Boolean bool, Long l8, Boolean bool2, Integer num7, String str3, Integer num8, Integer num9) {
        this.activity_id = l;
        this.shopid = num;
        this.itemid = l2;
        this.modelid = l3;
        this.sender_userid = num2;
        this.orderid = l4;
        this.original_price = l5;
        this.current_price = l6;
        this.lowest_price = l7;
        this.country = str;
        this.start_time = num3;
        this.end_time = num4;
        this.expiry_time = num5;
        this.name = str2;
        this.images = immutableCopyOf(list);
        this.num_active_activity = num6;
        this.has_slashed = bool;
        this.slashed_value = l8;
        this.daily_limit_reached = bool2;
        this.remaining_slash = num7;
        this.model_name = str3;
        this.num_total_activity = num8;
        this.min_remaining_slash = num9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SlashPriceActivityResponse(com.shopee.protocol.action.SlashPriceActivityResponse.Builder r27) {
        /*
            r26 = this;
            r0 = r27
            r1 = r26
            java.lang.Long r2 = r0.activity_id
            java.lang.Integer r3 = r0.shopid
            java.lang.Long r4 = r0.itemid
            java.lang.Long r5 = r0.modelid
            java.lang.Integer r6 = r0.sender_userid
            java.lang.Long r7 = r0.orderid
            java.lang.Long r8 = r0.original_price
            java.lang.Long r9 = r0.current_price
            java.lang.Long r10 = r0.lowest_price
            java.lang.String r11 = r0.country
            java.lang.Integer r12 = r0.start_time
            java.lang.Integer r13 = r0.end_time
            java.lang.Integer r14 = r0.expiry_time
            java.lang.String r15 = r0.name
            r25 = r1
            java.util.List<java.lang.String> r1 = r0.images
            r16 = r1
            java.lang.Integer r1 = r0.num_active_activity
            r17 = r1
            java.lang.Boolean r1 = r0.has_slashed
            r18 = r1
            java.lang.Long r1 = r0.slashed_value
            r19 = r1
            java.lang.Boolean r1 = r0.daily_limit_reached
            r20 = r1
            java.lang.Integer r1 = r0.remaining_slash
            r21 = r1
            java.lang.String r1 = r0.model_name
            r22 = r1
            java.lang.Integer r1 = r0.num_total_activity
            r23 = r1
            java.lang.Integer r1 = r0.min_remaining_slash
            r24 = r1
            r1 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r26.setBuilder(r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.SlashPriceActivityResponse.<init>(com.shopee.protocol.action.SlashPriceActivityResponse$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceActivityResponse)) {
            return false;
        }
        SlashPriceActivityResponse slashPriceActivityResponse = (SlashPriceActivityResponse) obj;
        if (!equals((Object) this.activity_id, (Object) slashPriceActivityResponse.activity_id) || !equals((Object) this.shopid, (Object) slashPriceActivityResponse.shopid) || !equals((Object) this.itemid, (Object) slashPriceActivityResponse.itemid) || !equals((Object) this.modelid, (Object) slashPriceActivityResponse.modelid) || !equals((Object) this.sender_userid, (Object) slashPriceActivityResponse.sender_userid) || !equals((Object) this.orderid, (Object) slashPriceActivityResponse.orderid) || !equals((Object) this.original_price, (Object) slashPriceActivityResponse.original_price) || !equals((Object) this.current_price, (Object) slashPriceActivityResponse.current_price) || !equals((Object) this.lowest_price, (Object) slashPriceActivityResponse.lowest_price) || !equals((Object) this.country, (Object) slashPriceActivityResponse.country) || !equals((Object) this.start_time, (Object) slashPriceActivityResponse.start_time) || !equals((Object) this.end_time, (Object) slashPriceActivityResponse.end_time) || !equals((Object) this.expiry_time, (Object) slashPriceActivityResponse.expiry_time) || !equals((Object) this.name, (Object) slashPriceActivityResponse.name) || !equals((List<?>) this.images, (List<?>) slashPriceActivityResponse.images) || !equals((Object) this.num_active_activity, (Object) slashPriceActivityResponse.num_active_activity) || !equals((Object) this.has_slashed, (Object) slashPriceActivityResponse.has_slashed) || !equals((Object) this.slashed_value, (Object) slashPriceActivityResponse.slashed_value) || !equals((Object) this.daily_limit_reached, (Object) slashPriceActivityResponse.daily_limit_reached) || !equals((Object) this.remaining_slash, (Object) slashPriceActivityResponse.remaining_slash) || !equals((Object) this.model_name, (Object) slashPriceActivityResponse.model_name) || !equals((Object) this.num_total_activity, (Object) slashPriceActivityResponse.num_total_activity) || !equals((Object) this.min_remaining_slash, (Object) slashPriceActivityResponse.min_remaining_slash)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.activity_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.modelid;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num2 = this.sender_userid;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l4 = this.orderid;
        int hashCode6 = (hashCode5 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.original_price;
        int hashCode7 = (hashCode6 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.current_price;
        int hashCode8 = (hashCode7 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.lowest_price;
        int hashCode9 = (hashCode8 + (l7 != null ? l7.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode10 = (hashCode9 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.start_time;
        int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.end_time;
        int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.expiry_time;
        int hashCode13 = (hashCode12 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.name;
        int hashCode14 = (hashCode13 + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<String> list = this.images;
        int hashCode15 = (hashCode14 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num6 = this.num_active_activity;
        int hashCode16 = (hashCode15 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool = this.has_slashed;
        int hashCode17 = (hashCode16 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l8 = this.slashed_value;
        int hashCode18 = (hashCode17 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Boolean bool2 = this.daily_limit_reached;
        int hashCode19 = (hashCode18 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num7 = this.remaining_slash;
        int hashCode20 = (hashCode19 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str3 = this.model_name;
        int hashCode21 = (hashCode20 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num8 = this.num_total_activity;
        int hashCode22 = (hashCode21 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.min_remaining_slash;
        if (num9 != null) {
            i2 = num9.hashCode();
        }
        int i3 = hashCode22 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceActivityResponse> {
        public Long activity_id;
        public String country;
        public Long current_price;
        public Boolean daily_limit_reached;
        public Integer end_time;
        public Integer expiry_time;
        public Boolean has_slashed;
        public List<String> images;
        public Long itemid;
        public Long lowest_price;
        public Integer min_remaining_slash;
        public String model_name;
        public Long modelid;
        public String name;
        public Integer num_active_activity;
        public Integer num_total_activity;
        public Long orderid;
        public Long original_price;
        public Integer remaining_slash;
        public Integer sender_userid;
        public Integer shopid;
        public Long slashed_value;
        public Integer start_time;

        public Builder() {
        }

        public Builder(SlashPriceActivityResponse slashPriceActivityResponse) {
            super(slashPriceActivityResponse);
            if (slashPriceActivityResponse != null) {
                this.activity_id = slashPriceActivityResponse.activity_id;
                this.shopid = slashPriceActivityResponse.shopid;
                this.itemid = slashPriceActivityResponse.itemid;
                this.modelid = slashPriceActivityResponse.modelid;
                this.sender_userid = slashPriceActivityResponse.sender_userid;
                this.orderid = slashPriceActivityResponse.orderid;
                this.original_price = slashPriceActivityResponse.original_price;
                this.current_price = slashPriceActivityResponse.current_price;
                this.lowest_price = slashPriceActivityResponse.lowest_price;
                this.country = slashPriceActivityResponse.country;
                this.start_time = slashPriceActivityResponse.start_time;
                this.end_time = slashPriceActivityResponse.end_time;
                this.expiry_time = slashPriceActivityResponse.expiry_time;
                this.name = slashPriceActivityResponse.name;
                this.images = SlashPriceActivityResponse.copyOf(slashPriceActivityResponse.images);
                this.num_active_activity = slashPriceActivityResponse.num_active_activity;
                this.has_slashed = slashPriceActivityResponse.has_slashed;
                this.slashed_value = slashPriceActivityResponse.slashed_value;
                this.daily_limit_reached = slashPriceActivityResponse.daily_limit_reached;
                this.remaining_slash = slashPriceActivityResponse.remaining_slash;
                this.model_name = slashPriceActivityResponse.model_name;
                this.num_total_activity = slashPriceActivityResponse.num_total_activity;
                this.min_remaining_slash = slashPriceActivityResponse.min_remaining_slash;
            }
        }

        public Builder activity_id(Long l) {
            this.activity_id = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder sender_userid(Integer num) {
            this.sender_userid = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder original_price(Long l) {
            this.original_price = l;
            return this;
        }

        public Builder current_price(Long l) {
            this.current_price = l;
            return this;
        }

        public Builder lowest_price(Long l) {
            this.lowest_price = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder expiry_time(Integer num) {
            this.expiry_time = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder images(List<String> list) {
            this.images = checkForNulls(list);
            return this;
        }

        public Builder num_active_activity(Integer num) {
            this.num_active_activity = num;
            return this;
        }

        public Builder has_slashed(Boolean bool) {
            this.has_slashed = bool;
            return this;
        }

        public Builder slashed_value(Long l) {
            this.slashed_value = l;
            return this;
        }

        public Builder daily_limit_reached(Boolean bool) {
            this.daily_limit_reached = bool;
            return this;
        }

        public Builder remaining_slash(Integer num) {
            this.remaining_slash = num;
            return this;
        }

        public Builder model_name(String str) {
            this.model_name = str;
            return this;
        }

        public Builder num_total_activity(Integer num) {
            this.num_total_activity = num;
            return this;
        }

        public Builder min_remaining_slash(Integer num) {
            this.min_remaining_slash = num;
            return this;
        }

        public SlashPriceActivityResponse build() {
            return new SlashPriceActivityResponse(this);
        }
    }
}
