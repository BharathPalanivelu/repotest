package com.shopee.protocol.action;

import com.shopee.protocol.shop.MultiLangTxt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetBrandSaleGroup extends Message {
    public static final Integer DEFAULT_BRANDID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_CUSTOM_ENTRANCE_PICTURE = "";
    public static final Long DEFAULT_ENTRANCE_PICTURE_SRC_ITEMID = 0L;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final List<MultiLangTxt> DEFAULT_SLOGAN = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer brandid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String custom_entrance_picture;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long entrance_picture_src_itemid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(label = Message.Label.REPEATED, messageType = MultiLangTxt.class, tag = 6)
    public final List<MultiLangTxt> slogan;

    public SetBrandSaleGroup(String str, String str2, Long l, Integer num, Integer num2, List<MultiLangTxt> list, Long l2, String str3) {
        this.requestid = str;
        this.country = str2;
        this.promotionid = l;
        this.brandid = num;
        this.shopid = num2;
        this.slogan = immutableCopyOf(list);
        this.entrance_picture_src_itemid = l2;
        this.custom_entrance_picture = str3;
    }

    private SetBrandSaleGroup(Builder builder) {
        this(builder.requestid, builder.country, builder.promotionid, builder.brandid, builder.shopid, builder.slogan, builder.entrance_picture_src_itemid, builder.custom_entrance_picture);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetBrandSaleGroup)) {
            return false;
        }
        SetBrandSaleGroup setBrandSaleGroup = (SetBrandSaleGroup) obj;
        if (!equals((Object) this.requestid, (Object) setBrandSaleGroup.requestid) || !equals((Object) this.country, (Object) setBrandSaleGroup.country) || !equals((Object) this.promotionid, (Object) setBrandSaleGroup.promotionid) || !equals((Object) this.brandid, (Object) setBrandSaleGroup.brandid) || !equals((Object) this.shopid, (Object) setBrandSaleGroup.shopid) || !equals((List<?>) this.slogan, (List<?>) setBrandSaleGroup.slogan) || !equals((Object) this.entrance_picture_src_itemid, (Object) setBrandSaleGroup.entrance_picture_src_itemid) || !equals((Object) this.custom_entrance_picture, (Object) setBrandSaleGroup.custom_entrance_picture)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.promotionid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.brandid;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<MultiLangTxt> list = this.slogan;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 1)) * 37;
        Long l2 = this.entrance_picture_src_itemid;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str3 = this.custom_entrance_picture;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetBrandSaleGroup> {
        public Integer brandid;
        public String country;
        public String custom_entrance_picture;
        public Long entrance_picture_src_itemid;
        public Long promotionid;
        public String requestid;
        public Integer shopid;
        public List<MultiLangTxt> slogan;

        public Builder() {
        }

        public Builder(SetBrandSaleGroup setBrandSaleGroup) {
            super(setBrandSaleGroup);
            if (setBrandSaleGroup != null) {
                this.requestid = setBrandSaleGroup.requestid;
                this.country = setBrandSaleGroup.country;
                this.promotionid = setBrandSaleGroup.promotionid;
                this.brandid = setBrandSaleGroup.brandid;
                this.shopid = setBrandSaleGroup.shopid;
                this.slogan = SetBrandSaleGroup.copyOf(setBrandSaleGroup.slogan);
                this.entrance_picture_src_itemid = setBrandSaleGroup.entrance_picture_src_itemid;
                this.custom_entrance_picture = setBrandSaleGroup.custom_entrance_picture;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
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

        public SetBrandSaleGroup build() {
            return new SetBrandSaleGroup(this);
        }
    }
}
