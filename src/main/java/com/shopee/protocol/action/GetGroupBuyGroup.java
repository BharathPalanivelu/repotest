package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetGroupBuyGroup extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_GROUPID = 0L;
    public static final String DEFAULT_GROUP_CODE = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String group_code;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long groupid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetGroupBuyGroup(String str, String str2, Long l, Long l2, Integer num, Integer num2, String str3, String str4, Integer num3) {
        this.requestid = str;
        this.token = str2;
        this.itemid = l;
        this.groupid = l2;
        this.limit = num;
        this.status = num2;
        this.group_code = str3;
        this.country = str4;
        this.offset = num3;
    }

    private GetGroupBuyGroup(Builder builder) {
        this(builder.requestid, builder.token, builder.itemid, builder.groupid, builder.limit, builder.status, builder.group_code, builder.country, builder.offset);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetGroupBuyGroup)) {
            return false;
        }
        GetGroupBuyGroup getGroupBuyGroup = (GetGroupBuyGroup) obj;
        if (!equals((Object) this.requestid, (Object) getGroupBuyGroup.requestid) || !equals((Object) this.token, (Object) getGroupBuyGroup.token) || !equals((Object) this.itemid, (Object) getGroupBuyGroup.itemid) || !equals((Object) this.groupid, (Object) getGroupBuyGroup.groupid) || !equals((Object) this.limit, (Object) getGroupBuyGroup.limit) || !equals((Object) this.status, (Object) getGroupBuyGroup.status) || !equals((Object) this.group_code, (Object) getGroupBuyGroup.group_code) || !equals((Object) this.country, (Object) getGroupBuyGroup.country) || !equals((Object) this.offset, (Object) getGroupBuyGroup.offset)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.groupid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.limit;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str3 = this.group_code;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.country;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num3 = this.offset;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetGroupBuyGroup> {
        public String country;
        public String group_code;
        public Long groupid;
        public Long itemid;
        public Integer limit;
        public Integer offset;
        public String requestid;
        public Integer status;
        public String token;

        public Builder() {
        }

        public Builder(GetGroupBuyGroup getGroupBuyGroup) {
            super(getGroupBuyGroup);
            if (getGroupBuyGroup != null) {
                this.requestid = getGroupBuyGroup.requestid;
                this.token = getGroupBuyGroup.token;
                this.itemid = getGroupBuyGroup.itemid;
                this.groupid = getGroupBuyGroup.groupid;
                this.limit = getGroupBuyGroup.limit;
                this.status = getGroupBuyGroup.status;
                this.group_code = getGroupBuyGroup.group_code;
                this.country = getGroupBuyGroup.country;
                this.offset = getGroupBuyGroup.offset;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
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

        public Builder groupid(Long l) {
            this.groupid = l;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder group_code(String str) {
            this.group_code = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public GetGroupBuyGroup build() {
            return new GetGroupBuyGroup(this);
        }
    }
}
