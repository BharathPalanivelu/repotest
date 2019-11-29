package com.shopee.protocol.action;

import com.shopee.protocol.shop.CategoryPath;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class DPItem extends Message {
    public static final List<Long> DEFAULT_CARRIERS = Collections.emptyList();
    public static final List<CategoryPath> DEFAULT_CATEGORIES = Collections.emptyList();
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_PRICE_BEFORE_VOUCHER = 0L;
    public static final Long DEFAULT_QUANTITY = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> carriers;
    @ProtoField(label = Message.Label.REPEATED, messageType = CategoryPath.class, tag = 2)
    public final List<CategoryPath> categories;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long price_before_voucher;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long quantity;

    public DPItem(Long l, List<CategoryPath> list, List<Long> list2, Long l2, Long l3) {
        this.itemid = l;
        this.categories = immutableCopyOf(list);
        this.carriers = immutableCopyOf(list2);
        this.price_before_voucher = l2;
        this.quantity = l3;
    }

    private DPItem(Builder builder) {
        this(builder.itemid, builder.categories, builder.carriers, builder.price_before_voucher, builder.quantity);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DPItem)) {
            return false;
        }
        DPItem dPItem = (DPItem) obj;
        if (!equals((Object) this.itemid, (Object) dPItem.itemid) || !equals((List<?>) this.categories, (List<?>) dPItem.categories) || !equals((List<?>) this.carriers, (List<?>) dPItem.carriers) || !equals((Object) this.price_before_voucher, (Object) dPItem.price_before_voucher) || !equals((Object) this.quantity, (Object) dPItem.quantity)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        List<CategoryPath> list = this.categories;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<Long> list2 = this.carriers;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode2 + i3) * 37;
        Long l2 = this.price_before_voucher;
        int hashCode3 = (i4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.quantity;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i5 = hashCode3 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<DPItem> {
        public List<Long> carriers;
        public List<CategoryPath> categories;
        public Long itemid;
        public Long price_before_voucher;
        public Long quantity;

        public Builder() {
        }

        public Builder(DPItem dPItem) {
            super(dPItem);
            if (dPItem != null) {
                this.itemid = dPItem.itemid;
                this.categories = DPItem.copyOf(dPItem.categories);
                this.carriers = DPItem.copyOf(dPItem.carriers);
                this.price_before_voucher = dPItem.price_before_voucher;
                this.quantity = dPItem.quantity;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder categories(List<CategoryPath> list) {
            this.categories = checkForNulls(list);
            return this;
        }

        public Builder carriers(List<Long> list) {
            this.carriers = checkForNulls(list);
            return this;
        }

        public Builder price_before_voucher(Long l) {
            this.price_before_voucher = l;
            return this;
        }

        public Builder quantity(Long l) {
            this.quantity = l;
            return this;
        }

        public DPItem build() {
            checkRequiredFields();
            return new DPItem(this);
        }
    }
}
