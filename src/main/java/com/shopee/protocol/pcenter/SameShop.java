package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SameShop extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_CTIME = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_LAST_OPERATOR = "";
    public static final Integer DEFAULT_MAIN_CAT = 0;
    public static final Long DEFAULT_MTIME = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SOURCE = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TARGET_SHOPID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String last_operator;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer main_cat;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer source;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String target_shopid;

    public SameShop(Long l, Integer num, Integer num2, String str, Integer num3, Integer num4, Long l2, Long l3, String str2, String str3) {
        this.id = l;
        this.shopid = num;
        this.source = num2;
        this.target_shopid = str;
        this.main_cat = num3;
        this.status = num4;
        this.ctime = l2;
        this.mtime = l3;
        this.last_operator = str2;
        this.country = str3;
    }

    private SameShop(Builder builder) {
        this(builder.id, builder.shopid, builder.source, builder.target_shopid, builder.main_cat, builder.status, builder.ctime, builder.mtime, builder.last_operator, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SameShop)) {
            return false;
        }
        SameShop sameShop = (SameShop) obj;
        if (!equals((Object) this.id, (Object) sameShop.id) || !equals((Object) this.shopid, (Object) sameShop.shopid) || !equals((Object) this.source, (Object) sameShop.source) || !equals((Object) this.target_shopid, (Object) sameShop.target_shopid) || !equals((Object) this.main_cat, (Object) sameShop.main_cat) || !equals((Object) this.status, (Object) sameShop.status) || !equals((Object) this.ctime, (Object) sameShop.ctime) || !equals((Object) this.mtime, (Object) sameShop.mtime) || !equals((Object) this.last_operator, (Object) sameShop.last_operator) || !equals((Object) this.country, (Object) sameShop.country)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.source;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.target_shopid;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.main_cat;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l2 = this.ctime;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.mtime;
        int hashCode8 = (hashCode7 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str2 = this.last_operator;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.country;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SameShop> {
        public String country;
        public Long ctime;
        public Long id;
        public String last_operator;
        public Integer main_cat;
        public Long mtime;
        public Integer shopid;
        public Integer source;
        public Integer status;
        public String target_shopid;

        public Builder() {
        }

        public Builder(SameShop sameShop) {
            super(sameShop);
            if (sameShop != null) {
                this.id = sameShop.id;
                this.shopid = sameShop.shopid;
                this.source = sameShop.source;
                this.target_shopid = sameShop.target_shopid;
                this.main_cat = sameShop.main_cat;
                this.status = sameShop.status;
                this.ctime = sameShop.ctime;
                this.mtime = sameShop.mtime;
                this.last_operator = sameShop.last_operator;
                this.country = sameShop.country;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public Builder target_shopid(String str) {
            this.target_shopid = str;
            return this;
        }

        public Builder main_cat(Integer num) {
            this.main_cat = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public SameShop build() {
            return new SameShop(this);
        }
    }
}
