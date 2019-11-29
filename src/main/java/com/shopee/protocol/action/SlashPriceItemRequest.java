package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SlashPriceItemRequest extends Message {
    public static final Integer DEFAULT_DUPLICATE_PLAYER_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_DUPLICATE_PLAYER_MIN_SLASH_OFF = 0;
    public static final Boolean DEFAULT_ENABLE_DUPLICATE_PLAYER = false;
    public static final Integer DEFAULT_EXISTING_PLAYER_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_EXISTING_PLAYER_MIN_SLASH_OFF = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_LOWEST_PRICE = 0L;
    public static final Integer DEFAULT_NEW_PLAYER_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_NEW_PLAYER_MIN_SLASH_OFF = 0;
    public static final Integer DEFAULT_SELF_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_SELF_MIN_SLASH_OFF = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer duplicate_player_max_slash_off;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer duplicate_player_min_slash_off;
    @ProtoField(tag = 13, type = Message.Datatype.BOOL)
    public final Boolean enable_duplicate_player;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer existing_player_max_slash_off;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer existing_player_min_slash_off;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long lowest_price;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer new_player_max_slash_off;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer new_player_min_slash_off;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer self_max_slash_off;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer self_min_slash_off;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;

    public SlashPriceItemRequest(Integer num, Long l, Long l2, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Boolean bool) {
        this.shopid = num;
        this.itemid = l;
        this.lowest_price = l2;
        this.status = num2;
        this.new_player_max_slash_off = num3;
        this.new_player_min_slash_off = num4;
        this.existing_player_max_slash_off = num5;
        this.existing_player_min_slash_off = num6;
        this.self_max_slash_off = num7;
        this.self_min_slash_off = num8;
        this.duplicate_player_max_slash_off = num9;
        this.duplicate_player_min_slash_off = num10;
        this.enable_duplicate_player = bool;
    }

    private SlashPriceItemRequest(Builder builder) {
        this(builder.shopid, builder.itemid, builder.lowest_price, builder.status, builder.new_player_max_slash_off, builder.new_player_min_slash_off, builder.existing_player_max_slash_off, builder.existing_player_min_slash_off, builder.self_max_slash_off, builder.self_min_slash_off, builder.duplicate_player_max_slash_off, builder.duplicate_player_min_slash_off, builder.enable_duplicate_player);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceItemRequest)) {
            return false;
        }
        SlashPriceItemRequest slashPriceItemRequest = (SlashPriceItemRequest) obj;
        if (!equals((Object) this.shopid, (Object) slashPriceItemRequest.shopid) || !equals((Object) this.itemid, (Object) slashPriceItemRequest.itemid) || !equals((Object) this.lowest_price, (Object) slashPriceItemRequest.lowest_price) || !equals((Object) this.status, (Object) slashPriceItemRequest.status) || !equals((Object) this.new_player_max_slash_off, (Object) slashPriceItemRequest.new_player_max_slash_off) || !equals((Object) this.new_player_min_slash_off, (Object) slashPriceItemRequest.new_player_min_slash_off) || !equals((Object) this.existing_player_max_slash_off, (Object) slashPriceItemRequest.existing_player_max_slash_off) || !equals((Object) this.existing_player_min_slash_off, (Object) slashPriceItemRequest.existing_player_min_slash_off) || !equals((Object) this.self_max_slash_off, (Object) slashPriceItemRequest.self_max_slash_off) || !equals((Object) this.self_min_slash_off, (Object) slashPriceItemRequest.self_min_slash_off) || !equals((Object) this.duplicate_player_max_slash_off, (Object) slashPriceItemRequest.duplicate_player_max_slash_off) || !equals((Object) this.duplicate_player_min_slash_off, (Object) slashPriceItemRequest.duplicate_player_min_slash_off) || !equals((Object) this.enable_duplicate_player, (Object) slashPriceItemRequest.enable_duplicate_player)) {
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
        Integer num3 = this.new_player_max_slash_off;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.new_player_min_slash_off;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.existing_player_max_slash_off;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.existing_player_min_slash_off;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.self_max_slash_off;
        int hashCode9 = (hashCode8 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.self_min_slash_off;
        int hashCode10 = (hashCode9 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.duplicate_player_max_slash_off;
        int hashCode11 = (hashCode10 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.duplicate_player_min_slash_off;
        int hashCode12 = (hashCode11 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Boolean bool = this.enable_duplicate_player;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceItemRequest> {
        public Integer duplicate_player_max_slash_off;
        public Integer duplicate_player_min_slash_off;
        public Boolean enable_duplicate_player;
        public Integer existing_player_max_slash_off;
        public Integer existing_player_min_slash_off;
        public Long itemid;
        public Long lowest_price;
        public Integer new_player_max_slash_off;
        public Integer new_player_min_slash_off;
        public Integer self_max_slash_off;
        public Integer self_min_slash_off;
        public Integer shopid;
        public Integer status;

        public Builder() {
        }

        public Builder(SlashPriceItemRequest slashPriceItemRequest) {
            super(slashPriceItemRequest);
            if (slashPriceItemRequest != null) {
                this.shopid = slashPriceItemRequest.shopid;
                this.itemid = slashPriceItemRequest.itemid;
                this.lowest_price = slashPriceItemRequest.lowest_price;
                this.status = slashPriceItemRequest.status;
                this.new_player_max_slash_off = slashPriceItemRequest.new_player_max_slash_off;
                this.new_player_min_slash_off = slashPriceItemRequest.new_player_min_slash_off;
                this.existing_player_max_slash_off = slashPriceItemRequest.existing_player_max_slash_off;
                this.existing_player_min_slash_off = slashPriceItemRequest.existing_player_min_slash_off;
                this.self_max_slash_off = slashPriceItemRequest.self_max_slash_off;
                this.self_min_slash_off = slashPriceItemRequest.self_min_slash_off;
                this.duplicate_player_max_slash_off = slashPriceItemRequest.duplicate_player_max_slash_off;
                this.duplicate_player_min_slash_off = slashPriceItemRequest.duplicate_player_min_slash_off;
                this.enable_duplicate_player = slashPriceItemRequest.enable_duplicate_player;
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

        public SlashPriceItemRequest build() {
            return new SlashPriceItemRequest(this);
        }
    }
}
