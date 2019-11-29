package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetItemList extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Boolean DEFAULT_HIDE_NO_STOCK = false;
    public static final Boolean DEFAULT_ID_ONLY = false;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_NO_BANNED = false;
    public static final Boolean DEFAULT_NO_DESCRIPTION = false;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_REVERSE = false;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean hide_no_stock;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean id_only;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 12, type = Message.Datatype.BOOL)
    public final Boolean no_banned;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean no_description;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean reverse;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;

    public GetItemList(String str, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, String str2, String str3, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5) {
        this.requestid = str;
        this.shopid = num;
        this.type = num2;
        this.offset = num3;
        this.limit = num4;
        this.reverse = bool;
        this.token = str2;
        this.country = str3;
        this.hide_no_stock = bool2;
        this.no_description = bool3;
        this.id_only = bool4;
        this.no_banned = bool5;
    }

    private GetItemList(Builder builder) {
        this(builder.requestid, builder.shopid, builder.type, builder.offset, builder.limit, builder.reverse, builder.token, builder.country, builder.hide_no_stock, builder.no_description, builder.id_only, builder.no_banned);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetItemList)) {
            return false;
        }
        GetItemList getItemList = (GetItemList) obj;
        if (!equals((Object) this.requestid, (Object) getItemList.requestid) || !equals((Object) this.shopid, (Object) getItemList.shopid) || !equals((Object) this.type, (Object) getItemList.type) || !equals((Object) this.offset, (Object) getItemList.offset) || !equals((Object) this.limit, (Object) getItemList.limit) || !equals((Object) this.reverse, (Object) getItemList.reverse) || !equals((Object) this.token, (Object) getItemList.token) || !equals((Object) this.country, (Object) getItemList.country) || !equals((Object) this.hide_no_stock, (Object) getItemList.hide_no_stock) || !equals((Object) this.no_description, (Object) getItemList.no_description) || !equals((Object) this.id_only, (Object) getItemList.id_only) || !equals((Object) this.no_banned, (Object) getItemList.no_banned)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.type;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.offset;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.limit;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool = this.reverse;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool2 = this.hide_no_stock;
        int hashCode9 = (hashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.no_description;
        int hashCode10 = (hashCode9 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.id_only;
        int hashCode11 = (hashCode10 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.no_banned;
        if (bool5 != null) {
            i2 = bool5.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetItemList> {
        public String country;
        public Boolean hide_no_stock;
        public Boolean id_only;
        public Integer limit;
        public Boolean no_banned;
        public Boolean no_description;
        public Integer offset;
        public String requestid;
        public Boolean reverse;
        public Integer shopid;
        public String token;
        public Integer type;

        public Builder() {
        }

        public Builder(GetItemList getItemList) {
            super(getItemList);
            if (getItemList != null) {
                this.requestid = getItemList.requestid;
                this.shopid = getItemList.shopid;
                this.type = getItemList.type;
                this.offset = getItemList.offset;
                this.limit = getItemList.limit;
                this.reverse = getItemList.reverse;
                this.token = getItemList.token;
                this.country = getItemList.country;
                this.hide_no_stock = getItemList.hide_no_stock;
                this.no_description = getItemList.no_description;
                this.id_only = getItemList.id_only;
                this.no_banned = getItemList.no_banned;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder reverse(Boolean bool) {
            this.reverse = bool;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder hide_no_stock(Boolean bool) {
            this.hide_no_stock = bool;
            return this;
        }

        public Builder no_description(Boolean bool) {
            this.no_description = bool;
            return this;
        }

        public Builder id_only(Boolean bool) {
            this.id_only = bool;
            return this;
        }

        public Builder no_banned(Boolean bool) {
            this.no_banned = bool;
            return this;
        }

        public GetItemList build() {
            checkRequiredFields();
            return new GetItemList(this);
        }
    }
}
