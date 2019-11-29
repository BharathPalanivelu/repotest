package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SlashPriceItemExtInfo extends Message {
    public static final Integer DEFAULT_DUPLICATE_PLAYER_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_DUPLICATE_PLAYER_MIN_SLASH_OFF = 0;
    public static final Boolean DEFAULT_ENABLE_DUPLICATE_PLAYER = false;
    public static final Integer DEFAULT_SELF_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_SELF_MIN_SLASH_OFF = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer duplicate_player_max_slash_off;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer duplicate_player_min_slash_off;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean enable_duplicate_player;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer self_max_slash_off;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer self_min_slash_off;

    public SlashPriceItemExtInfo(Integer num, Integer num2, Integer num3, Integer num4, Boolean bool) {
        this.self_max_slash_off = num;
        this.self_min_slash_off = num2;
        this.duplicate_player_max_slash_off = num3;
        this.duplicate_player_min_slash_off = num4;
        this.enable_duplicate_player = bool;
    }

    private SlashPriceItemExtInfo(Builder builder) {
        this(builder.self_max_slash_off, builder.self_min_slash_off, builder.duplicate_player_max_slash_off, builder.duplicate_player_min_slash_off, builder.enable_duplicate_player);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceItemExtInfo)) {
            return false;
        }
        SlashPriceItemExtInfo slashPriceItemExtInfo = (SlashPriceItemExtInfo) obj;
        if (!equals((Object) this.self_max_slash_off, (Object) slashPriceItemExtInfo.self_max_slash_off) || !equals((Object) this.self_min_slash_off, (Object) slashPriceItemExtInfo.self_min_slash_off) || !equals((Object) this.duplicate_player_max_slash_off, (Object) slashPriceItemExtInfo.duplicate_player_max_slash_off) || !equals((Object) this.duplicate_player_min_slash_off, (Object) slashPriceItemExtInfo.duplicate_player_min_slash_off) || !equals((Object) this.enable_duplicate_player, (Object) slashPriceItemExtInfo.enable_duplicate_player)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.self_max_slash_off;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.self_min_slash_off;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.duplicate_player_max_slash_off;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.duplicate_player_min_slash_off;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool = this.enable_duplicate_player;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceItemExtInfo> {
        public Integer duplicate_player_max_slash_off;
        public Integer duplicate_player_min_slash_off;
        public Boolean enable_duplicate_player;
        public Integer self_max_slash_off;
        public Integer self_min_slash_off;

        public Builder() {
        }

        public Builder(SlashPriceItemExtInfo slashPriceItemExtInfo) {
            super(slashPriceItemExtInfo);
            if (slashPriceItemExtInfo != null) {
                this.self_max_slash_off = slashPriceItemExtInfo.self_max_slash_off;
                this.self_min_slash_off = slashPriceItemExtInfo.self_min_slash_off;
                this.duplicate_player_max_slash_off = slashPriceItemExtInfo.duplicate_player_max_slash_off;
                this.duplicate_player_min_slash_off = slashPriceItemExtInfo.duplicate_player_min_slash_off;
                this.enable_duplicate_player = slashPriceItemExtInfo.enable_duplicate_player;
            }
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

        public SlashPriceItemExtInfo build() {
            return new SlashPriceItemExtInfo(this);
        }
    }
}
