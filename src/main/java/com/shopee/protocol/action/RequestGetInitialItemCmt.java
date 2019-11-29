package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestGetInitialItemCmt extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final Integer DEFAULT_FROM_TIME = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_TO_TIME = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8)
    public final BackendParam bparam;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer from_time;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer to_time;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;

    public RequestGetInitialItemCmt(String str, Long l, Integer num, Integer num2, Long l2, Integer num3, Integer num4, BackendParam backendParam, Integer num5, Integer num6) {
        this.requestid = str;
        this.cmtid = l;
        this.userid = num;
        this.shopid = num2;
        this.itemid = l2;
        this.offset = num3;
        this.limit = num4;
        this.bparam = backendParam;
        this.from_time = num5;
        this.to_time = num6;
    }

    private RequestGetInitialItemCmt(Builder builder) {
        this(builder.requestid, builder.cmtid, builder.userid, builder.shopid, builder.itemid, builder.offset, builder.limit, builder.bparam, builder.from_time, builder.to_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestGetInitialItemCmt)) {
            return false;
        }
        RequestGetInitialItemCmt requestGetInitialItemCmt = (RequestGetInitialItemCmt) obj;
        if (!equals((Object) this.requestid, (Object) requestGetInitialItemCmt.requestid) || !equals((Object) this.cmtid, (Object) requestGetInitialItemCmt.cmtid) || !equals((Object) this.userid, (Object) requestGetInitialItemCmt.userid) || !equals((Object) this.shopid, (Object) requestGetInitialItemCmt.shopid) || !equals((Object) this.itemid, (Object) requestGetInitialItemCmt.itemid) || !equals((Object) this.offset, (Object) requestGetInitialItemCmt.offset) || !equals((Object) this.limit, (Object) requestGetInitialItemCmt.limit) || !equals((Object) this.bparam, (Object) requestGetInitialItemCmt.bparam) || !equals((Object) this.from_time, (Object) requestGetInitialItemCmt.from_time) || !equals((Object) this.to_time, (Object) requestGetInitialItemCmt.to_time)) {
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
        Long l = this.cmtid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.userid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num3 = this.offset;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.limit;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode8 = (hashCode7 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Integer num5 = this.from_time;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.to_time;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestGetInitialItemCmt> {
        public BackendParam bparam;
        public Long cmtid;
        public Integer from_time;
        public Long itemid;
        public Integer limit;
        public Integer offset;
        public String requestid;
        public Integer shopid;
        public Integer to_time;
        public Integer userid;

        public Builder() {
        }

        public Builder(RequestGetInitialItemCmt requestGetInitialItemCmt) {
            super(requestGetInitialItemCmt);
            if (requestGetInitialItemCmt != null) {
                this.requestid = requestGetInitialItemCmt.requestid;
                this.cmtid = requestGetInitialItemCmt.cmtid;
                this.userid = requestGetInitialItemCmt.userid;
                this.shopid = requestGetInitialItemCmt.shopid;
                this.itemid = requestGetInitialItemCmt.itemid;
                this.offset = requestGetInitialItemCmt.offset;
                this.limit = requestGetInitialItemCmt.limit;
                this.bparam = requestGetInitialItemCmt.bparam;
                this.from_time = requestGetInitialItemCmt.from_time;
                this.to_time = requestGetInitialItemCmt.to_time;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder cmtid(Long l) {
            this.cmtid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
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

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder from_time(Integer num) {
            this.from_time = num;
            return this;
        }

        public Builder to_time(Integer num) {
            this.to_time = num;
            return this;
        }

        public RequestGetInitialItemCmt build() {
            return new RequestGetInitialItemCmt(this);
        }
    }
}
