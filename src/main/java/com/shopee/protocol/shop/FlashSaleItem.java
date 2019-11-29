package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class FlashSaleItem extends Message {
    public static final Integer DEFAULT_FLASH_CATID = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final List<String> DEFAULT_PROMO_IMAGES = Collections.emptyList();
    public static final String DEFAULT_PROMO_NAME = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Boolean DEFAULT_SOLD_OUT_AUTO_MOVE = false;
    public static final Integer DEFAULT_SORT_POSITION = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer flash_catid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> promo_images;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String promo_name;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean sold_out_auto_move;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer sort_position;

    public FlashSaleItem(Integer num, Long l, List<String> list, String str, Integer num2, Integer num3, Boolean bool) {
        this.shopid = num;
        this.itemid = l;
        this.promo_images = immutableCopyOf(list);
        this.promo_name = str;
        this.flash_catid = num2;
        this.sort_position = num3;
        this.sold_out_auto_move = bool;
    }

    private FlashSaleItem(Builder builder) {
        this(builder.shopid, builder.itemid, builder.promo_images, builder.promo_name, builder.flash_catid, builder.sort_position, builder.sold_out_auto_move);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlashSaleItem)) {
            return false;
        }
        FlashSaleItem flashSaleItem = (FlashSaleItem) obj;
        if (!equals((Object) this.shopid, (Object) flashSaleItem.shopid) || !equals((Object) this.itemid, (Object) flashSaleItem.itemid) || !equals((List<?>) this.promo_images, (List<?>) flashSaleItem.promo_images) || !equals((Object) this.promo_name, (Object) flashSaleItem.promo_name) || !equals((Object) this.flash_catid, (Object) flashSaleItem.flash_catid) || !equals((Object) this.sort_position, (Object) flashSaleItem.sort_position) || !equals((Object) this.sold_out_auto_move, (Object) flashSaleItem.sold_out_auto_move)) {
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
        List<String> list = this.promo_images;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.promo_name;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.flash_catid;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.sort_position;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool = this.sold_out_auto_move;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FlashSaleItem> {
        public Integer flash_catid;
        public Long itemid;
        public List<String> promo_images;
        public String promo_name;
        public Integer shopid;
        public Boolean sold_out_auto_move;
        public Integer sort_position;

        public Builder() {
        }

        public Builder(FlashSaleItem flashSaleItem) {
            super(flashSaleItem);
            if (flashSaleItem != null) {
                this.shopid = flashSaleItem.shopid;
                this.itemid = flashSaleItem.itemid;
                this.promo_images = FlashSaleItem.copyOf(flashSaleItem.promo_images);
                this.promo_name = flashSaleItem.promo_name;
                this.flash_catid = flashSaleItem.flash_catid;
                this.sort_position = flashSaleItem.sort_position;
                this.sold_out_auto_move = flashSaleItem.sold_out_auto_move;
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

        public Builder promo_images(List<String> list) {
            this.promo_images = checkForNulls(list);
            return this;
        }

        public Builder promo_name(String str) {
            this.promo_name = str;
            return this;
        }

        public Builder flash_catid(Integer num) {
            this.flash_catid = num;
            return this;
        }

        public Builder sort_position(Integer num) {
            this.sort_position = num;
            return this;
        }

        public Builder sold_out_auto_move(Boolean bool) {
            this.sold_out_auto_move = bool;
            return this;
        }

        public FlashSaleItem build() {
            return new FlashSaleItem(this);
        }
    }
}
