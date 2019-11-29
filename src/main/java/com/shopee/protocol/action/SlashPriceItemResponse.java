package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SlashPriceItemResponse extends Message {
    public static final Integer DEFAULT_DUPLICATE_PLAYER_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_DUPLICATE_PLAYER_MIN_SLASH_OFF = 0;
    public static final Boolean DEFAULT_ENABLE_DUPLICATE_PLAYER = false;
    public static final Integer DEFAULT_EXISTING_PLAYER_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_EXISTING_PLAYER_MIN_SLASH_OFF = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_LOWEST_PRICE = 0L;
    public static final List<SlashPriceItemModelResponse> DEFAULT_MODELS = Collections.emptyList();
    public static final Integer DEFAULT_NEW_PLAYER_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_NEW_PLAYER_MIN_SLASH_OFF = 0;
    public static final Integer DEFAULT_NUM_ACTIVE_ACTIVITY = 0;
    public static final Integer DEFAULT_NUM_TOTAL_ACTIVITY = 0;
    public static final String DEFAULT_OPERATOR = "";
    public static final Integer DEFAULT_SELF_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_SELF_MIN_SLASH_OFF = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer duplicate_player_max_slash_off;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer duplicate_player_min_slash_off;
    @ProtoField(tag = 17, type = Message.Datatype.BOOL)
    public final Boolean enable_duplicate_player;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer existing_player_max_slash_off;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer existing_player_min_slash_off;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long lowest_price;
    @ProtoField(label = Message.Label.REPEATED, messageType = SlashPriceItemModelResponse.class, tag = 11)
    public final List<SlashPriceItemModelResponse> models;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer new_player_max_slash_off;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer new_player_min_slash_off;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer num_active_activity;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer num_total_activity;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer self_max_slash_off;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer self_min_slash_off;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;

    public SlashPriceItemResponse(Integer num, Long l, Long l2, Integer num2, String str, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, List<SlashPriceItemModelResponse> list, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Boolean bool) {
        this.shopid = num;
        this.itemid = l;
        this.lowest_price = l2;
        this.status = num2;
        this.operator = str;
        this.new_player_max_slash_off = num3;
        this.new_player_min_slash_off = num4;
        this.existing_player_max_slash_off = num5;
        this.existing_player_min_slash_off = num6;
        this.num_active_activity = num7;
        this.models = immutableCopyOf(list);
        this.num_total_activity = num8;
        this.self_max_slash_off = num9;
        this.self_min_slash_off = num10;
        this.duplicate_player_max_slash_off = num11;
        this.duplicate_player_min_slash_off = num12;
        this.enable_duplicate_player = bool;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SlashPriceItemResponse(com.shopee.protocol.action.SlashPriceItemResponse.Builder r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            java.lang.Integer r2 = r0.shopid
            java.lang.Long r3 = r0.itemid
            java.lang.Long r4 = r0.lowest_price
            java.lang.Integer r5 = r0.status
            java.lang.String r6 = r0.operator
            java.lang.Integer r7 = r0.new_player_max_slash_off
            java.lang.Integer r8 = r0.new_player_min_slash_off
            java.lang.Integer r9 = r0.existing_player_max_slash_off
            java.lang.Integer r10 = r0.existing_player_min_slash_off
            java.lang.Integer r11 = r0.num_active_activity
            java.util.List<com.shopee.protocol.action.SlashPriceItemModelResponse> r12 = r0.models
            java.lang.Integer r13 = r0.num_total_activity
            java.lang.Integer r14 = r0.self_max_slash_off
            java.lang.Integer r15 = r0.self_min_slash_off
            r19 = r1
            java.lang.Integer r1 = r0.duplicate_player_max_slash_off
            r16 = r1
            java.lang.Integer r1 = r0.duplicate_player_min_slash_off
            r17 = r1
            java.lang.Boolean r1 = r0.enable_duplicate_player
            r18 = r1
            r1 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r20.setBuilder(r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.SlashPriceItemResponse.<init>(com.shopee.protocol.action.SlashPriceItemResponse$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceItemResponse)) {
            return false;
        }
        SlashPriceItemResponse slashPriceItemResponse = (SlashPriceItemResponse) obj;
        if (!equals((Object) this.shopid, (Object) slashPriceItemResponse.shopid) || !equals((Object) this.itemid, (Object) slashPriceItemResponse.itemid) || !equals((Object) this.lowest_price, (Object) slashPriceItemResponse.lowest_price) || !equals((Object) this.status, (Object) slashPriceItemResponse.status) || !equals((Object) this.operator, (Object) slashPriceItemResponse.operator) || !equals((Object) this.new_player_max_slash_off, (Object) slashPriceItemResponse.new_player_max_slash_off) || !equals((Object) this.new_player_min_slash_off, (Object) slashPriceItemResponse.new_player_min_slash_off) || !equals((Object) this.existing_player_max_slash_off, (Object) slashPriceItemResponse.existing_player_max_slash_off) || !equals((Object) this.existing_player_min_slash_off, (Object) slashPriceItemResponse.existing_player_min_slash_off) || !equals((Object) this.num_active_activity, (Object) slashPriceItemResponse.num_active_activity) || !equals((List<?>) this.models, (List<?>) slashPriceItemResponse.models) || !equals((Object) this.num_total_activity, (Object) slashPriceItemResponse.num_total_activity) || !equals((Object) this.self_max_slash_off, (Object) slashPriceItemResponse.self_max_slash_off) || !equals((Object) this.self_min_slash_off, (Object) slashPriceItemResponse.self_min_slash_off) || !equals((Object) this.duplicate_player_max_slash_off, (Object) slashPriceItemResponse.duplicate_player_max_slash_off) || !equals((Object) this.duplicate_player_min_slash_off, (Object) slashPriceItemResponse.duplicate_player_min_slash_off) || !equals((Object) this.enable_duplicate_player, (Object) slashPriceItemResponse.enable_duplicate_player)) {
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
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.lowest_price;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.operator;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.new_player_max_slash_off;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.new_player_min_slash_off;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.existing_player_max_slash_off;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.existing_player_min_slash_off;
        int hashCode9 = (hashCode8 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.num_active_activity;
        int hashCode10 = (hashCode9 + (num7 != null ? num7.hashCode() : 0)) * 37;
        List<SlashPriceItemModelResponse> list = this.models;
        int hashCode11 = (hashCode10 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num8 = this.num_total_activity;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.self_max_slash_off;
        int hashCode13 = (hashCode12 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.self_min_slash_off;
        int hashCode14 = (hashCode13 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.duplicate_player_max_slash_off;
        int hashCode15 = (hashCode14 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.duplicate_player_min_slash_off;
        int hashCode16 = (hashCode15 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Boolean bool = this.enable_duplicate_player;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode16 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceItemResponse> {
        public Integer duplicate_player_max_slash_off;
        public Integer duplicate_player_min_slash_off;
        public Boolean enable_duplicate_player;
        public Integer existing_player_max_slash_off;
        public Integer existing_player_min_slash_off;
        public Long itemid;
        public Long lowest_price;
        public List<SlashPriceItemModelResponse> models;
        public Integer new_player_max_slash_off;
        public Integer new_player_min_slash_off;
        public Integer num_active_activity;
        public Integer num_total_activity;
        public String operator;
        public Integer self_max_slash_off;
        public Integer self_min_slash_off;
        public Integer shopid;
        public Integer status;

        public Builder() {
        }

        public Builder(SlashPriceItemResponse slashPriceItemResponse) {
            super(slashPriceItemResponse);
            if (slashPriceItemResponse != null) {
                this.shopid = slashPriceItemResponse.shopid;
                this.itemid = slashPriceItemResponse.itemid;
                this.lowest_price = slashPriceItemResponse.lowest_price;
                this.status = slashPriceItemResponse.status;
                this.operator = slashPriceItemResponse.operator;
                this.new_player_max_slash_off = slashPriceItemResponse.new_player_max_slash_off;
                this.new_player_min_slash_off = slashPriceItemResponse.new_player_min_slash_off;
                this.existing_player_max_slash_off = slashPriceItemResponse.existing_player_max_slash_off;
                this.existing_player_min_slash_off = slashPriceItemResponse.existing_player_min_slash_off;
                this.num_active_activity = slashPriceItemResponse.num_active_activity;
                this.models = SlashPriceItemResponse.copyOf(slashPriceItemResponse.models);
                this.num_total_activity = slashPriceItemResponse.num_total_activity;
                this.self_max_slash_off = slashPriceItemResponse.self_max_slash_off;
                this.self_min_slash_off = slashPriceItemResponse.self_min_slash_off;
                this.duplicate_player_max_slash_off = slashPriceItemResponse.duplicate_player_max_slash_off;
                this.duplicate_player_min_slash_off = slashPriceItemResponse.duplicate_player_min_slash_off;
                this.enable_duplicate_player = slashPriceItemResponse.enable_duplicate_player;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder lowest_price(Long l) {
            this.lowest_price = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public Builder new_player_max_slash_off(Integer num) {
            this.new_player_max_slash_off = num;
            return this;
        }

        public Builder new_player_min_slash_off(Integer num) {
            this.new_player_min_slash_off = num;
            return this;
        }

        public Builder existing_player_max_slash_off(Integer num) {
            this.existing_player_max_slash_off = num;
            return this;
        }

        public Builder existing_player_min_slash_off(Integer num) {
            this.existing_player_min_slash_off = num;
            return this;
        }

        public Builder num_active_activity(Integer num) {
            this.num_active_activity = num;
            return this;
        }

        public Builder models(List<SlashPriceItemModelResponse> list) {
            this.models = checkForNulls(list);
            return this;
        }

        public Builder num_total_activity(Integer num) {
            this.num_total_activity = num;
            return this;
        }

        public Builder self_max_slash_off(Integer num) {
            this.self_max_slash_off = num;
            return this;
        }

        public Builder self_min_slash_off(Integer num) {
            this.self_min_slash_off = num;
            return this;
        }

        public Builder duplicate_player_max_slash_off(Integer num) {
            this.duplicate_player_max_slash_off = num;
            return this;
        }

        public Builder duplicate_player_min_slash_off(Integer num) {
            this.duplicate_player_min_slash_off = num;
            return this;
        }

        public Builder enable_duplicate_player(Boolean bool) {
            this.enable_duplicate_player = bool;
            return this;
        }

        public SlashPriceItemResponse build() {
            return new SlashPriceItemResponse(this);
        }
    }
}
