package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetUserBrief extends Message {
    public static final Boolean DEFAULT_NEED_DELETED = false;
    public static final Boolean DEFAULT_NEED_PICKUP_ADDRESS = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Integer> DEFAULT_SHOPID = Collections.emptyList();
    public static final String DEFAULT_TOKEN = "";
    public static final List<Integer> DEFAULT_USERID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean need_deleted;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean need_pickup_address;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> shopid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> userid;

    public GetUserBrief(String str, String str2, List<Integer> list, List<Integer> list2, Boolean bool, Boolean bool2) {
        this.requestid = str;
        this.token = str2;
        this.userid = immutableCopyOf(list);
        this.shopid = immutableCopyOf(list2);
        this.need_deleted = bool;
        this.need_pickup_address = bool2;
    }

    private GetUserBrief(Builder builder) {
        this(builder.requestid, builder.token, builder.userid, builder.shopid, builder.need_deleted, builder.need_pickup_address);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetUserBrief)) {
            return false;
        }
        GetUserBrief getUserBrief = (GetUserBrief) obj;
        if (!equals((Object) this.requestid, (Object) getUserBrief.requestid) || !equals((Object) this.token, (Object) getUserBrief.token) || !equals((List<?>) this.userid, (List<?>) getUserBrief.userid) || !equals((List<?>) this.shopid, (List<?>) getUserBrief.shopid) || !equals((Object) this.need_deleted, (Object) getUserBrief.need_deleted) || !equals((Object) this.need_pickup_address, (Object) getUserBrief.need_pickup_address)) {
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
        List<Integer> list = this.userid;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<Integer> list2 = this.shopid;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode3 + i3) * 37;
        Boolean bool = this.need_deleted;
        int hashCode4 = (i4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.need_pickup_address;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i5 = hashCode4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<GetUserBrief> {
        public Boolean need_deleted;
        public Boolean need_pickup_address;
        public String requestid;
        public List<Integer> shopid;
        public String token;
        public List<Integer> userid;

        public Builder() {
        }

        public Builder(GetUserBrief getUserBrief) {
            super(getUserBrief);
            if (getUserBrief != null) {
                this.requestid = getUserBrief.requestid;
                this.token = getUserBrief.token;
                this.userid = GetUserBrief.copyOf(getUserBrief.userid);
                this.shopid = GetUserBrief.copyOf(getUserBrief.shopid);
                this.need_deleted = getUserBrief.need_deleted;
                this.need_pickup_address = getUserBrief.need_pickup_address;
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

        public Builder userid(List<Integer> list) {
            this.userid = checkForNulls(list);
            return this;
        }

        public Builder shopid(List<Integer> list) {
            this.shopid = checkForNulls(list);
            return this;
        }

        public Builder need_deleted(Boolean bool) {
            this.need_deleted = bool;
            return this;
        }

        public Builder need_pickup_address(Boolean bool) {
            this.need_pickup_address = bool;
            return this;
        }

        public GetUserBrief build() {
            return new GetUserBrief(this);
        }
    }
}
