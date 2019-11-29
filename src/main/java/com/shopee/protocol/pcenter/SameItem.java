package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SameItem extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_CTIME = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_LAST_OPERATOR = "";
    public static final Long DEFAULT_LAST_UPDATE = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SOURCE = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TARGET_ITEMID = "";
    public static final String DEFAULT_TARGET_SHOPID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String last_operator;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long last_update;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer source;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String target_itemid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String target_shopid;

    public SameItem(Long l, Long l2, Integer num, String str, Integer num2, Integer num3, String str2, String str3, Long l3, Long l4, String str4, Long l5) {
        this.id = l;
        this.itemid = l2;
        this.shopid = num;
        this.country = str;
        this.status = num2;
        this.source = num3;
        this.target_itemid = str2;
        this.target_shopid = str3;
        this.ctime = l3;
        this.mtime = l4;
        this.last_operator = str4;
        this.last_update = l5;
    }

    private SameItem(Builder builder) {
        this(builder.id, builder.itemid, builder.shopid, builder.country, builder.status, builder.source, builder.target_itemid, builder.target_shopid, builder.ctime, builder.mtime, builder.last_operator, builder.last_update);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SameItem)) {
            return false;
        }
        SameItem sameItem = (SameItem) obj;
        if (!equals((Object) this.id, (Object) sameItem.id) || !equals((Object) this.itemid, (Object) sameItem.itemid) || !equals((Object) this.shopid, (Object) sameItem.shopid) || !equals((Object) this.country, (Object) sameItem.country) || !equals((Object) this.status, (Object) sameItem.status) || !equals((Object) this.source, (Object) sameItem.source) || !equals((Object) this.target_itemid, (Object) sameItem.target_itemid) || !equals((Object) this.target_shopid, (Object) sameItem.target_shopid) || !equals((Object) this.ctime, (Object) sameItem.ctime) || !equals((Object) this.mtime, (Object) sameItem.mtime) || !equals((Object) this.last_operator, (Object) sameItem.last_operator) || !equals((Object) this.last_update, (Object) sameItem.last_update)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.itemid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.source;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.target_itemid;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.target_shopid;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l3 = this.ctime;
        int hashCode9 = (hashCode8 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.mtime;
        int hashCode10 = (hashCode9 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str4 = this.last_operator;
        int hashCode11 = (hashCode10 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Long l5 = this.last_update;
        if (l5 != null) {
            i2 = l5.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SameItem> {
        public String country;
        public Long ctime;
        public Long id;
        public Long itemid;
        public String last_operator;
        public Long last_update;
        public Long mtime;
        public Integer shopid;
        public Integer source;
        public Integer status;
        public String target_itemid;
        public String target_shopid;

        public Builder() {
        }

        public Builder(SameItem sameItem) {
            super(sameItem);
            if (sameItem != null) {
                this.id = sameItem.id;
                this.itemid = sameItem.itemid;
                this.shopid = sameItem.shopid;
                this.country = sameItem.country;
                this.status = sameItem.status;
                this.source = sameItem.source;
                this.target_itemid = sameItem.target_itemid;
                this.target_shopid = sameItem.target_shopid;
                this.ctime = sameItem.ctime;
                this.mtime = sameItem.mtime;
                this.last_operator = sameItem.last_operator;
                this.last_update = sameItem.last_update;
            }
        }

        public Builder id(Long l) {
            this.id = l;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public Builder target_itemid(String str) {
            this.target_itemid = str;
            return this;
        }

        public Builder target_shopid(String str) {
            this.target_shopid = str;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder last_operator(String str) {
            this.last_operator = str;
            return this;
        }

        public Builder last_update(Long l) {
            this.last_update = l;
            return this;
        }

        public SameItem build() {
            return new SameItem(this);
        }
    }
}
