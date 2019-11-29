package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ObjSellerCollectionItem extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long userid;

    public ObjSellerCollectionItem(Long l, Integer num, Long l2) {
        this.itemid = l;
        this.shopid = num;
        this.userid = l2;
    }

    private ObjSellerCollectionItem(Builder builder) {
        this(builder.itemid, builder.shopid, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ObjSellerCollectionItem)) {
            return false;
        }
        ObjSellerCollectionItem objSellerCollectionItem = (ObjSellerCollectionItem) obj;
        if (!equals((Object) this.itemid, (Object) objSellerCollectionItem.itemid) || !equals((Object) this.shopid, (Object) objSellerCollectionItem.shopid) || !equals((Object) this.userid, (Object) objSellerCollectionItem.userid)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.userid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ObjSellerCollectionItem> {
        public Long itemid;
        public Integer shopid;
        public Long userid;

        public Builder() {
        }

        public Builder(ObjSellerCollectionItem objSellerCollectionItem) {
            super(objSellerCollectionItem);
            if (objSellerCollectionItem != null) {
                this.itemid = objSellerCollectionItem.itemid;
                this.shopid = objSellerCollectionItem.shopid;
                this.userid = objSellerCollectionItem.userid;
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder userid(Long l) {
            this.userid = l;
            return this;
        }

        public ObjSellerCollectionItem build() {
            return new ObjSellerCollectionItem(this);
        }
    }
}
