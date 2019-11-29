package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SlashPriceItem extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_EXISTING_PLAYER_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_EXISTING_PLAYER_MIN_SLASH_OFF = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_ID = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_LOWEST_PRICE = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_NEW_PLAYER_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_NEW_PLAYER_MIN_SLASH_OFF = 0;
    public static final String DEFAULT_OPERATOR = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer existing_player_max_slash_off;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer existing_player_min_slash_off;
    @ProtoField(tag = 14, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long lowest_price;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer new_player_max_slash_off;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer new_player_min_slash_off;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;

    public SlashPriceItem(Integer num, Integer num2, Long l, Long l2, String str, Integer num3, Integer num4, Integer num5, String str2, Integer num6, Integer num7, Integer num8, Integer num9, f fVar) {
        this.id = num;
        this.shopid = num2;
        this.itemid = l;
        this.lowest_price = l2;
        this.country = str;
        this.status = num3;
        this.ctime = num4;
        this.mtime = num5;
        this.operator = str2;
        this.new_player_max_slash_off = num6;
        this.new_player_min_slash_off = num7;
        this.existing_player_max_slash_off = num8;
        this.existing_player_min_slash_off = num9;
        this.extinfo = fVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SlashPriceItem(com.shopee.protocol.shop.SlashPriceItem.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Integer r2 = r0.id
            java.lang.Integer r3 = r0.shopid
            java.lang.Long r4 = r0.itemid
            java.lang.Long r5 = r0.lowest_price
            java.lang.String r6 = r0.country
            java.lang.Integer r7 = r0.status
            java.lang.Integer r8 = r0.ctime
            java.lang.Integer r9 = r0.mtime
            java.lang.String r10 = r0.operator
            java.lang.Integer r11 = r0.new_player_max_slash_off
            java.lang.Integer r12 = r0.new_player_min_slash_off
            java.lang.Integer r13 = r0.existing_player_max_slash_off
            java.lang.Integer r14 = r0.existing_player_min_slash_off
            e.f r15 = r0.extinfo
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.SlashPriceItem.<init>(com.shopee.protocol.shop.SlashPriceItem$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceItem)) {
            return false;
        }
        SlashPriceItem slashPriceItem = (SlashPriceItem) obj;
        if (!equals((Object) this.id, (Object) slashPriceItem.id) || !equals((Object) this.shopid, (Object) slashPriceItem.shopid) || !equals((Object) this.itemid, (Object) slashPriceItem.itemid) || !equals((Object) this.lowest_price, (Object) slashPriceItem.lowest_price) || !equals((Object) this.country, (Object) slashPriceItem.country) || !equals((Object) this.status, (Object) slashPriceItem.status) || !equals((Object) this.ctime, (Object) slashPriceItem.ctime) || !equals((Object) this.mtime, (Object) slashPriceItem.mtime) || !equals((Object) this.operator, (Object) slashPriceItem.operator) || !equals((Object) this.new_player_max_slash_off, (Object) slashPriceItem.new_player_max_slash_off) || !equals((Object) this.new_player_min_slash_off, (Object) slashPriceItem.new_player_min_slash_off) || !equals((Object) this.existing_player_max_slash_off, (Object) slashPriceItem.existing_player_max_slash_off) || !equals((Object) this.existing_player_min_slash_off, (Object) slashPriceItem.existing_player_min_slash_off) || !equals((Object) this.extinfo, (Object) slashPriceItem.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.lowest_price;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.operator;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num6 = this.new_player_max_slash_off;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.new_player_min_slash_off;
        int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.existing_player_max_slash_off;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.existing_player_min_slash_off;
        int hashCode13 = (hashCode12 + (num9 != null ? num9.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceItem> {
        public String country;
        public Integer ctime;
        public Integer existing_player_max_slash_off;
        public Integer existing_player_min_slash_off;
        public f extinfo;
        public Integer id;
        public Long itemid;
        public Long lowest_price;
        public Integer mtime;
        public Integer new_player_max_slash_off;
        public Integer new_player_min_slash_off;
        public String operator;
        public Integer shopid;
        public Integer status;

        public Builder() {
        }

        public Builder(SlashPriceItem slashPriceItem) {
            super(slashPriceItem);
            if (slashPriceItem != null) {
                this.id = slashPriceItem.id;
                this.shopid = slashPriceItem.shopid;
                this.itemid = slashPriceItem.itemid;
                this.lowest_price = slashPriceItem.lowest_price;
                this.country = slashPriceItem.country;
                this.status = slashPriceItem.status;
                this.ctime = slashPriceItem.ctime;
                this.mtime = slashPriceItem.mtime;
                this.operator = slashPriceItem.operator;
                this.new_player_max_slash_off = slashPriceItem.new_player_max_slash_off;
                this.new_player_min_slash_off = slashPriceItem.new_player_min_slash_off;
                this.existing_player_max_slash_off = slashPriceItem.existing_player_max_slash_off;
                this.existing_player_min_slash_off = slashPriceItem.existing_player_min_slash_off;
                this.extinfo = slashPriceItem.extinfo;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
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

        public Builder lowest_price(Long l) {
            this.lowest_price = l;
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

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
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

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public SlashPriceItem build() {
            return new SlashPriceItem(this);
        }
    }
}
