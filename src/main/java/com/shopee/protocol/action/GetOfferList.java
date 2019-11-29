package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetOfferList extends Message {
    public static final Boolean DEFAULT_GROUP_BY_USER = false;
    public static final Boolean DEFAULT_IS_SELLER = false;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_OFFER_STATUS = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean group_by_user;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean is_seller;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offer_status;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer userid;

    public GetOfferList(String str, Boolean bool, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool2, String str2, Long l, Long l2) {
        this.requestid = str;
        this.is_seller = bool;
        this.offer_status = num;
        this.offset = num2;
        this.limit = num3;
        this.userid = num4;
        this.group_by_user = bool2;
        this.token = str2;
        this.itemid = l;
        this.modelid = l2;
    }

    private GetOfferList(Builder builder) {
        this(builder.requestid, builder.is_seller, builder.offer_status, builder.offset, builder.limit, builder.userid, builder.group_by_user, builder.token, builder.itemid, builder.modelid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetOfferList)) {
            return false;
        }
        GetOfferList getOfferList = (GetOfferList) obj;
        if (!equals((Object) this.requestid, (Object) getOfferList.requestid) || !equals((Object) this.is_seller, (Object) getOfferList.is_seller) || !equals((Object) this.offer_status, (Object) getOfferList.offer_status) || !equals((Object) this.offset, (Object) getOfferList.offset) || !equals((Object) this.limit, (Object) getOfferList.limit) || !equals((Object) this.userid, (Object) getOfferList.userid) || !equals((Object) this.group_by_user, (Object) getOfferList.group_by_user) || !equals((Object) this.token, (Object) getOfferList.token) || !equals((Object) this.itemid, (Object) getOfferList.itemid) || !equals((Object) this.modelid, (Object) getOfferList.modelid)) {
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
        Boolean bool = this.is_seller;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.offer_status;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.userid;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool2 = this.group_by_user;
        int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode9 = (hashCode8 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.modelid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetOfferList> {
        public Boolean group_by_user;
        public Boolean is_seller;
        public Long itemid;
        public Integer limit;
        public Long modelid;
        public Integer offer_status;
        public Integer offset;
        public String requestid;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(GetOfferList getOfferList) {
            super(getOfferList);
            if (getOfferList != null) {
                this.requestid = getOfferList.requestid;
                this.is_seller = getOfferList.is_seller;
                this.offer_status = getOfferList.offer_status;
                this.offset = getOfferList.offset;
                this.limit = getOfferList.limit;
                this.userid = getOfferList.userid;
                this.group_by_user = getOfferList.group_by_user;
                this.token = getOfferList.token;
                this.itemid = getOfferList.itemid;
                this.modelid = getOfferList.modelid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder is_seller(Boolean bool) {
            this.is_seller = bool;
            return this;
        }

        public Builder offer_status(Integer num) {
            this.offer_status = num;
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

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder group_by_user(Boolean bool) {
            this.group_by_user = bool;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public GetOfferList build() {
            return new GetOfferList(this);
        }
    }
}
