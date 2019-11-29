package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemPreviewSetting extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Boolean DEFAULT_OPEN_PRICE_MASK = false;
    public static final Long DEFAULT_PREVIEWID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean open_price_mask;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long previewid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;

    public ItemPreviewSetting(Long l, Long l2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, String str, Boolean bool) {
        this.previewid = l;
        this.itemid = l2;
        this.shopid = num;
        this.start_time = num2;
        this.end_time = num3;
        this.status = num4;
        this.mtime = num5;
        this.ctime = num6;
        this.country = str;
        this.open_price_mask = bool;
    }

    private ItemPreviewSetting(Builder builder) {
        this(builder.previewid, builder.itemid, builder.shopid, builder.start_time, builder.end_time, builder.status, builder.mtime, builder.ctime, builder.country, builder.open_price_mask);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemPreviewSetting)) {
            return false;
        }
        ItemPreviewSetting itemPreviewSetting = (ItemPreviewSetting) obj;
        if (!equals((Object) this.previewid, (Object) itemPreviewSetting.previewid) || !equals((Object) this.itemid, (Object) itemPreviewSetting.itemid) || !equals((Object) this.shopid, (Object) itemPreviewSetting.shopid) || !equals((Object) this.start_time, (Object) itemPreviewSetting.start_time) || !equals((Object) this.end_time, (Object) itemPreviewSetting.end_time) || !equals((Object) this.status, (Object) itemPreviewSetting.status) || !equals((Object) this.mtime, (Object) itemPreviewSetting.mtime) || !equals((Object) this.ctime, (Object) itemPreviewSetting.ctime) || !equals((Object) this.country, (Object) itemPreviewSetting.country) || !equals((Object) this.open_price_mask, (Object) itemPreviewSetting.open_price_mask)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.previewid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.itemid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.start_time;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.end_time;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode9 = (hashCode8 + (str != null ? str.hashCode() : 0)) * 37;
        Boolean bool = this.open_price_mask;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemPreviewSetting> {
        public String country;
        public Integer ctime;
        public Integer end_time;
        public Long itemid;
        public Integer mtime;
        public Boolean open_price_mask;
        public Long previewid;
        public Integer shopid;
        public Integer start_time;
        public Integer status;

        public Builder() {
        }

        public Builder(ItemPreviewSetting itemPreviewSetting) {
            super(itemPreviewSetting);
            if (itemPreviewSetting != null) {
                this.previewid = itemPreviewSetting.previewid;
                this.itemid = itemPreviewSetting.itemid;
                this.shopid = itemPreviewSetting.shopid;
                this.start_time = itemPreviewSetting.start_time;
                this.end_time = itemPreviewSetting.end_time;
                this.status = itemPreviewSetting.status;
                this.mtime = itemPreviewSetting.mtime;
                this.ctime = itemPreviewSetting.ctime;
                this.country = itemPreviewSetting.country;
                this.open_price_mask = itemPreviewSetting.open_price_mask;
            }
        }

        public Builder previewid(Long l) {
            this.previewid = l;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
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

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder open_price_mask(Boolean bool) {
            this.open_price_mask = bool;
            return this;
        }

        public ItemPreviewSetting build() {
            return new ItemPreviewSetting(this);
        }
    }
}
