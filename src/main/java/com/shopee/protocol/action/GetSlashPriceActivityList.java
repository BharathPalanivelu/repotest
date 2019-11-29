package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetSlashPriceActivityList extends Message {
    public static final Long DEFAULT_ACTIVITY_ID = 0L;
    public static final Long DEFAULT_LAST_ACTIVITY_ID = 0L;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long activity_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long last_activity_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;

    public GetSlashPriceActivityList(String str, String str2, Long l, Integer num, Long l2, Integer num2, Integer num3) {
        this.requestid = str;
        this.token = str2;
        this.activity_id = l;
        this.type = num;
        this.last_activity_id = l2;
        this.limit = num2;
        this.offset = num3;
    }

    private GetSlashPriceActivityList(Builder builder) {
        this(builder.requestid, builder.token, builder.activity_id, builder.type, builder.last_activity_id, builder.limit, builder.offset);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetSlashPriceActivityList)) {
            return false;
        }
        GetSlashPriceActivityList getSlashPriceActivityList = (GetSlashPriceActivityList) obj;
        if (!equals((Object) this.requestid, (Object) getSlashPriceActivityList.requestid) || !equals((Object) this.token, (Object) getSlashPriceActivityList.token) || !equals((Object) this.activity_id, (Object) getSlashPriceActivityList.activity_id) || !equals((Object) this.type, (Object) getSlashPriceActivityList.type) || !equals((Object) this.last_activity_id, (Object) getSlashPriceActivityList.last_activity_id) || !equals((Object) this.limit, (Object) getSlashPriceActivityList.limit) || !equals((Object) this.offset, (Object) getSlashPriceActivityList.offset)) {
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
        Long l = this.activity_id;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.type;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.last_activity_id;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.offset;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetSlashPriceActivityList> {
        public Long activity_id;
        public Long last_activity_id;
        public Integer limit;
        public Integer offset;
        public String requestid;
        public String token;
        public Integer type;

        public Builder() {
        }

        public Builder(GetSlashPriceActivityList getSlashPriceActivityList) {
            super(getSlashPriceActivityList);
            if (getSlashPriceActivityList != null) {
                this.requestid = getSlashPriceActivityList.requestid;
                this.token = getSlashPriceActivityList.token;
                this.activity_id = getSlashPriceActivityList.activity_id;
                this.type = getSlashPriceActivityList.type;
                this.last_activity_id = getSlashPriceActivityList.last_activity_id;
                this.limit = getSlashPriceActivityList.limit;
                this.offset = getSlashPriceActivityList.offset;
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

        public Builder activity_id(Long l) {
            this.activity_id = l;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder last_activity_id(Long l) {
            this.last_activity_id = l;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public GetSlashPriceActivityList build() {
            return new GetSlashPriceActivityList(this);
        }
    }
}
