package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BrandSaleGroup extends Message {
    public static final Integer DEFAULT_BRANDID = 0;
    public static final String DEFAULT_CUSTOM_ENTRANCE_PICTURE = "";
    public static final Long DEFAULT_ENTRANCE_PICTURE_SRC_ITEMID = 0L;
    public static final List<FlashSaleItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    public static final List<MultiLangTxt> DEFAULT_SLOGAN = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer brandid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String custom_entrance_picture;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long entrance_picture_src_itemid;
    @ProtoField(label = Message.Label.REPEATED, messageType = FlashSaleItem.class, tag = 6)
    public final List<FlashSaleItem> items;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(label = Message.Label.REPEATED, messageType = MultiLangTxt.class, tag = 3)
    public final List<MultiLangTxt> slogan;

    public BrandSaleGroup(Integer num, Integer num2, List<MultiLangTxt> list, Long l, String str, List<FlashSaleItem> list2) {
        this.brandid = num;
        this.shopid = num2;
        this.slogan = immutableCopyOf(list);
        this.entrance_picture_src_itemid = l;
        this.custom_entrance_picture = str;
        this.items = immutableCopyOf(list2);
    }

    private BrandSaleGroup(Builder builder) {
        this(builder.brandid, builder.shopid, builder.slogan, builder.entrance_picture_src_itemid, builder.custom_entrance_picture, builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BrandSaleGroup)) {
            return false;
        }
        BrandSaleGroup brandSaleGroup = (BrandSaleGroup) obj;
        if (!equals((Object) this.brandid, (Object) brandSaleGroup.brandid) || !equals((Object) this.shopid, (Object) brandSaleGroup.shopid) || !equals((List<?>) this.slogan, (List<?>) brandSaleGroup.slogan) || !equals((Object) this.entrance_picture_src_itemid, (Object) brandSaleGroup.entrance_picture_src_itemid) || !equals((Object) this.custom_entrance_picture, (Object) brandSaleGroup.custom_entrance_picture) || !equals((List<?>) this.items, (List<?>) brandSaleGroup.items)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.brandid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<MultiLangTxt> list = this.slogan;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.entrance_picture_src_itemid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.custom_entrance_picture;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i4 = (hashCode4 + i2) * 37;
        List<FlashSaleItem> list2 = this.items;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<BrandSaleGroup> {
        public Integer brandid;
        public String custom_entrance_picture;
        public Long entrance_picture_src_itemid;
        public List<FlashSaleItem> items;
        public Integer shopid;
        public List<MultiLangTxt> slogan;

        public Builder() {
        }

        public Builder(BrandSaleGroup brandSaleGroup) {
            super(brandSaleGroup);
            if (brandSaleGroup != null) {
                this.brandid = brandSaleGroup.brandid;
                this.shopid = brandSaleGroup.shopid;
                this.slogan = BrandSaleGroup.copyOf(brandSaleGroup.slogan);
                this.entrance_picture_src_itemid = brandSaleGroup.entrance_picture_src_itemid;
                this.custom_entrance_picture = brandSaleGroup.custom_entrance_picture;
                this.items = BrandSaleGroup.copyOf(brandSaleGroup.items);
            }
        }

        public Builder brandid(Integer num) {
            this.brandid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder slogan(List<MultiLangTxt> list) {
            this.slogan = checkForNulls(list);
            return this;
        }

        public Builder entrance_picture_src_itemid(Long l) {
            this.entrance_picture_src_itemid = l;
            return this;
        }

        public Builder custom_entrance_picture(String str) {
            this.custom_entrance_picture = str;
            return this;
        }

        public Builder items(List<FlashSaleItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public BrandSaleGroup build() {
            return new BrandSaleGroup(this);
        }
    }
}
