package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BuyerAddressExtInfo extends Message {
    public static final String DEFAULT_GEOINFO = "";
    public static final Integer DEFAULT_PREFERRED_DELIVERY_OPTION = 0;
    public static final Long DEFAULT_USER_LOCATION_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String geoinfo;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer preferred_delivery_option;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long user_location_id;

    public BuyerAddressExtInfo(String str, Long l, Integer num) {
        this.geoinfo = str;
        this.user_location_id = l;
        this.preferred_delivery_option = num;
    }

    private BuyerAddressExtInfo(Builder builder) {
        this(builder.geoinfo, builder.user_location_id, builder.preferred_delivery_option);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BuyerAddressExtInfo)) {
            return false;
        }
        BuyerAddressExtInfo buyerAddressExtInfo = (BuyerAddressExtInfo) obj;
        if (!equals((Object) this.geoinfo, (Object) buyerAddressExtInfo.geoinfo) || !equals((Object) this.user_location_id, (Object) buyerAddressExtInfo.user_location_id) || !equals((Object) this.preferred_delivery_option, (Object) buyerAddressExtInfo.preferred_delivery_option)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.geoinfo;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.user_location_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.preferred_delivery_option;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BuyerAddressExtInfo> {
        public String geoinfo;
        public Integer preferred_delivery_option;
        public Long user_location_id;

        public Builder() {
        }

        public Builder(BuyerAddressExtInfo buyerAddressExtInfo) {
            super(buyerAddressExtInfo);
            if (buyerAddressExtInfo != null) {
                this.geoinfo = buyerAddressExtInfo.geoinfo;
                this.user_location_id = buyerAddressExtInfo.user_location_id;
                this.preferred_delivery_option = buyerAddressExtInfo.preferred_delivery_option;
            }
        }

        public Builder geoinfo(String str) {
            this.geoinfo = str;
            return this;
        }

        public Builder user_location_id(Long l) {
            this.user_location_id = l;
            return this;
        }

        public Builder preferred_delivery_option(Integer num) {
            this.preferred_delivery_option = num;
            return this;
        }

        public BuyerAddressExtInfo build() {
            return new BuyerAddressExtInfo(this);
        }
    }
}
