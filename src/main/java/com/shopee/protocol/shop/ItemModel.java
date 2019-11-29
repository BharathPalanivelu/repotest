package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ItemModel extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_PRICE = 0L;
    public static final Long DEFAULT_PRICE_BEFORE_DISCOUNT = 0L;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Long DEFAULT_REBATE_PRICE = 0L;
    public static final String DEFAULT_SKU = "";
    public static final Integer DEFAULT_SOLD = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_STOCK = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 12, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long price_before_discount;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long rebate_price;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String sku;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer sold;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer stock;

    public ItemModel(Long l, Long l2, String str, Long l3, String str2, Integer num, Integer num2, Long l4, Long l5, Long l6, Integer num3, f fVar, Integer num4, Integer num5, String str3) {
        this.modelid = l;
        this.itemid = l2;
        this.name = str;
        this.price = l3;
        this.currency = str2;
        this.stock = num;
        this.status = num2;
        this.price_before_discount = l4;
        this.promotionid = l5;
        this.rebate_price = l6;
        this.sold = num3;
        this.extinfo = fVar;
        this.ctime = num4;
        this.mtime = num5;
        this.sku = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ItemModel(com.shopee.protocol.shop.ItemModel.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.Long r2 = r0.modelid
            java.lang.Long r3 = r0.itemid
            java.lang.String r4 = r0.name
            java.lang.Long r5 = r0.price
            java.lang.String r6 = r0.currency
            java.lang.Integer r7 = r0.stock
            java.lang.Integer r8 = r0.status
            java.lang.Long r9 = r0.price_before_discount
            java.lang.Long r10 = r0.promotionid
            java.lang.Long r11 = r0.rebate_price
            java.lang.Integer r12 = r0.sold
            e.f r13 = r0.extinfo
            java.lang.Integer r14 = r0.ctime
            java.lang.Integer r15 = r0.mtime
            java.lang.String r1 = r0.sku
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.ItemModel.<init>(com.shopee.protocol.shop.ItemModel$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemModel)) {
            return false;
        }
        ItemModel itemModel = (ItemModel) obj;
        if (!equals((Object) this.modelid, (Object) itemModel.modelid) || !equals((Object) this.itemid, (Object) itemModel.itemid) || !equals((Object) this.name, (Object) itemModel.name) || !equals((Object) this.price, (Object) itemModel.price) || !equals((Object) this.currency, (Object) itemModel.currency) || !equals((Object) this.stock, (Object) itemModel.stock) || !equals((Object) this.status, (Object) itemModel.status) || !equals((Object) this.price_before_discount, (Object) itemModel.price_before_discount) || !equals((Object) this.promotionid, (Object) itemModel.promotionid) || !equals((Object) this.rebate_price, (Object) itemModel.rebate_price) || !equals((Object) this.sold, (Object) itemModel.sold) || !equals((Object) this.extinfo, (Object) itemModel.extinfo) || !equals((Object) this.ctime, (Object) itemModel.ctime) || !equals((Object) this.mtime, (Object) itemModel.mtime) || !equals((Object) this.sku, (Object) itemModel.sku)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.modelid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.itemid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l3 = this.price;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str2 = this.currency;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.stock;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l4 = this.price_before_discount;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.promotionid;
        int hashCode9 = (hashCode8 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.rebate_price;
        int hashCode10 = (hashCode9 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Integer num3 = this.sold;
        int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode12 = (hashCode11 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode13 = (hashCode12 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode14 = (hashCode13 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str3 = this.sku;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode14 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemModel> {
        public Integer ctime;
        public String currency;
        public f extinfo;
        public Long itemid;
        public Long modelid;
        public Integer mtime;
        public String name;
        public Long price;
        public Long price_before_discount;
        public Long promotionid;
        public Long rebate_price;
        public String sku;
        public Integer sold;
        public Integer status;
        public Integer stock;

        public Builder() {
        }

        public Builder(ItemModel itemModel) {
            super(itemModel);
            if (itemModel != null) {
                this.modelid = itemModel.modelid;
                this.itemid = itemModel.itemid;
                this.name = itemModel.name;
                this.price = itemModel.price;
                this.currency = itemModel.currency;
                this.stock = itemModel.stock;
                this.status = itemModel.status;
                this.price_before_discount = itemModel.price_before_discount;
                this.promotionid = itemModel.promotionid;
                this.rebate_price = itemModel.rebate_price;
                this.sold = itemModel.sold;
                this.extinfo = itemModel.extinfo;
                this.ctime = itemModel.ctime;
                this.mtime = itemModel.mtime;
                this.sku = itemModel.sku;
            }
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder stock(Integer num) {
            this.stock = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder price_before_discount(Long l) {
            this.price_before_discount = l;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder rebate_price(Long l) {
            this.rebate_price = l;
            return this;
        }

        public Builder sold(Integer num) {
            this.sold = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
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

        public Builder sku(String str) {
            this.sku = str;
            return this;
        }

        public ItemModel build() {
            return new ItemModel(this);
        }
    }
}
